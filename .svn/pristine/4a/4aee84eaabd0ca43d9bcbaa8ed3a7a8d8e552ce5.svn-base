"use strict";
angular.module("app.views")
.controller('saleManManageCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true,
        endDate : new Date().Format('yyyy-MM-dd')
    });
    $scope.saleMethod = Constants.sale_method;
    $scope.list = [];
    $scope.type = '';
    $scope.update = {};
    //全选、取消全选初始化
    $scope.allCheck = false;//全选控制
    $scope.idAllCheck = [];//全选所有id
    $scope.updateId = [];//更新的id
    $scope._list = [];//临时存储触发取消全选时已选择的id
    $scope.__list = [];//存储更新后已选择的id
    $scope.listNum = 1;//存储当前页码

    //搜索方法
    $scope.getResetList = function(num){
        if($scope.startDate && $scope.endDate){
            if($scope.startDate > $scope.endDate){
                showWarn('开始时间不能大于结束时间');
                return;
            }
        }
        $scope.allCheck = false;
        $scope._list = [];
        $scope.__list = [];
        CommonService.pagination({
            url : '/saleUser/findByPage.api',
            data :{
                pageNo : num || "1",
                pageSize : 30,
                isApply : true,
                name : $scope.name,
                mobile : $scope.mobile,
                salesmanCode : $scope.salesmanCode,
                idcard : $scope.idcard,
                company : $scope.company,
                status : $scope.status,
                type : $scope.type,
                qrcodeCreateInfoName : $scope.qrcodeCreateInfoName,
                startDate : $scope.startDate,
                endDate : $scope.endDate

            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
            $scope.idAllCheck = [];
            $scope.list.forEach(function(i){
                $scope.idAllCheck.push(i.id);
            });
        });
    };

    $scope.exportXls = function(){
        if(!$scope.startDate || !$scope.endDate){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
        else{
            if($scope.startDate > $scope.endDate){
                showWarn('开始时间不能大于结束时间');
                return;
            }
            window.open(rBasetUrl + '/saleUser/export.api?token=' + localStorage.getItem('token') 
                + '&company=' + ($scope.company || '') 
                + '&idcard=' + ($scope.idcard || '')
                + '&mobile=' + ($scope.mobile || '')
                + '&name='+ ($scope.name || '')
                + '&salesmanCode=' + ($scope.salesmanCode || '')
                + '&status=' + ($scope.status || '') 
                + '&type=' + ($scope.type || '')
                + '&startDate=' + ($scope.startDate || '')
                + '&endDate=' + ($scope.endDate || '')
                + '&isApply=true'
            );
        }
    };

    $scope.getList = function(num){
        if($scope.startDate && $scope.endDate){
            if($scope.startDate > $scope.endDate){
                showWarn('开始时间不能大于结束时间');
                return;
            }
        }
        $scope.listNum = num;
        CommonService.pagination({
            url:'/saleUser/findByPage.api',
            data:{
                pageNo : num || "1",
                pageSize : 30,
                isApply : true,
                name : $scope.name,
                mobile : $scope.mobile,
                salesmanCode : $scope.salesmanCode,
                idcard : $scope.idcard,
                company : $scope.company,
                status : $scope.status,
                type : $scope.type,
                qrcodeCreateInfoName:$scope.qrcodeCreateInfoName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
            $scope.idAllCheck = [];
            $scope.list.forEach(function(list){
                $scope.idAllCheck.push(list.id);
            });
            if($scope.__list.length > 0){
                //跳不同页
                if($scope.list[0].id != $scope.__list[0].id){
                    $scope.updateId = [];
                    $scope.allCheck = false;
                }
                //跳同一页
                else{
                    for(var i = 0; i < $scope.list.length; i++){
                        $scope.list[i].isSelect = $scope.__list[i].isSelect;
                    }
                }
            }
        });
    }
    $scope.getList();

    $scope.toDetail = function(id,name){
        tabOpenParent({name:'saleManManageDetail'+id,url:'saleManManageDetail.html?id='+id,displayName:'销售人员'+name});
    }

    //单个选择
    $scope.selectId = function(id){
        var idx = $scope.updateId.indexOf(id);
        if(idx == -1){
            $scope.updateId.push(id);
        }
        else{
            $scope.updateId.splice(idx,1);
        }
        if($scope.updateId.length == $scope.idAllCheck.length){
            $scope.allCheck = true;
        }
        else{
            $scope._list = angular.copy($scope.list);
            $scope.allCheck = false;
        }
    }

    //全选、取消全选
    $scope.$watch('allCheck',function(newVal,oldVal){
        if(newVal){
            $scope.list.forEach(function(list){
                list.isSelect = true;
            });
            $scope.updateId = angular.copy($scope.idAllCheck);
        }
        else{
            if($scope._list.length > 0){
                $scope.list = $scope._list;
            }
            else{
                $scope.list.forEach(function(list){
                    list.isSelect = false;
                });
                $scope.updateId = [];
            }
        }
        $scope._list = [];
    });

    $scope.updateReward = function(){
        if($scope.updateId.length == 0){
            showWarn('请勾选需要更新的销售人员');
            return;
        }
        if(!$scope.update.type){
            showWarn('请选择提成方式');
            return;
        }
        else if($scope.update.type == 1){
            if(!$scope.update.typeValue && $scope.update.typeValue !== 0){
                showWarn('每单提成金额为0.0~1000.0');
                return;
            }
            else if($scope.update.typeValue > 1000){
                showWarn('每单提成金额为0.0~1000.0');
                return;
            }
            else{
                var typeValueString = String($scope.update.typeValue);
                if(typeValueString.indexOf('.') > -1){
                    if(((typeValueString.length - 1) - typeValueString.indexOf('.')) > 1){
                        showWarn('每单提成金额为小数点后一位');
                        return;
                    }
                }
            }
        }
        else if($scope.update.type == 2){
            if(!$scope.update.typeValue && $scope.update.typeValue !== 0){
                showWarn('每单提成金额为0.0~100.0');
                return;
            }
            else if($scope.update.typeValue > 100){
                showWarn('每单提成金额为0.0~100.0');
                return;
            }
            else{
                var typeValueString = String($scope.update.typeValue);
                if(typeValueString.indexOf('.') > -1){
                    if(((typeValueString.length - 1) - typeValueString.indexOf('.')) > 1){
                        showWarn('每单提成金额为小数点后一位');
                        return;
                    }
                }
            }
        }
        if(!$scope.update.subscribeValue && $scope.update.subscribeValue !== 0){
            showWarn('关注奖金为0.0~100.0');
            return;
        }
        else if($scope.update.subscribeValue > 100){
            showWarn('关注奖金为0.0~100.0');
            return;
        }
        else{
            var typeValueString = String($scope.update.subscribeValue);
            if(typeValueString.indexOf('.') > -1){
                if(((typeValueString.length - 1) - typeValueString.indexOf('.')) > 1){
                    showWarn('关注奖金为小数点后一位');
                    return;
                }  
            }
        }
        if(!$scope.update.status){
            showWarn('请选择有效状态');
            return;
        }


        var sureMsg = '批量';
        if($scope.updateId.length == 1){
            sureMsg = '';
        }
        else{
            sureMsg = '批量';
        }

        CommonService.httpRequest({
            url: '/saleUser/updateBatch.api',
            method: 'post',
            data: {
                ids : $scope.updateId,
                type : $scope.update.type,
                typeValue : $scope.update.typeValue,
                subscribeValue : $scope.update.subscribeValue,
                status : $scope.update.status,
            }
        }).then(function(){
            showInfo(sureMsg + '更新成功',function(){
                $scope.__list = angular.copy($scope.list);
                $scope.getList($scope.listNum);
            });
        });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getResetList();
               }
           };

}]);
