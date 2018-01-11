var order_coupon_view = Vue.extend({
    template: '#order-coupon',
    data : function(){
        return{
          coupons : [],
          coupons_used : [],
          coupons_expire : [],
          coupon_input : '',
          order_amt : ''
        }
    },
    vuex :{
        getters :{
            coupon_refresh : function(state){ return state.coupon_refresh},
            tab : function(state){return state.coupon_tab},
            coupon_use : function(state){return state.coupon_use}
        }
    },
    watch : {
        'coupon_refresh' : 'getList'
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/myCoupon/list.api',
                success : function(data){
                    var arr1 = [];
                    var arr2 = [];
                    var arr3 = [];
                    for(var i = 0; i < data.datas.length; i++){
                        var item = data.datas[i];
                        if(item.status == 1){
                            arr1.push(item);
                        }else if(item.status == 2){
                            arr2.push(item);
                        }else if(item.status == 3){
                            arr3.push(item);
                        }
                    }
                    self.coupons = arr1;
                    self.coupons_used = arr2;
                    self.coupons_expire = arr3;
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
            if($.ls('usecoupon')){
                this.order_amt = Number($.ls('usecoupon'));
            }
        },
        goBack : function(){
            if($.ls('usecoupon')){
                $.ls('usecoupon','');
                history.back();
            }else{
                this.goView('/');
            }
        },
        use : function(item){
            if($.ls('usecoupon')){
                var amt = Number($.ls('usecoupon'));
                if(item.limitAmount > 0 && amt < item.limitAmount){
                    $.toast('该券需满' + item.limitAmount + '元可使用');
                    return;
                }
                if(amt >  item.chlidAmount){
                    amt = item.chlidAmount;
                }
                $.ls('usecoupon','');
                var coupon = {
                    childCode : item.childCodes[0],
                    chlidAmount : item.chlidAmount,
                    realAmt : amt,
                    type : 2
                };
                setStore('coupon_use',coupon);
                history.back();
            }else{
                //locationTo('index_v1.html');
                locationTo('index.html');
            }
        },
        toggleTab : function(tab){
            setStore('coupon_tab',tab);
        }
    },
    route : {
        deactivate : function(){
            this.order_amt = '';
        }
    },
    ready : function(){
       this.getList();
    }
});
