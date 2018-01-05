/**
 * Created by Administrator on 2017/10/10.
 */
angular.module("app.views")
    .controller("urgentFeeCtrl", ['$scope', 'CommonService', 'Constants', '$timeout', function ($scope, CommonService, Constants, $timeout) {
        $('body').niceScroll({cursorcolor: "#337ab7"});
        $scope.getList = function (num) {
            CommonService.pagination({
                url: '/urgent/findByPage.api',
                data: {
                    pageNo: num || 1,
                    name: $scope.name
                }
            }).then(function (data) {
                $scope.list = data.item;
                $scope.page = data.page;
            });
        };
        $scope.getList();

        $scope.goDetail = function (item) {
            localStorage.setItem('urgentFee', item.id);
            tabOpenParent({name: 'urgentFeeDetail', url: 'urgentFeeDetail.html', displayName: '加急运费详情'});
        };
        $scope.goAdd = function () {
            localStorage.setItem('urgentFee', "");
            tabOpenParent({name: 'urgentFeeDetail', url: 'urgentFeeDetail.html', displayName: '新增加急运费'});
        };

        //删除
        $scope.delete = function (id) {
            layer.confirm('确定删除吗?', {icon: 3, title: '提示'}, function (index) {
                CommonService.httpRequest({
                    url: '/urgent/delete.api?id=' + id,
                    method: 'get'
                }).then(function (data) {
                    showInfo("删除成功", function () {
                        $scope.getList();
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
                $scope.getList();
            }
        };
    }]);