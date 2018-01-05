var address_new_view = Vue.extend({
    template: '#address-new',
    data : function(){
        return {
            name : '',
            mobile : '',
            addr : '',
            cityName : '',
            def : false,
            isNew : true
        }
    },
    vuex :{
        getters : {
            addr_refresh : function(state){ return state.addr_refresh},
            addr_edit : function(state){return state.addr_edit}
        }
    },
    watch : {
        'addr_edit' : 'addOrEdit'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        addOrEdit : function(val){
            val.name ? this.isNew = false : this.isNew = true;
            if(this.isNew){
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
        },
        goBack : function(){
            if($.ls('addr_store')){
                locationTo('index_v1.html');
            }
            this.goView('/');
        },
        save : function(){
            var vald = this.validate();
            if(vald){
                $.toast(vald); return;
            };
            var self = this;
            if(this.isNew){
                $.commonAjax({
                    url : '/userAddress/add.api',
                    type : 'POST',
                    data : {
                        name : $.trim(this.name),
                        mobile : this.mobile,
                        cityName : this.cityName,
                        address : $.trim(this.addr),
                        def : this.def
                    },
                    success : function(data){
                        if($.ls('addr_store')){
                            self.addrStore(self,data.datas.id,data.datas.area_id);
                        }else{
                            self.goList();
                        }
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            }else{
                $.commonAjax({
                    url : '/userAddress/update.api',
                    type : 'POST',
                    data : {
                        id : this.addr_edit.id,
                        name : $.trim(this.name),
                        mobile : this.mobile,
                        cityName : this.cityName,
                        address : $.trim(this.addr),
                        def : this.def
                    },
                    success : function(data){
                        if($.ls('addr_store')){
                            self.addrStore(self,self.addr_edit.id,self.addr_edit.areaId);
                        }else{
                            self.goList();
                        }
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            }

        },
        validate : function(){
            if(!this.name || !$.trim(this.name)) return '请填写姓名';
            if(!this.mobile || !$.comReg.isPhone(this.mobile)) return '请填写有效联系电话';
            if(!this.cityName) return '请填写选择地区';
            if(!this.addr || !$.trim(this.addr)) return '请输入地址';
            return "";
        },
        delete : function(){
            var self = this;
            $.confirm('确定删除该地址?',function(){
                $.commonAjax({
                    url : '/userAddress/delete.api',
                    type : 'POST',
                    data : {
                        id : self.addr_edit.id
                    },
                    success : function(data){
                        self.goList();
                    },
                    error : function(err){
                        $.toast('删除地址失败');
                    }
                });
            });
        },
        changeCity : function(){
            setStore('cityName',this.cityName);
            this.goView('/city');
        },
        goList : function(){
            setStore('addr_refresh',this.addr_refresh + 1);
            this.goView('/');
        },
        addrStore : function(item,id,areaId){
            var store = JSON.parse($.ls('addr_store'));
            if(store.isJ){
                var send_addr = store.send_addr;
                send_addr.type = 1;
                send_addr.address = item.cityName.replace(/,/g,'')  + item.addr;
                send_addr.name = item.name;
                send_addr.mobile = item.mobile;
                send_addr.areaId = areaId;
                send_addr.real_address = item.addr;
                send_addr.addr_type = '4';
                send_addr.addr_id = id;

                store.send_addr = send_addr;
                $.ls('addr_store',JSON.stringify(store));
            }else{
                var collect_addr = store.collect_addr;
                collect_addr.type = 1;
                collect_addr.address = item.cityName.replace(/,/g,'')  + item.addr;
                collect_addr.name = item.name;
                collect_addr.mobile = item.mobile;
                collect_addr.areaId = areaId;
                collect_addr.real_address = item.addr;
                collect_addr.addr_type = '4';
                collect_addr.addr_id = id;

                store.collect_addr = collect_addr;
                $.ls('addr_store',JSON.stringify(store));
            }
            locationTo('index_v1.html');
        }
    },
    ready : function(){
        if($.ls('newaddr')){
            setStore('addr_edit',{'cityName':''});
            $.ls('newaddr','');
        }else if($.ls('editaddr')){
            setStore('addr_edit',JSON.parse($.ls('editaddr')));
            $.ls('editaddr','');
        }
        this.addOrEdit(this.addr_edit);
    }
});
