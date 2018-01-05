"use strict";
angular.module("app.views")
.controller('priceManageCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.selectStartPro = '';
    $scope.selectStartCity = '';
    $scope.selectEndPro = '';
    $scope.selectEndCity = '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseSFPrice/findByPage.api',
            data : {
                pageNo : num || "1",
                startProvince : $scope.selectStartPro.split('|')[1],
                startCity : $scope.selectStartCity.split('|')[1],
                endProvince : $scope.selectEndPro.split('|')[1],
                endCity : $scope.selectEndCity.split('|')[1]
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }

    $scope.addPrice = function(){
    	localStorage.removeItem('manages');
    	tabOpenParent({name:'priceManageDetail_add',url:'priceManageDetail.html',displayName:'新增价格'});
    }
    $scope.updatePrice = function(item){
      var itemStr=JSON.stringify(item);
		  localStorage.setItem("manages", itemStr);
    	tabOpenParent({name:'priceManageDetail_update',url:'priceManageDetail.html',displayName:'更新价格'});
   		
    }


    $scope.deletePrice = function(id){
        CommonService.httpRequest({
                  url : '/baseSFPrice/deleteById.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    $scope.getList(1);
                });
              });
    };
    $scope.layerDeletePrice = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deletePrice(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.startProvinceses = data.datas;
            $scope.endProvinceses = data.datas;
        });
    };
    $scope.getProvinces();
    $scope.getCitieses = function(id){
        if(id == 1){
            if(!!$scope.selectStartPro){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.selectStartPro.split('|')[0],
                    method : 'post',
                }).then(function(data){
                    $scope.startCitieses = data.datas;
                }); 
            }
            else{
                $scope.startCitieses = '';
            }
            $scope.selectStartCity = '';
        }
        else{
            if(!!$scope.selectEndPro){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.selectEndPro.split('|')[0],
                    method : 'post',
                }).then(function(data){
                    $scope.endCitieses = data.datas;
                });
            }
            else{
                $scope.endCitieses = '';
            }
            $scope.selectEndCity = '';
        }
        
    }

    $scope.findAllPrice = function(num){
      $scope.selectStartPro = '';
      $scope.selectStartCity = '';
      $scope.selectEndPro = '';
      $scope.selectEndCity = '';
        CommonService.pagination({
            url : '/baseSFPrice/findByPage.api',
            data :{
                pageNo : num || "1"
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }

    $scope.getList();
    $scope.getProvinces();

     document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };
    
}]);
