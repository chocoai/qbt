var coupon_view = Vue.extend({
    template : '#coupon',
    data : function(){
    	return {
    		tab : 1,
            coupons : [],
            coupon_input : '',
            total : 0, //用于接受#send页面传来的球包总价
            selCoupon : undefined
    	}
    }, 
    computed :{
        route_ident : function(){return this.$store.state.route_ident}
    },
    methods : {
    	goBack : function(view){
    		router.push(view);
    	},
        cancel : function(){
            window.sendTotal=undefined;
            window.couponInfo=undefined
            this.goBack('/send');
        },
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/myCoupon/coupons.api',
                success : function(data){
                    var datas=data.datas;
                    datas=datas.filter(function(m){
                        return m.status==1
                    });
                    self.coupons = datas;
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
        },
        checkCoupon : function(){
            if(this.coupon_input.length!=8){
                $.toast('请输入8位券号'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/myCoupon/valid_coupon.api',
                type : 'post',
                data :{
                    child_code : self.coupon_input,
                    amount : self.total
                },
                success : function(data){
                    var obj={
                        type : 2,
                        childCode : self.coupon_input,
                        chlidAmount : data.datas
                    }
                    window.couponInfo = obj;
                    self.goBack('/send');
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        selectCoupon : function(index)
        {
            this.selCoupon = index;
            if(this.coupons[index].status!=1) this.selCoupon=undefined;
        },
        useCoupon : function()
        {
            var self=this;
            if(self.selCoupon!=undefined)
            {
                var limitAmount=parseFloat(self.coupons[self.selCoupon].limitAmount);
                var _data=new Date();
                if(_data-self.coupons[self.selCoupon].startTime<0){
                    $.toast("该优惠券还未到开始使用时间!");
                    return;
                }
                if(self.total-limitAmount>=0)
                {
                    window.couponInfo=$.extend({type:1},self.coupons[self.selCoupon]);
                    window.sendTotal=undefined;//销毁window.sendTotal
                    self.goBack('/send');
                }
                else{
                   $.toast("您消费总额未满："+limitAmount+"元");
                }
            }else{
                $.toast("请先选择一张优惠券！");
            }
        }
    },
    activated : function(){
        var self=this;
        self.selCoupon=undefined;
        self.coupon_input="";
        self.tab=1;
        self.getList();
        //从路由/send到路由/send/coupon
        if(self.route_ident=="#send"){
            window.sendTotal && (self.total=parseFloat(window.sendTotal))
        }
        //设置路由标示
        setStore('route_ident',"#coupon");
    },
});
