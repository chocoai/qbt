/**
 * Created by Administrator on 2017/10/23.
 */
"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('systemConfigureCtrl', ["$scope", "CommonService","Constants",'Upload',function ($scope, CommonService, Constants,Upload) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  // $('.date-picker').datepicker({
  //   format : 'yyyy-mm-dd',
  //   autoclose: true,
  //   todayHighlight:true
  // });
  $scope.host = '';
  $scope.name = '';
  $scope.password = '';
  $scope.platForm = '';
  $scope.emailPort = '';
  $scope.sendFrom = '';
  $scope.sendTos = [''];
  $scope.sendToCcs = [''];
  $scope.username = '';
  $scope.code = '';
  $scope.id = '';

  $scope.addSendTo = function () {
    $scope.sendTos.push('');
  };
  $scope.addSendToCc = function () {
    $scope.sendToCcs.push('');
  };
  $scope.deleteSendTo = function (id) {
    $scope.sendTos.splice(id,1);
  };
  $scope.deleteSendToCc = function (id) {
    $scope.sendToCcs.splice(id,1);
  };

  $scope.getEmailList = function (num) {
    CommonService.pagination({
      url : '/emailConfig/findByPage.api',
      method : 'post',
      data : {
        name : $scope.emailName,
        pageNo :num || 1,
        pageSize : 10
      }
    }).then(function (data) {
      $scope.emailList = data.item;
      $scope.page = data.page;
    });
  };
  $scope.getEmailList();

  $scope.detailEmail = function (id) {
    $scope.id = id;
    CommonService.httpRequest({
      url : '/emailConfig/detail.api',
      method : 'get',
      data:{
        id : id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.host = manages.host;
      $scope.name = manages.name;
      $scope.password = manages.password;
      $scope.platForm = manages.platform;
      $scope.emailPort = manages.port;
      $scope.sendFrom = manages.sendFrom;
      $scope.sendTos = manages.sendTo;
      $scope.sendToCcs = manages.sendToCc;
      $scope.username = manages.username;
      $scope.code = manages.code;
    });
  };

  $scope.addEmailList = function () {
    $scope.host = '';
    $scope.name = '';
    $scope.password = '';
    $scope.platForm = '';
    $scope.emailPort = '';
    $scope.sendFrom = '';
    $scope.sendTos = [''];
    $scope.sendToCcs = [''];
    $scope.username = '';
    $scope.code = '';
    $scope.id = '';
  };

  $scope.submitEmail = function () {
    if($scope.host === ''){
      showWarn('主机不能为空');
      return false;
    }
    if($scope.name === ''){
      showWarn('名称不能为空');
      return false;
    }
    if($scope.password === ''){
      showWarn('密码不能为空');
      return false;
    }
    if($scope.platForm === ''){
      showWarn('平台不能为空');
      return false;
    }
    if($scope.emailPort === ''){
      showWarn('端口不能为空');
      return false;
    }
    if($scope.sendFrom === ''){
      showWarn('发送者邮箱不能为空');
      return false;
    }
    for(var i=0;i<$scope.sendTos.length;i++){
      if($scope.sendTos[i] === ''){
        showWarn('收件地址列表不能为空');
        return false;
      }
    }
    for(var j=0;j<$scope.sendToCcs.length;j++){
      if($scope.sendToCcs[j] === ''){
        showWarn('抄送地址列表不能为空');
        return false;
      }
    }
    if($scope.username === ''){
      showWarn('邮箱用户名不能为空');
      return false;
    }
    if($scope.code === ''){
      showWarn('唯一标识码不能为空');
      return false;
    }else{
      if(/^[0-9a-zA-Z_]{1,}$/g.test($scope.code)===false){
        showWarn('唯一标识码必须数字、字母或的组合');
        return false;
      }
    }
    if($scope.id === ''){
      CommonService.httpRequest({
        url : '/emailConfig/add.api',
        method : 'post',
        data : {
          code : $scope.code,
          host : $scope.host,
          name : $scope.name,
          password : $scope.password,
          platform : $scope.platForm,
          port : $scope.emailPort,
          sendFrom : $scope.sendFrom,
          sendTo : $scope.sendTos,
          sendToCc : $scope.sendToCcs,
          username : $scope.username
        }
      }).then(function (data) {
        showInfo('提交成功',function () {
          $scope.host = '';
          $scope.name = '';
          $scope.password = '';
          $scope.platForm = '';
          $scope.emailPort = '';
          $scope.sendFrom = '';
          $scope.sendTos = [''];
          $scope.sendToCcs = [''];
          $scope.username = '';
          $scope.code = '';
          $scope.id = '';
          $scope.getEmailList();
        });
      });
    }else{
      CommonService.httpRequest({
        url : '/emailConfig/update.api',
        method : 'post',
        data : {
          id : $scope.id,
          code : $scope.code,
          host : $scope.host,
          name : $scope.name,
          password : $scope.password,
          platform : $scope.platForm,
          port : $scope.emailPort,
          sendFrom : $scope.sendFrom,
          sendTo : $scope.sendTos,
          sendToCc : $scope.sendToCcs,
          username : $scope.username
        }
      }).then(function (data) {
        showInfo('提交成功',function () {
          $scope.host = '';
          $scope.name = '';
          $scope.password = '';
          $scope.platForm = '';
          $scope.emailPort = '';
          $scope.sendFrom = '';
          $scope.sendTos = [''];
          $scope.sendToCcs = [''];
          $scope.username = '';
          $scope.code = '';
          $scope.id = '';
          $scope.getEmailList();
        });
      });
    }
  };
  $scope.getSfNews = function () {
    CommonService.httpRequest({
      url : '/sysConfig/findByCode.api',
      method : 'get',
      data : {
        code : '1'
      }
    }).then(function (data) {
      $scope.sfNews = data.datas;
    });
  };
  $scope.getInvoiceTime = function () {
    CommonService.httpRequest({
      url : '/sysConfig/findByCode.api',
      method : 'get',
      data : {
        code : '2'
      }
    }).then(function (data) {
      $scope.timeDelay = data.datas;
    });
  };

  $scope.getInvoiceIntro = function () {
    CommonService.httpRequest({
      url : '/sysConfig/findByCode.api',
      method : 'get',
      data : {
        code : '3'
      }
    }).then(function (data) {
      $scope.invoiceIntro = data.datas;
    });
  };

  $scope.getPriceIntro = function () {
    CommonService.httpRequest({
      url : '/sysConfig/findByCode.api',
      method : 'get',
      data : {
        code : '4'
      }
    }).then(function (data) {
      $scope.priceIntro = data.datas;
    });
  };
  // $scope.getSfNews();
  $scope.getInvoiceTime();
  $scope.getInvoiceIntro();
  $scope.getPriceIntro();

  // $scope.submitSfNews = function () {
  //   if($scope.sfNews===''||!$scope.sfNews){
  //     showWarn('报文不能为空');
  //     return false;
  //   }
  //   CommonService.httpRequest({
  //     url : '/sysConfig/updateByCode.api',
  //     method : 'post',
  //     data : {
  //       code : '1',
  //       value : $scope.sfNews
  //     }
  //   }).then(function (data) {
  //     showInfo('提交成功',function () {
  //       $scope.getSfNews();
  //     });
  //   });
  // };

  $scope.submitInvoiceTime = function () {
    if($scope.timeDelay===''||!$scope.timeDelay){
      showWarn('发票时限不能为空');
      return false;
    }
    CommonService.httpRequest({
      url : '/sysConfig/updateByCode.api',
      method : 'post',
      data : {
        code : '2',
        value : $scope.timeDelay
      }
    }).then(function (data) {
      showInfo('提交成功',function () {
        $scope.getInvoiceTime();
      });
    });
  };

  $scope.submitInvoiceIntro = function () {
    if($scope.invoiceIntro===''||!$scope.invoiceIntro){
      showWarn('发票说明不能为空');
      return false;
    }
    CommonService.httpRequest({
      url : '/sysConfig/updateByCode.api',
      method : 'post',
      data : {
        code : '3',
        value : $scope.invoiceIntro
      }
    }).then(function (data) {
      showInfo('提交成功',function () {
        $scope.getInvoiceIntro();
      });
    });
  };

  $scope.submitPriceIntro = function () {
    if($scope.priceIntro===''||!$scope.priceIntro){
      showWarn('保价说明不能为空');
      return false;
    }
    CommonService.httpRequest({
      url : '/sysConfig/updateByCode.api',
      method : 'post',
      data : {
        code : '4',
        value : $scope.priceIntro
      }
    }).then(function (data) {
      showInfo('提交成功',function () {
        $scope.getPriceIntro();
      });
    });
  };


  //Vincent 2017-11-23 Add 微信端首页说明添加
  $scope.fBaseUrl = fBaseUrl;
  $scope.reminder1={};
  $scope.reminder2={};
  $scope.reminder3={};
  $scope.getReminder = function () {
    CommonService.httpRequest({
      url: '/reminder/list.api',
      method: 'get',
    }).then(function (data) {
      if (data&&data.datas) {
        $scope.reminder1 = data.datas.length >= 1 ? data.datas[0] : {};
        $scope.reminder2 = data.datas.length >= 2 ? data.datas[1] : {};
        $scope.reminder3 = data.datas.length >= 3 ? data.datas[2] : {};
      }
    });
  };

  $scope.getReminder();

  //提交说明
  $scope.submitReminder = function () {
    if ($scope.reminder1.name === '' || !$scope.reminder1.name
        || $scope.reminder2.name === '' || !$scope.reminder2.name
        || $scope.reminder3.name === '' || !$scope.reminder3.name) {
      showWarn('名称不能为空');
      return false;
    }
    if ($scope.reminder1.image === '' || !$scope.reminder1.image
        || $scope.reminder2.image === '' || !$scope.reminder2.image
        || $scope.reminder3.image === '' || !$scope.reminder3.image) {
      showWarn('请上传LOGO');
      return false;
    }
    CommonService.httpRequest({
      url: '/reminder/updateAll.api',
      method: 'post',
      data: [$scope.reminder1,$scope.reminder2,$scope.reminder3]
    }).then(function (data) {
      showInfo('提交成功', function () {
        $scope.getInvoiceIntro();
      });
    });
  };


  // 上传图片
  $scope.uploadImg = function($file,idx){
    if($file){
      //var isIntegrate = false;
      if($file.size > (10 * 1024 * 1024)){
        showWarn('上传的图片过大'); return;
      }
      var filetypes = [
        //ie9
        // "jfif", "jpe", "dib",
        //
        'image/png', 'image/jpeg', 'image/jpg'
        // 'image/bmp', "image/jfif", "image/dib", "image/jpe"
      ];
      var i = filetypes.indexOf($file.type);
      if (i < 0){
        showWarn('上传的图片格式不正确'); return;
      };
      Upload.upload({
        url: baseUrl + '/common/imageUpload.api',
        method:'post',
        data:{
          image: $file
        }
      }).progress(function(evt) {//上传进度
        layer.load(1, {
          shade: [0.1,'#fff']
        });
      }).then(function(data, status, headers, config){
        layer.closeAll();
        showInfo("上传成功！");
        if(idx==1){
          $scope.reminder1.image=data.data.datas;
        }else if(idx==2){
          $scope.reminder2.image=data.data.datas;
        }
        else if(idx==3){
          $scope.reminder3.image=data.data.datas;
        }
        //$scope.baseAdvertImageLists[idx].image = data.data.datas;
        if(data.data.message){
          showErr(data.data.message);
        }
      });
    }
  };
}]);