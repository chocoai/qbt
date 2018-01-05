/**
 * Created by Administrator on 2017/8/11.
 */
var agent_success_view = Vue.extend({
  template : '#agent_success',
  data : function(){
    return {
      adate : '',
      atime : '',
      showDanger : false
    }
  },
  filters : {
    // timeFilter : function(val){
    //     var mdata={
    //         0 : '周日',
    //         1 : '周一',
    //         2 : '周二',
    //         3 : '周三',
    //         4 : '周四',
    //         5 : '周五',
    //         6 : '周六'
    //     }
    //     return mdata[val]
    // }
  },
  methods : {
    goV2Nav : function(url,hach){
      var _url=location.href;
      _url=_url.replace(location.hash,'');
      var index = _url.indexOf('?');
      var hx="";
      hach && (hx=hach);
      if(index == -1){
        location.href = _url + '?_r=' + $.version;
      }else{
        location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1)+ '&orderstatus=4&isreplace=1' + '#' + hx;
      }
    },
    goOrderList : function(){
      this.goV2Nav("index.html","/order");
    },
    compatible_ios_show : function()
    {
      $(".page").css("overflow","hidden");
    },
    compatible_ios_hide : function(){
      $(".page").css("overflow","auto");
    }
  },
  activated : function(){
    var self=this;
    var _timeA=self.$route.params.arrivetime.split(" ")[0];
    var _timeB=self.$route.params.arrivetime.split(" ")[1];
    _timeA=_timeA.replace(/\-/g,"/");
    var myDate=new Date(_timeA);
    var month=myDate.getMonth();
    var day=myDate.getDate();
    var _week=myDate.getDay();
    var orderId=self.$route.params.orderId;
    self.adate=(month+1)+'月'+day+'日';
    self.atime=_timeB;
  },
  mounted : function(){

  }
});
