var voucher_buy_view = Vue.extend({
    template: '#voucher_buy',
    data: function() {
        return {
            securityCode: false, //获取验证码
            show: true, //显示验证码
            count: '', //倒计时
            timer: null, //计时器
            voucherCount: 1, //券包数量
            orderTotal: 0, //订单总额
            voucherProperty: true, //显示券包属性
            voucherList: [], //券包种类
            address: true, //显示地址
            voucher_type: 1 //券包颜色
        }
    },
    methods: {
        //返回上一个组件
        getBack: function() {
            router.go(-1);
        },
        //获取验证码
        getSecurityCode: function() {
            this.securityCode = true;
            const TIME_COUNT = 60;
            if (!this.timer) {
                this.count = TIME_COUNT;
                this.show = false;
                var that = this;
                this.timer = setInterval(function() {
                    if (that.count > 0 && that.count <= TIME_COUNT) {
                        that.count--;
                    } else {
                        that.show = true;
                        clearInterval(that.timer);
                        that.timer = null;
                    }
                }, 1000);
            }
        },
        //获取球包
        getBallBagPhoto: function() {
            router.push('/send/ball_bag_photo');
        },
        //增加券包数量
        increaseVoucherCount: function() {
            this.voucherCount++;
            this.orderTotal = this.voucherCount * 300;
        },
        //减少券包数量
        decreaseVoucherCount: function() {
            if (this.voucherCount > 1) {
                this.voucherCount--;
                this.orderTotal = this.voucherCount * 300;
            }
        },
        //球包通券包协议
        getVoucherAgreement: function() {
            router.push('/send/voucher_agreement');
        },
        //礼包支付
        voucherPay: function() {
            if(!$('.weui-check').prop('checked')) return $.toast('阅读并同意券包协议后方可购买');
        },
        //获取电子券
        getElectricVoucher: function() {
            $('.elec').attr('src','/img/icon1_v3.png');
            $('.paper').attr('src','/img/icon_v3.png');
        },
        //获取纸质券
        getPaperVoucher: function() {
            $('.elec').attr('src','/img/icon_v3.png');
            $('.paper').attr('src','/img/icon1_v3.png');
        },
        //选择购买哪种券包
        chooseVoucher: function(num) {
            this.voucher_type = num;
        },
        //券包激活
        isActivate: function() {

        }
    }
});