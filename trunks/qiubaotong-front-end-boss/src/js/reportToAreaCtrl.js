"use strict";
angular.module("app.views")
.controller('reportToAreaCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearStartTime = function(){
        $scope.startTime = '';
    }
    $scope.clearEndTime = function(){
        $scope.endTime = '';
    }
    $scope.startTime = new Date().Format('yyyy-MM-dd');
    $scope.endTime = new Date().Format('yyyy-MM-dd');
    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/orderArea/findByPage.api?token=' + localStorage.getItem('token'),
            baseUrl : rBasetUrl,
        	data :{
        		pageNo : num || "1",
                startDate:$scope.startTime,
                endDate:$scope.endTime,
                jAreaId:$scope.county1 || $scope.city1 || $scope.province1,
                dAreaId:$scope.county2 || $scope.city2 || $scope.province2
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    // $scope.getList(1);

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses1 = data.datas;
            $scope.provinceses2 = data.datas;
        });
    }
    $scope.getProvinces();
    $scope.getCitieses = function(id){
        if(id == 1){
            if(!!$scope.province1){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province1,
                    method : 'post',
                }).then(function(data){
                    $scope.citieses1 = data.datas;
                });

            }
            else{
                $scope.citieses1 = '';
                $scope.countieses1 = '';
            }
            $scope.city1 = '';
            $scope.county1 = '';
        }
        else{
            if(!!$scope.province2){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province2,
                    method : 'post',
                }).then(function(data){
                    $scope.citieses2 = data.datas;
                });

            }
            else{
                $scope.citieses2 = '';
                $scope.countieses2 = '';
            }
            $scope.city2 = '';
            $scope.county2 = '';
        }
    }
    $scope.getCounties = function(id){
        if(id == 1){
            if(!!$scope.city1){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city1,
                    method : 'post',
                }).then(function(data){
                    $scope.countieses1 = data.datas;
                });
            }
            else{
                $scope.countieses1 = '';
            }
            $scope.county1 = '';
        }
        else{
            if(!!$scope.city2){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city2,
                    method : 'post',
                }).then(function(data){
                    $scope.countieses2 = data.datas;
                });
            }
            else{
                $scope.countieses2 = '';
            }
            $scope.county2 = '';
        }
    }

    $scope.reportDownload = function(){
    	if(!$scope.startTime || !$scope.endTime){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
    	else{
            if($scope.startTime > $scope.endTime){
                showWarn('开始时间不能大于结束时间');
                return;
            }
            $scope.startTime1 = $scope.startTime + ' 00:00:00';
            $scope.endTime1 = $scope.endTime + ' 00:00:00';
	    	window.open(rBasetUrl + '/orderArea/export.api?token=' + localStorage.getItem('token') 
                                  + '&startDate=' + $scope.startTime1 
                                  + '&endDate=' + $scope.endTime1
                                  + '&jAreaId=' + ($scope.city1 || $scope.county1 || $scope.province1 || '')
                                  + '&dAreaId=' + ($scope.city2 || $scope.county2 || $scope.province2 || ''));
   		}
    }

    $('#search').focus();
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };

}]);
