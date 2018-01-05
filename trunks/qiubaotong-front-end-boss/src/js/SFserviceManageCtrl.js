"use strict";
angular.module("app.views")
.controller('SFserviceManageCtrl',['$scope','CommonService','$timeout',function($scope,CommonService,$timeout){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getSFtime = function(){
      //顺丰客服服务时间管理
        CommonService.httpRequest({
                  url : '/kftime/list.api',
                  method : 'get',
                  data :{
                  }
              }).then(function(data){
                  var datas = data.datas;
                  var dataString = '';
                  for(var i = 0; i < datas.length; i++){
                    dataString += datas[i].weekDay;
                  }
                  for(var j = 1; j < 8; j++){
                    if(dataString.indexOf(j) == -1){
                      var datas_object = {items:[],weekDay:j};
                      datas.splice(j-1,0,datas_object);
                    }
                  }
                  $scope.sfkfes = datas;
              });
    }
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/sfkf/findByPage.api',
            data :{
                pageNo : num || "1"
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();
    $scope.getSFtime();

    $scope.deleteSFKF = function(id){
        CommonService.httpRequest({
                  url : '/sfkf/delete.api',
                  method : 'get',
                  data :{
                      id : id,
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    $scope.getList(1);
                    $scope.getSFtime();
                    
                });
              });
    };
    $scope.layerDeleteSFKF = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteSFKF(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.addSFKF = function(){

      if(!$scope.name){
            showWarn("客服名称不能为空");
            return false;
      }
      if(!$scope.mobile){
            showWarn("电话不能为空");
            return false;
      }
      else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.mobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.mobile))){
            }
            else{
                showWarn("联系电话格式错误");
                return false;
            }
        }

        CommonService.httpRequest({
                  url : '/sfkf/add.api',
                  method : 'post',
                  data :{
                      name : $scope.name,
                      mobile : $scope.mobile
                  }
              }).then(function(data){
                  showInfo("新增成功",function(){
                    $scope.getList();
                    $scope.name = '';
                    $scope.mobile = '';
                });
              });
    }
    $scope.addSlider = function(id,selectedName,sfkf){
      var min = 0, max = 0;
      var isRepeat = false;
      var dataSlider = $('#dataSlider' + id).val().split(',');
      var startSlider = dataSlider[0];
      var endSlider = dataSlider[1];
      if(!selectedName){
          showWarn('客服人员不能为空');
          return ;
        }
      if(startSlider == endSlider){
        showWarn('开始时间不能与结束时间相同');
        return;
      }
      if(sfkf != null && sfkf != '' && sfkf != undefined){
        for(var i = 0; i < sfkf.length; i++){
          min = Math.min(sfkf[i].begin,min);
          max = Math.max(sfkf[i].end,max);
        } 
      }
      
      if(startSlider < min && endSlider <= min){}
      else if(startSlider >= max && endSlider > max){}
      else{
        isRepeat = true;
      }

      if(isRepeat){
        layer.open({
              type: 1,
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '200px'], //宽高
              content: $('#memo'),
              btn:['确定'],
              yes:function(index, layero){
                layer.close(index);
              }
            });
      }
      else{
        CommonService.httpRequest({
              url : '/kftime/add.api',
              method : 'post',
              data :{
                  weekDay : id,
                  begin : startSlider,
                  end : endSlider,
                  serviceId : selectedName

              }
          }).then(function(data){
              showInfo("新增成功",function(){
                $scope.getSFtime();
            });
          });
      }
    }

    $scope.selectedName = function(name,id){
    }

    $scope.deleteServer = function(id){
        CommonService.httpRequest({
              url : '/kftime/delete.api',
              method : 'get',
              data :{
                  id : id

              }
          }).then(function(data){
              showInfo("删除成功",function(){
                $scope.getSFtime();
            });
          });
    }

    $scope.sliderShow = function(scope) {
        $('input.add_slider').slider({
          tooltip: 'always'
        });
   }
   $scope.sliderShow1 = function(scope) {
       $timeout(function () {
            $('.divSliders' + scope).find('.sliders').slider({
                tooltip : 'always',
                enabled : false
            });
       }, 10);
   }

}]);
