var freight_city_view = Vue.extend({
    template: '#freight-city',
    data : function(){
        return{
            tab : 1,
            addr_list : [],
            provice : '',
            city : '',
            district : '',
            city_list : [],
            district_list : []
        }
    },
    vuex :{
        getters :{
            cityName : function(state){ return state.cityName},
            isJ : function(state){ return state.isJ}
        }
    },
    watch : {
        'cityName' : function(newVal){
            if(newVal){
                this.bindCityName();
            }
        }
    },
    methods : {
        goView : function(view){
            setStore('cityName','');
            this.$dispatch('view-change',view);
        },
        getCity : function(){
            var self = this;
            $.webService.getCityList().then(function(data){
                self.addr_list = data;
                self.bindCityName();
            },function(err){
                $.toast('获取城市列表失败');
            });
        },
        changeTab : function(id){
            if(id == 1){
                this.city = '',
                this.district = '',
                this.tab = 1;
            }else if(id == 2){
                if(this.provice){
                    this.district = '',
                    this.tab = 2;
                }
            }
        },
        bindProvice : function(name){
            this.provice = name;
            for(var i = 0; i < this.addr_list.length; i++){
                var item = this.addr_list[i];
                if(item.name == name){
                    this.city_list = item.items;
                    this.tab = 2;
                    if(this.city_list.length == 1){
                        this.bindCity(this.city_list[0].name);
                    }
                    break;
                }
            }
        },
        bindCity : function(name){
            this.city = name;
            var self = this;
            for(var i = 0; i < this.city_list.length; i++){
                var item = this.city_list[i];
                if(item.name == name){
                    $.commonAjax({
                        url : '/area/list.api',
                        data : {superId : item.id},
                        success : function(data){
                            self.district_list = data.datas;
                            self.tab = 3;
                        }
                    });
                }
            }
        },
        bindDistrict : function(name){
            this.district = name;
        },
        bindCityName : function(){
            if(this.cityName){
                var city = this.cityName.split(',');
                this.bindProvice(city[0]);
                if(city[1]){
                    this.bindCity(city[1]);
                }
                if(city[2]){
                    this.bindDistrict(city[2]);
                }
            }else{
                this.tab = 1;
                this.provice = '';
                this.city = '';
                this.district = '';
            }
        },
        save : function(name,id){
            if(this.isJ){
                setStore("jAddress",this.provice + ',' + this.city + ',' + name);
                setStore("jAddrId",id);
            }else{
                setStore("dAddress",this.provice + ',' + this.city + ',' + name);
                setStore("dAddrId",id);
            }
            this.goView('freight_view');
        }
    },
    ready : function(){
        this.getCity();
    }
});
