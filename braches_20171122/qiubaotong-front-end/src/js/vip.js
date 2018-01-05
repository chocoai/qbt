(function($){

if(!$.weixinAuth()){
   return;
};

var store = new Vuex.Store({
    state :{
        vip_img_id : '',
        vip_img : ''
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

@@include('include/vip-apply.js')
@@include('include/vip-info.js')
@@include('include/vip-detail.js')
@@include('include/vip-update.js')
@@include('include/vip-agreement.js')
@@include('include/vip-active.js')
@@include('include/vip-bag.js')
@@include('include/vip-mycert.js')
@@include('include/vip-pic.js')

var app = Vue.extend({
    components: {
        'vip_info_view' : vip_info_view,
        'vip_apply_view' : vip_apply_view,
        'vip_update_view' : vip_update_view,
        'vip_updatename_view' : vip_updatename_view,
        'vip_agreement_view' : vip_agreement_view,
        'vip_agreement2_view' : vip_agreement2_view,
        'vip_active_view' : vip_active_view,
        'vip_detail_view' : vip_detail_view,
        'vip_bag_view' : vip_bag_view,
        'vip_mycert_view' : vip_mycert_view,
        'vip_pic_view' : vip_pic_view
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/info': {
        component: vip_info_view
    },
    '/apply': {
        component: vip_apply_view
    },
    '/detail/:id': {
        component: vip_detail_view,
        name : 'detail'
    },
    '/update/:id': {
        component: vip_update_view,
        name : 'updatemobile'
    },
    '/updatename/:id': {
        component: vip_updatename_view,
        name : 'updatename'
    },
    '/agreement': {
        component: vip_agreement_view
    },
    '/agreement2': {
        component: vip_agreement2_view
    },
    '/active': {
        component: vip_active_view
    },
    '/bag': {
        component: vip_bag_view
    },
    '/mycert': {
        component: vip_mycert_view
    },
    '/pic': {
        component: vip_pic_view
    },
    '/updatepic/:id': {
        component: vip_pic_view,
        name : 'updatepic'
    },
    '*': {
        component: vip_apply_view
    }
});
router.start(app, '#app');

}(Zepto))
