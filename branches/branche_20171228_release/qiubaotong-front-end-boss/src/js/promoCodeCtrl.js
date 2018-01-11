/**
 * Created by Administrator on 2017/5/9.
 */
"use strict";
angular.module("app.views")
.controller('promoCodeCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.list=[];
  //新增优惠码按钮
  $scope.addPromo = function(){
    localStorage.removeItem('manages');
    tabOpenParent({name:'addPromo',url:'addPromo.html',displayName:'新增优惠码'});
  };
  $scope.name='';
  $scope.code='';
  $scope.status='0';
//搜索功能
  $scope.getList=function(num){
    CommonService.pagination({
      url:'/couponCodeActivity/findByPage.api',
      method:'post',
      data:{
        pageNo:num||"1",
        code:$scope.code,
        name:$scope.name,
        status:$scope.status
      }
    }).then(function(data){
      $scope.list=data.item;
      $scope.page=data.page;
    })
  }
  $scope.getList();
  $scope.updatePromo=function(item){
    localStorage.setItem("manages", item);
    tabOpenParent({name:'promoCodeDetail_update',url:'promoCodeDetail.html',displayName:'优惠码活动详情'});
  }
}]);