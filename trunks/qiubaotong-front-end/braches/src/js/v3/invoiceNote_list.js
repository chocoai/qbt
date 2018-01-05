/**
 * Created by Administrator on 2017/10/12.
 */
var invoiceNote_list_view = Vue.extend({
  template : '#invoiceNote_list',
  data : function () {
    return{
      invoiceList : []
    }
  },
  computed : {

  },
  methods : {
    goView : function (view) {
      router.push(view)
    },
    goNext : function (num, item) {
      var _self = this;
      num === 1 ? _self.goView('/perCont') : _self.goView('/comCont')
      setStore('invoice_detail', item)
    },
    getInvoiceNote : function () {
      var _self = this;
      $.commonAjax({
        url : '/bill/findBill.api',
        type : 'get',
        data : {},
        success : function (data) {
          if(data.datas.length>0){
            _self.invoiceList = data.datas;
          }
        }
      })
    }
  },
  activated : function () {
    var _self = this;
    _self.getInvoiceNote()
  }
});