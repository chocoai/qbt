"use strict";
angular.module("app.views")
.controller('partnerOrderCheckCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
	$('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearPayStartTime = function(){
        $scope.payStartTime = '';
    };
    $scope.clearPayEndTime = function(){
        $scope.payEndTime = '';
    };
    $scope.payStartTime = '';
    $scope.payEndTime = '';
    $scope.orderNumber = '';
    $scope.settleModel = '';
    $scope.settleState = '';
    $scope.userName  = '';
    $scope.thirdId = '';
    $scope.order_type = Constants.order_type;
    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/thirdOrder/findByPage.api',
            data :{
        		pageNo : num || "1",
                startDate : $scope.payStartTime,
                endDate : $scope.payEndTime,
                orderNumber:$scope.orderNumber,
                thirdId:$scope.thirdId,
                settleModel:$scope.settleModel,
                settleState:$scope.settleState,
                userName:$scope.userName,
                orderStatus:$scope.orderStatus
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    };
    $scope.getList();
    $scope.settle = function(id){
        layer.open({
              type: 1,
              title:'结算备注说明',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '240px'], //宽高
              content: $('#remark'),
              btn:['确定','关闭'],
              yes:function(index, layero){
                if(!$scope.remark){
                  showWarn('备注不能为空');
                }
                else{
                    CommonService.httpRequest({
                      url : '/thirdOrder/settlement.api',
                      method : 'post',
                      data :{
                          id : parseInt(id),
                          remark: $scope.remark
                      }
                  }).then(function(data){
                      $scope.remark = '';
                      showInfo("结算成功");
                      layer.close(index);
                      $scope.getList();
                  });
                  
                }
              }
            });
    };

    $scope.batchSettle = function(){
      if($scope.settleState == 2){
        showWarn('订单已批量结算');
        return false;
      }
      if($scope.settleState == 3){
        showWarn('无效订单不能结算');
        return false;
      }
      CommonService.httpRequest({
        url: '/thirdOrder/findSettlementBatch.api',
        method: 'post',
        data: {
          startDate : $scope.payStartTime,
          endDate : $scope.payEndTime,
          orderNumber : $scope.orderNumber,
          settleModel : $scope.settleModel,
          settleState : $scope.settleState,
          userName : $scope.userName,
          thirdId : $scope.thirdId
          }
      }).then(function(data){
        if(data.datas){
          layer.open({
              type: 1,
              title:'批量结算备注说明',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '240px'], //宽高
              content: $('#remark'),
              btn:['确定','关闭'],
              yes:function(index, layero){
                if(!$scope.remark){
                  showWarn('备注不能为空');
                }
                else{
                    CommonService.httpRequest({
                      url : '/thirdOrder/settlementBatch.api',
                      method : 'post',
                      data :{
                            startDate : $scope.payStartTime,
                            endDate : $scope.payEndTime,
                            orderNumber : $scope.orderNumber,
                            settleModel : $scope.settleModel,
                            settleState : $scope.settleState,
                            userName : $scope.userName,
                            remark : $scope.remark,
                            thirdId : $scope.thirdId
                      }
                  }).then(function(data){
                      $scope.remark = '';
                      showInfo("批量结算成功");
                      layer.close(index);
                      $scope.getList();
                  });
                  
                }
              }
            });
        }
        else{
          showWarn('订单已批量结算');
        }
      });
        
    };

    //合作机构操作
    $scope.clearThird = function(){
        $('#thirdText').text('选择合作方');
        $scope.thirdId = '';
    }
     $scope.getThird = function(num){
        CommonService.pagination({
            url : '/basePartner/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.thirdName
            }
        }).then(function(data){
            $scope.thirds = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.selectThird = function(){
        $scope.getThird();
            layer.open({    
              type: 1,
              title:'请选择合作方',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
              end : function(){
                $scope.thirdName = '';
              }
            });
        document.onkeydown = '';
    }
    $scope.selectedThird = function(id,name){
        $('#thirdText').text(name);
        $scope.thirdId = id;
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                    $scope.getList();
               }
           };
    };

    $scope.detail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };

    $('#search').focus();
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                  $('select').blur();
                   $scope.getList();
               }
           };

}]);
