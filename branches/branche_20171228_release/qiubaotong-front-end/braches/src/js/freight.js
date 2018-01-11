(function($){

var store = new Vuex.Store({
    state :{
        send_time : '',
        cityName : '',
        jAddress : '',
        jAddrId : '',
        dAddress : '',
        dAddrId : '',
        isJ : true
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

@@include('include/freight.js')
@@include('include/freight-city.js')
@@include('include/freight-starttime.js')

var app = new Vue({
    el: '#app',
    data: {
        currentView : 'freight_view',
    },
    events: {
        'view-change': function (view) {
            this.currentView = view;
        }
    },
    components: {
        'freight_view' : freight_view,
        'freight_city_view' : freight_city_view,
        'freight_starttime_view' : freight_starttime_view
    },
    store : store
});

}(Zepto))
