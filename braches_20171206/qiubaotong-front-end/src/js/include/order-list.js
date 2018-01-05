var order_list_view = Vue.extend({
    template: '#order-list',
    data : function(){
        return{
            order_list1 : [], //全部
            order_list2 : [], //待支付
            order_list3 : [], //待签收
            order_list4 : [], //已签收
            hasNext : [false,false,false,false],
            isLoad : [false,false,false,false],
            busy : false
        }
    },
    vuex :{
        getters :{
            order_refresh : function(state){ return state.order_refresh},
            tab : function(state){return state.order_tab}
        }
    },
    watch : {
        'order_refresh' : 'refresh',
        'tab' : 'tabChange'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        refresh : function(){
            //初始化值
            this.hasNext = [false,false,false,false];
            this.isLoad = [false,false,false,false];
            this.order_list1 = [];
            this.order_list2 = [];
            this.order_list3 = [];
            this.order_list4 = [];
            this.getList(this.tab);
            //待支付，再刷新全部
            if(this.tab == 2){
                this.getList(1);
            }
        },
        tabChange : function(){
            //加载列表
            if(!this.isLoad[this.tab-1]){
                this.getList(this.tab);
            }
        },
        getList : function(type){
            var self = this;
            var url = (type == 1 || type == 2) ? '/order/cart_list.api' : '/order/list.api';
            $.commonAjax({
                url : url,
                type : 'post',
                data : {
                    orderStatus : type-1,
                    pageSize : 10
                },
                success : function(data){
                    self['order_list'+type] = data.datas;
                    self.hasNext[type-1] = data.page.hasNext;
                    self.isLoad[type-1] = true;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        getMore : function(type){
            if(this.tab != type) return;
            if(!this.hasNext[type-1]) return;
            var self = this;
            this.busy = true;
            var _list = this['order_list'+type];
            var url = (type == 1 || type == 2) ? '/order/cart_list.api' : '/order/list.api';
            $.commonAjax({
                url : url,
                type : 'post',
                data : {
                    orderStatus : type-1,
                    pageSize : 10,
                    lastRecordId : _list[_list.length - 1].id
                },
                success : function(data){
                    self['order_list'+type] = self['order_list'+type].concat(data.datas);
                    self.hasNext[type-1] = data.page.hasNext;
                    self.busy = false;
                },
                error : function(err){
                    $.toast(err);
                    self.busy = false;
                }
            });
        },
        detail : function(item){
            this.$route.router.go({name : 'detail', params : {id : item.number}});
        },
        detailPay : function(item){
            //正常
            // if(item.orderStatus == 1){
            //     if(item.payStatus == 1){
            //         this.$route.router.go({name : 'mpay', params : {id : item.number}});
            //     }else{
            //         if(item.quantity > 1){
            //             this.$route.router.go({name : 'sublist', params : {id : item.number}});
            //         }else{
            //             this.$route.router.go({name : 'detail', params : {id : item.subNumber}});
            //         }
            //     }
            // }else{
            //     if(item.quantity > 1){
            //         this.$route.router.go({name : 'sublist', params : {id : item.number}});
            //     }else{
            //         this.$route.router.go({name : 'detail', params : {id : item.subNumber}});
            //     }
            // }

            this.$route.router.go({name : 'sublist', params : {id : item.number}});
        },
        goPay : function(item){
            this.$route.router.go({name : 'mpay', params : {id : item.number}});
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
                            self['order_list'+self.tab].$remove(item);
                        });
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });
        },
        deleteBig : function(item){
            var self = this;
            $.confirm('确认删除该订单吗?',function(){
                $.commonAjax({
                    url : '/order/delete.api',
                    type : 'post',
                    data : {orderId : item.subNumber},
                    success : function(data){
                        $.alert('删除成功',function(){
                            self['order_list'+self.tab].$remove(item);
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
        cancelBig : function(item){
            var self = this;
            $.confirm('确认取消该订单吗?',function(){
                $.commonAjax({
                    url : '/order/cancel.api',
                    type : 'post',
                    data : {orderId : item.subNumber},
                    success : function(data){
                        $.alert('取消成功',function(){
                            item.orderStatus = 2; //订单关闭
                        });
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });
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
        },
        toggleTab : function(tab){
            setStore('order_tab',tab);
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
        evaluate : function(item){
            setStore('order_comment',item.number);
            this.goView('/comment');
        },
        comment_detail : function(item){
            setStore('order_comment_detail',item.number);
            this.goView('/commentdetail');
        }
    },
    ready : function(){
        this.getList(this.tab);
    }
});
