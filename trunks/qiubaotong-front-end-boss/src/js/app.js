"use strict";

 // var baseUrl = "/api";
 // var wBaseUrl = "/api/wapi";
 // var fBaseUrl = "/file";
 // var rBasetUrl = '/api/report';

var baseUrl = "http://qbt.missionsky.cn:6047/system-web";
var wBaseUrl = "http://qbt.missionsky.cn:6047/qbt-web";
var fBaseUrl = "http://qbt.missionsky.cn:6047/file";
var rBasetUrl = 'http://qbt.missionsky.cn:6047/qbt-report';


//person
// var baseUrl = "http://192.168.1.132:8080/qbt-system-web";
// var rBasetUrl = "http://192.168.1.115:8080/qbt-report";
// 冯
// var baseUrl = "http://192.168.1.122:8080/system-web";
//汪
// var baseUrl = "http://192.168.1.96:8080/system-web";
//豪
// var baseUrl = "http://192.168.1.112:8080/qbt-system-web";

// var baseUrl = "http://114.55.225.54:8180/system-web";
// var fBaseUrl = "http://114.55.225.3/file";
// var rBasetUrl = "http://114.55.225.54:8280/qbt-report";

// 测试
 //var wBaseUrl = "http://192.168.1.12:8080/qbt-web";
 //var baseUrl = "http://192.168.1.12:8180/system-web";
 //var fBaseUrl = "http://testboss.qiubaotong.com/file";
 //var rBasetUrl = "http://192.168.1.12:8280/qbt-report";

//var baseUrl = "http://192.168.1.112:8080/system-web";
//汪
// var rBasetUrl = "http://192.168.1.96:8080/qbt-report";

var rsa_modulus = "00988234aa66797b915a6d8b661c1e79f9f7e0ec4418af4c4dd5957f79f7dd85a436a263db878dad1702bc2dc832d392d7a96eecf9a681c2df44716fe7931669ab10231cea9b17cd6df1d4a66877aa752e1889c04311ad501319507d2d37fc97b7dfe7055e39a39728050530f8a95282b5f07078574911b68ef8ff2af296d73059";
angular.module("app", [
    "app.components",
    "app.services",
    "app.views"
]);
angular.module("app.components", []);
angular.module("app.services", []);
angular.module("app.views", []);

