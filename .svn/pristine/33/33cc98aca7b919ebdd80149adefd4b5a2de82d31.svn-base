(function($){

if(!$.weixinAuth()){
   return;
};

var store = new Vuex.Store({
    state :{
        pay_order : '',
        order_refresh : 1, //订单列表刷新
        addr_refresh : 1, //地址列表刷新
        coupon_refresh : 1, //地址列表刷新
        addr_edit : {},
        cityName : '',
        coupon_use : {},
        order_tab : 1, // 1-全部 2-未支付 3-待收件 4-已签收
        coupon_tab : 1,
        order_comment : '', //订单评价
        order_comment_detail : '', //订单评价详情
        activity_id : '' //活动id
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

@@include('include/order-menu.js')
@@include('include/order-list.js')
@@include('include/order-detail.js')
@@include('include/order-coupon.js')
// 我的代金券
@@include('include/order-voucher.js')
// 我的券包
@@include('include/order-voucherbag.js')
@@include('include/order-comment.js')
@@include('include/order-commentdetail.js')
@@include('include/order-activity.js')
@@include('include/order-sublist.js')
@@include('include/order-mpay.js')

var app = Vue.extend({
    components: {
        'order_view' : order_view,
        'order_list_view' : order_list_view,
        'order_detail_view' : order_detail_view,
        'order_coupon_view' : order_coupon_view,
        'order_voucher_view' : order_voucher_view,
        'order_voucherbag_view' : order_voucherbag_view,
        'order_comment_view' : order_comment_view,
        'order_commentdetail_view' : order_commentdetail_view,
        'order_activity_view' : order_activity_view,
        'order_sublist_view' : order_sublist_view,
        'order_mpay_view' : order_mpay_view
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/': {
        component: order_view
    },
    '/list': {
        component: order_list_view
    },
    '/sublist/:id': {
        component: order_sublist_view,
        name : 'sublist'
    },
    '/mpay/:id': {
        component: order_mpay_view,
        name : 'mpay'
    },
    '/detail/:id': {
        component: order_detail_view,
        name : 'detail'
    },
    '/coupon': {
        component: order_coupon_view
    },
    '/voucher': {
        component: order_voucher_view
    },
    '/voucherbag': {
        component: order_voucherbag_view
    },
    '/comment': {
        component: order_comment_view
    },
    '/commentdetail': {
        component: order_commentdetail_view
    },
    '/activity': {
        component: order_activity_view
    },
    '*' : {
        component: order_view
    }
});
router.start(app, '#app');

//手机上无效
// window.addEventListener('beforeunload',function(e){
//     e = e || window.event;
//     var t = "";
//     if(location.hash.indexOf('mpay')>0){
//         t = '您的球包订单未支付完成，确认要离开?';
//     }
//     if(t){
//         e && (e.returnValue = t);
//     }
// });
}(Zepto))
