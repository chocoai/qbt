var vip_update_view = Vue.extend({
    template: '#vip-update',
    data : function(){
        return {
            vip : {},
            mobile : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getInfo : function(id){
            this.mobile = '';
            var self = this;
            $.commonAjax({
                url : '/vipUser/detail.api',
                data :{
                    id : id
                },
                success : function(data){
                    self.vip = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        save : function(){
            if(!this.mobile || !$.comReg.isMobile(this.mobile)){
                $.toast('请输入有效手机号'); return;
            }
            if(this.mobile == this.vip.mobile){
                $.toast('手机号未更改'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/vipUser/modify.api',
                type : 'post',
                data : {
                    id : this.vip.id,
                    mobile : this.mobile
                },
                success : function(){
                    $.alert('修改成功',function(){
                        history.back();
                    });
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    route :{
        data : function(transition){
            this.getInfo(transition.to.params.id);
        }
    }
});

var vip_updatename_view = Vue.extend({
    template: '#vip-updatename',
    data : function(){
        return {
            vip : {},
            userName : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getInfo : function(id){
            this.userName = '';
            var self = this;
            $.commonAjax({
                url : '/vipUser/detail.api',
                data :{
                    id : id
                },
                success : function(data){
                    self.vip = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        save : function(){
            if(!$.trim(this.userName)){
                $.toast('请输入会员用户名'); return;
            }
            if(!this.checkName(this.userName)){
                $.toast('请填写真实姓名'); return;
            }
            if(this.userName == this.vip.userName){
                $.toast('会员用户名未更改'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/vipUser/modify.api',
                type : 'post',
                data : {
                    id : this.vip.id,
                    userName : $.trim(this.userName)
                },
                success : function(){
                    $.alert('修改成功',function(){
                        history.back();
                    });
                },
                error : function(err){
                    $.toast(err);
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
    route :{
        data : function(transition){
            this.getInfo(transition.to.params.id);
        }
    }
});