angular.module("app.services")
.service('Constants',[function(){
    return {
        business_type : [
            {type : '1', desc : '明日达'},
            {type : '2', desc : '隔日达'},
            {type : '5', desc : '明午达'}
        ],
        order_type :[
            {type : '1', desc : '待支付'},
            {type : '2', desc : '支付中'},
            {type : '3', desc : '支付成功'},
            {type : '4', desc : '支付失败'},
            {type : '5', desc : '订单关闭(用户取消)'}, //用户取消
            {type : '6', desc : '订单关闭(系统关单)'},//系统关单
            {type : '7', desc : '订单关闭(客服取消)'},  //客服取消
            {type : '8', desc : '订单关闭(修改渠道)'}  //客服取消
        ],
        app_Status:[
            {type : '0', desc : '未申请'},
            {type : '1', desc : '已申请'}
        ],
        refund_type :[
            {type : '1', desc : '正常状态'},
            {type : '2', desc : '待退款'},
            {type : '3', desc : '退款中'},
            {type : '4', desc : '退款完成'},
            {type : '5', desc : '退款失败'}
        ],
        sf_type :[
            {type : '1', desc : '尚未下单至顺丰'},
            {type : '2', desc : '待上门收件'},
            {type : '3', desc : '顺丰已取件'},
            {type : '4', desc : '顺丰已取件(客服确认)'}, //客服确认
            {type : '5', desc : '物流运输中'},
            {type : '6', desc : '派送中'},
            {type : '7', desc : '已签收'}
        ],
        coupon_type :[
            {type : '1', desc : '现金券'},
            {type : '2', desc : '折扣券'},
            {type : '3', desc : '特价券'}
        ],
        apply_type:[
            {type : '1', desc : '球场官方工作人员'},
            {type : '2', desc : '球场私人工作人员'},
            {type : '3', desc : '银行站点工作人员'},
            {type : '4', desc : '顺丰站点工作人员'},
            {type : '5', desc : '顺丰机场工作人员'},
            {type : '6', desc : '官方球包助理'},
            {type : '7', desc : '普通球包助理'},
            {type : '8', desc : '合作方助理'}
        ],
        apply_status_type:[
            {type : '1', desc : '审核中'},
            {type : '2', desc : '审核通过'},
            {type : '3', desc : '审核不通过'},
            {type : '4', desc : '禁用'}
        ],
        course_status_type:[
            {type : '1', desc : '已签约'},
            {type : '2', desc : '未签约但可接受球包通球包'},
            {type : '3', desc : '不接受球包通球包'},
            {type : '4', desc : '未知状态'}
        ],
        service_manage_type:[
            {type : '0', desc : '普通客服'},
            {type : '1', desc : '财务'},
            {type : '2', desc : '技术管理员'}
        ],
        week_type : [
            {type : '1', desc : '星期一'},
            {type : '2', desc : '星期二'},
            {type : '3', desc : '星期三'},
            {type : '4', desc : '星期四'},
            {type : '5', desc : '星期五'},
            {type : '6', desc : '星期六'},
            {type : '7', desc : '星期天'}
        ],
        bps_type : [
            {type : '1', desc : '未发送'},
            {type : '2', desc : '发送成功'},
            {type : '3', desc : '发送失败'}
        ],
        dashboard_type : [
            {type : '1', desc : '需对订单状态检查'},
            {type : '2', desc : '订单状态未变更'},
            {type : '3', desc : '下单失败'},
            {type : '4', desc : '派送失败'},
            {type : '5', desc : '球场端收件异常'},
            {type : '6', desc : '球包已退回/转寄'},
            {type : '7', desc : '球包已退回/转寄'}
        ],
        dashboardColor_type : [
            {type : '1', desc : 'dashboardColor1'},
            {type : '2', desc : 'dashboardColor2'},
            {type : '3', desc : 'dashboardColor3'},
            {type : '4', desc : 'dashboardColor4'},
            {type : '5', desc : 'dashboardColor5'},
            {type : '6', desc : 'dashboardColor6'},
            {type : '7', desc : 'dashboardColor6'}
        ],
        advertise_seat : [
            {type : 'home', desc : '首页广告位'},
            {type : 'set', desc : '设置广告位'},
            {type : 'course', desc : '球场广告位'}
        ],
        orderEval_type : [
            {type : '1', desc : '审核中'},
            {type : '2', desc : '审核通过'},
            {type : '3', desc : '审核不通过'}
        ],
        orderPay_type : [
            {type : '1', desc : '微信支付'},
            {type : '2', desc : '合作方代下单'},
            {type : '99', desc : '现金券满额支付'}
        ],
        payMethod_type : [
            {type : '1', desc : '微信支付'},
            {type : '97', desc : 'BOSS代下单'},
            {type : '98', desc : '合作方代下单'},
            {type : '99', desc : '现金券满额支付'},
            {type : '6', desc : '现在支付'}
        ],
        partner_type : [
            {type : '1', desc : '旅行社'}
        ],
        settleModel_type : [
            {type : '1', desc : '进阶模式'},
            {type : '2', desc : '订单折扣模式'},
            {type : '3', desc : '订单固定金额模式'}
        ],
        settleState_type : [
            {type : '1', desc : '未结算'},
            {type : '2', desc : '已结算'},
            {type : '3', desc : '无效订单'}
        ],
        langEname_type : [
            {type : 'zh-cn', desc : '中文'},
            {type : 'ja-jp', desc : '日语'}
        ],
        settleModeValueUnit_type : [
            {type : '1', desc : ''},
            {type : '2', desc : '%'},
            {type : '3', desc : '元'}
        ],
        payStatus_type : [
            {type : '1', desc : '微信预支付'},
            {type : '2', desc : '支付成功'},
            {type : '3', desc : '支付失败'}
        ],
        emailStatus_type : [
            {type : '0', desc : '发送中'},
            {type : '1', desc : '发送成功'},
            {type : '2', desc : '发送失败'}
        ],
        platform_type : [
            {type : 'qbt', desc : '球包通'},
            {type : 'gft', desc : '高付通'}
        ],
        kfReceivableStatus_type : [
            {type : '0', desc : '无需收款'},
            {type : '1', desc : '是'},
            {type : '2', desc : '否'}
        ],

        //实体卡激活
        vipCard_active_type : [
            {type : '1', desc : '微信支付'},
            {type : '3', desc : '支付宝'},
            {type : '4', desc : '汇款'},
            {type : '5', desc : '现金'}
        ],

        payMethod_active_type : [
            {type : '0', desc : ''},
            {type : '1', desc : '微信支付'},
            {type : '2', desc : 'boss购买'},
            {type : '3', desc : '支付宝'},
            {type : '4', desc : '汇款'},
            {type : '5', desc : '现金'},
        ],
        activateMethod_active_type : [
            {type : '1', desc : '微信'},
            {type : '2', desc : 'APP'},
            {type : '3', desc : '官网'},
            {type : '4', desc : '客服人工'}
        ],
        platforms : [
            {type : '1', desc : '球包通平台'},
            {type : '2', desc : '高付通平台'},
            {type : '0', desc : '基础平台'}
        ],
        //弹框条件
        condition_type : [
            {type : '1', desc : '进入首页即弹框'},
            {type : '2', desc : '用户选特定球场'},
            {type : '3', desc : '用户选特定地区'}
        ],
        alert_platform : [
            {type : '1', desc : '微信'},
        ],
        //销售提成方式
        sale_method : [
            {type : '0', desc : '未知'},
            {type : '1', desc : '固定金额￥'},
            {type : '2', desc : '订单金额比例%'},
        ],
        //销售人员审核状态
        sale_status : [
            {type : '1', desc : '待审核'},
            {type : '2', desc : '审核通过'},
            {type : '3', desc : '审核不通过'},
        ],
        //物流状态
        delivery_Status : [
            {type : '1', desc : '待签收'},
            {type : '2', desc : '已签收'},
        ],
        //微信用户关注状态
        subscribe_status : [
            {type : '0', desc : '未知'},
            {type : '1', desc : '已关注'},
            {type : '2', desc : '取消关注'},

        ],
        //订单来源
        order_source : [
            {type : '1', desc : '微信下单'},
            {type : '3', desc : '官网下单'},
            {type : '5', desc : 'BOSS下单'},

        ],
        //报文类型
        serviceName_type : [
            {type : 'orderService', desc : '顺丰正向下单'},
            {type : 'orderReverseService', desc : '顺丰逆向下单'},
            {type : 'deliverTmService', desc : '顺丰时效查询'},
            {type : 'deliverTmServiceBySfWebSite', desc : '顺丰官网时效查询'},

        ],
        //发票类型
        billType : [
            {type : '', desc : '全部'},
            {type : '1', desc : '电子'},
            {type : '2', desc : '纸质'}
        ],
        //开票状态
        billingStatus : [
            {type : '', desc : '全部'},
            {type : '1', desc : '未开票'},
            {type : '2', desc : '已开票'}
        ]
    }
}]);
angular.module("app")
.filter("commFilter", ['Constants',function(Constants){
    return function(items, type){
        if(Constants[type]){
            for (var index = 0; index < Constants[type].length; index++){
                var item = Constants[type][index];
                if (items == item.type)
                    return item.desc;
            }
        }
        return '';
    }
}]);

