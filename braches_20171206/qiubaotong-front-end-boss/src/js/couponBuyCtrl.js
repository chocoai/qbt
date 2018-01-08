"use strict";
angular.module("app.views")
    .controller('couponBuyCtrl', ['$scope', 'CommonService', 'Constants', '$timeout', function ($scope, CommonService, Constants, $timeout) {
        $('body').niceScroll({cursorcolor: "#337ab7"});
        //订单模型
        $scope.order = {
            type: "0",
            openid: "",
            activityId: "",
            activityName: "",
            activityAmount: 1,
            purchaser: "",
            purchaserAddress: "",
            purchaserNumber: "",
            description: "",
            buyActive: 0
        };

        //选中的省市县
        $scope.addresses = {};
        $scope.wechatName = '选择微信用户';
        //选中的券包
        $scope.selectedPackage = null;
        $scope.selectedActivityIndex = "0";

        //监听券包选中
        $scope.$watch('selectedActivityIndex', function (newValue, oldValue, scope) {
            if ($scope.packageBuyList && $scope.packageBuyList.length > 0) {
                $scope.selectedPackage = $scope.packageBuyList[parseInt(newValue)];
            }

        });

        //可购买券包列表
        //$scope.packageBuyList = [];

        //获取省份列表
        $scope.getProvinces = function () {
            if ($scope.provinceses && $scope.provinceses.length > 0) {
                return;
            }
            CommonService.httpRequest({
                url: '/baseSfArea/findByParentId.api?parentId=1000000',
                method: 'get'
            }).then(function (data) {
                $scope.provinceses = data.datas;
            });
        };
        //获取城市列表
        $scope.getCitieses = function () {
            if (!$scope.addresses.province) {
                $scope.citieses = [];
                $scope.addresses.city = "";
                return;
            }
            CommonService.httpRequest({
                url: '/baseSfArea/findByParentId.api?parentId=' + $scope.addresses.province.split('|')[0],
                method: 'get'
            }).then(function (data) {
                $scope.citieses = data.datas;
            });
        };
        //获取地区列表
        $scope.getCounties = function () {
            if (!$scope.addresses.city) {
                $scope.countieses = [];
                $scope.addresses.country = "";
                return;
            }
            CommonService.httpRequest({
                url: '/baseSfArea/findByParentId.api?parentId=' + $scope.addresses.city.split('|')[0],
                method: 'get'
            }).then(function (data) {
                $scope.areas = data.datas;
            });
        };


        //获取可购买券包列表,只取三条有效的券包
        $scope.getPackageList = function () {
            CommonService.httpRequest({
                url: '/ticketPackageActivity/findByPage.api',
                method: 'post',
                data: {
                    pageNo: 1,
                    pageSize: 3,
                    status: 1
                }
            }).then(function (data) {
                $scope.packageBuyList = data.datas;
                if ($scope.packageBuyList && $scope.packageBuyList.length > 0) {
                    $scope.selectedPackage = $scope.packageBuyList[0];
                }
            });
        };

        //获取省份
        $scope.getProvinces();
        //获取券包列表
        $scope.getPackageList();

        //获取微信用户列表
        $scope.getWechatUser = function (num) {
            CommonService.pagination({
                url: '/userWeixin/findByPage.api',
                data: {
                    pageNo: num || "1",
                    name: $scope.queryWechatName
                }
            }).then(function (data) {
                $scope.wechatUsers = data.item;
                $scope.wechatUserPage = data.page;
            });
        };

        //打开微信用户选中
        $scope.openWechatUserPopup = function (item) {
            $scope.getWechatUser();
            layer.open({
                type: 1,
                title: '请选择微信用户',
                skin: 'layui-layer-rim', //加上边框
                area: ['620px', '640px'], //宽高
                content: $('#wechatUserPopup'),
                end: function () {
                    $scope.queryWechatName = '';
                }
            });
        }

        //选中微信用户
        $scope.selectedWechatUser = function (wechat) {
            $scope.order.openid = wechat.openid;
            // $scope.userName = wechat.name;
            // $scope.mobile = wechat.mobile;
            $scope.wechatName = wechat.nickname;
            layer.closeAll();
        };

        //清除选中的微信用户
        $scope.clearWechatUser = function ($event) {
            //阻止事件冒泡
            $event.stopPropagation();
            $scope.order.openid = '';
            $scope.wechatName = '选择微信用户';
        };


        //显示订单信息确认框
        $scope.showOrder = function () {
            if (!$scope.order.activityAmount || $scope.order.activityAmount < 0) {
                showWarn('数量不能小于1');
                return false;
            }
            if (!$scope.order.purchaser) {
                showWarn('购买人必须填写');
                return false;
            }
            if (!$scope.order.purchaserNumber) {
                showWarn('手机号必须填写');
                return false;
            }
            //选中电子券没有选微信用户
            if ($scope.order.type == "0" && !$scope.order.openid) {
                showWarn('电子券必须选择微信用户');
                return false;
            }

            //选中纸质券没有填地址
            if ($scope.order.type == "1" && !$scope.detailAddress) {
                showWarn('纸质券必须填写地址');
                return false;
            }

            $scope.order.purchaserAddress = $scope.detailAddress;
            if ($scope.addresses && $scope.addresses.province) {
                $scope.order.purchaserAddress = $scope.addresses.province.split('|')[1] + $scope.order.purchaserAddress;
                if ($scope.addresses.city) {
                    $scope.order.purchaserAddress = $scope.addresses.city.split('|')[1] + $scope.order.purchaserAddress;
                }
                if ($scope.addresses.area) {
                    $scope.order.purchaserAddress = $scope.addresses.area.split('|')[1] + $scope.order.purchaserAddress;
                }
            }

            $scope.order.activityId = $scope.selectedPackage.id;
            $scope.order.activityName = $scope.selectedPackage.activityName;
            //选中电子券没有选微信用户
            if ($scope.order.type == "0" && !$scope.isActive) {
                $scope.order.buyActive = 1;
            }


            $timeout(function () {
                layer.open({
                    type: 1,
                    title: '订单信息',
                    area: ['460px', '520px'],
                    content: $('#showOrder'),
                    btn: ['确认', '取消'],
                    zIndex: 1000,
                    //确认
                    yes: function (index) {
                        $scope.orderSubmit();
                        $scope.$apply();
                        layer.close(index);
                    },
                    //取消
                    end: function () {

                    }
                });
            });
            $('#showOrderBtn').blur();
        };

        //提交订单
        $scope.orderSubmit = function () {
            CommonService.httpRequest({
                url: '/proxyTicketPackage/order.api',
                method: 'post',
                data: $scope.order
            }).then(function (data) {
                //下单成功
                if (data.code == "0000") {
                    var btnConfirm = "确认已收款";
                    var btnPush = $scope.order.openid ? "推送客户支付" : "取消";
                    $timeout(function () {
                        layer.open({
                            type: 1,
                            title: '订单信息',
                            area: ['320px', '220px'],
                            content: $('#submitSuccess'),
                            btn: [btnConfirm, btnPush],
                            zIndex: 1000,
                            //确认
                            yes: function (index) {
                                $scope.confirmPaid(data.datas);
                                $scope.$apply();
                                layer.close(index);
                            },
                            //取消
                            end: function () {
                                //选择了微信用户、推送微信支付消息
                                if ($scope.order.openid) {
                                    $scope.pushPay(data.datas);
                                }
                            }
                        });
                    });
                } else {
                    showWarn(data.msg);
                }
            });
        }

        //确认支付
        $scope.confirmPaid = function (orderId) {
            CommonService.httpRequest({
                url: '/proxyTicketPackage/confirmPaid.api',
                method: 'post',
                data: {id: orderId}
            }).then(function (data) {
                //支付成功
                if (data.code == "0000") {
                    showInfo("确认支付成功");
                } else {
                    showWarn(data.msg);
                }

            });

        }

        //推送支付消息
        $scope.pushPay = function (orderId) {
            CommonService.httpRequest({
                url: '/proxyTicketPackage/pushPayment.api',
                method: 'post',
                data: {id: orderId, paymentUrl: wechatUrl + '/view/pkgPushPay.html?id=' + orderId}
            }).then(function (data) {
                //支付成功
                if (data.code == "0000") {
                    showInfo("推送客户支付成功");
                } else {
                    showWarn(data.msg);
                }

            });

        }

    }]);
