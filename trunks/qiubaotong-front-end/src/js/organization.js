(function($){

var store = new Vuex.Store({
    state :{
        order_type : ''
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
@@include('include/org-menu.js')
@@include('include/org-orderlist.js')
@@include('include/org-orderdetail.js')
@@include('include/org-sublist.js')

var app = Vue.extend({
    components: {
        'org_menu_view' : org_menu_view,
        'org_orderlist_view' : org_orderlist_view,
        'org_orderdetail_view' : org_orderdetail_view,
        'org_sublist_view' : org_sublist_view
    },
    store : store
});



var router = new VueRouter();
router.map({
    '/': {
        component: org_menu_view
    },
    '/list/:type': {
        component: org_orderlist_view,
        name : 'list'
    },
    '/sublist/:id': {
        component: org_sublist_view,
        name : 'sublist'
    },
    '/detail/:id': {
        component: org_orderdetail_view,
        name : 'detail'
    },
    '*' : {
        component: org_menu_view
    }
});
router.start(app, '#app');

}(Zepto))