angular.module("app")
.filter('to_trusted', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);//$sce把一些地址变成安全的、授权的链接，不被拦截
    }
}]);


angular.module("app.services")
.service('CommonService',['$http','$q', function($http,$q){
    var service = {

        getToken: function(){
            return localStorage.getItem('token');
        },

        setToken: function(data){
            localStorage.setItem('token',data);
        },

        removeToken: function(){
            localStorage.removeItem('token');
        },

        httpRequest: function(options) {
            var self = this;
            var method = options.method ? options.method.toLowerCase() : 'get';
            var url = (options.baseUrl || baseUrl) + options.url;
            var data = options.data || {};
            var token = self.getToken();
            if(method == 'get'){
                if(url.indexOf('?')>0){
                    url += "&s="+new Date().getTime();
                }else{
                    url += "?s="+new Date().getTime();
                }
                var arr = new Array();
                for (var key in data) {//把要提交的data数据放入数组里，中文经过encode码解析
                    arr.push(key + '=' + encodeURIComponent(data[key]));
                }
                if(arr.length>0){
                    url += "&";
                    url += arr.join("&");
                }

                var deferred  = $q.defer();//通过$q服务注册一个延迟对象 deferred
                var promise;
                var load = layer.load(1);
                promise = $http.get(url,{headers: {"token": token}});
                promise.then(function(data, status) {
                    layer.close(load);
                    if(data.data && data.data.code == '0000'){
                        return deferred.resolve(data.data);//成功解决(resolve)了其派生的promise。参数data.data将来会被用作成功回调函数的参数
                    }else{
                        if(data.data.code == '7001'){
                            showErr(data.data.msg,function(){
                              parent.window.location.href = "login.html";
                            });
                            return;
                        }else{
                            showErr(data.data.msg);
                        }
                        return deferred.reject(data.data.msg);//未成功解决其派生的promise。参数reason被用来说明未成功的原因
                    }
                },function(data, status) {
                    layer.close(load);
                    showErr('请求错误');
                    return deferred.reject('请求错误');
                });
                return deferred.promise;

            }else if(method == 'post'){
                var deferred = $q.defer();
                var load = layer.load(1);
                $http.post(url,data,{headers: {"token": token}}).then(function(data, status) {
                    layer.close(load);
                    if(data.data && data.data.code == '0000'){
                        return deferred.resolve(data.data);
                    }else{
                        if(data.data.code == '7001'){
                            showErr(data.data.msg,function(){
                              parent.window.location.href = "login.html";
                            });
                            return;
                        }else{
                            showErr(data.data.msg);
                        }
                        return deferred.reject(data.data.msg);
                    }
                },function(data, status) {
                    layer.close(load);
                    showErr('请求错误');
                    return deferred.reject('请求错误');
                });
                return deferred.promise;
            }
        },

        pagination : function(ops){
            var list = function(page,size){
                var data = ops.data || {};
                data.pageNo = page;
                data.pageSize = size;
                return service.httpRequest({
                    method : 'post',
                    url : ops.url,
                    baseUrl:ops.baseUrl,
                    data : data
                },$http,$q)
            }

            var load = function(){
                var deferred;
                deferred = $q.defer();
                var rdata = {};
                var pageNo = ops.data.pageNo || 1;
                var pageSize = ops.data.pageSize || 10;
                list(pageNo,pageSize).then(function(data){
                    if(ops.listName){
                        rdata.item = data[listName];
                    }else{
                        rdata.item = data.datas;
                    }
                    rdata.page = {};
                    rdata.page.totalCount = data.page.totalCount;
                    rdata.page.totalPage = data.page.totalPages;
                    rdata.page.pageNumber = data.page.pageNo;
                    rdata.page.pageSize = data.page.pageSize;
                    return deferred.resolve(rdata);
                })
                return deferred.promise;
            }

            return load();
        },

        getQueryString : function(name){
            var reg = new RegExp("(^|&|\|)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)return  decodeURIComponent(r[2]); return "";
        }

    }
    return service;
}]);


angular.module("app.components")
.directive("headerSidebar", [function(){
    return {
        restrict: "EA",
        templateUrl: "header.html",
        controller: ["$scope","CommonService", "$rootScope",'$timeout', function($scope,CommonService,$rootScope,$timeout){
            $scope.loginout = function(){
                CommonService.removeToken();
                window.location.href = "login.html";
            };
            $scope.loginName = localStorage.getItem('b_name');
            $scope.platId = localStorage.getItem('b_plat');
            $scope.getMenu = function(){
                CommonService.httpRequest({
                    url : '/adminSysResource/listByUserId.api',
                    method : 'get',
                    data : {
                        platId : $scope.platId
                    }
                }).then(function(data){
                    $scope.menuList = data.datas;
                    $timeout(function(){
                        $('#side-menu').metisMenu();//侧边栏导航插件
                        if(!isMobile.any()){
                            $('.sidebar-nav').outerHeight($(window).height() - 60);
                            $('.sidebar-nav').niceScroll({cursorcolor:"#337ab7"});
                            changeIframeHeight();
                            $(window).resize(function(){
                                $('.sidebar-nav').outerHeight($(window).height() - 60);
                                changeIframeHeight();
                            });
                        };
                    });
                });
            };
            $scope.checked = function(item){
                localStorage.removeItem('manages');
                tabOpen({
                    displayName : item.name,
                    url : item.url,
                    name : item.url.replace('.html','')
                });
            };
            $scope.changeHeight = function(id){
                var selectUl = $('#side-menu>li').eq(id).children('ul');
                var selectUlHeight = selectUl.height();
                if(!selectUlHeight){
                    var sidebarNavHeight = $('.sidebar-nav').height();
                    var liHeight = selectUl.children('li').height();
                    var sidebarNavLiHeight = (selectUl.children('li').length + 1) * liHeight;
                    if(sidebarNavLiHeight > sidebarNavHeight){
                        var selectUlTop = id * liHeight + 10;
                        $('.sidebar-nav').animate({
                            scrollTop: selectUlTop
                        }, 600);
                    }
                    else{
                        var selectUlTop = (id + 2 + selectUl.children('li').length) * liHeight + 20;
                        if(sidebarNavHeight < selectUlTop){
                            $('.sidebar-nav').animate({
                                scrollTop: (selectUlTop - sidebarNavHeight)
                            }, 600);
                        } 
                    }
                }
            };
            $scope.getMenu();
        }],
        // link: function ($scope, element){
        //     $(element).metisMenu();
        // },
        replace : true//是否替换标签
    };
}]);

angular.module("app.components")
.directive("pagination", [function(){
    return {
        restrict: "EA",
        templateUrl: "pagination.html",
        scope: {
            page:"=",
            onPageChange: "&change"
        },
        controller: ["$scope", function($scope){
            $scope.currentPage = 1;
            $scope.pages = [];
            function initPageBox(){
                var pages = [];
                var totalPage = $scope.page.totalPage;
                if (totalPage <= 7){
                    for (var index=1; index <= totalPage; index++)
                        pages.push(index);
                }
                else{
                    if ($scope.currentPage < 7){
                        for (var index = 1; index <= 7; index++)
                            pages.push(index);
                        pages.push("...");
                    }
                    else if ($scope.currentPage >= totalPage - 2){
                        pages.push(1);
                        pages.push(2);
                        pages.push("...");
                        pages.push(totalPage - 4);
                        pages.push(totalPage - 3);
                        pages.push(totalPage - 2);
                        pages.push(totalPage - 1);
                        pages.push(totalPage);
                    }
                    else{
                        pages.push(1);
                        pages.push(2);
                        pages.push("...");
                        pages.push($scope.currentPage - 2);
                        pages.push($scope.currentPage - 1);
                        pages.push($scope.currentPage);
                        pages.push($scope.currentPage + 1);
                        pages.push($scope.currentPage + 2);
                        pages.push("...");
                    };
                };
                $scope.pages = pages;
            };

            $scope.$watch("page", function(newValue, oldValue){
                if ((newValue != undefined)&&(newValue != null)){
                    if ($scope.page.pageNumber > $scope.page.totalPage){
                        $scope.setCurrentPage(newValue.totalPage);
                    };
                    if ($scope.page.pageNumber != $scope.currentPage){
                        $scope.setCurrentPage($scope.page.pageNumber);
                    }
                    initPageBox();
                }
            }, true)

            $scope.setCurrentPage = function(page){
                if (!page || page == "...")
                    return;
                if (page <= 0){
                    $scope.currentPage = 1;
                    return;
                }
                else if (page > $scope.page.totalPage){
                    $scope.currentPage = $scope.page.totalPage;
                    return;
                }
                else
                    $scope.currentPage = parseInt(page);
                initPageBox();
            }
            $scope.$watch("currentPage", function(newValue, oldValue){
                if ((!!newValue)&&(!!oldValue)&&(newValue != oldValue))
                    $scope.onPageChange({page: newValue});
            })
        }]
    }

}]);

//监听repeat完成
angular.module('app.components')
.directive('repeatDone', function() {
    return {
        link: function(scope, element, attrs) {
            if (scope.$last) {                   // 这个判断意味着最后一个 OK
                scope.$eval(attrs.repeatDone);  // 执行绑定的表达式
            }
        }
    }
});


//String format
String.prototype.format = function() {
   var s = this;
   for (var i = 0; i < arguments.length; i++) {
       var reg = new RegExp("\\{" + i + "\\}", "gm");
       s = s.replace(reg, arguments[i]);
   }
  return s;
};

//数组排序统计
Array.prototype.sortAndCount = function(){
    var s = this.sort();
    //统计个数
    var arr2 = {};
    s.forEach(function(item){
        if(arr2[item]){
            arr2[item] += 1;
        }else{
            arr2[item] = 1;
        }
    })
    return arr2;
};

//数组去重
Array.prototype.unique = function() {
    var res = [], hash = {};
    for(var i=0, elem; (elem = this[i]) != null; i++)  {
        if (!hash[elem])
        {
            res.push(elem);
            hash[elem] = true;
        }
    }
    return res;
}

// 日期扩展
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//String replaceAll扩展
String.prototype.replaceAll = function(s1,s2){
    return this.replace(new RegExp(s1,"gm"),s2);
};
//String url参数获取扩展
String.prototype.getQueryString = function(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = this.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]);
    return null;
}


