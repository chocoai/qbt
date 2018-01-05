"use strict";
angular.module("app.views")
.controller('orderDownCtrl',['$scope','CommonService','Constants','$timeout',function($scope,CommonService,Constants,$timeout){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.order_type = Constants.order_type;
    $scope.sf_type = Constants.sf_type;
    $scope.id = CommonService.getQueryString('id');
    $scope.order = {};
    $scope.edit = {};
    $scope.languageIdList = [];
    $scope.reasonList = ['打球']; // 默认打球
    $scope.otherReasonShow = false;
    $scope.order.quantity = 1;
    $scope.order.amountPrice = 0;
    $scope.order.insurePrice = 1;
    $scope.order.quantityDesc = '';
    $scope.order.insurePriceDesc = '';
    $scope.order.jContact = $scope.order.jMobile = $scope.order.dContact = $scope.order.dMobile = '';
    $scope.dtemp = {};// 用于存储取/送包信息
    $scope.isOk = true;
    $scope.inputDiscount = 0;
    $scope.islinkWecat = function(num){
        CommonService.pagination({
            url : '/adminUser/findByPage.api',
            data :{
                pageNo : num || "1",
                mobile : localStorage.getItem('loginMobile')
            }
        }).then(function(data){
            if(!data.item[0].wxUserId){
                layer.confirm('需关联微信用户才能下单，是否前往平台用户管理页面进行关联？', {
                      btn: ['前往'], //按钮
                      closeBtn: 0,
                      title : '提示'
                  }, function(){
                      tabOpenParent({name:'manageCheck',url:'manageCheck.html?loginMobile='+localStorage.getItem('loginMobile'),displayName:'平台用户管理'});
                  });
            }
            else{
                $scope.wxUserId = data.item[0].wxUserId;
            }
        });
    }
    $scope.islinkWecat();

    $scope.editTime = function(){
        $scope.getTime();
        layer.open({
            type: 1,
            title : '时间信息修改',
            area: ['450px', '300px'],
            content: $('#editTime'),
            btn: ['确认', '取消'],
            zIndex : 900,
            yes: function(index){
                $scope.order.sendSfUserTime = new Date(($scope.edit.sendDate.replace(/-/g,"/") + ' ' + $scope.edit.sendTime).substr(0,16)+':00').getTime();
                $scope.order.sendTimeSection = $scope.edit.sendDate + ' ' + $scope.edit.sendTime;
                $scope.order.playTime = $scope.playTime;
                $scope.$apply();
                layer.close(index);
            }
        });
    };
    $scope.getTime = function(){
        if($scope.timeList && $scope.timeList.length>0){
            $scope.timeList2 = $scope.timeList[0].items;
            $scope.edit.sendDate = $scope.timeList[0].day;
            $scope.edit.sendTime = $scope.timeList[0].items[0];
            return;
        }
        CommonService.httpRequest({
            url : '/index/time.api',
            method : 'get',
            baseUrl : wBaseUrl
        }).then(function(data){
            $scope.timeList = data.datas;
            $scope.timeList2 = data.datas[0].items;
            $scope.edit.sendDate = data.datas[0].day;
            $scope.edit.sendTime = data.datas[0].items[0];
            $('.date-time').datetimepicker({
                format: "yyyy-mm-dd hh:00:00",
                autoclose: true,
                startDate: new Date($scope.edit.sendDate),
                minView :1,
                maxView : 1
            });
        });
    };

    $scope.changeTime = function(){
        for(var i=0;i<$scope.timeList.length;i++){
            var item = $scope.timeList[i];
            if(item.day == $scope.edit.sendDate){
                $scope.timeList2 = item.items;
                $('.date-time').datetimepicker({
                    format: "yyyy-mm-dd hh:00:00",
                    autoclose: true,
                    startDate: new Date($scope.edit.sendDate),
                    minView :1,
                    maxView : 1
                });
                $scope.edit.sendTime = item.items[0];
                break;
            }
        }
    };

    $scope.getUserAddr = function(page){
        $scope.userAddrList = [];
        CommonService.pagination({
            url : '/userAddress/findByPage.api',
            data :{
                userId : $scope.wxUserId,
                pageNo : page || 1
            }
        }).then(function(data){
            $scope.userAddrList = data.item;
            $scope.page = data.page;
        });
    };
    $scope.editAddr = function(type){
        var title = type == 1 ? '取包信息修改' : '送包信息修改';
        $scope.edit = {};
        $scope.edit.type = type;
        if($scope.order.jContact!== '' || $scope.order.dContact!== ''){
            switch (type) {
              case 1 : // 取包地址
                switch ($scope.order.jAddrType){
                  //选择1球场，2银行网点，5顺丰站点，3机场网点
                  case 4 : // 普通地址
                    $('#myTab>li:nth-child(1)').addClass('active').siblings().removeClass('active');
                    $('#userAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_2 = $scope.order.jContact;
                    $scope.edit.mobile_2 = $scope.order.jMobile;
                    $scope.edit.address = $scope.order.jAddress;
                    $scope.edit.name_1 = $scope.order.jContact;
                    $scope.edit.mobile_1 = $scope.order.jMobile;
                    var jsheng;
                    if($scope.order.jTreePath.split(',')[0].indexOf('重庆')!==-1||$scope.order.jTreePath.split(',')[0].indexOf('北京')!==-1||$scope.order.jTreePath.split(',')[0].indexOf('上海')!==-1||$scope.order.jTreePath.split(',')[0].indexOf('天津')!==-1||$scope.order.jTreePath.split(',')[0].indexOf('自治区')!==-1||$scope.order.jTreePath.split(',')[0].indexOf('省')!==-1){
                      jsheng = $scope.order.jTreePath.split(',')[0];
                    }else{
                      jsheng = $scope.order.jTreePath.split(',')[0];
                    }
                    $scope.edit.province = $scope.order.jTreeId.split(',')[0]+'|'+jsheng;
                    $scope.edit.city = $scope.order.jTreeId.split(',')[1]+'|'+(($scope.order.jTreePath.split(',')[1].indexOf('市')<0&&$scope.order.jTreePath.split(',')[1].indexOf('州')<0&&$scope.order.jTreePath.split(',')[1].indexOf('县')<0)?$scope.order.jTreePath.split(',')[1]+'市':$scope.order.jTreePath.split(',')[1]);
                    $scope.edit.country = $scope.order.jTreeId.split(',')[2]+'|'+$scope.order.jTreePath.split(',')[2];
                    CommonService.httpRequest({
                      url : '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.province.split('|')[0],
                      method : 'post',
                    }).then(function(data){
                      $scope.citieses = data.datas;
                    });
                    CommonService.httpRequest({
                      url : '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.city.split('|')[0],
                      method : 'post',
                    }).then(function(data){
                      $scope.countieses = data.datas;
                    });
                    break;
                  case 1 : // 球场
                    $('#myTab>li:nth-child(2)').addClass('active').siblings().removeClass('active');
                    $('#courtAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.jContact;
                    $scope.edit.mobile_1 = $scope.order.jMobile;
                    $scope.edit.addrId = $scope.order.jAddrId;
                    $scope.edit.addrName = $scope.order.jAddrName;
                    $scope.edit.address = $scope.order.jAddress;
                    $scope.edit.stationName1 = $scope.order.jAddrName;
                    $scope.edit.treePath = $scope.order.jTreePath;
                    $scope.edit.areaId = $scope.order.jAreaId;
                    break;
                  case 3 : // 银行网点
                    $('#myTab>li:nth-child(3)').addClass('active').siblings().removeClass('active');
                    $('#bankAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.jContact;
                    $scope.edit.mobile_1 = $scope.order.jMobile;
                    $scope.edit.addrId = $scope.order.jAddrId;
                    $scope.edit.addrName = $scope.order.jAddrName;
                    $scope.edit.address = $scope.order.jAddress;
                    $scope.edit.stationName3 = $scope.order.jAddrName;
                    $scope.edit.treePath = $scope.order.jTreePath;
                    $scope.edit.areaId = $scope.order.jAreaId;
                    break;
                  case 2 : // 机场网点
                    $('#myTab>li:nth-child(5)').addClass('active').siblings().removeClass('active');
                    $('#airAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.jContact;
                    $scope.edit.mobile_1 = $scope.order.jMobile;
                    $scope.edit.addrId = $scope.order.jAddrId;
                    $scope.edit.addrName = $scope.order.jAddrName;
                    $scope.edit.address = $scope.order.jAddress;
                    $scope.edit.stationName2 = $scope.order.jAddrName;
                    $scope.edit.treePath = $scope.order.jTreePath;
                    $scope.edit.areaId = $scope.order.jAreaId;
                    break;
                  case 5 : // 顺丰站点
                    $('#myTab>li:nth-child(4)').addClass('active').siblings().removeClass('active');
                    $('#sfAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.jContact;
                    $scope.edit.mobile_1 = $scope.order.jMobile;
                    $scope.edit.addrId = $scope.order.jAddrId;
                    $scope.edit.addrName = $scope.order.jAddrName;
                    $scope.edit.address = $scope.order.jAddress;
                    $scope.edit.stationName5 = $scope.order.jAddrName;
                    $scope.edit.treePath = $scope.order.jTreePath;
                    $scope.edit.areaId = $scope.order.jAreaId;
                    break;
                }
                $scope.edit.name_2 = $scope.order.jContact;
                $scope.edit.mobile_2 = $scope.order.jMobile;
                break;
              case 2 : // 送包地址
                switch ($scope.order.dAddrType) {
                  //选择1球场，2银行网点，5顺丰站点，3机场网点
                  case 4 : // 普通地址
                    $('#myTab>li:nth-child(1)').addClass('active').siblings().removeClass('active');
                    $('#userAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_2 = $scope.order.dContact;
                    $scope.edit.mobile_2 = $scope.order.dMobile;
                    $scope.edit.address = $scope.order.dAddress;
                    $scope.edit.name_1 = $scope.order.dContact;
                    $scope.edit.mobile_1 = $scope.order.dMobile;
                    var dsheng;
                    if($scope.order.dTreePath.split(',')[0].indexOf('重庆')!==-1||$scope.order.dTreePath.split(',')[0].indexOf('北京')!==-1||$scope.order.dTreePath.split(',')[0].indexOf('上海')!==-1||$scope.order.dTreePath.split(',')[0].indexOf('天津')!==-1||$scope.order.dTreePath.split(',')[0].indexOf('自治区')!==-1||$scope.order.dTreePath.split(',')[0].indexOf('省')!==-1){
                      dsheng = $scope.order.dTreePath.split(',')[0];
                    }else{
                      dsheng = $scope.order.dTreePath.split(',')[0];
                    }
                    $scope.edit.province =$scope.order.dTreeId.split(',')[0]+'|'+dsheng;
                    $scope.edit.city = $scope.order.dTreeId.split(',')[1]+'|'+(($scope.order.dTreePath.split(',')[1].indexOf('市')<0&&$scope.order.dTreePath.split(',')[1].indexOf('州')<0&&$scope.order.dTreePath.split(',')[1].indexOf('县')<0)?$scope.order.dTreePath.split(',')[1]+'市':$scope.order.dTreePath.split(',')[1]);
                    $scope.edit.country = $scope.order.dTreeId.split(',')[2]+'|'+$scope.order.dTreePath.split(',')[2];
                    CommonService.httpRequest({
                      url : '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.province.split('|')[0],
                      method : 'post',
                    }).then(function(data){
                      $scope.citieses = data.datas;
                    });
                    CommonService.httpRequest({
                      url : '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.city.split('|')[0],
                      method : 'post',
                    }).then(function(data){
                      $scope.countieses = data.datas;
                    });
                    break;
                  case 1 : // 球场
                    $('#myTab>li:nth-child(2)').addClass('active').siblings().removeClass('active');
                    $('#courtAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.dContact;
                    $scope.edit.mobile_1 = $scope.order.dMobile;
                    $scope.edit.addrId = $scope.order.dAddrId;
                    $scope.edit.addrName = $scope.order.dAddrName;
                    $scope.edit.address = $scope.order.dAddress;
                    $scope.edit.stationName1 = $scope.order.dAddrName;
                    $scope.edit.treePath = $scope.order.dTreePath;
                    $scope.edit.areaId = $scope.order.dAreaId;
                    break;
                  case 3 : // 银行网点
                    $('#myTab>li:nth-child(3)').addClass('active').siblings().removeClass('active')
                    $('#bankAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.dContact;
                    $scope.edit.mobile_1 = $scope.order.dMobile;
                    $scope.edit.addrId = $scope.order.dAddrId;
                    $scope.edit.addrName = $scope.order.dAddrName;
                    $scope.edit.address = $scope.order.dAddress;
                    $scope.edit.stationName3 = $scope.order.dAddrName;
                    $scope.edit.treePath = $scope.order.dTreePath;
                    $scope.edit.areaId = $scope.order.dAreaId;
                    break;
                  case 2 : // 机场网点
                    $('#myTab>li:nth-child(5)').addClass('active').siblings().removeClass('active');
                    $('#airAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.dContact;
                    $scope.edit.mobile_1 = $scope.order.dMobile;
                    $scope.edit.addrId = $scope.order.dAddrId;
                    $scope.edit.addrName = $scope.order.dAddrName;
                    $scope.edit.address = $scope.order.dAddress;
                    $scope.edit.stationName2 = $scope.order.dAddrName;
                    $scope.edit.treePath = $scope.order.dTreePath;
                    $scope.edit.areaId = $scope.order.dAreaId;
                    break;
                  case 5 : // 顺丰站点
                    $('#myTab>li:nth-child(4)').addClass('active').siblings().removeClass('active');
                    $('#sfAddr').addClass('in').addClass('active').siblings().removeClass('active');
                    $scope.edit.name_1 = $scope.order.dContact;
                    $scope.edit.mobile_1 = $scope.order.dMobile;
                    $scope.edit.addrId = $scope.order.dAddrId;
                    $scope.edit.addrName = $scope.order.dAddrName;
                    $scope.edit.address = $scope.order.dAddress;
                    $scope.edit.stationName5 = $scope.order.dAddrName;
                    $scope.edit.treePath = $scope.order.dTreePath;
                    $scope.edit.areaId = $scope.order.dAreaId;
                    break;
                }
                $scope.edit.name_2 = $scope.order.dContact;
                $scope.edit.mobile_2 = $scope.order.dMobile;
                break;
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
            title : title,
            area: ['850px', '500px'],
            content: $('#editAddr')
        });
    };
    $scope.getCourt = function(){
        if($scope.courtList && $scope.courtList.length>0){
            return;
        }
        CommonService.httpRequest({
            url : '/common/siteList.api',
            method : 'get',
            data : {
                type : 1
            }
        }).then(function(data){
            $scope.courtList = data.datas;
        });
    };
    $scope.getBank = function(){
        if($scope.bankList && $scope.bankList.length>0){
            return;
        }
        CommonService.httpRequest({
            url : '/common/siteList.api',
            method : 'get',
            data : {
                type : 2
            }
        }).then(function(data){
            $scope.bankList = data.datas;
        });
    };
    $scope.getSf = function(){
        if($scope.sfList && $scope.sfList.length>0){
            return;
        }
        CommonService.httpRequest({
            url : '/common/siteList.api',
            method : 'get',
            data : {
                type : 3
            }
        }).then(function(data){
            $scope.sfList = data.datas;
        });
    };
    $scope.getAir = function(){
        if($scope.airList && $scope.airList.length>0){
            return;
        }
        CommonService.httpRequest({
            url : '/common/siteList.api',
            method : 'get',
            data : {
                type : 4
            }
        }).then(function(data){
            $scope.airList = data.datas;
        });
    };
    $scope.getProvinces = function(){
        if($scope.provinceses && $scope.provinceses.length>0){
            return;
        }
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'get'
        }).then(function(data){
            $scope.provinceses = data.datas;
        });
    };
    $scope.getCitieses = function(){
        if(!$scope.edit.province){
            $scope.citieses = [];
            $scope.edit.city = "";
            return;
        }
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.province.split('|')[0],
            method : 'get'
        }).then(function(data){
            $scope.citieses = data.datas;
        });
    };
    $scope.getCounties = function(){
        if(!$scope.edit.city){
            $scope.countieses = [];
            $scope.edit.country = "";
            return;
        }
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=' + $scope.edit.city.split('|')[0],
            method : 'get'
        }).then(function(data){
            $scope.countieses = data.datas;
        });
    };
    //查询时效
    $scope.getBusinessType = function(){
        CommonService.httpRequest({
            // url : '/comm/query_sf_recive_time.api',
            // url : '/comm/v2/query_sf_recive_time.api',
            url : '/comm/v2/query_sf_recive_time_boss.api',
            method : 'post',
            data : {
                consigned_time : new Date($scope.order.sendSfUserTime).Format('yyyy-MM-dd hh:mm')+':00',
                src_area_id : $scope.order.jAreaId,
                dest_area_id : $scope.order.dAreaId,
                src_address : $scope.order.jAddress,
                dest_address :$scope.order.dAddress ,
                business_type : 0,
                src_course_id : $scope.order.jAddrType == '1' ? $scope.order.jAddrId : '',
                dest_course_id : $scope.order.dAddrType == '1' ? $scope.order.dAddrId : ''
            },
            baseUrl : wBaseUrl
        }).then(function(data){
            $scope.deliverTimes = data.datas;
            $('.checkDeliverTime').eq(0).prop('checked',true);
            $scope.order.deliverDate =  data.datas[0].deliver_time.split(',')[1];
            $scope.order.expressType = data.datas[0].business_type;
            $scope.order.sfPrice = data.datas[0].sf_price;
            $scope.order.outRangePrice = data.datas[0].out_range_price;
            $scope.getFullCut();
        });
    };

    //boss下单检查是否支持vip订单
    $scope.checkOrderIsVip = function(){
        CommonService.httpRequest({
            url : '/vipInfo/checkVipOrder.api',
            method : 'post',
            data : {
                srcCourseId : $scope.order.jAddrType == '1' ? $scope.order.jAddrId : '',
                destCourseId : $scope.order.dAddrType == '1' ? $scope.order.dAddrId : '',
                src_address : $scope.order.jAddress,
                dest_address : $scope.order.dAddress,
                src_area_id : $scope.order.jAreaId,
                dest_area_id : $scope.order.dAreaId,
                jName   : $scope.order.jContact,
                jMobile : $scope.order.jMobile,
                dName   : $scope.order.dContact,
                dMobile : $scope.order.dMobile,
                consignedTime : $scope.order.sendTimeSection,
                num : $scope.order.quantity
            }
        }).then(function(data){
            var datas = data.datas;
            $scope.order.isVipOrder = datas.vipOrder;
            $scope.order.vipNumber = datas.num || 0;
            $scope.order.vipOrderAmount = 0;
            if(datas.vipOrderAmount && datas.vipOrderAmount.length > 0){
                $scope.order.outRangeAmount = datas.outRangeAmount;
                for(var i = 0; i < datas.vipOrderAmount.length; i++){
                    var singleVipAmount = datas.vipOrderAmount[i] + $scope.order.amountPrice + $scope.order.outRangeAmount - $scope.inputDiscount;
                    singleVipAmount = singleVipAmount < 0 ? 0 : singleVipAmount;
                    $scope.order.vipOrderAmount = $scope.order.vipOrderAmount + singleVipAmount;
                }
                $scope.order.vipOrderAmount = parseFloat(Number($scope.order.vipOrderAmount).toFixed(2));
                $scope.order.vipOrderAmountList = datas.vipOrderAmount.unique();
                $scope.order.vipOrderAmountNum = datas.vipOrderAmount.sortAndCount();
            }
            CommonService.httpRequest({
                url : '/activityOff/checkActivity.api',
                method : 'post',
                data : {
                    jAddrType : $scope.order.jAddrType,
                    jAddrId : $scope.order.jAddrType == '1' ? $scope.order.jAddrId : '',
                    jAreaId : $scope.order.jAreaId,
                    jAddrName : $scope.order.jContact,
                    dAddrType : $scope.order.dAddrType,
                    dAddrId : $scope.order.dAddrType == '1' ? $scope.order.dAddrId : '',
                    dAreaId : $scope.order.dAreaId,
                    dAddrName : $scope.order.dContact,
                    freight : $scope.order.sfPrice
                }
            }).then(function(data){
                $scope.order.fcJActivity = data.datas.jActivity;
                $scope.order.fcDActivity = data.datas.dActivity;
                $scope.order.fcJAmount = data.datas.jAmount || 0;
                $scope.order.fcDAmount = data.datas.dAmount || 0;
                if($scope.order.isVipOrder){
                    $scope.order.cutAmount = ($scope.order.quantity - $scope.order.vipNumber) * ($scope.order.fcDAmount + $scope.order.fcJAmount);
                    $scope.order.normalAllAmount = ($scope.order.quantity - $scope.order.vipNumber)
                                                 * ($scope.order.sfPrice + $scope.order.amountPrice - $scope.inputDiscount)
                                                 - $scope.order.cutAmount;
                    $scope.order.normalAllAmount = $scope.order.normalAllAmount < 0 ? 0 : $scope.order.normalAllAmount;

                    $scope.order.allAmount =  $scope.order.normalAllAmount + $scope.order.vipOrderAmount;
                    $scope.order.allAmount = $scope.order.allAmount < 0 ? 0 : $scope.order.allAmount;

                    $scope.order.price = ($scope.order.sfPrice + $scope.order.amountPrice) - ($scope.order.fcDAmount + $scope.order.fcJAmount);
                }
                else{
                    $scope.order.cutAmount = ($scope.order.quantity) * ($scope.order.fcDAmount + $scope.order.fcJAmount);
                    $scope.order.allAmount = ($scope.order.quantity) * ($scope.order.sfPrice + $scope.order.amountPrice) - $scope.order.cutAmount - ($scope.order.quantity * $scope.inputDiscount);
                    $scope.order.price = ($scope.order.sfPrice + $scope.order.amountPrice) - ($scope.order.fcDAmount + $scope.order.fcJAmount);
                }
                $scope.order.allAmount = $scope.order.allAmount < 0 ? 0 : $scope.order.allAmount;
            });
        });
    };

    $scope.$watch("order.sendSfUserTime",function(newValue, oldValue){
        if(!!$scope.order.sendSfUserTime && !!$scope.order.jAreaId && !!$scope.order.dAreaId){
            $scope.getBusinessType();
        }
    });
    $scope.$watch("order.jAddress",function(newValue, oldValue){
        if(!!$scope.order.sendSfUserTime && !!$scope.order.jAreaId && !!$scope.order.dAreaId){
            $scope.getBusinessType();
        }
    });
    $scope.$watch("order.jTreePath",function(newValue, oldValue){
        if(!!$scope.order.sendSfUserTime && !!$scope.order.jAreaId && !!$scope.order.dAreaId){
            $scope.getBusinessType();
        }
    });
    $scope.$watch("order.dAddress",function(newValue, oldValue){
        if(!!$scope.order.sendSfUserTime && !!$scope.order.jAreaId && !!$scope.order.dAreaId){
            $scope.getBusinessType();
        }
    });
    $scope.$watch("order.dTreePath",function(newValue, oldValue){
        if(!!$scope.order.sendSfUserTime && !!$scope.order.jAreaId && !!$scope.order.dAreaId){
            $scope.getBusinessType();
        }
    });
    $scope.checkBusiness = function(item){
        $scope.order.deliverDate = item.deliver_time.split(',')[1];
        $scope.order.expressType = item.business_type;
        $scope.order.describe = item.describe;
        $scope.order.sfPrice = item.sf_price;
        $scope.getFullCut();
    };

    //只改联系人
    $scope.changeUserName = function(){
        if(!$scope.edit.name || !$scope.edit.mobile){
            showWarn('请填写姓名手机号'); return;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.edit.mobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.edit.mobile))){
            }
            else{
                showWarn("联系电话格式错误");
                $scope.edit.mobile = '';
                return;
            }
        }
        if($scope.edit.type == 1){
            $scope.order.jContact = $scope.edit.name;
            $scope.order.jMobile = $scope.edit.mobile;
        }else{
            $scope.order.dContact = $scope.edit.name;
            $scope.order.dMobile = $scope.edit.mobile;
        }
        layer.closeAll();
    };

    //选择用户地址
    $scope.checkUserAddr = function(item){
        if($scope.edit.type == 1){
            $scope.order.jContact = item.contact;
            $scope.order.jMobile = item.mobile;
            $scope.order.jAddress = item.address;
            $scope.order.jAddrName = '';
            $scope.order.jAddrType = 4;
            $scope.order.jTreePath = item.treePath;
            $scope.order.jAreaId = item.areaId;
            $scope.order.jTreeId = item.treeId;
        }else{
            $scope.order.dContact = item.contact;
            $scope.order.dMobile = item.mobile;
            $scope.order.dAddress = item.address;
            $scope.order.dAddrName = '';
            $scope.order.dAddrType = 4;
            $scope.order.dTreePath = item.treePath;
            $scope.order.dAreaId = item.areaId;
            $scope.order.dTreeId = item.treeId;
        }
        layer.closeAll();
    };

    //新增用户地址
    $scope.addUserAddr = function(){
        if(!$scope.edit.name_2 || !$scope.edit.mobile_2 || !$scope.edit.address || !$scope.edit.country){
            showWarn('请填写完整信息'); return;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.edit.mobile_2)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.edit.mobile_2))){
            }
            else{
                showWarn("联系电话格式错误");
                $scope.edit.mobile_2 = '';
                return;
            }
        }
        if($scope.edit.type == 1){
            $scope.order.jContact = $scope.edit.name_2;
            $scope.order.jMobile = $scope.edit.mobile_2;
            $scope.order.jAddress = $scope.edit.address;
            $scope.order.jAddrName = '';
            $scope.order.jAddrType = 4;
            $scope.order.jTreePath = $scope.edit.province.split('|')[1] + ',' + $scope.edit.city.split('|')[1] + ',' + $scope.edit.country.split('|')[1];
            $scope.order.jAreaId = Number($scope.edit.country.split('|')[0]);
            $scope.order.jTreeId = $scope.edit.province.split('|')[0] + ',' + $scope.edit.city.split('|')[0] + ',' + $scope.edit.country.split('|')[0];
        }else{
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

    //选择1球场，3银行网点，5顺丰站点，2机场网点
    $scope.checkStation = function(type){
        if(!$scope.edit.name_1){
            showWarn('请填写联系人'); return;
        }
        if(!$scope.edit.mobile_1){
            showWarn('请填写手机号'); return;
        }
        else{
            if(!(/^1[3|4|5|7|8]\d{9}$/.test($scope.edit.mobile_1))){
                showWarn("手机号码格式错误");
                return;
            }
        }
        if(!$scope.edit.addrId){
            showWarn('请选择地址'); return;
        }
        if($scope.edit.type == 1){
            $scope.order.jContact = $scope.edit.name_1;
            $scope.order.jMobile = $scope.edit.mobile_1;
            $scope.order.jAddress = $scope.edit.address;
            $scope.order.jAddrName = $scope.edit.addrName;
            $scope.order.jAddrType = type;
            $scope.order.jAddrId = $scope.edit.addrId;
            $scope.order.jAreaId = $scope.edit.areaId;
            $scope.order.jTreePath = $scope.edit.treePath;
        }else{
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

    $scope.checkItem = function(item,type){
        $scope.edit.addrId = item.id;
        $scope.edit.address = item.address;
        $scope.edit.addrName = item.name;
        $scope.edit.areaId = item.areaId;
        $scope.edit.treePath = item.treePath;
        $scope.edit["stationName"+ type] = item.name;
    };

    $scope.getLanuage = function(){
        CommonService.httpRequest({
            url : '/baseLanguage/list.api',
            method : 'post',
        }).then(function(data){
            $scope.languageLists = data.datas;
            $scope.order.langName = $scope.languageLists[0].ename + '|' + $scope.languageLists[0].name;
        });
    }
    $scope.getLanuage();
    //语言配置
    $scope.isClick = function(id){
        if($scope.languageIdList.indexOf(id) == -1){
            $scope.languageIdList.push(id);
        }
        else{
            var idx = $scope.languageIdList.indexOf(id);
            $scope.languageIdList.splice(idx,1);
        }
    };

    //获取初始化保价金额
    $scope.getStartInsurePrice = function(){
        CommonService.httpRequest({
            url:'/index/query_insured.api',
            method : 'get',
            baseUrl : wBaseUrl
        }).then(function(data){
            $scope.order.insurePrice = data.datas.min;
            $scope.order.amountPrice = data.datas.insuredPrice;
            $scope.order.max = data.datas.max;
            $scope.order.min = data.datas.min;
        });
    };
    $scope.getInsure = function(){
        if(($scope.order.insurePrice || $scope.order.insurePrice == 0) && String($scope.order.insurePrice).indexOf('.') == -1){
            if($scope.order.insurePrice < $scope.order.min){
                $scope.order.insurePriceDesc = '保价金额不能小于'+$scope.order.min+'万元';
                $scope.isOk = false;
            }
            else if($scope.order.insurePrice > $scope.order.max){
                $scope.order.insurePriceDesc = '保价金额不能大于'+$scope.order.max+'万元';
                $scope.order.insurePrice = '';
                $scope.order.amountPrice = 0;
                $scope.isOk = false;
            }
            else{
                $scope.order.insurePriceDesc = '';
                CommonService.httpRequest({
                    url : '/index/insure.api',
                    method : 'get',
                    data : {
                        price : $scope.order.insurePrice
                    },
                    baseUrl : wBaseUrl
                }).then(function(data){
                    $scope.order.amountPrice = data.datas;
                });
                $scope.getFullCut();
                $scope.isOk = true;
            }

        }
        else{
            $scope.order.insurePriceDesc = '保价金额需为正整数';
            $scope.isOk = false;
        }
    };
    $scope.getBeforeFullCut = function(){
        if(!$scope.order.quantity && $scope.order.quantity != 0){
            $scope.order.quantityDesc = '球包数量不能小于1';
            $scope.isOk = false;
        }
        else if($scope.order.quantity == 0){
            $scope.order.quantity = '';
            $scope.order.quantityDesc = '球包数量不能小于1';
            $scope.isOk = false;
        }
        else if(String($scope.order.quantity).indexOf('.') > 0 ){
            $scope.order.quantityDesc = '球包数量需为整数';
            $scope.order.quantity = Math.round($scope.order.quantity);
            $scope.isOk = false;
        }
        else if($scope.order.quantity > 99){
                $scope.order.quantityDesc = '球包数量不能大于99';
                $scope.order.quantity = '';
                $scope.isOk = false;
        }
        else{
            $scope.order.quantityDesc = '';
            $scope.getFullCut();
            $scope.isOk = true;
        }
    }
    $scope.showOrder = function(){
        if(!$scope.order.jAreaId || !$scope.order.dAreaId ||
            !$scope.order.sendSfUserTime ||
            !$scope.order.deliverDate ||
            !$scope.order.sfPrice ||
            !$scope.order.langName ||
            (!$scope.order.insurePrice && $scope.order.insurePrice != 0) ||
            (!$scope.order.quantity && $scope.order.quantity != 0) || !$scope.isOk
            ){
            showWarn('请完善订单信息');
            return false;
        }
        if($scope.order.quantity == 0){
            showWarn('球包数量不能小于1');
            return false;
        }
        if($scope.otherReasonShow){
            if(!$scope.otherReason){
                showWarn('需填写其他原因');
                return ;
            }
        }
        if($scope.reasonList.length == 0 && !$scope.otherReasonShow){
            showWarn('请选择客户打球原因');
            return ;
        }
        if($scope.inputDiscountMsg){
            showWarn('每包优惠金额为0-10000的整数');
            return;
        }
        //Vincent Add 2011-11-22
        if($scope.inputDiscount>=$scope.order.price) {
            showWarn('每包优惠金额不得超过每包运费金额');
            return;
        }

        //
        if($scope.inputDiscount)

        $scope.check_consigned_time = new Date($scope.order.sendSfUserTime).getTime();
        if(($scope.check_consigned_time - (new Date()).getTime()) < 3600000){
            showWarn('预约取件时间已失效，请重新选择');
            return false;
        }
        $scope.getFullCut();
        $timeout(function(){
            layer.open({
                type: 1,
                title : '订单信息',
                area: ['460px', '520px'],
                content: $('#showOrder'),
                btn: ['确认', '取消'],
                zIndex : 1000,
                yes: function(index){
                    $scope.orderDown();
                    $scope.$apply();
                    layer.close(index);
                },
                end: function(){
                    if($scope.otherReasonShow){
                        if($scope.otherReason){
                            for(var i in $scope.reasonList){
                                if($scope.reasonList[i]=='活动' || $scope.reasonList[i]=='打球' || $scope.reasonList[i]=='返程'|| $scope.reasonList[i]=='旅游'){

                                }
                                else{
                                    $scope.reasonList.splice(i,1);
                                }
                            }
                        }
                    }
                }
            });
        });
        $('#showOrderBtn').blur();
    };

    $scope.getFullCut = function(){
        $scope.order.allAmount = 0;
        if(!!$scope.order.sendSfUserTime && !!$scope.order.jAreaId && !!$scope.order.dAreaId){
            $scope.checkOrderIsVip();
        }
    };


    $scope.orderDown = function(){

        if(($scope.check_consigned_time - (new Date()).getTime()) < 3600000){
            showWarn('预约取件时间已失效，请重新选择');
            return false;
        }
        if($scope.otherReasonShow){
            if($scope.otherReason){
                $scope.reasonList.push($scope.otherReason);
            }
        }
        CommonService.httpRequest({
            url : '/order/create.api',
            method : 'post',
            data : {
                business_type : $scope.order.expressType,
                weight  : 18,
                consigned_time : $scope.order.sendTimeSection,
                src_province : $scope.order.jTreePath.split(',')[0],
                src_city : $scope.order.jTreePath.split(',')[1],
                src_district : $scope.order.jTreePath.split(',')[2],
                src_address : $scope.order.jAddress,
                src_area_id : $scope.order.jAreaId,
                src_course_id : $scope.order.jAddrType == 1 ? $scope.order.jAddrId : '',
                src_id : $scope.order.jAddrType != '4' ? $scope.order.jAddrId : '',
                playTime : $scope.order.playTime,
                dest_province : $scope.order.dTreePath.split(',')[0],
                dest_city : $scope.order.dTreePath.split(',')[1],
                dest_district : $scope.order.dTreePath.split(',')[2],
                dest_address : $scope.order.dAddress,
                dest_area_id : $scope.order.dAreaId,
                dest_course_id : $scope.order.dAddrType == 1 ? $scope.order.dAddrId : '',
                dest_id : $scope.order.dAddrType != '4' ? $scope.order.dAddrId : '',

                src_type : $scope.order.jAddrType,
                src_moibile : $scope.order.jMobile,
                src_name : $scope.order.jContact,

                dest_type : $scope.order.dAddrType,
                dest_moibile : $scope.order.dMobile,
                dest_name : $scope.order.dContact,

                price : $scope.order.price,
                insure_price : $scope.order.insurePrice,
                deliver_time : $scope.order.deliverDate,
                freight : $scope.order.sfPrice,
                quantity  : $scope.order.quantity || 1,
                totalPrice : $scope.order.allAmount,
                inputDiscount : $scope.inputDiscount,

                langName : $scope.order.langName.split('|')[0],
                reason : $scope.reasonList.join(','),
                remark : $scope.remark
            }
        }).then(function(data){
            if($scope.otherReasonShow){
                if($scope.otherReason){
                    for(var i in $scope.reasonList){
                        if($scope.reasonList[i]=='活动' || $scope.reasonList[i]=='打球' || $scope.reasonList[i]=='返程'|| $scope.reasonList[i]=='旅游'){

                        }
                        else{
                            $scope.reasonList.splice(i,1);
                        }
                    }
                }
            }
            layer.msg('下单成功',{icon:6,time:2000},function(){
                tabOpenParent({name:'orderMgr',url:'orderMgr.html',displayName:'订单查询'});
            });
        });
    }

    //原因配置
    $scope.isReasonClick = function(val){

        if($scope.reasonList.indexOf(val) == -1){
            $scope.reasonList.push(val);
        }
        else{
            var idx = $scope.reasonList.indexOf(val);
            $scope.reasonList.splice(idx,1);
        }
    };

    $scope.getStartInsurePrice();

    $scope.moveDiscount = function(){
        if($scope.inputDiscount || $scope.inputDiscount === 0){
            if(!/^[1]{0,1}[0-9]{0,4}$/.test($scope.inputDiscount)){
                $scope.inputDiscountMsg = '每包优惠金额为0-10000的整数';
            }
            else{
                //Vincent Add 2011-11-22
                if($scope.inputDiscount>=$scope.order.price){
                    $scope.inputDiscountMsg = '每包优惠金额不得超过每包运费金额';
                }else{
                    $scope.inputDiscountMsg = '';
                }
            }
        }
        else{
            $scope.inputDiscount = '';
            $scope.inputDiscountMsg = '每包优惠金额为0-10000的整数';
        }
    }

    // 复制数据
    $scope.copyData = function (num) {
        switch (num){
          case 1 :
            if($scope.order.jContact === ''|| $scope.order.jContact === null || $scope.order.jMobile === '' || $scope.order.jMobile === null){
                showWarn('取包信息均不能为空');
                return false;
            }else{
              $scope.order.dContact = $scope.order.jContact;
              $scope.order.dMobile = $scope.order.jMobile;
              $scope.order.dAddress = $scope.order.jAddress;
              $scope.order.dAreaId = $scope.order.jAreaId;
              $scope.order.dTreePath = $scope.order.jTreePath;
              $scope.order.dAddrId = $scope.order.jAddrId;
              $scope.order.dAddrType = $scope.order.jAddrType;
              $scope.order.dTreeId = $scope.order.jTreeId;
              if($scope.order.dAddrType!==4){
                $scope.order.dAddrName = $scope.order.jAddrName;
                $scope.edit.addrId = $scope.order.jAddrId;
              }
            }
            break;
          case 2 :
            if($scope.order.dContact === ''|| $scope.order.dContact === null || $scope.order.dMobile === '' || $scope.order.dMobile ===null){
              showWarn('送包信息均不能为空');
              return false;
            }else{
              $scope.order.jContact = $scope.order.dContact;
              $scope.order.jMobile = $scope.order.dMobile;
              $scope.order.jAddress = $scope.order.dAddress;
              $scope.order.jAreaId = $scope.order.dAreaId;
              $scope.order.jTreePath = $scope.order.dTreePath;
              $scope.order.jAddrId = $scope.order.dAddrId;
              $scope.order.jAddrType = $scope.order.dAddrType;
              $scope.order.jTreeId = $scope.order.dTreeId;
              if($scope.order.jAddrType!==4){
                $scope.order.jAddrName = $scope.order.dAddrName;
                $scope.edit.addrId = $scope.order.dAddrId;
              }
            }
            break;
        }
    };
    // 取、送包数据交换
    $scope.changeData = function () {
        if($scope.order.dContact === '' || $scope.order.jContact === ''){
          showWarn('寄包与送包信息不能为空');
          return false;
        }
        // 存储送包信息
        $scope.dtemp.dAddress = $scope.order.dAddress;
        $scope.dtemp.dAreaId = $scope.order.dAreaId;
        $scope.dtemp.dContact = $scope.order.dContact;
        $scope.dtemp.dMobile = $scope.order.dMobile;
        $scope.dtemp.dTreePath = $scope.order.dTreePath;
        $scope.dtemp.dAddrName = $scope.order.dAddrName;
        $scope.dtemp.dAddrId = $scope.order.dAddrId;
        $scope.dtemp.dAddrType = $scope.order.dAddrType;
        // $scope.dtemp.dOutRangePrice = $scope.order.dOutRangePrice;
        // $scope.dtemp.dCourseStatus = $scope.order.dCourseStatus;
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
        // $scope.dtemp.jOutRangePrice = $scope.order.jOutRangePrice;
        // $scope.dtemp.jCourseStatus = $scope.order.jCourseStatus;
        $scope.dtemp.jTreeId =$scope.order.jTreeId;
        // 开始交换数据
        $scope.order.dAddress = $scope.dtemp.jAddress;
        $scope.order.dAreaId = $scope.dtemp.jAreaId;
        $scope.order.dContact = $scope.dtemp.jContact;
        $scope.order.dMobile = $scope.dtemp.jMobile;
        $scope.order.dTreePath = $scope.dtemp.jTreePath;
        $scope.order.dAddrName = $scope.dtemp.jAddrName;
        $scope.order.dAddrId = $scope.dtemp.jAddrId;
        $scope.order.dAddrType = $scope.dtemp.jAddrType;
        // $scope.order.dOutRangePrice = $scope.dtemp.jOutRangePrice;
        // $scope.order.dCourseStatus = $scope.dtemp.jCourseStatus;
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
        // $scope.order.jOutRangePrice = $scope.dtemp.dOutRangePrice;
        // $scope.order.jCourseStatus = $scope.dtemp.dCourseStatus;
        $scope.order.jTreeId = $scope.dtemp.dTreeId;
    }
}]);
