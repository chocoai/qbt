var agent_address_view = Vue.extend({
    template: '#agent-address',
    data : function(){
        return{
            addr_list : []
        }
    },
    vuex : {
        getters : {
            isJ : function(state){ return state.isJ},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr},
            agent_userId : function(state){return state.agent_userId},
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
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
            history.back();
        },
        goNewAddr : function(){
            this.goView('/newaddr');
        },
        getUserAddr : function(){
            var self = this;
            //常用地址
            $.commonAjax({
                url : '/userProxy/address/list.api',
                data : {
                    userId : this.agent_userId || 0
                },
                success : function(data){
                    self.addr_list = data.datas;
                }
            });
        }
    },
    route : {
        data : function(){
            this.getUserAddr();
        }
    }
});
