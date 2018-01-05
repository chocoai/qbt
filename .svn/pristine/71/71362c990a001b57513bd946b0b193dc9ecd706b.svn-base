var vip_active_view = Vue.extend({
    template: '#vip-active',
    data : function(){
        return {
            vipNo : '',
            random : '',
            userName : '',
            mobile : '',
            errorMsg: ''
        }
    },
    methods : {
        active : function(){
            if(!$.trim(this.vipNo)){
                $.toast('请输入有效卡号'); return;
            }
            if(!$.trim(this.random)){
                $.toast('请输入有效验证码'); return;
            }
            if(!$.trim(this.userName)){
                $.toast('请输入姓名'); return;
            }
            if(!$.trim(this.mobile) || !$.comReg.isPhone($.trim(this.mobile))){
                $.toast('请输入有效联系电话'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/vipUser/activate.api',
                type : 'post',
                data : {
                    vipNo : $.trim(this.vipNo),
                    random : $.trim(this.random),
                    userName : $.trim(this.userName),
                    mobile : $.trim(this.mobile)
                },
                success : function(data){
                    $.alert('欢迎新会员！您的会员卡已激活成功！',function(){
                        replaceTo('vip.html?_r=' + $.version + '#!/info');
                    });
                },
                error : function(err){
                    self.errorMsg = err;
                    $('#errorActive').css('display','block');
                }
            });
        },
        closeConfirm : function(){
            $('#errorActive').hide();
        }
    }
});
