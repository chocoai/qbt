;(function($){

    var webService = {
        //获取微信配置
        getJsConfig : function(){
            return getData({
                url : '/comm/weixin/jsConfig.api',
                loading : false,
                data : {
                    url : location.href.replace(location.hash,'')
                }
            });
        },
        //获取用户信息
        getUserInfo : function(){
            return getData({
                url : '/user/query_user_info.api'
            });
        },
        //更新用户信息
        updateUserInfo : function(data){
            return getData({
                url : '/user/update_user_info.api',
                type : 'post',
                loading : false,
                data : data
            });
        },
        //加入清单
        addShopList : function(data){
            return getData({
                url : '/shoppingCart/add.api',
                type : 'post',
                data : data
            });
        },
        //修改清单
        updateShopList : function(data){
            return getData({
                url : '/shoppingCart/update.api',
                type : 'post',
                data : data
            });
        },
        //删除清单
        delShopList : function(data){
            return getData({
                url : '/shoppingCart/delete.api',
                type : 'post',
                data : data
            });
        },
        //清单列表
        getShopList : function(data){
            return getData({
                url : '/shoppingCart/pull.api'
            });
        },
        //清单数量
        getShopCount : function(data){
            return getData({
                url : '/shoppingCart/count.api',
                loading : false
            });
        },
        //购物车订单提交
        confirmOrder : function(data){
            return getData({
                url : '/order/shoping_cart_confirm_order.api',
                type : 'post',
                data : data
            });
        },
        //大订单-支付详情
        getPayInfo : function(data){
            return getData({
                url : '/order/pay_info.api',
                data : data
            });
        },
        //城市查询
        getCityList : function(){
            var deferred = $.Deferred();
            if(localStorage.cityList){
                setTimeout(function(){
                    deferred.resolve(JSON.parse(localStorage.cityList));
                },0);
            }else{
                getData({
                    url : '/area/query_level.api',
                    data :{ level : 2 }
                }).then(function(data){
                    localStorage.cityList = JSON.stringify(data.datas);
                    deferred.resolve(data.datas);
                },function(err){
                    deferred.reject(err);
                });
            }
            return deferred.promise();
        },
        //vip 列表
        getVipList : function(data){
            return getData({
                url : '/vipUser/vipApply.api',
                data : data
            });
        },
        //球包列表
        getBagList : function(_imgType){
            return getData({
                url : '/userImage/list.api',
                //1-我的球包，2-我的证件
                data : {
                    imgType : _imgType
                }             
            });
        }
    };

    function getData(options){
        var _default = {
            type : 'GET',
            data : {},
            dataType : 'json',
            contentType : 'application/x-www-form-urlencoded',
            async : true,
            loading : true
        };
        options = $.extend(_default,options);
        if(options.type.toUpperCase()=='POST'){
            options.data = JSON.stringify(options.data);
            options.contentType = 'application/json';
        }
        //该死微信.GET请求有时被缓存
        if(options.type.toUpperCase()=='GET'){
            options.data._r = new Date().getTime();
        }
        if(options.loading){
            $.loading();
        }
        var deferred = $.Deferred();
        $.ajax({
            type : options.type,
            url : $.baseUrl + options.url,
            contentType : options.contentType,
            data : options.data,
            dataType : options.dataType,
            async : options.async,
            headers:{
                "token" : $.ls('token') || ''
            },
            success : function(d){
                $.closeLoading();
                if(d && d.code == '0000'){
                    deferred.resolve(d);
                }else if(d.code == '0001'){
                    deferred.reject('请从公众号重新登入');
                }else{
                    deferred.reject(d.msg);
                }
            },
            error : function(xhr, type, error){
                $.closeLoading();
                deferred.reject('网络繁忙，请稍后再试');
            }
        });
        return deferred.promise();
    };

    $.webService = webService;
})(Zepto)
