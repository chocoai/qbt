var success_view = Vue.extend({
    template : '#success',
    data : function(){
        return {
            adate : '',
            atime : '',
            showDanger : false,
            isWin : false
        }
    },
    filters : {
        // timeFilter : function(val){
        //     var mdata={
        //         0 : '周日',
        //         1 : '周一',
        //         2 : '周二',
        //         3 : '周三',
        //         4 : '周四',
        //         5 : '周五',
        //         6 : '周六'
        //     }
        //     return mdata[val]
        // }
    },
    methods : {
        goV2Nav : function(url,hach){
            var _url=location.href;
            _url=_url.replace(location.hash,'');
            var index = _url.indexOf('?');
            var hx="";
            hach && (hx=hach);
            if(index == -1){
                location.href = _url + '?_r=' + $.version;
            }else{
                location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1)+ '&orderstatus=4' + '#' + hx;
            }
        },
        goNav : function(url){
            locationTo(url);
        },
        compatible_ios_show : function()
        {
            $(".page").css("overflow","hidden");
        },
        compatible_ios_hide : function(){
            $(".page").css("overflow","auto");
        }
    },
    activated : function(){
        var self=this;
        var _timeA=self.$route.params.arrivetime.split(" ")[0];
        var _timeB=self.$route.params.arrivetime.split(" ")[1];
        _timeA=_timeA.replace(/\-/g,"/");
        var myDate=new Date(_timeA);
        var month=myDate.getMonth();
        var day=myDate.getDate();
        var _week=myDate.getDay(); 
        var orderId=self.$route.params.orderId;
        self.adate=(month+1)+'月'+day+'日';
        self.atime=_timeB;

        //获取中奖信息
        $.commonAjax({
                url : '/order/v2/isWinner.api',
                type : 'get',
                data : {
                    orderId : orderId
                },
                success : function(data){
                    self.isWin=data.datas
                },
                error : function(err){
                    $.toast(err);
                }
            });
    },
    mounted : function(){

    }
});
