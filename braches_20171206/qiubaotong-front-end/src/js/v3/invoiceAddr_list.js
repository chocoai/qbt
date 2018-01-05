/**
 * Created by Administrator on 2017/10/12.
 */
var invoiceAddr_list_view = Vue.extend({
  template : '#invoiceAddr_list',
  data : function () {
    return{
      personalType : 2,
      prevRouteId : '',
      addr_list : []
    }
  },
  computed : {
    route_ident : function () {
      return this.$store.state.route_ident;
    },
  },
  methods : {
    goAddAddr : function (num) {
      if(num===1){
        setStore('personalType',1);
        setStore('addr',{});
        router.push('/invoice/address/perAddr')
      }else{
        setStore('personalType',2);
        setStore('addr',{});
        router.push('/invoice/address/comAddr')
      }
    },
    onButtonClick : function (item) {
      var _self = this;
      setStore('addr',item);
      _self.personalType===1 ? router.push('/invoice/address/perAddr') : router.push('/invoice/address/comAddr')
    },
    onButtonDelete : function (type) {
      var _self = this;
      $.confirm('是否确认删除',function () {
        $.commonAjax({
          url : '/bill/deleteBillAddress.api',
          type : 'get',
          data : {
            id : type
          },
          success : function (data) {
            _self.getAddress(_self.personalType)
          }
        })
      })

    },
    // 获取
    getAddress : function (type) {
      var _self = this;
      _self.addr_list = [];
      $.commonAjax({
        url : '/bill/findBillAddress.api',
        type : 'get',
        data : {
          orgType : type ? type :1
        },
        success : function (data) {
          if(data.datas.length > 0){
            _self.addr_list = data.datas;
          }
        }
      })
    },
    // 切换公司或者个人
    tabPerType : function (num) {
      var _self = this;
      _self.personalType = num;
      _self.getAddress(num)
    },
    // 跳转回发票填写内容界面
    goInvoice : function (item) {
      var _self = this;
      setStore('addr',item);
      if(_self.prevRouteID === '') return;
      router.push('/invoice')
    },
    // 返回键
    goBack : function () {
      var _self = this;
      if(_self.prevRouteID == '#invoice_content'){
        // setStore('personalType',_self.personalType);
        // setStore('invoiceType',_self.$store.state.invoiceType)
        setStore('addr',{});
        router.push('/invoice');
      }else{
        _self.goV2Nav('order.html','order-menu')
      }
    },
    goV2Nav : function(url,hach){
      var _url=location.href;
      _url=_url.replace(location.hash,'');
      var index = _url.indexOf('?');
      var hx="";
      hach && (hx=hach);
      if(index == -1){
        location.href = _url + '?_r=' + $.version;
      }else{
        location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1)+ '&orderstatus=3&isreplace=0' + '#' + hx;
      }
    }
  },
  activated : function () {
    var _self = this;
    if(_self.route_ident == '#invoice_content'){
      _self.prevRouteID = '#invoice_content';
      _self.personalType = _self.$store.state.personalType;
      _self.getAddress(_self.personalType);
    }else if(_self.route_ident == '#invoice_addrList_per'){
      // _self.prevRouteID = '#invoice_addrList_per';
      _self.personalType = 1;
      _self.getAddress(1);
    }else if(_self.route_ident == '#invoice_addrList_com'){
      // _self.prevRouteID = '#invoice_addrList_com';
      _self.personalType = 2;
      _self.getAddress(2);
    }else {
      _self.prevRouteID = '';
      _self.personalType = 1;
      _self.getAddress(1);
    }
    setStore('route_ident','#invoice_addrList')
  }
});