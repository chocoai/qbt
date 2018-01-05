"use strict";
angular.module("app.views")
    .controller('orderDetailCtrl', ['$scope', 'CommonService', 'Constants', function ($scope, CommonService, Constants) {
        $('body').niceScroll({cursorcolor: "#337ab7"});
        $scope.order_type = Constants.order_type;
        $scope.sf_type = Constants.sf_type;
        $scope.id = CommonService.getQueryString('id');
        $scope.order = {};
        $scope.edit = {};
        $scope.refundAmountMsg = '';
        $scope.feeAmountMsg = '';
        $scope.moneyMsg = '';
        $scope.dtemp = {};// 用于存储取/送包信息

        $('#sendTime').datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            autoclose: true,
            todayBtn: true
        });

        $scope.detail = function () {
            CommonService.httpRequest({
                url: '/order/detail.api',
                method: 'get',
                data: {
                    id: $scope.id
                }
            }).then(function (data) {
                $scope.order = data.datas;
                $scope.order.mailChannel === 1 && $('#mailChannelNo').addClass('fade');
                $scope._dADDRESS = $scope.order.dTreePath + $scope.order.dAddress;
                $scope._jADDRESS = $scope.order.jTreePath + $scope.order.jAddress;
                $scope.arriveDay = Math.floor((new Date($scope.order.deliverDate).getTime() - new Date($scope.order.sendSfUserTime)) / (24 * 3600 * 1000))
                $scope.getOrderCostItem();

                //获取发送客户(顺丰)信息状态
                $scope.getSFNoticeStatus($scope.order.number);
            });
            $scope.deliverTimes = [];
        };
        $scope.getOptList = function () {
            CommonService.httpRequest({
                url: '/order/operateLog.api',
                method: 'get',
                data: {
                    orderId: $scope.id
                }
            }).then(function (data) {
                $scope.optList = data.datas;
            });
        };
        $scope.getWayList = function () {
            CommonService.httpRequest({
                url: '/order/waybill.api',
                method: 'get',
                data: {
                    orderId: $scope.id
                }
            }).then(function (data) {
                $scope.wayList = data.datas;
            });
        };
        $scope.detail();
        $scope.getOptList();
        $scope.getWayList();

        $scope.editStatus = function () {
            $scope.edit.orderStatus = $scope.order.orderStatus + "";
            $scope.edit.deliveryStatus = $scope.order.deliveryStatus + "";
            layer.open({
                type: 1,
                title: '订单状态修改',
                area: ['450px', '250px'],
                content: $('#editStatus'),
                btn: ['确认', '取消'],
                yes: function (index) {
                    $scope.order.orderStatus = $scope.edit.orderStatus;
                    $scope.order.deliveryStatus = $scope.edit.deliveryStatus;
                    $scope.$apply();
                    layer.close(index);
                }
            });
        };
        $scope.editMailNo = function () {
            $scope.edit.mailNo = $scope.order.mailNo;
            layer.open({
                type: 1,
                title: '运单号修改',
                area: ['450px', '200px'],
                content: $('#editMailNo'),
                btn: ['确认', '取消'],
                yes: function (index) {
                    $scope.order.mailNo = $scope.edit.mailNo;
                    $scope.$apply();
                    layer.close(index);
                }
            });
        };
        $scope.editChannelNo = function () {
            $scope.order.mailChannel === 1 ? $scope.edit.channel = '1' : ($scope.order.mailChannel === 2 ? $scope.edit.channel = '2' : ($scope.order.mailChannel === 3 ? $scope.edit.channel = '3' : ($scope.order.mailChannel === 4 ? $scope.edit.channel = '4' : $scope.edit.channel = '5')));
            // if($scope.order.mailChannel===1){
            //   $scope.edit.channel='1'
            // }else if($scope.order.mailChannel===2){
            //   $scope.edit.channel='2'
            // }else if($scope.edit.channel===3){
            //   $scope.edit.channel='3'
            // }
            $scope.edit.channelNo = ($scope.order.mailChannel === 1 ? '' : $scope.order.mailNumber);
            $scope.getChannel();
            layer.open({
                type: 1,
                title: '渠道修改',
                area: ['450px', '200px'],
                content: $('#editChannelNo'),
                btn: ['保存', '取消'],
                yes: function (index) {
                    if (/^[0-9a-zA-Z]+$/g.test($scope.edit.channelNo) === false) {
                        showWarn('必须字母加数字组合');
                        return false;
                    }
                    $scope.order.mailChannel = parseInt($scope.edit.channel);
                    $scope.order.mailNumber = $scope.edit.channelNo;
                    CommonService.httpRequest({
                        url: '/order/updateMailChannelById.api',
                        method: 'get',
                        data: {
                            id: $scope.order.id,
                            mailChannel: parseInt($scope.edit.channel),
                            mailNumber: $scope.edit.channelNo
                        }
                    }).then(function (data) {
                        showInfo('更新成功', function () {
                            $scope.detail();
                        });
                    });
                    $scope.$apply();
                    layer.close(index);
                }
            });
        }
        $scope.editTime = function () {
            // $scope.edit.sendSfUserTime = $scope.order.sendSfUserTime;
            // $('#sendTime').val(new Date($scope.order.sendSfUserTime).Format('yyyy-MM-dd hh:mm:ss'));
            $scope.getTime();
            layer.open({
                type: 1,
                title: '时间修改',
                area: ['450px', '300px'],
                content: $('#editTime'),
                btn: ['确认', '取消'],
                zIndex: 1000,
                yes: function (index) {
                    $scope.order.sendSfUserTime = new Date(($scope.edit.sendDate.replace(/-/g, "/") + ' ' + $scope.edit.sendTime).substr(0, 16) + ':00').getTime();
                    $scope.order.sendTimeSection = $scope.edit.sendDate + ' ' + $scope.edit.sendTime;
                    $scope.$apply();
                    layer.close(index);
                }
            });
        };
        $scope.getTime = function () {
            if ($scope.timeList && $scope.timeList.length > 0) {
                $scope.timeList2 = $scope.timeList[0].items;
                $scope.edit.sendDate = $scope.timeList[0].day;
                $scope.edit.sendTime = $scope.timeList[0].items[0];
                return;
            }
            CommonService.httpRequest({
                url: '/index/time.api',
                method: 'get',
                baseUrl: wBaseUrl
            }).then(function (data) {
                $scope.timeList = data.datas;
                $scope.timeList2 = data.datas[0].items;
                $scope.edit.sendDate = data.datas[0].day;
                $scope.edit.sendTime = data.datas[0].items[0];
            });
        };
        $scope.changeTime = function () {
            for (var i = 0; i < $scope.timeList.length; i++) {
                var item = $scope.timeList[i];
                if (item.day == $scope.edit.sendDate) {
                    $scope.timeList2 = item.items;
                    $scope.edit.sendTime = item.items[0];
                    break;
                }
            }
        };

        $scope.showDeliverTimes = function () {
            if ($scope.order.sendSfUserTime > (new Date()).getTime()) {
                $scope.getBusinessType();
            }
            else {
                showWarn('已超时间，请修改预约取件时间');
            }
        }

        $scope.getUserAddr = function (page) {
            $scope.userAddrList = [];
            CommonService.pagination({
                url: '/userAddress/findByPage.api',
                data: {
                    userId: $scope.order.userId,
                    pageNo: page || 1
                }
            }).then(function (data) {
                $scope.userAddrList = data.item;
                $scope.page = data.page;
            });
        };
        $scope.editAddr = function (type) {
            var title = type == 1 ? '取包地址修改' : '送包地址修改';
            $scope.edit = {};
            $scope.edit.type = type;
            // 取/送包的判断
            if (type === 1) {
                if ($scope.order.jAddrName === '') {
                    $('#myTab>li:nth-child(1)').addClass('active').siblings().removeClass('active');
                    $('#userAddr').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_2 = $scope.order.jContact;
                    $scope.edit.mobile_2 = $scope.order.jMobile;
                    $scope.edit.address = $scope.order.jAddress;
                    $scope.edit.name_1 = $scope.order.jContact;
                    $scope.edit.mobile_1 = $scope.order.jMobile;
                    var jsheng;
                    if ($scope.order.jTreePath.split(',')[0].indexOf('重庆') !== -1 || $scope.order.jTreePath.split(',')[0].indexOf('北京') !== -1 || $scope.order.jTreePath.split(',')[0].indexOf('上海') !== -1 || $scope.order.jTreePath.split(',')[0].indexOf('天津') !== -1 || $scope.order.jTreePath.split(',')[0].indexOf('自治区') !== -1 || $scope.order.jTreePath.split(',')[0].indexOf('省') !== -1) {
                        jsheng = $scope.order.jTreePath.split(',')[0]
                    } else {
                        jsheng = $scope.order.jTreePath.split(',')[0] + '省'
                    }
                    $scope.edit.province = $scope.order.jTreeId.split(',')[0] + '|' + jsheng;
                    $scope.edit.city = $scope.order.jTreeId.split(',')[1] + '|' + $scope.order.jTreePath.split(',')[1];
                    $scope.edit.country = $scope.order.jTreeId.split(',')[2] + '|' + $scope.order.jTreePath.split(',')[2];
                    CommonService.httpRequest({
                        url: '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.province.split('|')[0],
                        method: 'post',
                    }).then(function (data) {
                        $scope.citieses = data.datas;
                    });
                    CommonService.httpRequest({
                        url: '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.city.split('|')[0],
                        method: 'post',
                    }).then(function (data) {
                        $scope.countieses = data.datas;
                    });
                } else {
                    if ($scope.order.jAddrName.indexOf('球场') !== -1) {
                        $('#myTab>li:nth-child(2)').addClass('active').siblings().removeClass('active');
                        $('#courtAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.jContact;
                        $scope.edit.mobile_1 = $scope.order.jMobile;
                        $scope.edit.stationName1 = $scope.order.jAddrName;
                    }
                    else if ($scope.order.jAddrName.indexOf('银行') !== -1) {
                        $('#myTab>li:nth-child(3)').addClass('active').siblings().removeClass('active');
                        $('#bankAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.jContact;
                        $scope.edit.mobile_1 = $scope.order.jMobile;
                        $scope.edit.stationName3 = $scope.order.jAddrName;
                    }
                    else if ($scope.order.jAddrName.indexOf('机场') !== -1) {
                        $('#myTab>li:nth-child(5)').addClass('active').siblings().removeClass('active');
                        $('#airAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.jContact;
                        $scope.edit.mobile_1 = $scope.order.jMobile;
                        $scope.edit.stationName2 = $scope.order.jAddrName;
                    } else {
                        $('#myTab>li:nth-child(4)').addClass('active').siblings().removeClass('active');
                        $('#sfAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.jContact;
                        $scope.edit.mobile_1 = $scope.order.jMobile;
                        $scope.edit.stationName5 = $scope.order.jAddrName;
                    }
                    $scope.edit.name_2 = $scope.order.jContact;
                    $scope.edit.mobile_2 = $scope.order.jMobile;
                }
            } else if (type === 2) {
                if ($scope.order.dAddrName === '') {
                    $('#myTab>li:nth-child(1)').addClass('active').siblings().removeClass('active');
                    $('#userAddr').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_2 = $scope.order.dContact;
                    $scope.edit.mobile_2 = $scope.order.dMobile;
                    $scope.edit.address = $scope.order.dAddress;
                    $scope.edit.name_1 = $scope.order.dContact;
                    $scope.edit.mobile_1 = $scope.order.dMobile;
                    var dsheng;
                    if ($scope.order.dTreePath.split(',')[0].indexOf('重庆') !== -1 || $scope.order.dTreePath.split(',')[0].indexOf('北京') !== -1 || $scope.order.dTreePath.split(',')[0].indexOf('上海') !== -1 || $scope.order.dTreePath.split(',')[0].indexOf('天津') !== -1 || $scope.order.dTreePath.split(',')[0].indexOf('自治区') !== -1 || $scope.order.dTreePath.split(',')[0].indexOf('省') !== -1) {
                        dsheng = $scope.order.dTreePath.split(',')[0]
                    } else {
                        dsheng = $scope.order.dTreePath.split(',')[0] + '省'
                    }
                    $scope.edit.province = $scope.order.dTreeId.split(',')[0] + '|' + dsheng;
                    $scope.edit.city = $scope.order.dTreeId.split(',')[1] + '|' + $scope.order.dTreePath.split(',')[1];
                    $scope.edit.country = $scope.order.dTreeId.split(',')[2] + '|' + $scope.order.dTreePath.split(',')[2];
                    CommonService.httpRequest({
                        url: '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.province.split('|')[0],
                        method: 'post',
                    }).then(function (data) {
                        $scope.citieses = data.datas;
                    });
                    CommonService.httpRequest({
                        url: '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.city.split('|')[0],
                        method: 'post',
                    }).then(function (data) {
                        $scope.countieses = data.datas;
                    });
                } else {
                    if ($scope.order.dAddrName.indexOf('球场') !== -1) {
                        $('#myTab>li:nth-child(2)').addClass('active').siblings().removeClass('active');
                        $('#courtAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.dContact;
                        $scope.edit.mobile_1 = $scope.order.dMobile;
                        $scope.edit.stationName1 = $scope.order.dAddrName;
                    }
                    else if ($scope.order.dAddrName.indexOf('银行') !== -1) {
                        $('#myTab>li:nth-child(3)').addClass('active').siblings().removeClass('active')
                        $('#bankAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.dContact;
                        $scope.edit.mobile_1 = $scope.order.dMobile;
                        $scope.edit.stationName3 = $scope.order.dAddrName;
                    }
                    else if ($scope.order.dAddrName.indexOf('机场') !== -1) {
                        $('#myTab>li:nth-child(5)').addClass('active').siblings().removeClass('active');
                        $('#airAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.dContact;
                        $scope.edit.mobile_1 = $scope.order.dMobile;
                        $scope.edit.stationName2 = $scope.order.dAddrName;
                    } else {
                        $('#myTab>li:nth-child(4)').addClass('active').siblings().removeClass('active');
                        $('#sfAddr').addClass('active').siblings().removeClass('active');
                        $scope.edit.name_1 = $scope.order.dContact;
                        $scope.edit.mobile_1 = $scope.order.dMobile;
                        $scope.edit.stationName5 = $scope.order.dAddrName;
                    }
                    $scope.edit.name_2 = $scope.order.dContact;
                    $scope.edit.mobile_2 = $scope.order.dMobile;
                }
            }
            $scope.getUserAddr();
            $scope.getCourt();
            $scope.getBank();
            $scope.getAir();
            $scope.getSf();
            $scope.getProvinces();
            layer.open({
                type: 1,
                title: title,
                area: ['850px', '500px'],
                content: $('#editAddr')
            });
        };
        $scope.getCourt = function () {
            if ($scope.courtList && $scope.courtList.length > 0) {
                return;
            }
            CommonService.httpRequest({
                url: '/common/siteList.api',
                method: 'get',
                data: {
                    type: 1
                }
            }).then(function (data) {
                $scope.courtList = data.datas;
            });
        };
        $scope.getBank = function () {
            if ($scope.bankList && $scope.bankList.length > 0) {
                return;
            }
            CommonService.httpRequest({
                url: '/common/siteList.api',
                method: 'get',
                data: {
                    type: 2
                }
            }).then(function (data) {
                $scope.bankList = data.datas;
            });
        };
        $scope.getSf = function () {
            if ($scope.sfList && $scope.sfList.length > 0) {
                return;
            }
            CommonService.httpRequest({
                url: '/common/siteList.api',
                method: 'get',
                data: {
                    type: 3
                }
            }).then(function (data) {
                $scope.sfList = data.datas;
            });
        };
        $scope.getAir = function () {
            if ($scope.airList && $scope.airList.length > 0) {
                return;
            }
            CommonService.httpRequest({
                url: '/common/siteList.api',
                method: 'get',
                data: {
                    type: 4
                }
            }).then(function (data) {
                $scope.airList = data.datas;
            });
        };
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
        $scope.getCitieses = function () {
            $scope.edit.city = "";
            $scope.edit.country = "";
            if (!$scope.edit.province) {
                $scope.citieses = [];
                $scope.edit.city = "";
                return;
            }
            CommonService.httpRequest({
                url: '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.province.split('|')[0],
                method: 'get'
            }).then(function (data) {
                $scope.citieses = data.datas;
            });
        };
        $scope.getCounties = function () {
            $scope.edit.country = "";
            if (!$scope.edit.city) {
                $scope.countieses = [];
                $scope.edit.country = "";
                return;
            }
            CommonService.httpRequest({
                url: '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.city.split('|')[0],
                method: 'get'
            }).then(function (data) {
                $scope.countieses = data.datas;
            });
        };
        //查询时效
        $scope.getBusinessType = function () {
            CommonService.httpRequest({
                //url : '/comm/query_sf_recive_time.api',
                // url : '/comm/v2/query_sf_recive_time.api',
                url: '/comm/v2/query_sf_recive_time_boss.api',
                method: 'post',
                data: {
                    consigned_time: new Date($scope.order.sendSfUserTime).Format('yyyy-MM-dd hh:mm') + ':00',
                    src_area_id: $scope.order.jAreaId,
                    dest_area_id: $scope.order.dAreaId,
                    src_address: $scope.order.jAddress,
                    dest_address: $scope.order.dAddress,
                    business_type: 0,
                    src_course_id: $scope.order.jAddrType == 1 ? $scope.order.jAddrId : '',
                    dest_course_id: $scope.order.dAddrType == 1 ? $scope.order.dAddrId : ''
                },
                baseUrl: wBaseUrl
            }).then(function (data) {
                $scope.deliverTimes = data.datas;
                $scope.order.deliverDate = data.datas[0].deliver_time.split(',')[1];
                $scope.order.expressType = data.datas[0].business_type;
            });
        };
        $scope.$watch("order.sendSfUserTime", function (newValue, oldValue) {
            if (newValue && oldValue) {
                $scope.getBusinessType();
            }
        });
        $scope.$watch("order.jAreaId", function (newValue, oldValue) {
            if (newValue && oldValue) {
                $scope.getBusinessType();
            }
        });
        $scope.$watch("order.dAreaId", function (newValue, oldValue) {
            if (newValue && oldValue) {
                $scope.getBusinessType();
            }
        });
        $scope.checkBusiness = function (item) {
            $scope.order.deliverDate = item.deliver_time.split(',')[1];
            $scope.order.expressType = item.business_type;
        };
        $scope.getChannel = function () {
            CommonService.httpRequest({
                url: '/mailChannel/findAll.api',
                method: 'get'
            }).then(function (data) {
                $scope.channelList = data.datas;
            })
        };
        //只改联系人
        $scope.changeUserName = function () {
            if (!$scope.edit.name || !$scope.edit.mobile) {
                showWarn('请填写姓名手机号');
                return;
            }
            else {
                if ((/^1[3|4|5|7|8]\d{9}$/.test($scope.edit.mobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.edit.mobile))) {
                }
                else {
                    showWarn("联系电话格式错误");
                    $scope.edit.mobile = '';
                    return;
                }
            }
            if ($scope.edit.type == 1) {
                $scope.order.jContact = $scope.edit.name;
                $scope.order.jMobile = $scope.edit.mobile;
            } else {
                $scope.order.dContact = $scope.edit.name;
                $scope.order.dMobile = $scope.edit.mobile;
            }
            layer.closeAll();
        };

        //选择用户地址
        $scope.checkUserAddr = function (item) {
            if ($scope.edit.type == 1) {
                $scope.order.jContact = item.contact;
                $scope.order.jMobile = item.mobile;
                $scope.order.jAddress = item.address;
                $scope.order.jAddrName = '';
                $scope.order.jAddrType = 4;
                $scope.order.jTreePath = item.treePath;
                $scope.order.jAreaId = item.areaId;
            } else {
                $scope.order.dContact = item.contact;
                $scope.order.dMobile = item.mobile;
                $scope.order.dAddress = item.address;
                $scope.order.dAddrName = '';
                $scope.order.dAddrType = 4;
                $scope.order.dTreePath = item.treePath;
                $scope.order.dAreaId = item.areaId;
            }
            layer.closeAll();
        };

        //新增用户地址
        $scope.addUserAddr = function () {
            if (!$scope.edit.name_2 || !$scope.edit.mobile_2 || !$scope.edit.address || !$scope.edit.country) {
                showWarn('请填写完整信息');
                return;
            }
            else {
                if ((/^1[3|4|5|7|8]\d{9}$/.test($scope.edit.mobile_2)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.edit.mobile_2))) {
                }
                else {
                    showWarn("联系电话格式错误");
                    $scope.edit.mobile_2 = '';
                    return;
                }
            }
            if ($scope.edit.type == 1) {
                $scope.order.jContact = $scope.edit.name_2;
                $scope.order.jMobile = $scope.edit.mobile_2;
                $scope.order.jAddress = $scope.edit.address;
                $scope.order.jAddrName = '';
                $scope.order.jAddrType = 4;
                $scope.order.jTreePath = $scope.edit.province.split('|')[1] + ',' + $scope.edit.city.split('|')[1] + ',' + $scope.edit.country.split('|')[1];
                $scope.order.jAreaId = Number($scope.edit.country.split('|')[0]);
                $scope.order.jTreeId = $scope.edit.province.split('|')[0] + ',' + $scope.edit.city.split('|')[0] + ',' + $scope.edit.country.split('|')[0];
            } else {
                $scope.order.dContact = $scope.edit.name_2;
                $scope.order.dMobile = $scope.edit.mobile_2;
                $scope.order.dAddress = $scope.edit.address;
                $scope.order.dAddrName = '';
                $scope.order.dAddrType = 4;
                $scope.order.dTreePath = $scope.edit.province.split('|')[1] + ',' + $scope.edit.city.split('|')[1] + ',' + $scope.edit.country.split('|')[1];
                $scope.order.dAreaId = Number($scope.edit.country.split('|')[0]);
                $scope.order.dTreeId = $scope.edit.province.split('|')[0] + ',' + $scope.edit.city.split('|')[0] + ',' + $scope.edit.country.split('|')[0];
            }
            layer.closeAll();
        };

        //选择球场，银行网点，顺丰站点，机场网点
        $scope.checkStation = function (type) {
            if (!$scope.edit.name_1) {
                showWarn('请填写联系人');
                return;
            }
            if (!$scope.edit.mobile_1) {
                showWarn('请填写手机号');
                return;
            }
            else {
                if (!(/^1[3|4|5|7|8]\d{9}$/.test($scope.edit.mobile_1))) {
                    showWarn("手机号码格式错误");
                    return;
                }
            }
            if (!$scope.edit.addrId) {
                showWarn('请选择地址');
                return;
            }
            if ($scope.edit.type == 1) {
                $scope.order.jContact = $scope.edit.name_1;
                $scope.order.jMobile = $scope.edit.mobile_1;
                $scope.order.jAddress = $scope.edit.address;
                $scope.order.jAddrName = $scope.edit.addrName;
                $scope.order.jAddrType = type;
                $scope.order.jAddrId = $scope.edit.addrId;
                $scope.order.jAreaId = $scope.edit.areaId;
                $scope.order.jTreePath = $scope.edit.treePath;
            } else {
                $scope.order.dContact = $scope.edit.name_1;
                $scope.order.dMobile = $scope.edit.mobile_1;
                $scope.order.dAddress = $scope.edit.address;
                $scope.order.dAddrName = $scope.edit.addrName;
                $scope.order.dAddrType = type;
                $scope.order.dAddrId = $scope.edit.addrId;
                $scope.order.dAreaId = $scope.edit.areaId;
                $scope.order.dTreePath = $scope.edit.treePath;
            }
            layer.closeAll();
        };

        $scope.checkItem = function (item, type) {
            $scope.edit.addrId = item.id;
            $scope.edit.address = item.address;
            $scope.edit.addrName = item.name;
            $scope.edit.areaId = item.areaId;
            $scope.edit.treePath = item.treePath;
            $scope.edit["stationName" + type] = item.name;
        };

        //保存
        $scope.save = function (type) {
            // if($scope.deliverTimes.length>0 && !$scope.checkFlag){
            //     showWarn('请选择取包类型'); return;
            // }
            $scope.order.type = type;
            if (type == 2 || type == 3) {
                if ($scope._jADDRESS != ($scope.order.jTreePath + $scope.order.jAddress)
                    || $scope._dADDRESS != ($scope.order.dTreePath + $scope.order.dAddress)) {
                    layer.confirm('订单地址已变更，是否发送短信告知客户?', {icon: 3, title: '提示', btn: ['发送', '不发送']}, function (index) {
                        $scope.order.sendMsg = true;
                        layer.close(index);
                        CommonService.httpRequest({
                            url: '/order/update.api',
                            method: 'post',
                            data: $scope.order
                        }).then(function () {
                            showInfo('操作成功', function () {
                                $scope.detail();
                                $scope.getOptList();
                            });
                        });
                    }, function (index) {
                        $scope.order.sendMsg = false;
                        layer.close(index);
                        CommonService.httpRequest({
                            url: '/order/update.api',
                            method: 'post',
                            data: $scope.order
                        }).then(function () {
                            showInfo('操作成功', function () {
                                $scope.detail();
                                $scope.getOptList();
                            });
                        });
                    });
                }
                else {
                    CommonService.httpRequest({
                        url: '/order/update.api',
                        method: 'post',
                        data: $scope.order
                    }).then(function () {
                        showInfo('操作成功', function () {
                            $scope.detail();
                            $scope.getOptList();
                        });
                    });
                }
            }
            else {
                CommonService.httpRequest({
                    url: '/order/update.api',
                    method: 'post',
                    data: $scope.order
                }).then(function () {
                    showInfo('操作成功', function () {
                        $scope.detail();
                        $scope.getOptList();
                    });
                });
            }
        };
        //订单取消是否提示获取
        $scope.isTipCancel = function () {
            CommonService.httpRequest({
                url: '/order/order_cancel_calc_refund.api',
                method: 'post',
                data: {
                    id: $scope.id
                }
            }).then(function (data) {
                if (data.datas.tip) {
                    $scope.moneyCancel(data.datas);
                }
                else {
                    $scope.cancel();
                }
            });
        }

        //订单取消1
        $scope.cancel = function () {
            layer.confirm("是否确认取消该订单?", function (index) {
                CommonService.httpRequest({
                    url: '/order/order_cancel.api',
                    method: 'post',
                    data: {
                        id: $scope.id
                    }
                }).then(function () {
                    showInfo('取消成功', function () {
                        $scope.detail();
                    });
                });
                layer.close(index);
            })
        };

        //订单取消金额确认
        $scope.moneyCancel = function (item) {
            $scope.totalAmount = item.totalAmount;
            $scope.refundAmount = item.refundAmount;
            $scope.feeAmount = item.feeAmount;
            $scope.tipMsg = item.tipMsg;
            layer.open({
                type: 1,
                title: '订单取消退款确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['440px', '460px'], //宽高
                content: $('#moneyCancel'),
                btn: ['确定', '关闭'],
                yes: function (index, layero) {
                    if ((!$scope.refundAmount && $scope.refundAmount !== 0) || (!$scope.feeAmount && $scope.feeAmount !== 0) || !$scope.moneyMsg) {
                        showWarn('请完善填写信息');
                        return false;
                    }
                    CommonService.httpRequest({
                        url: '/order/order_cancel.api',
                        method: 'post',
                        data: {
                            id: $scope.id,
                            totalAmount: item.totalAmount,
                            refundAmount: $scope.refundAmount,
                            feeAmount: $scope.feeAmount,
                            tipMsg: $scope.moneyMsg
                        }
                    }).then(function () {
                        showInfo('取消成功', function () {
                            $scope.detail();

                        });
                    });
                    layer.close(index);
                },
                btn2: function (index, layero) {
                    $scope.refundAmount = item.refundAmount;
                    $scope.feeAmount = item.feeAmount;
                },
                end: function (index, layero) {
                    $scope.refundAmount = item.refundAmount;
                    $scope.feeAmount = item.feeAmount;
                }
            });
        };
        $scope.changeRefundAmount = function () {
            if (!$scope.refundAmount && $scope.refundAmount !== 0) {
                $scope.refundAmountMsg = '实际退款金额不能为空';
            }
            else if ($scope.refundAmount > $scope.totalAmount) {
                $scope.refundAmountMsg = '';
                $scope.feeAmountMsg = '';
                $scope.refundAmount = $scope.totalAmount;
                $scope.feeAmount = 0;
            }
            else {
                $scope.refundAmountMsg = '';
                $scope.feeAmountMsg = '';
                $scope.feeAmount = $scope.totalAmount - $scope.refundAmount;
            }
        };
        $scope.changeFeeAmount = function () {
            if (!$scope.feeAmount && $scope.feeAmount !== 0) {
                $scope.feeAmountMsg = '扣取金额不能为空';
            }
            else if ($scope.feeAmount > $scope.totalAmount) {
                $scope.feeAmountMsg = '';
                $scope.refundAmountMsg = ''
                $scope.feeAmount = $scope.totalAmount;
                $scope.refundAmount = 0;
            }
            else {
                $scope.feeAmountMsg = '';
                $scope.refundAmountMsg = ''
                $scope.refundAmount = $scope.totalAmount - $scope.feeAmount;
            }
        }


        //订单重新推送
        $scope.orderpush = function () {
            layer.confirm("是否确认重新推送该订单?", function (index) {
                CommonService.httpRequest({
                    url: '/order/order_push.api',
                    method: 'get',
                    data: {
                        id: $scope.id
                    }
                }).then(function () {
                    showInfo('推送成功');
                });
                layer.close(index);
            })
        };
        //确认已送包
        $scope.recvie = function () {
            CommonService.httpRequest({
                url: '/order/sf_recive.api',
                method: 'post',
                data: {
                    id: $scope.id
                }
            }).then(function () {
                showInfo('操作成功', function () {
                    $scope.detail();
                });
            });
        };
        $scope.layerRecvie = function () {
            layer.confirm('是否确认已取件?', {icon: 3, title: '提示'}, function (index) {
                $scope.recvie();
                layer.close(index);
            }, function (index) {
                layer.close(index);
            });
        };

        //客服确认收款
        $scope.changeKFReceivableStatus = function () {
            CommonService.httpRequest({
                url: '/order/receivable.api',
                method: 'get',
                data: {
                    id: $scope.id,
                    receivableType: 1
                }
            }).then(function () {
                showInfo('操作成功', function () {
                    $scope.detail();
                });
            });
        };

        // 点击提交微信支付码
        $scope.weixinPayCode = '';
        $scope.layerChangeKFReceivableStatus = function () {
            layer.confirm('客服是否确认收款?', {icon: 3, title: '提示'}, function (index) {
                if ($scope.weixinPayCode === '') {
                    showWarn('支付码不能为空');
                    return false;
                }
                CommonService.httpRequest({
                    url: '/order/updateWeixinPayCodeById.api',
                    method: 'get',
                    data: {
                        id: $scope.id,
                        weixinPayCode: $scope.weixinPayCode
                    }
                }).then(function (data) {
                });
                $scope.changeKFReceivableStatus();
                layer.close(index);
            }, function (index) {
                layer.close(index);
            });
        };

        //财务确认收款
        $scope.changeCWReceivableStatus = function () {
            CommonService.httpRequest({
                url: '/order/receivable.api',
                method: 'get',
                data: {
                    id: $scope.id,
                    receivableType: 2
                }
            }).then(function () {
                showInfo('操作成功', function () {
                    $scope.detail();
                });
            });
        };
        $scope.layerChangeCWReceivableStatus = function () {
            layer.confirm('财务是否确认收款?', {icon: 3, title: '提示'}, function (index) {
                $scope.changeCWReceivableStatus();
                layer.close(index);
            }, function (index) {
                layer.close(index);
            });
        };

        //查询客服记录
        $scope.checkKFRecord = function () {
            CommonService.httpRequest({
                url: '/orderMemo/list.api',
                method: 'get',
                data: {
                    orderId: $scope.id
                }
            }).then(function (data) {
                $scope.kfRecords = data.datas;
                for (var i = 0; i < $scope.kfRecords.length; i++) {
                    if ($scope.kfRecords[i].memo.indexOf('|') !== 0) {
                        $scope.kfRecords[i].memo = $scope.kfRecords[i].memo.replace(/(｜|\|)/g, '\n');
                    }
                }
            });
        };
        $scope.checkKFRecord();
        //添加客服记录
        $scope.addKFRecord = function () {
            if (!$scope.recordMemo) {
                showWarn('客服记录内容不能为空');
                return false;
            }
            CommonService.httpRequest({
                url: '/orderMemo/add.api',
                method: 'post',
                data: {
                    orderId: $scope.id,
                    memo: $scope.recordMemo
                }
            }).then(function (data) {
                $scope.optList = data.datas;
                $scope.checkKFRecord();
                $scope.recordMemo = '';
            });
        };

        //费用增减项目查询
        $scope.getOrderCostItem = function (page) {
            CommonService.pagination({
                url: '/orderCostItem/findByPage.api',
                data: {
                    pageNo: page || 1,
                    orderId: $scope.id,
                    pageSize: 100
                }
            }).then(function (data) {
                $scope.costes = data.item;
            });
        };
        $scope.costItemSelect = '特别优惠';
        $scope.$watch('costItemSelect', function (newVal, oldVal) {
            if (newVal && oldVal && newVal != oldVal) {
                $scope.costItem = newVal;
            }
        });

        //删除费用项目
        $scope.deleteCostItem = function (id) {
            CommonService.httpRequest({
                url: '/orderCostItem/delete.api',
                method: 'get',
                data: {
                    id: id
                }
            }).then(function (data) {
                showInfo('删除成功', function () {
                    $scope.getOrderCostItem();
                });
            });
        };

        //添加费用项目
        $scope.addCostItem = function () {

            if (!$scope.costItem) {
                showWarn('请输入或选择增减项目');
                return;
            }
            else if ($scope.costItem.length < 2) {
                showWarn('增减项目长度不能小于1位');
                return;
            }
            if (!$scope.costAmount && $scope.costAmount !== 0) {
                showWarn('金额不能为空');
                return;
            }
            else if ($scope.costAmount < -1000000 || $scope.costAmount > 10000) {
                showWarn('金额范围为-1000000~10000');
                return;
            }
            else {
                var stringCostAmount = String($scope.costAmount);
                var indexCostAmount = stringCostAmount.indexOf('.');
                if (indexCostAmount > -1) {
                    if (stringCostAmount.substring(indexCostAmount, stringCostAmount.length).length > 3) {
                        showWarn('金额小数点后只能一位');
                        return;
                    }
                }
            }

            CommonService.httpRequest({
                url: '/orderCostItem/add.api',
                method: 'post',
                data: {
                    amount: $scope.costAmount,
                    item: $scope.costItem,
                    orderId: $scope.id,
                    remark: $scope.costRemark,
                }
            }).then(function (data) {
                showInfo('添加费用增减项目成功', function () {
                    $scope.getOrderCostItem();
                });
            });
        };
        // 取、送包数据交换
        $scope.changeData = function () {
            // 存储送包信息
            $scope.dtemp.dAddress = $scope.order.dAddress;
            $scope.dtemp.dAreaId = $scope.order.dAreaId;
            $scope.dtemp.dContact = $scope.order.dContact;
            $scope.dtemp.dMobile = $scope.order.dMobile;
            $scope.dtemp.dTreePath = $scope.order.dTreePath;
            $scope.dtemp.dAddrName = $scope.order.dAddrName;
            $scope.dtemp.dAddrId = $scope.order.dAddrId;
            $scope.dtemp.dAddrType = $scope.order.dAddrType;
            $scope.dtemp.dOutRangePrice = $scope.order.dOutRangePrice;
            $scope.dtemp.dCourseStatus = $scope.order.dCourseStatus;
            $scope.dtemp.dTreeId = $scope.order.dTreeId;
            // 存储取包信息
            $scope.dtemp.jAddress = $scope.order.jAddress;
            $scope.dtemp.jAreaId = $scope.order.jAreaId;
            $scope.dtemp.jContact = $scope.order.jContact;
            $scope.dtemp.jMobile = $scope.order.jMobile;
            $scope.dtemp.jTreePath = $scope.order.jTreePath;
            $scope.dtemp.jAddrName = $scope.order.jAddrName;
            $scope.dtemp.jAddrId = $scope.order.jAddrId;
            $scope.dtemp.jAddrType = $scope.order.jAddrType;
            $scope.dtemp.jOutRangePrice = $scope.order.jOutRangePrice;
            $scope.dtemp.jCourseStatus = $scope.order.jCourseStatus;
            $scope.dtemp.jTreeId = $scope.order.jTreeId;
            // 开始交换数据
            $scope.order.dAddress = $scope.dtemp.jAddress;
            $scope.order.dAreaId = $scope.dtemp.jAreaId;
            $scope.order.dContact = $scope.dtemp.jContact;
            $scope.order.dMobile = $scope.dtemp.jMobile;
            $scope.order.dTreePath = $scope.dtemp.jTreePath;
            $scope.order.dAddrName = $scope.dtemp.jAddrName;
            $scope.order.dAddrId = $scope.dtemp.jAddrId;
            $scope.order.dAddrType = $scope.dtemp.jAddrType;
            $scope.order.dOutRangePrice = $scope.dtemp.jOutRangePrice;
            $scope.order.dCourseStatus = $scope.dtemp.jCourseStatus;
            $scope.order.dTreeId = $scope.dtemp.jTreeId;
            /* --------------------------------------------------- */
            $scope.order.jAddress = $scope.dtemp.dAddress;
            $scope.order.jAreaId = $scope.dtemp.dAreaId;
            $scope.order.jContact = $scope.dtemp.dContact;
            $scope.order.jMobile = $scope.dtemp.dMobile;
            $scope.order.jTreePath = $scope.dtemp.dTreePath;
            $scope.order.jAddrName = $scope.dtemp.dAddrName;
            $scope.order.jAddrId = $scope.dtemp.dAddrId;
            $scope.order.jAddrType = $scope.dtemp.dAddrType;
            $scope.order.jOutRangePrice = $scope.dtemp.dOutRangePrice;
            $scope.order.jCourseStatus = $scope.dtemp.dCourseStatus;
            $scope.order.jTreeId = $scope.dtemp.dTreeId;
        }
        // 是否显示运单号
        $scope.showMail = function (val) {
            val === '1' ? $('#mailChannelNo').addClass('fade') : $('#mailChannelNo').removeClass('fade')
        };


        //Vincent Chang 2017-11-29 Add 添加获取顺丰通知是否停止发送的状态
        $scope.getSFNoticeStatus = function (orderNo) {
            CommonService.httpRequest({
                url: '/sfnotify/findByPage.api',
                method: 'post',
                data: {
                    orderNumber: orderNo
                }
            }).then(function (data) {
                //已经禁用发送
                if (data.datas && data.datas.length > 0) {
                    $scope.sf_notice_string = "重新开启发送客户消息";
                    $scope.sf_notice_status = false;
                } else {
                    $scope.sf_notice_string = "停止发送客户消息";
                    $scope.sf_notice_status = true;
                }
            });
        };
        //禁用或启用
        $scope.updateSFNoticeStatus = function () {
            if ($scope.sf_notice_status) {
                CommonService.httpRequest({
                    url: '/sfnotify/disable.api',
                    method: 'post',
                    data: {
                        orderNumber: $scope.order.number
                    }
                }).then(function (data) {
                    showInfo('停止发送客户消息成功');
                    $scope.sf_notice_string = "重新开启发送客户消息";
                    $scope.sf_notice_status = false;
                });
            } else {
                CommonService.httpRequest({
                    url: '/sfnotify/enable.api',
                    method: 'post',
                    data: {
                        orderNumber: $scope.order.number
                    }
                }).then(function (data) {
                    showInfo('重新开启发送客户消息');
                    $scope.sf_notice_string = "停止发送客户消息";
                    $scope.sf_notice_status = true;
                });
            }


        };


        /*输入控制两位小数-start*/
        window.KeyUpTwoDecimal = function (obj) {
            // obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
            // obj.value = obj.value.replace(/^[0-9a-zA_Z]+$/g,"");  //清除“数字”和“.”以外的字符
            obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的
            obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
            obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');//只能输入两个小数
            // if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
            //   obj.value= parseFloat(obj.value);
            // }
            $(obj).trigger("change");
        }
    }]);
