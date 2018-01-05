/**
 * Created by Administrator on 2017/8/9.
 */
var wechat_user_view = Vue.extend({
  template:'#wechat-user',
  data : function(){
    return{
      keyword:'', // 搜索关键字
      userList:[]
    }
  },
  computed:{

  },
  methods : {
    getList : function () {
      var self = this;
      $.commonAjax({
        url:'/userProxy/list.api',
        data:{
          keyword:self.keyword
        },
        success : function (data) {
          self.userList = data.datas;
        },
        error : function (err) {
          $.toast(err);
        }
      })
    },
    goView : function (type,obj) {
      if(obj){
        setStore('agentId',obj.userId)
        setStore('proxyId',obj.proxyUserId)
      }
      type===3?setStore('isHelp',type):setStore('isHelp',2)
      router.push('/agent_send')
    },
    updataUser : function(user){
      var self = this;
      layer.open({
          type : 1,
          content: '<div style="" id="updataUser" class="weui-cells weui-cells_form">\
                      <div class="weui-cell" style="padding:5px;font-size:14px !important">\
                        <div class="weui-cell__hd">\
                          <label class="weui-label">用户名</label>\
                        </div>\
                        <div class="weui-cell__bd">\
                          <input id="userName" value="'+(user.name==null?'':user.name)+'" maxlength="10" class="weui-input" type="text" placeholder="请输入微信用户名">\
                        </div>\
                      </div>\
                      <div class="weui-cell" style="padding:5px;font-size:14px !important">\
                        <div class="weui-cell__hd">\
                          <label class="weui-label">手机号码</label>\
                        </div>\
                        <div class="weui-cell__bd">\
                          <input id="userMobile" value="'+user.mobile+'" class="weui-input" type="number" placeholder="请输入微信手机号码">\
                        </div>\
                      </div>\
                    </div>',
          shadeClose : false, //true会导致tap事件穿透
          btn: ['确定', '取消'],
          skin: 'footer',
          className : 'layer_confirm',
          yes: function(index){
            if($("#userName").val()==''){
              $.toast('请输入微信用户名');  return;
            }
            else if($("#userMobile").val().length!=11){
                $.toast('请输入11位的手机号码'); return;
            }else{}

            $.commonAjax({
              url:'/userProxy/save.api',
              type : 'POST',
              data:{
                name : $("#userName").val(),
                mobile : $("#userMobile").val(),
                userId : user.userId
              },
              success : function (data) {
                self.getList();
                layer.close(index);                              
              },
              error : function (err) {
                $.toast(err);
                layer.close(index);
              }
            })              
          },
          no : function(){
          }
      });
    }
  },
  activated : function () {
    var self = this;
    self.getList();
    setStore('route_ident',"#wechat_user");
  },
  mounted :function(){
    $.webService.getJsConfig().then(function(data){
        wx.config({
          appId: $.appId,
          timestamp: data.datas.timestamp,
          nonceStr: data.datas.nonceStr,
          signature: data.datas.signature,
          jsApiList: ['getLocation']
        });
        wx.ready(function(){
            wx.getLocation({
                type: 'wgs84',
                success: function (res) {
                    setStore('geo_lat',res.latitude);
                    setStore('geo_long',res.longitude);
                }
            });
        });
    });
  }
});