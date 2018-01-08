/**
 * Created by Administrator on 2017/10/11.
 */
var invoice_content_view = Vue.extend({
  template : '#invoice_content',
  data : function () {
    return{
      show : false,
      invoiceType : 1,
      personalType : 1,
      showChoice : false, // 可选信息的展示
      prevRouteID : '',
      perName : '',
      perTel : '',
      perAddr : '',
      taxNum : '',
      comNum : '',
      comBank : '',
      comTel : '',
      comAddr : '',
      perEmail : '',
      inName : '',
      historyList : {},
      invoiceIntro : ''
    }
  },
  computed : {
    route_ident : function(){return this.$store.state.route_ident},
    totalAmount : function () {
      return this.$store.state.totalAmount
    },
    orderCont : function () {
      return this.$store.state.orderCont
    }
  },
  methods : {
    goBack : function () {
      router.push('/')
    },
    goView : function () {
      var _self = this;
      setStore('personalType',_self.personalType);
      setStore('invoiceType',_self.invoiceType);
      router.push('/invoice/address')
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
    },
    showIntro : function (e) {
      if (e && e.stopPropagation) {//非IE浏览器
        e.stopPropagation();
      }
      else {//IE浏览器
        window.event.cancelBubble = true;
      }
      $(".tip_invoice.bottom_invoice").removeClass('fade')
    },
    fadeLog : function () {
      $(".tip_invoice.bottom_invoice").addClass('fade')
    },
    // 确认提交发票
    onConfirm : function () {
      var _self = this;
      $.commonAjax({
        url : '/bill/applayForBill.api',
        type : 'post',
        data : {
          orderId : _self.orderCont,
          price : _self.totalAmount,
          billType : _self.invoiceType,
          orgType : _self.personalType,
          title : _self.inName,
          email : _self.perEmail,
          name : _self.perName,
          telephone : _self.perTel,
          address : _self.perAddr,
          taxFileNumber : _self.taxNum,
          bankNumber : _self.comNum,
          companyTelephone : _self.comTel,
          companyAddress : _self.comAddr,
          bank : _self.comBank
        },
        success : function (data) {
          if(data.datas == true){
            _self.goV2Nav("index.html","/order");
          }
        }
      })
    },
    // 点击确认提交发票按钮
    confirmData : function () {
      var _self = this;
      var _regRule = /\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g;
      if(_self.inName === '') {
        $.toast('发票抬头不能为空');
        return;
      }
      if(_self.invoiceType===1){ // 电子的
        if(_self.personalType===2){
          if(_self.taxNum === ''|| !_self.taxNum || _self.taxNum===null){$.toast('公司税号不能为空'); return}
        }
        if(_self.perEmail === '' || !$.comReg.isEmail(_self.perEmail)){$.toast('请输入有效的邮箱'); return}
        setStore('email',_self.perEmail);
      }else{ // 纸质的
        if(_self.personalType===2){
          if(_self.taxNum === ''|| !_self.taxNum || _self.taxNum===null){$.toast('公司税号不能为空'); return}
          var invoiceCom_msg = {
            taxNum : _self.taxNum,
            accountNum : _self.comNum,
            invoiceBank : _self.comBank,
            invoicePhone : _self.comTel,
            invoiceAddr : _self.comAddr
          };
          setStore('companyInvoice',invoiceCom_msg);
        }
        if(_self.perName === ''){$.toast('收票人姓名不能为空'); return}
        if(_self.perTel === ''|| !$.comReg.isPhone(_self.perTel)){$.toast('请输入有效电话号码'); return}
        if(_self.perAddr === ''){$.toast('收票人地址不能为空'); return}
        if(_self.perAddr.match(_regRule)) {
          //param = param.replace(/\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g, "");
          $.toast("详情地址不可输入表情");
          return;
        }
        var invoicePer_msg = {
          invoiceName : _self.perName,
          invoicePhone : _self.perTel,
          invoiceAddr : _self.perAddr
        };
        setStore('sendInvoice',invoicePer_msg)
      }
      setStore('invoiceTitle',_self.inName);
      _self.show = true;
    },
    // 切换电子还是纸质界面
    tabType : function (num) {
      var _self = this;
      _self.invoiceType = num;
    },
    // 切换个人还是公司界面
    tabPerType : function (num) {
      var _self = this;
      _self.personalType = num;
    },
    // 获取历史信息
    getHistory : function () {
      var _self = this;
      $.commonAjax({
        url : '/bill/findLastUseAddressByUserId.api',
        type : 'get',
        data : {},
        success : function (data) {
          if(data.datas&&data.datas!=='') {
              _self.personalType = data.datas.orgType;
              _self.invoiceType = data.datas.billType;
              _self.perEmail = data.datas.email;
              _self.taxNum = data.datas.taxFileNumber;
              _self.comNum = data.datas.bankNumber;
              _self.comBank = data.datas.bank;
              _self.comTel = data.datas.companyTelephone;
              _self.comAddr = data.datas.companyAddress;
              _self.inName = data.datas.title;
              _self.perName = data.datas.name;
              _self.perTel = data.datas.telephone;
              _self.perAddr = data.datas.address;
          }
        },
        error : function (err) {
          $.toast(err);
        }
      })
    },

    getInvoiceIntro : function () {
      var _self = this;
      $.commonAjax({
        url : '/sysConfig/findByCode.api',
        type : 'get',
        data : {
          code : '3'
        },
        success : function (data) {
          _self.invoiceIntro = data.datas;
        },
        error : function (err) {
          $.toast(err);
        }
      })
    }
  },
  activated : function () {
    var _self = this;
    _self.getInvoiceIntro();
    if(_self.route_ident=='#invoice_select'){
      _self.prevRouteID = '#invoice_select';
      _self.getHistory();
    }else if(_self.route_ident=='#invoice_addrList'){
      _self.prevRouteID = '#invoice_addrList';
      _self.addr = _self.$store.state.addr;
      if(_self.addr.email || _self.addr.taxFileNumber || _self.addr.name){
        _self.personalType = _self.addr.orgType;
        _self.invoiceType = _self.addr.billType;
        _self.perEmail = _self.addr.email;
        _self.taxNum = _self.addr.taxFileNumber;
        _self.comNum = _self.addr.bankNumber;
        _self.comBank =  _self.addr.bank;
        _self.comTel = _self.addr.companyTelephone;
        _self.comAddr = _self.addr.companyAddress;
        _self.inName = _self.addr.title;
        _self.perName = _self.addr.name;
        _self.perTel = _self.addr.telephone;
        _self.perAddr = _self.addr.address;
      }
    }
    setStore('route_ident',"#invoice_content")
  }
});