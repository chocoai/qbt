"use strict";
angular.module("app.views")
.controller('vipCardSetCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true,
        startDate : new Date().Format('yyyy-MM-dd')
    });
    $scope.vipCardActiveType = Constants.vipCard_active_type;
    $scope.sellStatus = '1';
    $scope.vipTypes = [];

    $scope.getVipType = function(num){
        CommonService.pagination({
            url : '/vipType/findByPage.api',
            data :{
                pageNo : num || "1",             
                status : 1,
                pageSize:100
            }
        }).then(function(data){
            $scope.vipTypes = data.item;
        });
    };
    
    $scope.$watch('vipTypeName',function(newVal,oldVal){
        if(newVal){
            if($scope.vipTypes.length > 0){
                $scope.vipTypes.forEach(function(i){
                    if(i.name == newVal){
                        $scope.amount = i.amount;
                        $scope.valid = i.valid;
                        $scope.rules = i.rules;
                        $scope.vipTypeId = i.id;
                    }
                });
            }
        }
    });

    $scope.clearEndTime = function(){
        $scope.end_time = '';
    }
    $scope.send = function(){
                if(!$scope.name||$scope.name.length <2){
                    showWarn('请输入有效名称！字数在2-10位');
                    return false;
                }
                if(!/^[1-9][0-9]{0,4}$/.test($scope.number)){
                    showWarn('数量限制为1-300！');
                    return false;
                }
                if($scope.payAmount){
                    if ($scope.payAmount>10000) {
                        showWarn('支付金额限制为0-10000.00,两位小数！')
                        return false;
                    }else if (!/^([1-9][\d]{0,4}|0)(\.[\d]{1,2})?$/.test($scope.payAmount)) {
                        showWarn('支付金额限制为0-10000.00,两位小数！');
                        return false;
                    }
                    if ($scope.payAmount>=0 && !$scope.sellStatus) {
                        showWarn('请选择销售状态');
                        return false;
                    }  
                    if ($scope.payAmount>0 && $scope.sellStatus==2 && !$scope.payMethod) {
                        showWarn('请选择一种支付方式');
                        return false;
                     }
                }
                if (!$scope.end_time) {
                    showWarn('请选择截至日期！');
                    return false;
                } 
                if(!$scope.vipTypeId){
                    showWarn('请选择会员卡类型！');
                    return false;
                }           
            CommonService.httpRequest({
                url : '/vipCreate/generate.api',
                method : 'post',
                data :{
                    id: $scope.id,
                    name : $scope.name,
                    endTime : $scope.end_time,
                    number : $scope.number,
                    mobile : $scope.mobile,
                    vipTypeId : $scope.vipTypeId,
                    payAmount : $scope.payAmount,
                    sellStatus : $scope.sellStatus,
                    payMethod : $scope.payMethod
                }
            }).then(function(data){
                showInfo('生成成功！',function(){
                    $scope.name = '';
                    $scope.number = '';
                    $scope.end_time = '';
                    $scope.vipTypeId = '';
                    $scope.vipTypeName = '';
                    $scope.valid = '';
                    $scope.payAmount = '';
                    $scope.amount = '';
                    $scope.sellStatus = '';
                    $scope.payMethod = '';
                    $scope.getVipType();
                });  
            });  
    };
    $scope.getVipType();

}]);
