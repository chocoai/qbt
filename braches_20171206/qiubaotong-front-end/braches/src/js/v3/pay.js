var pay_view = Vue.extend({
    template : '#payTpl',
    data : function(){
        return {
            order_detail : {},
            pay_order : '',
            paylock : false,
        }
    },
    methods : {
        goView : function(view){
            router.push(view);
        },
        goV2Nav : function(url,hach){
            var _url=location.href;
            _url=_url.replace(location.hash,'');
            var index = _url.indexOf('?');
            var hx="";
            hach && (hx=hach);
            if(index == -1){
                location.href = _url + '?_r=' + $.version;
            }else{
                location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1)+ '#' + hx;
            }
        },
        getDetail : function(){
            this.order_detail = {};
            var _this = this;
            $.commonAjax({
                url : '/order/v2/pay_info.api',
                data : {
                    orderId : this.pay_order
                },
                success : function(data){
                    _this.order_detail = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        pay : function(){
            var self = this;
            if(self.paylock) return;
            if(!self.order_detail.orderNumber) return;
            self.paylock = true;
            //金额为0
            if(self.order_detail.amount == 0){
                $.commonAjax({
                    url : '/pay/v2/nopay_order.api',
                    data : {
                        orderId : self.order_detail.orderNumber
                    },
                    success : function(data){
                        self.paylock = false;
                        self.goV2Nav('index.html','/success/'+self.order_detail.sendTimeSection+'/'+self.order_detail.orderId);
                    },
                    error : function(err){
                        self.paylock = false;
                        $.toast(err);
                    }
                });
            }else{
                $.commonAjax({
                    url : '/pay/v2/order.api',
                    data : {
                        orderId : self.order_detail.orderNumber
                    },
                    success : function(data){
                        wx.chooseWXPay({
                            timestamp: data.datas.timeStamp,
                            nonceStr: data.datas.nonceStr,
                            package: data.datas.package,
                            signType: data.datas.signType,
                            paySign: data.datas.paySign,
                            success: function (res) {
                                var hach='/success/'+self.order_detail.sendTimeSection+'/'+self.order_detail.orderId;
                                self.goV2Nav('index.html',hach);
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
    },
    activated : function(){
        this.pay_order = this.$route.params.id;
        this.getDetail();
        //设置路由标示
        setStore('route_ident',"#pay");
    },
    mounted : function(){
        $.webService.getJsConfig().then(function(data){
            wx.config({
                //debug: true,
                appId: $.appId,
                timestamp: data.datas.timestamp,
                nonceStr: data.datas.nonceStr,
                signature: data.datas.signature,
                jsApiList: ['chooseWXPay']
            });
        });
    }
});
