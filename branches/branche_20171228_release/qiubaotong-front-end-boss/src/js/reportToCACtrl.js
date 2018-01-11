"use strict";
angular.module("app.views")
.controller('reportToCACtrl',['$scope','CommonService',function($scope,CommonService){
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
    $scope.sendType = '0';
    $scope.getType = '0';
    $scope.jAddrType = '';
    $scope.jSiteId = '';
    $scope.dAddrType = '';
    $scope.dSiteId = '';

    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/orderSite/findByPage.api?token=' + localStorage.getItem('token'),
            baseUrl : rBasetUrl,
        	data :{
        		pageNo : num || "1",
                startDate:$scope.startTime,
                endDate:$scope.endTime,
                jAddrType:$scope.sendType == 0 ? '' : $scope.sendType,
                dAddrType:$scope.getType == 0 ? '' : $scope.getType,
                jSiteId:$scope.county1 || $scope.city1 || $scope.province1 || $scope.jSiteId,
                dSiteId:$scope.county2 || $scope.city2 || $scope.province2 || $scope.dSiteId
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    // $scope.getList(1);

    $scope.clearSendCourse = function(){
        $('#courseText1').text('选择取包球场');
        $scope.jSiteId = '';
    }
    $scope.clearGetCourse = function(){
        $('#courseText2').text('选择送包球场');
        $scope.dSiteId = '';
    }
    $scope.clearSendAirport = function(){
        $('#airportText1').text('选择取包机场站点');
        $scope.jSiteId = '';
    }
    $scope.clearGetAirport = function(){
        $('#airportText2').text('选择送包机场站点');
        $scope.dSiteId = '';
    }
    $scope.clearSendBank = function(){
        $('#bankText1').text('选择取包银行站点');
        $scope.jSiteId = '';
    }
    $scope.clearGetBank = function(){
        $('#bankText2').text('选择送包银行站点');
        $scope.dSiteId = '';
    }
    $scope.clearSendSF = function(){
        $('#sfText1').text('选择取包顺丰站点');
        $scope.jSiteId = '';
    }
    $scope.clearGetSF = function(){
        $('#sfText2').text('选择送包顺丰站点');
        $scope.dSiteId = '';
    }

    //球场分页
    $scope.getCourse = function(num){
        CommonService.pagination({
        	url : '/course/findByPage.api',
        	data :{
        		pageNo : num || "1",
                name : $scope.positionName
            }
        }).then(function(data){
        	$scope.courses = data.item;
        	$scope.page1 = data.page;
        });
    };
    //机场分页
    $scope.getAirport = function(num){
        CommonService.pagination({
            url : '/airport/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.positionName
            }
        }).then(function(data){
            $scope.airports = data.item;
            $scope.page2 = data.page;
        });
    };
    //银行分页
    $scope.getBank = function(num){
        CommonService.pagination({
            url : '/baseBankBranch/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.positionName
            }
        }).then(function(data){
            $scope.banks = data.item;
            $scope.page3 = data.page;
        });
    };
    //顺丰站点分页
    $scope.getSF = function(num){
        CommonService.pagination({
            url : '/baseSfSite/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.positionName
            }
        }).then(function(data){
            $scope.sfs = data.item;
            $scope.page4 = data.page;
        });
    };

    //球场选择
    $scope.selectCourse = function(id){
        $scope.positionName = '';
        $scope.courseSelectId = id;
        $scope.getCourse();
        if(id == 1){
            layer.open({    
              type: 1,
              title:'请选择取包球场',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo1'),
            });
        }
        else{
            layer.open({    
              type: 1,
              title:'请选择送包球场',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo1'),
            });
        }
        document.onkeydown = '';
    };
    $scope.selectedCourse = function(id,name){
        if($scope.courseSelectId == 1){
            $scope.jSiteId = id;
        }
        else{
            $scope.dSiteId = id;
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

    //机场选择
    $scope.selectAirport = function(id){
        $scope.positionName = '';
        $scope.airportSelectId = id;
        $scope.getAirport();
        if(id == 1){
            layer.open({    
              type: 1,
              title:'请选择取包机场站点',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo2'),
            });
        }
        else{
            layer.open({    
              type: 1,
              title:'请选择送包机场站点',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo2'),
            });
        }
        document.onkeydown = '';
    };
    $scope.selectedAirport = function(id,name){
        if($scope.airportSelectId == 1){
            $scope.jSiteId = id;
        }
        else{
            $scope.dSiteId = id;
        }
        $('#airportText' + $scope.airportSelectId).text(name);
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };
    };

    //银行选择
    $scope.selectBank = function(id){
        $scope.positionName = '';
        $scope.bankSelectId = id;
        $scope.getBank();
        if(id == 1){
            layer.open({    
              type: 1,
              title:'请选择取包银行站点',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo3'),
            });
        }
        else{
            layer.open({    
              type: 1,
              title:'请选择送包银行站点',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo3'),
            });
        }
        document.onkeydown = '';
    };
    $scope.selectedBank = function(id,name){
        if($scope.bankSelectId == 1){
            $scope.jSiteId = id;
        }
        else{
            $scope.dSiteId = id;
        }
        $('#bankText' + $scope.bankSelectId).text(name);
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };
    };

    //顺丰站点选择
    $scope.selectSF = function(id){
        $scope.positionName = '';
        $scope.sfSelectId = id;
        $scope.getSF();
        if(id == 1){
            layer.open({    
              type: 1,
              title:'请选择取包顺丰站点',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo4'),
            });
        }
        else{
            layer.open({    
              type: 1,
              title:'请选择送包顺丰站点',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo4'),
            });
        }
        document.onkeydown = '';
    };
    $scope.selectedSF = function(id,name){
        if($scope.sfSelectId == 1){
            $scope.jSiteId = id;
        }
        else{
            $scope.dSiteId = id;
        }
        $('#sfText' + $scope.sfSelectId).text(name);
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };
    };

    $scope.clear_jSiteId = function(){
        $scope.jSiteId = '';
        $scope.province1 = '';
        $scope.city1 = '';
        $scope.county1 = '';
        $('#courseText1').text('选择取包球场');
        $('#airportText1').text('选择取包机场站点');
        $('#bankText1').text('选择取包银行站点');
    }
    $scope.clear_dSiteId = function(){
        $scope.dSiteId = '';
        $scope.province2 = '';
        $scope.city2 = '';
        $scope.county2 = '';
        $('#courseText2').text('选择送包球场');
        $('#airportText2').text('选择送包机场站点');
        $('#bankText2').text('选择送包银行站点');
    }

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
	    	window.open(rBasetUrl + '/orderSite/export.api?token=' + localStorage.getItem('token') 
                                  + '&startDate=' + $scope.startTime1 
                                  + '&endDate=' + $scope.endTime1 
                                  + '&jAddrType=' + ($scope.sendType == 0 ? '' : $scope.sendType)
                                  + '&dAddrType=' + ($scope.getType == 0 ? '' : $scope.getType)
                                  + '&jSiteId=' + $scope.jSiteId 
                                  + '&dSiteId=' + $scope.dSiteId);
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