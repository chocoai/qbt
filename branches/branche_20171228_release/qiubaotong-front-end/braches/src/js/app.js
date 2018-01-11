;(function($){

    $.version = '1511259742190';



    //$.baseUrl = "/api";
    $.baseUrl = "http://qbt.missionsky.cn:6047/qbt-web";
    $.fbaseUrl = "http://qbt.missionsky.cn:6047/file";
    //MS Test
    //$.appId='wx431ea45290b64792';
    //生产
    //$.fbaseUrl = "http://weixin.qiubaotong.com/file";
    //$.appId = 'wxeaebcab0b9ed0a68';

    //测试wx5e7cf8497e16387a
    $.appId = 'wx5e7cf8497e16387a';
    //$.fbaseUrl = "http://testweixin.qiubaotong.com/file";

    $.commonAjax = function(options){
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
                    options.success && options.success(d)
                }else if(d.code == '0001'){
                    $.toast('请从公众号重新登入');
                }else{
                    options.error && options.error(d.msg);
                }
            },
            error : function(xhr, type, error){
                $.closeLoading();
                // options.error && options.error(xhr, type, error);
                options.error && options.error('网络繁忙，请稍后再试');
            }
        });
    };
}(Zepto))

;(function($){
    $.getQueryString = function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = location.search.substr(1).match(reg);
        if (r != null)
            return unescape(decodeURI(r[2]));
        return null;
    };
    //String format
    if(!String.prototype.format){
        String.prototype.format = function() {
           var s = this;
           for (var i = 0; i < arguments.length; i++) {
               var reg = new RegExp("\\{" + i + "\\}", "gm");
               s = s.replace(reg, arguments[i]);
           }
           return s;
        };
    };

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


    $.alert  = function(msg,func){
        layer.open({
            content : msg,
            btn : '确定',
            shadeClose: false,
            className : 'layer_alert',
            yes : function(index){
                func && func();
                layer.close(index);
            }
        });
    };

    $.toast = function(msg){
        layer.open({
            content: msg,
            skin: 'msg',
            time: 2
        });
    };

    $.confirm = function(msg,func,fune){
        layer.open({
            content: msg,
            btn: ['确定', '返回'],
            skin: 'footer',
            className : 'layer_confirm',
            yes: function(index){
              func && func();
              layer.close(index);
            }
        });
    };
    $.confirm2 = function(msg,func,fune){
        layer.open({
            content: msg,
            shadeClose : false, //true会导致tap事件穿透
            btn: ['确定', '返回'],
            skin: 'footer',
            className : 'layer_confirm',
            yes: function(index){
              func && func();
              layer.close(index);
            },
            no : function(){
                fune && fune();
            }
        });
    };

    $.ls = function(id,msg){
        if(msg != undefined){
            msg ? sessionStorage.setItem(id,msg) : sessionStorage.removeItem(id);
        }else{
            return sessionStorage.getItem(id);
        }
    };

    $.setTitle = function(title){
        $('title').text(title);
        if($.os.ios){
            var $iframe = $('<iframe src="../img/star-s.png" style="display:none;"></iframe>').on('load', function() {
                setTimeout(function() {
                    $iframe.off('load').remove();
                }, 0)
            }).appendTo($('body'));
        }
    };

}(Zepto))

;(function($){

    $.comReg = {
        isPhone : function(val){
            return /(^(0[0-9]{2,3}-?)?[0-9]{7,8}$)|(^1[\d]{10}$)/g.test(val);
        },
        isMobile : function(val){
            return /^1[\d]{10}$/g.test(val);
        },
        isEmail : function (val) {
            return /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/g.test(val);
        }
    };
}(Zepto))

;(function($){
    $.loading = function(){
        if($('#loading').length>0){
            $('#loading').show();
        }else{
            var context = [];
            context.push('<div id="loading" class="load-shadow">');
            context.push('<div>');
            context.push('<img src="/img/loading.svg"/>');
            context.push('</div>');
            context.push('</div>');
            $('body').append(context.join(''));
        }
    };
    $.closeLoading = function(){
       $('#loading').hide();
    };
}(Zepto))

