var org_menu_view = Vue.extend({
    template: '#org-menu',
    data : function(){
        return {
            applyName : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        goList : function(type){
            this.$route.router.go({name : 'list', params : {type : type}});
        },
        goIndex : function(){
            locationTo('index_v1.html');
        }
    },
    ready : function(){
        var applyName = $.ls('applyName');
        if(applyName){
            this.applyName = applyName;
        }else{
            var self = this;
            $.commonAjax({
                url : '/assistant/query_assistant.api',
                success : function(data){
                    $.ls('applyId',data.datas.applyId);
                    $.ls('applyName',data.datas.applyName);
                    $.ls('applyType',data.datas.applyType);
                    self.applyName = data.datas.applyName;
                }
            });
        }
    }
});
