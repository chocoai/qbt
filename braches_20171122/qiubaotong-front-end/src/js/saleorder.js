(function($){

if(!$.weixinAuth()){
   return;
};

var store = new Vuex.Store({
    state :{
        pay_order : '',
        order_refresh : 1, //订单列表刷新
        order_tab : 1, // 1-全部 2-未支付 3-待收件 4-已签收
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

@@include('include/sale-order-list.js')
@@include('include/sale-order-detail.js')
@@include('include/sale-order-sublist.js')

var app = Vue.extend({
    components: {
        'order_list_view' : order_list_view,
        'order_detail_view' : order_detail_view,
        'order_sublist_view' : order_sublist_view,
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/': {
        component: order_list_view
    },
    '/list': {
        component: order_list_view
    },
    '/sublist/:id': {
        component: order_sublist_view,
        name : 'sublist'
    },
    '/detail/:id': {
        component: order_detail_view,
        name : 'detail'
    },
    '*' : {
        component: order_list_view
    }
});
router.start(app, '#app');

}(Zepto))
