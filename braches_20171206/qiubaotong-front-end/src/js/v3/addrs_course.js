var address_course_select_view = Vue.extend({
    template: '#address_course_select',
    data: function () {
        return {
            court_list: [],
            //球场搜索
            courtK: '',
            addressType: 1,
            addressK: '',
            prevRouteID: '',
            //历史订单城市
            historyCity: [],
            //热门城市
            hotCity: [],
            //当前是否选中头部热门城市或历史订单城市ID
            citySelectId: null,
            citySelectName: null,
            //选中城市球场列表
            cityCourseList: new Array()
        }
    },
    computed: {

        route_ident: function () {
            return this.$store.state.route_ident
        },
        label_type: function () {
            return this.$store.state.label_type
        },

        court_city: function (state) {
            return this.$store.state.court_city;
        },
        geo_lat: function (state) {
            return this.$store.state.geo_lat
        },
        geo_long: function (state) {
            return this.$store.state.geo_long
        },
        filterCourtList: function () {
            var key = this.courtK;
            //var courtList = this.court_list;
            var filterList = [];
            //循环所有省份
            this.court_list.forEach(function (item) {
                item.courseAddressVoList.forEach(function (subItem) {
                    if (subItem.name.indexOf(key) > -1) {
                        filterList.push(subItem);
                    }
                })
            })
            return filterList;
        },

        cityCourse: function () {
            return this.cityCourseList;
        }


        // filterCourtList2: function () {
        //     var key = this.courtK;
        //     var courtList = this.court_list2;
        //     return courtList.filter(function (item) {
        //         return item.name.indexOf(key) > -1;
        //     });
        // }

    },
    methods: {
        getCourt: function (city, query) {
            var self = this;
            // $.commonAjax({
            //     url : '/comm/query_course.api',
            //     data :{
            //         city_name : city,
            //         lon : self.geo_long,
            //         lat : self.geo_lat,
            //         name : query,
            //         isPractice : 0
            //     },
            //     success : function(data){
            //         self.court_list = data.datas;
            //     },
            //     error : function(err){
            //         $.toast(err);
            //     }
            // });

            $.commonAjax({
                url: '/courseAddress/list.api',
                data: {
                    // city_name : city,
                    lon: self.geo_long,
                    lat: self.geo_lat,
                    //  name : query,
                    //  isPractice : 0
                },
                success: function (data) {
                    self.court_list = data.datas.provincesVo.provinceVoList;
                    console.log(self.court_list);
                    //初始设置第一个省份展开
                    self.expandProvince();
                    //历史订单城市
                    self.historyCity = data.datas.historyOrderCitiesVo.historyOrderCityVoList;
                    //热门城市
                    self.hotCity = data.datas.citiesVo.cityVoList;
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        },

        //根据城市id获取城市下的球场
        getCourseByCity: function (cityId) {
            var self = this;
            $.commonAjax({
                url: '/courseAddress/findByCityId.api?',
                data: {
                    lon: self.geo_long,
                    lat: self.geo_lat,
                    cityId: cityId
                },
                success: function (data) {
                    self.cityCourseList = data.datas;
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        },

        //展开省份
        expandProvince: function (itemNode) {
            //本来是展开的
            if (itemNode && itemNode.isExpand) {
                //收缩当前省份
                Vue.set(itemNode, 'isExpand', false);
                return;
            }
            //循环所有省份
            this.court_list.forEach(function (item, index) {

                //默认全部不展开
                Vue.set(item, 'isExpand', false);
                //初始展开第一个省份
                if (!itemNode && index == 0) {
                    Vue.set(item, 'isExpand', true);
                }
                //点击展开相应省份
                if (itemNode && item.id == itemNode.id) {
                    Vue.set(item, 'isExpand', true);
                }
            });
        },

        //热门城市、历史城市、国内城市选择
        citySelect: function (isCity, id, name) {
            if (isCity) {
                this.citySelectId = id;
                this.citySelectName = name;
                this.getCourseByCity(id);
            } else {
                this.citySelectId = null;
                this.citySelectName = null;
            }
        },

        save: function (item, type) {
            var self = this;
            //首页快捷式进入该页面，保存功能失效
            if (self.prevRouteID == "#index" || self.prevRouteID == '') return;
            if (type != 1) {
                item.siteName = item.name;
                //item.name = '';
            }

            //复制对象以防止对象被修改影响列表显示
            setStore('addrMsg', $.extend({}, item));
            setStore('tabStyle', type);
            setStore('label_type', this.addressType)
            router.push('/isend/address');
        },
        goBack: function () {
            var self = this;
            if (self.prevRouteID == "#index") {
                router.push('/');
            }
            else if (self.prevRouteID == "#address") {
                router.push('/isend/address');
            } else if (self.prevRouteID == '') {
                history.back();
            } else {

            }
        }
    },
    activated: function () {
        var self = this;
        if (self.route_ident == '#edita') {
            self.addressType = self.label_type;
            self.getAddress(self.addressType);
        }
        else if (self.route_ident == '#index') {
            self.prevRouteID = '#index';
        }
        else if (self.route_ident == '#address') {
            self.prevRouteID = '#address';
        }
        else {

        }
        //每次激活清空球场搜索关键字
        self.courtK = "";
        setStore('route_ident', "#address_course");
    },
    mounted: function () {
        this.getCourt(this.court_city, '');
    }
});
