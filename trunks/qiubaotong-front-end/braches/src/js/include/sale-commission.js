var sale_commission_view = Vue.extend({
    template: '#sale-commission',
    data : function(){
        return{
            detail : {}
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        getDetail : function(){
            var _this = this;
            $.commonAjax({
                url : '/saleUser/info.api',
                success : function(data){
                    _this.detail = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    ready : function(){
        this.getDetail();
    }
});
