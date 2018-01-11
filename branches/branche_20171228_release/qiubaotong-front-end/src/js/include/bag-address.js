var bag_address_view = Vue.extend({
    template: '#bag-address',
    data : function(){
        return{
            list_addr : [],
            provice : '',
            city : '',
            addr_list : [],
            addr_city : []
        }
    },
    watch : {
        'provice' : 'changeProvice',
        'city' : 'changeCity',
        'applyType' : 'getList'
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;},
            applyType : function(state){ return state.applyType;},
            applyName : function(state){ return state.applyName;}
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        getList : function(){
            if(this.applyType == 1 || this.applyType == 2){
                this.provice = "";
                this.city = "";
                this.list_addr= [];
                return;
            }
            var self = this;
            var type = "";
            if(this.applyType == 3) type = '3';
            if(this.applyType == 4) type = '2';
            if(this.applyType == 5) type = '1';
            if(this.applyType == 8) type = '4'; //合作机构
            $.commonAjax({
                url : '/comm/query_site.api',
                data :{
                    type : type
                },
                success : function(data){
                    self.list_addr = data.datas;
                }
            });
        },
        save : function(item){
            setStore('applyId',item.id);
            setStore('applyName',item.name);
            this.goView('bag_apply_view');
        },
        changeProvice : function(name){
            if(this.provice){
                for(var i = 0;i<this.addr_list.length;i++){
                    if(this.provice == this.addr_list[i].id){
                        this.addr_city = this.addr_list[i].items;
                        break;
                    }
                };
          }else {
              this.addr_city = [];
          };
          this.city = '';
        },
        changeCity : function(){
          if(this.city){
              var self = this;
              $.commonAjax({
                  url : '/comm/query_course.api',
                  data :{
                      city_id : this.city,
                      status : this.applyType
                  },
                  success : function(data){
                      self.list_addr = data.datas;
                  },
                  error : function(err){
                      $.toast(err);
                  }
              });
          }else{
              this.list_addr= [];
          };
        },
        getCity : function(){
            var self = this;
            if(localStorage.cityList){
                self.addr_list = JSON.parse(localStorage.cityList);
            }else{
                $.commonAjax({
                    url : '/area/query_level.api',
                    data :{ level : 2 },
                    success : function(data){
                        self.addr_list = data.datas;
                        localStorage.cityList = JSON.stringify(data.datas);
                    },
                    error : function(){
                        $.toast('获取城市列表失败');
                    }
                });
            }
        }
    },
    ready : function(){
        this.getList();
        this.getCity();
    }
});
