var track_list_view = Vue.extend({
    template: '#track-list',
    data : function(){
        return{
            query : '',
            orderList : []
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        search : function(){
            var self = this;
            $.commonAjax({
                url : '/order/track_order.api',
                data :{
                    keyword : this.query
                },
                success : function(data){
                    self.orderList = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        detail : function(item){
            setStore('order_detail',item);
            this.goView('/detail');
        }
    },
    ready : function(){
        this.search();
    }
});
