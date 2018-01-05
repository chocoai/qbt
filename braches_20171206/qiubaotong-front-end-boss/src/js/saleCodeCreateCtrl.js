"use strict";
angular.module("app.views")
.controller('saleCodeCreateCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });
    $scope.type = '1';
    $scope.firstType = '1';
    $scope.clearEndTime = function(){
        $scope.end_time = '';
    }
    // 奖品
    $scope.getAward = function () {
        CommonService.httpRequest({
            url:'/rewardActitvity/findCurrentCoupon.api',
            method:'get',
            data:{
                type:2
            }
        }).then(function (data) {
            $scope.awardList = data.datas;
        })
    };
    $scope.getAward();
    $scope.send = function(){
        if(!$scope.name||$scope.name.length <2){
            showWarn('请输入生成批次名称！字数在2-10位');
            return;
        }
        else if($scope.name.indexOf('系统生成') != -1){
            showWarn('生成批次名称不能包含‘系统生成’');
            return;
        }
        if(!$scope.number){
            showWarn('请输入生成数量，限制为1-300的整数！');
            return;
        }
        else{
            if($scope.number > 300){
                showWarn('数量限制为1-300的整数！');
                return;
            }
            else{
                var numberString = String($scope.number);
                if(numberString.indexOf('.') > 0){
                    showWarn('数量限制为1-300的整数！');
                    return;
                }
            }
        }
        
        if($scope.company){
           if($scope.company.length < 2){
                showWarn('工作单位字数为2~10');
                return ;
           }
        }

      if(!$scope.typeValue || $scope.typeValue===''){
            showWarn('每单提成金额不能为空');
            return;
       }else{
        if($scope.checkDoubleNumber($scope.typeValue,'0.0~1000.0',1000,1,'每单提成金额')){
                return;
            }
       }
      if(!$scope.firstTypeValue || $scope.firstTypeValue===''){
            showWarn('首单提成金额不能为空');
            return;
       }else{
        if($scope.checkDoubleNumber($scope.firstTypeValue,'0.0~1000.0',1000,1,'每单提成金额')){
                return;
            }
       }
        // if(!$scope.type){
        //     showWarn('请选择提成方式');
        //     return;
        // }
        // else{
        //     if($scope.type == 1){
        //         if($scope.checkDoubleNumber($scope.typeValue,'0.0~1000.0',1000,1,'每单提成金额')){
        //             return;
        //         }
        //     }
        //     else if($scope.type == 2){
        //         if($scope.checkDoubleNumber($scope.typeValue,'0.0~100.0',100,1,'每单提成金额')){
        //             return;
        //         }
        //     }
        // }
        // if($scope.checkDoubleNumber($scope.subscribeValue,'0.0~100.0',100,1,'关注奖金')){
        //     return;
        // }
        // if(!$scope.firstType){
        //     showWarn('请选择首单提成方式');
        //     return;
        // }
        // else{
        //     if($scope.firstType == 1){
        //         if($scope.checkDoubleNumber($scope.firstTypeValue,'0.0~1000.0',1000,1,'每单提成金额')){
        //             return;
        //         }
        //     }
        //     else if($scope.firstType == 2){
        //         if($scope.checkDoubleNumber($scope.firstTypeValue,'0.0~100.0',100,1,'每单提成金额')){
        //             return;
        //         }
        //     }
        // }
        // if(!$scope.orderDayType){
        //     showWarn('请选择代下单日类型');
        //     return
        // }
        // else if($scope.orderDayType == 2){
        //     if($scope.checkDoubleNumber($scope.orderDayValue,'1~1000',1000,0,'天数')){
        //         return;
        //     }
        // }
        if(!$scope.orderDayValue || $scope.orderDayValue===''){
          showWarn('关联天数不能为空！');
          return;
        }else{
          if($scope.orderDayValue > 1000){
            showWarn('关联天数不能大于1000！');
            return;
          }
        }
        if($scope.awardName==='' || !$scope.awardName){
            showWarn('奖励物品不能为空');
            return;
        }
        CommonService.httpRequest({
            url : '/saleQrcodeCreateInfo/add.api',
            method : 'post',
            data :{
                company: $scope.company,
                name : $scope.name,
                // subscribeValue : $scope.subscribeValue,
                number : $scope.number,
                type : parseInt($scope.type),
                typeValue : $scope.typeValue,
                firstType : parseInt($scope.firstType),
                firstTypeValue : $scope.firstTypeValue,
                orderDayType : 2,
                orderDayValue : $scope.orderDayValue,
                createType : '1'
            }
        }).then(function(data){
            showInfo('生成成功',function(){
                $scope.company = '';
                $scope.name = '';
                $scope.subscribeValue = '';
                $scope.number = '';
                $scope.type = '1';
                $scope.typeValue = ''
                $scope.firstType = '1';
                $scope.firstTypeValue = '';
                $scope.orderDayType = '';
                $scope.orderDayValue = '';
                $scope.$apply();
            });  
        });
    };

    //系统生成
    $scope.systemProduce = function(){
        layer.confirm('确定进行系统生成二维码吗?', {icon: 3, title:'提示'}, function(index){
            layer.alert('二维码生成中，请稍等或先进行其他业务处理', {
                icon: 6,
                skin: 'layer-ext-moon',
                zIndex: '29891014',
                title: '提示'
            });
            CommonService.httpRequest({
                url : '/saleQrcodeCreateInfo/add.api',
                method : 'post',
                data :{
                    createType : '2'
                }
            }).then(function(data){
                
                showInfo('系统生成成功！',function(){
                    layer.closeAll();
                });  
            });
            layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.checkDoubleNumber = function(value,range,maxValue,pointNumber,tip){
        if(!value && value !== 0){
            showWarn(tip + '为' + range);
            return true;
        }
        else if(value > maxValue){
            showWarn(tip + '不能大于' + maxValue);
            return true;
        }
        else{
            var typeValueString = String(value);
            if(typeValueString.indexOf('.') > -1){
                if(((typeValueString.length - 1) - typeValueString.indexOf('.')) > pointNumber){
                    if(pointNumber == 0){
                        showWarn(tip + '为' + range + '的整数');
                        return true;  
                    }
                    else{
                        showWarn(tip + '为小数点后' + pointNumber + '位');
                        return true;    
                    }
                }  
            }
        }
        return false;
    }

}]);
