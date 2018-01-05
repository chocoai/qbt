var track_detail_view = Vue.extend({
    template: '#track-detail',
    data : function(){
        return{
            way_list : []
        }
    },
    vuex :{
        getters :{
            info : function(state){ return state.order_detail}
        }
    },
    watch : {
        'info' : function(newVal){
            if(newVal){
                this.getBillway();
            }
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getBillway : function(){
            var self = this;
            $.commonAjax({
                url : '/order/way_bill.api',
                data : {
                    orderId : this.info.number
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
        }
    },
    ready : function(){
        this.getBillway();
    }
});
