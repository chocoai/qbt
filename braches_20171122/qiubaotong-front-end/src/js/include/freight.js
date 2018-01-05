var freight_view = Vue.extend({
    template: '#freight',
    data: function(){
        return{
            expect_times : [],
            geo_addr : '',
            geo_addr_id : ''
        }
    },
    vuex :{
        getters :{
            send_time : function(state){ return state.send_time},
            jAddress : function(state){ return state.jAddress},
            jAddrId : function(state){ return state.jAddrId},
            dAddress : function(state){ return state.dAddress},
            dAddrId : function(state){ return state.dAddrId},
            isJ : function(state){ return state.isJ}
        }
    },
    methods: {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        getAmount : function(){
          if(!this.jAddrId){
              $.toast('请选择寄包地址'); return;
          }
          if(!this.dAddrId){
              $.toast('请选择收包地址'); return;
          }
          if(!this.send_time){
              $.toast('请选择取包时间'); return;
          }
          var self = this;
          $.commonAjax({
              url : '/comm/v2/query_sf_recive_time.api',
              type : 'POST',
              data : {
                  consigned_time : this.send_time.substr(0,16)+':00',
                  src_area_id : this.jAddrId,
                  dest_area_id : this.dAddrId,
                  src_address : '全部',
                  dest_address : '全部',
                  business_type : 0
              },
              success : function(data){
                  if(data.datas && data.datas.length>0){
                      self.expect_times = data.datas;
                  }
              },
              error : function(err){
                  $.toast(err);
              }
          });
      },
      checkCity : function(isJ){
          setStore("isJ",isJ);
          if(isJ){
              setStore("cityName",this.jAddress);
          }else{
              setStore("cityName",this.dAddress);
          }
          this.goView('freight_city_view');
      },
      checkTime : function(){
          this.goView('freight_starttime_view');
      },
      bindProvice : function(addr_list,province,city,district){
          for(var i =0; i<addr_list.length; i ++){
              if(province.indexOf(addr_list[i].name)>=0){
                  this.geo_addr = addr_list[i].name;
                  this.bindCity(addr_list[i].items,city,district);
                  return;
              }
          }
      },
      bindCity : function(city_list,city,district){
          for(var i =0; i<city_list.length; i ++){
              if(city.indexOf(city_list[i].name)>=0){
                  this.geo_addr = this.geo_addr + ',' + city_list[i].name;
                  this.bindDistrict(city_list[i].id,district);
                  return;
              }
          }
          //没匹配到
          this.bindFinished();
      },
      bindDistrict : function(city_id,district){
          var self = this;
          $.commonAjax({
              url : '/area/list.api',
              data : {superId : city_id},
              success : function(data){
                  var district_list = data.datas;
                  for(var i=0; i< district_list.length; i ++){
                      if(district.indexOf(district_list[i].name)>=0){
                          self.geo_addr = self.geo_addr + ',' + district_list[i].name;
                          self.geo_addr_id = district_list[i].id;
                          break;
                      }
                  }
                  self.bindFinished();
              }
          });
      },
      bindFinished : function(){
          if(this.geo_addr){
              if(!this.jAddress){
                  setStore('jAddress',this.geo_addr);
              }
              if(!this.dAddress){
                  setStore('dAddress',this.geo_addr);
              }
          }
          if(this.geo_addr_id){
              if(!this.jAddrId){
                  setStore('jAddrId',this.geo_addr_id);
              }
              if(!this.dAddrId){
                  setStore('dAddrId',this.geo_addr_id);
              }
          }
      }
    },
    ready: function() {
        var self = this;
        //定位 -> 地址转换 百度地址 -> 顺丰地址
        $.webService.getCityList().then(function(data){
            var addr_list = data;
            $.baiduApi_location(function(geo){
                var province = geo.result.addressComponent.province;
                var city = geo.result.addressComponent.city;
                var district = geo.result.addressComponent.district;
                self.bindProvice(addr_list,province,city,district);
            })
        });
    }
});
