"use strict";
angular.module("app.views")
.controller('advertiseCheckCtrl',['$scope','CommonService','Constants','$timeout',function($scope,CommonService,Constants,$timeout){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.advertise_seat = Constants.advertise_seat;
    $scope.fBaseUrl = fBaseUrl;
    $scope.list = [];
    $scope.type = '';
    $scope.position = '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseAdv/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.name,
                type : $scope.type,
                position:$scope.position
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addAdv = function(){
        localStorage.removeItem('manages');
        tabOpenParent({name:'advertiseCheck_add',url:'advertiseCheckDetail.html',displayName:'新增广告位'});
    }
    $scope.updateAdv = function(item){
        localStorage.setItem("manages", item);
        tabOpenParent({name:'advertiseCheck_update',url:'advertiseCheckDetail.html',displayName:'更新广告位'});
        
    }

    $scope.deleteAdv = function(id){
        CommonService.httpRequest({
                  url : '/baseAdv/delete.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    location.href = 'advertiseCheck.html';
                });
              });
    };
    $scope.layerDeleteAdv = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteAdv(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.imgShow = function(src){
      $scope.imgToBig = src;
        $timeout(function () {
          layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            // area: '516px',
            shadeClose: true,
            closeBtn:true,
            content: $('#picShow')
          });
        },10)
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                  $('select').blur();
                   $scope.getList();
               }
           };


}]);
