var home_view = Vue.extend({
    data: function () {
        return {
            transportCount: 0, //运输中的数量
            unpayCount: 0, //未支付的数量
            unsignCount: 0, //未送达的数量
            waitCount: 0, //待取件数量
            showPop: false,
            message: {},
            allMessage: [],
            fbaseUrl: '',
            advertImg: [],
            call: false,
            showPopTitle: false,
            allReminders: []
        }
    },
    template: '#index',
    methods: {
        // 图片轮播
        getImg: function () {
            var self = this;
            self.advertImg = [];
            $.commonAjax({
                url: '/baseAdvert/listByCode.api',
                data: {
                    code: "wx_home",
                    flatType: 2 // 1PC 2微信
                },
                type: 'get',
                success: function (data) {
                    if (data.datas.imageVoList.length > 0) {
                        for (var i = 0; i < data.datas.imageVoList.length; i++) {
                            self.advertImg.push({url: '', img: ''});
                            self.advertImg[i].img = $.fbaseUrl + data.datas.imageVoList[i].image;
                            self.advertImg[i].url = data.datas.imageVoList[i].url;
                        }
                    }
                }
            })
        },
        goView: function (view, orderStatus) {
            orderStatus && setStore('orderStatus', orderStatus);
            router.push(view);
        },
        getUserInfo: function () {
            $.commonAjax({
                url: '/user/query_user_info.api',
                data: {},
                type: 'get',
                success: function (data) {
                    var userInfo = {
                        name: data.datas.name,
                        mobile: data.datas.mobile
                    };
                    setStore('user_info', userInfo);
                }
            });
        },
        sendBag: function () {
            var self = this;
            $.commonAjax({
                url: '/order/v2/lastOrder.api',
                data: {},
                success: function (data) {
                    var datas = data.datas;
                    if (datas == null || datas.length == 0) {
                        // self.goView('/isend');
                        //第一次使用调用个人信息 名字和电话
                        self.sendBagFirstTime();
                    } else {
                        //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
                        var send_addr = {
                                type: 1,
                                name: datas.jContact,
                                mobile: datas.jMobile,
                                address: datas.jAddress,
                                real_address: '',
                                treePath: datas.jTreePath,
                                areaId: datas.jAreaId,
                                addr_type: datas.jAddrType,
                                addr_id: datas.jAddrId,
                                remark: '',
                                tabStyle: datas.jAddrType == 1 ? 2 : datas.jAddrType == 2 ? 3 : datas.jAddrType == 4 ? 1 : '',
                                treeId: datas.jTreeId,
                                label_type: datas.jLabelType,
                                siteName: datas.jAddrName,
                                isOutRange: datas.jIsOutRange,
                                //该id字段只要用于处理address页面确定取值问题
                                id: datas.jAddrId
                            },
                            collect_addr = {
                                type: 1,
                                name: datas.dContact,
                                mobile: datas.dMobile,
                                address: datas.dAddress,
                                real_address: '',
                                treePath: datas.dTreePath,
                                areaId: datas.dAreaId,
                                addr_type: datas.dAddrType,
                                addr_id: datas.dAddrId,
                                remark: '',
                                tabStyle: datas.dAddrType == 1 ? 2 : datas.dAddrType == 2 ? 3 : datas.dAddrType == 4 ? 1 : '',
                                treeId: datas.dTreeId,
                                label_type: datas.dLabelType,
                                siteName: datas.dAddrName,
                                isOutRange: datas.dIsOutRange,
                                //该id字段只要用于处理address页面确定取值问题
                                id: datas.dAddrId
                            };
                        setStore('send_addr', send_addr);
                        setStore('collect_addr', collect_addr);
                        self.goView('/send');
                    }
                },
                error: function (err) {
                    $.toast(err);
                }
            });
            return;
        },
        //type=1时处理未支付订单；type=2处理待取件或未送达订单
        goViewUnpay: function (type) {
            var self = this;
            if (type == 1) {
                if (self.unpayCount == 0) return;
                self.goView('/order', 1);
            } else if (type == 2) {
                if (self.transportCount == 0 && self.waitCount == 0) {
                    return;
                } else if (self.transportCount == 0 && self.waitCount != 0) {
                    self.goView('/order', 4);
                } else if (self.transportCount != 0 && self.waitCount == 0) {
                    self.goView('/order', 2);
                }
                else if (self.transportCount != 0 && self.waitCount != 0) {
                    self.goView('/order', 2);
                }
                else {
                }

            } else {

            }

        },
        goAddress: function () {
            setStore('isAddr', true);
            setStore('tab', 1);
            router.push('/isend/address/addrs');
        },
        getDealNum: function () {
            var self = this;
            $.commonAjax({
                url: '/order/v2/orderCount.api',
                type: 'get',
                data: {},
                success: function (data) {
                    self.transportCount = data.datas.transportCount;
                    self.unpayCount = data.datas.unpayCount;
                    self.unsignCount = data.datas.unsignCount;
                    self.waitCount = data.datas.waitCount;
                }
            });
        },
        baggage: function () {
            location.href = "tel:400-609-0990";
            //$.toast('寄行李服务稍后推出！');
        },
        getMessage: function () {
            var self = this;
            $.commonAjax({
                url: '/index/pop.api',
                type: 'post',
                data: {
                    type: 1,
                    id: 0,
                    platform: 1
                },
                success: function (data) {
                    self.allMessage = data.datas;
                    if (data.datas.length > 0) {
                        self.message = data.datas[0];
                        self.allMessage.splice(0, 1);
                        self.showPop = true;
                    }
                }
            });
        },
        closePop: function () {
            if (this.allMessage.length > 0) {
                this.message = this.allMessage[0];
                this.allMessage.splice(0, 1);
            }
            else {
                this.showPop = false;
            }
        },
        // QBT-22
        goOrderList: function () {
            this.goV2Nav("index.html", "/order");
        },
        // QBT-22
        goV2Nav: function (url, hach) {
            var _url = location.href;
            _url = _url.replace(location.hash, '');
            var index = _url.indexOf('?');
            var hx = "";
            hach && (hx = hach);
            if (index == -1) {
                location.href = _url + '?_r=' + $.version;
            } else {
                location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1) + '#' + hx;
            }
        },
        showPopup: function (reminderId) {
            var self = this
            // self.allMessage = data.datas;
            // if(data.datas.length>0){
            //     self.message = data.datas[0];
            //     self.allMessage.splice(0,1);
            //     // moooooo
            //     self.showPop = true;
            // }
            var reminders = this.allReminders;
            for (var key in reminders) {
                var row = reminders[key];
                if (row.id === reminderId) {
                    if(row.description&&row.description.trim()!=""){
                        layer.open({
                            // title: row.name,
                            content: row.description,
                            btn : '确定',
                            shadeClose: true,
                            className: 'layer_alert_home',

                        });
                    }

                    // self.showPopTitle = true;
                    //  self.message.title = row.name;
                    //  self.message.contentType = 1;
                    //  self.message.content = row.description;
                    //  self.showPop = true;
                    return;
                }
            }
        },
        getReminderList: function () {
            var self = this;
            $.commonAjax({
                url: '/reminder/list.api',
                type: 'get',
                success: function (data) {
                    // self.allMessage = data.datas;
                    // if(data.datas.length>0){
                    //     self.message = data.datas[0];
                    //     self.allMessage.splice(0,1);
                    //     // moooooo
                    //     self.showPop = true;
                    // }
                    if (data.datas.length > 0) {
                        self.allReminders = data.datas;
                    }
                    // self.showPopTitle = true;
                    // self.message.title = '便捷'
                    // self.message.contentType = 1
                    // self.message.content = '我是一家便捷公司，我们是一家快捷公司我们是一家快捷公司我们是一家快捷公司我们是一家快捷公司我们是一家快捷公司我们是一家快捷公'
                    // self.showPop = true;
                }
            });
        },
        sendBagFirstTime: function () {
            var self = this;
            $.commonAjax({
                url: '/user/query_user_info.api',
                data: {},
                success: function (data) {
                    var datas = data.datas;
                    if (datas == null || datas.length == 0) {
                        self.goView('/send');
                    } else {
                        //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
                        var send_addr = {
                                type: 1,
                                name: datas.name,
                                mobile: datas.mobile
                            },
                            collect_addr = {
                                type: 1,
                                name: datas.name,
                                mobile: datas.mobile
                            };
                        setStore('send_addr', send_addr);
                        setStore('collect_addr', collect_addr);
                        self.goView('/send');
                    }
                },
                error: function (err) {
                    $.toast(err);
                }
            });
            return;
        },
    },
    activated: function () {
        this.getDealNum();
        this.getImg();
        setStore('route_ident', "#index");
    },
    mounted: function () {
        this.fbaseUrl = $.fbaseUrl;
        this.getMessage();
        this.getUserInfo();
        this.getReminderList();
    }
});
