"use strict";
angular.module("app.views")
.controller('fullCutDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });
    var id = localStorage.getItem('manages');
    $scope.types = '3';
    $scope.priority = '10';
    $scope.province = '';
    $scope.city = '';
    $scope.amountConfigs = [];
    $scope.areas = [];
    $scope.courses = [];
    $scope.scopeValueShow = '1';
    $scope.courseNoRepeat = true;
    $scope.areaNoRepeat = true;
    $scope.submitScopes = '';
    $scope.amountType = '1';

    $scope.addAmount = function(){
        $scope.amountConfigs.push({amountType: 1, limitAmount:'', amount:''});
    }

    $scope.deleteAmount = function(id){
        $scope.amountConfigs.splice(id,1);
    }

    $scope.addArea  = function(){
        if(!!$scope.province && !!$scope.city){
            $scope.proCityCoun = $scope.province.split('|')[1] + $scope.city.split('|')[1];
            if($scope.areas.length != 0){
                for(var i = 0; i < $scope.areas.length; i++){
                    if($scope.areas[i].scopeName == $scope.proCityCoun){
                        $scope.areaNoRepeat = false;
                        break;
                    }
                }
                if($scope.areaNoRepeat){
                    $scope.areas.push({scopeName:$scope.proCityCoun,scopeId:$scope.city.split('|')[0]});
                }
                $scope.areaNoRepeat = true;
            }
            else{
                $scope.areas.push({scopeName:$scope.proCityCoun,scopeId:$scope.city.split('|')[0]});
            }
        }
        else{
            showWarn('请选择省市');
            return;
        }
    }

    $scope.deleteArea = function(id){
        $scope.areas.splice(id,1);
    }

    $scope.checkCourse = function(name,id){
        $scope.courseNoRepeat = true;
        if($scope.length != 0){
        	for(var i = 0; i < $scope.courses.length; i++){
        		if($scope.courses[i].scopeName == name){
                    $scope.courseNoRepeat = false;
                    break;
        		}
        	}
            if($scope.courseNoRepeat){
                $scope.courses.push({'scopeName':name,scopeId:id});
            }
        }
        else{
            $scope.courses.push({'scopeName':name,scopeId:id});
        }
    }
    $scope.deleteCourse = function(id){
        $scope.courses.splice(id,1);
    }
    $scope.getCourt = function(){
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
    $scope.getCourt();

    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/activityOff/detail.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
            var manages = data.datas;
            $scope.id = manages.id;
            $scope.name = manages.name;
            $scope.startTime = manages.startTime;
            $scope.endTime = manages.endTime;
            $scope.amountConfigs = manages.amountConfigs;
            $scope.amountType = $scope.amountConfigs[0].amountType + '';
            $scope.types = manages.type + '';
            $scope.memo = manages.memo;
            if(manages.type == 3){
                $scope.courses = manages.configs;
            }
            else{
                $scope.areas = manages.configs;
            }
        });
       
    }

    
    $scope.addFullCut = function(){
        if(!$scope.name){
            showWarn("满减活动名称不能为空");
            return false;
        }
        if(!$scope.startTime){
            showWarn("开始时间不能为空");
            return false;
        }
        if(!$scope.endTime){
            showWarn("结束时间不能为空");
            return false;
        }
        if($scope.startTime > $scope.endTime){
            showWarn('开始时间不能大于结束时间');
            return false;
        }
        if($scope.amountConfigs.length == 0){
            showWarn('满减规则及类型不能为空');
            return false;
        }
        else{
            for(var i = 0; i < $scope.amountConfigs.length; i++){
                if(!$scope.amountConfigs[i].limitAmount || $scope.amountConfigs[i].limitAmount == 0 || !$scope.amountConfigs[i].amount || $scope.amountConfigs[i].amount == 0){
                    showWarn('满、减的金额不能为空或0');
                    return;
                }
                else if($scope.amountConfigs[i].limitAmount > 999999.99){
                    showWarn('满的金额不能大于999999.99');
                    return;
                }
                if($scope.amountType == 1){
                    if($scope.amountConfigs[i].amount > 999999.99){
                        showWarn('减的金额不能大于999999.99');
                        return;
                    }
                    if($scope.amountConfigs[i].limitAmount < $scope.amountConfigs[i].amount){
                        showWarn('满金额不能小于所减金额');
                        return;
                    }
                }
                else{
                    if($scope.amountConfigs[i].amount > 100){
                        showWarn('减的折扣不能大于100');
                        return
                    }
                }
            }
        }
        if(!$scope.memo){
            showWarn("满减活动规则描述不能为空");
            return false;
        }
        if(!$scope.types){
            showWarn("满减活动类型不能为空");
            return false;
        }
        if($scope.types == 3){
            $scope.submitScopes = $scope.courses;
        }
        else{
            $scope.submitScopes = $scope.areas;
        }
        $scope.amountConfigs.forEach(function(config){
            config.amountType = $scope.amountType;
        });
        if(!id){
             CommonService.httpRequest({
                url : '/activityOff/add.api',
                method : 'post',
                data :{
                    name          : $scope.name,
                    startTime     : new Date($scope.startTime).getTime(),
                    endTime       : new Date($scope.endTime).getTime(),
                    amountConfigs : $scope.amountConfigs,
                    type          : parseInt($scope.types),
                    memo          : $scope.memo,
                    configs       : $scope.submitScopes,
                    status        : 1
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'fullCut',url:'fullCut.html',displayName:'满减活动'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/activityOff/update.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name          : $scope.name,
                    startTime     : new Date($scope.startTime).getTime(),
                    endTime       : new Date($scope.endTime).getTime(),
                    amountConfigs : $scope.amountConfigs,
                    type          : parseInt($scope.types),
                    memo          : $scope.memo,
                    configs       : $scope.submitScopes,
                    status        : 1
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'fullCut',url:'fullCut.html',displayName:'满减活动'});
                });
            });
            localStorage.removeItem('manages');
           
        }
    	
    }

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses = data.datas;
        });
    }
    $scope.getProvinces();
    $scope.getCitieses = function(){
        if($scope.province){
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province.split('|')[0],
                method : 'post',
            }).then(function(data){
                $scope.citieses = data.datas;
            });
        }
        else{
            $scope.citieses = '';
        }
        $scope.city = '';
    }
     $scope.scopeShow = function(scopeValueShow){
        $scope.scopeValueShow = scopeValueShow + '';
    }


    if(id){
        $scope.getList(id);
    }

}]);
