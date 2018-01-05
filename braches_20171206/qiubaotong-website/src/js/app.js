;(function($){
    //生产环境
    $.baseUrl = "http://qbt.missionsky.cn:6047/qbt-web";
    $.bossUrl = 'http://qbt.missionsky.cn:6047/system-web';
    $.fBaseUrl = "http://qbt.missionsky.cn:6047/file";

    // $.baseUrl = "http://weixin.qiubaotong.com/api";
    // $.bossUrl = 'http://boss.qiubaotong.com/api';
    // $.fBaseUrl = "http://boss.qiubaotong.com/file";
    //测试环境
    //$.baseUrl = "http://testweixin.qiubaotong.com/api";
    //$.bossUrl = 'http://183.47.12.54:8200/api';
    //$.fBaseUrl = "http://testboss.qiubaotong.com/file";


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

    if(!String.prototype.startsWith){
        String.prototype.startsWith = function(prefix) {
           return this.slice(0, prefix.length) === prefix;
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

    $.ls = function(id,msg){
        if(msg != undefined){
            msg ? sessionStorage.setItem(id,msg) : sessionStorage.removeItem(id);
        }else{
            return sessionStorage.getItem(id);
        }
    };

}(jQuery || Zepto))

;(function($){

    $.comReg = {
        isPhone : function(val){
            return /(^(0[0-9]{2,3}-?)?[0-9]{7,8}$)|(^1[\d]{10}$)/g.test(val);
        },
        isMobile : function(val){
            return /^1[\d]{10}$/g.test(val);
        },
        IdCodeValid :function(code) {
            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",
            31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",
            44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",
            63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};

            if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
                return false;
            }

            if(!city[code.substr(0,2)]){
                return false;
            }
            //18位身份证需要验证最后一位校验位
            if(code.length == 18){
                //∑(ai×Wi)(mod 11)
                //加权因子
                var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                //校验位
                var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                var sum = 0;
                var ai = 0;
                var wi = 0;
                for (var i = 0; i < 17; i++)
                {
                    ai = code[i];
                    wi = factor[i];
                    sum += ai * wi;
                }
                var last = parity[sum % 11];
                if(parity[sum % 11] != code[17]){
                    return false;
                }
            }
            return true;
        }
    };
}(jQuery || Zepto))


;(function(){

var types = {
    idCardType : [
        {type : '1', desc : '身份证'},
        {type : '2', desc : '护照'}
    ]
};

$.Enums = types;

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

window.currency = function currency(value, _currency, decimals){
    value = parseFloat(value);
    if (!isFinite(value) || !value && value !== 0) return '';
    _currency = _currency != null ? _currency : '$';
    decimals = decimals != null ? decimals : 2;
    var stringified = Math.abs(value).toFixed(decimals);
    var _int = decimals ? stringified.slice(0, -1 - decimals) : stringified;
    var i = _int.length % 3;
    var head = i > 0 ? _int.slice(0, i) + (_int.length > 3 ? ',' : '') : '';
    var _float = decimals ? stringified.slice(-1 - decimals) : '';
    var sign = value < 0 ? '-' : '';
    return sign + _currency + head + _int.slice(i).replace(/(\d{3})(?=\d)/g, '$1,') + _float;
};

Vue.filter('currency',currency);

}(window))
