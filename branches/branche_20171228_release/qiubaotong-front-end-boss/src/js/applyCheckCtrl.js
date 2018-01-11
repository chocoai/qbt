"use strict";
angular.module("app.views")
.controller('applyCheckCtrl',['$scope','CommonService','$timeout',function($scope,CommonService,$timeout){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.fBaseUrl = fBaseUrl;
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/userAssistantApply/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.applyName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();
    $scope.apply_status = function(id){
        layer.open({
              type: 1,
              title:'确定设置状态为审核通过？',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '240px'], //宽高
              content: $('#memo'),
              btn:['审核通过','审核拒绝'],
              yes:function(index, layero){
                CommonService.httpRequest({
                  url : '/userAssistantApply/updateStatus.api',
                  method : 'post',
                  data :{
                      assistantId : parseInt(id),
                      status:'2',
                      memo:$scope.memo
                  }
              }).then(function(data){
                  $scope.getList(1);
                  layer.close(index);
              });
              },
              btn2:function(index, layero){
                if(!$scope.memo){
                  showWarn('审核拒绝原因不能为空');
                  return;
                }
                CommonService.httpRequest({
                      url : '/userAssistantApply/updateStatus.api',
                      method : 'post',
                      data :{
                          assistantId : parseInt(id),
                          status:'3',
                          memo:$scope.memo
                      }
                  }).then(function(data){
                      $scope.getList(1);
                      layer.close(index);
                  });
              }
            });
    };

    $scope.imgShow = function(src){
      $scope.imgToBig = src;
        $timeout(function () {
          layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            area: '26%',
            shadeClose: true,
            closeBtn:true,
            content: $('#picShow')
          });
        },10)
    };
    $scope.picRotate = function(){
      var picShow = document.getElementById('picShow').parentNode.parentNode;
      picShow.style.animation = 'none';
      var picShowRotate = parseInt(picShow.style.transform.replace('rotate(','').replace('deg)',''));
      if(!picShowRotate){
        picShow.style.transform = 'rotate(90deg)';
      }
      else{
        picShowRotate = picShowRotate + 90;
        if(picShowRotate == 360){
          picShowRotate = 0;
        }
        picShow.style.transform = 'rotate(' + picShowRotate + 'deg)';
      }
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

    
}]);
