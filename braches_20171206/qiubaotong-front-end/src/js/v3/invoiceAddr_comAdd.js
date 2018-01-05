/**
 * Created by Administrator on 2017/10/12.
 */
var invoiceAddr_comAdd_view = Vue.extend({
  template : '#invoiceAddr_comAdd',
  data : function () {
    return{
      invoiceType : 1,
      perName : '',
      perTel : '',
      perAddr : '',
      taxNum : '',
      comNum : '',
      comBank : '',
      comTel : '',
      comAddr : '',
      perEmail : '',
      inName : ''
    }
  },
  computed : {
    addr : function(){return this.$store.state.addr}
  },
  methods : {
    goBack : function () {
      router.push('/invoice/address')
    },
    tabType : function (num) {
      var _self = this;
      _self.invoiceType = num;
      _self.addr.billType = num;
    },
    save : function () {
      var _self = this;
      var _regRule = /\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g;
      if(_self.addr.title === ''|| !_self.addr.title) {
        $.toast('发票抬头不能为空');
        return;
      }
      if(_self.addr.taxFileNumber === ''|| !_self.addr.taxFileNumber) {
        $.toast('税号不能为空');
        return;
      }
      if(_self.invoiceType === 1|| _self.addr.billType===1){ // 电子
        if(_self.addr.email === '' || !$.comReg.isEmail(_self.addr.email) || !_self.addr.email){
          $.toast('请输入有效的邮箱');
          return
        }
      }else{
        if(_self.addr.name === ''||_self.addr.name === null || !_self.addr.name){$.toast('收票人姓名不能为空'); return}
        if(_self.addr.telephone === ''|| _self.addr.telephone ===null || !$.comReg.isPhone(_self.addr.telephone)){$.toast('请输入有效电话号码'); return}
        if(_self.addr.address === ''||_self.addr.address === null || !_self.addr.address){$.toast('收票人地址不能为空'); return}
        if(_self.addr.address.match(_regRule)) {
          //param = param.replace(/\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g, "");
          $.toast("详情地址不可输入表情");
          return;
        }
      }
      if(_self.addr.id){
        $.commonAjax({
          url : '/bill/updateBillAddress.api',
          type : 'post',
          data : {
            id : _self.addr.id,
            billType : _self.invoiceType,
            orgType : 2, // 公司的
            title : _self.addr.title,
            taxFileNumber :_self.addr.taxFileNumber,
            email : _self.invoiceType===1?_self.addr.email:'',
            bankNumber : _self.addr.bankNumber,
            companyTelephone : _self.addr.companyTelephone,
            companyAddress : _self.addr.companyAddress,
            name : _self.invoiceType===2?_self.addr.name:'',
            telephone : _self.invoiceType===2?_self.addr.telephone:'',
            address : _self.invoiceType===2?_self.addr.address:'',
            bank : _self.addr.bank
          },
          success : function (data) {
            if(data.datas===true) router.push('/invoice/address');
            if (data.datas === false){
              $.toast('已有重复的地址信息');
              return
            }
          },
          error : function (err) {
            $.toast(err);
          }
        })
      }else{
        $.commonAjax({
          url : '/bill/insertBillAddress.api',
          type : 'post',
          data : {
            billType : _self.invoiceType,
            orgType : 2, // 公司的
            title : _self.addr.title,
            taxFileNumber :_self.addr.taxFileNumber,
            email : _self.invoiceType===1?_self.addr.email:'',
            bankNumber : _self.addr.bankNumber,
            companyTelephone : _self.addr.companyTelephone,
            companyAddress : _self.addr.companyAddress,
            name : _self.invoiceType===2?_self.addr.name:'',
            telephone : _self.invoiceType===2?_self.addr.telephone:'',
            address : _self.invoiceType===2?_self.addr.address:'',
            bank : _self.addr.bank
          },
          success : function (data) {
            if(data.datas===true) router.push('/invoice/address');
            if (data.datas === false){
              $.toast('已有重复的地址信息');
              return
            }
          },
          error : function (err) {
            $.toast(err);
          }
        })
      }
    }
  },
  activated : function () {
    var _self = this;
    if(_self.addr.billType){
      _self.invoiceType = _self.addr.billType;
    }else{
      _self.invoiceType = 1;
    }
    setStore('route_ident','#invoice_addrList_com')
  }
});