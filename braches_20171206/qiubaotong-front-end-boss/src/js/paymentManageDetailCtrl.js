/**
 * Created by Administrator on 2017/6/6.
 */
angular.module("app.views")
.controller('paymentManageDetailCtrl',['$scope','CommonService',function($scope,CommonService){
  $('body').niceScroll({cursorcolor:"#337ab7"});
  var manages = localStorage.getItem('manages');
  $scope.startProvince = '';
  $scope.endProvince = '';
  $scope.cichenFavourablePrice = '';
  $scope.cichenQbtPrice = '';
  $scope.ciriFavourablePrice= '';
  $scope.ciriQbtPrice = '';
  $scope.geriFavourablePrice = '';
  $scope.geriQbtPrice = '';
  $scope.getMessage = function(){
    manages = JSON.parse(manages);
    $scope.id = manages.id;
    $scope.startProvince = manages.startArea;
    $scope.endProvince = manages.endArea;
    $scope.cichenFavourablePrice = manages.cichenFavourablePrice;
    $scope.cichenQbtPrice = manages.cichenQbtPrice
    $scope.ciriFavourablePrice = manages.ciriFavourablePrice
    $scope.ciriQbtPrice = manages.ciriQbtPrice
    $scope.geriFavourablePrice = manages.geriFavourablePrice
    $scope.geriQbtPrice = manages.geriQbtPrice
  }
  $scope.getProvinces = function(){
    CommonService.httpRequest({
      url : '/baseSfArea/findByParentId.api?parentId=1000000',
      method : 'post',
    }).then(function(data){
      // $scope.Allprovinces = data.datas;
      $scope.startProvinceses = data.datas;
      $scope.endProvinceses = data.datas;
    });
  }
  $scope.addPrice = function () {
    if(!$scope.startProvince){
      showWarn("寄件地区不能为空");
      return false;
    }
    if(!$scope.endProvince){
      showWarn("收件地区不能为空");
      return false;
    }
    if($scope.cichenFavourablePrice==='' || $scope.cichenFavourablePrice < 0){
      showWarn("次晨优惠价格不能为空或小于0");
      return false;
    }
    else{
      if($scope.cichenFavourablePrice > 999.99){
        showWarn("次晨优惠价格不能大于999.99");
        return false;
      }
    }
    if($scope.cichenQbtPrice==='' || $scope.cichenQbtPrice < 0){
      showWarn("次晨球包通价格不能为空或小于0");
      return false;
    }
    else{
      if($scope.cichenQbtPrice > 999.99){
        showWarn("次晨球包通价格不能大于999.99");
        return false;
      }
    }
    if($scope.ciriFavourablePrice==='' || $scope.ciriFavourablePrice < 0){
      showWarn("次日优惠价格不能为空或小于0");
      return false;
    }
    else{
      if($scope.ciriFavourablePrice > 999.99){
        showWarn("次日优惠价格不能大于999.99");
        return false;
      }
    }
    if($scope.ciriQbtPrice==='' || $scope.ciriQbtPrice < 0){
      showWarn("次日球包通价格不能为空或小于0");
      return false;
    }
    else{
      if($scope.ciriQbtPrice > 999.99){
        showWarn("次日球包通价格不能大于999.99");
        return false;
      }
    }
    if($scope.geriFavourablePrice==='' || $scope.geriFavourablePrice < 0){
      showWarn("隔日优惠价格不能为空或小于0");
      return false;
    }
    else{
      if($scope.geriSfPrice > 999.99){
        showWarn("隔日优惠价格不能大于999.99");
        return false;
      }
    }
    if($scope.geriQbtPrice==='' || $scope.geriQbtPrice < 0){
      showWarn("隔日球包通不能为空或小于0");
      return false;
    }
    else{
      if($scope.geriQbtPrice > 999.99){
        showWarn("隔日球包通不能大于999.99");
        return false;
      }
    }
    if (!$scope.id){
      CommonService.httpRequest({
        method:'post',
        url:'/baseNewSfPrice/add.api',
        data:{
          cichenFavourablePrice:parseFloat($scope.cichenFavourablePrice),
          cichenQbtPrice:parseFloat($scope.cichenQbtPrice),
          ciriFavourablePrice:parseFloat($scope.ciriFavourablePrice),
          ciriQbtPrice:parseFloat($scope.ciriQbtPrice),
          endArea:$scope.endProvince.split('|')[1],
          geriFavourablePrice:parseFloat($scope.geriFavourablePrice),
          geriQbtPrice:parseFloat($scope.geriQbtPrice),
          startArea:$scope.startProvince.split('|')[1]
        }
      }).then(function (data) {
        showInfo("新增成功",function(){
          tabOpenParent({name:'paymentManage',url:'paymentManage.html',displayName:'运费管理'});
        });
      })
    }
    else{
      CommonService.httpRequest({
        method:'post',
        url:'/baseNewSfPrice/update.api',
        data:{
          cichenFavourablePrice:parseFloat($scope.cichenFavourablePrice),
          cichenQbtPrice:parseFloat($scope.cichenQbtPrice),
          ciriFavourablePrice:parseFloat($scope.ciriFavourablePrice),
          ciriQbtPrice:parseFloat($scope.ciriQbtPrice),
          endArea:$scope.endProvince.split('|')[1],
          geriFavourablePrice:parseFloat($scope.geriFavourablePrice),
          geriQbtPrice:parseFloat($scope.geriQbtPrice),
          id : parseInt($scope.id),
          startArea:$scope.startProvince.split('|')[1]
        }
      }).then(function (data) {
        showInfo("更新成功",function(){
          tabOpenParent({name:'paymentManage',url:'paymentManage.html',displayName:'运费管理'});
        });
      });
      localStorage.removeItem('manages');
    }
  }
  if(manages != '' && manages != null && manages != undefined){
    $scope.getMessage();
    CommonService.httpRequest({
      url : '/baseSfArea/findByParentId.api?parentId=1000000',
      method : 'post',
    }).then(function(data) {
      var datas = data.datas;
      $scope.startProvinceses = datas;
      $scope.endProvinceses = datas;
      for(var i = 0; i < datas.length; i++) {
        if (datas[i].name == $scope.startProvince) {
          var startPro = datas[i].id;
          CommonService.httpRequest({
            url: '/baseSfArea/findByParentId.api?parentId=' + startPro,
            method: 'post',
          }).then(function (data) {
            $scope.startProvince = startPro + '|' + $scope.startProvince;
          })
        }
        if (datas[i].name == $scope.endProvince) {
          var endPro = datas[i].id;
          CommonService.httpRequest({
            url: '/baseSfArea/findByParentId.api?parentId=' + endPro,
            method: 'post',
          }).then(function (data) {
            $scope.endProvince = endPro + '|' + $scope.endProvince;
          })
        }
      }
    })
  }else {
    $scope.getProvinces();
  }
  /*输入控制两位小数-start*/
  window.keyUpTwoDecimal = function(obj){
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数
    // if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
    //   obj.value= parseFloat(obj.value);
    // }
    $(obj).trigger("change");
  };
}])