var bag_applying_view = Vue.extend({
    template: '#bag-applying',
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
