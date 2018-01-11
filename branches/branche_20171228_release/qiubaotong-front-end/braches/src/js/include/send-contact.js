var send_contact_view = Vue.extend({
    template: '#send-contact',
    data : function(){
        return{
            name : '',
            mobile : '',
            user : false,
            user_name : '',
            user_mobile : ''
        }
    },
    vuex : {
        getters : {
            send_addr : function(state){return state.send_addr;},
            collect_addr : function(state){ return state.collect_addr;},
            isJ : function(state){ return state.isJ;}
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        save : function(){
            if(!this.name){
                $.toast('请输入姓名'); return;
            }
            if(!this.mobile || !$.comReg.isPhone(this.mobile)){
                $.toast('请输入有效联系电话'); return;
            }
            var self = this;
            //未填写个人信息
            if(this.user && !this.user_name && !this.user_mobile && $.comReg.isMobile(this.mobile)){
                layer.open({
                    content: '是否保存当前联系方式为您的个人信息?',
                    btn: ['确定', '取消'],
                    skin: 'footer',
                    shadeClose: false,
                    yes: function(index){
                        self.user = false;
                        $.webService.updateUserInfo({
                            name : self.name,
                            mobile : self.mobile
                        });
                        self.goIndex();
                        layer.close(index);
                    },
                    no : function(index){
                        self.user = false;
                        self.goIndex();
                    }
                });
            }else{
                self.goIndex();
            }

        },
        goIndex : function(){
            if(this.isJ){
                this.send_addr.name = this.name;
                this.send_addr.mobile = this.mobile;
            }else{
                this.collect_addr.name = this.name;
                this.collect_addr.mobile = this.mobile;
            }
            this.goView("/");
        }
    },
    ready : function(){
        var self = this;
        $.webService.getUserInfo().then(function(data){
            self.user = true;
            self.user_name = data.datas.name;
            self.user_mobile = data.datas.mobile;
        });
    }
});
