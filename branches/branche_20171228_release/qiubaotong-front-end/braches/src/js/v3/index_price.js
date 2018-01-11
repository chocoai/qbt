var home_price_view = Vue.extend({
    template : '#index_price',
    methods : {
    	goView : function(){
    		router.push('/isend');
    	},
    	goBack: function(){
    		history.back();
    	},
        baggage : function(){
             location.href="tel:400-609-0990";
            //$.toast('寄行李服务稍后推出！');
        }
    }
});
