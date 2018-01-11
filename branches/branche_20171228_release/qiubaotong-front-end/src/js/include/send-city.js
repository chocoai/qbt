var send_city_view = Vue.extend({
    template: '#send-city',
    data : function(){
        return{
            c_citys : ['北京','上海','深圳','广州','天津','昆明','青岛','三亚'],
            city_list : [],
            provice_selected : '',
            city_selected : '',
            ads : [],
            fbaseUrl : '',
            course : [],
            name : '',
            mobile : '',
            course_finished : false
        }
    },
    vuex : {
        getters : {
            geo_city : function(state){ return state.geo_city || '定位中..'},
            isJ : function(state){ return state.isJ;},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr}
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        toggle : function(name){
            if(this.provice_selected == name){
                this.provice_selected = '';
            }else{
                this.provice_selected = name;
            }
        },
        selectCity : function(name){
            if(!name) return;
            setStore('court_city',name);
            setStore('court_search_type','1');
            this.goView('/court');
        },
        quickSearch : function(){
            setStore('court_city','');
            setStore('court_search_type','2');
            this.goView('/court');
        },
        getAds : function(){
            var self = this;
            $.commonAjax({
                url : '/baseAdv/list.api',
                loading : false,
                data :{
                    type : 'wx',
                    position : 'course'
                },
                success : function(data){
                    self.ads = data.datas;
                    if(data.datas.length > 1){
                        self.$nextTick(function () {
                            self.initSwiper();
                        })
                    }
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
        },
        getCourse : function(){
            var self = this;
            $.commonAjax({
                url : '/user/query_course.api',
                success : function(data){
                    self.course = data.datas;
                    self.course_finished = true;
                },
                error : function(){
                    self.course_finished = true;
                }
            });
        },
        save : function(item){
            if(this.isJ){
                this.send_addr.type = 2;
                this.send_addr.address = item.name;
                //有用户信息
                if(this.name || this.mobile){
                    this.send_addr.name = this.name;
                    this.send_addr.mobile = this.mobile;
                }else{
                    //取收件
                    if(this.collect_addr.name && this.collect_addr.mobile){
                        this.send_addr.name = this.collect_addr.name;
                        this.send_addr.mobile = this.collect_addr.mobile;
                    }else{
                        this.send_addr.name = '';
                        this.send_addr.mobile = '';
                    }
                }
                this.send_addr.real_address = item.address;
                this.send_addr.areaId = item.areaId;
                this.send_addr.addr_type = '1';
                this.send_addr.addr_id = item.id;
                //提示
                this.send_addr.remark = (item.isOutRange && item.isTip) ? item.wechatTip : '';

                if(!this.send_addr.name || !this.send_addr.mobile){
                    this.goView('/contact');
                }else{
                    this.goView('/');
                }
            }else{
                this.collect_addr.type = 2;
                this.collect_addr.address = item.name;
                //有用户信息
                if(this.name || this.mobile){
                    this.collect_addr.name = this.name;
                    this.collect_addr.mobile = this.mobile;
                }else{
                    //取寄件
                    if(this.send_addr.name && this.send_addr.mobile){
                        this.collect_addr.name = this.send_addr.name;
                        this.collect_addr.mobile = this.send_addr.mobile;
                    }else{
                        this.collect_addr.name = '';
                        this.collect_addr.mobile = '';
                    }
                }
                this.collect_addr.real_address = item.address;
                this.collect_addr.areaId = item.areaId;
                this.collect_addr.addr_type = '1';
                this.collect_addr.addr_id = item.id;
                //提示
                this.collect_addr.remark = (item.isOutRange && item.isTip) ? item.wechatTip : '';

                if(!this.collect_addr.name || !this.collect_addr.mobile){
                    this.goView('/contact');
                }else{
                    this.goView('/');
                }
            }
        },
        getCityList : function(){
            var self = this;
            $.commonAjax({
                url : '/area/query_level_course.api',
                data :{ level : 2 },
                success : function(data){
                    self.city_list = data.datas;
                },
                error : function(){
                    $.toast('获取城市列表失败');
                }
            });
        }
    },
    ready : function(){
        this.fbaseUrl = $.fbaseUrl;
        this.getAds();
        this.getCourse();
        this.getCityList();

        var self = this;
        $.webService.getUserInfo().then(function(data){
            self.name = data.datas.name;
            self.mobile = data.datas.mobile;
        });
    }
});
