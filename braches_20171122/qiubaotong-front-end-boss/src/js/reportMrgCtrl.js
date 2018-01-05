/**
 * Created by Administrator on 2017/7/29.
 */
angular.module("app.views")
.controller('reportMgrCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $scope.jTimeStart = '';
  $scope.jTimeEnd = '';
  $scope.deliverStartTime = '';
  $scope.deliverEndTime = '';
  $scope.sfType = '' ;
  $scope.isdCourse = '';
  $scope.isjCourse = '';
  $scope.mailChannel = '';
  $scope.orderType = '';
  $scope.isD = '';
  $scope.isJ = '';
  $('.date-picker').datepicker({
    format: 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight: true
  });
  // 清除日期
  $scope.clearStartTime = function(){
    $scope.jTimeStart = '';
  };
  $scope.clearEndTime = function(){
    $scope.jTimeEnd = '';
  };
  $scope.clearDstartTime = function(){
    $scope.deliverStartTime = '';
  };
  $scope.clearDendTime = function(){
    $scope.deliverEndTime = '';
  };
  $scope.sf_type = Constants.sf_type;
  $scope.order_type = Constants.order_type;
  $scope.getList = function(num) {
    if ($scope.jTimeStart && $scope.jTimeEnd) {
      if ($scope.jTimeStart > $scope.jTimeEnd) {
        showWarn('预约取件开始时间不能大于预约取件结束时间');
        return;
      }
    }
    if($scope.deliverStartTime && $scope.deliverEndTime){
      if($scope.deliverStartTime > $scope.deliverEndTime){
        showWarn('预约到达开始时间不能大于预约到达结束时间');
        return;
      }
    }
    CommonService.pagination({
      url:'/orderPage/findByPage.api?token='+localStorage.getItem('token'),
      baseUrl : rBasetUrl,
      method:'post',
      data:{
        pageNo : num || 1,
        begSendTime : $scope.jTimeStart,
        endSendTime : $scope.jTimeEnd,
        deliverStartTime : $scope.deliverStartTime,
        deliverEndTime : $scope.deliverEndTime,
        deliveryStatus : $scope.sfType?parseInt($scope.sfType):$scope.sfType,
        dAddrType : $scope.isdCourse?parseInt($scope.isdCourse):$scope.isdCourse,
        jAddrType : $scope.isjCourse?parseInt($scope.isjCourse):$scope.isjCourse,
        mailChannel : $scope.mailChannel?parseInt($scope.mailChannel):$scope.mailChannel,
        orderStatus : $scope.orderType?parseInt($scope.orderType):$scope.orderType,
        dBagIsSameAdree : $scope.isD?parseInt($scope.isD):$scope.isD,
        jBagIsSameAdree : $scope.isJ?parseInt($scope.isJ):$scope.isJ,
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    })
  }
  $scope.getList();
  $scope.detail = function(id){
    tabOpenParent({
      name:'orderDetail' +id,
      url:'orderDetail.html?id='+id,
      displayName: '订单' + id
    });
  };
  $scope.courseDetail = function(id,type){
    tabOpenParent({
      name:'addCourse_update'+id,
      url:'addCourse.html?id='+id+'&orderToCourse=1'+'&addrType='+type,
      displayName:'球场详情'+id
    });
  };
  $scope.travelDetail = function(id){
    tabOpenParent({
      name:'travelDetail_update'+id,
      url:'travelDetail.html?id='+id+'&orderToTravel=1',
      displayName:'合作方机构详情'+id
    });
  };

  $scope.isWeixin = function(mobile,id){
    CommonService.httpRequest({
      url : '/userWeixin/isWeiXinUser.api',
      method : 'get',
      data:{
        mobile:mobile
      }
    }).then(function(data){
      if(data.datas.isWeiXin){
        if(data.datas.idList.length > 1){
          tabOpenParent({name:'userCheck'+data.datas.idList[0],url:'userCheck.html?mobileOfMoreWeixin='+mobile,displayName:'微信用户查询'+data.datas.idList[0]});
        }
        else{
          $scope.userDetail(data.datas.idList[0]);
        }
      }
      else{
        $scope.mobileDetail(mobile,id);
      }
    });
  };

  $scope.mobileDetail = function(mobile,id){
    tabOpenParent({
      name:'contactCheckDetail_update'+id,
      url:'contactCheckDetail.html?mobile='+mobile,
      displayName:'客户信息详情'+id
    });
  }
  $scope.userDetail = function(id){
    tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:'用户详情查询'+id});
  };

  $scope.daiUserDetail = function(id,name){
    tabOpenParent({name:'saleManManageDetail'+id,url:'saleManManageDetail.html?id='+id,displayName:'销售人员'+name});
  }

  //修改待上门收件为顺丰已取件(客服确认)
  $scope.sendStatus2To4 = function(id){
    CommonService.httpRequest({
      url : '/order/sf_recive.api',
      method : 'post',
      data : {
        id : id
      }
    }).then(function(){
      showInfo('操作成功',function(){
        $scope.getList();
      });
    });
  };
  $scope.layerSendStatus2To4 = function(id){
    layer.confirm('是否修改为顺丰已取件(客服确认)?', {icon: 3, title:'提示'}, function(index){
      $scope.sendStatus2To4(id);
      layer.close(index);
    },function(index){
      layer.close(index);
    });
  };
  $scope.reportDownload = function(){
    if($scope.jTimeEnd!==''&&$scope.jTimeStart!==''){
      if($scope.jTimeStart > $scope.jTimeEnd){
        showWarn('开始时间不能大于结束时间');
        return;
      }
    }
    if($scope.deliverEndTime!==''&& $scope.deliverStartTime!==''){
      if($scope.deliverStartTime > $scope.deliverEndTime){
        showWarn('开始时间不能大于结束时间');
        return;
      }
    }
      $scope.jTimeStart1 = ($scope.jTimeStart!==''?$scope.jTimeStart + ' 00:00:00':'');
      $scope.deliverStartTime1 = ($scope.deliverStartTime!==''?$scope.deliverStartTime + ' 00:00:00':'');
      $scope.jTimeEnd1  = ($scope.jTimeEnd!==''?$scope.jTimeEnd  + ' 00:00:00':'');
      $scope.deliverEndTime1 = ($scope.deliverEndTime!==''?$scope.deliverEndTime + ' 00:00:00':'');
      window.open( rBasetUrl + '/orderPage/export.api?token=' + localStorage.getItem('token') + '&begSendTime=' + $scope.jTimeStart1 +
        '&endSendTime=' + $scope.jTimeEnd1 + '&deliverStartTime='+ $scope.deliverStartTime1 + '&deliverEndTime=' + $scope.deliverEndTime1 + '&dAddrType=' + $scope.isdCourse +
        '&jAddrType=' + $scope.isjCourse + '&mailChannel=' + $scope.mailChannel + '&orderStatus=' + $scope.orderType + '&deliveryStatus=' +$scope.sfType +'&dBagIsSameAdree=' + $scope.isD + '&jBagIsSameAdree=' +$scope.isJ  );
  };
// 获取快递渠道
  $scope.getChannel = function () {
    CommonService.httpRequest({
      url:'/mailChannel/findAll.api',
      method:'get'
    }).then(function (data) {
      $scope.channelList = data.datas;
    })
  };
  $scope.getChannel();

  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);