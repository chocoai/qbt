/**
 * Created by Administrator on 2017/7/18.
 */
angular.module("app.views")
.controller('farAreaDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.keywords = [];
  $scope.province = '';
  $scope.city = '';
  $scope.county = '';
  var id = localStorage.getItem('manages');
  var reg = new RegExp("/^\d+$/","g"); 
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url:'/outRangeAddress/findById.api',
      method:'get',
      data:{
        id:id
      }
    }).then(function (data) {
      var manages = data.datas;
      if(manages.addressArr===null||manages.addressArr===''||!manages.addressArr){
        $scope.keywords = [];
      }else{
        for(var i=0;i<manages.addressArr.length;i++){
          $scope.keywords.push({limitKeyword:''});
          $scope.keywords[i].limitKeyword = manages.addressArr[i];
        }
      }
      $scope.id = manages.id;
      $scope.province = manages.treeId.split(',')[0];
      $scope.city = manages.treeId.split(',')[1];
      $scope.county = manages.treeId.split(',')[2];
      $scope.costs = manages.outRangePrice;
      $scope.days = manages.outRangeTime;
      $scope.remark = manages.remark;
      CommonService.httpRequest({
        url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province,
        method : 'post',
      }).then(function(data){
        $scope.citieses = data.datas;
      });
      CommonService.httpRequest({
        url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
        method : 'post',
      }).then(function(data){
        $scope.countieses = data.datas;
      });
    })
  };
  if(id){
    $scope.getList(id)
  }
  $scope.getProvinces = function(){
    CommonService.httpRequest({
      url : '/baseSfArea/findByParentId.api?parentId=1000000',
      method : 'post',
    }).then(function(data){
      $scope.provinceses = data.datas;
    });
  };
  $scope.getProvinces();
  $scope.getCitieses = function(type){
    // if(type == 1){
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
  };
  $scope.getCounties = function(type){
      if(!!$scope.city){
        CommonService.httpRequest({
          url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
          method : 'post',
        }).then(function(data){
          $scope.countieses = data.datas;
          $scope.parentId = data.datas.parentId;
        });
      }
      else{
        $scope.countieses = '';
      }
      $scope.county = '';
  };

  $scope.addKeyword = function () {
    $scope.keywords.push({limitKeyword:''});
  };
  $scope.deleteKeyword = function (id) {
    $scope.keywords.splice(id,1);
  };
  $scope.addNewArea = function () {
    if(!$scope.province){
      showWarn("省不能为空");
      return false;
    }
    if(!$scope.city){
      showWarn("市不能为空");
      return false;
    }
    if(!$scope.county){
      showWarn("区不能为空");
      return false;
    }
    if($scope.costs===''){
      showWarn("偏远价格不能为空");
      return false;
    }

    if($scope.days===''){
      showWarn("偏远时效不能为空");
      return false;
    }
    else if($scope.days>999){
      showWarn("偏远时效不能大于999");
      return false;
    }else{

    }
    var obj = [];
    if(!id){
      for(var i=0;i<$scope.keywords.length;i++){
        obj.push($scope.keywords[i].limitKeyword);
      }
      CommonService.httpRequest({
        url:'/outRangeAddress/add.api',
        method:'post',
        data:{
          addressArr:obj,
          areaId:parseInt($scope.county),
          outRangePrice:$scope.costs,
          outRangeTime:$scope.days,
          remark:$scope.remark
        }
      }).then(function (data) {
        showInfo("新增成功",function(){
          tabOpenParent({name:'farArea',url:'farArea.html',displayName:'偏远地区管理'});
        });
      })
    }else{
      if($scope.keywords.length>0){
        for(var i=0;i<$scope.keywords.length;i++){
          obj.push($scope.keywords[i].limitKeyword);
        }
      }
      CommonService.httpRequest({
        url:'/outRangeAddress/updateById.api',
        method:'post',
        data:{
          id:id,
          addressArr:obj,
          areaId:parseInt($scope.county),
          outRangePrice:$scope.costs,
          outRangeTime:$scope.days,
          remark:$scope.remark
        }
      }).then(function (data) {
        showInfo("更新成功",function(){
          tabOpenParent({name:'farArea',url:'farArea.html',displayName:'偏远地区管理'});
        });
      })
      localStorage.removeItem("manages");
    }
  }

  /*输入控制两位小数-start*/
  window.keyUpTwoDecimal = function(obj){  
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符   
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的   
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");  
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数   
    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额  
     obj.value= parseFloat(obj.value);  
    }
    $(obj).trigger("change");  
  } 
}])