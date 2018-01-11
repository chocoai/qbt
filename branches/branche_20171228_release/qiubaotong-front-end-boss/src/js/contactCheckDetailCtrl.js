"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('contactCheckDetailCtrl',['$scope','CommonService','Upload',function($scope,CommonService,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});

    $scope.fBaseUrl = fBaseUrl;

    $scope.mobiles = CommonService.getQueryString('mobile');
    $scope.isUpdate = false;
    $scope.labelIdList = [];
    $scope.contentList = [];

    $scope.getList = function(){
        CommonService.httpRequest({
            url : '/contact/detail.api',
            method : 'get',
            data : {
                mobile : $scope.mobiles
            }
        }).then(function(data){
            $scope.datas = data.datas;
            if($scope.datas){
                var manages = data.datas;
                $scope.id = manages.id;
                $scope.name = manages.name;
                $scope.mobile = manages.mobile;
                $scope.isDelete = manages.isDelete;
                $scope.getMobileOrder();
                $scope.isMobile = !!(/^1[3|4|5|7|8]\d{9}$/.test(manages.mobile));
                CommonService.httpRequest({
                    url : '/baseLabel/listContentByMobile.api',
                    method : 'get',
                    data :{
                        userId : $scope.id,
                        userType : 2
                    }
                }).then(function(data){
                    $scope.contentList = data.datas;
                });
                CommonService.httpRequest({
                    url : '/baseLabel/listByMobile.api',
                    method : 'get',
                    data :{
                        userId : $scope.id,
                        userType : 2
                    }
                }).then(function(data){
                    $scope.labelIdList = data.datas;
                });
            }
            else{
                layer.confirm('该客户信息不存在，是否前往新增客户信息？', {
                      btn: ['前往'],
                      closeBtn: 0,
                      title : '提示'
                  }, function(){
                      tabOpenParent({name:'contactCheckDetail_add',url:'contactCheckDetail.html',displayName:'新增客户信息'});
                  });
            }
        });
    };
    $scope.getMobileOrder = function(num){
        CommonService.pagination({
            url : '/order/findByPage.api',
            meth : 'post',
            data :{
                pageNo : num || "1",
                concactMobile : $scope.mobiles
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    };

    
    $scope.addContact= function(){

        if(!$scope.name){
            showWarn("姓名不能为空");
            return false;
        }
        if(!$scope.mobile){
            showWarn("联系电话不能为空");
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
        
        if(!$scope.mobiles){
             CommonService.httpRequest({
                url : '/contact/add.api',
                method : 'post',
                data :{
                    name : $scope.name,
                    mobile:$scope.mobile,
                    isDelete:false
                }
            }).then(function(data){
                if($scope.labelIdList.length != 0){
                    CommonService.httpRequest({
                      url : '/baseLabel/addUserLabel.api',
                      method : 'post',
                      data:{
                            labelIdList : $scope.labelIdList,
                            contentList:$scope.contentList,
                            userId : data.datas,
                            userType : 2
                        }
                      }).then(function(data){
                        showInfo("新增并添加个性化标签成功",function(){
                            tabOpenParent({name:'contactCheck',url:'contactCheck.html',displayName:'客户信息查询'});
                        });
                    });
                }
                else{
                    showInfo("新增成功",function(){
                        tabOpenParent({name:'contactCheck',url:'contactCheck.html',displayName:'客户信息查询'});
                    });     
                }
            });
        }
        else{
            CommonService.httpRequest({
                url : '/contact/update.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name : $scope.name,
                    mobile:$scope.mobile
                }
            }).then(function(data){
                CommonService.httpRequest({
                  url : '/baseLabel/addUserLabel.api',
                  method : 'post',
                  data:{
                    labelIdList : $scope.labelIdList,
                    contentList : $scope.contentList,
                    userId : $scope.id,
                    userType : 2
                    }
                }).then(function(data){
                    showInfo("更新成功",function(){
                        $scope.getList();
                    });
                });
            });
            localStorage.removeItem('manages');
           
        }
    	
    }

    $scope.toSendMsg = function(mobile){
        tabOpenParent({
            name:'sendMsg',
            url:'sendMsg.html?mobile='+mobile,
            displayName:'短信发送'
        });
    };
    $scope.getStyleLabel = function(){
        CommonService.httpRequest({
          url : '/baseLabel/list.api',
          method : 'get'
          }).then(function(data){
            $scope.labels = data.datas;
        });
    };

    //标签
    $scope.isSelected = function(id){
        return $scope.labelIdList.indexOf(id) >= 0;
    }

    $scope.isClick = function(id){
        if($scope.labelIdList.indexOf(id) == -1){
            $scope.labelIdList.push(id);
        }
        else{
            var idx = $scope.labelIdList.indexOf(id);
            $scope.labelIdList.splice(idx,1);
        }
    };

    //新增自定义标签
    $scope.addSelfLabel = function(){
        if(!$scope.selfLabel && $scope.selfLabel !== 0){
            showWarn('标签不能为空');
            return false;
        }
        else{
            for(var i = 0; i < $scope.contentList.length; i++){
                if($scope.contentList[i] == $scope.selfLabel){
                    showWarn("该标签已存在");
                    return false;
                }
            }
            $scope.contentList.push($scope.selfLabel);
            for(var j = 0;j < $scope.contentList.length; j++){
                if($scope.contentList[j].indexOf('|')!==-1 || $scope.contentList[j].indexOf('｜')!==-1){
                    $scope.contentList[j]= $scope.contentList[j].replace(/(｜|\|)/g,'\n');
                }
            }
            $scope.selfLabel = '';  
        }
    };
    //删除自定义标签
    $scope.deleteSelfLabel = function(selfLabel){
        var selfLabelIndex = $scope.contentList.indexOf(selfLabel);
        $scope.contentList.splice(selfLabelIndex,1);
    }


    $scope.detail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };
    $scope.courseDetail = function(id,type){
        tabOpenParent({
            name:'addCourse_update'+id,
            url:'addCourse.html?id='+id+'&orderToCourse=1'+'&addrType='+type,
            displayName:'球场详情'+id
        });
    };

    $scope.isWeixin = function(mobile,id){
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
    };
    $scope.userDetail = function(id){
        tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:'用户详情查询'+id});
    };

    if($scope.mobiles){
        $scope.getList();
    }
    $scope.getStyleLabel();

}]);
