var bag_apply_view = Vue.extend({
    template: '#bag-apply',
    data : function(){
        return{
            name : '',
            mobile : '',
            idCode : '',
            pics : [],
            pics_src : {
                img0 : '',
                img1 : ''
            },
            smsToken : '',
            smsCode : '',
            addr_text : '',
            lock : false,
            locktime : 60,
            pics_src1 : ''
        }
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;},
            applyType : function(state){ return state.applyType;},
            applyName : function(state){ return state.applyName;}
        }
    },
    watch : {
        'applyType' : 'addrText'
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        addrText : function(){
            if(this.applyType == 1 || this.applyType == 2){
                this.addr_text = '工作球场';
            } else if(this.applyType == 4){
                this.addr_text = '顺丰站点';
            } else if(this.applyType == 5){
                this.addr_text = '机场站点';
            } else if(this.applyType == 3){
                this.addr_text = '银行网点';
            } else if(this.applyType == 8){
                this.addr_text = '合作机构';
            }
        },
        validate : function(){
            if(!this.name) return '请输入姓名';
            // if(!this.idCode || !/(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/g.test(this.idCode)) return '请输入有效身份证';
            if(!this.mobile || !/1\d{10}/g.test(this.mobile)) return '请输入正确手机号';
            if(!this.smsToken) return '请获取验证码';
            if(!this.smsCode) return '请输入验证码';
            if(!this.applyId) return '请选择工作场所';
            // if(this.pics.length !=2) return '请上传全证件照';
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
                url : '/assistant/apply.api',
                type : 'post',
                data :{
                    name : this.name,
                    mobile : this.mobile,
                    idCode : this.idCode,
                    applyType : this.applyType,
                    applyId : this.applyId,
                    applyName : this.applyName,
                    smsToken : this.smsToken,
                    smsCode : this.smsCode,
                    pics : this.pics
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
        upload : function(index){
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
                            self.pics_src['img'+index] = localIds[0];
                            self.pics[index] = serverId;
                        }
                    });
                }
            });
        }
    },
    ready : function(){
        this.addrText();
        // var self = this;
        // $.commonAjax({
        //     url : '/comm/weixin/jsConfig.api',
        //     data : {
        //         url : location.href
        //     },
        //     success : function(data){
        //         wx.config({
        //         //   debug: true,
        //           appId: $.appId,
        //           timestamp: data.datas.timestamp,
        //           nonceStr: data.datas.nonceStr,
        //           signature: data.datas.signature,
        //           jsApiList: ['chooseImage','uploadImage']
        //         });
        //     }
        // });
    }
});
