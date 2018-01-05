"use strict";
angular.module("app.views")
.controller('reportCourseCountCtrl',['$scope','CommonService',function($scope,CommonService){
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
    $scope.jContact = '';
    $scope.jMobile = '';
    $scope.jAddrId = '';
    $scope.dAddrId = '';

    $scope.getList = function(num){
        if(!$scope.jContact && !$scope.jMobile){
            showWarn('姓名和手机号二选一');
            return;
        }
        if(!$scope.jAddrId && !$scope.dAddrId){
            showWarn('取包球场和送包球场二选一');
            return;
        }
        CommonService.pagination({
        	url : '/orderJCourse/findByPage.api?token=' + localStorage.getItem('token'),
            baseUrl : rBasetUrl,
        	data :{
        		pageNo : num || "1",
                startDate:$scope.startTime,
                endDate:$scope.endTime,
                jContact:$scope.jContact,
                jMobile:$scope.jMobile,
                jAddrId:$scope.jAddrId,
                dAddrId:$scope.dAddrId
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    // $scope.getList(1);

    $scope.clearSendCourse = function(){
        $('#courseText1').text('选择取包球场');
        $scope.jAddrId = '';
    }
    $scope.clearGetCourse = function(){
        $('#courseText2').text('选择送包球场');
        $scope.dAddrId = '';
    }

    //球场操作
    $scope.getCourse = function(num){
        CommonService.pagination({
            url : '/course/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.courseName
            }
        }).then(function(data){
            $scope.courses = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.selectCourse = function(id){
        $scope.courseName = '';
        $scope.courseSelectId = id;
        $scope.getCourse();
        if(id == 1){
            layer.open({    
              type: 1,
              title:'请选择取包球场',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
            });
        }
        else{
            layer.open({    
              type: 1,
              title:'请选择送包球场',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
            });
        }
        document.onkeydown = '';
    };
    $scope.selectedCourse = function(id,name){
        if($scope.courseSelectId == 1){
            $scope.jAddrId = id;
        }
        else{
            $scope.dAddrId = id;
        }
        $('#courseText' + $scope.courseSelectId).text(name);
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                    $scope.getList();
               }
           };
    };
    //球场操作-end


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
            if(!$scope.jContact && !$scope.jMobile){
                showWarn('姓名和手机号二选一');
                return;
            }
            if(!$scope.jAddrId && !$scope.dAddrId){
                showWarn('取包球场和送包球场二选一');
                return;
            }
            $scope.startTime1 = $scope.startTime + ' 00:00:00';
            $scope.endTime1 = $scope.endTime + ' 00:00:00';
	    	window.open(rBasetUrl + '/orderJCourse/export.api?token=' + localStorage.getItem('token') 
                                  + '&startDate=' + $scope.startTime1
                                  + '&endDate=' + $scope.endTime1
                                  + '&jContact=' + $scope.jContact 
                                  + '&jMobile=' + $scope.jMobile 
                                  + '&jAddrId=' + $scope.jAddrId 
                                  + '&dAddrId=' + $scope.dAddrId);
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
