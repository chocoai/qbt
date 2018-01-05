"use strict";
angular.module("app.views")
.controller('saleScoreCountCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });
    $scope.startDate = new Date().Format('yyyy-MM-dd');
    $scope.endDate = new Date().Format('yyyy-MM-dd');
    $scope.startDate1 = new Date().Format('yyyy-MM-dd');
    $scope.endDate1 = new Date().Format('yyyy-MM-dd');
    $scope.isLeft = true;

    $scope.delivery_Status = Constants.delivery_Status;

    $scope.getList = function(num){
        if($scope.startDate && $scope.endDate && ($scope.startDate > $scope.endDate)){
            showWarn('开始时间不能大于结束时间');
            return;
        }else {
            CommonService.pagination({
                url : '/sale/order/findByPage.api?token='+CommonService.getToken(),
                baseUrl:rBasetUrl,
                data :{
                    pageNo : num || "1",
                    pageSize : 30,
                    deliveryStatus : $scope.deliveryStatus || '',
                    endDate : $scope.endDate || '',
                    startDate : $scope.startDate || '',
                    mobile : $scope.mobile || '',
                    name : $scope.name || '',
                    orderStatus : $scope.orderStatus || '',
                    salesmanCode : $scope.salesmanCode || '',
                    settleStatus : $scope.settleStatus || '',

                }
            }).then(function(data){
                $scope.list = data.item;
                $scope.page = data.page;
            });
        }

    }

    $scope.getNewList = function(num){
        if($scope.startDate1 && $scope.endDate1 && ($scope.startDate1 > $scope.endDate1)) {
            showWarn('开始时间不能大于结束时间');
            return;
        } else{
            CommonService.pagination({
                url : '/sale/subcripbe/findByPage.api?token='+CommonService.getToken(),
                baseUrl:rBasetUrl,
                data :{
                    pageNo : num || "1",
                    pageSize : 30,
                    endDate : $scope.endDate1 || '',
                    startDate : $scope.startDate1 || '',
                    mobile : $scope.mobile1 || '',
                    name : $scope.name1 || '',
                    salesmanCode : $scope.salesmanCode1 || '',
                    settleStatus : $scope.settleStatus1 || '',
                }
            }).then(function(data){
                $scope.list1 = data.item;
                $scope.page1 = data.page;
            });
        }

    }




    $scope.saledown = function(){
        if(!$scope.startDate || !$scope.endDate){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
    	else{
            if($scope.startDate > $scope.endDate){
                showWarn('开始时间不能大于结束时间');
                return;
            }
            window.open(rBasetUrl + '/sale/order/export.api?token=' + localStorage.getItem('token') + '&startDate=' + ($scope.startDate || '') +
                 '&endDate=' + ($scope.endDate || '') + '&deliveryStatus=' + ($scope.deliveryStatus || '') + '&mobile=' +($scope.mobile || '')
                 + '&name=' + ($scope.name || '') + '&orderStatus=' + ($scope.orderStatus || '') + '&salesmanCode=' + ($scope.salesmanCode || '')
                 + '&settleStatus=' + ($scope.settleStatus || '')
             );
         }
    };
    $scope.saledown2 = function(){
        if(!$scope.startDate1 || !$scope.endDate1){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
    	else{
            if($scope.startDate1 > $scope.endDate1){
                showWarn('开始时间不能大于结束时间');
                return;
            }
        window.open(rBasetUrl + '/sale/subcripbe/export.api?token=' + localStorage.getItem('token') + '&startDate=' + ($scope.startDate1 || '') +
             '&endDate=' + ($scope.endDate1 || '')  + '&mobile=' + ($scope.mobile1 || '') + '&name=' + ($scope.name1 || '') +
             '&salesmanCode=' + ($scope.salesmanCode1 || '') + '&settleStatus=' + ($scope.settleStatus1 || '')
         );
         }
    };
    $scope.toDetail = function(id,name){
        tabOpenParent({name:'saleManManageDetail'+id,url:'saleManManageDetail.html?id='+id,displayName:'销售人员'+name});
    }
    $('#list').focus();
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter 键
            if($scope.isLeft){
                $scope.getList();
            }
            else{
                $scope.getNewList();
            }
        }
    };


}]);
