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
            remark : '',
            cityName : ''
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
            remark : '',
            cityName : ''
        },
        court_city : '', //球场城市
        court_search_type : '',//球场查询类型 1按城市 2快速搜索
        addr_province : '', //地址 省
        addr_city : '',//地址 市
        addr_district : '',//地址 区
        addr_street : '',//地址 街道
        useraddr_refresh : '',

        addr_edit : {cityName:''},
        cityName : '',
        user_msg : {},
        //代下单用户
        agent_userId : '',
        agent_name : '',
        agent_mobile : ''
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

@@include('include/send-agent.js')
//选择地址
@@include('include/agent-address.js')
//城市选择
@@include('include/send-addrcity.js')
//城市选择
@@include('include/agent-city.js')
//球场选择
@@include('include/agent-court.js')
//站点选择
@@include('include/agent-station.js')
//时间选择
@@include('include/send-starttime.js')
//修改联系人
@@include('include/send-contact.js')
//球包通服务协议
@@include('include/send-agreement.js')
//注意事项
@@include('include/send-care.js')
//地址新增
@@include('include/agent-newaddr.js')
@@include('include/address-city.js')
//搜索客户
@@include('include/agent-user-search.js')

var app = Vue.extend({
    components: {
        'send_agent_view' : send_agent_view,
        'agent_address_view' : agent_address_view,
        'agent_court_view' : agent_court_view,
        'agent_station_view' : agent_station_view,
        'send_starttime_view' : send_starttime_view,
        'agent_city_view' : agent_city_view,
        'send_contact_view' : send_contact_view,
        'send_agreement_view' : send_agreement_view,
        'send_care_view' : send_care_view,
        'send_addrcity_view' : send_addrcity_view,
        'send_danger_view' : send_danger_view,
        'address_city_view' : address_city_view,
        'agent_user_search_view' : agent_user_search_view,
        'agent_newaddr_view' : agent_newaddr_view
    },
    store : store
});

var router = new VueRouter();
router.map({
    '/': {
        component: send_agent_view
    },
    '/address': {
        component: agent_address_view
    },
    '/court': {
        component: agent_court_view
    },
    '/station': {
        component: agent_station_view
    },
    '/starttime': {
        component: send_starttime_view
    },
    '/city': {
        component: agent_city_view
    },
    '/contact': {
        component: send_contact_view
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
    '/newaddr': {
        component: agent_newaddr_view
    },
    '/cityaddr': {
        component: address_city_view
    },
    '/usersearch':{
        component : agent_user_search_view
    },
    '*' : {
        component: send_agent_view
    }
});
router.start(app, '#app');

}(Zepto));
