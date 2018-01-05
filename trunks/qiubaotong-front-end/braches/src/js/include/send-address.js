var send_address_view = Vue.extend({
    template: '#send-address',
    data : function(){
        return{
            addr_province : '',
            addr_city : '',
            addr_district : '',
            addr_street : '',
            search_list : [],
            search_msg : '',
            addr_list : []
        }
    },
    vuex : {
        getters : {
            geo_city : function(state){ return state.geo_city},
            geo_city2 : function(state){ return state.geo_city2},
            geo_province : function(state){ return state.geo_province},
            geo_district : function(state){ return state.geo_district},
            geo_addr : function(state){ return state.geo_addr},
            isJ : function(state){ return state.isJ},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr},
            useraddr_refresh : function(state){ return state.useraddr_refresh}
        }
    },
    methods : {
        goView : function(view){
            this.searchClear();
            this.$route.router.go(view);
        },
        search : function(val){
            if(val && (this.geo_city2 || this.geo_city)){
                var self = this;
                $.baiduApi_suggestion(this.geo_city2 || this.geo_city,val,function(data){
                    self.search_list = data.result;
                });
            }
        },
        searchClear : function(){
            this.search_list = [];
            this.search_msg = '';
        },
        selectPlace:function(place) {
          var self = this;
          $.baiduApi_address(place.location.lat+','+place.location.lng,function(data){
              self.addr_province = data.result.addressComponent.province;
              self.addr_city = data.result.addressComponent.city;
              self.addr_district = data.result.addressComponent.district;
              self.addr_street = data.result.addressComponent.street + data.result.addressComponent.street_number;
              self.newaddr(self.addr_province,self.addr_city,self.addr_district,self.addr_street);
          });
        },
        save : function(item){
            if(this.isJ){
                this.send_addr.type = 1;
                this.send_addr.address = item.cityName.replace(/,/g,'')  + item.address;
                this.send_addr.name = item.name;
                this.send_addr.mobile = item.mobile;
                this.send_addr.areaId = item.areaId;
                this.send_addr.real_address = item.address;
                this.send_addr.addr_type = '4';
                this.send_addr.addr_id = item.id;
            }else{
                this.collect_addr.type = 1;
                this.collect_addr.address = item.cityName.replace(/,/g,'')  + item.address;
                this.collect_addr.name = item.name;
                this.collect_addr.mobile = item.mobile;
                this.collect_addr.areaId = item.areaId;
                this.collect_addr.real_address = item.address;
                this.collect_addr.addr_type = '4';
                this.collect_addr.addr_id = item.id;
            }
            this.goView('/');
        },
        newaddr : function(province,city,district,addr){
            setStore('addr_province',province);
            setStore('addr_city',city);
            setStore('addr_district',district);
            setStore('addr_street',addr);
            this.goView('/newaddr');
        },
        selectGeo : function(){
            this.newaddr(this.geo_province,this.geo_city,this.geo_district,this.geo_addr);
        },
        goNewAddr : function(){
            $.ls('newaddr',"true");
            //保存已填地址
            this.saveStore();
            locationTo('address.html#!/new');
        },
        goEditAddr : function(item){
            $.ls('editaddr',JSON.stringify(item));
            //保存已填地址
            this.saveStore();
            locationTo('address.html#!/new');
        },
        getUserAddr : function(){
            var self = this;
            //常用地址
            $.commonAjax({
                url : '/userAddress/list.api',
                success : function(data){
                    self.addr_list = data.datas;
                }
            });
        },
        saveStore : function(){
            var store = {
                send_addr : this.send_addr,
                collect_addr : this.collect_addr,
                isJ : this.isJ
            };
            $.ls('addr_store',JSON.stringify(store));
        }
    },
    watch : {
        'search_msg' : function(val){
            this.search(val);
        },
        'useraddr_refresh' : 'getUserAddr'
    },
    ready : function(){
        this.getUserAddr();
    }
});
