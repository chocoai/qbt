var order_activity_view = Vue.extend({
    template: '#order-activity',
    data : function(){
        return{
            info : {}
        }
    },
    vuex :{
        getters :{
            activity_id : function(state){ return state.activity_id}
        }
    },
    watch : {
        'activity_id' : 'detail'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        detail : function(){
            var self = this;
            $.commonAjax({
                url : '/activity/detail.api',
                data : {
                    id : this.activity_id
                },
                success : function(data){
                    self.info = data.datas;
                    self.isList = false;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    ready : function(){
        this.detail();
    }
});
