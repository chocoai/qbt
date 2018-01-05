(function($){

if(!$.weixinAuth()){
   return;
};

var store = new Vuex.Store({
    state :{
        send_time : '', //取包时间
        geo_province : '', //定位省
        geo_city : '', //定位城市
        geo_city2 : '', //手工定位城市
        geo_district : '',//定位区
        geo_addr : '', //定位地址
        geo_lat : '',//纬度
        geo_long : '',//经度
        isJ : true, // 寄 ? 收
        //寄件信息
        send_addr : {
            type : 1, //寄件地址类型 1地址 2球场 3站点
            name : '',
            mobile : '',
            address : '',
            real_address : '',
            areaId : '',
            addr_type : '', //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
            addr_id : '',
            remark : ''
        },
        //收件信息
        collect_addr : {
            type : 2, //收件地址类型 1地址 2球场 3站点
            name : '',
            mobile : '',
            address : '',
            real_address : '',
            areaId : '',
            addr_type : '', //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
            addr_id : '',
            remark : ''
        },
        court_city : '', //球场城市
        court_search_type : '',//球场查询类型 1按城市 2快速搜索
        addr_province : '', //地址 省
        addr_city : '',//地址 市
        addr_district : '',//地址 区
        addr_street : '',//地址 街道
        useraddr_refresh : ''
    },
    mutations : {
        SETVAL : function(state,para,val){
            state[para] = val;
        }
    }
});

function setStore(para,val){
    store.dispatch('SETVAL',para,val);
};

@@include('include/send.js')
//选择地址
@@include('include/send-address.js')
//城市选择
@@include('include/send-addrcity.js')
//城市选择
@@include('include/send-city.js')
//球场选择
@@include('include/send-court.js')
//站点选择
@@include('include/send-station.js')
//时间选择
@@include('include/send-starttime.js')
//修改联系人
@@include('include/send-contact.js')
//新建地址
@@include('include/send-newaddr.js')
//球包通服务协议
@@include('include/send-agreement.js')
//注意事项
@@include('include/send-care.js')

var app = Vue.extend({
    components: {
        'send_view' : send_view,
        'send_address_view' : send_address_view,
        'send_court_view' : send_court_view,
        'send_station_view' : send_station_view,
        'send_starttime_view' : send_starttime_view,
        'send_city_view' : send_city_view,
        'send_contact_view' : send_contact_view,
        'send_newaddr_view' : send_newaddr_view,
        'send_agreement_view' : send_agreement_view,
        'send_care_view' : send_care_view,
        'send_addrcity_view' : send_addrcity_view,
        'send_danger_view' : send_danger_view
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/': {
        component: send_view
    },
    '/address': {
        component: send_address_view
    },
    '/court': {
        component: send_court_view
    },
    '/station': {
        component: send_station_view
    },
    '/starttime': {
        component: send_starttime_view
    },
    '/city': {
        component: send_city_view
    },
    '/contact': {
        component: send_contact_view
    },
    '/newaddr': {
        component: send_newaddr_view
    },
    '/agreement': {
        component: send_agreement_view
    },
    '/care': {
        component: send_care_view
    },
    '/addrcity': {
        component: send_addrcity_view
    },
    '/danger': {
        component: send_danger_view
    },
    '*' : {
        component: send_view
    }
});
router.start(app, '#app');

}(Zepto));
