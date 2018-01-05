/**
 * Created by Administrator on 2017/10/12.
 */
var invoiceNote_company_view = Vue.extend({
  template : '#invoiceNote_company',
  data : function () {
    return{
      orderAmount : [] // 包含订单数量
    }
  },
  computed : {
    invoice_detail : function () {
      return this.$store.state.invoice_detail;
    }
  },
  methods : {
    goView : function (view) {
      router.push(view)
    },
    goDetail : function (obj) {
      setStore('personalType',2);
      setStore('orderIdList',obj);
      this.goView('/invoiceDetail')
    }
  },
  activated : function () {
    var _self = this;
    _self.orderAmount= [];
    if(_self.invoice_detail.orderId.indexOf(',')!==-1){
      _self.orderAmount = _self.invoice_detail.orderId.split(',');
    }else{
      _self.orderAmount.push(_self.invoice_detail.orderId)
    }
  }
});