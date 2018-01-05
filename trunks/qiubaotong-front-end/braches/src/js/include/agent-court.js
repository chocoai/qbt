var agent_court_view = Vue.extend({
    template: '#agent-court',
    data : function(){
        return{
            tab : 1,
            court_list : [],
            court_list2 : [],
            search : '',
            keyword : '',
            desc1 : 1,
            desc2 : 1
        }
    },
    vuex :{
        getters : {
            isJ : function(state){ return state.isJ;},
            court_city : function(state){ return state.court_city;},
            geo_city : function(state){ return state.geo_city;},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr},
            court_search_type : function(state){ return state.court_search_type},
            geo_lat : function(state){ return state.geo_lat},
            geo_long : function(state){ return state.geo_long},
            agent_name : function(state){return state.agent_name},
            agent_mobile : function(state){return state.agent_mobile}
        }
    },
    watch : {
        'court_city' : function(val){
            if(val){
                this.getCourt(val,'');
            }
        },
        'search' : function(val){
            if(val){
                this.getCourt('',val);
            }else{
                this.court_list = [];
                this.court_list2 = [];
            }
        },
        'court_search_type' : function(val){
            if(val == '2'){
                this.court_list = [];
                this.court_list2 = [];
            }
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getCourt : function(city,query){
            var self = this;
            $.commonAjax({
                url : '/comm/query_course.api',
                data :{
                    city_name : city,
                    lon : self.geo_long,
                    lat : self.geo_lat,
                    name : query,
                    isPractice : 0
                },
                success : function(data){
                    self.court_list = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
            $.commonAjax({
                url : '/comm/query_course.api',
                data :{
                    city_name : city,
                    lon : self.geo_long,
                    lat : self.geo_lat,
                    name : query,
                    isPractice : 1
                },
                success : function(data){
                    self.court_list2 = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        toggleTab : function(tab){
            if(this.tab == tab){
                if(tab == 1){
                    this.desc1 = this.desc1 * -1;
                }
                if(tab == 2){
                    this.desc2 = this.desc2 * -1;
                }
            }else{
                this.tab = tab;
            }
        },
        save : function(item){
            if(this.isJ){
                this.send_addr.type = 2;
                this.send_addr.address = item.name;

                if(!this.send_addr.name && !this.send_addr.mobile){
                    //有用户信息
                    if(this.agent_name || this.agent_mobile){
                        this.send_addr.name = this.agent_name;
                        this.send_addr.mobile = this.agent_mobile;
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
                }
                this.send_addr.real_address = item.address;
                this.send_addr.areaId = item.areaId;
                this.send_addr.addr_type = '1';
                this.send_addr.addr_id = item.id;
                //提示
                this.send_addr.remark = (item.isOutRange && item.isTip) ? item.wechatTip : '';

                if(!this.send_addr.name || !this.send_addr.mobile){
                    this.goView('/contact');
                }else{
                    this.goView('/');
                }
            }else{
                this.collect_addr.type = 2;
                this.collect_addr.address = item.name;

                if(!this.collect_addr.name && !this.collect_addr.mobile){
                    //有用户信息
                    if(this.agent_name || this.agent_mobile){
                        this.collect_addr.name = this.agent_name;
                        this.collect_addr.mobile = this.agent_mobile;
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
                }

                this.collect_addr.real_address = item.address;
                this.collect_addr.areaId = item.areaId;
                this.collect_addr.addr_type = '1';
                this.collect_addr.addr_id = item.id;
                //提示
                this.collect_addr.remark = (item.isOutRange && item.isTip) ? item.wechatTip : '';

                if(!this.collect_addr.name || !this.collect_addr.mobile){
                    this.goView('/contact');
                }else{
                    this.goView('/');
                }
            }
        }
    },
    route : {
        data : function(transition){
            this.search = '';
            this.keyword = '';
        }
    },
    ready : function(){
        if(this.court_search_type == '1'){
            this.getCourt(this.court_city,'');
        }
    }
});
