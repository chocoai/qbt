(function($){

if(!$.weixinAuth()){
   return;
};

var store = new Vuex.Store({
    state :{
        addr_refresh : 1, //地址列表刷新
        addr_edit : {},
        cityName : ''
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

@@include('include/address-list.js')
@@include('include/address-new.js')
@@include('include/address-city.js')

var app = Vue.extend({
    components: {
        'address_list_view' : address_list_view,
        'address_new_view' : address_new_view,
        'address_city_view' : address_city_view
    },
    store : store
});


var router = new VueRouter();
router.map({
    '/': {
        component: address_list_view
    },
    '/new': {
        component: address_new_view
    },
    '/city': {
        component: address_city_view
    },
    '*' : {
        component: address_list_view
    }
});
router.start(app, '#app');

}(Zepto))
