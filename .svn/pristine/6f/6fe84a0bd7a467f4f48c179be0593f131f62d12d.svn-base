/**
 * Created by Administrator on 2017/8/1.
 */
angular.module("app.views")
.controller('groupOrderCtrl',['$scope','CommonService','Constants',function ($scope, CommonService,Constants) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.status= '';
  $scope.orgNm = '';
  $scope.orderType = Constants.order_type;
  // 清除选择时间
  $scope.clearStartTime = function(){
    $scope.beginTime = '';
  }
  $scope.clearEndTime = function(){
    $scope.endTime = '';
  };
  $scope.detail = function(id){
    tabOpenParent({
      name:'orderDetail' +id,
      url:'orderDetail.html?id='+id,
      displayName: '订单' + id
    });
  };
  var groupId = localStorage.getItem('orgId');
  $scope.getList = function (num) {
    if($scope.beginTime && $scope.endTime ){
      if($scope.beginTime > $scope.endTime){
        showWarn('开始时间不能大于结束时间');
        return false;
      }
    }
    CommonService.pagination({
      url:'/order/findByPage.api',
      method:'post',
      data:{
        pageNo:num||1,
        orgId:groupId,
        isOrg:1,
        orderNo:$scope.orderNo,
        payTimeStartTime:$scope.beginTime,
        payTimeEndTime:$scope.endTime,
        orgName:$scope.name,
        orderStatus:$scope.status===''?'':parseInt($scope.status)
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.list.length!==0&&($scope.orgNm = $scope.list[0].orgName);
      $scope.page = data.page;
    })
  }
  $scope.getList()
}]);
