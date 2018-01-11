var org_sublist_view = Vue.extend({
    template: '#org-sublist',
    data : function(){
        return{
            order_list1 : [], //全部
            orderId : ''
        }
    },
    vuex :{
        getters :{
            order_type : function(state){ return state.order_type},
        }
    },
    watch : {
        'orderId' : function(newVal){
            if(newVal){
                this.getList(newVal);
            }
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getList : function(id){
            var self = this;
            $.commonAjax({
                url : '/order/sub_list.api',
                data :{
                    orderId : id
                },
                success : function(data){
                    self.order_list1 = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        detail : function(id,status){
            this.$route.router.go({name : 'detail', params : {id : id}});
        },
        delete : function(item){
            var self = this;
            $.confirm('确认删除该订单吗?',function(){
                $.commonAjax({
                    url : '/order/delete.api',
                    type : 'post',
                    data : {orderId : item.number},
                    success : function(data){
                        $.alert('删除成功',function(){
                            self.order_list1.$remove(item);
                        });
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });
        },
        cancel : function(item){
            var self = this;
            $.confirm('确认取消该订单吗?',function(){
                $.commonAjax({
                    url : '/order/cancel.api',
                    type : 'post',
                    data : {orderId : item.number},
                    success : function(data){
                        $.alert('取消成功',function(){
                            item.orderStatus = 5; //用户取消
                        });
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });
        },
        showDelete : function(o,d){
            if(o == 3 && d != 7){
                return false;
            }
            return true;
        },
        showCancel : function(o,d){
            if((o == 5 || o == 6 || o == 7 || d == 7) || (o == 3 && d != 1 && d != 2)){
                return false;
            }
            return true;
        },
        redo : function(number,type){
            $.commonAjax({
                url : '/order/info.api',
                data : {
                    orderId : number
                },
                success : function(data){
                    $.ls('redoAddr',JSON.stringify(data.datas));
                    $.ls('redoAddrType',type);
                    locationTo('index_v1.html');
                },
                error : function(err){
                    $.alert('订单查询失败');
                }
            });
        }
    },
    route : {
        data : function(transition){
            var id = transition.to.params.id;
            this.orderId = id;
        }
    },
    ready : function(){
        // this.getList();
    }
});
