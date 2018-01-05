/**
 * Created by Administrator on 2017/6/6.
 */
angular.module("app.views")
.controller('paymentManageCtrl',['$scope','CommonService',function($scope,CommonService){
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.selectStartPro='';
  $scope.selectEndPro=''
  $scope.getProvinces = function(){
    CommonService.httpRequest({
      url : '/baseSfArea/findByParentId.api?parentId=1000000',
      method : 'post',
    }).then(function(data){
      $scope.startProvinceses = data.datas;
      $scope.endProvinceses = data.datas;
    });
  };
  $scope.getProvinces()
  $scope.getList = function(num){
    CommonService.pagination({
      url : '/baseNewSfPrice/findByPage.api',
      method:'post',
      data : {
        pageNo : num || "1",
        endArea : $scope.selectEndPro.split('|')[1],
        startArea : $scope.selectStartPro.split('|')[1]
      }
    }).then(function(data){
      $scope.list = data.item;
      $scope.page = data.page;
    });
  }
  $scope.getList()
  $scope.addPrice = function(){
    localStorage.removeItem('manages');
    tabOpenParent({name:'paymentManage_add',url:'paymentManageDetail.html',displayName:'新增价格'});
  }
  $scope.updatePrice = function(item){
    var itemStr=JSON.stringify(item);
    localStorage.setItem("manages", itemStr);
    tabOpenParent({name:'paymentManage_update',url:'paymentManageDetail.html',displayName:'更新价格'});
  }
  $scope.deletePrice = function(id){
    CommonService.httpRequest({
      url : '/baseNewSfPrice/delete.api',
      method : 'get',
      data :{
        id : id
      }
    }).then(function(data){
      showInfo("删除成功",function(){
        $scope.getList(1);
      });
    });
  };
  $scope.layerDeletePrice = function(id){
    showConfirm('确定删除吗?', function(){
      $scope.deletePrice(id);
      layer.close();
    },function(){
      layer.close();
    });
  };
}])