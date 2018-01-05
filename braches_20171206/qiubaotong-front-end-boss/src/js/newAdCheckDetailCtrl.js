/**
 * Created by Administrator on 2017/10/10.
 */
angular.module("app.views",['ngFileUpload'])
.controller('newAdCheckDetailCtrl',['$scope','CommonService','Upload',function ($scope,CommonService,Upload) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.baseAdvertImageLists = [{'image':'','number':1,'url':'http://'}];
  $scope.fBaseUrl = fBaseUrl;
  $scope.temp = {
    'image' :'',
    'url':''
  }; // 中间数 保存交换位置值
  var id = localStorage.getItem('advertId');
  $scope.getList = function(id){
    CommonService.httpRequest({
      url : '/baseAdvert/findById.api',
      method : 'get',
      data : {
        id : id
      }
    }).then(function(data){
      var manages = data.datas;
      $scope.id = manages.id;
      $scope.name = manages.name;
      $scope.local = manages.advertDescribe;
      manages.baseAdvertImageList===null?$scope.baseAdvertImageLists:$scope.baseAdvertImageLists = manages.baseAdvertImageList;
      $scope.type = manages.flatType + '';
      $scope.showType = manages.openType + '';
      $scope.remark = manages.remark;
    });
  };
  $scope.getList(id);
  // 新增图片编辑上传框
  $scope.addImg = function () {
      if($scope.baseAdvertImageLists.length<6){
        $scope.baseAdvertImageLists.push({'image':'','number':$scope.baseAdvertImageLists.length+1,'url':'http://'});
      }else{
        showWarn('最多6个广告位');
        return false;
      }
  };
  // 删除图片编辑框
  $scope.deleteImg = function (idx) {
    $scope.baseAdvertImageLists.splice(idx,1);
  };
  // 交换数组元素
  // var swapItems = function(arr, index1, index2) {
  //   arr[index1] = arr.splice(index2, 1, arr[index1])[0];
  //   return arr;
  // };
  // 位置下降
  $scope.downImg = function (idx) {
    if(idx === $scope.baseAdvertImageLists.length -1) {
      return;
    }
    $scope.temp.image =$scope.baseAdvertImageLists[idx+1].image;
    $scope.temp.url = $scope.baseAdvertImageLists[idx+1].url ;
    $scope.baseAdvertImageLists[idx + 1].image = $scope.baseAdvertImageLists[idx].image;
    $scope.baseAdvertImageLists[idx + 1].url = $scope.baseAdvertImageLists[idx].url;
    $scope.baseAdvertImageLists[idx].url = $scope.temp.url;
    $scope.baseAdvertImageLists[idx].image = $scope.temp.image;

    // swapItems($scope.baseAdvertImageLists, idx, idx + 1);
    // $scope.baseAdvertImageLists[idx] = $scope.temp;
    // $scope.baseAdvertImageLists[idx] = $scope.baseAdvertImageLists[idx + 1];
    // $scope.baseAdvertImageLists[idx + 1] = $scope.temp;
  };
  // 位置上移
  $scope.upImg = function (idx) {
    if(idx === 0) {
      return;
    }
    $scope.temp.image = $scope.baseAdvertImageLists[idx - 1].image;
    $scope.temp.url = $scope.baseAdvertImageLists[idx - 1].url
    $scope.baseAdvertImageLists[idx - 1].image = $scope.baseAdvertImageLists[idx].image;
    $scope.baseAdvertImageLists[idx - 1].url = $scope.baseAdvertImageLists[idx].url;
    $scope.baseAdvertImageLists[idx].url = $scope.temp.url;
    $scope.baseAdvertImageLists[idx].image = $scope.temp.image;
    // if(idx!==6){
    //   $scope.baseAdvertImageLists[idx+1].number=idx
    // }
    // for(var i=0;i<$scope.baseAdvertImageLists.length;i++){
    //   if(i>=idx){
    //     $scope.baseAdvertImageLists[i].number = i;
    //   }
    // }
    // swapItems($scope.baseAdvertImageLists, idx, idx-1);
    // $scope.baseAdvertImageLists[idx] = $scope.temp;
    // $scope.baseAdvertImageLists[idx] = $scope.baseAdvertImageLists[idx - 1];
    // $scope.baseAdvertImageLists[idx - 1] = $scope.temp;
    console.log($scope.baseAdvertImageLists[idx].number);
  };

  // 上传图片
  $scope.uploadImg = function($file,idx){
    if($file){
      var isIntegrate = false;
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
        $scope.baseAdvertImageLists[idx].image = data.data.datas;
        if(data.data.message){
          showErr(data.data.message);
        }
      });
    }
  };
  // 提交修改
  $scope.submitData = function () {
    if($scope.name===''){
      showWarn('广告位名称不能为空');
      return false;
    }
    if($scope.local===''){
      showWarn('位置不能为空');
      return false;
    }
    for(var i=0;i<$scope.baseAdvertImageLists.length;i++){
      if($scope.baseAdvertImageLists[i].image===''){
        showWarn('图片不能为空');
        return false;
      }
    }
    CommonService.httpRequest({
      url : '/baseAdvert/update.api',
      method : 'post',
      data : {
        id : parseInt(id),
        baseAdvertImageList : $scope.baseAdvertImageLists,
        advertDescribe : $scope.local,
        name : $scope.name,
        openType : $scope.showType?parseInt($scope.showType):'',
        remark : $scope.remark
      }
    }).then(function (data) {
      showInfo('更新成功',function () {
        tabOpenParent({name:'newAdCheck',url:'newAdCheck.html',displayName:'广告位查询'});
      });
    });
  };
}]);