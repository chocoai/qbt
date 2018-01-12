var voucher_buy_view = Vue.extend({
    template: '#voucher_buy',
    data: function() {
        return {
            securityCode: false, //是否显示验证码那一栏
            show: true, //显示验证码字
            count: '', //倒计时
            timer: null, //计时器
            activeColor : '#04be02', //激活图标背景颜色
            voucherCount: 1, //券包数量
            voucherType: 0, //券包类型  0-电子券 1-纸质券
            activityId: 999, //券包id
            activityName: '', //券包活动名称
            buyActive: 0, //电子券包是否激活 0-未激活 1-已激活(默认不激活)
            orderTotal: 0, //订单总额
            voucherProperty: false, //是否显示券包属性
            voucherPropertyList: [], //券包属性列表
            voucherPrice: 0, //券包价格
            voucherList: [], //券包活动种类
            address: false, //是否显示地址
            voucherBgc: 999, //券包背景颜色
            canGoPay: false, //短信验证通过后才能下单
        }
    },
    created: function() {
        this.getVoucherList();
        //微信支付配置
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
    },
    methods: {
        //返回上一个组件
        getBack: function() {
            router.go(-1);
        },
        //获取券包活动种类
        getVoucherList: function() {
            var self = this;
            $.commonAjax({
                url : '/myTicketPackage/packageActivityFindByPage.api',
                type : 'POST',
                data : {
                    status: '',
                    activityName: '',
                    ruleId: ''
                },
                success : function(data){
                    var datas = data.datas;
                    self.voucherList = datas;
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
        },
        //选取电子券
        getElectricVoucher: function() {
            $('.elec').attr('src','/img/icon1_v3.png');
            $('.paper').attr('src','/img/icon_v3.png');
            this.address = false;
        },
        //选取纸质券
        getPaperVoucher: function() {
            $('.elec').attr('src','/img/icon_v3.png');
            $('.paper').attr('src','/img/icon1_v3.png');
            this.address = true;
        },
        //券包是否激活
        isActivate: function() {
            this.buyActive = this.buyActive == 0 ? 1:0;
            this.activeColor = this.activeColor == '#04be02' ? '#ccc':'#04be02';
        },
        //选择购买哪种活动券包
        chooseVoucher: function(num) {
            this.voucherBgc = num;
            this.voucherProperty = true; //显示券包属性
            this.voucherPrice = this.voucherList[num].ticketPackageRule.payPrice; //券包单价
            this.orderTotal = this.voucherCount * this.voucherPrice; //支付金额
            this.activityId = this.voucherList[num].id; //券包id
            this.activityName = this.voucherList[num].activityName; //券包活动名称
        },
        //增加券包数量
        increaseVoucherCount: function() {
            this.voucherCount++;
            this.orderTotal = this.voucherCount * this.voucherPrice;
        },
        //减少券包数量
        decreaseVoucherCount: function() {
            if (this.voucherCount > 1) {
                this.voucherCount--;
                this.orderTotal = this.voucherCount * this.voucherPrice;
            }
        },
        //获取验证码
        getSecurityCode: function() {
            if(!$.comReg.isMobile($('.receivePhone').val().trim())) {
                $.toast('电话号码不正确');
                return;
            }
            var self = this;
            $.commonAjax({
                url : '/smsCommon/getSmsCode.api',
                data : {mobile:$('.receivePhone').val().trim()},
                success : function(data){
                    var smsToken = data.datas;
                    self.securityCode = true;
                    var TIME_COUNT = 59;
                    if (!self.timer) {
                        self.count = TIME_COUNT;
                        self.show = false;
                        var that = self;
                        self.timer = setInterval(function() {
                            if (that.count > 0 && that.count <= TIME_COUNT) {
                                that.count--;
                            } else {
                                that.show = true;
                                clearInterval(that.timer);
                                that.timer = null;
                            }
                        }, 1000);
                    }
                    //校验手机验证码 
                    $('.cellphoneCode').blur(function(){
                        $.commonAjax({
                            url : '/smsCommon/checkSmsCode.api',
                            type: 'POST',
                            data : {
                                mobile:$('.receivePhone').val().trim(),
                                smsCode:$('.cellphoneCode').val().trim(),
                                smsToken:smsToken
                            },
                            success : function(data){
                                $.toast('验证码输入正确！');
                                self.canGoPay = true;
                            },
                            error : function(){
                                $.toast('验证码输入有误');
                            }
                        });
                    });
                },
                error : function(){
                    $.toast('发送验证码失败');
                }
            });
        },
        //获取球包
        // getBallBagPhoto: function() {
        //     router.push('/send/ball_bag_photo');
        // },
        //球包通券包协议
        getVoucherAgreement: function() {
            router.push('/send/voucher_agreement');
        },
        //券包订单支付
        voucherPay: function() {
            var self = this;
            //创建订单
            if(this.orderTotal == 0) return $.toast('请选择券包类型');
            if(!$('.adminName').val()) return $.toast('姓名不能为空'); 
            if(!this.canGoPay) return $.toast('短息验证通过后才能下单哦！');
            if(!$('.weui-check').prop('checked')) return $.toast('阅读并同意券包协议后方可购买');
            $.commonAjax({
                url : '/ticketPackageOrder/add.api',
                type: 'POST',
                data : {
                    type: this.voucherType,
	                activityId: this.activityId,
	                activityAmount: this.voucherCount,
	                activityName:this.activityName,
	                purchaser:$('.adminName').val().trim(),
	                purchaserAddress: $('.address').val().trim(),
                    purchaserNumber:$('.receivePhone').val().trim(),
                    buyActive: this.buyActive
                },
                success : function(data){
                    var orderId = data.datas;
                    //$.toast('下单成功！');
                    //订单支付
                    $.commonAjax({
                        url: '/ticketPackagePay/pay.api',
                        type: 'post',
                        data: {
                            orderId: orderId,
                            payAmount: self.orderTotal,
                            activityAmount: self.voucherCount,
                            activityName: self.activityName
                        },
                        success: function (data) {
                            wx.chooseWXPay({
                                timestamp: data.datas.timeStamp,
                                nonceStr: data.datas.nonceStr,
                                package: data.datas.package,
                                signType: data.datas.signType,
                                paySign: data.datas.paySign,
                                success: function (res) {
                                    //跳转到个人中心我的券包
                                    self.canGoPay = false;
                                    $.toast("支付成功!");
                                    locationTo('order.html');
                                },
                                fail: function (err) {
                                    self.canGoPay = false;
                                    $.toast("支付失败!");
                                }
                            });
                        },
                        error: function (err) {
                            $.toast(err);
                        }
                    });
                },
                error : function(){
                    $.toast('下单失败！');
                }
            });
        }
    }
});