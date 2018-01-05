/**
 * Created by Administrator on 2017/10/11.
 */
var invoice_addr_select_view = Vue.extend({
  template : '#invoice_addr_select',
  data : function () {
    return{
      orderList : [],
      selectMebPoint : false,
      orderIdArr : '',
      totalAmount : 0,
      checkList : [],
      isCheck : false // 判断是否包含已选择订单
    }
  },
  computed : {
    route_ident : function () {
      return this.$store.state.route_ident;
    }
  },
  methods : {
    onScrollBottom : function () {

    },
    goNext : function () {
      var _self = this;
      if(_self.orderList.length===0){
        return
      }
      for(var i=0;i<_self.orderList.length;i++){
        if(_self.orderList[i].checked===true){
          _self.isCheck = true;
          _self.orderIdArr.length===0 ? _self.orderIdArr = _self.orderIdArr +_self.orderList[i].id : _self.orderIdArr = _self.orderIdArr+','+_self.orderList[i].id;
          _self.totalAmount = _self.totalAmount + _self.orderList[i].amount;
        }else{
          if(i===_self.orderList.length-1 && _self.isCheck===false){
            $.toast('请选择需要开发票的订单');
            return;
          }
        }
      }
      setStore('orderCont',_self.orderIdArr);
      setStore('totalAmount',_self.totalAmount);
      setStore('addr',{});
      _self.orderIdArr = '';
      _self.totalAmount = 0;
      _self.isCheck = false;
      router.push('/invoice');
    },
    selectMeb : function(index) {
      var _self = this;
      this.checkList[index].checked=!this.checkList[index].checked;
      if(_self.checkList[index].checked){
        _self.orderList[index].checked=true;
      }else{
        _self.orderList[index].checked=false;
      }
      for(var j=0;j<_self.checkList.length;j++){
        if(_self.checkList[j].checked === false){
          if(_self.selectMebPoint === true){
            _self.selectMebPoint = false;
            break
          }else{
            _self.selectMebPoint = false;
            break
          }
        }else{
          _self.selectMebPoint = true;
        }
      }
    },
    selectAllMeb : function() {
      var self = this;
      self.selectMebPoint=!self.selectMebPoint;
      if(self.selectMebPoint) {
        for(var i=0;i<self.orderList.length;i++){
          self.checkList[i].checked=true;
          self.orderList[i].checked=true;
        }
      }else{
        for(var i=0;i<self.orderList.length;i++){
          self.checkList[i].checked=false;
          self.orderList[i].checked=false;
        }
      }
    },
    getForBill : function () {
      var _self = this;
      $.commonAjax({
        url : '/order/findForBill.api',
        type : 'get',
        data:{},
        success : function (data) {
          _self.orderList = data.datas;
          _self.checkList = [];
          if(data.datas.length>0){
            _self.orderList = data.datas.map(function (m, index) {
              return $.extend(m,{checked:false})
            })
            for(var i=0;i<_self.orderList.length;i++){
              _self.checkList.push({'checked':''})
              _self.checkList[i].checked = _self.orderList[i].checked;
            }
          }
        }
      })
    }
  },
  activated : function () {
    var _self = this;
    this.getForBill();
    if(_self.route_ident ==='#invoice_content'){
      _self.selectMebPoint = false;
    }
    setStore('route_ident',"#invoice_select");
  }
})