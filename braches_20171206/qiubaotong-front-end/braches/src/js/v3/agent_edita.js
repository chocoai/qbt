/**
 * Created by Administrator on 2017/8/9.
 */
var agent_address_addrs_edit_view = Vue.extend({
  template : '#agent_send_addrs_edit',
  data : function(){
    return{
      areas: AREAS,
      treeId:[],
      labelType:3
    }
  },
  computed :{
    addr : function(){return this.$store.state.addr},
    isHelp : function () {return this.$store.state.isHelp},
    agentId : function () {return this.$store.state.agentId}
  },
  methods : {
    save: function(){
      var self = this;
      var msg = this.validate();
      if(msg){
        $.toast(msg); return;
      }
      //表情输入检查
      var regRule = /\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g;
      if(self.addr.address.match(regRule)) {
        //param = param.replace(/\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g, "");
        $.toast("详情地址不可输入表情");
        return;
      }
      if(this.addr.id){
        // 修改
        if(self.isHelp===3){
          $.commonAjax({
            url : '/userProxy/address/update.api',
            type : 'POST',
            data : {
              areaId : self.treeId[2],
              id : self.addr.id,
              name : "",
              mobile : "",
              cityName : "",
              address : self.addr.address,
              def : false,
              labelType : self.labelType,
              userId : self.agentId || 0
            },
            success : function(data){
              setStore('label_type',self.labelType);
              // router.push('/isend/address/addrs');
              router.push('/agent_address/addrs');
            },
            error : function(err){
              $.toast(err);
            }
          })
        }else{
          $.commonAjax({
            url : '/userAddress/update.api',
            type : 'POST',
            data : {
              id : self.addr.id,
              name : "",
              mobile : "",
              areaId : self.treeId[2],
              address : self.addr.address,
              labelType : self.labelType
            },
            success : function(data){
              setStore('label_type',self.labelType);
              // router.push('/isend/address/addrs');
              router.push('/agent_address/addrs');
            },
            error : function(err){
              $.toast(err);
            }
          });
        }
      }
      else{
        // 新增
        if(self.isHelp===3){
          $.commonAjax({
            url : '/userProxy/address/add.api',
            type : 'POST',
            data : {
              areaId : self.treeId[2],
              name : "",
              mobile : "",
              cityName : "",
              address : self.addr.address,
              def : false,
              userId : self.agentId || 0,
              labelType : self.labelType
            },
            success : function(data){
              setStore('label_type',self.labelType);
              // router.push('/isend/address/addrs');
              router.push('/agent_address/addrs');
            },
            error : function(err){
              $.toast(err);
            }
          });
        }else{
          $.commonAjax({
            url : '/userAddress/add.api',
            type : 'POST',
            data : {
              name : "",
              mobile : "",
              areaId : self.treeId[2],
              address : self.addr.address,
              labelType : self.labelType
            },
            success : function(data){
              setStore('label_type',self.labelType);
              // router.push('/isend/address/addrs');
              router.push('/agent_address/addrs');
            },
            error : function(err){
              $.toast(err);
            }
          });
        }
      }
    },
    validate : function(){
      // if(!this.addr.name) return '请输入联系人姓名';
      // if(!this.addr.mobile || !$.comReg.isPhone(this.addr.mobile)) return '请输入有效手机号';
      if(this.treeId.length == 0) return '请选择所在地区';
      if(!this.addr.address) return '请输入详情地址';
      return '';
    },
    setLabel: function(type){
      this.labelType = type;
    },
    goBack: function(){
      router.push('/agent_address/addrs');
    }
  },
  activated : function(){
    var self = this;
    //设置路由标示
    setStore('route_ident',"#agent_edita");
    if(this.addr.treeId){
      this.treeId = this.addr.treeId.split(',');
      this.labelType = this.addr.labelType;
    }else{
      this.treeId=["","",""];
      this.labelType=3;
    }
  },
  mounted : function(){
  }
});
