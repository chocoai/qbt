var bag_login_view = Vue.extend({
    template: '#bag-login',
    data : function(){
        return{

        }
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;},
            applyType : function(state){ return state.applyType;},
            applyName : function(state){ return state.applyName;},
            salesmanStatus : function(state){ return state.salesmanStatus;}
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        goList : function(type){
            setStore('order_type',type);
            this.goView('bag_orderlist_view')
        }
    },
    ready : function(){

    }
});
