/**
 * Created by Administrator on 2017/8/9.
 */
(function ($) {
  if(!$.weixinAuth()){
    return;
  };
  Vue.filter('currency',function(value, _currency, decimals) {
    value = parseFloat(value);
    if (!isFinite(value) || !value && value !== 0) return '';
    _currency = _currency != null ? _currency : '$';
    decimals = decimals != null ? decimals : 2;
    var stringified = Math.abs(value).toFixed(decimals);
    var _int = decimals ? stringified.slice(0, -1 - decimals) : stringified;
    var i = _int.length % 3;
    var head = i > 0 ? _int.slice(0, i) + (_int.length > 3 ? ',' : '') : '';
    var _float = decimals ? stringified.slice(-1 - decimals) : '';
    var sign = value < 0 ? '-' : '';
    return sign + _currency + head + _int.slice(i).replace(/(\d{3})(?=\d)/g, '$1,') + _float;
  });

  var store = new Vuex.Store({
    state :{
      geo_lat : '',//纬度
      geo_long : '',//经度
      isJ : true, //寄 ？ 收
      route_ident : '', //路由标识
      isHelp : '', // 代下单 ? 自下单
      //寄件信息
      send_addr : {
        type : 1, //寄件地址类型 1地址 2球场 3站点
        name : '',
        mobile : '',
        address : '',
        real_address : '',
        treePath: '',
        areaId : '',
        addr_type : '', //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
        addr_id : '',
        remark : '',
        tabStyle : 1, //记录寄件信息的选择地址类型 1-常用地址 2-球场 3-机场
        treeId : '',
        siteName : '',
        label_type:3,//常用地址类别 1-家 2-公司 3-其他
        isOutRange : false //是否偏远地址
      },
      //收件信息
      collect_addr : {
        type : 2, //收件地址类型 1地址 2球场 3站点
        name : '',
        mobile : '',
        address : '',
        real_address : '',
        treePath: '',
        areaId : '',
        addr_type : '', //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
        addr_id : '',
        remark : '',
        tabStyle : 1, //记录收件信息的选择地址类型 1-常用地址 2-球场 3-机场
        treeId : '',
        siteName : '',
        label_type:3,//常用地址类别 1-家 2-公司 3-其他
        isOutRange : false //是否偏远地址
      },
      addrMsg:{},//获取选择的地址信息
      addr:{},//新增修改地址信息
      tab:1,//选择的地址类型 1-常用地址 2-球场 3-机场
      label_type:3,//常用地址类别 1-家 2-公司 3-其他
      tabStyle:1,
      isAddr:true, //[true address] [false address course airport]
      orderStatus : 0, //0-全部 1-待支付 2-运输中 3-已签收 4-待取件
      orderDetail : 2, //订单详情页的展示类型 0-不显示切换头默认展示订单详情内容 1-订单详情 2-球包位置
      agentId : '', // 客户编号
      proxyId : '' // 客户编号
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

  @@include('v3/wechat-user.js')
  @@include('v3/agent_send.js')
  @@include('v3/agent_address.js')
  @@include('v3/agent_addrs.js')
  @@include('v3/agent_edita.js')
  @@include('v3/agent_pay.js')
  @@include('v3/agent_agreement.js')
  @@include('v3/agent_success.js')

  Vue.component("tab", vuxTab)
  Vue.component("tab-item", vuxTabItem)
  Vue.component("popup-picker", vuxPopupPicker)
  Vue.component("popup", vuxPopup)
  Vue.component("load-more", vuxLoadMore)
  Vue.component("scroller", vuxScroller)
  Vue.component("timeline", vuxTimeline)
  Vue.component("confirm", vuxConfirm)
  Vue.component("datetime", vuxDatetime)

  var router = new VueRouter({
    routes: [
      {path : '/' ,component : wechat_user_view ,meta : '球包通'},
      {path : '/agent_send' ,component : agent_send_view},
      {path : '/agent_address' ,component : agent_address_view},
      {path : '/agent_address/addrs' ,component : agent_address_addrs_view},
      {path : '/agent_address/addrs/edita' ,component : agent_address_addrs_edit_view},
      {path : '/agent_pay/:id' ,component : agent_pay_view},
      {path : '/agent_success/:arrivetime/:orderId' ,component : agent_success_view},
      {path : '/agreement' ,component : qbt_agreement_view},
      {path : '/care' ,component : qbt_care_view}
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