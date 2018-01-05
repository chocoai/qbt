/**
 * Created by Administrator on 2017/6/30.
 */
angular.module("app.views")
.controller('addCodeCtrl',['$scope','CommonService',function ($scope,CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  var id = localStorage.getItem('manages');
  $scope.addNewCode = function () {
    if(!$scope.codeName){
      showWarn("渠道二维码名称不能为空");
      return false;
    }
    CommonService.httpRequest({
      url:'/channelQrcodeInfo/add.api',
      method:'post',
      data:{
        name:$scope.codeName,
        remark:$scope.remark,
      }
    }).then(function (data) {
      showInfo("新增成功",function(){
        tabOpenParent({name:'qrcodeManage',url:'qrcodeManage.html',displayName:'渠道二维码管理'});
      });
    });
  };
  $scope.getList = function () {
    CommonService.httpRequest({
      url : '/channelQrcodeInfo/findById.api',
      method : 'get',
      data : {
        id : id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.id = manages.id;
      $scope.codeName = manages.name;
      $scope.identify = manages.channelQrcodeCode;
      $scope.qrcode = fBaseUrl + manages.qrcodeUrl;
      $scope.stateVal = manages.status + '';
      $scope.remark = manages.remark;
    });
  };
  if(id){
    $scope.aid = id;
    $scope.getList();
  }
  $scope.updateList = function () {
    if(!$scope.stateVal){
      showWarn("状态不能为空");
      return false;
    }
    if(!$scope.codeName){
      showWarn("名称不能为空");
      return false;
    }
    CommonService.httpRequest({
      url : '/channelQrcodeInfo/updateById.api',
      method : 'post',
      data : {
        id : id,
        name : $scope.codeName,
        status : parseInt($scope.stateVal),
        remark : $scope.remark
      }
    }).then(function (data) {
      showInfo("更新成功",function(){
        // console.log(data);
        tabOpenParent({name:'qrcodeManage',url:'qrcodeManage.html',displayName:'渠道二维码管理'});
      });
    });
    localStorage.removeItem('manages');
  };
}]);