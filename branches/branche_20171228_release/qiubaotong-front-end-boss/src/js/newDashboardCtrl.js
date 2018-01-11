/**
 * Created by Administrator on 2017/6/8.
 */
"use strict";
angular.module("app.views")
.controller('newDashboardCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants) {
  $('body').niceScroll({
    cursorcolor: "#337ab7",
    cursorwidth:"13px"
  });
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight : true
  });
  $scope.list = [];
  $scope.id = '';
  $scope.mid = [];
  // $scope.isHide = "隐藏";
  $scope.isDone = false;
  $scope.isDealed = "false";
  $scope.searchVal = '展开';
  // 时间清空
  $scope.clearStartTime = function(){
    $scope.order.jTime = '';
  }
  $scope.clearEndTime = function(){
    $scope.order.jTimeEnd = '';
  }
  $scope.clearDstartTime = function(){
    $scope.deliverStartTime = '';
  }
  $scope.clearDendTime = function(){
    $scope.deliverEndTime = '';
  }
  $scope.clearBegCreateTime = function(){
    $scope.begCreateTime = '';
  }
  $scope.clearEndCreateTime = function(){
    $scope.endCreateTime = '';
  };
  $scope.order = {
    order_type : '',
    sf_type : '',
    bps_type : '',
    jTime : '',
    jTimeEnd : '',
    thirdType : '',
    concactMobile : '',
    outRangeType : ''
  };
  // 获取第三方渠道
  $scope.getThirdOrg = function () {
    CommonService.httpRequest({
      url : '/thirdOrg/findAll.api',
      method : 'get'
    }).then(function (data) {
      $scope.thirdChannel = data.datas;
      // if($scope.thirdOrg || $scope.thirdOrg!=undefined || $scope.thirdOrg!=null){
      //   $scope.thirdOrg = $scope.thirdOrg + '';
      // }else{
      $scope.thirdOrg = '';
      // }
    });
  };
  $scope.deliverType = 'desc';
  $scope.deliverTime = 'create_time';
  $scope.order_type = Constants.order_type;
  $scope.sf_type = Constants.sf_type;
  $scope.bps_type = Constants.bps_type;
  $scope.order_source = Constants.order_source;
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
  // 获取机构群
  $scope.getOrg = function () {
    CommonService.httpRequest({
      url:'/orgGroup/list.api',
      method:'get'
    }).then(function (data) {
      $scope.orgList = data.datas;
    })
  };
  $scope.getOrg();
  $scope.getList = function(num){
    if($scope.order.jTime && $scope.order.jTimeEnd){
      if($scope.order.jTime > $scope.order.jTimeEnd){
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
    if($scope.begCreateTime && $scope.endCreateTime){
      if($scope.begCreateTime > $scope.endCreateTime){
        showWarn('下单时间不能大于下单结束时间');
        return;
      }
    }
    if($scope.deliverTime === 'create_time'){
      $scope.deliverType = 'desc';
    }
    else{
      $scope.deliverType = 'asc';
    }

    if($scope.order.outRangeType){
      $scope.order.outRangeType == $scope.order.outRangeType == '1' ? 1 : 0;
    }
    CommonService.pagination({
      url : '/orderException/findByPageV2.api',
      data :{
        pageNo : num || 1,
        begCreateTime : $scope.begCreateTime && new Date(($scope.begCreateTime + ' 00:00:00').replace(/-/g,"/")).getTime(),
        endCreateTime : $scope.endCreateTime && new Date(($scope.endCreateTime + ' 00:00:00').replace(/-/g,"/")).getTime(),
        orderNo : $scope.order.orderId || '',
        orderStatus : $scope.order.order_type,
        deliveryStatus : $scope.order.sf_type,
        create_Times : $scope.create_Times && new Date(($scope.create_Times + ' 00:00:00').replace(/-/g,"/")).getTime(),
        begSendTime : $scope.order.jTime && new Date(($scope.order.jTime + ' 00:00:00').replace(/-/g,"/")).getTime(),
        endSendTime : $scope.order.jTimeEnd && new Date(($scope.order.jTimeEnd+' 00:00:00').replace(/-/g,"/")).getTime(),
        deliverStartTime : $scope.deliverStartTime && new Date(($scope.deliverStartTime + ' 00:00:00').replace(/-/g,"/")).getTime(),
        deliverEndTime : $scope.deliverEndTime && new Date(($scope.deliverEndTime + ' 00:00:00').replace(/-/g,"/")).getTime(),
        bpsStatus : $scope.order.bps_type,
        distributionStatus : $scope.offerStatus,
        distributorName : $scope.offerName,
        handleExceptionStatus : $scope.handleStatus,
        orderByColumn : $scope.deliverTime,
        orderByType : $scope.deliverType,
        mailNo : $scope.mailNo,
        thirdOrg : $scope.thirdOrg ? parseInt($scope.thirdOrg) : '', // 先注释
        keyWord : $scope.order.query,
        thirdType : $scope.order.thirdType,
        outRangeType : $scope.order.outRangeType,
        orderSource : $scope.orderSource,
        mailChannel : parseInt($scope.mailChannel),
        orgId : $scope.orgId ? parseInt($scope.orgId) : ''
      }
    }).then(function(data){
      $scope.list = data.item;
      $scope.page = data.page;
    });
  }
  $scope.getList();
  $scope.detail = function(id){
    tabOpenParent({
      name:'orderDetail' +id,
      url:'orderDetail.html?id='+id,
      displayName: '订单' + id
    });
  };
  // $scope.hideCont = function (id) {
  //   var _orderList = $('#orderList'+id);
  //   // console.log(_orderList.prev().prev().children().last().children().eq(1).html())
  //   if(_orderList.hasClass('fade')){
  //     _orderList.removeClass('fade')
  //     _orderList.prev().prev().children().last().children().eq(1).html('隐藏')
  //   }else{
  //     _orderList.addClass('fade')
  //     _orderList.prev().prev().children().last().children().eq(1).html('显示')
  //   }
  // };
  // 申领任务
  $scope.applyTask = function (id) {
    showConfirm('是否申领任务?',function () {
      CommonService.httpRequest({
        url : '/orderException/apply.api',
        method : 'get',
        data : {
          orderId : id
        }
      }).then(function (data) {
        showInfo('申领成功', function () {
          $scope.getList();
        });
      });
    });
  };
  // 释放任务
  $scope.deleteTask = function (id) {
    showConfirm('是否释放任务?',function () {
      CommonService.httpRequest({
        url : '/orderException/release.api',
        method : 'get',
        data : {
          orderId : id
        }
      }).then(function (data) {
        showInfo('释放成功', function () {
          $scope.getList();
        });
      });
    });
  };
  $scope.mobileDetail = function(mobile,id){
    tabOpenParent({
      name:'contactCheckDetail_update'+id,
      url:'contactCheckDetail.html?mobile='+mobile,
      displayName:'客户信息详情'+id
    });
  };
  $scope.courseDetail = function(id,type){
    tabOpenParent({
      name:'addCourse_update'+id,
      url:'addCourse.html?id='+id+'&orderToCourse=1'+'&addrType='+type,
      displayName:'球场详情'+id
    });
  };
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
  $scope.travelDetail = function(id){
    tabOpenParent({
      name:'travelDetail_update'+id,
      url:'travelDetail.html?id='+id+'&orderToTravel=1',
      displayName:'合作方机构详情'+id
    });
  };$scope.courseDetail = function(id,type){
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
  $scope.userDetail = function(id){
    tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:'用户详情查询'+id});
  };

  $scope.daiUserDetail = function(id,name){
    tabOpenParent({name:'saleManManageDetail'+id,url:'saleManManageDetail.html?id='+id,displayName:'销售人员'+name});
  };
  $scope.showSearch = function () {
    if($('#toSearch').hasClass('fade')){
      $('#toSearch').removeClass('fade');
      $scope.searchVal = '收起';
    }else{
      $('#toSearch').addClass('fade');
      $scope.searchVal = '展开';
    }
  }

  // 回车搜索
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };

}]);