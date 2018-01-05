var sale_apply_view = Vue.extend({
    template: '#sale-apply',
    data : function(){
        return{
            name : '',
            mobile : '',
            idcard : '',
            pics : [],
            pics_src : '',
            smsToken : '',
            smsCode : '',
            lock : false,
            locktime : 60,
            company : '',
            salesmanCode : '',
            readOnly : false
        }
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;}
        }
    },
    watch : {
        'salesmanCode' : function(newVal){
            if(newVal.length == 10){
                this.getCompany(newVal);
            }else{
                this.readOnly = false;
            }
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        goBack : function(){
            if(this.applyId){
                this.goView('bag_login_view');
            }else{
                this.goView('bag_workaddr_view');
            }
        },
        validate : function(){
            if(this.salesmanCode && this.salesmanCode.length !=10) return '请输入10位工作证号';
            if(!/^.{2,10}$/.test(this.name)) return '请输入2-10位姓名';
            if(!this.mobile || !/1\d{10}/g.test(this.mobile)) return '请输入正确手机号';
            if(!this.smsToken) return '请获取验证码';
            if(!this.smsCode) return '请输入验证码';
            // if(this.idcard && !/(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/g.test(this.idcard)) return '请输入有效身份证';
            return '';
        },
        apply : function(){
            var vald = this.validate();
            if(vald){
                $.toast(vald);
                return;
            }
            var self = this;
            $.commonAjax({
                url : '/saleUser/apply.api',
                type : 'post',
                data :{
                    company : this.company,
                    name : this.name,
                    mobile : this.mobile,
                    idcard : this.idcard,
                    smsToken : this.smsToken,
                    smsCode : this.smsCode,
                    idcardUrl : this.pics.length >0 ? this.pics[0] : '',
                    salesmanCode : this.salesmanCode
                },
                success : function(data){
                    self.goView('bag_applying_view');
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        getCode : function(){
            if(!this.mobile || !/1\d{10}/g.test(this.mobile)){
                $.toast('请输入正确手机号');
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
                    self.smsToken = data.datas;
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
        upload : function(){
            var self = this;
            wx.chooseImage({
                count: 1,
                sizeType: ['compressed'],
                sourceType: ['album', 'camera'],
                success: function (res) {
                    var localIds = res.localIds;
                    wx.uploadImage({
                        localId: localIds[0],
                        isShowProgressTips: 1,
                        success: function (res) {
                            var serverId = res.serverId;
                            self.pics_src = localIds[0];
                            self.pics[0] = serverId;
                        }
                    });
                }
            });
        },
        showPic : function(e){
            var url = e.target.src;
            var urls = [url];
            wx.previewImage({
                current: url,
                urls: urls
            });
        },
        getCompany : function(code){
            var _this = this;
            $.commonAjax({
                url : '/saleUser/codeCompany.api',
                data : {
                    salesmanCode : code
                },
                success : function(data){
                    if(data.datas){
                        _this.company = data.datas;
                        _this.readOnly = true;
                    }else{
                        _this.readOnly = false;
                    }
                }
            });
        }
    },
    ready : function(){
        // $.webService.getJsConfig().then(function(data){
        //     wx.config({
        //     //   debug: true,
        //       appId: $.appId,
        //       timestamp: data.datas.timestamp,
        //       nonceStr: data.datas.nonceStr,
        //       signature: data.datas.signature,
        //       jsApiList: ['chooseImage','uploadImage']
        //     });
        // });
    }
});
