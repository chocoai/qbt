"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('vipInfoDetailCtrl',['$scope','$timeout','CommonService','Upload',function($scope,$timeout,CommonService,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.fBaseUrl = fBaseUrl;
    $scope.id = CommonService.getQueryString('id') || '';
    $scope.bagList = [];
    $scope.isBagSelect = false;
    $scope.isSelectDelete = '删除';
    $scope.noWechatBagShow = true;

    $scope.getList = function(){
    	CommonService.httpRequest({
    		method : 'get',
    		url : '/vipInfo/detail.api',
    		data:{
    			id : $scope.id
    		}
    	}).then(function(data){
            $scope.vipInfoMsg = data.datas;
            $scope.getBagList($scope.vipInfoMsg.userId || '');
    	});
    }

    $scope.modifyUser = function(id){
        $scope.userName = $scope.vipInfoMsg.userName;
        layer.open({
            type: 1,
            title:'修改会员用户名',
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', '240px'], //宽高
            content : $('#modifyUser'),
            btn:['确定','取消'],
            yes: function(index, layero){
                if(!$scope.userName){
                    showWarn('会员用户名不能为空');
                    return false;
                }
                else if($scope.userName.length == 1){
                    showWarn('需填写真实姓名');
                    return false;
                }
                else if($scope.userName.indexOf('先生') != -1 || $scope.userName.indexOf('女士') != -1){
                    showWarn('需填写真实姓名');
                    return false;
                }
                CommonService.httpRequest({
                    url: '/vipInfo/modify.api',
                    method : 'post',
                    data: {
                        id: id,
                        userName: $scope.userName,
                    }
                }).then(function(){
                    showInfo('更新成功',function(){
                        $scope.getList(1);
                        layer.close(index);
                    });
                })
            }
        });
    }
     $scope.getWecat = function(num){
        CommonService.pagination({
            url : '/userWeixin/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.selectWecatName
            }
        }).then(function(data){
            $scope.wecats = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.selectWecat = function(item){
        $scope.getWecat();
        layer.open({    
              type :1,
              title:'请选择微信用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['480px', '535px'], //宽高
              content: $('#memo'),
              end: function(){
                $scope.selectWecatName = '';
              }
            });
    }
    $scope.selectedWecat = function(wecat){
        layer.confirm('确定绑定（' + wecat.nickname + '）为（' + $scope.vipInfoMsg.userName + '）的微信号？<br>确定后将无法修改！',{
            title : '微信用户绑定',
            btn:['确定','取消']
        },function(index){
             CommonService.httpRequest ({
                url: '/vipInfo/updateUserWeixin.api',
                method :'get',
                data: {
                    id: $scope.id,
                    userId: wecat.id,
                    }
                }).then(function(data){
                    showInfo('绑定成功',function(){
                        layer.closeAll(); 
                        $scope.getList();
                    });
                });
        },function(index){
            layer.close(index); 
        });
    };
    $scope.modifyPh = function(id){
        $scope.mobile = $scope.vipInfoMsg.mobile;
        layer.open({
            type: 1,
            title: '修改会员手机号',
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', '240px'], //宽高
            content : $('#modifyPhone'),
            btn:['确定','取消'],
            yes: function(index, layero){
                if(!$scope.mobile){
                    showInfo('会员手机号不能为空');
                    return;
                }
                if(!(/^1[3|4|5|7|8]\d{9}$/.test($scope.mobile))){
                    showWarn('会员手机号格式错误')
                    return;
                }
                CommonService.httpRequest ({
                    url: '/vipInfo/modify.api',
                    method : 'post',
                    data: {
                        id: id,
                        mobile: $scope.mobile,
                    }
                }).then(function(data){
                    showInfo('更新成功',function(){
                        $scope.getList(1);
                        layer.close(index);
                    });
                   })
            }
        })
    }

    //球包图片列表
    $scope.getBagList = function(id){
        CommonService.httpRequest({
            url: '/userImage/list.api',
            method: 'get',
            data:{
                userId:id
            }
        }).then(function(data){
            $scope._bagList = data.datas;
        });
    }
    $scope.addBag = function(id,pic){
        if(!$scope.vipInfoMsg.nickname){
            CommonService.httpRequest({
                url: '/vipInfo/updateAppointImage.api',
                method: 'post',
                data:{
                    id:$scope.id,
                    imageUrl : pic,
                    userImageId:0
                }
            }).then(function(data){
                showInfo('上传成功！',function(){
                    $scope.getList();
                });
            });
        }
        else{
            CommonService.httpRequest({
                url: '/userImage/add.api',
                method: 'post',
                data:{
                    imageUrl:pic,
                    userId:id
                }
            }).then(function(data){
                showInfo("上传成功！",function(){
                    if(!$scope.vipInfoMsg.userImageUrl){
                        CommonService.httpRequest({
                            url: '/vipInfo/updateAppointImage.api',
                            method: 'post',
                            data:{
                                id:$scope.id,
                                imageUrl : pic,
                                userImageId:data.datas
                            }
                        }).then(function(data){
                            $scope.getList();
                        });
                    }
                    $scope.getBagList(id);
                });
            });
        }
    }

    //球包照片
    $scope.uploadImg = function($file){
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
                $scope.addBag($scope.vipInfoMsg.userId,data.data.datas);
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

    $scope.selectToDelete = function(){
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
            if(!$scope.vipInfoMsg.nickname){
            }
            else{
                var deleteMsg = '确认删除吗';
                layer.confirm(deleteMsg, {icon: 3, title:'提示'}, function(index){
                    CommonService.httpRequest({
                        url: '/userImage/delete.api',
                        method: 'get',
                        data:{
                            ids : $scope.bagList
                        }
                    }).then(function(){
                        showInfo('删除成功',function(){
                            $scope.bagList = [];
                            $scope.isBagSelect = !$scope.isBagSelect;
                            $scope.isSelectDelete = '删除';
                            $scope.getBagList($scope.vipInfoMsg.userId);
                            $scope.getList();
                            layer.closeAll();
                        });
                    });
                    
                },function(index){
                    layer.close(index);
                });   
            }
        }
    };

    $scope.selectBag = function(val,index){
        if(!$scope.vipInfoMsg.nickname){
            var colorStyle = $('#noWechat').css('color');
            if(colorStyle == '#333'){
                $('#noWechat').css('color','#333');
                $scope.isSelectDelete = '取消';
            }
            else{
                $('#noWechat').css('color','#fff');
                $scope.isSelectDelete = '确认删除';
            }
        }
        else{
            var idx = $scope.bagList.indexOf(val);
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
            
        }

    }

    $scope.updateBag = function(){

        if(!$scope.vipInfoMsg.nickname){
            layer.confirm('确认设置该照片为指定球包吗?', {icon: 3, title:'提示'}, function(index){
                showInfo('设置成功',function(){
                    layer.closeAll();
                });
            },function(index){
                layer.close(index);
            });
        }
        else{
            layer.confirm('确认设置该照片为指定球包吗?', {icon: 3, title:'提示'}, function(index){
                CommonService.httpRequest({
                    url: '/vipInfo/updateAppointImage.api',
                    method: 'post',
                    data:{
                        id:$scope.id,
                        userImageId : $scope.setBag.id
                    }
                }).then(function(data){
                    showInfo('设置成功',function(){
                        layer.closeAll();
                        $scope.getList();
                    });
                });
                
            },function(index){
                layer.close(index);
            });  
        }

    };

    $scope.imgShow = function(src){
        if($scope.vipInfoMsg.nickname){
            $scope.imgToBig = fBaseUrl + src.imageUrl;
            $scope.setBag = src;
        }
        else{
            $scope.imgToBig = fBaseUrl + src;
        }
        $timeout(function () {
          layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            area: '50%',
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


    if($scope.id){
        $scope.getList();
    }

}]);
