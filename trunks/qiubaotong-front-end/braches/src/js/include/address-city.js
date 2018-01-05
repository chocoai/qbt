var address_city_view = Vue.extend({
    template: '#address-city',
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
            addr_edit : function(state){return state.addr_edit}
        }
    },
    watch : {
        'cityName' : 'bindCityName'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getCity : function(){
            var self = this;
            if(localStorage.cityList){
                self.addr_list = JSON.parse(localStorage.cityList);
                self.bindCityName();
            }else{
                $.commonAjax({
                    url : '/area/query_level.api',
                    data :{ level : 2 },
                    success : function(data){
                        self.addr_list = data.datas;
                        self.bindCityName();
                        localStorage.cityList = JSON.stringify(data.datas);
                    },
                    error : function(){
                        $.toast('获取城市列表失败');
                    }
                });
            }
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
                this.bindCity(city[1]);
                this.bindDistrict(city[2]);
            }else{
                this.tab = 1;
                this.provice = '';
                this.city = '';
                this.district = '';
            }
        },
        save : function(name,id){
            this.addr_edit.cityName = this.provice + ',' + this.city + ',' + name;
            this.addr_edit.areaId = id;
            history.back();
        }
    },
    ready : function(){
        this.getCity();
    }
});
