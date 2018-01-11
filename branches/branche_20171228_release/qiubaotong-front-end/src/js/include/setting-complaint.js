var setting_compiaint_view = Vue.extend({
    template: '#setting_compiaint_view',
    data : function(){
        return {
            mobile : '',
            content : ''
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        add : function(){
            if(!this.mobile || !/1\d{10}/.test(this.mobile)){
                $.toast('请填写有效手机号'); return;
            }
            if(!this.content || !$.trim(this.content)){
                $.toast('请填写您的建议'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/feedback/submit.api',
                type : 'post',
                data : {
                    mobile : this.mobile,
                    content : $.trim(this.content)
                },
                success : function(data){
                    $.alert('感谢您的建议',function(){
                        self.content = '';
                    });
                }
            });
        }
    },
    ready : function(){
        var self = this;
        $.commonAjax({
            url : '/user/query_user_info.api',
            success : function(data){
                self.mobile = data.datas.mobile;
            }
        });
    }
});
