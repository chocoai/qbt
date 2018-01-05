"use strict";
angular.module("app.views")
.controller('contactCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.isDelete = '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/contact/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.name,
                mobile : $scope.mobile,
                isDelete:$scope.isDelete
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addContact = function(){
        tabOpenParent({name:'contactCheckDetail_add',url:'contactCheckDetail.html',displayName:'新增客户信息'});
    }
    $scope.updateContact = function(mobile,weixinList,id,name){
        $scope.isWeixin(mobile,weixinList,id,name);
    }

    $scope.isWeixin = function(mobile,weixinList,id,name){
        if(weixinList){
          if(weixinList.length > 1){
            tabOpenParent({name:'userCheck'+weixinList[0].id,url:'userCheck.html?mobileOfMoreWeixin='+mobile,displayName:'微信用户查询'+weixinList[0].id});
          }
          else{
            $scope.userDetail(weixinList[0].id,name);
          }
        }
        else{
          tabOpenParent({name:'contactCheckDetail_update'+id,url:'contactCheckDetail.html?mobile='+mobile,displayName:name + '详情'});
        }
    };

    $scope.userDetail = function(id,name){
      tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:name + '详情'});
    };

    $scope.deleteContact = function(mobile,isDelete){
      CommonService.httpRequest({
        url : '/contact/delete.api',
        method : 'get',
        data :{
          mobile : mobile,
          isDelete:!isDelete

        }
      }).then(function(data){
        $scope.getList();
    });
    }

    $scope.deleteNotPay = function(mobile){
      CommonService.httpRequest({
        url : '/contact/remove.api',
        method : 'get',
        data :{
          mobile : mobile
        }
      }).then(function(data){
        showInfo("删除成功",function(){
          $scope.getList();
        });
        
      });
    }
    $scope.layerDeleteNotPay = function(mobile){
          layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
            $scope.deleteNotPay(mobile);
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
