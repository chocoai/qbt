/**
 * Created by Administrator on 2017/9/7.
 */
angular.module("app.views")
.controller('handleStepDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.handleType = '1';
  $scope.steps = [{"name":'',"step":1,"type":parseInt($scope.handleType)}];
  $scope.handleNm = '';
  var id = localStorage.getItem('manage');

  $scope.addStep = function (idx) {
    $scope.steps.push({"name":'',"step":idx+1,"type":parseInt($scope.handleType)});
  };

  $scope.deleteStep = function (id) {
    $scope.steps.splice(id,1);
  };
  $scope.showObj = function (type) {
    CommonService.httpRequest({
      url : '/baseHandle/listByType.api',
      method : 'get',
      data : {
        type : parseInt(type),
      }
    }).then(function (data) {
        $scope.objs = data.datas;
    });
  };
  $scope.showObj($scope.handleType);
  $scope.selectObj = function (type) {
    CommonService.httpRequest({
      url : '/baseHandle/listByType.api',
      method : 'get',
      data : {
        type : parseInt(type),
      }
    }).then(function (data) {
      $scope.objs = data.datas;
      $scope.handleObj = ''
    });
  };
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url : '/baseHandle/findById.api',
      method : 'get',
      data :{
        id : id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.handleType = manages.type + '';
      $scope.showObj($scope.handleType);
      $scope.handleObj = manages.objectId + '|' + manages.objectName;
      $scope.handleNm = manages.name;
      $scope.remark = manages.remark;
      $scope.steps = manages.baseHandleStepsList;
    });
  };
  if(id){
    $scope.getList(id);
  }
  $scope.submitData = function () {
    if(!$scope.handleObj || $scope.handleObj===undefined){
      showWarn('处理对象不能为空');
      return false;
    }
    if($scope.handleNm===''){
      showWarn('处理名称不能为空');
      return false;
    }
    if($scope.steps[0].name===''){
      showWarn('步骤1不能为空');
      return false;
    }
    for(var i=0;i<$scope.steps.length;i++){
      if(i>0&& $scope.steps[i].name===''){
        showWarn('步骤内容不能为空');
        return false;
      }
    }
    if($scope.handleType === '2'){
      for(var i = 0;i<$scope.steps.length;i++){
        $scope.steps[i]["type"] = 2;
      }
    }else{
      for(var i = 0;i<$scope.steps.length;i++){
        $scope.steps[i]["type"] = 1;
      }
    }
    if(!id){
      CommonService.httpRequest({
        url : '/baseHandle/add.api',
        method : 'post',
        data :{
          baseHandleStepsList : $scope.steps,
          name : $scope.handleNm,
          objectId : parseInt($scope.handleObj.split('|')[0]),
          objectName : $scope.handleObj.split('|')[1],
          remark : $scope.remark,
          type : parseInt($scope.handleType)
        }
      }).then(function (data) {
        showInfo('新增成功',function () {
          tabOpenParent({name: 'handleStep', url: 'handleStep.html', displayName: '处理步骤管理'});
        });
      });
    }else{
      CommonService.httpRequest({
        url : '/baseHandle/updateById.api',
        method : 'post',
        data :{
          id : id,
          baseHandleStepsList : $scope.steps,
          name : $scope.handleNm,
          objectId : parseInt($scope.handleObj.split('|')[0]),
          objectName : $scope.handleObj.split('|')[1],
          remark : $scope.remark,
          type : parseInt($scope.handleType)
        }
      }).then(function (data) {
        showInfo('更新成功',function () {
          tabOpenParent({name: 'handleStep', url: 'handleStep.html', displayName: '处理步骤管理'});
        });
      })
    }
  };
}]);