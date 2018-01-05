/**
 * Created by Administrator on 2017/10/11.
 */
(function ($) {
  if(!$.weixinAuth()){
    return;
  };
  var store = new Vuex.Store({
    state : {
      invoiceType : 1, // 1-电子 2-纸质
      personalType : 1, // 1-个人 2-公司
      orderCont : '', // 订单id列表
      totalAmount : 0, // 发票总金额
      email : '', // 邮箱信息
      invoiceTitle : '', // 发票抬头
      invoicePrice : '', // 发票金额
      route_ident : '', // 路由标识
      sendInvoice :{    //  收件信息
        invoiceName : '', // 姓名
        invoicePhone : '', // 电话
        invoiceAddr : '', // 地址
      },
      companyInvoice :{ // 公司信息
        taxNum : '', // 税号
        accountNum : '', // 账号
        invoiceBank : '', // 开户行
        invoicePhone : '', // 电话
        invoiceAddr : '', // 地址
      },
      addr:{}//新增修改地址信息
    },
    mutations : {
      SETVAL : function(state,value){
        state[value.key] = value.value;
      }
    }
  });

  function setStore(para,val){
    store.commit('SETVAL',{key : para,value : val});
  };

  @@include('v3/invoice_select.js');
  @@include('v3/invoice_content.js');
  @@include('v3/invoiceAddr_list.js');
  @@include('v3/invoiceAddr_comAdd.js');
  @@include('v3/invoiceAddr_perAdd.js');

  Vue.component("load-more", vuxLoadMore);
  Vue.component('confirm',vuxConfirm);
  Vue.component('icon',vuxIcon);
  Vue.component("swipeout", vuxSwipeout);
  Vue.component("swipeout-button", vuxSwipeoutButton);
  Vue.component("swipeout-item", vuxSwipeoutItem);

  var router = new VueRouter({
    routes: [
      {path : '/' ,component : invoice_addr_select_view ,meta : '球包通'},
      {path : '/invoice' ,component : invoice_content_view },
      {path : '/invoice/address' ,component : invoiceAddr_list_view },
      {path : '/invoice/address/perAddr' ,component : invoiceAddr_perAdd_view },
      {path : '/invoice/address/comAddr' ,component : invoiceAddr_comAdd_view },
    ]
  });

  router.beforeEach(function(to,from,next){
    typeof(to.meta) === 'string' && $.setTitle(to.meta);
    next();
  });

  router.afterEach(function(to,from){
    $("#_loading").hide();
  });

  var app = new Vue({
    data : {
      transitionName : 'fadeInLeft'
    },
    watch : {
      "$route" : function(to,from){
        var toDepth = to.path.split('/').length;
        var fromDepth = from.path.split('/').length;
        this.transitionName = toDepth < fromDepth ? 'fadeOutRight' : 'fadeInLeft';
      }
    },
    router : router,
    store : store

  }).$mount('#app');

}(Zepto));