//菜单打开标签
function tabOpen(item){
    if(isMobile.any()){
        location.href = item.url;
        return;
    }
    var tabid = item.name;
    $("#tab>div").removeClass("tab_down");
    $("#contenttab>div").removeClass("divtab_down");
    $("#contenttab>div").addClass("divtab");

    if($("#"+tabid).length>0){
        $("#"+tabid).addClass("tab_down");
        $("#content"+tabid).addClass("divtab_down");
        $("#iframe"+tabid)[0].contentWindow.location.reload();
    }else{
        tabc.AddTab(item.name,item.displayName,
            "<iframe id='iframe"+tabid+"' src='"+item.url+"' ></iframe>", true);
        // if($("#tab>div").length>7){
        //     //remove first tab
        //     var removeid = $("#tab>div")[1].id;
        //     $("#"+removeid).remove();
        //     $("#content"+removeid).remove();
        // }
    }
    changeIframeHeight();
};
//页面打开标签
function tabOpenParent(item){
    if(isMobile.any()){
        location.href = item.url;
        return;
    }
    var tabid = item.name;
    $("#tab>div",window.parent.document).removeClass("tab_down");
    $("#contenttab>div",window.parent.document).removeClass("divtab_down");
    $("#contenttab>div",window.parent.document).addClass("divtab");

    if($("#"+tabid,window.parent.document).length>0){
        $("#"+tabid,window.parent.document).addClass("tab_down");
        $("#content"+tabid,window.parent.document).addClass("divtab_down");
        var orgUrl = $("#iframe"+tabid,window.parent.document)[0].src;
        if(orgUrl == item.url){
            $("#iframe"+tabid,window.parent.document)[0].contentWindow.location.reload();
        }else{
            $("#iframe"+tabid,window.parent.document)[0].src = item.url;
        }
    }else{
        window.parent.tabc.AddTab(item.name,item.displayName,
            "<iframe id='iframe"+tabid+"' src='"+item.url+"' ></iframe>", true);

        // if($("#tab>div",window.parent.document).length>7){
        //     //remove first tab
        //     var removeid = $("#tab>div",window.parent.document)[1].id;
        //     $("#"+removeid,window.parent.document).remove();
        //     $("#content"+removeid,window.parent.document).remove();
        // }
    }
};

