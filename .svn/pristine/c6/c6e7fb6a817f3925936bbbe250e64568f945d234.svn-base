/**
 * Created by Administrator on 2017/10/10.
 */
angular.module("app.views")
    .controller("courseSortCtrl", ['$scope', 'CommonService', 'Constants', '$timeout', function ($scope, CommonService, Constants, $timeout) {
        $('body').niceScroll({cursorcolor: "#337ab7"});
        $scope.hotList = [];
        $scope.toAddHotList = [];
        $scope.getList = function () {
            CommonService.httpRequest({
                url: '/sysAddress/provinces.api',
                method: 'get'
            }).then(function (data) {
                $scope.list = data.datas;
            });
        };
        $scope.getList();

        //获取所有城市列表
        $scope.getToAddHotList = function (num) {
            CommonService.pagination({
                url: '/sysAddress/cities.api',
                data: {
                    pageNo: num || 1,
                    name: $scope.name
                }
            }).then(function (data) {
                $scope.toAddHotList = data.item;
                $scope.page = data.page;
                // angular.forEach(data.datas, function (item) {
                //     if (item.status == 1) {
                //         $scope.hotList.push(item);
                //     }
                // });
            });
        }

        //获取热门城市
        $scope.getHotList = function (num) {
            CommonService.httpRequest({
                url: '/sysAddress/hotCities.api',
                method: 'get'
            }).then(function (data) {
                $scope.hotList = data.datas;
            });
        }

        $scope.getHotList();
        $scope.getToAddHotList();


        //禁用启用省份
        $scope.updateStatus = function (item) {
            var msg = item.status == 2 ? "启用" : "禁用";
            layer.confirm('确定' + msg + '吗?', {icon: 3, title: '提示'}, function (index) {
                item.status = item.status == 2 ? 1 : 2;
                CommonService.httpRequest({
                    url: '/sysAddress/updateProvince.api',
                    method: 'post',
                    data: item
                }).then(function (data) {
                    showInfo(msg + "成功", function () {
                        $scope.getList();
                    });
                });
                layer.close(index);
            }, function (index) {
                layer.close(index);
            });
        };

        //排序
        $scope.sortList = function (index, sortType) {
            if (sortType == "up") {
                if (index == 0) {
                    showWarn('已经是第一个,不能再向上移动了。');
                    return;
                }
                var tmp = angular.copy($scope.list[index - 1]);

                $scope.list[index - 1] = $scope.list[index];
                $scope.list[index] = tmp;
            } else {
                if (index == $scope.list.length - 1) {
                    showWarn('已经是最后一个了，不能再向下移动了！');
                    return;
                }
                var tmp = angular.copy($scope.list[index + 1]);
                $scope.list[index + 1] = $scope.list[index];
                $scope.list[index] = tmp;
            }
        };

        //保存排序
        $scope.updateSort = function () {
            layer.confirm('确定要保存最新排序吗?', {icon: 3, title: '提示'}, function (index) {
                for (var index = 0; index < $scope.list.length; index++) {
                    $scope.list[index].sortNumber = index + 1;
                }
                CommonService.httpRequest({
                    url: '/sysAddress/updatePovinces.api',
                    method: 'post',
                    data: $scope.list
                }).then(function (data) {
                    showInfo("排序更新成功", function () {
                        $scope.getList();
                    });
                });
                layer.close(index);
            }, function (index) {
                layer.close(index);
            });
        };

        //打开城市选择框
        $scope.openHotCity = function () {
            layer.open({
                type: 1,
                title: "添加热门城市",
                area: ['880px', '720px'],
                content: $('#addHotCityDiv')
            });
        }

        //添加热门城市
        $scope.addHotCity = function (item) {
            if ($scope.hotList.length >= 3) {
                showWarn('已经有三座热门城市了,最多只能添加三座热门城市。');
                return;
            }
            item.status = 1;
            CommonService.httpRequest({
                url: '/sysAddress/updateCity.api',
                method: 'post',
                data: item
            }).then(function (data) {
                showInfo("添加成功", function () {
                    $scope.getHotList();
                    $scope.getToAddHotList();
                });
            });
        }


        //取消热门城市
        $scope.delHot = function (item) {
            layer.confirm('确定取消吗?', {icon: 3, title: '提示'}, function (index) {
                item.status = 2;
                CommonService.httpRequest({
                    url: '/sysAddress/updateCity.api',
                    method: 'post',
                    data: item
                }).then(function (data) {
                    showInfo("取消成功", function () {
                        $scope.getHotList();
                        $scope.getToAddHotList();
                    });
                });
                layer.close(index);
            }, function (index) {
                layer.close(index);
            });

        }

        document.onkeydown = function (event) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode == 13) { // enter 键
                $('select').blur();
                $scope.getToAddHotList();
            }
        };
    }]);