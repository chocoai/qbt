var send_care_view = Vue.extend({
    template: '<section class="section">'+
                '<div class="header tex-c" >'+
                  '<a href="javascript:;" class="back" @tap="$route.router.go(\'/\')"><img src="/img/back.png" /></a>'+
                  '寄球包注意事项'+
                '</div>'+
                '<div id="careTpl" class="scroll"></div>'+
              '</section>',
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        }
    },
    ready : function(){
        $('#careTpl').load('care.html #care');
    }
});
var send_danger_view = Vue.extend({
    template: '<section class="section">'+
                '<div class="header tex-c" >'+
                  '<a href="javascript:;" class="back" @tap="$route.router.go(\'/\')"><img src="/img/back.png" /></a>'+
                  '违禁品清单'+
                '</div>'+
                '<div id="careTpl" class="scroll"></div>'+
              '</section>',
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        }
    },
    ready : function(){
        $('#careTpl').load('care.html #danger');
    }
});
