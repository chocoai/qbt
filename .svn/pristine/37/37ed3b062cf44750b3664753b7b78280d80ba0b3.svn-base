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

@@include('include/track-list.js')
@@include('include/track-detail.js')

var app = Vue.extend({
    components: {
        'track_list_view' : track_list_view,
        'track_detail_view' : track_detail_view
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/': {
        component: track_list_view
    },
    '/detail': {
        component: track_detail_view
    },
    '*' : {
        component: track_list_view
    }
});
router.start(app, '#app');

}(Zepto))