//微信认证
;(function($){

    $.weixinAuth = function(){
        var token = $.ls("token");
    	if(!token){
    		var code = $.getQueryString('code');
    		if(code == null){
    			var fromurl = location.href;
    			var url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='+$.appId+'&redirect_uri=' + encodeURIComponent(fromurl) + '&response_type=code&scope=snsapi_userinfo&state=0#wechat_redirect';
    		    location.replace(url);
                return false;
    		}else{

                $.commonAjax({
    	            url:'/index/login.api',
                    data:{
                        "code" : code
                    },
                    async : false,
    	            success:function(data){
                        if(data && data.code == '0000'){
                            $.ls('token',data.datas);
                        }else{
                            $.toast('获取用户授权失败');
                        }
                    },
                    error : function(xhr, type, error){
                        $.toast('获取用户授权失败');
                    }
    	        });
    		}
    	}
        return true;
    }

}(Zepto))

//百度服务
;(function($){
    //var ak = "bbUppcCeCy3T1caDzybElD4Pc7QP4SGb";
    var ak = "4CIpHQfLPefMBvMHxzlwQr1pdn1IdYTZ";
    $.baiduApi = {
        //ip定位
        location : 'http://api.map.baidu.com/location/ip?ak={0}&coor=bd09ll',
        //地理查询
        geocoder : 'http://api.map.baidu.com/geocoder/v2?ak={0}&address={1}&output=json',
        //坐标查地理
        geocoder_xy : 'http://api.map.baidu.com/geocoder/v2/?ak={0}&coordtype=wgs84ll&location={1}&output=json',
        //地址检索
        suggestion : 'http://api.map.baidu.com/place/v2/suggestion?ak={0}&region={1}&q={2}&output=json'
    };
    $.baiduApi_location = function(fn){
        $.ajaxJSONP({
            url : $.baiduApi.location.format(ak) + '&callback=?',
            success : function(data){
                $.ajaxJSONP({
                    url : 'http://api.map.baidu.com/geocoder/v2/?ak='+ak+'&coordtype=bd09ll&location='+data.content.point.y+','+data.content.point.x+'&output=json&callback=?',
                    success : function(d){
                        fn && fn(d);
                    }
                });
            }
        });
    };
    $.baiduApi_address = function(location,fn){
        $.ajaxJSONP({
            url : $.baiduApi.geocoder_xy.format(ak,location) + '&callback=?',
            success : function(data){
                fn && fn(data);
            }
        });
    };
    $.baiduApi_suggestion = function(region,q,fn){
        $.ajaxJSONP({
            url : $.baiduApi.suggestion.format(ak,region,q) + '&callback=?',
            success : function(data){
                fn && fn(data);
            }
        });
    };
}(Zepto))

