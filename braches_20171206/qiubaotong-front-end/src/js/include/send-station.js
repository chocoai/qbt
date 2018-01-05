var send_station_view = Vue.extend({
    template: '#send-station',
    data : function(){
        return{
            tab : '1',
            list_airport : [],
            list_sf : [],
            list_bank : [],
            name : '',
            mobile : ''
        }
    },
    vuex :{
        getters : {
            isJ : function(state){ return state.isJ;},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr}
        }
    },
    watch : {
        'tab' : function(val){
            if(val == '1'){
                if(this.list_airport.length == 0){
                    this.getList();
                }
            }else if(val == '2'){
                if(this.list_sf.length == 0){
                    this.getList();
                }
            }else if(val == '3'){
                if(this.list_bank.length == 0){
                    this.getList();
                }
            }
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/comm/query_site.api',
                data :{
                    type : self.tab
                },
                success : function(data){
                    if(self.tab == '1'){
                        self.list_airport = data.datas;
                    }else if(self.tab == '2'){
                        self.list_sf = data.datas;
                    }else if(self.tab == '3'){
                        self.list_bank = data.datas;
                    }
                }
            });
        },
        save : function(item){
            if(this.isJ){
                this.send_addr.type = 3;
                this.send_addr.address = item.name;

                //有用户信息
                if(this.name || this.mobile){
                    this.send_addr.name = this.name;
                    this.send_addr.mobile = this.mobile;
                }else{
                    //取收件
                    if(this.collect_addr.name && this.collect_addr.mobile){
                        this.send_addr.name = this.collect_addr.name;
                        this.send_addr.mobile = this.collect_addr.mobile;
                    }else{
                        this.send_addr.name = '';
                        this.send_addr.mobile = '';
                    }
                }

                this.send_addr.real_address = item.address;
                this.send_addr.areaId = item.areaId;
                if(this.tab == '1'){
                    this.send_addr.addr_type = '2';
                }else if(this.tab == '2'){
                    this.send_addr.addr_type = '5';
                }else if(this.tab == '3'){
                    this.send_addr.addr_type = '3';
                }
                this.send_addr.addr_id = item.id;

                if(!this.send_addr.name || !this.send_addr.mobile){
                    this.goView('/contact');
                }else{
                    this.goView('/');
                }
            }else{
                this.collect_addr.type = 3;
                this.collect_addr.address = item.name;

                //有用户信息
                if(this.name || this.mobile){
                    this.collect_addr.name = this.name;
                    this.collect_addr.mobile = this.mobile;
                }else{
                    //取寄件
                    if(this.send_addr.name && this.send_addr.mobile){
                        this.collect_addr.name = this.send_addr.name;
                        this.collect_addr.mobile = this.send_addr.mobile;
                    }else{
                        this.collect_addr.name = '';
                        this.collect_addr.mobile = '';
                    }
                }
                this.collect_addr.real_address = item.address;
                this.collect_addr.areaId = item.areaId;
                if(this.tab == '1'){
                    this.collect_addr.addr_type = '2';
                }else if(this.tab == '2'){
                    this.collect_addr.addr_type = '5';
                }else if(this.tab == '3'){
                    this.collect_addr.addr_type = '3';
                }
                this.collect_addr.addr_id = item.id;

                if(!this.collect_addr.name || !this.collect_addr.mobile){
                    this.goView('/contact');
                }else{
                    this.goView('/');
                }
            }
        }
    },
    ready : function(){
        this.getList();
        var self = this;
        $.webService.getUserInfo().then(function(data){
            self.name = data.datas.name;
            self.mobile = data.datas.mobile;
        });
    }
});
