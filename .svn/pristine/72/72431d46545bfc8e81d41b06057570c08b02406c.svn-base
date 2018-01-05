var setting_view = Vue.extend({
    template: '#setting-menu',
    data : function(){
        return{
            ads : [],
            fbaseUrl : ''
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        goNav : function(url){
            locationTo(url);
        },
        getAds : function(){
            var self = this;
            $.commonAjax({
                url : '/baseAdv/list.api',
                loading : false,
                data :{
                    type : 'wx',
                    position : 'set'
                },
                success : function(data){
                    self.ads = data.datas;
                    self.$nextTick(function () {
                        self.initSwiper();
                    })
                }
            });
        },
        initSwiper : function(){
            var swiper = new Swiper('.swiper-container', {
                  pagination: '.swiper-pagination',
                  paginationClickable: true,
                  loop: true,
                  width: document.body.clientWidth,
                  autoplay:3000,
                  autoplayDisableOnInteraction : false,
                  onTap: function(swiper){
                      if(swiper.clickedSlide){
                         var url = $(swiper.clickedSlide.firstChild).attr('data-src');
                         if(url){
                             location.href = url;
                         }
                      }
                  }
            });
        }
    },
    ready : function(){
        this.fbaseUrl = $.fbaseUrl;
        this.getAds();
    }
});
