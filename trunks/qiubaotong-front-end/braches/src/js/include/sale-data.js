var sale_data_view = Vue.extend({
    template: '#sale-data',
    data : function(){
        return{
            detail : {},
            fbaseUrl : $.fbaseUrl
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        getDetail : function(){
            var _this = this;
            $.commonAjax({
                url : '/saleUser/info.api',
                success : function(data){
                    _this.detail = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        showCode : function(){
            var _this = this;
            wx.previewImage({
                current: _this.fbaseUrl + _this.detail.qrcode,
                urls: [_this.fbaseUrl + _this.detail.qrcode]
            });
        }
    },
    ready : function(){
        this.getDetail();
    }
});
