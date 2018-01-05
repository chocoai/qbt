"use strict";
angular.module("app.views")
.controller('reportPartnerCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearStartTime = function(){
        $scope.startTime = '';
    };
    $scope.clearEndTime = function(){
        $scope.endTime = '';
    };
    $scope.startTime = new Date().Format('yyyy-MM-dd');
    $scope.endTime = new Date().Format('yyyy-MM-dd');
    $scope.settleState = '';
    $scope.thirdId = '';
    $scope.getList = function(num){
        if(!$scope.thirdId){
            showWarn('合作机构名称不能为空');
            return false;
        }
        CommonService.pagination({
        	url : '/orderPartner/findByPage.api?token=' + localStorage.getItem('token'),
        	baseUrl:rBasetUrl,
            data :{
        		pageNo : num || "1",
                startDate : $scope.startTime,
                endDate : $scope.endTime,
                settleState:$scope.settleState,
                thirdId : $scope.thirdId
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    // $scope.getList(1);

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
            if(!$scope.thirdId){
                showWarn('合作机构名称不能为空');
                return false;
            }
            $scope.startTime1 = $scope.startTime + ' 00:00:00';
            $scope.endTime1 = $scope.endTime + ' 00:00:00';
	    	window.open(rBasetUrl + '/orderPartner/export.api?token=' + localStorage.getItem('token') + '&startDate=' + $scope.startTime1 +
	    	 '&endDate=' + $scope.endTime1 + '&settleState=' + $scope.settleState + '&thirdId=' + $scope.thirdId);
   		}
    }

    //合作机构操作
    $scope.clearThird = function(){
        $('#thirdText').text('选择合作机构');
        $scope.thirdId = '';
    }
     $scope.getThird = function(num){
        CommonService.pagination({
            url : '/basePartner/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.thirdName
            }
        }).then(function(data){
            $scope.thirds = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.selectThird = function(){
        $scope.getThird();
            layer.open({    
              type: 1,
              title:'请选择合作机构',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
              end: function(){
                $scope.thirdName = '';
              }
            });
        document.onkeydown = '';
    }
    $scope.selectedThird = function(id,name){
        $('#thirdText').text(name);
        $scope.thirdId = id;
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                    $scope.getList();
               }
           };
    };

    $('#search').focus();
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
