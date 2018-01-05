"use strict";
angular.module("app.views")
.controller('vipInfoCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];

    $scope.getVipType = function(num){
        CommonService.pagination({
            url : '/vipType/findByPage.api',
            data :{
                pageNo : num || "1",
                pageSize:100
            }
        }).then(function(data){
            $scope.vipTypes = data.item;
        });
    };

    $scope.getList = function(num){
        CommonService.pagination({
            url : '/vipInfo/findByPage.api',
            data :{
                pageNo : num || "1",
                vipNo : $scope.vipNo,
                userName : $scope.userName,
                vipTypeId : $scope.vipTypeId,
                nickname : $scope.nickname,
                mobile : $scope.mobile
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();
    $scope.getVipType();

    $scope.updateVipInfo = function(id){
        tabOpenParent({name:'vipInfoDetail_update'+id,url:'vipInfoDetail.html?id=' + id,displayName:'会员详情'+id});
        
    }


    $scope.vipDisabled = function(id,status){
      CommonService.httpRequest({
        url : '/vipInfo/updateStatus.api',
        method : 'get',
        data :{
          id : id,
          status: status  == 1 ? 2 : 1
        }
      }).then(function(data){
        if(status == 1){
          showInfo("禁用成功",function(){
            $scope.getList();
          });
        }
        else{
          showInfo("启用成功",function(){
            $scope.getList();
          });
        }
        
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

    $scope.getWecatId = function(openId){
        CommonService.httpRequest({
          url : '/userWeixin/findUserIdByOpenId.api',
          method : 'get',
          data :{
            openId : openId
          }
        }).then(function(data){
            $scope.userDetail(data.datas);
        });
    };



    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
