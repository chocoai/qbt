var address_list_view = Vue.extend({
    template: '#address-list',
    data : function(){
        return {
            addr_list : []
        }
    },
    vuex :{
        getters :{
            addr_refresh : function(state){ return state.addr_refresh}
        }
    },
    watch : {
        'addr_refresh' : 'getList'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        editAddr : function(item){
            setStore('addr_edit',item);
            this.goView('/new');
        },
        addAddr : function(){
            setStore('addr_edit',{'cityName':''});
            this.goView('/new');
        },
        getList : function(){
            var self = this;
            //常用地址
            $.commonAjax({
                url : '/userAddress/list.api',
                success : function(data){
                    self.addr_list = data.datas;
                }
            });
        }
    },
    ready : function(){
        this.getList();
    }
});
