var send_view = Vue.extend({
    template: '#send-template',
    data : function(){
        return{
            money : '',
            min : 0,
            amount_bj : 0,
            amount_yf : 0,
            b_money : '￥0.00',
            business : '1',
            expect_times : [],
            expect_selected : {},
            readCare : true,
            readAgree : true,
            warnTips : '',
            ads : [], //广告
            fbaseUrl : '',
            quantity : 1, //数量
            list_count : 0,
            isVip : false, //是否vip
            vipAmt : 0, //vip下单金额
            assistantUser : false, //是否合作机构
            message : {},
            allMessage: [],
            showPop : false
        }
    },
    vuex : {
        getters : {
            send_time : function(state){ return state.send_time},
            send_addr : function(state){ return state.send_addr},
            collect_addr : function(state){ return state.collect_addr},
            geo_lat : function(state){ return state.geo_lat},
            geo_long : function(state){ return state.geo_long}
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        goView2 : function(view,isJ){
            setStore('isJ',isJ);
            this.$route.router.go(view);
        },
        goNav : function(url){
            locationTo(url);
        },
        getPrice : function(val){
            var self = this;
            $.commonAjax({
                url : '/index/insure.api',
                data : {
                    price : val
                },
                success : function(data){
                    self.amount_bj = data.datas;
                    self.b_money = Vue.options.filters.currency(data.datas,'￥');
                },
                error : function(err){
                    self.amount_bj = 0;
                    self.money = "";
                    self.b_money = err;
                }
            });
        },
        getAmount : function(){
            if(!this.send_addr.address || !this.collect_addr.address || !this.send_time){
                return;
            }
            var self = this;
            $.commonAjax({
                url : '/comm/v2/query_sf_recive_time.api',
                type : 'POST',
                data : {
                    business_type : self.business,
                    consigned_time : self.send_time.substr(0,16)+':00',
                    src_address : self.send_addr.real_address,
                    src_area_id : self.send_addr.areaId,
                    dest_address : self.collect_addr.real_address,
                    dest_area_id : self.collect_addr.areaId,
                    src_course_id : self.send_addr.addr_type == '1' ? self.send_addr.addr_id : '',
                    dest_course_id : self.collect_addr.addr_type == '1' ? self.collect_addr.addr_id : ''
                },
                success : function(data){
                    if(data.datas && data.datas.length>0){
                        self.expect_times = data.datas;
                        self.expect_selected = data.datas[0];
                        self.amount_yf = data.datas[0].sf_price;

                        //温馨提示
                        self.showWarn();
                    }else{
                        self.expect_times = [];
                        self.expect_selected = {};
                        self.amount_yf = 0;
                    }
                },
                error : function(err){
                    self.expect_times = [];
                    self.expect_selected = {};
                    self.amount_yf = 0;
                    $.toast(err);
                }
            });
        },
        selectType : function(item){
            this.expect_selected = item;
            this.amount_yf = item.sf_price;
            //温馨提示
            this.showWarn();
        },
        checkConfirm : function(){
            if(!this.send_addr.name || !this.collect_addr.name){
                return false;
            }
            if(!this.expect_selected.business_type){
                return false;
            }
            if(!this.send_time){
                return false;
            }
            if(this.money === ""){
                return false;
            }
            return true;
        },
        inVald : function(){
            if(this.send_addr.real_address && this.collect_addr.real_address && this.expect_selected.business_type && (this.money !='')){
                var self = this;
                if(!this.send_addr.name){
                    $.alert('请完善寄件联系人',function(){
                        self.goView2('/contact',true);
                    });
                    return;
                }
                if(!this.collect_addr.name){
                    $.alert('请完善收件联系人',function(){
                        self.goView2('/contact',false);
                    });
                    return;
                }
            }
        },
        checkName : function(name){
            name = $.trim(name);
            if(name.length == 1 || name.indexOf('先生')>0 || name.indexOf('女士')>0){
                return false;
            }
            return true;
        },
        save : function(){
            if(!this.checkName(this.send_addr.name) || !this.checkName(this.collect_addr.name)){
                $.alert('由于保价需要实名，请填写真实姓名'); return;
            }
            if(!this.readCare){
                $.alert('请阅读注意事项'); return;
            }
            if(!this.readAgree){
                $.alert('请阅读服务协议'); return;
            }
            var self = this;
            $.commonAjax({
                url : '/order/confirm_order.api',
                type : 'POST',
                data:{
                    business_type : this.expect_selected.business_type,
                    consigned_time : this.send_time,
                    deliver_time : this.expect_selected.deliver_time.split(',')[1],
                    src_address : this.send_addr.real_address,
                    src_area_id : this.send_addr.areaId,
                    dest_address : this.collect_addr.real_address,
                    dest_area_id : this.collect_addr.areaId,
                    src_type : this.send_addr.addr_type,
                    src_id : this.send_addr.addr_id,
                    src_moibile : this.send_addr.mobile,
                    src_name : $.trim(this.send_addr.name),
                    dest_type : this.collect_addr.addr_type,
                    dest_id : this.collect_addr.addr_id,
                    dest_moibile : this.collect_addr.mobile,
                    dest_name : $.trim(this.collect_addr.name),
                    price : this.amount_yf + this.amount_bj,
                    insure_price : this.money,
                    quantity : this.quantity
                },
                success : function(data){
                    location.href = 'order.html?v=' + $.version + '#!/mpay/' + data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        convert : function(type){
            if(type == 4) return 1;
            if(type == 1) return 2;
            return 3;
        },
        showWarn : function(){
            var tips = '温馨提示：如果显示到达时间不能满足您的需要，请直接咨询客服，球包通将竭尽全力为您安排';

            var couseTips = false;
            if(this.send_addr.addr_type == 1 && this.send_addr.remark){
                tips = '温馨提示：' + '寄件球场为偏远球场,' + this.send_addr.remark;
                couseTips = true;
            }
            if(this.collect_addr.addr_type == 1 && this.collect_addr.remark){
                if(couseTips){
                    //非同球场
                    if(this.send_addr.addr_id != this.collect_addr.addr_id){
                        tips += '收件球场为偏远球场,'+this.collect_addr.remark;
                    }
                }else {
                    tips = '温馨提示：'  + '收件球场为偏远球场,' + this.collect_addr.remark;
                    couseTips = true;
                }
            }
            if(couseTips){
                this.warnTips = tips;
                return;
            }

            //1005310 - 1005324  昆明
            if((this.send_addr.areaId >= 1005310 && this.send_addr.areaId <= 1005324) ||
            this.collect_addr.areaId >= 1005310 && this.collect_addr.areaId <= 1005324){
                //明午,明日
                if(this.expect_selected.business_type == 1 || this.expect_selected.business_type == 5){
                    tips = '温馨提示：如果显示到达时间不能满足您的需要，请直接咨询客服，球包通将竭尽全力为您安排（昆明机场维护中，有可能造成实际到达时间延后）';
                    this.warnTips = tips;
                    return;
                }
            }
            if(this.collect_addr.addr_type == 1 && this.expect_selected.business_type == 2){
                tips = '温馨提示：收件地址为球场，建议选择快的时效类型，如果显示到达时间不能满足您的需要，请直接咨询客服，球包通将竭尽全力为您安排';
            }
            this.warnTips = tips;
        },
        getAds : function(){
            var self = this;
            $.commonAjax({
                url : '/baseAdv/list.api',
                loading : false,
                data :{
                    type : 'wx',
                    position : 'home'
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
        },
        redo : function(time){
            //重运
            if($.ls('redoAddr')){
                var item = JSON.parse($.ls('redoAddr'));
                var type = $.ls('redoAddrType');
                $.ls('redoAddr','');
                if(type == '1'){
                    this.send_addr.type = this.convert(item.jAddrType);
                    if(this.send_addr.type == 1){
                        this.send_addr.address = item.jCityName.replace(/,/g,'')  + item.jAddressName;
                    }else{
                        this.send_addr.address = item.jAddressName;
                    }
                    this.send_addr.name = item.jUserName;
                    this.send_addr.mobile = item.jMobile;
                    this.send_addr.areaId = item.jAreaId;
                    this.send_addr.real_address = item.jAddressName;
                    this.send_addr.addr_type = item.jAddrType;
                    this.send_addr.addr_id = item.jAddrId;

                    this.collect_addr.type = this.convert(item.dAddrType);
                    if(this.collect_addr.type == 1){
                        this.collect_addr.address = item.dCityName.replace(/,/g,'')  + item.dAddressName;
                    }else{
                        this.collect_addr.address = item.dAddressName;
                    }
                    this.collect_addr.name = item.dUserName;
                    this.collect_addr.mobile = item.dMobile;
                    this.collect_addr.areaId = item.dAreaId;
                    this.collect_addr.real_address = item.dAddressName;
                    this.collect_addr.addr_type = item.dAddrType;
                    this.collect_addr.addr_id = item.dAddrId;
                }else{
                    this.collect_addr.type = this.convert(item.jAddrType);
                    if(this.collect_addr.type == 1){
                        this.collect_addr.address = item.jCityName.replace(/,/g,'')  + item.jAddressName;
                    }else{
                        this.collect_addr.address = item.jAddressName;
                    }
                    this.collect_addr.name = item.jUserName;
                    this.collect_addr.mobile = item.jMobile;
                    this.collect_addr.areaId = item.jAreaId;
                    this.collect_addr.real_address = item.jAddressName;
                    this.collect_addr.addr_type = item.jAddrType;
                    this.collect_addr.addr_id = item.jAddrId;

                    this.send_addr.type = this.convert(item.dAddrType);
                    if(this.send_addr.type == 1){
                        this.send_addr.address = item.dCityName.replace(/,/g,'')  + item.dAddressName;
                    }else{
                        this.send_addr.address = item.dAddressName;
                    }
                    this.send_addr.name = item.dUserName;
                    this.send_addr.mobile = item.dMobile;
                    this.send_addr.areaId = item.dAreaId;
                    this.send_addr.real_address = item.dAddressName;
                    this.send_addr.addr_type = item.dAddrType;
                    this.send_addr.addr_id = item.dAddrId;
                }
                var send_time = item.sendTimeSection;
                //时间大于默认时间
                if(new Date(send_time.substr(0,16)+':00').getTime() > new Date(time.substr(0,16)+':00').getTime()){
                    setStore('send_time',send_time);
                }else{
                    setStore('send_time',time);
                }
                //保价
                this.money = item.insureValue;
            }else{
                setStore('send_time',time);
            }
        },
        geoAddr : function(){
            //定位
            if(this.geo_lat && this.geo_long){
                $.baiduApi_address(this.geo_lat+','+this.geo_long,function(data){
                    setStore('geo_province',data.result.addressComponent.province);
                    setStore('geo_city',data.result.addressComponent.city);
                    setStore('geo_district',data.result.addressComponent.district);
                    setStore('geo_addr',data.result.addressComponent.street + data.result.addressComponent.street_number);
                });
            };
        },
        addShopList : function(){
            if(!this.checkName(this.send_addr.name) || !this.checkName(this.collect_addr.name)){
                $.alert('由于保价需要实名，请填写真实姓名'); return;
            }
            if(!this.readCare){
                $.alert('请阅读注意事项'); return;
            }
            if(!this.readAgree){
                $.alert('请阅读服务协议'); return;
            }
            var self = this;
            $.webService.addShopList({
                business_type : this.expect_selected.business_type,
                consigned_time : this.send_time,
                deliver_time : this.expect_selected.deliver_time.split(',')[1],
                src_address : this.send_addr.real_address,
                src_area_id : this.send_addr.areaId,
                dest_address : this.collect_addr.real_address,
                dest_area_id : this.collect_addr.areaId,
                src_type : this.send_addr.addr_type,
                src_id : this.send_addr.addr_id,
                src_moibile : this.send_addr.mobile,
                src_name : $.trim(this.send_addr.name),
                dest_type : this.collect_addr.addr_type,
                dest_id : this.collect_addr.addr_id,
                dest_moibile : this.collect_addr.mobile,
                dest_name : $.trim(this.collect_addr.name),
                price : this.amount_yf + this.amount_bj,
                insure_price : this.money,
                quantity : this.quantity
            }).then(function(data){
                $('#pay_confirm').css('display','block');
                $('#indexAnim').css('display','block');
                $('#indexAnim').animate({
                    'bottom' : '50px',
                    'left' : '50%',
                    'transform' : 'scale(0.5)'
                },500,'ease-in',function(){
                    $('#indexAnim').css({
                        'bottom' : '150px',
                        'left' : '60%',
                        'transform' : 'scale(1)',
                        'display' : 'none'
                    });
                    self.list_count += self.quantity;
                    self.quantity = 1;
                })
            },function(err){
                $.toast(err);
            });
        },
        closeDialog : function(){
            $('#pay_confirm').hide();
        },
        goBuy : function(){
            locationTo('vip.html');
        },
        closePop : function(){
            if(this.allMessage.length > 0){
                this.message = this.allMessage[0];
                this.allMessage.splice(0,1);
            }
            else{
                this.showPop = false;
            }
        },
        getMessage : function(type,id){
            //弹层
            var self = this;
            $.commonAjax({
                url : '/index/pop.api',
                type : 'post',
                data: {
                    type : type,
                    id : id,
                    platform : 1
                },
                success : function(data){
                    self.allMessage = data.datas;
                    if(data.datas.length>0){
                        self.message = data.datas[0];
                        self.allMessage.splice(0,1);
                        self.showPop = true;
                    }
                }
            });
        }
    },
    watch :{
        'money' : function(val,oldVal){
            if((val || val == 0) && (oldVal || oldVal ==0)){
                if(/^\d+$/.test(val)){
                    this.getPrice(val);
                }else{
                    this.money = "";
                    this.b_money = '请填写整数保价金额';
                }
            }
        },
        'send_time' : 'getAmount',
        'send_addr.address' : function(){
            this.getAmount();

            //地址或球场
            if(this.send_addr.type == 1 || this.send_addr.type == 2){
                this.getMessage(this.send_addr.type == 1 ? 3 : 2,this.send_addr.type == 1 ? this.send_addr.areaId : this.send_addr.addr_id);
            }

        },
        'collect_addr.address' : function(){
            this.getAmount();

            //地址或球场
            if(this.collect_addr.type == 1 || this.collect_addr.type == 2){
                this.getMessage(this.collect_addr.type == 1 ? 3 : 2,this.collect_addr.type == 1 ? this.collect_addr.areaId : this.collect_addr.addr_id);
            }
        },
        'geo_lat' : 'geoAddr',
        'geo_long' : 'geoAddr',
        'quantity' : function(newVal){
            if(!newVal || newVal <= 0){
                this.quantity = 1;
                return;
            }
            if(newVal >99){
                this.quantity = 99;
            }
        }
    },
    ready : function(){
        var self = this;


        this.fbaseUrl = $.fbaseUrl;
        //广告
        this.getAds();

        //首次
        if(!$.ls('first')){
            //弹层
            this.getMessage(1,0);

            $.ls('first','1');
        }


        $.commonAjax({
            url : '/index/default_time.api',
            loading : false,
            success : function(data){
                self.redo(data.datas);
            }
        });

        //保价
        $.commonAjax({
            url : '/index/query_insured.api',
            loading : false,
            success : function(data){
                self.min = data.datas.min;
                self.money = data.datas.min;
                self.b_money = Vue.options.filters.currency(data.datas.insuredPrice,'￥');
            }
        });

        //数据还原
        if($.ls('addr_store')){
            var item = JSON.parse($.ls('addr_store'));
            //还原寄件信息
            if(item.send_addr){
                setStore('send_addr',item.send_addr);
            }
            //还原收件信息
            if(item.collect_addr){
                setStore('collect_addr',item.collect_addr);
            }
            //清空信息
            $.ls('addr_store','');
        }
        $.webService.getJsConfig().then(function(data){
            wx.config({
              appId: $.appId,
              timestamp: data.datas.timestamp,
              nonceStr: data.datas.nonceStr,
              signature: data.datas.signature,
              jsApiList: ['getLocation']
            });
            wx.ready(function(){
                wx.getLocation({
                    type: 'wgs84',
                    success: function (res) {
                        setStore('geo_lat',res.latitude);
                        setStore('geo_long',res.longitude);
                    }
                });
            });
        });
        //清单数量
        $.webService.getShopCount().then(function(data){
            self.list_count = data.datas;
        });
        //用户信息
        $.webService.getUserInfo().then(function(data){
            self.isVip = data.datas.vip;
            self.vipAmt = data.datas.vipAmount;
            self.assistantUser = data.datas.assistantUser;
        });
    }
});
