"use strict";
angular.module("app.views")
.controller('travelCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.fBaseUrl = fBaseUrl;
    $scope.list = [];
    $scope.name = '';
    $scope.areaId = '';
    $scope.shareOrder = '';
    $scope.settleType = '';
    $scope.status = '';

    $scope.getList = function(num){
        CommonService.pagination({
            url : '/basePartner/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.name,
                areaId : parseInt($scope.county || $scope.city || $scope.province) || '',
                shareOrder : $scope.shareOrder,
                settleType : $scope.settleType,
                status : $scope.status
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addTravel = function(){
        localStorage.removeItem('manages');
        tabOpenParent({name:'travelDetail_add',url:'travelDetail.html',displayName:'新增合作旅行社'});
    }
    $scope.updateTravel = function(item){
        localStorage.setItem("manages", item);
        tabOpenParent({name:'travelDetail_update',url:'travelDetail.html?id='+item,displayName:'更新合作旅行社'});
        
    }

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses = data.datas;
        });
    }
    $scope.getProvinces();
    $scope.getCitieses = function(){
        if(!!$scope.province){
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province,
                method : 'post',
            }).then(function(data){
                $scope.citieses = data.datas;
            });

        }
        else{
            $scope.citieses = '';
            $scope.countieses = '';
        }
        $scope.city = '';
        $scope.county = '';
    }
    $scope.getCounties = function(){
        if(!!$scope.city){
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
                method : 'post',
            }).then(function(data){
                $scope.countieses = data.datas;
            });
        }
        else{
            $scope.countieses = '';
        }
        $scope.county = '';
    }


    $scope.toDisable = function(id){
      layer.confirm('确定设置为禁用吗？', {
          btn: ['确定','取消'] //按钮
        }, function(index){
          CommonService.httpRequest({
                  url : '/basePartner/delete.api',
                  method : 'get',
                  data :{
                      id : id,
                      status:2
                  }
              }).then(function(data){
                  $scope.getList($scope.page.pageNumber);
                  layer.close(index);
              });
        }, function(index){
          layer.close(index);
        });
    };

    $scope.toEnable = function(id){
      layer.confirm('确定设置为启用吗？', {
          btn: ['确定','取消'] //按钮
        }, function(index){
          CommonService.httpRequest({
                  url : '/basePartner/delete.api',
                  method : 'get',
                  data :{
                      id : id,
                      status:1
                  }
              }).then(function(data){
                  $scope.getList($scope.page.pageNumber);
                  layer.close(index);
              });
        }, function(index){
          layer.close(index);
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
