var send_newaddr_view = Vue.extend({
    template: '#send-newaddr',
    data : function(){
        return{
            name : '',
            mobile : '',
            addr : '',
            def : false
        }
    },
    vuex :{
        getters : {
            isJ : function(state){ return state.isJ;},
            addr_province : function(state){ return state.addr_province;},
            addr_city : function(state){ return state.addr_city;},
            addr_district : function(state){ return state.addr_district;},
            addr_street : function(state){ return state.addr_street;},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr}
        }
    },
    watch : {

    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        validate : function(){
            if(!this.name || !$.trim(this.name)) return '请填写姓名';
            if(!this.mobile || !$.comReg.isPhone(this.mobile)) return '请填写有效联系电话';
            if(!this.addr || !$.trim(this.addr)) return '请输入地址';
            return "";
        },
        save : function(){
            var vald = this.validate();
            if(vald){
                $.alert(vald); return;
            };
            var self = this;
            $.commonAjax({
                url : '/userAddress/add.api',
                type : 'POST',
                data : {
                    name : $.trim(this.name),
                    mobile : this.mobile,
                    cityName : this.addr_province + ',' + this.addr_city + ',' + this.addr_district,
                    address : $.trim(this.addr),
                    def : this.def
                },
                success : function(data){
                    if(self.isJ){
                        if(self.addr_province == self.addr_city){
                            self.send_addr.address = self.addr_city + self.addr_district + self.addr;
                        }else{
                            self.send_addr.address = self.addr_province + self.addr_city + self.addr_district + self.addr;
                        }
                        self.send_addr.name = self.name;
                        self.send_addr.mobile = self.mobile;
                        self.send_addr.areaId = data.datas.area_id;
                        self.send_addr.real_address = self.addr;
                        self.send_addr.addr_type = '4';
                        self.send_addr.addr_id = data.datas.id;
                    }else{
                        if(self.addr_province == self.addr_city){
                            self.collect_addr.address = self.addr_city + self.addr_district + self.addr;
                        }else{
                            self.collect_addr.address = self.addr_province + self.addr_city + self.addr_district + self.addr;
                        }
                        self.collect_addr.name = self.name;
                        self.collect_addr.mobile = self.mobile;
                        self.collect_addr.areaId = data.datas.area_id;
                        self.collect_addr.real_address = self.addr;
                        self.collect_addr.addr_type = '4';
                        self.collect_addr.addr_id = data.datas.id;
                    }
                    setStore('useraddr_refresh',new Date().getTime());
                    self.goView('/');
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    ready : function(){
        var self = this;
        $.commonAjax({
            url : '/user/query_user_info.api',
            loading : false,
            success : function(data){
                self.name = data.datas.name;
                self.mobile = data.datas.mobile;
            }
        });
    }
});
