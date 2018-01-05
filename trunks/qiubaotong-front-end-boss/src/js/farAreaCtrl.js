/**
 * Created by Administrator on 2017/7/18.
 */
angular.module("app.views")
.controller('farAreaCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.area = [];
  $scope.addFarArea = function () {
    localStorage.removeItem('manages');
    tabOpenParent({name:'farAreaDetail_add',url:'farAreaDetail.html',displayName:'新增偏远地区'});
  };
  $scope.getList = function (num) {
    CommonService.pagination({
      url:'/outRangeAddress/findByPage.api',
      method:'post',
      data:{
        pageNo : num || "1",
        areaId : ($scope.country && $scope.country!=='') ? $scope.country : ($scope.city ? $scope.city : $scope.province),
        address: $scope.keyWord
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    })
  }
  $scope.getList();
  $scope.updateArea = function (id) {
    localStorage.setItem("manages",id)
    tabOpenParent({name:'farAreaDetail_update',url:'farAreaDetail.html',displayName:'偏远地区详情'});
  };
  $scope.deleteArea = function (id) {
    CommonService.httpRequest({
      url:'/outRangeAddress/deleteById.api',
      method:'get',
      data:{
        id:id
      }
    }).then(function (data) {
      showInfo("删除成功",function(){
        tabOpenParent({name:'farArea',url:'farArea.html',displayName:'偏远地区管理'});
      });
    })
  }
  $scope.getProvinces = function(){
    CommonService.httpRequest({
      url : '/baseSfArea/findByParentId.api?parentId=1000000',
      method : 'post',
    }).then(function(data){
      $scope.provinceses = data.datas;
      $scope.country = '';
    });
  };
  $scope.getProvinces();
  $scope.getCitieses = function(){
    // if(type == 1){
    if(!!$scope.province){
      CommonService.httpRequest({
        url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province,
        method : 'post',
      }).then(function(data){
        $scope.citieses = data.datas;
        $scope.country = '';
      });
    }
    else{
      $scope.citieses = '';
      $scope.countieses = '';
      $scope.country = '';
    }
    $scope.city = '';
    $scope.county = '';
  };
  $scope.getCounties = function(){
    if(!!$scope.city){
      CommonService.httpRequest({
        url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
        method : 'post',
      }).then(function(data){
        $scope.countieses = data.datas;
        $scope.parentId = data.datas.parentId;
      });
    }
    else{
      $scope.countieses = '';
    }
    $scope.country = '';
  };
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}])