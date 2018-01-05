/**
 * @Title: OrderServiceOrder.java
 * @Package com.froad.iamp.xml2bean.api
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016�?8�?4�?
 * @version V1.0
**/

package com.qbt.sf.api.bean.orderOrdeReverse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: OrderReqOrder
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderReverseReqOrder {
    
    @XmlAttribute(name="orderid")
    private String orderid;
    @XmlAttribute(name="mailno")
    private String mailno;
    @XmlAttribute(name="is_gen_bill_no")
    private String is_gen_bill_no;
    
    @XmlAttribute(name="j_company")
    private String j_company;
    
    @XmlAttribute(name="j_contact")
    private String j_contanct;
    
    @XmlAttribute(name="j_tel")
    private String j_tel;
    
    @XmlAttribute(name="j_mobile")
    private String j_mobile;
    
    @XmlAttribute(name="j_shippercode")
    private String j_shippercode;
    
    @XmlAttribute(name="j_country")
    private String j_country;
    
    @XmlAttribute(name="j_province")
    private String j_province;
    
    @XmlAttribute(name="j_city")
    private String j_city;
    @XmlAttribute(name="j_county")
    private String j_county;
    @XmlAttribute(name="j_address")
    private String j_address;
    @XmlAttribute(name="j_post_code")
    private String j_post_code;
    @XmlAttribute(name="d_company")
    private String d_company;
    @XmlAttribute(name="d_contact")
    private String d_contact;
    @XmlAttribute(name="d_tel")
    private String d_tel;
    @XmlAttribute(name="d_mobile")
    private String d_mobile;
    @XmlAttribute(name="d_deliverycode")
    private String d_deliverycode;
    @XmlAttribute(name="d_country")
    private String d_country;
    @XmlAttribute(name="d_province")
    private String d_province;
    @XmlAttribute(name="d_city")
    private String d_city;
    @XmlAttribute(name="d_county")
    private String d_county;
    @XmlAttribute(name="d_address")
    private String d_address;
    @XmlAttribute(name="d_post_code")
    private String d_post_code;
    @XmlAttribute(name="custid")
    private String custid;
    @XmlAttribute(name="pay_method")
    private String pay_method;
    @XmlAttribute(name="express_type")
    private String express_type;
    @XmlAttribute(name="parcel_quantity")
    private String parcel_quantity;
    @XmlAttribute(name="cargo_length")
    private String cargo_length;
    @XmlAttribute(name="cargo_width")
    private String cargo_width;
    @XmlAttribute(name="cargo_height")
    private String cargo_height;
    @XmlAttribute(name="volume")
    private String volume;
    @XmlAttribute(name="cargo_total_weight")
    private String cargo_total_weight;
    @XmlAttribute(name="declared_value")
    private String declared_value;
    @XmlAttribute(name="declared_value_currency")
    private String declared_value_currency;
    @XmlAttribute(name="customs_batchs")
    private String customs_batchs;
    @XmlAttribute(name="sendstarttime")
    private String sendstarttime;
    @XmlAttribute(name="is_docall")
    private String is_docall;
    @XmlAttribute(name="need_return_tracking_no")
    private String need_return_tracking_no;
    @XmlAttribute(name="return_tracking")
    private String return_tracking;
    @XmlAttribute(name="d_tax_no")
    private String d_tax_no;
    @XmlAttribute(name="tax_pay_type")
    private String tax_pay_type;
    @XmlAttribute(name="tax_set_accounts")
    private String tax_set_accounts;
    @XmlAttribute(name="original_number")
    private String original_number;
    @XmlAttribute(name="payment_tool")
    private String payment_tool;
    @XmlAttribute(name="payment_number")
    private String payment_number;
    @XmlAttribute(name="goods_code")
    private String goods_code ;
    @XmlAttribute(name="in_process_waybill_no")
    private String in_process_waybill_no; 
    @XmlAttribute(name="brand")
    private String brand;
    @XmlAttribute(name="specifications")
    private String specifications;
    @XmlAttribute(name="temp_range")
    private String temp_range;
    @XmlAttribute(name="order_name")
    private String order_name;
    @XmlAttribute(name="order_cert_type")
    private String order_cert_type;
    @XmlAttribute(name="order_cert_no")
    private String order_cert_no;
    @XmlAttribute(name="order_source")
    private String order_source ;
    @XmlAttribute(name="template")
    private String template ;
    @XmlAttribute(name="remark")
    private String remark ;
    @XmlAttribute(name="oneself_pickup_flg")
    private String oneself_pickup_flg;
    @XmlAttribute(name="dispatch_sys")
    private String dispatch_sys;
    
 
    @XmlElement(name = "Cargo")  
    private List<OrderReverseCargo> cargoList;
    
    
    @XmlElement(name = "AddedService")  
    private List<OrderReverseAddedService> addedService;
    


    /**
     * getter method 
     * @Title: getOrderid
     * @return the orderid
     */
    public String getOrderid() {
        return orderid;
    }


    /**
    * setter method
    * @param orderid the orderid to set
    */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }


    /**
     * getter method 
     * @Title: getMailno
     * @return the mailno
     */
    public String getMailno() {
        return mailno;
    }


    /**
    * setter method
    * @param mailno the mailno to set
    */
    public void setMailno(String mailno) {
        this.mailno = mailno;
    }


    /**
     * getter method 
     * @Title: getIs_gen_bill_no
     * @return the is_gen_bill_no
     */
    public String getIs_gen_bill_no() {
        return is_gen_bill_no;
    }


    /**
    * setter method
    * @param is_gen_bill_no the is_gen_bill_no to set
    */
    public void setIs_gen_bill_no(String is_gen_bill_no) {
        this.is_gen_bill_no = is_gen_bill_no;
    }


    /**
     * getter method 
     * @Title: getJ_company
     * @return the j_company
     */
    public String getJ_company() {
        return j_company;
    }


    /**
    * setter method
    * @param j_company the j_company to set
    */
    public void setJ_company(String j_company) {
        this.j_company = j_company;
    }


    /**
     * getter method 
     * @Title: getJ_contanct
     * @return the j_contanct
     */
    public String getJ_contanct() {
        return j_contanct;
    }


    /**
    * setter method
    * @param j_contanct the j_contanct to set
    */
    public void setJ_contanct(String j_contanct) {
        this.j_contanct = j_contanct;
    }


    /**
     * getter method 
     * @Title: getJ_tel
     * @return the j_tel
     */
    public String getJ_tel() {
        return j_tel;
    }


    /**
    * setter method
    * @param j_tel the j_tel to set
    */
    public void setJ_tel(String j_tel) {
        this.j_tel = j_tel;
    }


    /**
     * getter method 
     * @Title: getJ_mobile
     * @return the j_mobile
     */
    public String getJ_mobile() {
        return j_mobile;
    }


    /**
    * setter method
    * @param j_mobile the j_mobile to set
    */
    public void setJ_mobile(String j_mobile) {
        this.j_mobile = j_mobile;
    }


    /**
     * getter method 
     * @Title: getJ_shippercode
     * @return the j_shippercode
     */
    public String getJ_shippercode() {
        return j_shippercode;
    }


    /**
    * setter method
    * @param j_shippercode the j_shippercode to set
    */
    public void setJ_shippercode(String j_shippercode) {
        this.j_shippercode = j_shippercode;
    }


    /**
     * getter method 
     * @Title: getJ_country
     * @return the j_country
     */
    public String getJ_country() {
        return j_country;
    }


    /**
    * setter method
    * @param j_country the j_country to set
    */
    public void setJ_country(String j_country) {
        this.j_country = j_country;
    }


    /**
     * getter method 
     * @Title: getJ_province
     * @return the j_province
     */
    public String getJ_province() {
        return j_province;
    }


    /**
    * setter method
    * @param j_province the j_province to set
    */
    public void setJ_province(String j_province) {
        this.j_province = j_province;
    }


    /**
     * getter method 
     * @Title: getJ_city
     * @return the j_city
     */
    public String getJ_city() {
        return j_city;
    }


    /**
    * setter method
    * @param j_city the j_city to set
    */
    public void setJ_city(String j_city) {
        this.j_city = j_city;
    }


    /**
     * getter method 
     * @Title: getJ_county
     * @return the j_county
     */
    public String getJ_county() {
        return j_county;
    }


    /**
    * setter method
    * @param j_county the j_county to set
    */
    public void setJ_county(String j_county) {
        this.j_county = j_county;
    }


    /**
     * getter method 
     * @Title: getJ_address
     * @return the j_address
     */
    public String getJ_address() {
        return j_address;
    }


    /**
    * setter method
    * @param j_address the j_address to set
    */
    public void setJ_address(String j_address) {
        this.j_address = j_address;
    }


    /**
     * getter method 
     * @Title: getJ_post_code
     * @return the j_post_code
     */
    public String getJ_post_code() {
        return j_post_code;
    }


    /**
    * setter method
    * @param j_post_code the j_post_code to set
    */
    public void setJ_post_code(String j_post_code) {
        this.j_post_code = j_post_code;
    }


    /**
     * getter method 
     * @Title: getD_company
     * @return the d_company
     */
    public String getD_company() {
        return d_company;
    }


    /**
    * setter method
    * @param d_company the d_company to set
    */
    public void setD_company(String d_company) {
        this.d_company = d_company;
    }


    /**
     * getter method 
     * @Title: getD_contact
     * @return the d_contact
     */
    public String getD_contact() {
        return d_contact;
    }


    /**
    * setter method
    * @param d_contact the d_contact to set
    */
    public void setD_contact(String d_contact) {
        this.d_contact = d_contact;
    }


    /**
     * getter method 
     * @Title: getD_tel
     * @return the d_tel
     */
    public String getD_tel() {
        return d_tel;
    }


    /**
    * setter method
    * @param d_tel the d_tel to set
    */
    public void setD_tel(String d_tel) {
        this.d_tel = d_tel;
    }


    /**
     * getter method 
     * @Title: getD_mobile
     * @return the d_mobile
     */
    public String getD_mobile() {
        return d_mobile;
    }


    /**
    * setter method
    * @param d_mobile the d_mobile to set
    */
    public void setD_mobile(String d_mobile) {
        this.d_mobile = d_mobile;
    }


    /**
     * getter method 
     * @Title: getD_deliverycode
     * @return the d_deliverycode
     */
    public String getD_deliverycode() {
        return d_deliverycode;
    }


    /**
    * setter method
    * @param d_deliverycode the d_deliverycode to set
    */
    public void setD_deliverycode(String d_deliverycode) {
        this.d_deliverycode = d_deliverycode;
    }


    /**
     * getter method 
     * @Title: getD_country
     * @return the d_country
     */
    public String getD_country() {
        return d_country;
    }


    /**
    * setter method
    * @param d_country the d_country to set
    */
    public void setD_country(String d_country) {
        this.d_country = d_country;
    }


    /**
     * getter method 
     * @Title: getD_province
     * @return the d_province
     */
    public String getD_province() {
        return d_province;
    }


    /**
    * setter method
    * @param d_province the d_province to set
    */
    public void setD_province(String d_province) {
        this.d_province = d_province;
    }


    /**
     * getter method 
     * @Title: getD_city
     * @return the d_city
     */
    public String getD_city() {
        return d_city;
    }


    /**
    * setter method
    * @param d_city the d_city to set
    */
    public void setD_city(String d_city) {
        this.d_city = d_city;
    }


    /**
     * getter method 
     * @Title: getD_county
     * @return the d_county
     */
    public String getD_county() {
        return d_county;
    }


    /**
    * setter method
    * @param d_county the d_county to set
    */
    public void setD_county(String d_county) {
        this.d_county = d_county;
    }


    /**
     * getter method 
     * @Title: getD_address
     * @return the d_address
     */
    public String getD_address() {
        return d_address;
    }


    /**
    * setter method
    * @param d_address the d_address to set
    */
    public void setD_address(String d_address) {
        this.d_address = d_address;
    }


    /**
     * getter method 
     * @Title: getD_post_code
     * @return the d_post_code
     */
    public String getD_post_code() {
        return d_post_code;
    }


    /**
    * setter method
    * @param d_post_code the d_post_code to set
    */
    public void setD_post_code(String d_post_code) {
        this.d_post_code = d_post_code;
    }


    /**
     * getter method 
     * @Title: getCustid
     * @return the custid
     */
    public String getCustid() {
        return custid;
    }


    /**
    * setter method
    * @param custid the custid to set
    */
    public void setCustid(String custid) {
        this.custid = custid;
    }


    /**
     * getter method 
     * @Title: getPay_method
     * @return the pay_method
     */
    public String getPay_method() {
        return pay_method;
    }


    /**
    * setter method
    * @param pay_method the pay_method to set
    */
    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }


    /**
     * getter method 
     * @Title: getExpress_type
     * @return the express_type
     */
    public String getExpress_type() {
        return express_type;
    }


    /**
    * setter method
    * @param express_type the express_type to set
    */
    public void setExpress_type(String express_type) {
        this.express_type = express_type;
    }


    /**
     * getter method 
     * @Title: getParcel_quantity
     * @return the parcel_quantity
     */
    public String getParcel_quantity() {
        return parcel_quantity;
    }


    /**
    * setter method
    * @param parcel_quantity the parcel_quantity to set
    */
    public void setParcel_quantity(String parcel_quantity) {
        this.parcel_quantity = parcel_quantity;
    }


    /**
     * getter method 
     * @Title: getCargo_length
     * @return the cargo_length
     */
    public String getCargo_length() {
        return cargo_length;
    }


    /**
    * setter method
    * @param cargo_length the cargo_length to set
    */
    public void setCargo_length(String cargo_length) {
        this.cargo_length = cargo_length;
    }


    /**
     * getter method 
     * @Title: getCargo_width
     * @return the cargo_width
     */
    public String getCargo_width() {
        return cargo_width;
    }


    /**
    * setter method
    * @param cargo_width the cargo_width to set
    */
    public void setCargo_width(String cargo_width) {
        this.cargo_width = cargo_width;
    }


    /**
     * getter method 
     * @Title: getCargo_height
     * @return the cargo_height
     */
    public String getCargo_height() {
        return cargo_height;
    }


    /**
    * setter method
    * @param cargo_height the cargo_height to set
    */
    public void setCargo_height(String cargo_height) {
        this.cargo_height = cargo_height;
    }


    /**
     * getter method 
     * @Title: getVolume
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }


    /**
    * setter method
    * @param volume the volume to set
    */
    public void setVolume(String volume) {
        this.volume = volume;
    }


    /**
     * getter method 
     * @Title: getCargo_total_weight
     * @return the cargo_total_weight
     */
    public String getCargo_total_weight() {
        return cargo_total_weight;
    }


    /**
    * setter method
    * @param cargo_total_weight the cargo_total_weight to set
    */
    public void setCargo_total_weight(String cargo_total_weight) {
        this.cargo_total_weight = cargo_total_weight;
    }


    /**
     * getter method 
     * @Title: getDeclared_value
     * @return the declared_value
     */
    public String getDeclared_value() {
        return declared_value;
    }


    /**
    * setter method
    * @param declared_value the declared_value to set
    */
    public void setDeclared_value(String declared_value) {
        this.declared_value = declared_value;
    }


    /**
     * getter method 
     * @Title: getDeclared_value_currency
     * @return the declared_value_currency
     */
    public String getDeclared_value_currency() {
        return declared_value_currency;
    }


    /**
    * setter method
    * @param declared_value_currency the declared_value_currency to set
    */
    public void setDeclared_value_currency(String declared_value_currency) {
        this.declared_value_currency = declared_value_currency;
    }


    /**
     * getter method 
     * @Title: getCustoms_batchs
     * @return the customs_batchs
     */
    public String getCustoms_batchs() {
        return customs_batchs;
    }


    /**
    * setter method
    * @param customs_batchs the customs_batchs to set
    */
    public void setCustoms_batchs(String customs_batchs) {
        this.customs_batchs = customs_batchs;
    }


    /**
     * getter method 
     * @Title: getSendstarttime
     * @return the sendstarttime
     */
    public String getSendstarttime() {
        return sendstarttime;
    }


    /**
    * setter method
    * @param sendstarttime the sendstarttime to set
    */
    public void setSendstarttime(String sendstarttime) {
        this.sendstarttime = sendstarttime;
    }


    /**
     * getter method 
     * @Title: getIs_docall
     * @return the is_docall
     */
    public String getIs_docall() {
        return is_docall;
    }


    /**
    * setter method
    * @param is_docall the is_docall to set
    */
    public void setIs_docall(String is_docall) {
        this.is_docall = is_docall;
    }


    /**
     * getter method 
     * @Title: getNeed_return_tracking_no
     * @return the need_return_tracking_no
     */
    public String getNeed_return_tracking_no() {
        return need_return_tracking_no;
    }


    /**
    * setter method
    * @param need_return_tracking_no the need_return_tracking_no to set
    */
    public void setNeed_return_tracking_no(String need_return_tracking_no) {
        this.need_return_tracking_no = need_return_tracking_no;
    }


    /**
     * getter method 
     * @Title: getReturn_tracking
     * @return the return_tracking
     */
    public String getReturn_tracking() {
        return return_tracking;
    }


    /**
    * setter method
    * @param return_tracking the return_tracking to set
    */
    public void setReturn_tracking(String return_tracking) {
        this.return_tracking = return_tracking;
    }


    /**
     * getter method 
     * @Title: getD_tax_no
     * @return the d_tax_no
     */
    public String getD_tax_no() {
        return d_tax_no;
    }


    /**
    * setter method
    * @param d_tax_no the d_tax_no to set
    */
    public void setD_tax_no(String d_tax_no) {
        this.d_tax_no = d_tax_no;
    }


    /**
     * getter method 
     * @Title: getTax_pay_type
     * @return the tax_pay_type
     */
    public String getTax_pay_type() {
        return tax_pay_type;
    }


    /**
    * setter method
    * @param tax_pay_type the tax_pay_type to set
    */
    public void setTax_pay_type(String tax_pay_type) {
        this.tax_pay_type = tax_pay_type;
    }


    /**
     * getter method 
     * @Title: getTax_set_accounts
     * @return the tax_set_accounts
     */
    public String getTax_set_accounts() {
        return tax_set_accounts;
    }


    /**
    * setter method
    * @param tax_set_accounts the tax_set_accounts to set
    */
    public void setTax_set_accounts(String tax_set_accounts) {
        this.tax_set_accounts = tax_set_accounts;
    }


    /**
     * getter method 
     * @Title: getOriginal_number
     * @return the original_number
     */
    public String getOriginal_number() {
        return original_number;
    }


    /**
    * setter method
    * @param original_number the original_number to set
    */
    public void setOriginal_number(String original_number) {
        this.original_number = original_number;
    }


    /**
     * getter method 
     * @Title: getPayment_tool
     * @return the payment_tool
     */
    public String getPayment_tool() {
        return payment_tool;
    }


    /**
    * setter method
    * @param payment_tool the payment_tool to set
    */
    public void setPayment_tool(String payment_tool) {
        this.payment_tool = payment_tool;
    }


    /**
     * getter method 
     * @Title: getPayment_number
     * @return the payment_number
     */
    public String getPayment_number() {
        return payment_number;
    }


    /**
    * setter method
    * @param payment_number the payment_number to set
    */
    public void setPayment_number(String payment_number) {
        this.payment_number = payment_number;
    }


    /**
     * getter method 
     * @Title: getGoods_code
     * @return the goods_code
     */
    public String getGoods_code() {
        return goods_code;
    }


    /**
    * setter method
    * @param goods_code the goods_code to set
    */
    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }


    /**
     * getter method 
     * @Title: getIn_process_waybill_no
     * @return the in_process_waybill_no
     */
    public String getIn_process_waybill_no() {
        return in_process_waybill_no;
    }


    /**
    * setter method
    * @param in_process_waybill_no the in_process_waybill_no to set
    */
    public void setIn_process_waybill_no(String in_process_waybill_no) {
        this.in_process_waybill_no = in_process_waybill_no;
    }


    /**
     * getter method 
     * @Title: getBrand
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }


    /**
    * setter method
    * @param brand the brand to set
    */
    public void setBrand(String brand) {
        this.brand = brand;
    }


    /**
     * getter method 
     * @Title: getSpecifications
     * @return the specifications
     */
    public String getSpecifications() {
        return specifications;
    }


    /**
    * setter method
    * @param specifications the specifications to set
    */
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }


    /**
     * getter method 
     * @Title: getTemp_range
     * @return the temp_range
     */
    public String getTemp_range() {
        return temp_range;
    }


    /**
    * setter method
    * @param temp_range the temp_range to set
    */
    public void setTemp_range(String temp_range) {
        this.temp_range = temp_range;
    }


    /**
     * getter method 
     * @Title: getOrder_name
     * @return the order_name
     */
    public String getOrder_name() {
        return order_name;
    }


    /**
    * setter method
    * @param order_name the order_name to set
    */
    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }


    /**
     * getter method 
     * @Title: getOrder_cert_type
     * @return the order_cert_type
     */
    public String getOrder_cert_type() {
        return order_cert_type;
    }


    /**
    * setter method
    * @param order_cert_type the order_cert_type to set
    */
    public void setOrder_cert_type(String order_cert_type) {
        this.order_cert_type = order_cert_type;
    }


    /**
     * getter method 
     * @Title: getOrder_cert_no
     * @return the order_cert_no
     */
    public String getOrder_cert_no() {
        return order_cert_no;
    }


    /**
    * setter method
    * @param order_cert_no the order_cert_no to set
    */
    public void setOrder_cert_no(String order_cert_no) {
        this.order_cert_no = order_cert_no;
    }


    /**
     * getter method 
     * @Title: getOrder_source
     * @return the order_source
     */
    public String getOrder_source() {
        return order_source;
    }


    /**
    * setter method
    * @param order_source the order_source to set
    */
    public void setOrder_source(String order_source) {
        this.order_source = order_source;
    }


    /**
     * getter method 
     * @Title: getTemplate
     * @return the template
     */
    public String getTemplate() {
        return template;
    }


    /**
    * setter method
    * @param template the template to set
    */
    public void setTemplate(String template) {
        this.template = template;
    }


    /**
     * getter method 
     * @Title: getRemark
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }


    /**
    * setter method
    * @param remark the remark to set
    */
    public void setRemark(String remark) {
        this.remark = remark;
    }


    /**
     * getter method 
     * @Title: getOneself_pickup_flg
     * @return the oneself_pickup_flg
     */
    public String getOneself_pickup_flg() {
        return oneself_pickup_flg;
    }


    /**
    * setter method
    * @param oneself_pickup_flg the oneself_pickup_flg to set
    */
    public void setOneself_pickup_flg(String oneself_pickup_flg) {
        this.oneself_pickup_flg = oneself_pickup_flg;
    }


    /**
     * getter method 
     * @Title: getDispatch_sys
     * @return the dispatch_sys
     */
    public String getDispatch_sys() {
        return dispatch_sys;
    }


    /**
    * setter method
    * @param dispatch_sys the dispatch_sys to set
    */
    public void setDispatch_sys(String dispatch_sys) {
        this.dispatch_sys = dispatch_sys;
    }


    /**
     * getter method 
     * @Title: getCargoList
     * @return the cargoList
     */
    public List<OrderReverseCargo> getCargoList() {
        return cargoList;
    }


    /**
    * setter method
    * @param cargoList the cargoList to set
    */
    public void setCargoList(List<OrderReverseCargo> cargoList) {
        this.cargoList = cargoList;
    }


    /**
     * getter method 
     * @Title: getAddedService
     * @return the addedService
     */
    public List<OrderReverseAddedService> getAddedService() {
        return addedService;
    }


    /**
    * setter method
    * @param addedService the addedService to set
    */
    public void setAddedService(List<OrderReverseAddedService> addedService) {
        this.addedService = addedService;
    }  
    
    
    
}
