var shoplist_detail_view = Vue.extend({
    template: '#shoplist-detail',
    data : function(){
        return {}
    },
    vuex : {
        getters : {
            detail : function(state){ return state.order_detail}
        }
    },
    computed :{
        total : function(){
            var num = this.detail.quantity;
            return this.detail.insuredFee * num + this.detail.freight * num;
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        }
    }
});
