"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('saleManManageDetailCtrl',['$scope','$timeout','CommonService','Constants','Upload',function($scope,$timeout,CommonService,Constants,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.saleMethod = Constants.sale_method;
    $scope.isEdit = false;
    $scope.editValue = '编辑';
    $scope.fBaseUrl = fBaseUrl;
    $scope.detail = {
        id:CommonService.getQueryString('id')
    };
    $scope.detailUpdate = {};
    $scope.selectData = {};
    $scope.selectSettleMethod = Constants.vipCard_active_type;
    $scope.newGetData = {};
    $scope.orderGetData = {};
    $scope.awardName = '';
    $scope.detailUpdate.firstType = '1';
    $scope.detailUpdate.type = '1';
    //获取销售人员基本信息
    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url:'/saleUser/detail.api',
            method:'get',
            data:{
                id : id
            }
        }).then(function(data){
            if(data.datas){
                $scope.detail = data.datas;
                detail.activityName!== '' && ($scope.awardName = $scope.detail.activityId+'|'+$scope.detail.activityName+'|'+$scope.detail.couponLimitDay)
                $scope.detailUpdate = angular.copy($scope.detail);
                $scope.getWechatName($scope.detail.userId);
            }
        });
    };
    //获取微信用户信息
    $scope.getWechatName = function(id){
        CommonService.httpRequest({
            url : '/userWeixin/findById.api',
                method : 'get',
                data :{
                    id : id
                }
        }).then(function(data){
            $scope.detail.wechatName = data.datas.nickname;
        });
    };

    //业绩详情
    //代下单提成详情列表
    $scope.getOrderGet = function(num){
        CommonService.pagination({
            url:'/saleOrderInfo/findByPageBySaleId.api',
            data:{
                pageNo : num || "1",
                pageSize : 30,
                startDate : $scope.startDate,
                endDate : $scope.endDate,
                saleId : $scope.detail.id
            }
        }).then(function(data){
            $scope.orderGetList = data.item;
            $scope.pageOrderGet = data.page;
            $scope._orderGetCount($scope.detail.id);
        });
    };
    //代下单提成临时计算
    $scope._orderGetCount = function(id){
        CommonService.httpRequest({
            url:'/saleUser/order/settleInfo.api',
            method:'post',
            data:{
                startDate : $scope.startDate,
                endDate : $scope.endDate,
                saleId : id
            }
        }).then(function(data){
            $scope.orderGetData = data.datas;
        });
    };
    //结算代下单提成
    $scope.orderGetCount = function(id){
        CommonService.httpRequest({
            url:'/saleUser/order/settle.api',
            method:'post',
            data:{
                startDate : $scope.startDate,
                endDate : $scope.endDate,
                settleMethod : $scope.selectType,
                saleId : id,
                remark : $scope.selectRemark,
            }
        }).then(function(data){
            showInfo('代下单结算成功',function(){
                $scope.getOrderGet();
            });
        });
    };

    //新拉关注奖金详情列表
    $scope.getNewGet = function(num){
        CommonService.pagination({
            url:'/saleWeixinSubcripbeInfo/findByPageBySaleId.api',
            data:{
                pageNo : num || "1",
                pageSize : 30,
                startDate : $scope.startDate1,
                endDate : $scope.endDate1,
                saleId : $scope.detail.id
            }
        }).then(function(data){
            $scope.newGetList = data.item;
            $scope.pageNewGet = data.page;
            $scope._newGetCount($scope.detail.id);
        });
    };
    //结算新拉关注奖金临时计算
    $scope._newGetCount = function(id){
        CommonService.httpRequest({
            url:'/saleUser/subcripbe/settleInfo.api',
            method:'post',
            data:{
                startDate : $scope.startDate1,
                endDate : $scope.endDate1,
                saleId : id
            }
        }).then(function(data){
            $scope.newGetData = data.datas;
        });
    };
    //结算新拉关注奖金
    $scope.newGetCount = function(id){
        CommonService.httpRequest({
            url:'/saleUser/subcripbe/settle.api',
            method:'post',
            data:{
                startDate : $scope.startDate1,
                endDate : $scope.endDate1,
                settleMethod : $scope.selectType,
                saleId : id,
                remark : $scope.selectRemark,
            }
        }).then(function(data){
            showInfo('新拉关注奖金结算成功',function(){
                $scope.getNewGet();
            });
        });
    };

    $scope.beforeOrderGetCount = function(orderGetData,type){
        if(orderGetData.settleNumber){
            $scope.selectData = orderGetData;
            layer.open({
                type: 1,
                title : '结单确认',
                area: ['350px', 'auto'],
                content: $('#selectSettle'),
                btn: ['确认', '取消'],
                zIndex : 1000,
                yes: function(index){
                    if(!$scope.selectType){
                        showWarn('请选择结算方式');
                    }
                    else{
                        if(type == 1){
                            $scope.orderGetCount($scope.detail.id);
                        }
                        else{
                            $scope.newGetCount($scope.detail.id);
                        }
                        layer.close(index);
                    }
                },
                end:function(index){
                    $scope.selectType = '';
                    $scope.selectRemark = '';
                }
            });
        }
    };

    $scope.changeDate = function(type){
        if($scope.startDate && $scope.endDate && ($scope.startDate > $scope.endDate)){
            showWarn('统计开始日期不能大于统计截至日期',function(){
                $scope.orderGetList = [];
                $scope.pageOrderGet = null;
                $scope.orderGetData.settleNumber = '';
                if(type == 1){
                    $scope.startDate = '';
                }
                else{
                    $scope.endDate = '';
                }
                $scope.$apply();
            });
            return;
        }
        else{
            $scope.getOrderGet();
        }

    };

    $scope.changeDate1 = function(type){
        if($scope.startDate1 && $scope.endDate1 && ($scope.startDate1 > $scope.endDate1)){
            showWarn('统计开始日期不能大于统计截至日期',function(){
                $scope.newGetList = [];
                $scope.pageNewGet = null;
                $scope.newGetData.settleNumber = '';
                if(type == 1){
                    $scope.startDate1 = '';
                }
                else{
                    $scope.endDate1 = '';
                }
                $scope.$apply();
            });
            return;
        }
        else{
            $scope.getNewGet();
        }

    };

    if($scope.detail.id){
        $scope.getDetail($scope.detail.id);
    }


    $scope.toEdit = function(){
        $scope.isEdit = !$scope.isEdit;
        if($scope.isEdit){
            $scope.editValue = '取消';
            $scope.detailUpdate = angular.copy($scope.detail);
            $scope.detailUpdate.type += '';
            if($scope.detailUpdate.firstType){
                $scope.detailUpdate.firstType += '';
            }
            // if($scope.detailUpdate.orderDayType){
            //     $scope.detailUpdate.orderDayType += '';
            // }
          $scope.getAward()
        }
        else{
            $scope.editValue = '编辑';
        }
    }
    // 奖品
    $scope.getAward = function () {
      CommonService.httpRequest({
        url:'/rewardActitvity/findCurrentCoupon.api',
        method:'get',
        data:{
            type:2
        }
      }).then(function (data) {
        $scope.awardList = data.datas;
      })
    }

    //提交更新
    $scope.updateData = function(){

        if(!$scope.detailUpdate.name){
            showWarn('姓名不能为空');
            return;
        }
        else if($scope.detailUpdate.name.length < 2){
            showWarn('姓名长度为2~10');
            return;
        }
        if($scope.detailUpdate.company){
            if($scope.detailUpdate.company.length < 2){
                showWarn('工作单位长度为2~15');
                return;
            }
        }
        if(!$scope.detailUpdate.mobile){
            showWarn('手机号不能为空');
            return;
        }
        else if(!(/^1[3|4|5|7|8]\d{9}$/.test($scope.detailUpdate.mobile))){
            showWarn('手机号格式错误');
            return;
        }
        if($scope.detailUpdate.idcard && $scope.detailUpdate.idcard.length < 5){
            showWarn('身份证号长度为5~18');
            return;
        }
        if($scope.detailUpdate.email){
            if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($scope.detailUpdate.email))){
                showWarn('邮箱格式错误');
                return;
            }
        }
        if($scope.detailUpdate.type){
            if($scope.detailUpdate.type == 1){
                if($scope.checkDoubleNumber($scope.detailUpdate.typeValue,'0.0~1000.0',1000,1,'每单提成金额')){
                        return;
                }
            }
            // else if($scope.detailUpdate.type == 2){
            //     if($scope.checkDoubleNumber($scope.detailUpdate.typeValue,'0.0~100.0',100,1,'每单提成金额')){
            //         return;
            //     }
            // }
        }
        // if($scope.checkDoubleNumber($scope.detailUpdate.subscribeValue,'0.0~100.0',100,1,'关注奖金')){
        //     return;
        // }
        if(!$scope.detailUpdate.firstType){
            showWarn('请选择首单提成方式');
            return;
        }
        else{
            if($scope.detailUpdate.firstType == 1){
                if($scope.checkDoubleNumber($scope.detailUpdate.firstTypeValue,'0.0~1000.0',1000,1,'每单提成金额')){
                    return;
                }
            }
            // else if($scope.detailUpdate.firstType == 2){
            //     if($scope.checkDoubleNumber($scope.detailUpdate.firstTypeValue,'0.0~100.0',100,1,'每单提成金额')){
            //         return;
            //     }
            // }
        }
        if($scope.awardName ===''|| $scope.awardName==='0||0'){
           showWarn('请选择奖励现金券活动');
           return;
        }
        // if(!$scope.detailUpdate.orderDayType){
        //     showWarn('请选择代下单日类型');
        //     return
        // }
        // if($scope.detailUpdate.orderDayType == 2){
        //     if($scope.checkDoubleNumber($scope.detailUpdate.orderDayValue,'1~1000',1000,0,'天数')){
        //         return;
        //     }
        // }
        CommonService.httpRequest({
            url:'/saleUser/update.api',
            method:'post',
            data:{
                id:$scope.detailUpdate.id,
                email:$scope.detailUpdate.email,
                idcard:$scope.detailUpdate.idcard,
                idcardUrl:$scope.detailUpdate.idcardUrl,
                mobile:$scope.detailUpdate.mobile,
                name:$scope.detailUpdate.name,
                subscribeValue:$scope.detailUpdate.subscribeValue,
                type:1,
                typeValue:$scope.detailUpdate.typeValue,
                company:$scope.detailUpdate.company,
                firstType : 1,
                firstTypeValue : $scope.detailUpdate.firstTypeValue,
                orderDayType : 2,
                orderDayValue : $scope.detailUpdate.orderDayValue ,
                activityId : $scope.awardName && $scope.awardName.split('|')[0] || ''
            }
        }).then(function(){
            showInfo('更新成功',function(){
                $scope.isEdit = false;
                $scope.editValue = '编辑';
                $scope.getDetail($scope.detail.id);
            });
        });
    };

    //更改审核状态
    $scope.updateCheck = function(id,applyStatus){
        
        // if(applyStatus == 1 && !$scope.detail.type){
        //     layer.alert('请先点击编辑，选择一种结算方式。',{
        //         icon:0,
        //         title:'提示'
        //     });
        //     return;
        // }

        if(applyStatus == 1){
            layer.confirm('请选择审核状态?', {icon: 3, title:'提示',btn:['审核通过','审核不通过']}, function(index){
                CommonService.httpRequest({
                    url:'/saleUser/audit.api',
                    method:'post',
                    data:{
                        id : id,
                        applyStatus : 2
                    }
                }).then(function(data){
                    showInfo('设置成功',function(){
                        $scope.getDetail(id);
                    });
                });
                layer.close(index);
            },function(index){
                CommonService.httpRequest({
                    url:'/saleUser/audit.api',
                    method:'post',
                    data:{
                        id : id,
                        applyStatus : 3
                    }
                }).then(function(data){
                    showInfo('设置成功',function(){
                        $scope.getDetail(id);
                    });
                });
                layer.close(index);
            });
        }
        else if(applyStatus == 3){
            layer.confirm('请选择审核状态?', {icon: 3, title:'提示',btn:['审核通过','待审核']}, function(index){
                CommonService.httpRequest({
                    url:'/saleUser/audit.api',
                    method:'post',
                    data:{
                        id : id,
                        applyStatus : 2
                    }
                }).then(function(data){
                    showInfo('设置成功',function(){
                        $scope.getDetail(id);
                    });
                });
                layer.close(index);
            },function(index){
                CommonService.httpRequest({
                    url:'/saleUser/audit.api',
                    method:'post',
                    data:{
                        id : id,
                        applyStatus : 1
                    }
                }).then(function(data){
                    showInfo('设置成功',function(){
                        $scope.getDetail(id);
                    });
                });
                layer.close(index);
            });
        }
    };

    //更改有效状态
    $scope.updateStatus = function(id,status){
        if($scope.detail.applyStatus == 2){
            CommonService.httpRequest({
                url: '/saleUser/updateStatus.api',
                method: 'post',
                data:{
                    id : id,
                    status : status == 1 ? 2 : 1
                }
            }).then(function(data){
                $scope.getDetail(id);
            });
        }
    };

    $scope.uploadImg = function($file){
        if($file){
            var isIntegrate = false;
            if($file.size > (3 * 1024 * 1024)){
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
                showInfo("上传成功！",function(){
                    $scope.detailUpdate.idcardUrl = data.data.datas;
                    $scope.$apply();
                });
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

    $scope.imgShow = function(src){
        $scope.imgToBig = fBaseUrl + src;
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

    //统计导出
    $scope.exportData = function(type){
        if(type == 1){
            if(!$scope.startDate || !$scope.endDate){
                showWarn('统计开始日期和统计截至日期不能为空');
                return;
            }
            else{
                if($scope.startDate > $scope.endDate){
                    showWarn('统计开始日期和统计截至日期不能为空');
                    return;
                }
                $scope._startDate = $scope.startDate + ' 00:00:00';
                $scope._endDate = $scope.endDate + ' 00:00:00';
                window.open(rBasetUrl + '/saleOrderInfo/export.api?token=' + localStorage.getItem('token') 
                    + '&saleId=' + $scope.detail.id
                    + '&startDate=' + $scope._startDate 
                    + '&endDate=' + $scope._endDate);
            }
        }
        else{
            if(!$scope.startDate1 || !$scope.endDate1){
                showWarn('统计开始日期和统计截至日期不能为空');
                return;
            }
            else{
                if($scope.startDate1 > $scope.endDate1){
                    showWarn('统计开始日期和统计截至日期不能为空');
                    return;
                }
                $scope._startDate1 = $scope.startDate1 + ' 00:00:00';
                $scope._endDate1 = $scope.endDate1 + ' 00:00:00';
                window.open(rBasetUrl + '/saleWeixinSubcripbeInfo/export.api?token=' + localStorage.getItem('token') 
                    + '&saleId=' + $scope.detail.id
                    + '&startDate=' + $scope._startDate1 
                    + '&endDate=' + $scope._endDate1);
            }
        }
    };

    $scope.orderDetail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };

    $scope.checkDoubleNumber = function(value,range,maxValue,pointNumber,tip){
        if(!value && value !== 0){
            showWarn(tip + '为' + range);
            return true;
        }
        else if(value > maxValue){
            showWarn(tip + '不能大于' + maxValue);
            return true;
        }
        else{
            var typeValueString = String(value);
            if(typeValueString.indexOf('.') > -1){
                if(((typeValueString.length - 1) - typeValueString.indexOf('.')) > pointNumber){
                    if(pointNumber == 0){
                        showWarn(tip + '为' + range + '的整数');
                        return true;  
                    }
                    else{
                        showWarn(tip + '为小数点后' + pointNumber + '位');
                        return true;    
                    }
                }  
            }
        }
        return false;
    }

    $scope.imgShow1 = function(src){
        $scope.imgToBig1 = src;
        $timeout(function () {
            layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                area: '25%',
                shadeClose: true,
                closeBtn:true,
                content: $('#picShow1')
            });
        },10)
    };


}]);
