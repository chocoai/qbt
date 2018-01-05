(function($){

if(!$.weixinAuth()){
   return;
};

var app = new Vue({
    el: '#app',
    data: {
        code : '',
        mobile : '',
        msgcode : '',
        errmsg : '',
        smstoken : '',
        lock : false,
        locktime : 60

    },
    methods: {
        getCoupon : function(){
            if(!this.validate()) return;
            var self = this;
            $.commonAjax({
                url : '/myCoupon/getCouponCode.api',
                type : 'post',
                data : {
                    mobile : this.mobile,
                    smsCode : this.msgcode,
                    smsToken : this.smstoken,
                    code : this.code
                },
                success : function(data){
                    $.alert('领取成功',function(){
                        self.smstoken = '';
                        self.code = '';
                        locationTo('order.html#!/coupon');
                    });
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        getCode : function(){
            if(!this.mobile || !/1\d{10}/g.test(this.mobile)){
                this.errmsg = '请输入正确手机号';
                return false;
            }
            if(this.lock) return;
            var self = this;
            $.commonAjax({
                url : '/smsCommon/getSmsCode.api',
                data : {
                    mobile : this.mobile
                },
                success : function(data){
                    self.smstoken = data.datas;
                    self.lock = true;
                    self.locktime = 60;
                    var time = setInterval(function(){
                        self.locktime = self.locktime -1;
                        if(self.locktime == 0){
                            self.lock = false;
                            clearInterval(time);
                        }
                    },1000);
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        validate : function(){
            if(!this.code){
                this.errmsg = '请输入暗号';
                return false;
            }
            if(!this.mobile || !/1\d{10}/g.test(this.mobile)){
                this.errmsg = '请输入正确手机号';
                return false;
            }
            if(!this.smstoken){
                this.errmsg = '请获取验证码';
                return false;
            }
            if(!this.msgcode){
                this.errmsg = '请输入验证码';
                return false;
            }
            this.errmsg = '';
            return true;
        }
    },
    ready: function() {

    }
});

}(Zepto))
