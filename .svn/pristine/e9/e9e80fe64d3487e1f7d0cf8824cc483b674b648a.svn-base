"use strict";
angular.module("app.views")
.controller('reSendEmailCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});

    $scope.list = [];
    $scope.emailStatus_type = Constants.emailStatus_type;
    $scope.platform_types = Constants.platform_type;
    $scope.requestStatus = '';

    //平台判断
    $scope.platId = localStorage.getItem('b_plat');
    if($scope.platId == 1){
        $scope.platform = 'qbt';
    }

    $scope.getList = function(num){
        CommonService.pagination({
            url : '/emailMessage/findByPage.api',
            data :{
                pageNo : num || "1",
                requestStatus : parseInt($scope.requestStatus),
                platform : $scope.platform,
                subject : $scope.subject,
                data : $scope.emailData,
                emailAddress : $scope.emailAddress
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.reSendEmailDetail = function(item){
        var itemStr=JSON.stringify(item);
        localStorage.setItem("manages", itemStr);
        tabOpenParent({name:'reSendEmailDetail',url:'reSendEmailDetail.html',displayName:'邮件详情'});
        
    }

    $scope.reSendEmail = function(uuid){
        CommonService.httpRequest({
                url : '/emailMessage/resend.api',
                method : 'get',
                data :{
                    uuid  : uuid
                }
            }).then(function(data){
                showInfo("补发成功",function(){
                    $scope.getList();
                });
            });
    };
    $scope.layerReSendEmail = function(uuid){
        layer.confirm('确定补发吗?', {icon: 3, title:'提示'}, function(index){
          $scope.reSendEmail(uuid);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