;(function($){
        /**输入框控制方法
     * inputElement 节点元素名，必须为ID，即#ID
     * regExp 正则表达式。正则表达式不合法的输入会直接删除掉
     * type money为金额框
     */
    $.inputValues = {};
    $.inputRegExp = function (inputElement, regExp, type) {

        function getCursorPosition(inputId) {
            var elem = document.getElementById(inputId);
            var inputIndex = 0;
            if ('selectionStart' in elem) {
                inputIndex = elem.selectionStart;
            } else if ('selection' in document) {
                elem.focus();
                var Sel = document.selection.createRange();
                var SelLength = document.selection.createRange().text.length;
                Sel.moveStart('character', -elem.value.length);
                inputIndex = Sel.text.length - SelLength;
            }
            return inputIndex;
        }

        function setCursorPosition(inputId, newIdx) {
            var elem = document.getElementById(inputId);
            if ('selectionStart' in elem) {
                elem.selectionStart = newIdx;
                elem.selectionEnd = newIdx;
            } else {
                var range = elem.createTextRange();
                range.move("character", newIdx);
                range.select();
            }
        }

        if (inputElement !== null && inputElement !== undefined && inputElement !== '') {
            var inputId = $(inputElement).attr("id");
            var inputType = $(inputElement).attr("type");
            $.inputValues[inputId] = {};
            $.inputValues[inputId]["value"] = "";
            $.inputValues[inputId]["idx"] = 0;
            $.inputValues[inputId]["type"] = type;
            $.inputValues[inputId]["regExp"] = regExp;
            if ("money" == type) {
                $(inputElement).attr("type", "text");
                $(inputElement).attr("maxlength", "16");
                $.inputValues[inputId]["regExp"] = /^(([0-9]|([1-9][0-9]{0,12}))?(((\.[0-9]{0,2})|(\.))?))$/;
            }
            if ("number" == inputType) {
                $(inputElement).attr("type", "tel");
            }
            $(inputElement).unbind('keydown');
            $(inputElement).unbind('input');
            $(inputElement).on('keydown', function () {
                var inputId = $(this).attr("id");
                $.inputValues[inputId]["value"] = $(this).val();
                $.inputValues[inputId]["idx"] = getCursorPosition(inputId);
            });
            $(inputElement).on('input', function () {
                var inputId = $(this).attr("id");
                var elemVal = $(this).val().replace(/\s/g, "");
                if (elemVal == null || elemVal == "") {
                    $.inputValues[inputId]["idx"] = 0;
                    $.inputValues[inputId]["value"] = "";
                } else {
                    if("money" == $.inputValues[inputId]["type"]) {
                        if("." == elemVal) {
                            $(this).val("0.");
                            elemVal = $(this).val();
                        }
                    }
                    if ($.inputValues[inputId]["regExp"].test(elemVal))
                    {
                        if("bankCard"==$.inputValues[inputId]["type"])
                        {
                            var s=$(this).val();
                            if(s.charAt(s.length - 1)==" ")
                            {
                                s=s.substring(0,s.length-1);
                                $(this).val(s);
                                return;
                            };
                            var valArr=elemVal.split("");
                            var m=parseInt(valArr.length / 4);
                            for(i=1;i<=m;i++)
                            {
                                valArr.splice(5*i-1,0," ");
                            }
                            $(this).val(valArr.join(""));
                            $.inputValues[inputId]["idx"] = getCursorPosition(inputId);
                        }
                        else
                        {
                            $.inputValues[inputId]["value"] = $(this).val();
                            $.inputValues[inputId]["idx"] = getCursorPosition(inputId);
                        }

                    }
                    else {
                        $(this).val($.inputValues[inputId]["value"]);
                        setCursorPosition(inputId, $.inputValues[inputId]["idx"]);
                    }
                }
            });
        }
    };
}(Zepto))

;(function(){

var types = {
    business_type : [
        {type : '5', desc : '明午达'},
        {type : '1', desc : '明日达'},
        {type : '2', desc : '后日达'}
    ],
    order_type :[
        {type : '1', desc : '待支付'},
        {type : '2', desc : '支付中'},
        {type : '3', desc : '支付成功'},
        {type : '4', desc : '支付失败'},
        {type : '5', desc : '订单关闭'}, //用户取消
        {type : '6', desc : '订单关闭'}, //系统关单
        {type : '7', desc : '订单关闭'} //客服取消
    ],
    sf_type :[
        {type : '1', desc : '待取件'},//尚未下单至顺丰
        {type : '2', desc : '待取件'},//待上门收件
        {type : '3', desc : '已取件'},//顺丰已取件
        {type : '4', desc : '已取件'}, //顺丰已取件 客服确认
        {type : '5', desc : '运输中'},//物流运输中
        {type : '6', desc : '派送中'},
        {type : '7', desc : '已签收'}
    ],
    refund_type :[
        {type : '1', desc : '正常状态'},
        {type : '2', desc : '待退款'},
        {type : '3', desc : '退款中'},
        {type : '4', desc : '退款完成'},
        {type : '5', desc : '退款失败'}
    ]
};

Vue.filter('commFilter', function (val,type,def) {
    if(types[type]){
        for(var i =0 ; i< types[type].length; i++){
            if(types[type][i].type == val){
                return types[type][i].desc;
            }
        }
        return def ? def : '';
    }else{
        return '';
    }
});
Vue.filter('dateFormat', function (val,fmt) {
    return val ? new Date(val).Format(fmt) : '';
});

//所有html跳转带上版本时间,微信缓存问题
window.locationTo = function(url){
    var index = url.indexOf('?');
    if(index == -1){
        location.href = url + '?_r=' + $.version;
    }else{
        location.href = url.substr(0,index) + '?_r=' + $.version + '&' + url.substr(index + 1);
    }
};
window.replaceTo = function(url){
    var index = url.indexOf('?');
    if(index == -1){
        location.replace(url + '?_r=' + $.version);
    }else{
        location.replace(url.substr(0,index) + '?_r=' + $.version + '&' + url.substr(index + 1));
    }
};

}(window))

$(function() {
    FastClick.attach(document.body);
});

@@include('include/webService.js')
