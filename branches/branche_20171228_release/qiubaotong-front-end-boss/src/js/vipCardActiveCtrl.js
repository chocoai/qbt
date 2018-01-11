"use strict";
angular.module("app.views")
.controller('vipCardActiveCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
     $scope.wecatName = '选择微信用户';
     $scope.getWecat = function(num){
        CommonService.pagination({
            url : '/userWeixin/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.selectWecatName
            }
        }).then(function(data){
            $scope.wecats = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.selectWecat = function(item){
        $scope.getWecat();
        layer.open({    
              type :1,
              title:'请选择微信用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['480px', '535px'], //宽高
              content: $('#memo'),
              end: function(){
                $scope.selectWecatName = '';
              }
            });
    }
    $scope.selectedWecat = function(wecat){
        $scope.openId = wecat.openid;
        $scope.wecatName = wecat.nickname;
        layer.closeAll();
    };
    $scope.clearWecat = function(){
        $scope.openId = '';
        $scope.wecatName = '选择微信用户';
    };
    $scope.succeed = function(){
        if(!$scope.vipNo){
            showWarn('请输入卡号！');
            return false;
        }
        if(!$scope.random){
            showWarn('请输入验证码！');
            return false;
        }
        if(!$scope.userName){
            showWarn('请输入会员姓名！');
            return false;
        }
        if(!$scope.mobile){
            showWarn('请输入会员电话！');
            return false;
        }
        else if(!(/(^1[\d]{10}$)/g.test($scope.mobile))){
            showWarn('会员手机号格式错误');
            return false;
        }
        CommonService.httpRequest({
                url : '/vipInfo/activate.api',
                method : 'post',
                data :{
                    openId: $scope.openId,
                    userName : $scope.userName,
                    vipNo : $scope.vipNo,
                    random : $scope.random,
                    mobile : $scope.mobile
                }
            }).then(function(data){
            showInfo('激活成功！',function(){
                $scope.vipNo='';
                $scope.userName='';
                $scope.mobile='';
                $scope.random='';
                $scope.wecatName = '选择微信用户' 
                $scope.$apply();
            })    
        })
    }
}]);