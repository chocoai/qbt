var vip_apply_view = Vue.extend({
    template: '#vip-apply',
    data : function(){
        return {
            name : '',
            mobile : '',
            type : '',
            vipList : [],
            selected : {},
            paylock : false,
            assistantUser : false,
            isRead : true,
            isRead2 : true,
            fbaseUrl : ''
        }
    },
    vuex :{
        getters :{
            vip_img : function(state){ return state.vip_img},
            vip_img_id : function(state){ return state.vip_img_id}
        }
    },
    watch : {
        'type' : 'changeType'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        pay : function(){
            if(this.assistantUser){
                $.toast('合作机构不能参加会员卡购买，如需要使用会员卡资格，要先退出合作机构，如有疑问请联系客服');
                return;
            }
            if(!this.name){
                $.toast('请输入姓名'); return;
            }
            if(!/^[\u4E00-\u9FA5]+$/.test(this.name)){
                $.toast('请填写中文姓名'); return;
            }
            if(!this.checkName(this.name)){
                $.toast('请填写真实姓名'); return;
            }
            if(!this.mobile || !$.comReg.isMobile(this.mobile)){
                $.toast('请输入有效手机号'); return;
            }
            // if(!this.vip_img_id){
            //     $.toast('请指定球包'); return;
            // }
            if(!this.type){
                $.toast('请选择会员卡类型'); return;
            }
            if(!this.isRead || !this.isRead2){
                $.toast('请阅读会员卡协议'); return;
            }
            if(this.paylock) return;
            this.paylock = true;
            var self = this;
            $.commonAjax({
                url : '/vipPay/vipOrder.api',
                type : 'post',
                data : {
                    mobile : this.mobile,
                    price : this.selected.amount,
                    user_name : $.trim(this.name),
                    vipTypeId : this.selected.id,
                    userImgId : this.vip_img_id
                },
                success : function(data){
                    wx.chooseWXPay({
                        timestamp: data.datas.timeStamp,
                        nonceStr: data.datas.nonceStr,
                        package: data.datas.package,
                        signType: data.datas.signType,
                        paySign: data.datas.paySign,
                        success: function (res) {
                            $.alert('购买成功',function(){
                                replaceTo('order.html');
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
        },
        changeType : function(newVal){
            var self = this;
            this.vipList.forEach(function(item){
                if(newVal == item.id){
                    item.rules = item.rules.replace(/\n/g,'<br/>');
                    self.selected = item;
                }
            });
        },
        checkName : function(name){
            name = $.trim(name);
            if(name.length == 1 || name.indexOf('先生')>0 || name.indexOf('女士')>0){
                return false;
            }
            return true;
        }
    },
    ready : function(){
        this.fbaseUrl = $.fbaseUrl;
        var self = this;
        /*
        $.webService.getUserInfo().then(function(data){
            var isVip = data.datas.vip || data.datas.vipUser.status == 2 ? true : false;
            if(!isVip){
                self.name = data.datas.name;
                self.mobile = data.datas.mobile;
                self.assistantUser = data.datas.assistantUser;
                $('#vip').css('display','block');
            }else{
                self.$route.router.replace('/info');
            }

        });
        */
        $.webService.getJsConfig().then(function(data){
            wx.config({
                // debug : true,
                appId: $.appId,
                timestamp: data.datas.timestamp,
                nonceStr: data.datas.nonceStr,
                signature: data.datas.signature,
                jsApiList: ['chooseWXPay']
            });
        });
        $.webService.getVipList({status : 1}).then(function(data){
            self.vipList = data.datas;
            if(data.datas.length>0){
                self.type = data.datas[0].id;
            }
        });
    }
});
