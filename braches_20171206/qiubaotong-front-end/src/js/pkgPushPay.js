(function ($) {

    if (!$.weixinAuth()) {
        return;
    }
    ;

    var app = new Vue({
        el: '#app',
        data: {
            orderInfo: {},
            paylock: false
        },
        methods: {
            goPay: function () {

                var self = this;
                if (self.paylock) return;
                self.paylock = true;
                $.commonAjax({
                    url: '/ticketPackagePay/pay.api',
                    type: 'post',
                    data: {
                        orderId: self.orderInfo.id,
                        payAmount: self.orderInfo.payAmount,
                        activityAmount: self.orderInfo.activityAmount,
                        activityName: self.orderInfo.activityName
                    },
                    success: function (data) {
                        $.alert(JSON.stringify(data));
                        wx.chooseWXPay({
                            timestamp: data.datas.timeStamp,
                            nonceStr: data.datas.nonceStr,
                            package: data.datas.package,
                            signType: data.datas.signType,
                            paySign: data.datas.paySign,
                            success: function (res) {
                                //var hach='/success/'+self.order_detail.sendTimeSection+'/'+self.order_detail.orderId;
                                //self.goV2Nav('index.html',hach);

                                //todo 跳转到我的券包
                                //$.alert(JSON.stringify("支付成功"));
                            },
                            fail: function (err) {
                                $.alert(JSON.stringify(err));
                            }
                        });
                        self.paylock = false;
                    },
                    error: function (err) {
                        self.paylock = false;
                        $.toast(err);
                    }
                });
            }

        },
        ready: function () {

        },
        created: function () {
            var self = this;
            //获取待支付订单详情
            var id = $.getQueryString("id");
            if (!id) {
                return;
            }
            $.webService.getJsConfig().then(function (data) {
                wx.config({
                    //debug: true,
                    appId: $.appId,
                    timestamp: data.datas.timestamp,
                    nonceStr: data.datas.nonceStr,
                    signature: data.datas.signature,
                    jsApiList: ['chooseWXPay']
                });
            });
            $.commonAjax({
                url: '/ticketPackageOrder/detail.api?id=' + id,
                type: 'post',
                data: {},
                success: function (data) {
                    self.orderInfo = data.datas;
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        }
    });

}(Zepto))
