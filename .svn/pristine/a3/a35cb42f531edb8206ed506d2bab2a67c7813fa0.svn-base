(function($){

if(!$.weixinAuth()){
   return;
};

Vue.filter('currency',function(value, _currency, decimals) {
    value = parseFloat(value);
    if (!isFinite(value) || !value && value !== 0) return '';
    _currency = _currency != null ? _currency : '$';
    decimals = decimals != null ? decimals : 2;
    var stringified = Math.abs(value).toFixed(decimals);
    var _int = decimals ? stringified.slice(0, -1 - decimals) : stringified;
    var i = _int.length % 3;
    var head = i > 0 ? _int.slice(0, i) + (_int.length > 3 ? ',' : '') : '';
    var _float = decimals ? stringified.slice(-1 - decimals) : '';
    var sign = value < 0 ? '-' : '';
    return sign + _currency + head + _int.slice(i).replace(/(\d{3})(?=\d)/g, '$1,') + _float;
});



var store = new Vuex.Store({
    state :{
        geo_lat : '',//纬度
        geo_long : '',//经度
        isJ : true, //寄 ？ 收
        route_ident : '', //路由标识
        //寄件信息
        send_addr : {
            type : 1, //寄件地址类型 1地址 2球场 3站点
            name : '',
            mobile : '',
            address : '',
            real_address : '',
            treePath: '',
            areaId : '',
            addr_type : '', //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
            addr_id : '',
            remark : '',
            tabStyle : 1, //记录寄件信息的选择地址类型 1-常用地址 2-球场 3-机场
            treeId : '',
            siteName : '',
            label_type:3,//常用地址类别 1-家 2-公司 3-其他
            isOutRange : false //是否偏远地址
        },
        //收件信息
        collect_addr : {
            type : 2, //收件地址类型 1地址 2球场 3站点
            name : '',
            mobile : '',
            address : '',
            real_address : '',
            treePath: '',
            areaId : '',
            addr_type : '', //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
            addr_id : '',
            remark : '',
            tabStyle : 1, //记录收件信息的选择地址类型 1-常用地址 2-球场 3-机场
            treeId : '',
            siteName : '',
            label_type:3,//常用地址类别 1-家 2-公司 3-其他
            isOutRange : false //是否偏远地址

        },
        addrMsg:{},//获取选择的地址信息
        addr:{},//新增修改地址信息
        //微信用户信息
        user_info : {
            name : '',
            mobile : ''
        },
        tab:1,//选择的地址类型 1-常用地址 2-球场 3-机场
        label_type:3,//常用地址类别 1-家 2-公司 3-其他
        tabStyle:1,
        isAddr:true, //[true address] [false address course airport]
        orderStatus : 1, //0-全部 1-待支付 2-运输中 3-已签收 4-待取件
        orderDetail : 2 //订单详情页的展示类型 0-不显示切换头默认展示订单详情内容 1-订单详情 2-球包位置
    },
    mutations : {
        SETVAL : function(state,value){
            state[value.key] = value.value;
        }
    }
});

function setStore(para,val){
    store.commit('SETVAL',{key : para,value : val});
};

@@include('v3/index.js')
@@include('v3/send.js')
@@include('v3/coupon.js')
@@include('v3/index_price.js')
@@include('v3/isend.js')
@@include('v3/address.js')
@@include('v3/addrs_his.js')
@@include('v3/addrs_course.js')
@@include('v3/edita.js')
@@include('v3/pay.js')
@@include('v3/order-detail.js')
@@include('v3/order-list.js')
@@include('v3/agreement.js')
@@include('v3/success.js')

Vue.component("tab", vuxTab);
Vue.component("tab-item", vuxTabItem);
Vue.component("popup-picker", vuxPopupPicker);
Vue.component("popup", vuxPopup);
Vue.component("load-more", vuxLoadMore);
Vue.component("scroller", vuxScroller);
Vue.component("timeline", vuxTimeline);
Vue.component("confirm", vuxConfirm);
Vue.component("datetime", vuxDatetime);
Vue.component("swiper", vuxSwiper);

Vue.component("tel-contact",{
    template:'<div @touchstart="_touchstart($event)" @touchmove="_touchmove($event)" @touchend="_touchend($event)" id="call_phone" style="display: inline-block;z-index:499;position:fixed;left:0;bottom:60px;width:70px;height:70px">\
                <a href="tel:400-609-0990">\
                    <img width="70" src="/img/call.png">\
                </a>\
              </div>',
    data  : function(){
        return {
            translateL : 0,
            translateT : 0,
            touchX : 0,
            touchY : 0,
            l : 0,
            t : 0
        }
    },
    methods : {
        _touchstart : function(event){
            var self=this,obj=self.$el;
             if(event.targetTouches.length == 1)
             {
                var touch = event.targetTouches[0];
                self.touchX=touch.pageX-obj.offsetLeft-self.translateL;
                self.touchY=touch.pageY-obj.offsetTop-self.translateT;
             }
        },
        _touchmove : function(event){
            var self=this;
            event.preventDefault();
            if(event.targetTouches.length == 1)
            {
                var touch = event.targetTouches[0];
                var obj=self.$el,l,t;
                var l=touch.pageX-self.touchX-obj.offsetLeft,t=touch.pageY-self.touchY-obj.offsetTop;
                if(l<-obj.offsetLeft) l=-obj.offsetLeft;
                else if(l>document.documentElement.clientWidth-obj.offsetLeft-obj.offsetWidth) l=document.documentElement.clientWidth-obj.offsetLeft-obj.offsetWidth;
                else{};
                if(t+obj.offsetTop<0){t=-obj.offsetTop}
                else if(t>document.documentElement.clientHeight-obj.offsetTop-obj.offsetHeight){t=document.documentElement.clientHeight-obj.offsetTop-obj.offsetHeight}
                else {}

                self.l=l;
                self.t=t;
                obj.style.webkitTransform="translate("+l+"px,"+t+"px)";
                obj.style.mozTransform="translate("+l+"px,"+t+"px)";
                obj.style.oTransform="translate("+l+"px,"+t+"px)";

            }
        },
        _touchend : function(event){
            window.event.returnValue = true;
            var obj=this.$el;
            this.translateL=this.l;
            this.translateT=this.t;
            obj.removeEventListener('touchstart',function(event){},false);
            obj.removeEventListener('touchmove',function(event){},false);
        }

    },
    activated : function()
    {
        var obj=this.$el;
        this.translateL=0;
        this.translateT=0;
        obj.style.webkitTransform="translate(0px,0px)";
        obj.style.mozTransform="translate(0px,0px)";
        obj.style.oTransform="translate(0px,0px)";
    }
});

var router = new VueRouter({
    routes: [
        {path : '/' ,component : home_view, meta : '球包通'},
        {path : '/send' ,component : send_view},
        {path : '/send/coupon' ,component : coupon_view},
        {path : '/index_price' ,component : home_price_view},
        {path : '/isend' ,component : home_send_view},
        {path : '/isend/address' ,component : home_address_view},
        {path : '/isend/address/addrs_his' ,component : address_his_select_view},
        {path : '/isend/address/addrs_course' ,component : address_course_select_view},
        {path : '/isend/address/addrs/edita' ,component : address_add_edit_view},
        {path : '/pay/:id' ,component : pay_view},
        {path : '/order' ,component : order_list_view},
        {path : '/order/:id' ,component : order_detail_view},
        {path : '/agreement' ,component : qbt_agreement_view},
        {path : '/care' ,component : qbt_care_view},
        {path : '/success/:arrivetime/:orderId' ,component : success_view}
    ]
});

router.beforeEach(function(to,from,next){
    typeof(to.meta) === 'string' && $.setTitle(to.meta);
    next();
});

router.afterEach(function(to,from){
    $("#_loading").hide();
});

var app = new Vue({
    data : {
        transitionName : 'fadeInLeft'
    },
    watch : {
        "$route" : function(to,from){
            var toDepth = to.path.split('/').length;
            var fromDepth = from.path.split('/').length;
            this.transitionName = toDepth < fromDepth ? 'fadeOutRight' : 'fadeInLeft';
        }
    },
    router : router,
    store : store
}).$mount('#app');

}(Zepto))

//电话联系浮动图标兼容性处理
;(function($)
{
    $(document).ready(function()
    {
        var docClientH=document.documentElement.clientHeight;
        if(!$.os.ios)
        {
            $(window).resize(function(){
                var dClientH=document.documentElement.clientHeight;
                if(dClientH<docClientH)
                {
                    $("#call_phone").css("display","none");               
                }else
                {

                    $("#call_phone").css("display","block"); 
                }
            });
        }    
    });

}(Zepto))
