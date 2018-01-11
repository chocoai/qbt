(function($){

var app = new Vue({
    data : {
        //地址
        jUserName : '',
        jMobile : '',
        jAddress : '', //用于地址类型的地址
        jAddress_q : '',//用于球场类型的地址
        jAreaId : '',
        jAddrType : 1,
        jCourse : {},

        dUserName : '',
        dMobile : '',
        dAddress : '', //用于地址类型的地址
        dAddress_q : '',//用于球场类型的地址
        dAreaId : '',
        dAddrType : 1,
        dCourse : {},

        //保价
        money : 0,
        min : 0,
        insuredPrice : 0,
        //数量
        num : 1,
        //时间
        timeList : [],
        timeList2 : [],
        day : '',
        time : '',

        expect_times : [],
        expect_time : {},

        searchCourse1 : '',
        courseList1 : [],
        searchCourse2 : '',
        courseList2 : [],

        detail : {},
        pay_url : '',

        fBaseUrl : $.fBaseUrl,
        intervalId : '',

        v_mobile : '',
        v_piccode : '',
        v_pic : '',
        v_pictoken : '',

        smsCode : '',
        smsToken : '',

        province : [{id : '',name : '全国'}],
        course_pro1 : '',
        course_pro2 : '',

        locktime : 0,
        timeId : '',
    },
    computed : {
        'totalPrice' : function(){
            if(this.expect_time.sf_price && this.num){
                return (this.expect_time.sf_price + this.insuredPrice) * this.num;
            }
            return 0;
        },
        'timeText' : function(){
            return this.locktime > 0 ? this.locktime + 's' : '获取';
        }
    },
    watch : {
        'time' : 'getAmount',
        'day' : function(){
            this.expect_times = [];
            this.expect_time = {};
            $('#deliverTitle').text('请选择预计到达');
        },
        'jAreaId' : 'getAmount',
        'dAreaId' : 'getAmount',
        'money' : function(val,oldVal){
            if(val || val === 0){
                if(/^\d+$/.test(val)){
                    this.getPrice(val,oldVal);
                }else{
                    this.money = oldVal;
                    layer.msg('请填写整数保价金额');
                }
            }
        },
        'num' : function(val,oldVal){
            if(val || val === 0){
                if(/^\d+$/.test(val)){
                    if(val < 1){
                        this.num = 1;
                    }
                    if(val > 99){
                        this.num = 99;
                    }
                }else{
                    this.num = 1;
                }
            }
        },
        'searchCourse1' : function(val){
            this.getCourse(1);
        },
        'searchCourse2' : function(val){
            this.getCourse(2);
        },
        'course_pro1' : function(val){
            if(val){
                this.getCourse(1);
            }else{
                this.getCourseHot(1);
            }
            this.jCourse = {};
            $('#jCourse').val('');
        },
        'course_pro2' : function(val){
            if(val){
                this.getCourse(2);
            }else{
                this.getCourseHot(2);
            }
            this.dCourse = {};
            $('#dCourse').val('');
        }
    },
    methods : {
        chooseDay : function(day,e){
            this.day = day;
            for(var i = 0;i < this.timeList.length ;i++){
                if(day == this.timeList[i].day){
                    this.timeList2 = this.timeList[i].items;
                }
            }
            $(e.target).parent().hide().siblings().show();
            $('.book-day li').toggleClass('active');
            e.stopPropagation();
        },
        chooseTime : function(time,e){
            this.time = time;
            $(e.target).parent().hide().siblings().show();
            $('.book-day li').toggleClass('active');
            $('.book-name').parent().toggleClass('open02');
        },
        choosePrice : function(item,e){
            var self=this;
            if(e.target.tagName.toUpperCase()=="LI"){
                $(e.target).addClass('selected').siblings().removeClass('selected');
                $('#deliverTitle').html($(e.target).html());
            }else{
                $(e.target).parent().addClass('selected').siblings().removeClass('selected');
                $('#deliverTitle').html($(e.target).parent().html());
            }
            self.expect_time = item;
        },
        getAmount : function(){
            var _this = this;
            if(!this.time || !this.jAreaId || !this.dAreaId){
                return;
            }
            var data = {
                consigned_time : (this.day + ' ' + this.time).substring(0,16)+':00',
                src_area_id : this.jAreaId,
                dest_area_id : this.dAreaId,
                src_address : this.jAddress,
                dest_address : this.dAddress,
                business_type : 0,
                src_course_id : this.jAddrType == 2 ? this.jCourse.id : '',
                dest_course_id : this.dAddrType == 2 ? this.dCourse.id : ''
            }
            $.ajax({
                url: $.baseUrl + '/comm/v2/query_sf_recive_time.api',
                type: 'post',
                contentType:'application/json',
                data: JSON.stringify(data),
                success : function(data){
                    if(data.code == '0000'){
                        _this.expect_times = data.datas;
                        //默认选中费用类型
                        var defaultIndex = 0;
                        data.datas.forEach(function (i) {
                            i.checked = false;
                            //存在加急费
                            if (i.business_type == "3") {
                                defaultIndex = 1;
                            }
                        });
                        _this.expect_time = data.datas[defaultIndex];
                        var _html='';
                        data.datas[defaultIndex].origin_price>data.datas[defaultIndex].sf_price && (_html='<s style="padding-left:15px">原价:'+currency(data.datas[defaultIndex].origin_price,'￥')+'</s>');
                        $('#deliverTitle').html(data.datas[defaultIndex].deliver_time.split(',')[1] + ' ' + currency(data.datas[defaultIndex].sf_price,'￥')+_html);
                    }else{
                        layer.msg(data.msg);
                    }
                },
                error : function(){
                    layer.msg('网络繁忙，请稍后再试');
                }
            });
        },
        getPrice : function(val,oldVal){
            var _this = this;
            $.get($.baseUrl + "/index/insure.api",{price : val}).success(function(data){
                if(data.code == '0000'){
                    _this.insuredPrice = data.datas;
                }else{
                    _this.money = oldVal;
                    layer.msg(data.msg);
                }
            });
        },
        confirm : function(){
            var _this = this;

            var valid = this.validate();
            if(valid){
                layer.msg(valid); return;
            }

            var req = {
                business_type : this.expect_time.business_type,
                consigned_time : this.day + ' ' + this.time,
                deliver_time : this.expect_time.deliver_time.split(',')[1],
                insure_price : this.money,
                quantity : this.num,
                src_id : this.jAddrType == 1 ? 0 : this.jCourse.id,
                src_name : this.jUserName,
                src_moibile : this.jMobile,
                src_area_id : this.jAreaId,
                src_address : this.jAddrType == 1 ? this.jAddress : this.jAddress_q,
                src_type : this.jAddrType == 1 ? 4 : 1,

                dest_id : this.dAddrType == 1 ? 0 : this.dCourse.id,
                dest_name : this.dUserName,
                dest_moibile : this.dMobile,
                dest_area_id : this.dAreaId,
                dest_address : this.dAddrType == 1 ? this.dAddress : this.dAddress_q,
                dest_type : this.dAddrType == 1 ? 4 : 1,

                smsCode : this.smsCode,
                smsToken : this.smsToken,
                mobile : this.v_mobile,
                playTime : $("#playBallTime").val()
            };
            $.ajax({
                url: $.baseUrl + '/official/order_create.api',
                type: 'post',
                contentType:'application/json',
                data: JSON.stringify(req),
                success : function(data){
                    if(data.code == '0000'){
                        // _this.getDetail(data.datas);
                        location.href = 'orderpay.html?order=' + data.datas;
                    }else{
                        layer.msg(data.msg);
                    }
                },
                error : function(){
                    layer.msg('网络繁忙，请稍后再试');
                }
            });
        },
        getDetail : function(orderId){
            var _this = this;
            $.get($.baseUrl + '/official/order_detail.api',{orderNumber : orderId}).success(function(data){
                _this.detail = data.datas;
                _this.getPayCode();
                _this.getOrderStatus();

                Vue.nextTick(function(){
                    layer.open({
                        type : 1,
                        area : ['auto','auto'],
                        content : $('#order_detail'),
                        end : function(){
                            clearInterval(_this.intervalId);
                        }
                    });
                });

            }).fail(function(){
                layer.msg('网络繁忙，请稍后再试');
            });
        },
        getPayCode : function(){
            var _this = this;
            $.get($.baseUrl + '/official/pay.api',{orderNumber : this.detail.number}).success(function(data){
                _this.pay_url = data.datas;
            }).fail(function(){
                layer.msg('网络繁忙，请稍后再试');
            });
        },
        validate : function(){
            if(!this.jUserName || this.jUserName.length < 2) return '请填写2-8位寄包姓名';
            if(!this.jMobile || !$.comReg.isPhone(this.jMobile)) return '请填写有效寄包电话';
            if(this.jAddrType == 1){
                if(!this.jAreaId) return '请选择寄包所在地区';
                if(!this.jAddress) return '请填写寄包详细地址';
            }
            if(this.jAddrType == 2 && !this.jCourse.id){
                return '请选择寄包球场';
            }
            if(!this.dUserName || this.dUserName.length < 2) return '请填写2-8位收包姓名';
            if(!this.dMobile || !$.comReg.isPhone(this.dMobile)) return '请填写有效收包电话';
            if(this.dAddrType == 1){
                if(!this.dAreaId) return '请选择收包所在地区';
                if(!this.dAddress) return '请填写收包详细地址';
            }
            if(this.dAddrType == 2 && !this.dCourse.id){
                return '请选择收包球场';
            }
            if(!this.expect_time.sf_price) return '请选择预计到达';

            if(!this.smsToken) return '请获取短信验证码';
            if(!this.smsCode) return '请输入短信验证码';

            return '';
        },
        showCourse : function(isJ){
            if(isJ){
                $('#course1').toggleClass('hide');
            }else{
                $('#course2').toggleClass('hide');
            }
        },
        getCourse : function(t){
            var _this = this;
            $.get($.baseUrl + "/comm/query_course.api",{
                city_id : t ==1 ? _this.course_pro1 : _this.course_pro2,
                name : t ==1 ? _this.searchCourse1 : _this.searchCourse2,
                isPractice:0
            }).success(function(data){
                if(t ==1){
                    _this.courseList1 = data.datas;
                }else{
                    _this.courseList2 = data.datas;
                }
            });
        },
        getCourseHot : function(type){
            var _this = this;
            $.get($.baseUrl + "/comm/findByHotCourse.api").success(function(data){
                if(type == 0){
                    _this.courseList1 = data.datas;
                    _this.courseList2 = data.datas;
                }else if(type == 1){
                    _this.courseList1 = data.datas;
                }else{
                    _this.courseList2 = data.datas;
                }
            });
        },
        chooseCourse : function(item,isJ){
            if(isJ){
                this.jCourse = item;
                this.jAreaId = item.areaId;
                if(this.jAddrType==2) this.jAddress_q=item.address;
                $('#course1').addClass('hide');
                $('#jCourse').val(item.name);
            }else{
                this.dCourse = item;
                this.dAreaId = item.areaId;
                if(this.dAddrType==2) this.dAddress_q=item.address;
                $('#course2').addClass('hide');
                $('#dCourse').val(item.name);
            }
        },
        getOrderStatus : function(){
            var _this = this;
            this.intervalId = setInterval(function(){
                $.get($.baseUrl + "/official/order_pay_status.api",{orderNumber : _this.detail.number}).success(function(data){
                    if(data.datas == 2){
                        clearInterval(_this.intervalId);
                        layer.closeAll();
                        layer.alert('支付成功', {icon: 6});
                    }
                });
            },5000);
        },
        getPic : function(){
            var _this = this;
            $.get($.baseUrl + '/code/captchaImage.api').success(function(data){
                _this.v_pic = 'data:image/jpg;base64,' + data.datas.image;
                _this.v_pictoken = data.datas.captchaToken;
            });
        },
        getSmsCode : function(){
            var _this = this;
            if(!this.v_piccode){
                layer.msg('请输入图片验证码'); return;
            }
            if(!this.v_mobile || !$.comReg.isMobile(this.v_mobile)){
                layer.msg('请输入有效手机号码'); return;
            }
            var req = {
                captchaCode : this.v_piccode,
                captchaToken : this.v_pictoken,
                mobile : this.v_mobile
            };
            $.ajax({
                url: $.baseUrl + '/code/sms.api',
                type: 'post',
                contentType:'application/json',
                data: JSON.stringify(req),
                success : function(data){
                    if(data.code == '0000'){
                        _this.smsToken = data.datas;
                        _this.v_piccode = '';
                        layer.closeAll();
                        layer.msg('获取成功');
                        _this.locktime = 60;
                        _this.timeId = setInterval(function(){
                            _this.locktime --;
                            if(_this.locktime <=0 ){
                                clearInterval(_this.timeId);
                            }
                        },1000);
                    }else{
                        layer.msg(data.msg);
                    }
                },
                error : function(){
                    layer.msg('网络繁忙，请稍后再试');
                }
            });
        },
        openSms : function(){
            if(this.locktime>0) return;
            var _this = this;
            _this.v_mobile = _this.jMobile;
            _this.getPic();
            layer.open({
                type : 1,
                title : '获取验证码',
                area : ['320px','auto'],
                content : $('#msgcode'),
                btn : ['获取'],
                yes : function(){
                    _this.getSmsCode();
                }
            });
        }
    },
    mounted : function(){
        var _this = this;
        this.jAreaId = $.getQueryString('jAddrId') || '';
        this.dAreaId = $.getQueryString('dAddrId') || '';
        $('#city').val($.getQueryString('jAddr') || '');
        $('#city-2').val($.getQueryString('dAddr') || '');

        $("#city").click(function (e) {
    		SelCity(this,e);
            $('#_citys0 a').on('click',function(){
                $('#_citys1 a').on('click',function(){
                    $('#_citys2 a').on('click',function(){
                        _this.jAreaId = $(this).attr('data-id');
                    });
                });
            });
    	});
    	$("#city-2").click(function (e) {
    		SelCity(this,e);
            $('#_citys0 a').on('click',function(){
                $('#_citys1 a').on('click',function(){
                    $('#_citys2 a').on('click',function(){
                        _this.dAreaId = $(this).attr('data-id');
                    });
                });
            });
    	});

        $(".select").each(function(index,ele) {
            $(ele).click(function(e){
                 $(this).toggleClass("open");
                 e.stopPropagation();
            });
            $(this).children().children().click(function(){
                var $this = $(this);
                $this.addClass("selected").siblings().removeClass("selected");
                $(this).parent().parent().children("p").text($this.html());
            });
        });
        $(document).click(function(){
            $(".select").removeClass("open");
            $('.book-tab').removeClass('open02');

            $('#course1').addClass('hide');
            $('#course2').addClass('hide');
        });
        $(".book-name").each(function(index,ele) {
           $(ele).click(function(e){
               $(ele).parent().toggleClass("open02");
               e.stopPropagation();
           });
       });

        //初始化打球时间控件
        $('#playBallTime').datetimepicker({
            format : 'yyyy-mm-dd hh',
            startDate : new Date(),
            todayBtn : false,
            autoclose : true
        });

       //时间
       $.get($.baseUrl + "/index/time.api").success(function(data){
            _this.timeList = data.datas;
            _this.day = data.datas[0].day;
            _this.time = data.datas[0].items[0];
            var timeMsg = $.getQueryString('time');
            if(timeMsg){
                _this.day = timeMsg.split(' ')[0];
                _this.time = timeMsg.split(' ')[1];
            }
       });

        //保价
       $.get($.baseUrl + "/index/query_insured.api").success(function(data){
           _this.min = data.datas.min;
           _this.money = data.datas.min;
           _this.insuredPrice = data.datas.insuredPrice;
       });

       for(var i = 0; i<cityList.length; i ++ ){
           _this.province.push({
               id : cityList[i].id,
               name : cityList[i].name
           });
       }

       this.getCourseHot(0);
    }
}).$mount('#app');

$(function(){
    function tabs(tabTit,on,tabCon){
        $(tabTit).children().click(function(){
            $(this).addClass(on).siblings().removeClass(on);
            var index = $(tabTit).children().index(this);
            $(tabCon).children().eq(index).show().siblings().hide();
        });
    };
    tabs(".tab-hd","active",".tab-bd");
});

}(jQuery || Zepto));
