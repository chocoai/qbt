/**
 * Created by Administrator on 2017/10/12.
 */
var invoiceNote_detail_view = Vue.extend({
  template : '#invoiceNote_detail',
  data : function () {
    return{
      invoiceList : []
    }
  },
  computed : {
    personalType : function () {
      return this.$store.state.personalType;
    },
    orderIdList : function () {
      return this.$store.state.orderIdList;
    }
  },
  methods : {
    getInvoiceDetail : function (obj) {
      var _self = this;
      $.commonAjax({
        url : '/bill/findOrderByIds.api',
        type : 'get',
        data : {
          orderIds : obj
        },
        success : function (data) {
          _self.invoiceList = data.datas;
        }
      })
    }
  },
  activated : function () {
    var _self = this;
    _self.getInvoiceDetail(_self.orderIdList)
  }
});