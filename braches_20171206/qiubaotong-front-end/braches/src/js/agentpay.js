(function($){

if(!$.weixinAuth()){
   return;
};

var app = new Vue({
    el: '#app',
    data : function(){
        return{
            coupon_use : {},
            order_detail : {},
            showCoupon : false,
            coupon_count : 0,
            paylock : false,
            activity : false, //满减活动
            activity_amt : 0,  //满减金额
            remark : '',
            lang : '',
            langs : [],
            pay_order : '',
            totalAmt : {},
            canPay : false,
            vipOrderIds : [], //vip订单
            vipIds : [], //vip订单对应会员卡
            uid : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getDetail : function(){
            this.order_detail = {};
            this.totalAmt = {};
            var self = this;
            $.webService.getPayInfo({
                orderId : this.pay_order
            }).then(function(data){
                self.order_detail = data.datas;
                if(self.order_detail.partnerOrder == true){
                    self.langs = self.order_detail.partnerLangs;
                    if(self.order_detail.partnerLangs && self.order_detail.partnerLangs.length>0){
                        self.lang = self.order_detail.partnerLangs[0].split(':')[0];
                    }
                    //回机构代下单
                    $.ls('from','organization.html');
                }
                //计算金额
                self.getTotalAmt();

                if(self.order_detail.invalidCount > 0){
                    $.alert('请注意已有'+self.order_detail.invalidCount+'个球包失效');
                }
                self.canPay = true;
            },function(err){
                self.canPay = false;
                $.toast(err);
            });
        },
        getTotalAmt : function(){
            var totalFee = 0; //保价
            var totalFreight = 0; //运费
            var totalDiscount = 0; //满减
            var couponFreight = 0; //可使用优惠券金额
            var totalCount = 0;
            var vipDiscount = 0;
            var vipOrderIds = [];
            var vipIds = [];
            this.order_detail.subOrders.forEach(function(item){
                var num = item.numbers.length;
                totalFee += item.insureFee * num;
                totalDiscount += (item.jAmount || item.dAmount) * num;
                //无满减 非VIP
                if(!item.jActivity && !item.dActivity && !item.vipOrder){
                    couponFreight += item.freight * num;
                }
                //会员
                if(item.vipOrder){
                    //VIP订单号
                    vipOrderIds = vipOrderIds.concat(item.numbers);
                    vipIds = vipIds.concat(item.vipIds);
                    //VIP优惠 运费 - 偏远 - VIP
                    var vipAmt = item.freight - item.outRangeAmount - item.vipOrderAmount;
                    vipDiscount += (vipAmt < 0 ? 0 : vipAmt) * num;
                    //VIP订单金额
                    totalFreight += (vipAmt< 0 ? (item.vipOrderAmount + item.outRangeAmount) : item.freight) * num;
                }else{
                    totalFreight += item.freight * num;
                }
                totalCount += num;
            });
            this.totalAmt = {
                totalFee : totalFee,
                totalFreight : totalFreight,
                totalDiscount : totalDiscount,
                totalAmount : totalFee + totalFreight - totalDiscount - vipDiscount, //保价 + 运费 - 优惠 - VIP
                couponFreight : couponFreight,
                totalCount : totalCount,
                vipDiscount : vipDiscount
            };
            //会员订单ID
            this.vipOrderIds = vipOrderIds;
            this.vipIds = vipIds;
        },
        pay : function(){
            if(this.paylock) return;
            if(!this.order_detail.orderNumber) return;
            var self = this;
            this.paylock = true;
            //保价 + 运费 - 满减 - 优惠券
            var payAmount = (this.totalAmt.totalAmount - (this.coupon_use.realAmt || 0)).toFixed(2);
            //子订单
            var orderIds = [];
            //活动
            var activityIds = [];
            this.order_detail.subOrders.forEach(function(item){
                for(var i =0; i< item.numbers.length; i++){
                    orderIds.push(item.numbers[i]);
                    activityIds.push(item.activityId);
                }
            });
            //金额为0
            if(payAmount == 0 || this.order_detail.partnerOrder == true){
                $.commonAjax({
                    url : '/pay/nopay_order.api',
                    type : 'post',
                    data : {
                        orderNumber : this.order_detail.orderNumber,
                        orderId : orderIds,
                        activityId : activityIds,
                        chidCode : this.coupon_use.childCode || '',
                        type : this.coupon_use.type || 0,
                        payAmount : payAmount,
                        remark : this.remark,
                        langName : this.lang,
                        vipOrderIds : this.vipOrderIds,
                        vipIds : this.vipIds
                    },
                    success : function(data){
                        $.alert('支付成功',function(){
                            self.isLeave(true);
                        });
                        self.paylock = false;
                    },
                    error : function(err){
                        self.paylock = false;
                        $.toast(err);
                    }
                });
            }else{
                $.commonAjax({
                    url : '/pay/order.api',
                    type : 'post',
                    data : {
                        orderNumber : this.order_detail.orderNumber,
                        orderId : orderIds,
                        activityId : activityIds,
                        chidCode : this.coupon_use.childCode || '',
                        type : this.coupon_use.type || 0,
                        payAmount : payAmount,
                        remark : this.remark,
                        vipOrderIds : this.vipOrderIds,
                        vipIds : this.vipIds
                    },
                    success : function(data){
                        wx.chooseWXPay({
                            timestamp: data.datas.timeStamp,
                            nonceStr: data.datas.nonceStr,
                            package: data.datas.package,
                            signType: data.datas.signType,
                            paySign: data.datas.paySign,
                            success: function (res) {
                                $.alert('支付成功',function(){
                                    self.isLeave(true);
                                });
                            },
                            fail: function(err){
                                $.alert(JSON.stringify(err));
                            }
                        });
                        self.paylock = false;
                    },
                    error : function(err){
                        self.paylock = false;
                        $.toast(err);
                    }
                });
            }
        },
        goBack : function(){
            $('#pay_confirm').css('display','block');
        },
        isLeave : function(leave){
            if(leave){
                history.back();
            }else{
                $('#pay_confirm').hide();
            }
        },
        showCouponInput : function(){
            $('#coupon_input').val('');
            $('#showCoupon').css('display','block');
        },
        checkCoupon : function(){
            if($('#coupon_input').val().length<8){
                return;
            }
            this.coupon_input = $('#coupon_input').val();
            var self = this;
            $.commonAjax({
                url : '/myCoupon/valid_coupon.api',
                type : 'post',
                data :{
                    child_code : this.coupon_input,
                    amount : this.totalAmt.couponFreight
                },
                success : function(data){
                    var amt = 0;
                    if(self.totalAmt.couponFreight <  data.datas){
                        amt = self.totalAmt.couponFreight;
                    }else{
                        amt = data.datas;
                    }
                    var item = {
                        childCode : self.coupon_input,
                        chlidAmount : data.datas,
                        realAmt : amt,
                        type : 1
                    };
                    self.coupon_use = item;
                    self.coupon_input = "";
                    $('#showCoupon').css('display','none');
                },
                error : function(err){
                    $('#showCoupon').css('display','none');
                    $.toast(err);
                }
            });
        },
        cleanCoupon : function(){
            this.coupon_use = {};
        }
    },
    ready : function(){
        $.webService.getJsConfig().then(function(data){
            wx.config({
                // debug: true,
                appId: $.appId,
                timestamp: data.datas.timestamp,
                nonceStr: data.datas.nonceStr,
                signature: data.datas.signature,
                jsApiList: ['chooseWXPay']
            });
        });
        this.pay_order = $.getQueryString('id');
        this.getDetail();
        this.uid = $.getQueryString('aid');
    }
});

}(Zepto))
