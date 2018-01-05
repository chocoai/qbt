var bag_orderlist_view = Vue.extend({
    template: '#bag-orderlist',
    data : function(){
        return{
            searchText : '',
            orderList : [],
        }
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;},
            applyType : function(state){ return state.applyType;},
            applyName : function(state){ return state.applyName;},
            order_refresh : function(state){ return state.order_refresh;},
            order_type : function(state){ return state.order_type;}
        }
    },
    watch : {
        'order_refresh' : 'getList',
        'order_type' : 'getList'
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/assistant/order.api',
                data : {
                    applyId : this.applyId,
                    applyType : this.applyType,
                    type : this.order_type
                },
                success : function(data){
                    self.orderList = data.datas;
                },
                error : function(){
                    $.toast('订单查询失败');
                }
            });
        },
        detail : function(item){
            setStore('order_detail',item);
            this.goView('bag_orderdetail_view');
        }
    },
    ready : function(){
        this.getList();
    }
});
