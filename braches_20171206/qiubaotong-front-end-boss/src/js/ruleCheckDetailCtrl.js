"use strict";
angular.module("app.views")
.controller('ruleCheckDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.id = '';
    $scope.packages = [];
    $scope.status = '1';
    $scope.updateRule = function(){
    	CommonService.httpRequest({
                  url : '/activityRule/detail.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
              		var datas = data.datas;
              		$scope.id = id;
              		$scope.name = datas.name;
              		$scope.amount = datas.amount;
              		$scope.memo = datas.memo;
              		$scope.status = datas.status + '';
                  $scope.packages = datas.configs;
                });
    }

    $scope.addPackage = function(){
    	var pack = {'amount':'','number':'','limitAmount':''};
    	$scope.packages.push(pack);
    }


    $scope.countAmount = function(){
      $scope.amount = 0;
      for(var i = 0; i < $scope.packages.length; i++){
        if(!!parseFloat($scope.packages[i].amount) && !!parseInt($scope.packages[i].number)){
          $scope.amount = $scope.amount + parseFloat($scope.packages[i].amount) * parseInt($scope.packages[i].number);
        }
      }
    }

    $scope.deleteMoney = function(id){
    	$scope.packages.splice(id,1);
      $scope.countAmount();
    }

    $scope.submitPackage = function(){
      if(!$scope.name){
            showWarn("规则名称不能为空");
            return false;
        }

      if(!$scope.amount){
          $scope.amount = '';
            showWarn("请添加礼包数量及完善礼包信息");
            return false;
      }
      else if($scope.amount > 999999999.99){
        showWarn('金额不能大于999999999.99');
        return false;
      }
      else if($scope.amount <= 0){
            for(var i = 0; i < $scope.packages.length; i++){
            if($scope.packages[i].amount <= 0 || $scope.packages[i].number <= 0 || $scope.packages[i].limitAmount <= 0){
              showWarn("配置信息不能为小于0");
              return false;
          }
        }
      }
      else{
        for(var i = 0; i < $scope.packages.length; i++){
          if($scope.packages[i].limitAmount > 999999999.99){
            showWarn('使用限制不能大于999999999.99');
            return false;
          }
        }
      };

      if(!$scope.memo){
            showWarn("描述不能为空");
            return false;
        }


    	if(!$scope.id){
    		CommonService.httpRequest({
                  url : '/activityRule/add.api',
                  method : 'post',
                  data :{
                      name : $scope.name,
                      memo : $scope.memo,
                      amount : $scope.amount,
                      configs : $scope.packages,
                      status : $scope.status
                  }
              }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'ruleCheck',url:'ruleCheck.html',displayName:'规则查询'});
                });
              });
    	}
    	else{
        CommonService.httpRequest({
                  url : '/activityRule/update.api',
                  method : 'post',
                  data :{
                      id : $scope.id,
                      name : $scope.name,
                      memo : $scope.memo,
                      amount : $scope.amount,
                      configs : $scope.packages,
                      status : $scope.status
                  }
              }).then(function(data){
                  showInfo("更新成功",function(){
                      tabOpenParent({name:'ruleCheck',url:'ruleCheck.html',displayName:'规则查询'});
                  });
                });
    	}
    }

    if(!!id){
    	$scope.updateRule();
    }

}]);
