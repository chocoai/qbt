/**
 * Created by Administrator on 2017/8/9.
 */
var agent_address_view = Vue.extend({
    template: '#agent_address',
    data: function () {
        return {
            areas: AREAS,
            showConcat: false,
            concat_list: [],
            name: '',
            mobile: '',
            cityName: [],
            address: '',
            //联系人
            concat_: {},
            //前次选中联系人
            pre_concat:{},
            address_type: 1,
            label_type: 3,
            prevRouteID: '',
            docClientH: 0
        }
    },
    computed: {
        addrMsg: function () {
            return this.$store.state.addrMsg
        },
        tab: function () {
            return this.$store.state.tab
        },
        tabStyle: function () {
            return this.$store.state.tabStyle ? this.$store.state.tabStyle : 1;
        },
        isJ: function () {
            return this.$store.state.isJ
        },
        route_ident: function () {
            return this.$store.state.route_ident
        },
        //寄件信息
        send_addr: function () {
            return this.$store.state.send_addr
        },
        //收件信息
        collect_addr: function () {
            return this.$store.state.collect_addr
        }
    },
    methods: {
        goView: function (type) {
            setStore('tab', type);
            setStore('isAddr', false);
            //router.push('/agent_address/addrs');
            //历史地址
            if (type == 4) {
                router.push('/agent_address/addrs_his');
            } else if (type == 2) {//球场
                router.push('/agent_address/addrs_course');
            } else if (type == 1) {//输入地址
                setStore('tabStyle', type);
            }
        },
        chooseConcats: function () {
            var self = this;
            $.commonAjax({
                url: '/user/query_old_contacts.api',
                data: {},
                success: function (data) {
                    self.showConcat = true;
                    self.concat_list = data.datas;
                    self.$nextTick(function () {
                        var dClientH = document.documentElement.clientHeight;
                        var concatH = $("#concatList").height();
                        if (concatH >= dClientH / 2) {
                            $("#concatList").css({height: "50%", overflow: "auto"});
                        }
                    });
                },
                error: function (err) {
                    $.toast(err);
                }
            });
        },
        selectConcat: function (index, item) {
            var self = this;
            var oH = $("#concatList").get(0).offsetHeight;
            //减去#concatList盒子50的padding-bottom的值
            oH = oH - 50;
            //记录上次选中的联系人信息
            self.pre_concat=self.concat_;
            //前次选中的和点击的是同一行数据
            if(self.pre_concat.index==index){
                //取消选中
                self.concat_ = {index:undefined};
                //self.concat_.index = index;
            }else{
                self.concat_ = item;
                self.concat_.index = index;
            }
            self.$nextTick(function () {
                $("#concatList").css({height: oH + "px", overflow: "auto"});
            });
            // this.name = this.concat_.userName;
            // this.mobile = this.concat_.mobile;
            // this.showConcat = false;
        },
        delConcat: function (index, item) {
            var self = this;
            $.commonAjax({
                url: '/user/delete_old_contacts.api',
                data: {
                    id: item.id
                },
                success: function (data) {
                    //重新更新历史联系人列表
                    $.commonAjax({
                        url: '/user/query_old_contacts.api',
                        data: {},
                        success: function (data) {
                            self.concat_list = data.datas;
                            self.concat_ = {index: undefined};
                            self.$nextTick(function () {
                                var dClientH = document.documentElement.clientHeight;
                                var concatH = $("#concatList").height();
                                if (concatH >= dClientH / 2) {
                                    $("#concatList").css({height: "50%", overflow: "auto"});
                                }
                            });
                        },
                        error: function (err) {
                            $.toast(err);
                        }
                    });
                },
                error: function (err) {
                    $.toast(err);
                }
            });

        },
        //联系人弹框点击返回
        cancelConcat:function () {
            //隐藏弹框
            this.showConcat = false;
            this.concat_=this.pre_concat;
            //this.concat_.index=
        },
        sureConcat: function () {

            if (this.concat_.index == undefined) {
                $.toast("请先选择联系人");
                return;
            }
            this.name = this.concat_.userName;
            this.mobile = this.concat_.mobile;
            this.showConcat = false;
        },
        save: function () {
            var _this = this;
            var msg = this.validate();
            if (msg) {
                $.toast(msg);
                return;
            }
            //表情输入检查
            var regRule = /\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g;
            if (this.addrMsg.address.match(regRule)) {
                //param = param.replace(/\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g, "");
                $.toast("详情地址不可输入表情");
                return;
            }
            var addr_type = 1;
            var str = "";
            var bool = false;
            if (this.tab == 1 || this.tabStyle == 1) {
                addr_type = 4;
                $.commonAjax({
                    url: '/comm/isOutRangeArea.api',
                    async: false,
                    type: 'post',
                    data: {
                        areaId: _this.cityName[2],
                        address: _this.addrMsg.address
                    },
                    success: function (data) {
                        bool = data.datas;
                    },
                    error: function (err) {
                        $.toast(err);
                    }
                });
            }
            //
            // if (_this.tab == 2) {
            //     addr_type = 1
            // }
            //球场
            if (_this.tab == 3 || _this.tabStyle == 2) {
                addr_type = 1
            }
            if (this.cityName.length > 0 && this.cityName.length == 3) {
                var arr = this.cityName;
                str = this.areas.filter(function (ele) {
                    return ele.value == arr[0] || ele.value == arr[1] || ele.value == arr[2]
                }).map(function (ele) {
                    return ele.name
                }).join(" ")
            }
            var attr_msg = {
                type: this.tab,
                name: this.name,
                mobile: this.mobile,
                address: this.addrMsg.address,
                real_address: '',
                treePath: this.tab == 1 || this.tabStyle == 1 ? str : '',
                areaId: this.tab == 1 || this.tabStyle == 1 ? this.cityName[2] : this.addrMsg.areaId,
                addr_type: addr_type,
                addr_id: this.tab != 1 || this.tabStyle != 1 ? this.addrMsg.id : '',
                remark: '',
                tabStyle: this.tabStyle,
                treeId: this.cityName.join(','),
                siteName: this.addrMsg.siteName,
                label_type: this.label_type,
                isOutRange: this.tab == 1 || this.tabStyle == 1 ? bool : this.addrMsg.isOutRange,
                //增加该字段防止正向返回时缺损Id字段
                id: this.addrMsg.id
            };
            if (this.isJ) {
                setStore('send_addr', attr_msg);
            }
            else {
                setStore('collect_addr', attr_msg);
            }
            if (this.prevRouteID == '#agent_send') {
                router.push('/agent_send');
            } else {

            }
        },
        validate: function () {
            if (!this.name) return '请输入联系人姓名';
            if (!this.mobile || !$.comReg.isPhone(this.mobile)) return '请输入有效电话号码';
            if (this.mobile.length != 11) return '请输入11位的手机号码';
            if (this.tab == 1) {
                if (this.cityName.length == 0 || this.cityName.some(function (ele) {
                        return ele == ""
                    })) return '请选择所在地区';
                else {
                    if (!this.addrMsg.areaId) {
                        this.addrMsg.cityName = $('.vux-popup-picker-value').text().replace(/\s/g, ',');
                        this.addrMsg.areaId = this.cityName[2];
                    }
                }
            }
            if (!this.addrMsg.address) return '请输入详细地址';
            return '';
        },
        goBack: function () {
            if (self.isJ) {
                window.send_addr && setStore('send_addr', window.send_addr);
            }
            else {
                window.collect_addr && setStore('collect_addr', window.collect_addr);
            }
            router.push('/agent_send');
        }
    },
    mounted: function () {
        var self = this;
        var bool = false;
        //兼容性处理
        if (!$.os.ios) {
            $(window).resize(function () {
                var dClientH = document.documentElement.clientHeight;
                if (dClientH < self.docClientH) {
                    if (bool)  $(".page").css("margin-top", -(self.docClientH - dClientH) + "px");
                } else {
                    bool = false;
                    $(".page").css("margin-top", "0px");
                }
            });
            document.addEventListener("click", function (ev) {
                if (ev.target.id == "address") bool = true;
            }, false);
        }
        ;

    },
    activated: function () {
        var self = this;
        self.docClientH = document.documentElement.clientHeight;
        //激活组件时，将历史联系人列表设为全不选状态
        self.concat_.index = undefined;
        if (self.route_ident == '#agent_send') {
            self.prevRouteID = '#agent_send';
            if (self.isJ) {
                window.send_addr = $.extend({}, self.send_addr);
                setStore('addrMsg', self.send_addr);
                setStore('tab', self.send_addr.tabStyle);
                self.name = self.send_addr.name;
                self.mobile = self.send_addr.mobile;
                (self.send_addr.treeId == "" || self.send_addr.treeId == undefined) ? self.cityName = ["", "", ""] : self.cityName = self.send_addr.treeId.split(",");
                self.label_type = self.send_addr.label_type;
            }
            else {
                window.collect_addr = $.extend({}, self.collect_addr);
                setStore('addrMsg', self.collect_addr);
                setStore('tab', self.collect_addr.tabStyle);
                self.name = self.collect_addr.name;
                self.mobile = self.collect_addr.mobile;
                (self.collect_addr.treeId == "" || self.collect_addr.treeId == undefined) ? (self.cityName = ["", "", ""]) : (self.cityName = self.collect_addr.treeId.split(','));
                self.label_type = self.collect_addr.label_type;
            }
        }
        //由路由isend/address/addrs->isend/address
        else if (self.route_ident == '#agent_addrs_his') {
            self.addrMsg.treeId && (self.cityName = self.addrMsg.treeId.split(','));
            self.label_type = self.$store.state.label_type;
        } else {
        }

        // setStore('route_ident',"#address");
        setStore('route_ident', "#agent_address");
    }
})