"use strict";
angular.module("app.views")
.controller('coupunCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.activityId = parseInt(localStorage.getItem('manages'));
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/coupon/findByPage.api',
            data :{
                pageNo : num || "1",
                code : $scope.codes,
                userName : $scope.userName,
                activityId : $scope.activityId
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }

    $scope.getUser = function(num){
        CommonService.pagination({
                url : '/userWeixin/findByPage.api',
                data :{
                    pageNo : num || "1",
                    name : $scope.userName
                }
            }).then(function(data){
                $scope.users = data.item;
                $scope.page1 = data.page;
            });
    }
    $scope.getList(1);
    
    
    $scope.receiveToUser = function(item){
        $scope.getUser(1);
        $scope.selectedCoupun = item;
        layer.open({    
              type: 1,
              title:'请选择分发的用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
            });
    }

    $scope.receive = function(id,name){
        CommonService.httpRequest({
                  url : '/coupon/update.api',
                  method : 'post',
                  data : {
                    id : $scope.selectedCoupun.id,
                    activityId : $scope.selectedCoupun.activityId,
                    code : $scope.selectedCoupun.code,
                    userId : id,
                    userName : name
                  }
              }).then(function(data){
                    layer.closeAll();
                    $scope.getList();
              });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };


}]);

