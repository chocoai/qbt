/**
 * Created by Administrator on 2017/6/6.
 */
angular.module("app.views")
    .controller('urgentFeeDetailCtrl', ['$scope', 'CommonService', function ($scope, CommonService) {
        $('body').niceScroll({cursorcolor: "#337ab7"});
        $scope.urgentFeeId = localStorage.getItem('urgentFee');
        if (!$scope.urgentFeeId) {
            $scope.urgentFee = {
                id: null,
                name: "",
                price: null,
                description: "",
                fromProvince: "",
                fromCity: "",
                toProvince: "",
                toCity: ""
            };
        } else {
            //获取详情
            CommonService.httpRequest({
                url: '/urgent/detail.api?id=' + $scope.urgentFeeId,
                method: 'post',
            }).then(function (data) {
                $scope.urgentFee = data.datas;
                $scope.getCitieses($scope.urgentFee.fromProvince, 0);
                $scope.getCitieses($scope.urgentFee.toProvince, 1);
            });
        }


        //获取省份
        $scope.getProvinces = function () {
            CommonService.httpRequest({
                url: '/baseSfArea/findByParentId.api?parentId=1000000',
                method: 'post',
            }).then(function (data) {
                $scope.startProvinceses = data.datas;
                $scope.endProvinceses = data.datas;
            });
        };
        $scope.getProvinces();

        $scope.getCitieses = function (parentId, type) {
            // if(type == 1){
            if (!!parentId) {
                CommonService.httpRequest({
                    url: '/baseSfArea/findByParentId.api?parentId=' + parentId,
                    method: 'post',
                }).then(function (data) {
                    if (type == 0) {
                        $scope.startCitieses = data.datas;
                    } else {
                        $scope.endCitieses = data.datas;
                    }
                });
            }
            else {
                if (type == 0) {
                    $scope.startCitieses = [];
                } else {
                    $scope.endCitieses = [];
                }
            }
        };

        //省份变化时
        $scope.changeProvince = function (type) {
            var parentId = type == 0 ? $scope.urgentFee.fromProvince : $scope.urgentFee.toProvince;
            $scope.getCitieses(parentId, type);
        }


        //保存数据
        $scope.submitData = function () {
            if (!$scope.urgentFee.fromProvince || !$scope.urgentFee.fromCity) {
                showWarn("原寄地省市不能为空");
                return false;
            }
            if (!$scope.urgentFee.toProvince || !$scope.urgentFee.toCity) {
                showWarn("目的地省市不能为空");
                return false;
            }

            if (!$scope.urgentFee.price || $scope.cichenFavourablePrice < 0) {
                showWarn("价格不能为空或小于0");
                return false;
            }
            else {
                if ($scope.urgentFee.price > 999.99) {
                    showWarn("价格不能大于999.99");
                    return false;
                }
            }

            if (!$scope.urgentFeeId) {
                CommonService.httpRequest({
                    method: 'post',
                    url: '/urgent/add.api',
                    data: $scope.urgentFee
                }).then(function (data) {
                    showInfo("新增成功", function () {
                        tabOpenParent({name: 'urgentFee', url: 'urgentFee.html', displayName: '加急运费管理'});
                    });
                })
            }
            else {
                CommonService.httpRequest({
                    method: 'post',
                    url: '/urgent/update.api',
                    data: $scope.urgentFee
                }).then(function (data) {
                    showInfo("更新成功", function () {
                        tabOpenParent({name: 'urgentFee', url: 'urgentFee.html', displayName: '加急运费管理'});
                    });
                });
                localStorage.removeItem('urgentFee');
            }
        }
        /*输入控制两位小数-start*/
        window.keyUpTwoDecimal = function (obj) {
            obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
            obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的
            obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
            obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');//只能输入两个小数
            // if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
            //   obj.value= parseFloat(obj.value);
            // }
            $(obj).trigger("change");
        };
    }])