function removeTab(tabid,event) {
    if($("#tab").children('div').length-1!=0){
        var tab = $('#' + tabid),
            contentTab = $('#content' + tabid);
        if($("#"+tabid).attr("class")=="tabDiv tab_down"){
            //获取当前选择tab的上一个tab
            var prevTabId=$("#"+tabid).prev().attr("id");
            if($("#"+tabid).prev().length<1){
                prevTabId=$("#"+tabid).next().attr("id");
            }
            $("#"+prevTabId).addClass("tab_down");
            $("#content"+prevTabId).addClass("divtab_down");
        }
        tab.remove();
        contentTab.remove();
        changeIframeHeight();
        //阻止事件冒泡
        event.stopPropagation();
    }
};
function tab_Click(tabid){//点击
    //只有一个tab层或者当前tab已选中
    if($("#tab").children('div').length==1 || $("#"+tabid).attr("class")=="tabDiv tab_down"){
        return;
    }
    $("#tab>div").removeClass("tab_down");
    $("#"+tabid).addClass("tab_down");

    $("#contenttab>div").removeClass("divtab_down");
    $("#contenttab>div").addClass("divtab");
    $("#content"+tabid).removeClass("divtab");
    $("#content"+tabid).addClass("divtab_down");
    changeIframeHeight();
};
//页面里关闭标签
function tabClose(){
    var tabid = $(".tabDiv.tab_down",window.parent.document).attr("id");

    if($("#tab",window.parent.document).children('div').length-1!=0){
        var tab = $('#' + tabid,window.parent.document),
            contentTab = $('#content' + tabid,window.parent.document);
        if($("#"+tabid,window.parent.document).attr("class")=="tabDiv tab_down"){
            //获取当前选择tab的上一个tab
            var prevTabId=$("#"+tabid,window.parent.document).prev().attr("id");
            if($("#"+tabid,window.parent.document).prev().length<1){
                prevTabId=$("#"+tabid,window.parent.document).next().attr("id");
            }
            $("#"+prevTabId,window.parent.document).addClass("tab_down");
            $("#content"+prevTabId,window.parent.document).addClass("divtab_down");
        }
        tab.remove();
        contentTab.remove();
    }
};
//刷新tab
function refreshTab(tabid){
    if($("#iframe"+tabid,window.parent.document).length>0){
        $("#iframe"+tabid,window.parent.document)[0].contentWindow.location.reload();
    }
};


var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i) ? true : false;
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i) ? true : false;
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i) ? true : false;
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i) ? true : false;
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Windows());
    }
};

function showWarn(msg,func){
    layer.msg(msg,{icon:0,time:4000},func);
};
function showErr(msg,func){
    layer.msg(msg,{icon:2,time:2000},func);
};
function showInfo(msg,func){
    layer.msg(msg,{icon:6,time:1500},func);
};
function showLongInfo(msg,func){
    layer.msg(msg,{icon:6,time:3500},func);
};
function showConfirm(msg,func) {
    layer.alert(msg,{btn:['确认','取消'],icon:6},func);
}
function changeIframeHeight(){
    var contenttab_top = $('#contenttab').offset().top;
    $('#contenttab').outerHeight($(window).height() - 10 - contenttab_top);
}
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