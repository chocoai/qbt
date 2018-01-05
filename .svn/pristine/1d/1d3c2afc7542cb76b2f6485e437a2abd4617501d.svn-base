var order_detail_view = Vue.extend({
    template : '#orderDetailTpl',
    data : function(){
        return {
            order_detail : {},
            order_detail_id : '',
            way_list : [],
        }
    },
    computed :{
        orderStatus : function(){return this.$store.state.orderStatus},
        orderDetail : function(){return this.$store.state.orderDetail}
    },
    filters :{
        orderType : function(val){
            var obj={
                0 : "全部",
                1 : "待支付",
                2 : "运输中",
                3 : "已签收",
                4 : "待取件"
            }
            return obj[val]
        }
    },
    methods : {
        getDetail : function(){
            this.order_detail = {};
            this.way_list = [];
            var self = this;
            $.commonAjax({
                url : '/order/info.api',
                data : {
                    orderId : this.order_detail_id
                },
                success : function(data){
                    self.order_detail = data.datas;
                },
                error : function(err){
                    $.toast('订单查询失败');
                }
            });
            $.commonAjax({
                url : '/order/way_bill.api',
                data : {
                    orderId : this.order_detail_id
                },
                success : function(data){
                    if(data.datas.length == 0){
                        var item = [{
                            remark : '暂无物流信息'
                        }];
                        self.way_list = item;
                    }else{
                        self.way_list = data.datas;
                    }

                }
            });
        },
        switchTob : function(index)
        {
            setStore('orderDetail',index);
        },
        goBack: function(){
            router.push('/order');
        }
    },
    activated : function(){
        this.order_detail_id = this.$route.params.id;
        this.getDetail();
    },
    mounted : function(){
    }
});
