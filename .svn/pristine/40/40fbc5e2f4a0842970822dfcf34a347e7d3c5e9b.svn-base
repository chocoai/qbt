var order_pay_view = Vue.extend({
    template: '#order-pay',
    data : function(){
        return{
            order_detail : {},
            showCoupon : false,
            coupon_count : 0,
            paylock : false,
            activity : false, //满减活动
            activity_amt : 0,  //满减金额
            remark : '',
            lang : '',
            langs : [],
            pay_order : ''
        }
    },
    vuex :{
        getters :{
            coupon_use : function(state){ return state.coupon_use}
        }
    },
    watch : {
        'pay_order' : function(val){
            if(val){
                this.getDetail();
            }
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getDetail : function(){
            this.order_detail = {};
            var self = this;
            $.commonAjax({
                url : '/order/info.api',
                data : {
                    orderId : this.pay_order
                },
                success : function(data){
                    var order_detail = data.datas;
                    //语言类型 是否代下单
                    if(order_detail.partnerOrder == true){
                        self.langs = order_detail.partnerLangs;
                        if(order_detail.partnerLangs.length>0){
                            self.lang = order_detail.partnerLangs[0].split(':')[0];
                        }
                        //回机构代下单
                        $.ls('from','organization.html');
                    }
                    //查满减
                    $.commonAjax({
                        url : '/activity/check_order.api',
                        data : {
                            orderId : self.pay_order
                        },
                        success : function(data){
                            order_detail.activity = data.datas;
                            //有满减
                            if(data.datas.jActivity || data.datas.dActivity){
                                self.activity = true;
                                self.activity_amt = data.datas.jAmount || data.datas.dAmount;
                            }else{
                                self.activity = false;
                                self.activity_amt = 0;
                            }
                            self.order_detail = order_detail;
                        },
                        error : function(err){
                            order_detail.activity = {};
                            self.activity = false;
                            self.activity_amt = 0;
                            self.order_detail = order_detail;
                        }
                    });
                },
                error : function(err){
                    $.toast('订单查询失败');
                }
            });
            $.commonAjax({
                url : '/myCoupon/valid_count.api',
                success : function(data){
                    self.coupon_count = data.datas;
                }
            });
        },
        pay : function(){
            if(this.paylock) return;
            var self = this;
            this.paylock = true;
            var payAmount = 0;
            if(this.activity){
                payAmount = this.order_detail.totalAmount - this.activity_amt;
            }else{
                payAmount = this.order_detail.totalAmount - (this.coupon_use.realAmt || 0);
            }
            //金额为0
            if(payAmount == 0 || this.order_detail.partnerOrder == true){
                $.commonAjax({
                    url : '/pay/nopay_order.api',
                    type : 'post',
                    data : {
                        orderId : this.order_detail.number,
                        chidCode : this.coupon_use.childCode || '',
                        type : this.coupon_use.type || 0,
                        payAmount : payAmount,
                        activityId : this.order_detail.activity.activityId || 0,
                        remark : this.remark,
                        langName : this.lang
                    },
                    success : function(data){
                        $.alert('支付成功',function(){
                            setStore('order_refresh',new Date().getTime());
                            self.goBack();
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
                        orderId : this.order_detail.number,
                        chidCode : this.coupon_use.childCode || '',
                        type : this.coupon_use.type || 0,
                        payAmount : payAmount,
                        activityId : this.order_detail.activity.activityId || 0,
                        remark : this.remark
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
                                    setStore('order_refresh',new Date().getTime());
                                    self.goBack();
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
        goCoupon : function(){
            $.ls('usecoupon',this.order_detail.freight);
            setStore('coupon_refresh',new Date().getTime());
            this.goView('/coupon');
        },
        goBack : function(){
            var from = $.ls('from');
            if(from){
                $.ls('from','');
                location.replace(from);
            }
            setStore('coupon_use',{});
            // this.goView('/list');
            this.$route.router.replace('/list');
        },
        showCouponInput : function(){
            $('#coupon_input').val('');
            this.showCoupon = true;
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
                    amount : this.order_detail.freight
                },
                success : function(data){
                    var amt = 0;
                    if(self.order_detail.freight <  data.datas){
                        amt = self.order_detail.freight;
                    }else{
                        amt = data.datas;
                    }
                    var item = {
                        childCode : self.coupon_input,
                        chlidAmount : data.datas,
                        realAmt : amt,
                        type : 1
                    };
                    setStore('coupon_use',item);
                    self.coupon_input = "";
                    self.showCoupon = false;
                },
                error : function(err){
                    self.showCoupon = false;
                    $.toast(err);
                }
            });
        },
        cleanCoupon : function(){
            setStore('coupon_use',{});
        },
        activityDetail : function(id){
            setStore('activity_id',id);
            this.goView('/activity');
        }
    },
    route : {
        data : function(transition){
            var id = transition.to.params.id;
            this.pay_order = id;
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
    }
});
