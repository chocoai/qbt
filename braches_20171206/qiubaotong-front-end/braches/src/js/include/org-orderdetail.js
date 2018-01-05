var org_orderdetail_view = Vue.extend({
    template: '#org-orderdetail',
    data : function(){
        return{
            tab : 1,
            pic : '',
            order_detail : {},
            way_list : [],
            order_detail_id : ''
        }
    },
    watch : {
        'order_detail_id' : function(val){
            if(val){
                this.getDetail();
            }
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getDetail : function(){
            this.order_detail = {};
            this.pic = '';
            this.way_list = [];
            var self = this;
            $.commonAjax({
                url : '/order/info.api',
                data : {
                    orderId : this.order_detail_id
                },
                success : function(data){
                    self.order_detail = data.datas;
                    self.getStatus(data.datas.orderStatus,data.datas.deliveryStatus);
                },
                error : function(err){
                    $.alert('订单查询失败');
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
        getStatus : function(o,d){
            // 1 待支付 2-待取包 3-运输中 4-签收
            if(o != 3){
                this.pic = 'ord-transport';
            }else{
                if(d == 1 || d == 2){
                    this.pic = 'ord-transport-2';
                }
                if(d == 3 || d == 4 || d == 5 || d == 6){
                    this.pic = 'ord-transport-3';
                }
                if(d == 7){
                    this.pic = 'ord-transport-4';
                }
            }
        }
    },
    route : {
        data : function(transition){
            var id = transition.to.params.id;
            this.order_detail_id = id;
        },
        deactivate : function(){
            this.order_detail_id = '';
        }
    },
    ready : function(){

    }
});
