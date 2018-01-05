/**
 * Created by Administrator on 2017/8/9.
 */
var agent_send_view = Vue.extend({
    template: '#agent_send',
    data: function () {
        return {
            title1: '取包时间',
            quantity: 1, //数量
            money: '1',
            timeList: [],
            timeValue: [],

            min: 0,
            amount_bj: 0, //保价费用
            amount_yf: 0, //球包实价(或是优惠价)
            amount_op: 0, //球包原价
            amount_py: 0, //球包偏远费
            amount_dis: 0, //优惠金额
            expect_times: [],
            expect_selected: {},
            // isVip : false, // 是否会员
            // choseVip : false, // 检查是否会员
            showNum: false,
            showInsure: false,
            showUseDiscount: false,
            showDeliver: false,

            selectMebPoint: false,

            // coupon_count : 0, // 优惠码
            discountType: 0,//1-优惠券优惠 2-会员卡优惠 3-机构群会员优惠
            // vipCodes : [],
            // coupCode : '', // 优惠码

            // vipList : [],
            orderAmount: 0,

            pop_num: 1,
            pop_remark: '',
            pop_num_input: '',

            pop_insure: 1,
            pop_insure_input: 1,
            pop_insure_money: 0,
            pop_insure_money_org: 0,// 保价费用

            // coupon_data : "",// 优惠券

            limitHourValue: "",
            start_date: '',

            isF: true,
            requiredRemark: false,
            showAmountDetails: false,
            showUrgent: false,
        }
    },
    computed: {
        send_addr: function () {
            return this.$store.state.send_addr
        },
        collect_addr: function () {
            return this.$store.state.collect_addr
        },
        route_ident: function () {
            return this.$store.state.route_ident
        },
        isHelp: function () {
            return this.$store.state.isHelp
        },// 判断是代下单还是自下单
        agentId: function () {
            return this.$store.state.agentId
        },
        proxyId: function () {
            return this.$store.state.proxyId
        },
        // route_ident : function(){return this.$store.state.route_ident},
        // 没有优惠
        totalAmt: function () {
            var self = this;
            var _totalAmt = (self.amount_bj + self.amount_yf) * self.quantity // - amount_dis;
            return _totalAmt;
        },
        //按价格排序
        expect_times_show: function () {
            return this.expect_times.sort(function (x, y) {
                return x.origin_price < y.origin_price
            });
        }

    },
    watch: {
        'timeValue': 'getAmount',
        'send_addr.address': 'getAmount',
        // 'pop_insure' : function(val){
        //   if(val != -1){
        //     this.pop_insure_input='';
        //     this.money=val;
        //     this.getPrice(val);
        //   }
        // },
        //监听保价金额 发生变化时重新请求获取保价费用
        'pop_insure_input': function (val, oldVal) {
            var self = this;
            if (val === '' || val === 0) {
                self.pop_insure_input = 0;
                self.pop_insure_money = 0;
                self.pop_insure_money_org = 0;
                self.money = 0;
                self.amount_bj = 0;
                //window.pop_insure = self.pop_insure;
                window.pop_insure_input = self.pop_insure_input;
                return;
            }
            var newVal = parseInt(val);
            self.pop_insure_input = newVal;
            self.money = newVal;
            //获取保价费用
            self.getPrice(newVal);
            //self.amount_bj = self.pop_insure_money;
            //window.pop_insure = self.pop_insure;
            //window.pop_insure_input = self.pop_insure_input;
        },
        'expect_selected': function (newVal, oldVal) {
            newVal.deliver_time && (this.selHourValue = this.start_date = newVal.deliver_time.split(',')[1]);
            // this.start_date = newVal.deliver_time.split(',')[1];
            // this.min_hour = this.start_date.split(' ')[1].split(':')[0];
            this.limitHourValue = "";
        },
        //监听球包数量
        'quantity': function (val) {
            var self = this;
            self.quantity = parseInt(val);
            //球包数据大于99
            if (self.quantity > 99) {
                self.quantity = 99;
            }
            //球包数据小于等于0
            if (self.quantity <= 0) {
                self.quantity = 1;
            }
            // self.confirmNum();
            //每次选球包数量的时候，将本地的会员优惠和优惠券优惠置空
            self.amount_dis = 0;
            self.coupon_data = '';
            if (self.quantity > 1 && (!self.pop_remark || self.pop_remark.trim() == "")) {
                self.requiredRemark = true;
                return;
            }
            self.showNum = false;
            self.requiredRemark = false;
        },
        //监听备注
        'pop_remark': function (val) {
            //console.log(quantity);
            if (this.quantity > 1 && (!val || val.trim() == "")) {
                this.requiredRemark = true;
                return;
            }
            //console.log(val);
            this.requiredRemark = false;
        },
    },
    methods: {
        goView: function (view) {
            router.push(view);
        },
        goAddr: function (isJ) {
            var self = this;
            setStore('isJ', isJ);
            if (isJ == true) {
                setStore('tabStyle', this.send_addr.tabStyle);
            } else {
                setStore('tabStyle', this.collect_addr.tabStyle);
            }
            this.goView('/agent_address');
        },
        getTime: function (fn) {
            var _this = this;
            $.commonAjax({
                url: '/index/time.api',
                success: function (data) {
                    var list = [];
                    data.datas.forEach(function (item) {
                        var obj = {
                            name: item.day,
                            value: item.day,
                            parent: 0
                        };
                        list.push(obj);
                        item.items.forEach(function (subitem) {
                            var subobj = {
                                name: subitem,
                                value: subitem,
                                parent: item.day
                            }
                            list.push(subobj);
                        });
                    });
                    _this.timeList = list;
                    _this.timeValue = [data.datas[0].day, data.datas[0].items[0]];
                    fn && fn();
                },
                error: function () {
                    $.toast(err);
                }
            });
        },
        //获取保价费和原保价费
        getPrice: function (val, callback) {
            var _this = this;
            //获取保价费用
            $.commonAjax({
                url: '/index/insure.api',
                data: {
                    price: val
                },
                //async: false,
                success: function (data) {
                    //设置保价费用
                    _this.pop_insure_money = data.datas;
                    _this.amount_bj = data.datas;
                    callback && callback();
                },
                error: function (err) {
                    $.toast(err);
                    _this.money = 0;
                    _this.amount_bj = 0;
                    _this.pop_insure_input = 0;
                    _this.pop_insure_money = 0;
                    _this.pop_insure_money_org = 0;
                }
            });
            //获取保价原费用
            $.commonAjax({
                url: '/index/insure_origin.api',
                data: {
                    price: val
                },
                success: function (data) {
                    _this.pop_insure_money_org = data.datas;
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        },
        getAmount: function () {
            if (!this.send_addr.areaId||!this.send_addr.address ||!this.collect_addr.areaId|| !this.collect_addr.address || !this.timeValue.length < 0) {
                return;
            }

            var self = this;
            $.commonAjax({
                url: '/comm/v2/query_sf_recive_time.api',
                type: 'POST',
                data: {
                    business_type: '0',
                    consigned_time: self.timeValue.join(' ').substr(0, 16) + ':00',
                    src_address: self.send_addr.address,
                    src_area_id: self.send_addr.areaId,
                    dest_address: self.collect_addr.address,
                    dest_area_id: self.collect_addr.areaId,
                    src_course_id: self.send_addr.addr_type == '1' ? self.send_addr.addr_id : '',
                    dest_course_id: self.collect_addr.addr_type == '1' ? self.collect_addr.addr_id : ''
                },
                success: function (data) {
                    if (data.datas && data.datas.length > 0) {
                        //默认选中费用类型
                        var defaultIndex=0;
                        var hasUrgent=false;
                        data.datas.forEach(function (i) {
                            i.checked = false;
                            //存在加急费
                            if(i.business_type=="3"){
                                defaultIndex=1;
                                hasUrgent = true;
                            }
                        });
                        self.showUrgent=hasUrgent;
                        data.datas[defaultIndex].checked = true;
                        self.expect_times = data.datas;
                        self.expect_selected = data.datas[defaultIndex];
                        self.amount_yf = data.datas[defaultIndex].sf_price;
                        self.amount_op = data.datas[defaultIndex].origin_price;
                        self.amount_py = data.datas[defaultIndex].out_range_price;
                        //self.getUrgent();
                    } else {
                        self.expect_times = [];
                        self.expect_selected = {};
                        self.amount_yf = 0;
                        self.amount_op = 0;
                        self.amount_py = 0;
                        self.showUrgent = false;
                    }

                },
                error: function (err) {
                    self.expect_times = [];
                    self.expect_selected = {};
                    self.amount_yf = 0;
                    self.showUrgent = false;
                    $.toast(err);
                }
            });
        },
        save: function () {
            var self = this;
            if (self.send_addr.address == "") {
                $.toast("请先选择寄件人信息");
                return
            }
            else if (self.collect_addr.address == "") {
                $.toast("请先选择收件人信息");
                return
            }
            else if (self.quantity == 0) {
                $.toast("请先选择球包数量！");
                return
            }
            else if (self.quantity > 1 && self.pop_remark.trim() == "") {
                $.toast('请填写备注信息');
                return;
            }
            else {
            }
           // (self.send_addr.tabStyle == 1) && self.saveAddress(self.send_addr);
           // (self.collect_addr.tabStyle == 1) && self.saveAddress(self.collect_addr);
            var mdata = {
                business_type: this.expect_selected.business_type,
                consigned_time: this.timeValue.join(' '),
                deliver_time: this.expect_selected.deliver_time.split(',')[1],
                src_address: this.send_addr.address,
                src_area_id: this.send_addr.areaId,
                dest_address: this.collect_addr.address,
                dest_area_id: this.collect_addr.areaId,
                src_type: this.send_addr.addr_type,
                src_id: this.send_addr.addr_id,
                src_moibile: this.send_addr.mobile,
                src_name: $.trim(this.send_addr.name),
                dest_type: this.collect_addr.addr_type,
                dest_id: this.collect_addr.addr_id,
                dest_moibile: this.collect_addr.mobile,
                dest_name: $.trim(this.collect_addr.name),
                price: this.totalAmt,
                insure_price: this.money,
                quantity: this.quantity,
                remark: this.pop_remark,
                playTime: this.limitHourValue,
                create_method: 2,
                // proxyUserId : this.proxyId, // 销售的id
                userId: this.agentId || 0 // 客户的id
            };
            $.commonAjax({
                url: '/order/v2/confirm_order.api',
                type: 'POST',
                data: mdata,
                success: function (data) {
                    router.push('/agent_pay/' + data.datas);
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        },
        goCoupon: function () {
            if (this.quantity == 0) {
                $.toast("请先选择球包数量！");
                return;
            }
            //if(this.coupon_count == 0) return;
            this.isCheck = false;
            window.sendTotal = (this.amount_bj + this.amount_yf) * this.quantity;
            router.push('/send/coupon');
        },
        confirmNum: function () {
            var self = this;
            if (self.pop_num > 1 && self.pop_remark == "") {
                $.toast('请填写备注信息');
                return;
            }
            self.quantity = self.pop_num;
            self.showNum = false;
        },
        callCust: function () {
            this.showNum = false;
            location.href = "tel:400-609-0990";
        },
        showBagNum: function () {
            var self = this;
            self.pop_num = self.quantity;
            self.showNum = true
        },
        // confirmInsure: function () {
        //     var self = this;
        //     if (self.pop_insure == -1) {
        //         if (!self.pop_insure_input) {
        //             $.toast('请输入球包保价额');
        //             return;
        //         }
        //         self.money = self.pop_insure_input;
        //     } else {
        //         self.money = self.pop_insure;
        //     }
        //     self.amount_bj = self.pop_insure_money;
        //     window.pop_insure = self.pop_insure;
        //     window.pop_insure_input = self.pop_insure_input;
        //     self.showInsure = false;
        // },
        // _showInsure: function () {
        //     if (this.quantity == 0) {
        //         $.toast("球包数量不能为0！");
        //         return;
        //     }
        //     ;
        //     this.showInsure = true;
        // },
        showDeliverPop: function () {
            if (this.expect_times.length > 0) {
                this.showDeliver = true;
            }
        },
        // 点击选择时效
        confirmDeliver: function () {
            var _this = this;
            //每次选送达时间是，将本地的会员优惠和优惠券优惠置空
            // _this.amount_dis=0;
            // _this.coupon_data='';
            _this.isCheck = false;
            this.expect_times.forEach(function (i) {
                if (i.checked) {
                    _this.expect_selected = i;
                    _this.amount_yf = i.sf_price;
                    _this.amount_op = i.origin_price;
                    _this.amount_py = i.out_range_price;
                }
            });
            this.showDeliver = false;
        },
        checkDeliver: function (item) {
            this.expect_times.forEach(function (i) {
                i.checked = false;
            });
            item.checked = true;
        },
        change: function () {
            var contain_send = $.extend(this.send_addr, {});
            var contain_collect = $.extend(this.collect_addr, {});
            setStore('send_addr', contain_collect);
            setStore('collect_addr', contain_send);
        },
        memberPre: function () {
            var self = this;
            if (self.quantity == 0) {
                $.toast("球包数量不能为0！");
                return;
            }
            ;
            if (self.amount_dis == 0) {
                self.selectMebPoint = false;
                // self.vipList.map(function(m){m.checked=false;});
            }
            self.showUseDiscount = true;
        },
        saveAddress: function (obj) {
            var self = this;
            $.commonAjax({
                url: '/userProxy/address/add.api',
                type: 'POST',
                data: {
                    name: "",
                    mobile: "",
                    areaId: obj.areaId,
                    address: obj.address,
                    userId: self.agentId,
                    cityName: '',
                    def: false,
                    labelType: obj.label_type
                },
                success: function (data) {
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        },
        clearLimit: function () {
            this.limitHourValue = "";
        },
        compatible_ios_show: function () {
            $(".page").css("overflow", "hidden");
        },
        compatible_ios_hide: function () {
            //this.pop_insure = window.pop_insure || 0;
            //this.pop_insure_input = window.pop_insure_input || 0;
            $(".page").css("overflow", "auto");
        },
        // _compatible_ios_hide: function () {
        //     this.pop_insure = window.pop_insure || 0;
        //     this.pop_insure_input = window.pop_insure_input || 0;
        //     if (this.pop_insure == -1) {
        //         this.money = this.pop_insure_input;
        //     }
        //     else {
        //         this.money = this.pop_insure;
        //     }
        //     this.getPrice(this.money);
        //     $(".page").css("overflow", "auto");
        // },
        // getUrgent: function () {
        //     var _this = this;
        //     console.log("fromArea" + _this.send_addr.areaId)
        //     console.log("toArea" + _this.collect_addr.areaId)
        //     $.commonAjax({
        //         url: '/urgent/findByArea.api',
        //         type: 'POST',
        //         data: {
        //             fromArea: _this.send_addr.areaId,
        //             toArea: _this.collect_addr.areaId
        //         },
        //         success: function (data) {
        //             //加急时间显示取包时间后的24小时
        //             var dStr=_this.timeValue.join(' ').substr(0, 16) + ':00';
        //             //ios系统不识别2017-11-23 这样的格式 ，只识别2017/11/23
        //             var d = new Date(dStr.replace(/\-/g, "/"));
        //             //下午17点以后
        //             if (d.getHours() >= 17) {
        //                 d.setDate(d.getDate() + 2);
        //                 d.setHours(9);
        //             } else {
        //                 d.setDate(d.getDate() + 1);
        //             }
        //             var datestring = d.getFullYear() + "-" + ("0" + (d.getMonth() + 1)).slice(-2) + "-" + ("0" + d.getDate()).slice(-2) + " " + ("0" + d.getHours()).slice(-2) + ":" + ("0" + d.getMinutes()).slice(-2) + ":" + ("0" + d.getSeconds()).slice(-2);
        //             console.log(datestring)
        //             if (data.datas && data.datas.length > 0) {
        //                 var urgentObj = {
        //                     "business_type": "3",
        //                     "business_type_desc": "顺丰重货",
        //                     "checked": false,
        //                     // "2017-12-02 23:59:00,2017-12-02 23:59:00"
        //                     "deliver_time": datestring + "," + datestring,
        //                     "describe": "",
        //                     "origin_price": _this.amount_op + data.datas[0].price,
        //                     "out_range_price": _this.amount_py,
        //                     "sf_price": _this.amount_yf + data.datas[0].price,
        //                 };
        //                 // self.amount_yf = data.datas[0].sf_price;
        //                 // self.amount_op = data.datas[0].origin_price;
        //                 // self.amount_py = data.datas[0].out_range_price;
        //                 _this.expect_times.push(urgentObj);
        //                 _this.showUrgent = true;
        //             } else {
        //                 _this.showUrgent = false;
        //             }
        //         },
        //         error: function (err) {
        //             $.toast(err);
        //         }
        //     });
        // },
    },
    activated: function () {
        var self = this;
        // $.inputRegExp("#pop_insure_input",/^\d+$/);

        //设置路由标示
        setStore('route_ident', "#agent_send");
        if (!self.isF) {
            //重置价格列表
            self.expect_times=[];
            self.getAmount();
            //if (self.send_addr.address != '' && self.collect_addr.address != '') self.getPrice(self.pop_insure, self.confirmInsure);
        }
    },
    mounted: function () {
        var _this = this, callback = function () {
            _this.isF = false;

            //Vincent Chang 2017-12-04 delete
            //获取取包时间会设置默认取包时间、取包时间变更会重新获取价格列表
           // _this.getAmount();
        };
        _this.getTime(callback);

        $.webService.getJsConfig().then(function (data) {
            wx.config({
                appId: $.appId,
                timestamp: data.datas.timestamp,
                nonceStr: data.datas.nonceStr,
                signature: data.datas.signature,
                jsApiList: ['getLocation']
            });
            wx.ready(function () {
                wx.getLocation({
                    type: 'wgs84',
                    success: function (res) {
                        setStore('geo_lat', res.latitude);
                        setStore('geo_long', res.longitude);
                    }
                });
            });
        });

        //获取最小保价金额和费用
        $.commonAjax({
            url: '/index/query_insured.api',
            loading: false,
            success: function (data) {
                //_this.min = data.datas.min;
                //最小保价金额为0时 设置初始保价金额为1
                if (data.datas.min <= 0) {
                    _this.money = 1;
                    _this.pop_insure_input = 1;
                } else {
                    _this.money = data.datas.min;
                    _this.pop_insure_input = data.datas.min;
                }

                //获取初始保价金额
                _this.getPrice(_this.money);

                // _this.money = data.datas.min;
                // _this.amount_bj = data.datas.insuredPrice;
            }
        });

    }
})