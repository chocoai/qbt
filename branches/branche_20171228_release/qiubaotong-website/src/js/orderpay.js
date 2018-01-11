(function($){

var app = new Vue({
    data : {
        detail : {},
        pay_url : '',

        fBaseUrl : $.fBaseUrl,
        intervalId : '',

        jPoint : '',
        dPoint : '',

    },
    methods : {
        getDetail : function(orderId){
            var _this = this;
            $.get($.baseUrl + '/official/order_detail.api',{orderNumber : orderId}).success(function(data){
                if(data.code == '0000'){
                    if(data.datas){
                        if(data.datas.orderStatus == 1 && data.datas.payStatus == 1){
                            _this.detail = data.datas;
                            _this.getPayCode();
                            _this.getOrderStatus();
                            _this.getPoint(data.datas.jTreePath.split(',')[1],data.datas.dTreePath.split(',')[1]);
                        }else{
                            layer.alert('订单已支付或已关闭',{closeBtn:0},function(){
                                location.href = 'order.html';
                            });
                        }
                    }else{
                        layer.alert('订单不存在',{closeBtn:0},function(){
                            location.href = 'order.html';
                        });
                    }
                }else{
                    layer.msg(data.msg);
                }
            }).fail(function(){
                layer.msg('网络繁忙，请稍后再试');
            });
        },
        getPayCode : function(){
            var _this = this;
            $.get($.baseUrl + '/official/pay.api',{orderNumber : this.detail.number}).success(function(data){
                _this.pay_url = data.datas;
            }).fail(function(){
                layer.msg('网络繁忙，请稍后再试');
            });
        },
        getOrderStatus : function(){
            var _this = this;
            this.intervalId = setInterval(function(){
                $.get($.baseUrl + "/official/order_pay_status.api",{orderNumber : _this.detail.number}).success(function(data){
                    if(data.datas.payStatus == 2){
                        clearInterval(_this.intervalId);
                        layer.closeAll();

                        var map = new BMap.Map("bmap");
                        map.centerAndZoom(_this.detail.jTreePath.split(',')[1], 5);
                    	map.enableScrollWheelZoom();
                    	var points = [_this.jPoint,_this.dPoint];

                    	var curve = new BMapLib.CurveLine(points, {strokeColor:"blue", strokeWeight:3, strokeOpacity:0.5});
                    	map.addOverlay(curve);

                        layer.open({
                            type : 1,
                            content : $('#paysucess'),
                            area : ['750px','auto'],
                            end : function(){
                                location.href = 'order.html';
                            }
                        });

                    }
                    if(data.datas.orderStatus == 2){
                        clearInterval(_this.intervalId);
                        layer.alert('订单已关闭',{closeBtn:0},function(){
                            location.href = 'order.html';
                        });
                    }
                });
            },5000);
        },
        getPoint : function(jcity,dcity){
            var _this = this;
            var myGeo = new BMap.Geocoder();
            myGeo.getPoint(jcity,function(point){
                _this.jPoint = point;
            });
            myGeo.getPoint(dcity,function(point){
                _this.dPoint = point;
            });
        }
    },
    mounted : function(){

        var id = $.getQueryString('order');
        if(id){
            this.getDetail(id);
        }else{
            location.href = 'order.html';
        }

    }
}).$mount('#app');

}(jQuery || Zepto));
