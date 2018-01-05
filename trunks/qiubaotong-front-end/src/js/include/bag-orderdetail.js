var bag_orderdetail_view = Vue.extend({
    template: '#bag-orderdetail',
    data : function(){
        return{
            remark : ''
        }
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;},
            applyType : function(state){ return state.applyType;},
            applyName : function(state){ return state.applyName;},
            order_detail : function(state){ return state.order_detail;},
            order_type : function(state){ return state.order_type;}
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        back : function(){
            setStore('order_refresh',new Date().getTime());
            this.goView('bag_orderlist_view');
        },
        delivery : function(type,optType){
            if(type == 2 && !this.remark){
                $.toast('请输入备注'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/assistant/delivery.api',
                type : 'post',
                data : {
                    orderId : this.order_detail.number,
                    applyId : this.applyId,
                    applyType : this.applyType,
                    type : this.order_type,
                    remark : this.remark,
                    optType : optType || '1'
                },
                success : function(){
                    self.remark = "";
                    self.back();
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    ready : function(){

    }
});
