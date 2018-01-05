/**
 * Created by Administrator on 2017/7/31.
 */
angular.module("app.views",['ngFileUpload'])
.controller('groupUserDetailCtrl',['$scope','CommonService','Upload',function ($scope, CommonService,Upload) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.list = '';
  $scope.useId = [];
  $scope.allUse = [];
  $scope.user =[];
  $scope.selectAll = false;
  $scope.selectOne = false;
  $scope.addNewUser = function () {
    localStorage.removeItem('groupUser');
    tabOpenParent({name:'addGroupUser',url:'addGroupUser.html',displayName:'新增机构用户'});
  };
  // 进入详情
  $scope.goDetail = function (id) {
    localStorage.setItem('groupUser',id);
    tabOpenParent({name:'addGroupUser',url:'addGroupUser.html',displayName:'机构用户详情'});
  };
  // 清除选择时间
  $scope.clearStartTime = function(){
    $scope.startTime = '';
  }
  $scope.clearEndTime = function(){
    $scope.endTime = '';
  }
  var groupId = localStorage.getItem('groupId');
  $scope.getList = function (num) {
    if($scope.startTime && $scope.endTime ){
      if($scope.startTime > $scope.endTime){
        showWarn('开始时间不能大于结束时间');
        return false;
      }
    }
    CommonService.pagination({
      url:'/orgGroupUser/findByPage.api',
      method:'post',
      data:{
        pageNo:num||1,
        endCreateTime:$scope.endTime,
        mobile:$scope.phone,
        name:$scope.userName,
        orgId:parseInt(groupId),
        orgName:$scope.group,
        startCreateTime:$scope.startTime,
        status:parseInt($scope.status)
      }
    }).then(function (data) {
      var _selectObj = [];
      for(var i=0;i<data.item.length;i++){
        _selectObj.push(data.item[i].id)
      }
      $scope.allUse = _selectObj;
      $scope.list = data.item;
      $scope.list.length!==0&&($scope.orgNm = $scope.list[0].orgName);
      $scope.page = data.page
    })
  };
  $scope.getList();
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/orgGroupUser/updateStatus.api',
      method:'post',
      data:{
        id:id,
        status:state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
        });
      }
      else{
        showInfo("启用成功",function(){
        });
      }
      $scope.getList();
    })
  };
  // 全选和全不选
  $scope.changeAll = function (m) {
    if(m===true){
      $scope.useId = $scope.allUse;
      $scope.selectOne = true;
    }else{
      $scope.useId = [];
      $scope.selectOne = false
    }
  };
  // 单选
  $scope.changeId = function (id,n) {
    if(n===true){
      if($scope.useId.indexOf(id)===-1){
        $scope.useId.push(id)
      }
    }else{
      var _idx = $scope.useId.indexOf(id);
      $scope.useId.splice(_idx,1);
    }
  };
  // 批量删除用户
  $scope.deleteAllUser = function () {
    if($scope.useId.length===0){
      showWarn('请选择需要批量删除的数据');
      return
    }
    CommonService.httpRequest({
      url:'/orgGroupUser/delete.api',
      method:'post',
      data:{
        ids:$scope.useId
      }
    }).then(function (data) {
      showInfo('批量删除成功',function () {
        location.href = 'groupUserDetail.html';
      })
    })
  };
  // 单独删除用户
  $scope.deleteUser =function (id) {
    CommonService.httpRequest({
      url:'/orgGroupUser/delete.api',
      method:'post',
      data:{
        ids:[id]
      }
    }).then(function (data) {
      showInfo('删除成功',function () {
        $scope.getList();
      })
    })
  };
  // 将excel上传到文件服务器
  $scope.addExcel = function (pic) {
    CommonService.httpRequest({
      url:'/orgGroupUser/importFile.api',
      method:'post',
      data:{
        excel:pic,
        orgId:parseInt(groupId)
      }
    }).then(function (data) {
      showLongInfo('共有'+ data.datas.totalCount + '条数据，成功上传'+data.datas.succCount+'条，重复数据共'+data.datas.failCount+'条',function () {
        $scope.getList()
      })
    })
  };
  //上传excel表格
  $scope.uploadExcel = function ($file) {
    if($file){
      var isIntegrate = false;
      var idx = $file.name.lastIndexOf(".");
      // 判断是否为最后一个.是否存在
      if(idx<0){
        showWarn('上传的文件格式不正确，请选择97-2003Excel文件(*.xls)！');
        return false
      }else{
        var ext = $file.name.substring(idx + 1, $file.length);
        // 判断后缀是否为xls
        if(ext !== "xls") {
          showWarn("上传的文件格式不正确，请选择97-2003Excel文件(*.xls)！");
          return false
        }else{
          Upload.upload({
            url: baseUrl + '/common/excelUpload.api',
            method:'post',
            data:{
              excel: $file
            }
          }).progress(function(evt) {//上传进度
            layer.load(1, {
              shade: [0.1,'#fff']
            });
          }).then(function(data){
            layer.closeAll();
            $scope.addExcel(data.data.datas);
          })
        }
      }
    }
  };
  // 回车搜索
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);