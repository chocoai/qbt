/**
 * Created by Administrator on 2017/10/12.
 */
(function ($) {
  if(!$.weixinAuth()){
    return;
  };
  var store = new Vuex.Store({
    state : {
      invoiceType : 1, // 1-电子 2-纸质
      personalType : 1, // 1-个人 2-公司
      orderIdList : '', // 订单id列表
      invoice_detail : {}
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
  @@include('v3/invoiceNote_list.js');
  @@include('v3/invoiceNote_person.js');
  @@include('v3/invoiceNote_company.js');
  @@include('v3/invoiceNote_detail.js');

  Vue.component("timeline", vuxTimeline);

  var router = new VueRouter({
    routes: [
      {path : '/' ,component : invoiceNote_list_view ,meta : '球包通' },
      {path : '/perCont' ,component : invoiceNote_person_view },
      {path : '/comCont' ,component : invoiceNote_company_view },
      {path : '/invoiceDetail' ,component : invoiceNote_detail_view }
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