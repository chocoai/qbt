var send_addrcity_view = Vue.extend({
    template: '#send-addrcity',
    data : function(){
        return{
            city_list : [],
            provice_selected : '',
            city_selected : ''
        }
    },
    vuex : {
        getters : {
            geo_city : function(state){ return state.geo_city}
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        toggle : function(name){
            if(this.provice_selected == name){
                this.provice_selected = '';
            }else{
                this.provice_selected = name;
            }
        },
        selectCity : function(name){
            if(!name) return;
            setStore('geo_city2',name);
            this.goView('/address');
        }
    },
    ready : function(){
        var self = this;
        if(localStorage.cityList){
            self.city_list = JSON.parse(localStorage.cityList);
        }else{
            $.commonAjax({
                url : '/area/query_level.api',
                data :{ level : 2 },
                success : function(data){
                    self.city_list = data.datas;
                    localStorage.cityList = JSON.stringify(data.datas);
                },
                error : function(){
                    $.alert('获取城市列表失败');
                }
            });
        }
    }
});
