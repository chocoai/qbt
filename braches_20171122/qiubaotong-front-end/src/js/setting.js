(function($){
    
if(!$.weixinAuth()){
   return;
};

@@include('include/setting-menu.js')
@@include('include/setting-complaint.js')
var app = new Vue({
    el: '#app',
    data: {
        currentView : 'setting_view'
    },
    methods: {
        goNav : function(url){
            locationTo(url);
        }
    },
    events: {
        'view-change': function (view) {
            this.currentView = view;
        }
    },
    ready: function() {

    },
    components: {
        'setting_view' : setting_view,
        'setting_compiaint_view' : setting_compiaint_view
    }
});



}(Zepto))
