"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('userCheckDetailCtrl',['$scope','$timeout','CommonService','Constants','Upload',function($scope,$timeout,CommonService,Constants,Upload){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true,
        endDate:new Date().Format('yyyy-MM-dd')
    });
    $scope.fBaseUrl = fBaseUrl;

    var id = CommonService.getQueryString("id");
    var orderStatus= CommonService.getQueryString('orderStatus');
    $scope.labelIdList = [];
    $scope.contentList = [];

    $scope.bagList = [];
    $scope.isBagSelect = false;
    $scope.isSelectDelete = '删除';
    $scope.IsSelectDelete = '删除';

    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/order/findByPage.api',
        	meth : 'post',
        	data :{
        		pageNo : num || "1",
                userId : id,
                orderStatus:orderStatus
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
            $scope.getUserAddr();
            $scope.getWeixinDetail();
            $scope.getBagList(id);
            $scope.getPerList(id);
            $scope.getAddrCount();
            $scope.getRouteCount();
           console.log($('.selfLabel').css('position'))
        });
    };

    //常用地址
    $scope.getUserAddr = function(num){
        CommonService.pagination({
            url : '/userAddress/findByPage.api',
            data :{
                userId : id,
                pageNo : num || 1
            }
        }).then(function(data){
            $scope.userAddrList = data.item;
        	  $scope.page1 = data.page;
        });
    };

    //地址统计
    $scope.getAddrCount = function(num){
        if($scope.addrStartOrderTime && $scope.addrEndOrderTime){
            if($scope.addrStartOrderTime > $scope.addrEndOrderTime){
                showWarn('统计开始日期不能大于统计结束日期');
                return;
            }
        }
        CommonService.pagination({
            url: '/orderAddressType/findByPage.api',
            data: {
                pageNo : num || 1,
                contact : $scope.addrContact,
                endOrderTime : $scope.addrEndOrderTime,
                mobile : $scope.addrMobile,
                sort : $scope.addrSort,
                startOrderTime : $scope.addrStartOrderTime,
                type : $scope.addrType,
                addrType:$scope.addrAddrType,
                userId : id
            }
        }).then(function(data){
            $scope.addresses = data.item;
            $scope.pageAddrCount = data.page;
        });
    };

    //路线统计
    $scope.getRouteCount = function(num){
        if($scope.routerStartOrderTime && $scope.routerEndOrderTime){
            if($scope.routerStartOrderTime > $scope.routerEndOrderTime){
                showWarn('统计开始日期不能大于统计结束日期');
                return;
            }
        }
        CommonService.pagination({
            url: '/orderAddressRoute/findByPage.api',
            data: {
                pageNo : num || 1,
                contact : $scope.routerContact,
                startOrderTime : $scope.routerStartOrderTime,
                endOrderTime : $scope.routerEndOrderTime,
                mobile : $scope.routerMobile,
                userId : id
            }
        }).then(function(data){
            $scope.routes = data.item;
            $scope.pageRouteCount = data.page;
        });
    };

    $scope.getWeixinDetail = function(){
        CommonService.httpRequest({
          url : '/userWeixin/findById.api',
          method : 'get',
          data :{
              id : id
          }
      }).then(function(data){
        $scope.weixin = data.datas;
        if($scope.weixin.id){
            CommonService.httpRequest({
                url : '/baseLabel/listContentByMobile.api',
                method : 'get',
                data :{
                    userId : $scope.weixin.id,
                    userType : 1
                }
            }).then(function(data){
                $scope.contentList = data.datas;
            });
            CommonService.httpRequest({
                url : '/baseLabel/listByMobile.api',
                method : 'get',
                data :{
                    userId : $scope.weixin.id,
                    userType : 1
                }
            }).then(function(data){
                $scope.labelIdList = data.datas;
            }); 
        }
    });
  };

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

    $scope.toSendMsg = function(mobile){
      tabOpenParent({
            name:'sendMsg',
            url:'sendMsg.html?mobile='+mobile,
            displayName:'短信发送'
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

    $scope.getStyleLabel = function(){
        CommonService.httpRequest({
          url : '/baseLabel/list.api',
          method : 'get'
          }).then(function(data){
            $scope.labels = data.datas;
        });
    };
    $scope.addStyleLabel = function(){
        CommonService.httpRequest({
          url : '/baseLabel/addUserLabel.api',
          method : 'post',
          data:{
                labelIdList : $scope.labelIdList,
                contentList:$scope.contentList,
                userType : 1,
                userId : id,
                mobile:$scope.weixin.mobile || ''
            }
          }).then(function(data){
            showInfo("更新成功",function(){
                $scope.getStyleLabel();
                $scope.getList();
            }); 
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
    }
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

    //用户球包
    $scope.getBagList = function(id){
        CommonService.httpRequest({
            url: '/userImage/list.api',
            method: 'get',
            data:{
                userId:id,
                type:1
            }
        }).then(function(data){
            $scope._bagList = data.datas;
        });
    };
    $scope.getPerList = function (id) {
      CommonService.httpRequest({
        url: '/userImage/list.api',
        method: 'get',
        data:{
          userId:id,
          type:2
        }
      }).then(function(data){
        $scope._perList = data.datas;
      });
    }
    $scope.addBag = function(id,pic,num){
        CommonService.httpRequest({
            url: '/userImage/add.api',
            method: 'post',
            data:{
                imageUrl:pic,
                userId:id,
                type:num
            }
        }).then(function(data){
            showInfo("上传成功！",function(){
              if(num===1){
                $scope.getBagList(id);
              }else{
                $scope.getPerList(id)
              }
            });
        });
    }


    $scope.getStyleLabel();
    $scope.getList();

    //球包照片
    $scope.uploadImg = function($file,val){
        $scope.num = val;
        if($file){
            var isIntegrate = false;
            if($file.size > (2 * 1024 * 1024)){
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
            if(val===1){
              Upload.upload({
                url: baseUrl + '/common/imageUpload.api',
                method:'post',
                data:{
                  image: $file,
                }
              }).progress(function(evt) {//上传进度
                layer.load(1, {
                  shade: [0.1,'#fff']
                });
              }).then(function(data, status, headers, config){
                layer.closeAll();
                $scope.addBag(id,data.data.datas,val);
                if(data.data.message){
                  showErr(data.data.message);
                }
              })
            }else{
              Upload.upload({
                url: baseUrl + '/common/imageUpload.api',
                method:'post',
                data:{
                  image: $file,
                }
              }).progress(function(evt) {//上传进度
                layer.load(1, {
                  shade: [0.1,'#fff']
                });
              }).then(function(data, status, headers, config){
                layer.closeAll();
                $scope.addBag(id,data.data.datas,2);
                if(data.data.message){
                  showErr(data.data.message);
                }
              })
            }
        }
    };

    $scope.selectToDelete = function(val){
      if(val===1){
        if($scope.isSelectDelete != '确认删除'){
          if(!$scope.isBagSelect){
            $scope.isSelectDelete = '取消';
          }
          else{
            $scope.isSelectDelete = '删除';
          }
          $scope.isBagSelect = !$scope.isBagSelect;
        }
        else{
          layer.confirm('确认删除吗?', {icon: 3, title:'提示'}, function(index){
            CommonService.httpRequest({
              url: '/userImage/delete.api',
              method: 'get',
              data:{
                ids : $scope.bagList,
                type: 1
              }
            }).then(function(){
              showInfo('删除成功',function(){
                $scope.bagList = [];
                $scope.isBagSelect = !$scope.isBagSelect;
                $scope.isSelectDelete = '删除';
                $scope.getBagList(id);
                $scope.getPerList(id)
              });
            });
            layer.close(index);
          },function(index){
            layer.close(index);
          });
        }
      }else{
        if($scope.IsSelectDelete != '确认删除'){
          if(!$scope.IsBagSelect){
            $scope.IsSelectDelete = '取消';
          }
          else{
            $scope.IsSelectDelete = '删除';
          }
          $scope.IsBagSelect = !$scope.IsBagSelect;
        }
        else{
          layer.confirm('确认删除吗?', {icon: 3, title:'提示'}, function(index){
            CommonService.httpRequest({
              url: '/userImage/delete.api',
              method: 'get',
              data:{
                ids : $scope.bagList,
                type: 2
              }
            }).then(function(){
              showInfo('删除成功',function(){
                $scope.bagList = [];
                $scope.IsBagSelect = !$scope.IsBagSelect;
                $scope.IsSelectDelete = '删除';
                $scope.getBagList(id);
                $scope.getPerList(id)
              });
            });
            layer.close(index);
          },function(index){
            layer.close(index);
          });
        }
      }

    };

    $scope.selectBag = function(val,index,num){
      var idx = $scope.bagList.indexOf(val);
      if(num===1){
        var bagCol = $('.bagCol:eq('+index+') i');
        if(idx == -1){
          $scope.bagList.push(val);
          bagCol.css('color','#fff');
        }
        else{
          $scope.bagList.splice(idx,1);
          bagCol.css('color','#333');
        }
        if($scope.bagList.length > 0){
          $scope.isSelectDelete = '确认删除';
        }
        else{
          $scope.isSelectDelete = '取消';
        }
      }else{
        var bagCol = $('.BagCol:eq('+index+') i');
        if(idx == -1){
          $scope.bagList.push(val);
          bagCol.css('color','#fff');
        }
        else{
          $scope.bagList.splice(idx,1);
          bagCol.css('color','#333');
        }
        if($scope.bagList.length > 0){
          $scope.IsSelectDelete = '确认删除';
        }
        else{
          $scope.IsSelectDelete = '取消';
        }
      }


    }

    $scope.imgShow = function(src,val){
        $scope.imgToBig = src;
        $timeout(function () {
                layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                area: '45%',
                shadeClose: true,
                closeBtn:true,
                content: $('#picShow')
            });
        },10)
    };
    $scope.picRotate = function(){
        var picShow = document.getElementById('picShow').parentNode.parentNode;
        picShow.style.animation = 'none';
        var picShowRotate = parseInt(picShow.style.transform.replace('rotate(','').replace('deg)',''));
        if(!picShowRotate){
            picShow.style.transform = 'rotate(90deg)';
        }
        else{
            picShowRotate = picShowRotate + 90;
            if(picShowRotate == 360){
                picShowRotate = 0;
            }
            picShow.style.transform = 'rotate(' + picShowRotate + 'deg)';
        }
    };


}]);
