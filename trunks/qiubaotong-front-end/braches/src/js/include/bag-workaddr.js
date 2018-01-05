var bag_workaddr_view = Vue.extend({
    template: '#bag-workaddr',
    data : function(){
        return{
            isOther : false,
        }
    },
    vuex :{
        getters : {
            salesmanStatus : function(state){ return state.salesmanStatus;}
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        goApply : function(type){
            setStore('applyType',type);
            setStore('applyId','');
            setStore('applyName','');
            this.goView('bag_apply_view');
        },
        applySale : function(){
            this.goView('sale_apply_view');
        }
    },
    ready : function(){

    }
});
