/**
 * Created by Administrator on 2017/7/31.
 */
angular.module("app.views")
.controller('agcyDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.cutLists = [];
  $scope.status = '1'
  var id = localStorage.getItem('manages');
  $scope.addCutList = function () {
    $scope.cutLists.push({minAmount:'',maxAmount:'',discount:''})
  };
  $scope.deleteCutList = function (id) {
    $scope.cutLists.splice(id,1)
  };
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url:'/orgGroup/detail.api',
      method:'get',
      data:{
        id:id
      }
    }).then(function (data) {
      var manages = data.datas;
      if(manages.amountConfigs===null||manages.amountConfigs===''||!manages.amountConfigs){
        $scope.cutLists = [];
      }else{
        for(var i=0;i<manages.amountConfigs.length;i++){
          $scope.cutLists.push({minAmount:'',maxAmount:'',discount:''});
          $scope.cutLists[i].minAmount = manages.amountConfigs[i].minAmount;
          $scope.cutLists[i].maxAmount = manages.amountConfigs[i].maxAmount;
          $scope.cutLists[i].discount = manages.amountConfigs[i].discount;
        }
      }
      $scope.id = manages.id;
      $scope.groupName = manages.name;
      $scope.groupNm = manages.shortName;
      $scope.endTime = manages.endDateStr;
      $scope.startTime = manages.startDateStr;
      $scope.status = manages.status + '';
      $scope.contact = manages.contact;
      $scope.phone = manages.mobile;
      $scope.remark = manages.remark;
    })
  };
  if(id){
    $scope.getList(id);
  }
  $scope.submitGroup = function () {
    if (!$scope.groupName) {
      showWarn("机构名称不能为空");
      return false;
    }
    if(!$scope.contact){
      showWarn("联系人不能为空");
      return false;
    }
    if(!$scope.phone){
      showWarn("联系电话不能为空");
      return false;
    }else {
      if($scope.phone.length<10){
        showWarn("联系电话格式不对");
        return false;
      }
    }
    if (!$scope.groupNm) {
      showWarn("机构简称不能为空");
      return false;
    }
    if (!$scope.startTime || !$scope.endTime) {
      showWarn("合作开始时间或结束时间不能为空");
      return false;
    } else {
      if ($scope.startTime > $scope.endTime) {
        showWarn("合作开始时间不能大于结束时间");
        return false;
      }
    }
    if (!$scope.status) {
      showWarn("状态不能为空");
      return false;
    }
    var obj = [];
    if (!id) {
      for (var i = 0; i < $scope.cutLists.length; i++) {
        if($scope.cutLists[i].maxAmount===''||$scope.cutLists[i].minAmount===''||$scope.cutLists[i].discount===''){
          showWarn("金额不能为空");
          return false;
        }
        if(i>0 && (parseInt($scope.cutLists[i-1].maxAmount)>=parseInt($scope.cutLists[i].minAmount))){
          showWarn("金额区间不能重复");
          return false;
        }
        if(parseInt($scope.cutLists[i].minAmount)>parseInt($scope.cutLists[i].maxAmount) || parseInt($scope.cutLists[i].discount)>parseInt($scope.cutLists[i].maxAmount)){
          showWarn("当前的最低价格或优惠不能高于最高价格");
          return false;
        }
        obj.push($scope.cutLists[i]);
      }
      CommonService.httpRequest({
        url: '/orgGroup/add.api',
        method: 'post',
        data: {
          amountConfigs: obj,
          contact: $scope.contact,
          endDate: $scope.endTime,
          startDate: $scope.startTime,
          remark: $scope.remark,
          mobile:$scope.phone,
          name:$scope.groupName,
          shortName:$scope.groupNm,
          status:parseInt($scope.status)
        }
      }).then(function (data) {
        showInfo("新增成功", function () {
          tabOpenParent({name: 'agcyPromo', url: 'agcyPromo.html', displayName: '机构群优惠管理'});
        });
      })
    } else {
      if ($scope.cutLists.length > 0) {
        for (var i = 0; i < $scope.cutLists.length; i++) {
          if($scope.cutLists[i].maxAmount===''||$scope.cutLists[i].minAmount===''||$scope.cutLists[i].discount==='') {
            showWarn("金额不能为空");
            return false;
          }
          if(i>0 && (parseInt($scope.cutLists[i-1].maxAmount)>=parseInt($scope.cutLists[i].minAmount))){
            showWarn("金额区间不能重复");
            return false;
          }
          if(parseInt($scope.cutLists[i].minAmount)>parseInt($scope.cutLists[i].maxAmount) || parseInt($scope.cutLists[i].discount)>parseInt($scope.cutLists[i].maxAmount)){
            showWarn("最低或优惠价格不能高于最高价格");
            return false;
          }
          obj.push($scope.cutLists[i]);
        }
      }
      CommonService.httpRequest({
        url: '/orgGroup/update.api',
        method: 'post',
        data: {
          id: id,
          amountConfigs: obj,
          contact: $scope.contact,
          endDate: $scope.endTime,
          startDate: $scope.startTime,
          remark: $scope.remark,
          mobile:$scope.phone,
          name:$scope.groupName,
          shortName:$scope.groupNm,
          status:parseInt($scope.status)
        }
      }).then(function (data) {
        showInfo("更新成功", function () {
          tabOpenParent({name: 'agcyPromo', url: 'agcyPromo.html', displayName: '机构群优惠管理'});
        });
      })
      localStorage.removeItem("manages");
    }
  };
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
}]);