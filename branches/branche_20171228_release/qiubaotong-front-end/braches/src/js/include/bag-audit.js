var bag_audit_view = Vue.extend({
    template: '#bag-audit',
    data : function(){
        return{

        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        }
    },
    ready : function(){

    }
});
