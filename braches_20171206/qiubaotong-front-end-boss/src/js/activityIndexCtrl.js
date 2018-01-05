"use strict";
angular.module("app.views")
.controller('activityIndexCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });
    $scope.couponType = '1';
    $scope.status = '1';
    $scope.list = [];
    $scope.ruleId = '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/activity/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.activityName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    

    $scope.addActivity = function(){
        if(!$scope.activityName){
            showWarn("活动名称不能为空");
            return false;
        }
        if(!$scope.startTime){
            showWarn("券码开始时间不能为空");
            return false;
        }
        if(!$scope.endTime){
            showWarn("券码结束时间不能为空");
            return false;
        }
        if($scope.startTime > $scope.endTime){
            showWarn('券码开始时间不能大于券码结束时间');
            return;
        }
        if(!$scope.activityCode){
            showWarn("暗号不能为空");
            return false;
        }
        else{
            if(!(/^[A-Za-z0-9]{4,8}$/.test($scope.activityCode))){
                showWarn("暗号为4-8位的英文字母和数字组合");
                return false;
            }
        }
        if(!$scope.activityStartTime){
            showWarn("活动开始时间不能为空");
            return false;
        }
        if(!$scope.activityEndTime){
            showWarn("活动结束时间不能为空");
            return false;
        }
        if($scope.activityStartTime > $scope.activityEndTime){
            showWarn('活动开始时间不能大于活动结束时间');
            return;
        }
        if(!$scope.ruleId){
            showWarn("规则名称不能为空");
            return false;
        }
        if(!$scope.couponCount){
            showWarn("优惠券数量不能为空");
            return false;
        }
        else{
            if($scope.couponCount > 999999999){
                showWarn('优惠券数量不能大于999999999');
                return false;
            }
        }
        if(!$scope.maxPerOne){
            showWarn("个人领取次数不能为空");
            return false;
        }
        else{
            if($scope.maxPerOne > 999999999){
                showWarn('个人领取次数不能大于999999999');
                return false;
            }
        }

        CommonService.httpRequest({
            url : '/activity/add.api',
            method : 'post',
            data :{
                name : $scope.activityName,
                code : $scope.activityCode,
                startTime : new Date($scope.startTime).getTime(),
                endTime : new Date($scope.endTime).getTime(),
                activityStartTime : new Date($scope.activityStartTime).getTime(),
                activityEndTime : new Date($scope.activityEndTime).getTime(),
                maxPerOne : parseInt($scope.maxPerOne),
                desc : $scope.desc,
                amount : $scope.amount,
                couponCount : parseInt($scope.couponCount),
                status : $scope.status,
                ruleId : parseInt($scope.ruleId)
            }
        }).then(function(data){
            showInfo("新增成功",function(){
                tabOpenParent({name:'activityIndex',url:'activityIndex.html',displayName:'活动查询'});
            });
        });
    }

    $scope.conpunDetail = function(id){
        localStorage.setItem("manages", id);
        tabOpenParent({name:'coupunCheck',url:'coupunCheck.html',displayName:'优惠券'});
    }

    $scope.getRule = function(){
        CommonService.httpRequest({
            url : '/activityRule/list.api',
            method : 'get',
            data :{
            }
        }).then(function(data){
            $scope.rules = data.datas;
        });
    }

    $scope.setAmount = function(){
        if(!!$scope.ruleId){
            CommonService.httpRequest({
                url : '/activityRule/detail.api',
                method : 'get',
                data :{
                    id : $scope.ruleId
                }
            }).then(function(data){
                $scope.amount = data.datas.amount;
            });
        }
        else{
            $scope.amount = '';
        }
    }

    $scope.toActivity = function(){
        tabOpenParent({name:'activityIndexDetail',url:'activityIndexDetail.html',displayName:'新增活动'});
    }

     $scope.downloadActivity = function(id){
        window.open(rBasetUrl + '/activity/coupon.api?token=' + localStorage.getItem('token') + '&activityId=' + id);
    };

    $scope.getList(1);
    $scope.getRule();

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };
    
}]);


