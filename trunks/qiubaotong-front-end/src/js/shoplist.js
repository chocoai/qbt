(function($){

if(!$.weixinAuth()){
   return;
};

var store = new Vuex.Store({
    state :{
        order_detail : {}
    },
    mutations : {
        SETVAL : function(state,para,val){
            state[para] = val;
        }
    }
});

function setStore(para,val){
    store.dispatch('SETVAL',para,val);
};

@@include('include/shoplist-list.js')
@@include('include/shoplist-detail.js')

var app = Vue.extend({
    components: {
        'shoplist_list_view' : shoplist_list_view,
        'shoplist_detail_view' : shoplist_detail_view
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/': {
        component: shoplist_list_view
    },
    '/detail': {
        component: shoplist_detail_view
    },
    '*' : {
        component: shoplist_list_view
    }
});
router.start(app, '#app');

}(Zepto))
