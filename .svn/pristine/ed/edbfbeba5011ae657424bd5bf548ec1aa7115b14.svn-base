var address_select_view = Vue.extend({
    template : '#address_select',
    data : function(){
        return{
            court_list : [],
            court_list2 : [],
            courtK : '',
            addressType : 1,
            courseType : 1,
            showCourseType : false,
            airport_list : [],
            airportK : '',
            addr_list : [],
            addressK : '',
            prevRouteID : ''
        }
    },
    computed: {
        tab : function(){return this.$store.state.tab},
        isAddr : function(){return this.$store.state.isAddr},
        route_ident : function(){return this.$store.state.route_ident},
        label_type : function(){return this.$store.state.label_type},
        filterAddrList: function () {
            var key = this.addressK;
            var addrList = this.addr_list;
            return addrList.filter(function (item) {
                return item.cityName.indexOf(key) > -1 || item.address.indexOf(key) > -1;
            });
        },
        court_city : function(state){ return this.$store.state.court_city;},
        geo_lat : function(state){ return this.$store.state.geo_lat},
        geo_long : function(state){ return this.$store.state.geo_long},
        filterCourtList: function () {
            var key = this.courtK;
            var courtList = this.court_list;
            return courtList.filter(function (item) {
                return item.name.indexOf(key) > -1;
            });
        },
        filterCourtList2: function () {
            var key = this.courtK;
            var courtList = this.court_list2;
            return courtList.filter(function (item) {
                return item.name.indexOf(key) > -1;
            });
        },
        filterAirportList: function () {
            var key = this.airportK;
            var ariportList = this.airport_list;
            return ariportList.filter(function (item) {
                return item.name.indexOf(key) > -1;
            });
        }
    },
    methods : {
        goEdit : function(item){
            setStore('addr',item);
            router.push('/isend/address/addrs/edita');
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
        getAirport : function(){
            var self = this;
            $.commonAjax({
                url : '/comm/query_site.api',
                data :{
                    type : 1
                },
                success : function(data){
                    self.airport_list = data.datas;
                }
            });
        },
        getAddress : function(type){
            var self = this;
            self.addressType = type;
            //常用地址
            $.commonAjax({
                url : '/userAddress/list.api',
                type : 'get',
                data:{
                    labelType:type
                },
                success : function(data){
                    self.addr_list = data.datas;
                }
            });
        },
        chooseCourseType: function(type){
            this.courseType = type;
            this.showCourseType = false;
        },
        chooseTab: function(type){
            setStore('tab',type);
        },
        save : function(item,type){
            var self=this;
            //首页快捷式进入该页面，保存功能失效
            if(self.prevRouteID=="#index" || self.prevRouteID=='') return;
            if(type != 1){
                item.siteName = item.name;
                //item.name = '';
            }
            setStore('addrMsg',item);
            setStore('tabStyle',type);
            setStore('label_type',this.addressType)
            router.push('/isend/address');
        },
        addAddress: function(){
            setStore('addr',{});
            router.push('/isend/address/addrs/edita');
        },
        toDelete : function(id){
            var self = this;
            $.confirm('确定删除该地址?',function(){
                $.commonAjax({
                    url : '/userAddress/delete.api',
                    type : 'POST',
                    data : {
                        id : id
                    },
                    success : function(data){
                        self.getAddress(self.addressType);
                    },
                    error : function(err){
                        $.toast('删除地址失败');
                    }
                });
            });
        },
        goTop: function(id,def){
            var self = this;
            $.commonAjax({
                url : '/userAddress/updateUpdateTime.api',
                type : 'post',
                data : {
                    id : id,
                    def:!def
                },
                success : function(data){
                    self.getAddress(self.addressType);
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        goBack: function(){
            var self=this;
            if(self.prevRouteID=="#index")
            {
                router.push('/');
            }
            else if(self.prevRouteID=="#address")
            {
                router.push('/isend/address');
            }else if(self.prevRouteID==''){
                history.back();
            }else{

            }
        }
    },
    activated : function(){
        var self=this;
        if(self.route_ident=='#edita')
        {
            self.addressType=self.label_type;
            self.getAddress(self.addressType);
        }
        else if(self.route_ident=='#index')
        {
            self.prevRouteID='#index';
        }
        else if(self.route_ident=='#address')
        {
            self.prevRouteID='#address';
        }
        else
        {

        }
        setStore('route_ident',"#addrs");
    },
    mounted : function(){
        this.getAddress(3);
        this.getCourt(this.court_city,'');
        this.getAirport();
    }
});
