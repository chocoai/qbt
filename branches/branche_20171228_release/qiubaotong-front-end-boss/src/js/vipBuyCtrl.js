"use strict";
angular.module("app.views")
.controller('vipBuyCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.wecatName = '选择微信用户';
    $scope.vipTypes = [];
    $scope.salesmanName = '';

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
            $scope.vipTypeName = $scope.vipTypes[0].name;
            $scope.vipTypeId = $scope.vipTypes[0].id;
            $scope.amount = $scope.vipTypes[0].amount;
            $scope.validDesc = $scope.vipTypes[0].validDesc;
            $scope.rules = $scope.vipTypes[0].rules;
        });
    };

    $scope.$watch('vipTypeName',function(newVal,oldVal){
        if(newVal){
            if($scope.vipTypes.length > 0){
                $scope.vipTypes.forEach(function(i){
                    if(i.name == newVal){
                        $scope.amount = i.amount;
                        $scope.validDesc = i.validDesc;
                        $scope.rules = i.rules;
                        $scope.vipTypeId = i.id;
                    }
                });
            }
        }
    });

    $scope.getWecat = function(num){
    	CommonService.pagination({
    		url : '/userWeixin/findByPage.api',
    		data :{
    			pageNo : num || "1",
    			name : $scope.selectWecatName
    		}
    	}).then(function(data){
    		$scope.wecats = data.item;
    		$scope.page1 = data.page;
    	});
    };

    $scope.selectWecat = function(item){
        $scope.getWecat();
        layer.open({    
        	  type :1,
              title:'请选择微信用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['480px', '535px'], //宽高
              content: $('#memo'),
              end: function(){
                $scope.selectWecatName = '';
              }
            });
    }

    $scope.selectedWecat = function(wecat){
        $scope.openId = wecat.openid;
        $scope.userName = wecat.name;
        $scope.mobile = wecat.mobile;
        $scope.wecatName = wecat.nickname;
        layer.closeAll();
    };

    $scope.clearWecat = function(){
    	$scope.openId = '';
    	$scope.wecatName = '选择微信用户';
    };

    $scope.vipBuy = function(){
        if(!$scope.userName && $scope.userName !== 0){
            showWarn('姓名不能为空');
            return false;
        }
        else if($scope.userName.length == 1){
            showWarn('需填写真实姓名');
            return false;
        }
        else if($scope.userName.indexOf('先生') != -1 || $scope.userName.indexOf('女士') != -1){
            showWarn('需填写真实姓名');
            return false;
        }
        if(!$scope.mobile){
            showWarn('手机号不能为空');
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.mobile))){
            }
            else{
                showWarn("手机号格式错误");
                return false;
            }
        }
        if($scope.salesmanName === ''){
          showWarn("销售人姓名不能为空");
          return false;
        }
        layer.open({
            type: 1,
            title : '购买信息确认',
            area: ['300px', '400px'],
            content: $('#showBuyMsg'),
            btn: ['确定', '取消'],
            zIndex : 1000,
            yes: function(index){
                $scope.submitVipMsg();
                layer.close(index);
            }
        });
    };
    $scope.submitVipMsg = function(){
        CommonService.httpRequest({
            method : 'post',
            url : '/vipInfo/addVipInfo.api',
            data:{
                mobile : $scope.mobile,
                openId : $scope.openId,
                userName : $scope.userName,
                vipTypeId : $scope.vipTypeId,
                salesmanName : $scope.salesmanName
            }
        }).then(function(data){
            showInfo("购买成功",function(){
                tabOpenParent({name:'vipInfo',url:'vipInfo.html',displayName:'会员信息管理'});
            });
        });
    };

    $scope.getVipType();

}]);
