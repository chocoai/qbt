(function ($) {

    if (!$.weixinAuth()) {
        return;
    }
    var app = new Vue({
        el: '#app',
        data: {
            buyActive: 0, //电子券包是否激活 0-未激活 1-已激活(默认不激活)
            activeColor : '#04be02', //激活图标背景颜色
            canGoPay: false, //短信验证通过后才能接受
            show: true, //显示验证码字
        },
        methods: {
            //券包是否激活
            isActivate: function() {
                this.buyActive = this.buyActive == 0 ? 1:0;
                this.activeColor = this.activeColor == '#04be02' ? '#ccc':'#04be02';
            },

            add: function () {
                $.commonAjax({
                    url: '/myTicketPackage/qrcode.api',
                    type: 'post',
                    data: {
                        url:"http://localhost:8080/qbt/test.html?packageId=98&qrCode=431815ad70a69540ba1a1d26b1d629e3",
                        packageId:"98",
                        qrCode:"431815ad70a69540ba1a1d26b1d629e3"
                    },
                    success: function (data) {
                        
                    },
                    error: function (err) {
                        $.toast(err);
                    }
                });
            },


            //获取验证码
            getSecurityCode: function() {
                console.log(123);
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
            //拒绝券包
            reject: function(){
                console.log(123);
                $.commonAjax({
                    url: '/myTicketPackage/qrcode.api',
                    type: 'post',
                    data: {
                        url:"http://localhost:8080/qbt/test.html?packageId=98&qrCode=431815ad70a69540ba1a1d26b1d629e3",
                        packageId:"98",
                        qrCode:"431815ad70a69540ba1a1d26b1d629e3"
                    },
                    success: function (data) {
                        
                    },
                    error: function (err) {
                        $.toast(err);
                    }
                });
            },
            //接受券包
            receive: function(){
                console.log(123);
                if(!$('.adminName').val()) return $.toast('姓名不能为空'); 
                if(!this.canGoPay) return $.toast('短息验证通过后才能接受哦！');
                if(!$('.weui-check').prop('checked')) return $.toast('阅读并同意券包协议后方可接受');
                $.commonAjax({
                    url: '/myTicketPackage/recieve.api',
                    type: 'post',
                    data: {
                        urrecieveUserNamel:$('.adminName').val().trim(),
                        recieveUserMobile:$('.receivePhone').val().trim(),
                        packageId:"98",
                        qrCode:"123456",
                    },
                    success: function (data) {
                        
                    },
                    error: function (err) {
                        $.toast(err);
                    }
                });
            }
        }
    });

}(Zepto));
