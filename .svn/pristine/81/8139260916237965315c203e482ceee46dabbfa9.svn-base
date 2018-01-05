"use strict";
angular.module("app.views")
.controller('vipOrderInfoCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});

    $scope.order_type = Constants.order_type;
    $scope.sf_type = Constants.sf_type;

    $scope.getList = function(page){
        CommonService.pagination({
        	url : '/vipOrderInfo/findByPage.api',
        	data :{
        		pageNo : page || 1,
                deliveryStatus : $scope.deliveryStatus,
                mailNo : $scope.mailNo,
                mobile : $scope.mobile,
                number : $scope.number,
                orderStatus : $scope.orderStatus,
                userName : $scope.userName,
                vipNo : $scope.vipNo
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

    $scope.isWeixin = function(mobile,id){
        id = id.substring(0,4);
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

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };


}]);
