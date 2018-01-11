var agent_address_his_select_view = Vue.extend({
    template: '#agent_address_his_select',
    data: function () {
        return {
            addressType: 1,
            addr_list: [],
            addressK: '',
            prevRouteID: ''
        }
    },
    computed: {
        //tab : function(){return this.$store.state.tab},
        //isAddr : function(){return this.$store.state.isAddr},
        route_ident: function () {
            return this.$store.state.route_ident
        },
        label_type: function () {
            return this.$store.state.label_type
        },
        filterAddrList: function () {
            var key = this.addressK;
            this.addr_list.forEach(function (item) {

            })
            var addrList = this.addr_list;
            return addrList.filter(function (item) {
                return item.cityName.indexOf(key) > -1 || item.address.indexOf(key) > -1 || item.addressName.indexOf(key) > -1;
            });
        }
    },
    methods: {
        getAddress: function (type) {
            var self = this;
            self.addressType = type;
            //常用地址
            $.commonAjax({
                url: '/order/findAddressHistoryById.api',
                type: 'get',
                // data:{
                //     labelType:type
                // },
                success: function (data) {
                    if(!data.datas||data.datas.length<=0){
                        return;
                    }
                    var addrList = data.datas;
                    addrList.forEach(function (item) {
                        var isExist = self.isAddressExist(item);
                        if (!isExist.jExist) {
                            self.addr_list.push({
                                "addressId": item.jAddrId,
                                "treeId": item.jtreeId,
                                "addressType": item.jAddrType,
                                "address": item.jAddress,
                                "addressName": item.jAddressName,
                                "areaId": item.jAreaId,
                                "cityName": item.jCityName,
                                "isOutRange": item.jOutRangeType,
                                "type": "发件地址"
                            });
                        }

                        if (!isExist.dExist) {
                            self.addr_list.push({
                                "addressId": item.dAddrId,
                                "treeId": item.dtreeId,
                                "addressType": item.dAddrType,
                                "address": item.dAddress,
                                "addressName": item.dAddressName,
                                "areaId": item.dAreaId,
                                "cityName": item.dCityName,
                                "isOutRange": item.dOutRangeType,
                                "type": "收件地址"
                            });
                        }
                    });
                }
            });
        },
        //历史地址是否已存在
        isAddressExist: function (item) {
            var isExist = {"jExist": false, "dExist": false};
            this.addr_list.forEach(function (existItem) {
                if (item.jAddrType == existItem.addressType && item.jAddress == existItem.address &&
                    item.jAddressName == existItem.addressName && item.jAreaId == existItem.areaId
                    && item.jCityName == existItem.cityName) {
                    isExist.jExist = true;
                }
                if (item.dAddrType == existItem.addressType && item.dAddress == existItem.address &&
                    item.dAddressName == existItem.addressName && item.dAreaId == existItem.areaId
                    && item.dCityName == existItem.cityName) {
                    isExist.dExist = true;
                }
            })

            return isExist;
        },
        save: function (item) {
            var self = this;
            //首页快捷式进入该页面，保存功能失效
            //if (self.prevRouteID == "#index" || self.prevRouteID == '') return;

            var itemData = {};
            //1 输入地址  2 球场地址
            var type = 1;
            //球场的情况下
            if (item.addressType == 1) {
                itemData = {
                    "id": item.addressId,
                    "areaId": item.areaId,
                    "address": item.address,
                    "name": item.addressName,
                    "isOutRange": item.isOutRange,
                    "siteName": item.addressName,
                };
                type = 2;
            } else {
                itemData = {
                    "areaId": item.areaId,
                    "treeId": item.treeId,
                    "cityName": item.cityName,
                    "isOutRange": item.isOutRange,
                    "siteName": item.addressName,
                    "address": item.address,
                };
                type = 1;
            }
            //console.log(itemData);
            setStore('addrMsg', itemData);
            setStore('tabStyle', type);
            router.push('/agent_address');
        },
        goBack: function () {
            router.push('/agent_address');
        }
    },
    activated: function () {
        var self = this;
        if (self.route_ident == '#agent_edita') {
            self.addressType = self.label_type;
            self.getAddress(self.addressType);
        }
        // else if(self.route_ident=='#index')
        // {
        //   self.prevRouteID='#index';
        // }
        else if (self.route_ident == '#agent_address') {
            self.prevRouteID = '#agent_address';
        }
        else {

        }
        setStore('route_ident', "#agent_addrs_his");
    },
    mounted: function () {
        this.getAddress(3);
    }
});
