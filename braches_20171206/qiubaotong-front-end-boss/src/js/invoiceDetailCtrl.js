"use strict";
angular.module("app.views")
.controller('invoiceCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.id = CommonService.getQueryString('id') || '';
  $scope.getDetail = function(id){
  	CommonService.httpRequest({
        url : '/bill/findById.api',
        method : 'get',
        data :{
          id : id
        }
    }).then(function(data){
      $scope.items = data.datas;
    });
  }

  $scope.submit = function(){
  	CommonService.httpRequest({
        url : '/bill/updateRemark.api',
        method : 'post',
        data :{
          id : $scope.items.id,
          remark : $scope.items.remark

        }
    }).then(function(data){
      $scope.getDetail($scope.items.id);
      tabOpenParent({name:'invoice',url:'invoice.html',displayName:'发票管理'});
    	
    });
  }

  $scope.getDetail($scope.id);
}]);
