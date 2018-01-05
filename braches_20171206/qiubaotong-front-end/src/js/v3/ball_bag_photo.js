var ball_bag_photo_view = Vue.extend({
    template : '#ball_bag_photo',
    methods : {
        //返回上一个组件
        getBack : function (){
    		router.go(-1);
        },
    }
});