var agent_newaddr_view = Vue.extend({
    template: '#agent-newaddr',
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
            isJ : function(state){ return state.isJ},
            addr_refresh : function(state){ return state.addr_refresh},
            addr_edit : function(state){return state.addr_edit},
            agent_name : function(state){return state.agent_name},
            agent_mobile : function(state){return state.agent_mobile},
            agent_userId : function(state){return state.agent_userId},
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
            if(this.isNew && (this.agent_name || this.agent_mobile)){
                this.name = this.agent_name;
                this.mobile = this.agent_mobile;
            }
        },
        save : function(){
            var vald = this.validate();
            if(vald){
                $.toast(vald); return;
            };
            this.addAddress();
            this.addrStore(this,0,this.addr_edit.areaId);

        },
        addAddress : function(){
            if(this.isNew){
                $.commonAjax({
                    url : '/userProxy/address/add.api',
                    type : 'POST',
                    data : {
                        areaId : this.addr_edit.areaId,
                        name : $.trim(this.name),
                        mobile : this.mobile,
                        cityName : this.cityName,
                        address : $.trim(this.addr),
                        def : this.def,
                        userId : this.agent_userId || 0
                    },
                    success : function(data){

                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            }else{
                $.commonAjax({
                    url : '/userProxy/address/update.api',
                    type : 'POST',
                    data : {
                        areaId : this.addr_edit.areaId,
                        id : this.addr_edit.id,
                        name : $.trim(this.name),
                        mobile : this.mobile,
                        cityName : this.cityName,
                        address : $.trim(this.addr),
                        def : this.def,
                        userId : this.agent_userId || 0
                    },
                    success : function(data){

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
        changeCity : function(){
            setStore('cityName',this.cityName);
            this.goView('/cityaddr');
        },
        addrStore : function(item,id,areaId){
            if(this.isJ){
                var send_addr = {};
                send_addr.type = 1;
                send_addr.address = item.cityName.replace(/,/g,'')  + item.addr;
                send_addr.name = item.name;
                send_addr.mobile = item.mobile;
                send_addr.areaId = areaId;
                send_addr.real_address = item.addr;
                send_addr.addr_type = '4';
                send_addr.addr_id = id;
                send_addr.cityName = item.cityName;

                setStore('send_addr',send_addr);
            }else{
                var collect_addr = {};
                collect_addr.type = 1;
                collect_addr.address = item.cityName.replace(/,/g,'')  + item.addr;
                collect_addr.name = item.name;
                collect_addr.mobile = item.mobile;
                collect_addr.areaId = areaId;
                collect_addr.real_address = item.addr;
                collect_addr.addr_type = '4';
                collect_addr.addr_id = id;
                collect_addr.cityName = item.cityName;

                setStore('collect_addr',collect_addr);
            }
            this.goView('/');
        }
    },
    ready : function(){
        this.addOrEdit(this.addr_edit);
    }
});
