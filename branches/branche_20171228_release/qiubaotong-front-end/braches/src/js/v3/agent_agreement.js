var qbt_agreement_view = Vue.extend({
    template: '<section class="section bg_agreement">'+
                '<div class="header tex-c">'+
                  '<a href="javascript:;" class="back" @click="goBack"><img src="/img/back.png" /></a>'+
                  '球包通服务协议'+
                '</div>'+
                '<div id="agreementTpl" class="scroll"></div>'+
              '</section>',
    data : function(){
        return {
            prevRouteID : ''
        }
    },
    computed :{
        route_ident : function(){return this.$store.state.route_ident}
    },
    methods : {
        goBack : function(){
            var self=this;
            if(self.prevRouteID=='#agent_send')
            {
                router.push('/agent_send');
            }else if(self.prevRouteID=='#agent_pay')
            {
                history.back();
            }else{
                location.href='index.html#/';
            }
        }
    },
    activated : function(){
        var self=this;
        $('#agreementTpl').load('agreement.html #agreement');
        if(self.route_ident=='#agent_send'){
            self.prevRouteID='#agent_send';
        }else if(self.route_ident=='#agent_pay'){
            self.prevRouteID='#agent_pay';
        }else{
            self.prevRouteID="/";
        }

        //设置路由标示
        setStore('route_ident',"#agreement");
    }
});

var qbt_care_view = Vue.extend({
    template: '<section class="section bg_agreement">'+
                '<div class="header tex-c" >'+
                  '<a href="javascript:;" class="back" @click="goBack"><img src="/img/back.png" /></a>'+
                  '寄球包注意事项'+
                '</div>'+
                '<div id="careTpl" class="scroll"></div>'+
              '</section>',
    data : function(){
        return {
            prevRouteID : ''
        }
    },
    computed :{
        route_ident : function(){return this.$store.state.route_ident}
    },
    methods : {
        goBack : function(){
            var self=this;
            if(self.prevRouteID=='#agent_send')
            {
                router.push('/agent_send');
            }else if(self.prevRouteID=='#agent_pay')
            {
                history.back();
            }else{
                location.href='index.html#/';
            }
        }
    },
    activated : function(){
        var self=this;
        $('#careTpl').load('care.html #care');
        if(self.route_ident=='#agent_send'){
            self.prevRouteID='#agent_send';
        }else if(self.route_ident=='#agent_pay'){
            self.prevRouteID='#agent_pay';
        }else{
            self.prevRouteID="/";
        }

        //设置路由标示
        setStore('route_ident',"#care");
    }
});
