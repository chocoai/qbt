package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andMail_noIsNull() {
            addCriterion("mail_no is null");
            return (Criteria) this;
        }

        public Criteria andMail_noIsNotNull() {
            addCriterion("mail_no is not null");
            return (Criteria) this;
        }

        public Criteria andMail_noEqualTo(String value) {
            addCriterion("mail_no =", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noNotEqualTo(String value) {
            addCriterion("mail_no <>", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noGreaterThan(String value) {
            addCriterion("mail_no >", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noGreaterThanOrEqualTo(String value) {
            addCriterion("mail_no >=", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noLessThan(String value) {
            addCriterion("mail_no <", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noLessThanOrEqualTo(String value) {
            addCriterion("mail_no <=", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noLike(String value) {
            addCriterion("mail_no like", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noNotLike(String value) {
            addCriterion("mail_no not like", value, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noIn(List<String> values) {
            addCriterion("mail_no in", values, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noNotIn(List<String> values) {
            addCriterion("mail_no not in", values, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noBetween(String value1, String value2) {
            addCriterion("mail_no between", value1, value2, "mail_no");
            return (Criteria) this;
        }

        public Criteria andMail_noNotBetween(String value1, String value2) {
            addCriterion("mail_no not between", value1, value2, "mail_no");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverIsNull() {
            addCriterion("has_bag_cover is null");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverIsNotNull() {
            addCriterion("has_bag_cover is not null");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverEqualTo(Boolean value) {
            addCriterion("has_bag_cover =", value, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverNotEqualTo(Boolean value) {
            addCriterion("has_bag_cover <>", value, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverGreaterThan(Boolean value) {
            addCriterion("has_bag_cover >", value, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_bag_cover >=", value, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverLessThan(Boolean value) {
            addCriterion("has_bag_cover <", value, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverLessThanOrEqualTo(Boolean value) {
            addCriterion("has_bag_cover <=", value, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverIn(List<Boolean> values) {
            addCriterion("has_bag_cover in", values, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverNotIn(List<Boolean> values) {
            addCriterion("has_bag_cover not in", values, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverBetween(Boolean value1, Boolean value2) {
            addCriterion("has_bag_cover between", value1, value2, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andHas_bag_coverNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_bag_cover not between", value1, value2, "has_bag_cover");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeIsNull() {
            addCriterion("send_start_time is null");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeIsNotNull() {
            addCriterion("send_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeEqualTo(String value) {
            addCriterion("send_start_time =", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeNotEqualTo(String value) {
            addCriterion("send_start_time <>", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeGreaterThan(String value) {
            addCriterion("send_start_time >", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeGreaterThanOrEqualTo(String value) {
            addCriterion("send_start_time >=", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeLessThan(String value) {
            addCriterion("send_start_time <", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeLessThanOrEqualTo(String value) {
            addCriterion("send_start_time <=", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeLike(String value) {
            addCriterion("send_start_time like", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeNotLike(String value) {
            addCriterion("send_start_time not like", value, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeIn(List<String> values) {
            addCriterion("send_start_time in", values, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeNotIn(List<String> values) {
            addCriterion("send_start_time not in", values, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeBetween(String value1, String value2) {
            addCriterion("send_start_time between", value1, value2, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andSend_start_timeNotBetween(String value1, String value2) {
            addCriterion("send_start_time not between", value1, value2, "send_start_time");
            return (Criteria) this;
        }

        public Criteria andInsureIsNull() {
            addCriterion("insure is null");
            return (Criteria) this;
        }

        public Criteria andInsureIsNotNull() {
            addCriterion("insure is not null");
            return (Criteria) this;
        }

        public Criteria andInsureEqualTo(Double value) {
            addCriterion("insure =", value, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureNotEqualTo(Double value) {
            addCriterion("insure <>", value, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureGreaterThan(Double value) {
            addCriterion("insure >", value, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureGreaterThanOrEqualTo(Double value) {
            addCriterion("insure >=", value, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureLessThan(Double value) {
            addCriterion("insure <", value, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureLessThanOrEqualTo(Double value) {
            addCriterion("insure <=", value, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureIn(List<Double> values) {
            addCriterion("insure in", values, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureNotIn(List<Double> values) {
            addCriterion("insure not in", values, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureBetween(Double value1, Double value2) {
            addCriterion("insure between", value1, value2, "insure");
            return (Criteria) this;
        }

        public Criteria andInsureNotBetween(Double value1, Double value2) {
            addCriterion("insure not between", value1, value2, "insure");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andClub_countIsNull() {
            addCriterion("club_count is null");
            return (Criteria) this;
        }

        public Criteria andClub_countIsNotNull() {
            addCriterion("club_count is not null");
            return (Criteria) this;
        }

        public Criteria andClub_countEqualTo(Integer value) {
            addCriterion("club_count =", value, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countNotEqualTo(Integer value) {
            addCriterion("club_count <>", value, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countGreaterThan(Integer value) {
            addCriterion("club_count >", value, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("club_count >=", value, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countLessThan(Integer value) {
            addCriterion("club_count <", value, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countLessThanOrEqualTo(Integer value) {
            addCriterion("club_count <=", value, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countIn(List<Integer> values) {
            addCriterion("club_count in", values, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countNotIn(List<Integer> values) {
            addCriterion("club_count not in", values, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countBetween(Integer value1, Integer value2) {
            addCriterion("club_count between", value1, value2, "club_count");
            return (Criteria) this;
        }

        public Criteria andClub_countNotBetween(Integer value1, Integer value2) {
            addCriterion("club_count not between", value1, value2, "club_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countIsNull() {
            addCriterion("headcover_count is null");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countIsNotNull() {
            addCriterion("headcover_count is not null");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countEqualTo(Integer value) {
            addCriterion("headcover_count =", value, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countNotEqualTo(Integer value) {
            addCriterion("headcover_count <>", value, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countGreaterThan(Integer value) {
            addCriterion("headcover_count >", value, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("headcover_count >=", value, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countLessThan(Integer value) {
            addCriterion("headcover_count <", value, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countLessThanOrEqualTo(Integer value) {
            addCriterion("headcover_count <=", value, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countIn(List<Integer> values) {
            addCriterion("headcover_count in", values, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countNotIn(List<Integer> values) {
            addCriterion("headcover_count not in", values, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countBetween(Integer value1, Integer value2) {
            addCriterion("headcover_count between", value1, value2, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andHeadcover_countNotBetween(Integer value1, Integer value2) {
            addCriterion("headcover_count not between", value1, value2, "headcover_count");
            return (Criteria) this;
        }

        public Criteria andIs_memberIsNull() {
            addCriterion("is_member is null");
            return (Criteria) this;
        }

        public Criteria andIs_memberIsNotNull() {
            addCriterion("is_member is not null");
            return (Criteria) this;
        }

        public Criteria andIs_memberEqualTo(Boolean value) {
            addCriterion("is_member =", value, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberNotEqualTo(Boolean value) {
            addCriterion("is_member <>", value, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberGreaterThan(Boolean value) {
            addCriterion("is_member >", value, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_member >=", value, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberLessThan(Boolean value) {
            addCriterion("is_member <", value, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberLessThanOrEqualTo(Boolean value) {
            addCriterion("is_member <=", value, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberIn(List<Boolean> values) {
            addCriterion("is_member in", values, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberNotIn(List<Boolean> values) {
            addCriterion("is_member not in", values, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberBetween(Boolean value1, Boolean value2) {
            addCriterion("is_member between", value1, value2, "is_member");
            return (Criteria) this;
        }

        public Criteria andIs_memberNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_member not between", value1, value2, "is_member");
            return (Criteria) this;
        }

        public Criteria andMember_typeIsNull() {
            addCriterion("member_type is null");
            return (Criteria) this;
        }

        public Criteria andMember_typeIsNotNull() {
            addCriterion("member_type is not null");
            return (Criteria) this;
        }

        public Criteria andMember_typeEqualTo(String value) {
            addCriterion("member_type =", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeNotEqualTo(String value) {
            addCriterion("member_type <>", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeGreaterThan(String value) {
            addCriterion("member_type >", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeGreaterThanOrEqualTo(String value) {
            addCriterion("member_type >=", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeLessThan(String value) {
            addCriterion("member_type <", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeLessThanOrEqualTo(String value) {
            addCriterion("member_type <=", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeLike(String value) {
            addCriterion("member_type like", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeNotLike(String value) {
            addCriterion("member_type not like", value, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeIn(List<String> values) {
            addCriterion("member_type in", values, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeNotIn(List<String> values) {
            addCriterion("member_type not in", values, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeBetween(String value1, String value2) {
            addCriterion("member_type between", value1, value2, "member_type");
            return (Criteria) this;
        }

        public Criteria andMember_typeNotBetween(String value1, String value2) {
            addCriterion("member_type not between", value1, value2, "member_type");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateIsNull() {
            addCriterion("deliver_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateIsNotNull() {
            addCriterion("deliver_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateEqualTo(String value) {
            addCriterion("deliver_date =", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateNotEqualTo(String value) {
            addCriterion("deliver_date <>", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateGreaterThan(String value) {
            addCriterion("deliver_date >", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_date >=", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateLessThan(String value) {
            addCriterion("deliver_date <", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateLessThanOrEqualTo(String value) {
            addCriterion("deliver_date <=", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateLike(String value) {
            addCriterion("deliver_date like", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateNotLike(String value) {
            addCriterion("deliver_date not like", value, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateIn(List<String> values) {
            addCriterion("deliver_date in", values, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateNotIn(List<String> values) {
            addCriterion("deliver_date not in", values, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateBetween(String value1, String value2) {
            addCriterion("deliver_date between", value1, value2, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_dateNotBetween(String value1, String value2) {
            addCriterion("deliver_date not between", value1, value2, "deliver_date");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeIsNull() {
            addCriterion("deliver_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeIsNotNull() {
            addCriterion("deliver_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeEqualTo(String value) {
            addCriterion("deliver_time =", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeNotEqualTo(String value) {
            addCriterion("deliver_time <>", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeGreaterThan(String value) {
            addCriterion("deliver_time >", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_time >=", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeLessThan(String value) {
            addCriterion("deliver_time <", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeLessThanOrEqualTo(String value) {
            addCriterion("deliver_time <=", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeLike(String value) {
            addCriterion("deliver_time like", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeNotLike(String value) {
            addCriterion("deliver_time not like", value, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeIn(List<String> values) {
            addCriterion("deliver_time in", values, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeNotIn(List<String> values) {
            addCriterion("deliver_time not in", values, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeBetween(String value1, String value2) {
            addCriterion("deliver_time between", value1, value2, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_timeNotBetween(String value1, String value2) {
            addCriterion("deliver_time not between", value1, value2, "deliver_time");
            return (Criteria) this;
        }

        public Criteria andPlay_dateIsNull() {
            addCriterion("play_date is null");
            return (Criteria) this;
        }

        public Criteria andPlay_dateIsNotNull() {
            addCriterion("play_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlay_dateEqualTo(String value) {
            addCriterion("play_date =", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateNotEqualTo(String value) {
            addCriterion("play_date <>", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateGreaterThan(String value) {
            addCriterion("play_date >", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateGreaterThanOrEqualTo(String value) {
            addCriterion("play_date >=", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateLessThan(String value) {
            addCriterion("play_date <", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateLessThanOrEqualTo(String value) {
            addCriterion("play_date <=", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateLike(String value) {
            addCriterion("play_date like", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateNotLike(String value) {
            addCriterion("play_date not like", value, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateIn(List<String> values) {
            addCriterion("play_date in", values, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateNotIn(List<String> values) {
            addCriterion("play_date not in", values, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateBetween(String value1, String value2) {
            addCriterion("play_date between", value1, value2, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_dateNotBetween(String value1, String value2) {
            addCriterion("play_date not between", value1, value2, "play_date");
            return (Criteria) this;
        }

        public Criteria andPlay_timeIsNull() {
            addCriterion("play_time is null");
            return (Criteria) this;
        }

        public Criteria andPlay_timeIsNotNull() {
            addCriterion("play_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlay_timeEqualTo(String value) {
            addCriterion("play_time =", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeNotEqualTo(String value) {
            addCriterion("play_time <>", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeGreaterThan(String value) {
            addCriterion("play_time >", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeGreaterThanOrEqualTo(String value) {
            addCriterion("play_time >=", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeLessThan(String value) {
            addCriterion("play_time <", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeLessThanOrEqualTo(String value) {
            addCriterion("play_time <=", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeLike(String value) {
            addCriterion("play_time like", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeNotLike(String value) {
            addCriterion("play_time not like", value, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeIn(List<String> values) {
            addCriterion("play_time in", values, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeNotIn(List<String> values) {
            addCriterion("play_time not in", values, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeBetween(String value1, String value2) {
            addCriterion("play_time between", value1, value2, "play_time");
            return (Criteria) this;
        }

        public Criteria andPlay_timeNotBetween(String value1, String value2) {
            addCriterion("play_time not between", value1, value2, "play_time");
            return (Criteria) this;
        }

        public Criteria andJ_course_idIsNull() {
            addCriterion("j_course_id is null");
            return (Criteria) this;
        }

        public Criteria andJ_course_idIsNotNull() {
            addCriterion("j_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andJ_course_idEqualTo(Long value) {
            addCriterion("j_course_id =", value, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idNotEqualTo(Long value) {
            addCriterion("j_course_id <>", value, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idGreaterThan(Long value) {
            addCriterion("j_course_id >", value, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idGreaterThanOrEqualTo(Long value) {
            addCriterion("j_course_id >=", value, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idLessThan(Long value) {
            addCriterion("j_course_id <", value, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idLessThanOrEqualTo(Long value) {
            addCriterion("j_course_id <=", value, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idIn(List<Long> values) {
            addCriterion("j_course_id in", values, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idNotIn(List<Long> values) {
            addCriterion("j_course_id not in", values, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idBetween(Long value1, Long value2) {
            addCriterion("j_course_id between", value1, value2, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_course_idNotBetween(Long value1, Long value2) {
            addCriterion("j_course_id not between", value1, value2, "j_course_id");
            return (Criteria) this;
        }

        public Criteria andJ_contactIsNull() {
            addCriterion("j_contact is null");
            return (Criteria) this;
        }

        public Criteria andJ_contactIsNotNull() {
            addCriterion("j_contact is not null");
            return (Criteria) this;
        }

        public Criteria andJ_contactEqualTo(String value) {
            addCriterion("j_contact =", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactNotEqualTo(String value) {
            addCriterion("j_contact <>", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactGreaterThan(String value) {
            addCriterion("j_contact >", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactGreaterThanOrEqualTo(String value) {
            addCriterion("j_contact >=", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactLessThan(String value) {
            addCriterion("j_contact <", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactLessThanOrEqualTo(String value) {
            addCriterion("j_contact <=", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactLike(String value) {
            addCriterion("j_contact like", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactNotLike(String value) {
            addCriterion("j_contact not like", value, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactIn(List<String> values) {
            addCriterion("j_contact in", values, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactNotIn(List<String> values) {
            addCriterion("j_contact not in", values, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactBetween(String value1, String value2) {
            addCriterion("j_contact between", value1, value2, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_contactNotBetween(String value1, String value2) {
            addCriterion("j_contact not between", value1, value2, "j_contact");
            return (Criteria) this;
        }

        public Criteria andJ_mobileIsNull() {
            addCriterion("j_mobile is null");
            return (Criteria) this;
        }

        public Criteria andJ_mobileIsNotNull() {
            addCriterion("j_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andJ_mobileEqualTo(String value) {
            addCriterion("j_mobile =", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileNotEqualTo(String value) {
            addCriterion("j_mobile <>", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileGreaterThan(String value) {
            addCriterion("j_mobile >", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileGreaterThanOrEqualTo(String value) {
            addCriterion("j_mobile >=", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileLessThan(String value) {
            addCriterion("j_mobile <", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileLessThanOrEqualTo(String value) {
            addCriterion("j_mobile <=", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileLike(String value) {
            addCriterion("j_mobile like", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileNotLike(String value) {
            addCriterion("j_mobile not like", value, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileIn(List<String> values) {
            addCriterion("j_mobile in", values, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileNotIn(List<String> values) {
            addCriterion("j_mobile not in", values, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileBetween(String value1, String value2) {
            addCriterion("j_mobile between", value1, value2, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_mobileNotBetween(String value1, String value2) {
            addCriterion("j_mobile not between", value1, value2, "j_mobile");
            return (Criteria) this;
        }

        public Criteria andJ_provinceIsNull() {
            addCriterion("j_province is null");
            return (Criteria) this;
        }

        public Criteria andJ_provinceIsNotNull() {
            addCriterion("j_province is not null");
            return (Criteria) this;
        }

        public Criteria andJ_provinceEqualTo(String value) {
            addCriterion("j_province =", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotEqualTo(String value) {
            addCriterion("j_province <>", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceGreaterThan(String value) {
            addCriterion("j_province >", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("j_province >=", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceLessThan(String value) {
            addCriterion("j_province <", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceLessThanOrEqualTo(String value) {
            addCriterion("j_province <=", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceLike(String value) {
            addCriterion("j_province like", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotLike(String value) {
            addCriterion("j_province not like", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceIn(List<String> values) {
            addCriterion("j_province in", values, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotIn(List<String> values) {
            addCriterion("j_province not in", values, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceBetween(String value1, String value2) {
            addCriterion("j_province between", value1, value2, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotBetween(String value1, String value2) {
            addCriterion("j_province not between", value1, value2, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_cityIsNull() {
            addCriterion("j_city is null");
            return (Criteria) this;
        }

        public Criteria andJ_cityIsNotNull() {
            addCriterion("j_city is not null");
            return (Criteria) this;
        }

        public Criteria andJ_cityEqualTo(String value) {
            addCriterion("j_city =", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotEqualTo(String value) {
            addCriterion("j_city <>", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityGreaterThan(String value) {
            addCriterion("j_city >", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityGreaterThanOrEqualTo(String value) {
            addCriterion("j_city >=", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityLessThan(String value) {
            addCriterion("j_city <", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityLessThanOrEqualTo(String value) {
            addCriterion("j_city <=", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityLike(String value) {
            addCriterion("j_city like", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotLike(String value) {
            addCriterion("j_city not like", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityIn(List<String> values) {
            addCriterion("j_city in", values, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotIn(List<String> values) {
            addCriterion("j_city not in", values, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityBetween(String value1, String value2) {
            addCriterion("j_city between", value1, value2, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotBetween(String value1, String value2) {
            addCriterion("j_city not between", value1, value2, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_countyIsNull() {
            addCriterion("j_county is null");
            return (Criteria) this;
        }

        public Criteria andJ_countyIsNotNull() {
            addCriterion("j_county is not null");
            return (Criteria) this;
        }

        public Criteria andJ_countyEqualTo(String value) {
            addCriterion("j_county =", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotEqualTo(String value) {
            addCriterion("j_county <>", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyGreaterThan(String value) {
            addCriterion("j_county >", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyGreaterThanOrEqualTo(String value) {
            addCriterion("j_county >=", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyLessThan(String value) {
            addCriterion("j_county <", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyLessThanOrEqualTo(String value) {
            addCriterion("j_county <=", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyLike(String value) {
            addCriterion("j_county like", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotLike(String value) {
            addCriterion("j_county not like", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyIn(List<String> values) {
            addCriterion("j_county in", values, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotIn(List<String> values) {
            addCriterion("j_county not in", values, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyBetween(String value1, String value2) {
            addCriterion("j_county between", value1, value2, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotBetween(String value1, String value2) {
            addCriterion("j_county not between", value1, value2, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_addressIsNull() {
            addCriterion("j_address is null");
            return (Criteria) this;
        }

        public Criteria andJ_addressIsNotNull() {
            addCriterion("j_address is not null");
            return (Criteria) this;
        }

        public Criteria andJ_addressEqualTo(String value) {
            addCriterion("j_address =", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotEqualTo(String value) {
            addCriterion("j_address <>", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressGreaterThan(String value) {
            addCriterion("j_address >", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressGreaterThanOrEqualTo(String value) {
            addCriterion("j_address >=", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressLessThan(String value) {
            addCriterion("j_address <", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressLessThanOrEqualTo(String value) {
            addCriterion("j_address <=", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressLike(String value) {
            addCriterion("j_address like", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotLike(String value) {
            addCriterion("j_address not like", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressIn(List<String> values) {
            addCriterion("j_address in", values, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotIn(List<String> values) {
            addCriterion("j_address not in", values, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressBetween(String value1, String value2) {
            addCriterion("j_address between", value1, value2, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotBetween(String value1, String value2) {
            addCriterion("j_address not between", value1, value2, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameIsNull() {
            addCriterion("j_course_name is null");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameIsNotNull() {
            addCriterion("j_course_name is not null");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameEqualTo(String value) {
            addCriterion("j_course_name =", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameNotEqualTo(String value) {
            addCriterion("j_course_name <>", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameGreaterThan(String value) {
            addCriterion("j_course_name >", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameGreaterThanOrEqualTo(String value) {
            addCriterion("j_course_name >=", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameLessThan(String value) {
            addCriterion("j_course_name <", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameLessThanOrEqualTo(String value) {
            addCriterion("j_course_name <=", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameLike(String value) {
            addCriterion("j_course_name like", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameNotLike(String value) {
            addCriterion("j_course_name not like", value, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameIn(List<String> values) {
            addCriterion("j_course_name in", values, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameNotIn(List<String> values) {
            addCriterion("j_course_name not in", values, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameBetween(String value1, String value2) {
            addCriterion("j_course_name between", value1, value2, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_course_nameNotBetween(String value1, String value2) {
            addCriterion("j_course_name not between", value1, value2, "j_course_name");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noIsNull() {
            addCriterion("j_bag_no is null");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noIsNotNull() {
            addCriterion("j_bag_no is not null");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noEqualTo(String value) {
            addCriterion("j_bag_no =", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noNotEqualTo(String value) {
            addCriterion("j_bag_no <>", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noGreaterThan(String value) {
            addCriterion("j_bag_no >", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noGreaterThanOrEqualTo(String value) {
            addCriterion("j_bag_no >=", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noLessThan(String value) {
            addCriterion("j_bag_no <", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noLessThanOrEqualTo(String value) {
            addCriterion("j_bag_no <=", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noLike(String value) {
            addCriterion("j_bag_no like", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noNotLike(String value) {
            addCriterion("j_bag_no not like", value, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noIn(List<String> values) {
            addCriterion("j_bag_no in", values, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noNotIn(List<String> values) {
            addCriterion("j_bag_no not in", values, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noBetween(String value1, String value2) {
            addCriterion("j_bag_no between", value1, value2, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andJ_bag_noNotBetween(String value1, String value2) {
            addCriterion("j_bag_no not between", value1, value2, "j_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_course_idIsNull() {
            addCriterion("d_course_id is null");
            return (Criteria) this;
        }

        public Criteria andD_course_idIsNotNull() {
            addCriterion("d_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andD_course_idEqualTo(Long value) {
            addCriterion("d_course_id =", value, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idNotEqualTo(Long value) {
            addCriterion("d_course_id <>", value, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idGreaterThan(Long value) {
            addCriterion("d_course_id >", value, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idGreaterThanOrEqualTo(Long value) {
            addCriterion("d_course_id >=", value, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idLessThan(Long value) {
            addCriterion("d_course_id <", value, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idLessThanOrEqualTo(Long value) {
            addCriterion("d_course_id <=", value, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idIn(List<Long> values) {
            addCriterion("d_course_id in", values, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idNotIn(List<Long> values) {
            addCriterion("d_course_id not in", values, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idBetween(Long value1, Long value2) {
            addCriterion("d_course_id between", value1, value2, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_course_idNotBetween(Long value1, Long value2) {
            addCriterion("d_course_id not between", value1, value2, "d_course_id");
            return (Criteria) this;
        }

        public Criteria andD_contactIsNull() {
            addCriterion("d_contact is null");
            return (Criteria) this;
        }

        public Criteria andD_contactIsNotNull() {
            addCriterion("d_contact is not null");
            return (Criteria) this;
        }

        public Criteria andD_contactEqualTo(String value) {
            addCriterion("d_contact =", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactNotEqualTo(String value) {
            addCriterion("d_contact <>", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactGreaterThan(String value) {
            addCriterion("d_contact >", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactGreaterThanOrEqualTo(String value) {
            addCriterion("d_contact >=", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactLessThan(String value) {
            addCriterion("d_contact <", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactLessThanOrEqualTo(String value) {
            addCriterion("d_contact <=", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactLike(String value) {
            addCriterion("d_contact like", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactNotLike(String value) {
            addCriterion("d_contact not like", value, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactIn(List<String> values) {
            addCriterion("d_contact in", values, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactNotIn(List<String> values) {
            addCriterion("d_contact not in", values, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactBetween(String value1, String value2) {
            addCriterion("d_contact between", value1, value2, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_contactNotBetween(String value1, String value2) {
            addCriterion("d_contact not between", value1, value2, "d_contact");
            return (Criteria) this;
        }

        public Criteria andD_mobileIsNull() {
            addCriterion("d_mobile is null");
            return (Criteria) this;
        }

        public Criteria andD_mobileIsNotNull() {
            addCriterion("d_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andD_mobileEqualTo(String value) {
            addCriterion("d_mobile =", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileNotEqualTo(String value) {
            addCriterion("d_mobile <>", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileGreaterThan(String value) {
            addCriterion("d_mobile >", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileGreaterThanOrEqualTo(String value) {
            addCriterion("d_mobile >=", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileLessThan(String value) {
            addCriterion("d_mobile <", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileLessThanOrEqualTo(String value) {
            addCriterion("d_mobile <=", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileLike(String value) {
            addCriterion("d_mobile like", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileNotLike(String value) {
            addCriterion("d_mobile not like", value, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileIn(List<String> values) {
            addCriterion("d_mobile in", values, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileNotIn(List<String> values) {
            addCriterion("d_mobile not in", values, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileBetween(String value1, String value2) {
            addCriterion("d_mobile between", value1, value2, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_mobileNotBetween(String value1, String value2) {
            addCriterion("d_mobile not between", value1, value2, "d_mobile");
            return (Criteria) this;
        }

        public Criteria andD_provinceIsNull() {
            addCriterion("d_province is null");
            return (Criteria) this;
        }

        public Criteria andD_provinceIsNotNull() {
            addCriterion("d_province is not null");
            return (Criteria) this;
        }

        public Criteria andD_provinceEqualTo(String value) {
            addCriterion("d_province =", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotEqualTo(String value) {
            addCriterion("d_province <>", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceGreaterThan(String value) {
            addCriterion("d_province >", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("d_province >=", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceLessThan(String value) {
            addCriterion("d_province <", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceLessThanOrEqualTo(String value) {
            addCriterion("d_province <=", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceLike(String value) {
            addCriterion("d_province like", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotLike(String value) {
            addCriterion("d_province not like", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceIn(List<String> values) {
            addCriterion("d_province in", values, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotIn(List<String> values) {
            addCriterion("d_province not in", values, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceBetween(String value1, String value2) {
            addCriterion("d_province between", value1, value2, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotBetween(String value1, String value2) {
            addCriterion("d_province not between", value1, value2, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_cityIsNull() {
            addCriterion("d_city is null");
            return (Criteria) this;
        }

        public Criteria andD_cityIsNotNull() {
            addCriterion("d_city is not null");
            return (Criteria) this;
        }

        public Criteria andD_cityEqualTo(String value) {
            addCriterion("d_city =", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotEqualTo(String value) {
            addCriterion("d_city <>", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityGreaterThan(String value) {
            addCriterion("d_city >", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityGreaterThanOrEqualTo(String value) {
            addCriterion("d_city >=", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityLessThan(String value) {
            addCriterion("d_city <", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityLessThanOrEqualTo(String value) {
            addCriterion("d_city <=", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityLike(String value) {
            addCriterion("d_city like", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotLike(String value) {
            addCriterion("d_city not like", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityIn(List<String> values) {
            addCriterion("d_city in", values, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotIn(List<String> values) {
            addCriterion("d_city not in", values, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityBetween(String value1, String value2) {
            addCriterion("d_city between", value1, value2, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotBetween(String value1, String value2) {
            addCriterion("d_city not between", value1, value2, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_countyIsNull() {
            addCriterion("d_county is null");
            return (Criteria) this;
        }

        public Criteria andD_countyIsNotNull() {
            addCriterion("d_county is not null");
            return (Criteria) this;
        }

        public Criteria andD_countyEqualTo(String value) {
            addCriterion("d_county =", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotEqualTo(String value) {
            addCriterion("d_county <>", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyGreaterThan(String value) {
            addCriterion("d_county >", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyGreaterThanOrEqualTo(String value) {
            addCriterion("d_county >=", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyLessThan(String value) {
            addCriterion("d_county <", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyLessThanOrEqualTo(String value) {
            addCriterion("d_county <=", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyLike(String value) {
            addCriterion("d_county like", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotLike(String value) {
            addCriterion("d_county not like", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyIn(List<String> values) {
            addCriterion("d_county in", values, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotIn(List<String> values) {
            addCriterion("d_county not in", values, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyBetween(String value1, String value2) {
            addCriterion("d_county between", value1, value2, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotBetween(String value1, String value2) {
            addCriterion("d_county not between", value1, value2, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_addressIsNull() {
            addCriterion("d_address is null");
            return (Criteria) this;
        }

        public Criteria andD_addressIsNotNull() {
            addCriterion("d_address is not null");
            return (Criteria) this;
        }

        public Criteria andD_addressEqualTo(String value) {
            addCriterion("d_address =", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotEqualTo(String value) {
            addCriterion("d_address <>", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressGreaterThan(String value) {
            addCriterion("d_address >", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressGreaterThanOrEqualTo(String value) {
            addCriterion("d_address >=", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressLessThan(String value) {
            addCriterion("d_address <", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressLessThanOrEqualTo(String value) {
            addCriterion("d_address <=", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressLike(String value) {
            addCriterion("d_address like", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotLike(String value) {
            addCriterion("d_address not like", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressIn(List<String> values) {
            addCriterion("d_address in", values, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotIn(List<String> values) {
            addCriterion("d_address not in", values, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressBetween(String value1, String value2) {
            addCriterion("d_address between", value1, value2, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotBetween(String value1, String value2) {
            addCriterion("d_address not between", value1, value2, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_course_nameIsNull() {
            addCriterion("d_course_name is null");
            return (Criteria) this;
        }

        public Criteria andD_course_nameIsNotNull() {
            addCriterion("d_course_name is not null");
            return (Criteria) this;
        }

        public Criteria andD_course_nameEqualTo(String value) {
            addCriterion("d_course_name =", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameNotEqualTo(String value) {
            addCriterion("d_course_name <>", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameGreaterThan(String value) {
            addCriterion("d_course_name >", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameGreaterThanOrEqualTo(String value) {
            addCriterion("d_course_name >=", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameLessThan(String value) {
            addCriterion("d_course_name <", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameLessThanOrEqualTo(String value) {
            addCriterion("d_course_name <=", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameLike(String value) {
            addCriterion("d_course_name like", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameNotLike(String value) {
            addCriterion("d_course_name not like", value, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameIn(List<String> values) {
            addCriterion("d_course_name in", values, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameNotIn(List<String> values) {
            addCriterion("d_course_name not in", values, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameBetween(String value1, String value2) {
            addCriterion("d_course_name between", value1, value2, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_course_nameNotBetween(String value1, String value2) {
            addCriterion("d_course_name not between", value1, value2, "d_course_name");
            return (Criteria) this;
        }

        public Criteria andD_bag_noIsNull() {
            addCriterion("d_bag_no is null");
            return (Criteria) this;
        }

        public Criteria andD_bag_noIsNotNull() {
            addCriterion("d_bag_no is not null");
            return (Criteria) this;
        }

        public Criteria andD_bag_noEqualTo(String value) {
            addCriterion("d_bag_no =", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noNotEqualTo(String value) {
            addCriterion("d_bag_no <>", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noGreaterThan(String value) {
            addCriterion("d_bag_no >", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noGreaterThanOrEqualTo(String value) {
            addCriterion("d_bag_no >=", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noLessThan(String value) {
            addCriterion("d_bag_no <", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noLessThanOrEqualTo(String value) {
            addCriterion("d_bag_no <=", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noLike(String value) {
            addCriterion("d_bag_no like", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noNotLike(String value) {
            addCriterion("d_bag_no not like", value, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noIn(List<String> values) {
            addCriterion("d_bag_no in", values, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noNotIn(List<String> values) {
            addCriterion("d_bag_no not in", values, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noBetween(String value1, String value2) {
            addCriterion("d_bag_no between", value1, value2, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andD_bag_noNotBetween(String value1, String value2) {
            addCriterion("d_bag_no not between", value1, value2, "d_bag_no");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_atEqualTo(Date value) {
            addCriterion("created_at =", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThan(Date value) {
            addCriterion("created_at >", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThan(Date value) {
            addCriterion("created_at <", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atIn(List<Date> values) {
            addCriterion("created_at in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andIs_paidIsNull() {
            addCriterion("is_paid is null");
            return (Criteria) this;
        }

        public Criteria andIs_paidIsNotNull() {
            addCriterion("is_paid is not null");
            return (Criteria) this;
        }

        public Criteria andIs_paidEqualTo(Boolean value) {
            addCriterion("is_paid =", value, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidNotEqualTo(Boolean value) {
            addCriterion("is_paid <>", value, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidGreaterThan(Boolean value) {
            addCriterion("is_paid >", value, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_paid >=", value, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidLessThan(Boolean value) {
            addCriterion("is_paid <", value, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidLessThanOrEqualTo(Boolean value) {
            addCriterion("is_paid <=", value, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidIn(List<Boolean> values) {
            addCriterion("is_paid in", values, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidNotIn(List<Boolean> values) {
            addCriterion("is_paid not in", values, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidBetween(Boolean value1, Boolean value2) {
            addCriterion("is_paid between", value1, value2, "is_paid");
            return (Criteria) this;
        }

        public Criteria andIs_paidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_paid not between", value1, value2, "is_paid");
            return (Criteria) this;
        }

        public Criteria andPaid_atIsNull() {
            addCriterion("paid_at is null");
            return (Criteria) this;
        }

        public Criteria andPaid_atIsNotNull() {
            addCriterion("paid_at is not null");
            return (Criteria) this;
        }

        public Criteria andPaid_atEqualTo(Date value) {
            addCriterion("paid_at =", value, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atNotEqualTo(Date value) {
            addCriterion("paid_at <>", value, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atGreaterThan(Date value) {
            addCriterion("paid_at >", value, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atGreaterThanOrEqualTo(Date value) {
            addCriterion("paid_at >=", value, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atLessThan(Date value) {
            addCriterion("paid_at <", value, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atLessThanOrEqualTo(Date value) {
            addCriterion("paid_at <=", value, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atIn(List<Date> values) {
            addCriterion("paid_at in", values, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atNotIn(List<Date> values) {
            addCriterion("paid_at not in", values, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atBetween(Date value1, Date value2) {
            addCriterion("paid_at between", value1, value2, "paid_at");
            return (Criteria) this;
        }

        public Criteria andPaid_atNotBetween(Date value1, Date value2) {
            addCriterion("paid_at not between", value1, value2, "paid_at");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Short value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Short value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Short value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Short value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Short value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Short value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Short> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Short> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Short value1, Short value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Short value1, Short value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andBank_idIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBank_idIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBank_idEqualTo(Long value) {
            addCriterion("bank_id =", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotEqualTo(Long value) {
            addCriterion("bank_id <>", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idGreaterThan(Long value) {
            addCriterion("bank_id >", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idGreaterThanOrEqualTo(Long value) {
            addCriterion("bank_id >=", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLessThan(Long value) {
            addCriterion("bank_id <", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLessThanOrEqualTo(Long value) {
            addCriterion("bank_id <=", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idIn(List<Long> values) {
            addCriterion("bank_id in", values, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotIn(List<Long> values) {
            addCriterion("bank_id not in", values, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idBetween(Long value1, Long value2) {
            addCriterion("bank_id between", value1, value2, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotBetween(Long value1, Long value2) {
            addCriterion("bank_id not between", value1, value2, "bank_id");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signIsNull() {
            addCriterion("coordinate_sign is null");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signIsNotNull() {
            addCriterion("coordinate_sign is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signEqualTo(Boolean value) {
            addCriterion("coordinate_sign =", value, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signNotEqualTo(Boolean value) {
            addCriterion("coordinate_sign <>", value, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signGreaterThan(Boolean value) {
            addCriterion("coordinate_sign >", value, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signGreaterThanOrEqualTo(Boolean value) {
            addCriterion("coordinate_sign >=", value, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signLessThan(Boolean value) {
            addCriterion("coordinate_sign <", value, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signLessThanOrEqualTo(Boolean value) {
            addCriterion("coordinate_sign <=", value, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signIn(List<Boolean> values) {
            addCriterion("coordinate_sign in", values, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signNotIn(List<Boolean> values) {
            addCriterion("coordinate_sign not in", values, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signBetween(Boolean value1, Boolean value2) {
            addCriterion("coordinate_sign between", value1, value2, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andCoordinate_signNotBetween(Boolean value1, Boolean value2) {
            addCriterion("coordinate_sign not between", value1, value2, "coordinate_sign");
            return (Criteria) this;
        }

        public Criteria andSign_remarkIsNull() {
            addCriterion("sign_remark is null");
            return (Criteria) this;
        }

        public Criteria andSign_remarkIsNotNull() {
            addCriterion("sign_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSign_remarkEqualTo(String value) {
            addCriterion("sign_remark =", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkNotEqualTo(String value) {
            addCriterion("sign_remark <>", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkGreaterThan(String value) {
            addCriterion("sign_remark >", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("sign_remark >=", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkLessThan(String value) {
            addCriterion("sign_remark <", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkLessThanOrEqualTo(String value) {
            addCriterion("sign_remark <=", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkLike(String value) {
            addCriterion("sign_remark like", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkNotLike(String value) {
            addCriterion("sign_remark not like", value, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkIn(List<String> values) {
            addCriterion("sign_remark in", values, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkNotIn(List<String> values) {
            addCriterion("sign_remark not in", values, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkBetween(String value1, String value2) {
            addCriterion("sign_remark between", value1, value2, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andSign_remarkNotBetween(String value1, String value2) {
            addCriterion("sign_remark not between", value1, value2, "sign_remark");
            return (Criteria) this;
        }

        public Criteria andAllow_signIsNull() {
            addCriterion("allow_sign is null");
            return (Criteria) this;
        }

        public Criteria andAllow_signIsNotNull() {
            addCriterion("allow_sign is not null");
            return (Criteria) this;
        }

        public Criteria andAllow_signEqualTo(Boolean value) {
            addCriterion("allow_sign =", value, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signNotEqualTo(Boolean value) {
            addCriterion("allow_sign <>", value, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signGreaterThan(Boolean value) {
            addCriterion("allow_sign >", value, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allow_sign >=", value, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signLessThan(Boolean value) {
            addCriterion("allow_sign <", value, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signLessThanOrEqualTo(Boolean value) {
            addCriterion("allow_sign <=", value, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signIn(List<Boolean> values) {
            addCriterion("allow_sign in", values, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signNotIn(List<Boolean> values) {
            addCriterion("allow_sign not in", values, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_sign between", value1, value2, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andAllow_signNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_sign not between", value1, value2, "allow_sign");
            return (Criteria) this;
        }

        public Criteria andSign_locationIsNull() {
            addCriterion("sign_location is null");
            return (Criteria) this;
        }

        public Criteria andSign_locationIsNotNull() {
            addCriterion("sign_location is not null");
            return (Criteria) this;
        }

        public Criteria andSign_locationEqualTo(Short value) {
            addCriterion("sign_location =", value, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationNotEqualTo(Short value) {
            addCriterion("sign_location <>", value, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationGreaterThan(Short value) {
            addCriterion("sign_location >", value, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationGreaterThanOrEqualTo(Short value) {
            addCriterion("sign_location >=", value, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationLessThan(Short value) {
            addCriterion("sign_location <", value, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationLessThanOrEqualTo(Short value) {
            addCriterion("sign_location <=", value, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationIn(List<Short> values) {
            addCriterion("sign_location in", values, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationNotIn(List<Short> values) {
            addCriterion("sign_location not in", values, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationBetween(Short value1, Short value2) {
            addCriterion("sign_location between", value1, value2, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSign_locationNotBetween(Short value1, Short value2) {
            addCriterion("sign_location not between", value1, value2, "sign_location");
            return (Criteria) this;
        }

        public Criteria andSent_remarkIsNull() {
            addCriterion("sent_remark is null");
            return (Criteria) this;
        }

        public Criteria andSent_remarkIsNotNull() {
            addCriterion("sent_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSent_remarkEqualTo(String value) {
            addCriterion("sent_remark =", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkNotEqualTo(String value) {
            addCriterion("sent_remark <>", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkGreaterThan(String value) {
            addCriterion("sent_remark >", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("sent_remark >=", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkLessThan(String value) {
            addCriterion("sent_remark <", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkLessThanOrEqualTo(String value) {
            addCriterion("sent_remark <=", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkLike(String value) {
            addCriterion("sent_remark like", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkNotLike(String value) {
            addCriterion("sent_remark not like", value, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkIn(List<String> values) {
            addCriterion("sent_remark in", values, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkNotIn(List<String> values) {
            addCriterion("sent_remark not in", values, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkBetween(String value1, String value2) {
            addCriterion("sent_remark between", value1, value2, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andSent_remarkNotBetween(String value1, String value2) {
            addCriterion("sent_remark not between", value1, value2, "sent_remark");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagIsNull() {
            addCriterion("has_send_bag is null");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagIsNotNull() {
            addCriterion("has_send_bag is not null");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagEqualTo(Boolean value) {
            addCriterion("has_send_bag =", value, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagNotEqualTo(Boolean value) {
            addCriterion("has_send_bag <>", value, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagGreaterThan(Boolean value) {
            addCriterion("has_send_bag >", value, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_send_bag >=", value, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagLessThan(Boolean value) {
            addCriterion("has_send_bag <", value, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagLessThanOrEqualTo(Boolean value) {
            addCriterion("has_send_bag <=", value, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagIn(List<Boolean> values) {
            addCriterion("has_send_bag in", values, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagNotIn(List<Boolean> values) {
            addCriterion("has_send_bag not in", values, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagBetween(Boolean value1, Boolean value2) {
            addCriterion("has_send_bag between", value1, value2, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andHas_send_bagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_send_bag not between", value1, value2, "has_send_bag");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountEqualTo(Double value) {
            addCriterion("total_amount =", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotEqualTo(Double value) {
            addCriterion("total_amount <>", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThan(Double value) {
            addCriterion("total_amount >", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThanOrEqualTo(Double value) {
            addCriterion("total_amount >=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThan(Double value) {
            addCriterion("total_amount <", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThanOrEqualTo(Double value) {
            addCriterion("total_amount <=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIn(List<Double> values) {
            addCriterion("total_amount in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotIn(List<Double> values) {
            addCriterion("total_amount not in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountBetween(Double value1, Double value2) {
            addCriterion("total_amount between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotBetween(Double value1, Double value2) {
            addCriterion("total_amount not between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andCoupon_idIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCoupon_idIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoupon_idEqualTo(Long value) {
            addCriterion("coupon_id =", value, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idLessThan(Long value) {
            addCriterion("coupon_id <", value, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idIn(List<Long> values) {
            addCriterion("coupon_id in", values, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idNotIn(List<Long> values) {
            addCriterion("coupon_id not in", values, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_idNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "coupon_id");
            return (Criteria) this;
        }

        public Criteria andVoucherIsNull() {
            addCriterion("voucher is null");
            return (Criteria) this;
        }

        public Criteria andVoucherIsNotNull() {
            addCriterion("voucher is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherEqualTo(Double value) {
            addCriterion("voucher =", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherNotEqualTo(Double value) {
            addCriterion("voucher <>", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherGreaterThan(Double value) {
            addCriterion("voucher >", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherGreaterThanOrEqualTo(Double value) {
            addCriterion("voucher >=", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherLessThan(Double value) {
            addCriterion("voucher <", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherLessThanOrEqualTo(Double value) {
            addCriterion("voucher <=", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherIn(List<Double> values) {
            addCriterion("voucher in", values, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherNotIn(List<Double> values) {
            addCriterion("voucher not in", values, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherBetween(Double value1, Double value2) {
            addCriterion("voucher between", value1, value2, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherNotBetween(Double value1, Double value2) {
            addCriterion("voucher not between", value1, value2, "voucher");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountIsNull() {
            addCriterion("special_amount is null");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountIsNotNull() {
            addCriterion("special_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountEqualTo(Double value) {
            addCriterion("special_amount =", value, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountNotEqualTo(Double value) {
            addCriterion("special_amount <>", value, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountGreaterThan(Double value) {
            addCriterion("special_amount >", value, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountGreaterThanOrEqualTo(Double value) {
            addCriterion("special_amount >=", value, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountLessThan(Double value) {
            addCriterion("special_amount <", value, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountLessThanOrEqualTo(Double value) {
            addCriterion("special_amount <=", value, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountIn(List<Double> values) {
            addCriterion("special_amount in", values, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountNotIn(List<Double> values) {
            addCriterion("special_amount not in", values, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountBetween(Double value1, Double value2) {
            addCriterion("special_amount between", value1, value2, "special_amount");
            return (Criteria) this;
        }

        public Criteria andSpecial_amountNotBetween(Double value1, Double value2) {
            addCriterion("special_amount not between", value1, value2, "special_amount");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Double value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Double value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Double value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Double value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Double value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Double value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Double> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Double> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Double value1, Double value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Double value1, Double value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeIsNull() {
            addCriterion("coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeIsNotNull() {
            addCriterion("coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeEqualTo(String value) {
            addCriterion("coupon_code =", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeNotEqualTo(String value) {
            addCriterion("coupon_code <>", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeGreaterThan(String value) {
            addCriterion("coupon_code >", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_code >=", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeLessThan(String value) {
            addCriterion("coupon_code <", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeLessThanOrEqualTo(String value) {
            addCriterion("coupon_code <=", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeLike(String value) {
            addCriterion("coupon_code like", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeNotLike(String value) {
            addCriterion("coupon_code not like", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeIn(List<String> values) {
            addCriterion("coupon_code in", values, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeNotIn(List<String> values) {
            addCriterion("coupon_code not in", values, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeBetween(String value1, String value2) {
            addCriterion("coupon_code between", value1, value2, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCoupon_codeNotBetween(String value1, String value2) {
            addCriterion("coupon_code not between", value1, value2, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsIsNull() {
            addCriterion("voucher_items is null");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsIsNotNull() {
            addCriterion("voucher_items is not null");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsEqualTo(String value) {
            addCriterion("voucher_items =", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsNotEqualTo(String value) {
            addCriterion("voucher_items <>", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsGreaterThan(String value) {
            addCriterion("voucher_items >", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsGreaterThanOrEqualTo(String value) {
            addCriterion("voucher_items >=", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsLessThan(String value) {
            addCriterion("voucher_items <", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsLessThanOrEqualTo(String value) {
            addCriterion("voucher_items <=", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsLike(String value) {
            addCriterion("voucher_items like", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsNotLike(String value) {
            addCriterion("voucher_items not like", value, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsIn(List<String> values) {
            addCriterion("voucher_items in", values, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsNotIn(List<String> values) {
            addCriterion("voucher_items not in", values, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsBetween(String value1, String value2) {
            addCriterion("voucher_items between", value1, value2, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andVoucher_itemsNotBetween(String value1, String value2) {
            addCriterion("voucher_items not between", value1, value2, "voucher_items");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkIsNull() {
            addCriterion("contraband_goods_remark is null");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkIsNotNull() {
            addCriterion("contraband_goods_remark is not null");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkEqualTo(String value) {
            addCriterion("contraband_goods_remark =", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkNotEqualTo(String value) {
            addCriterion("contraband_goods_remark <>", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkGreaterThan(String value) {
            addCriterion("contraband_goods_remark >", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("contraband_goods_remark >=", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkLessThan(String value) {
            addCriterion("contraband_goods_remark <", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkLessThanOrEqualTo(String value) {
            addCriterion("contraband_goods_remark <=", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkLike(String value) {
            addCriterion("contraband_goods_remark like", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkNotLike(String value) {
            addCriterion("contraband_goods_remark not like", value, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkIn(List<String> values) {
            addCriterion("contraband_goods_remark in", values, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkNotIn(List<String> values) {
            addCriterion("contraband_goods_remark not in", values, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkBetween(String value1, String value2) {
            addCriterion("contraband_goods_remark between", value1, value2, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andContraband_goods_remarkNotBetween(String value1, String value2) {
            addCriterion("contraband_goods_remark not between", value1, value2, "contraband_goods_remark");
            return (Criteria) this;
        }

        public Criteria andIs_bookingIsNull() {
            addCriterion("is_booking is null");
            return (Criteria) this;
        }

        public Criteria andIs_bookingIsNotNull() {
            addCriterion("is_booking is not null");
            return (Criteria) this;
        }

        public Criteria andIs_bookingEqualTo(Boolean value) {
            addCriterion("is_booking =", value, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingNotEqualTo(Boolean value) {
            addCriterion("is_booking <>", value, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingGreaterThan(Boolean value) {
            addCriterion("is_booking >", value, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_booking >=", value, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingLessThan(Boolean value) {
            addCriterion("is_booking <", value, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingLessThanOrEqualTo(Boolean value) {
            addCriterion("is_booking <=", value, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingIn(List<Boolean> values) {
            addCriterion("is_booking in", values, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingNotIn(List<Boolean> values) {
            addCriterion("is_booking not in", values, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingBetween(Boolean value1, Boolean value2) {
            addCriterion("is_booking between", value1, value2, "is_booking");
            return (Criteria) this;
        }

        public Criteria andIs_bookingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_booking not between", value1, value2, "is_booking");
            return (Criteria) this;
        }

        public Criteria andBooking_statusIsNull() {
            addCriterion("booking_status is null");
            return (Criteria) this;
        }

        public Criteria andBooking_statusIsNotNull() {
            addCriterion("booking_status is not null");
            return (Criteria) this;
        }

        public Criteria andBooking_statusEqualTo(Integer value) {
            addCriterion("booking_status =", value, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusNotEqualTo(Integer value) {
            addCriterion("booking_status <>", value, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusGreaterThan(Integer value) {
            addCriterion("booking_status >", value, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("booking_status >=", value, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusLessThan(Integer value) {
            addCriterion("booking_status <", value, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusLessThanOrEqualTo(Integer value) {
            addCriterion("booking_status <=", value, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusIn(List<Integer> values) {
            addCriterion("booking_status in", values, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusNotIn(List<Integer> values) {
            addCriterion("booking_status not in", values, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusBetween(Integer value1, Integer value2) {
            addCriterion("booking_status between", value1, value2, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("booking_status not between", value1, value2, "booking_status");
            return (Criteria) this;
        }

        public Criteria andBooking_priceIsNull() {
            addCriterion("booking_price is null");
            return (Criteria) this;
        }

        public Criteria andBooking_priceIsNotNull() {
            addCriterion("booking_price is not null");
            return (Criteria) this;
        }

        public Criteria andBooking_priceEqualTo(Double value) {
            addCriterion("booking_price =", value, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceNotEqualTo(Double value) {
            addCriterion("booking_price <>", value, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceGreaterThan(Double value) {
            addCriterion("booking_price >", value, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("booking_price >=", value, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceLessThan(Double value) {
            addCriterion("booking_price <", value, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceLessThanOrEqualTo(Double value) {
            addCriterion("booking_price <=", value, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceIn(List<Double> values) {
            addCriterion("booking_price in", values, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceNotIn(List<Double> values) {
            addCriterion("booking_price not in", values, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceBetween(Double value1, Double value2) {
            addCriterion("booking_price between", value1, value2, "booking_price");
            return (Criteria) this;
        }

        public Criteria andBooking_priceNotBetween(Double value1, Double value2) {
            addCriterion("booking_price not between", value1, value2, "booking_price");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeIsNull() {
            addCriterion("j_addr_type is null");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeIsNotNull() {
            addCriterion("j_addr_type is not null");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeEqualTo(String value) {
            addCriterion("j_addr_type =", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeNotEqualTo(String value) {
            addCriterion("j_addr_type <>", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeGreaterThan(String value) {
            addCriterion("j_addr_type >", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeGreaterThanOrEqualTo(String value) {
            addCriterion("j_addr_type >=", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeLessThan(String value) {
            addCriterion("j_addr_type <", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeLessThanOrEqualTo(String value) {
            addCriterion("j_addr_type <=", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeLike(String value) {
            addCriterion("j_addr_type like", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeNotLike(String value) {
            addCriterion("j_addr_type not like", value, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeIn(List<String> values) {
            addCriterion("j_addr_type in", values, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeNotIn(List<String> values) {
            addCriterion("j_addr_type not in", values, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeBetween(String value1, String value2) {
            addCriterion("j_addr_type between", value1, value2, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_addr_typeNotBetween(String value1, String value2) {
            addCriterion("j_addr_type not between", value1, value2, "j_addr_type");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idIsNull() {
            addCriterion("j_special_addr_id is null");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idIsNotNull() {
            addCriterion("j_special_addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idEqualTo(Long value) {
            addCriterion("j_special_addr_id =", value, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idNotEqualTo(Long value) {
            addCriterion("j_special_addr_id <>", value, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idGreaterThan(Long value) {
            addCriterion("j_special_addr_id >", value, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idGreaterThanOrEqualTo(Long value) {
            addCriterion("j_special_addr_id >=", value, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idLessThan(Long value) {
            addCriterion("j_special_addr_id <", value, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idLessThanOrEqualTo(Long value) {
            addCriterion("j_special_addr_id <=", value, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idIn(List<Long> values) {
            addCriterion("j_special_addr_id in", values, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idNotIn(List<Long> values) {
            addCriterion("j_special_addr_id not in", values, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idBetween(Long value1, Long value2) {
            addCriterion("j_special_addr_id between", value1, value2, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andJ_special_addr_idNotBetween(Long value1, Long value2) {
            addCriterion("j_special_addr_id not between", value1, value2, "j_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeIsNull() {
            addCriterion("d_addr_type is null");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeIsNotNull() {
            addCriterion("d_addr_type is not null");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeEqualTo(String value) {
            addCriterion("d_addr_type =", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeNotEqualTo(String value) {
            addCriterion("d_addr_type <>", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeGreaterThan(String value) {
            addCriterion("d_addr_type >", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeGreaterThanOrEqualTo(String value) {
            addCriterion("d_addr_type >=", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeLessThan(String value) {
            addCriterion("d_addr_type <", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeLessThanOrEqualTo(String value) {
            addCriterion("d_addr_type <=", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeLike(String value) {
            addCriterion("d_addr_type like", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeNotLike(String value) {
            addCriterion("d_addr_type not like", value, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeIn(List<String> values) {
            addCriterion("d_addr_type in", values, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeNotIn(List<String> values) {
            addCriterion("d_addr_type not in", values, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeBetween(String value1, String value2) {
            addCriterion("d_addr_type between", value1, value2, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_addr_typeNotBetween(String value1, String value2) {
            addCriterion("d_addr_type not between", value1, value2, "d_addr_type");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idIsNull() {
            addCriterion("d_special_addr_id is null");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idIsNotNull() {
            addCriterion("d_special_addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idEqualTo(Long value) {
            addCriterion("d_special_addr_id =", value, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idNotEqualTo(Long value) {
            addCriterion("d_special_addr_id <>", value, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idGreaterThan(Long value) {
            addCriterion("d_special_addr_id >", value, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idGreaterThanOrEqualTo(Long value) {
            addCriterion("d_special_addr_id >=", value, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idLessThan(Long value) {
            addCriterion("d_special_addr_id <", value, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idLessThanOrEqualTo(Long value) {
            addCriterion("d_special_addr_id <=", value, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idIn(List<Long> values) {
            addCriterion("d_special_addr_id in", values, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idNotIn(List<Long> values) {
            addCriterion("d_special_addr_id not in", values, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idBetween(Long value1, Long value2) {
            addCriterion("d_special_addr_id between", value1, value2, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andD_special_addr_idNotBetween(Long value1, Long value2) {
            addCriterion("d_special_addr_id not between", value1, value2, "d_special_addr_id");
            return (Criteria) this;
        }

        public Criteria andFavorablesIsNull() {
            addCriterion("favorables is null");
            return (Criteria) this;
        }

        public Criteria andFavorablesIsNotNull() {
            addCriterion("favorables is not null");
            return (Criteria) this;
        }

        public Criteria andFavorablesEqualTo(String value) {
            addCriterion("favorables =", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesNotEqualTo(String value) {
            addCriterion("favorables <>", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesGreaterThan(String value) {
            addCriterion("favorables >", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesGreaterThanOrEqualTo(String value) {
            addCriterion("favorables >=", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesLessThan(String value) {
            addCriterion("favorables <", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesLessThanOrEqualTo(String value) {
            addCriterion("favorables <=", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesLike(String value) {
            addCriterion("favorables like", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesNotLike(String value) {
            addCriterion("favorables not like", value, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesIn(List<String> values) {
            addCriterion("favorables in", values, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesNotIn(List<String> values) {
            addCriterion("favorables not in", values, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesBetween(String value1, String value2) {
            addCriterion("favorables between", value1, value2, "favorables");
            return (Criteria) this;
        }

        public Criteria andFavorablesNotBetween(String value1, String value2) {
            addCriterion("favorables not between", value1, value2, "favorables");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionIsNull() {
            addCriterion("send_time_section is null");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionIsNotNull() {
            addCriterion("send_time_section is not null");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionEqualTo(String value) {
            addCriterion("send_time_section =", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionNotEqualTo(String value) {
            addCriterion("send_time_section <>", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionGreaterThan(String value) {
            addCriterion("send_time_section >", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionGreaterThanOrEqualTo(String value) {
            addCriterion("send_time_section >=", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionLessThan(String value) {
            addCriterion("send_time_section <", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionLessThanOrEqualTo(String value) {
            addCriterion("send_time_section <=", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionLike(String value) {
            addCriterion("send_time_section like", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionNotLike(String value) {
            addCriterion("send_time_section not like", value, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionIn(List<String> values) {
            addCriterion("send_time_section in", values, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionNotIn(List<String> values) {
            addCriterion("send_time_section not in", values, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionBetween(String value1, String value2) {
            addCriterion("send_time_section between", value1, value2, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andSend_time_sectionNotBetween(String value1, String value2) {
            addCriterion("send_time_section not between", value1, value2, "send_time_section");
            return (Criteria) this;
        }

        public Criteria andExpress_typeIsNull() {
            addCriterion("express_type is null");
            return (Criteria) this;
        }

        public Criteria andExpress_typeIsNotNull() {
            addCriterion("express_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpress_typeEqualTo(String value) {
            addCriterion("express_type =", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotEqualTo(String value) {
            addCriterion("express_type <>", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeGreaterThan(String value) {
            addCriterion("express_type >", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeGreaterThanOrEqualTo(String value) {
            addCriterion("express_type >=", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeLessThan(String value) {
            addCriterion("express_type <", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeLessThanOrEqualTo(String value) {
            addCriterion("express_type <=", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeLike(String value) {
            addCriterion("express_type like", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotLike(String value) {
            addCriterion("express_type not like", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeIn(List<String> values) {
            addCriterion("express_type in", values, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotIn(List<String> values) {
            addCriterion("express_type not in", values, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeBetween(String value1, String value2) {
            addCriterion("express_type between", value1, value2, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotBetween(String value1, String value2) {
            addCriterion("express_type not between", value1, value2, "express_type");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeleted_atEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atLessThan(Date value) {
            addCriterion("deleted_at <", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andExtra_amountIsNull() {
            addCriterion("extra_amount is null");
            return (Criteria) this;
        }

        public Criteria andExtra_amountIsNotNull() {
            addCriterion("extra_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExtra_amountEqualTo(Double value) {
            addCriterion("extra_amount =", value, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountNotEqualTo(Double value) {
            addCriterion("extra_amount <>", value, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountGreaterThan(Double value) {
            addCriterion("extra_amount >", value, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountGreaterThanOrEqualTo(Double value) {
            addCriterion("extra_amount >=", value, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountLessThan(Double value) {
            addCriterion("extra_amount <", value, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountLessThanOrEqualTo(Double value) {
            addCriterion("extra_amount <=", value, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountIn(List<Double> values) {
            addCriterion("extra_amount in", values, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountNotIn(List<Double> values) {
            addCriterion("extra_amount not in", values, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountBetween(Double value1, Double value2) {
            addCriterion("extra_amount between", value1, value2, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_amountNotBetween(Double value1, Double value2) {
            addCriterion("extra_amount not between", value1, value2, "extra_amount");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsIsNull() {
            addCriterion("extra_items is null");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsIsNotNull() {
            addCriterion("extra_items is not null");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsEqualTo(String value) {
            addCriterion("extra_items =", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsNotEqualTo(String value) {
            addCriterion("extra_items <>", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsGreaterThan(String value) {
            addCriterion("extra_items >", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsGreaterThanOrEqualTo(String value) {
            addCriterion("extra_items >=", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsLessThan(String value) {
            addCriterion("extra_items <", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsLessThanOrEqualTo(String value) {
            addCriterion("extra_items <=", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsLike(String value) {
            addCriterion("extra_items like", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsNotLike(String value) {
            addCriterion("extra_items not like", value, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsIn(List<String> values) {
            addCriterion("extra_items in", values, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsNotIn(List<String> values) {
            addCriterion("extra_items not in", values, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsBetween(String value1, String value2) {
            addCriterion("extra_items between", value1, value2, "extra_items");
            return (Criteria) this;
        }

        public Criteria andExtra_itemsNotBetween(String value1, String value2) {
            addCriterion("extra_items not between", value1, value2, "extra_items");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idIsNull() {
            addCriterion("group_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idIsNotNull() {
            addCriterion("group_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idEqualTo(Long value) {
            addCriterion("group_coupon_id =", value, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idNotEqualTo(Long value) {
            addCriterion("group_coupon_id <>", value, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idGreaterThan(Long value) {
            addCriterion("group_coupon_id >", value, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idGreaterThanOrEqualTo(Long value) {
            addCriterion("group_coupon_id >=", value, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idLessThan(Long value) {
            addCriterion("group_coupon_id <", value, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idLessThanOrEqualTo(Long value) {
            addCriterion("group_coupon_id <=", value, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idIn(List<Long> values) {
            addCriterion("group_coupon_id in", values, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idNotIn(List<Long> values) {
            addCriterion("group_coupon_id not in", values, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idBetween(Long value1, Long value2) {
            addCriterion("group_coupon_id between", value1, value2, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_idNotBetween(Long value1, Long value2) {
            addCriterion("group_coupon_id not between", value1, value2, "group_coupon_id");
            return (Criteria) this;
        }

        public Criteria andGroup_discountIsNull() {
            addCriterion("group_discount is null");
            return (Criteria) this;
        }

        public Criteria andGroup_discountIsNotNull() {
            addCriterion("group_discount is not null");
            return (Criteria) this;
        }

        public Criteria andGroup_discountEqualTo(Double value) {
            addCriterion("group_discount =", value, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountNotEqualTo(Double value) {
            addCriterion("group_discount <>", value, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountGreaterThan(Double value) {
            addCriterion("group_discount >", value, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountGreaterThanOrEqualTo(Double value) {
            addCriterion("group_discount >=", value, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountLessThan(Double value) {
            addCriterion("group_discount <", value, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountLessThanOrEqualTo(Double value) {
            addCriterion("group_discount <=", value, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountIn(List<Double> values) {
            addCriterion("group_discount in", values, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountNotIn(List<Double> values) {
            addCriterion("group_discount not in", values, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountBetween(Double value1, Double value2) {
            addCriterion("group_discount between", value1, value2, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_discountNotBetween(Double value1, Double value2) {
            addCriterion("group_discount not between", value1, value2, "group_discount");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeIsNull() {
            addCriterion("group_coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeIsNotNull() {
            addCriterion("group_coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeEqualTo(String value) {
            addCriterion("group_coupon_code =", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeNotEqualTo(String value) {
            addCriterion("group_coupon_code <>", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeGreaterThan(String value) {
            addCriterion("group_coupon_code >", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeGreaterThanOrEqualTo(String value) {
            addCriterion("group_coupon_code >=", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeLessThan(String value) {
            addCriterion("group_coupon_code <", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeLessThanOrEqualTo(String value) {
            addCriterion("group_coupon_code <=", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeLike(String value) {
            addCriterion("group_coupon_code like", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeNotLike(String value) {
            addCriterion("group_coupon_code not like", value, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeIn(List<String> values) {
            addCriterion("group_coupon_code in", values, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeNotIn(List<String> values) {
            addCriterion("group_coupon_code not in", values, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeBetween(String value1, String value2) {
            addCriterion("group_coupon_code between", value1, value2, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andGroup_coupon_codeNotBetween(String value1, String value2) {
            addCriterion("group_coupon_code not between", value1, value2, "group_coupon_code");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeIsNull() {
            addCriterion("bag_cover_type is null");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeIsNotNull() {
            addCriterion("bag_cover_type is not null");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeEqualTo(Integer value) {
            addCriterion("bag_cover_type =", value, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeNotEqualTo(Integer value) {
            addCriterion("bag_cover_type <>", value, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeGreaterThan(Integer value) {
            addCriterion("bag_cover_type >", value, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bag_cover_type >=", value, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeLessThan(Integer value) {
            addCriterion("bag_cover_type <", value, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeLessThanOrEqualTo(Integer value) {
            addCriterion("bag_cover_type <=", value, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeIn(List<Integer> values) {
            addCriterion("bag_cover_type in", values, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeNotIn(List<Integer> values) {
            addCriterion("bag_cover_type not in", values, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeBetween(Integer value1, Integer value2) {
            addCriterion("bag_cover_type between", value1, value2, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andBag_cover_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("bag_cover_type not between", value1, value2, "bag_cover_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeEqualTo(Integer value) {
            addCriterion("order_type =", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThan(Integer value) {
            addCriterion("order_type <", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIn(List<Integer> values) {
            addCriterion("order_type in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andBag_idIsNull() {
            addCriterion("bag_id is null");
            return (Criteria) this;
        }

        public Criteria andBag_idIsNotNull() {
            addCriterion("bag_id is not null");
            return (Criteria) this;
        }

        public Criteria andBag_idEqualTo(Long value) {
            addCriterion("bag_id =", value, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idNotEqualTo(Long value) {
            addCriterion("bag_id <>", value, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idGreaterThan(Long value) {
            addCriterion("bag_id >", value, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idGreaterThanOrEqualTo(Long value) {
            addCriterion("bag_id >=", value, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idLessThan(Long value) {
            addCriterion("bag_id <", value, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idLessThanOrEqualTo(Long value) {
            addCriterion("bag_id <=", value, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idIn(List<Long> values) {
            addCriterion("bag_id in", values, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idNotIn(List<Long> values) {
            addCriterion("bag_id not in", values, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idBetween(Long value1, Long value2) {
            addCriterion("bag_id between", value1, value2, "bag_id");
            return (Criteria) this;
        }

        public Criteria andBag_idNotBetween(Long value1, Long value2) {
            addCriterion("bag_id not between", value1, value2, "bag_id");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atEqualTo(Date value) {
            addCriterion("updated_at =", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThan(Date value) {
            addCriterion("updated_at <", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIn(List<Date> values) {
            addCriterion("updated_at in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andBag_nameIsNull() {
            addCriterion("bag_name is null");
            return (Criteria) this;
        }

        public Criteria andBag_nameIsNotNull() {
            addCriterion("bag_name is not null");
            return (Criteria) this;
        }

        public Criteria andBag_nameEqualTo(String value) {
            addCriterion("bag_name =", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameNotEqualTo(String value) {
            addCriterion("bag_name <>", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameGreaterThan(String value) {
            addCriterion("bag_name >", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameGreaterThanOrEqualTo(String value) {
            addCriterion("bag_name >=", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameLessThan(String value) {
            addCriterion("bag_name <", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameLessThanOrEqualTo(String value) {
            addCriterion("bag_name <=", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameLike(String value) {
            addCriterion("bag_name like", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameNotLike(String value) {
            addCriterion("bag_name not like", value, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameIn(List<String> values) {
            addCriterion("bag_name in", values, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameNotIn(List<String> values) {
            addCriterion("bag_name not in", values, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameBetween(String value1, String value2) {
            addCriterion("bag_name between", value1, value2, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_nameNotBetween(String value1, String value2) {
            addCriterion("bag_name not between", value1, value2, "bag_name");
            return (Criteria) this;
        }

        public Criteria andBag_club_countIsNull() {
            addCriterion("bag_club_count is null");
            return (Criteria) this;
        }

        public Criteria andBag_club_countIsNotNull() {
            addCriterion("bag_club_count is not null");
            return (Criteria) this;
        }

        public Criteria andBag_club_countEqualTo(Integer value) {
            addCriterion("bag_club_count =", value, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countNotEqualTo(Integer value) {
            addCriterion("bag_club_count <>", value, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countGreaterThan(Integer value) {
            addCriterion("bag_club_count >", value, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("bag_club_count >=", value, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countLessThan(Integer value) {
            addCriterion("bag_club_count <", value, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countLessThanOrEqualTo(Integer value) {
            addCriterion("bag_club_count <=", value, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countIn(List<Integer> values) {
            addCriterion("bag_club_count in", values, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countNotIn(List<Integer> values) {
            addCriterion("bag_club_count not in", values, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countBetween(Integer value1, Integer value2) {
            addCriterion("bag_club_count between", value1, value2, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_countNotBetween(Integer value1, Integer value2) {
            addCriterion("bag_club_count not between", value1, value2, "bag_club_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countIsNull() {
            addCriterion("bag_club_cover_count is null");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countIsNotNull() {
            addCriterion("bag_club_cover_count is not null");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countEqualTo(Integer value) {
            addCriterion("bag_club_cover_count =", value, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countNotEqualTo(Integer value) {
            addCriterion("bag_club_cover_count <>", value, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countGreaterThan(Integer value) {
            addCriterion("bag_club_cover_count >", value, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("bag_club_cover_count >=", value, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countLessThan(Integer value) {
            addCriterion("bag_club_cover_count <", value, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countLessThanOrEqualTo(Integer value) {
            addCriterion("bag_club_cover_count <=", value, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countIn(List<Integer> values) {
            addCriterion("bag_club_cover_count in", values, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countNotIn(List<Integer> values) {
            addCriterion("bag_club_cover_count not in", values, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countBetween(Integer value1, Integer value2) {
            addCriterion("bag_club_cover_count between", value1, value2, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andBag_club_cover_countNotBetween(Integer value1, Integer value2) {
            addCriterion("bag_club_cover_count not between", value1, value2, "bag_club_cover_count");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeIsNull() {
            addCriterion("fetch_bag_time is null");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeIsNotNull() {
            addCriterion("fetch_bag_time is not null");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeEqualTo(Date value) {
            addCriterion("fetch_bag_time =", value, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeNotEqualTo(Date value) {
            addCriterion("fetch_bag_time <>", value, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeGreaterThan(Date value) {
            addCriterion("fetch_bag_time >", value, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("fetch_bag_time >=", value, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeLessThan(Date value) {
            addCriterion("fetch_bag_time <", value, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeLessThanOrEqualTo(Date value) {
            addCriterion("fetch_bag_time <=", value, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeIn(List<Date> values) {
            addCriterion("fetch_bag_time in", values, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeNotIn(List<Date> values) {
            addCriterion("fetch_bag_time not in", values, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeBetween(Date value1, Date value2) {
            addCriterion("fetch_bag_time between", value1, value2, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andFetch_bag_timeNotBetween(Date value1, Date value2) {
            addCriterion("fetch_bag_time not between", value1, value2, "fetch_bag_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeIsNull() {
            addCriterion("arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrival_timeIsNotNull() {
            addCriterion("arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrival_timeEqualTo(String value) {
            addCriterion("arrival_time =", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotEqualTo(String value) {
            addCriterion("arrival_time <>", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeGreaterThan(String value) {
            addCriterion("arrival_time >", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeGreaterThanOrEqualTo(String value) {
            addCriterion("arrival_time >=", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeLessThan(String value) {
            addCriterion("arrival_time <", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeLessThanOrEqualTo(String value) {
            addCriterion("arrival_time <=", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeLike(String value) {
            addCriterion("arrival_time like", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotLike(String value) {
            addCriterion("arrival_time not like", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeIn(List<String> values) {
            addCriterion("arrival_time in", values, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotIn(List<String> values) {
            addCriterion("arrival_time not in", values, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeBetween(String value1, String value2) {
            addCriterion("arrival_time between", value1, value2, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotBetween(String value1, String value2) {
            addCriterion("arrival_time not between", value1, value2, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeIsNull() {
            addCriterion("start_fetch_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeIsNotNull() {
            addCriterion("start_fetch_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeEqualTo(Date value) {
            addCriterion("start_fetch_time =", value, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeNotEqualTo(Date value) {
            addCriterion("start_fetch_time <>", value, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeGreaterThan(Date value) {
            addCriterion("start_fetch_time >", value, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_fetch_time >=", value, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeLessThan(Date value) {
            addCriterion("start_fetch_time <", value, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeLessThanOrEqualTo(Date value) {
            addCriterion("start_fetch_time <=", value, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeIn(List<Date> values) {
            addCriterion("start_fetch_time in", values, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeNotIn(List<Date> values) {
            addCriterion("start_fetch_time not in", values, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeBetween(Date value1, Date value2) {
            addCriterion("start_fetch_time between", value1, value2, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andStart_fetch_timeNotBetween(Date value1, Date value2) {
            addCriterion("start_fetch_time not between", value1, value2, "start_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeIsNull() {
            addCriterion("end_fetch_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeIsNotNull() {
            addCriterion("end_fetch_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeEqualTo(Date value) {
            addCriterion("end_fetch_time =", value, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeNotEqualTo(Date value) {
            addCriterion("end_fetch_time <>", value, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeGreaterThan(Date value) {
            addCriterion("end_fetch_time >", value, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_fetch_time >=", value, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeLessThan(Date value) {
            addCriterion("end_fetch_time <", value, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_fetch_time <=", value, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeIn(List<Date> values) {
            addCriterion("end_fetch_time in", values, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeNotIn(List<Date> values) {
            addCriterion("end_fetch_time not in", values, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeBetween(Date value1, Date value2) {
            addCriterion("end_fetch_time between", value1, value2, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andEnd_fetch_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_fetch_time not between", value1, value2, "end_fetch_time");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeEqualTo(String value) {
            addCriterion("business_type =", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeGreaterThan(String value) {
            addCriterion("business_type >", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeLessThan(String value) {
            addCriterion("business_type <", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeLike(String value) {
            addCriterion("business_type like", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeNotLike(String value) {
            addCriterion("business_type not like", value, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeIn(List<String> values) {
            addCriterion("business_type in", values, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "business_type");
            return (Criteria) this;
        }

        public Criteria andBusiness_typeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "business_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeIsNull() {
            addCriterion("start_address_type is null");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeIsNotNull() {
            addCriterion("start_address_type is not null");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeEqualTo(String value) {
            addCriterion("start_address_type =", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeNotEqualTo(String value) {
            addCriterion("start_address_type <>", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeGreaterThan(String value) {
            addCriterion("start_address_type >", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeGreaterThanOrEqualTo(String value) {
            addCriterion("start_address_type >=", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeLessThan(String value) {
            addCriterion("start_address_type <", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeLessThanOrEqualTo(String value) {
            addCriterion("start_address_type <=", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeLike(String value) {
            addCriterion("start_address_type like", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeNotLike(String value) {
            addCriterion("start_address_type not like", value, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeIn(List<String> values) {
            addCriterion("start_address_type in", values, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeNotIn(List<String> values) {
            addCriterion("start_address_type not in", values, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeBetween(String value1, String value2) {
            addCriterion("start_address_type between", value1, value2, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_typeNotBetween(String value1, String value2) {
            addCriterion("start_address_type not between", value1, value2, "start_address_type");
            return (Criteria) this;
        }

        public Criteria andStart_address_idIsNull() {
            addCriterion("start_address_id is null");
            return (Criteria) this;
        }

        public Criteria andStart_address_idIsNotNull() {
            addCriterion("start_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andStart_address_idEqualTo(Long value) {
            addCriterion("start_address_id =", value, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idNotEqualTo(Long value) {
            addCriterion("start_address_id <>", value, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idGreaterThan(Long value) {
            addCriterion("start_address_id >", value, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idGreaterThanOrEqualTo(Long value) {
            addCriterion("start_address_id >=", value, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idLessThan(Long value) {
            addCriterion("start_address_id <", value, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idLessThanOrEqualTo(Long value) {
            addCriterion("start_address_id <=", value, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idIn(List<Long> values) {
            addCriterion("start_address_id in", values, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idNotIn(List<Long> values) {
            addCriterion("start_address_id not in", values, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idBetween(Long value1, Long value2) {
            addCriterion("start_address_id between", value1, value2, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_idNotBetween(Long value1, Long value2) {
            addCriterion("start_address_id not between", value1, value2, "start_address_id");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameIsNull() {
            addCriterion("start_address_name is null");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameIsNotNull() {
            addCriterion("start_address_name is not null");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameEqualTo(String value) {
            addCriterion("start_address_name =", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameNotEqualTo(String value) {
            addCriterion("start_address_name <>", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameGreaterThan(String value) {
            addCriterion("start_address_name >", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameGreaterThanOrEqualTo(String value) {
            addCriterion("start_address_name >=", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameLessThan(String value) {
            addCriterion("start_address_name <", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameLessThanOrEqualTo(String value) {
            addCriterion("start_address_name <=", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameLike(String value) {
            addCriterion("start_address_name like", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameNotLike(String value) {
            addCriterion("start_address_name not like", value, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameIn(List<String> values) {
            addCriterion("start_address_name in", values, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameNotIn(List<String> values) {
            addCriterion("start_address_name not in", values, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameBetween(String value1, String value2) {
            addCriterion("start_address_name between", value1, value2, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_address_nameNotBetween(String value1, String value2) {
            addCriterion("start_address_name not between", value1, value2, "start_address_name");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idIsNull() {
            addCriterion("start_contact_id is null");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idIsNotNull() {
            addCriterion("start_contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idEqualTo(Long value) {
            addCriterion("start_contact_id =", value, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idNotEqualTo(Long value) {
            addCriterion("start_contact_id <>", value, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idGreaterThan(Long value) {
            addCriterion("start_contact_id >", value, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idGreaterThanOrEqualTo(Long value) {
            addCriterion("start_contact_id >=", value, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idLessThan(Long value) {
            addCriterion("start_contact_id <", value, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idLessThanOrEqualTo(Long value) {
            addCriterion("start_contact_id <=", value, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idIn(List<Long> values) {
            addCriterion("start_contact_id in", values, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idNotIn(List<Long> values) {
            addCriterion("start_contact_id not in", values, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idBetween(Long value1, Long value2) {
            addCriterion("start_contact_id between", value1, value2, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andStart_contact_idNotBetween(Long value1, Long value2) {
            addCriterion("start_contact_id not between", value1, value2, "start_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeIsNull() {
            addCriterion("end_address_type is null");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeIsNotNull() {
            addCriterion("end_address_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeEqualTo(String value) {
            addCriterion("end_address_type =", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeNotEqualTo(String value) {
            addCriterion("end_address_type <>", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeGreaterThan(String value) {
            addCriterion("end_address_type >", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeGreaterThanOrEqualTo(String value) {
            addCriterion("end_address_type >=", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeLessThan(String value) {
            addCriterion("end_address_type <", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeLessThanOrEqualTo(String value) {
            addCriterion("end_address_type <=", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeLike(String value) {
            addCriterion("end_address_type like", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeNotLike(String value) {
            addCriterion("end_address_type not like", value, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeIn(List<String> values) {
            addCriterion("end_address_type in", values, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeNotIn(List<String> values) {
            addCriterion("end_address_type not in", values, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeBetween(String value1, String value2) {
            addCriterion("end_address_type between", value1, value2, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_typeNotBetween(String value1, String value2) {
            addCriterion("end_address_type not between", value1, value2, "end_address_type");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idIsNull() {
            addCriterion("end_address_id is null");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idIsNotNull() {
            addCriterion("end_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idEqualTo(Long value) {
            addCriterion("end_address_id =", value, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idNotEqualTo(Long value) {
            addCriterion("end_address_id <>", value, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idGreaterThan(Long value) {
            addCriterion("end_address_id >", value, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idGreaterThanOrEqualTo(Long value) {
            addCriterion("end_address_id >=", value, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idLessThan(Long value) {
            addCriterion("end_address_id <", value, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idLessThanOrEqualTo(Long value) {
            addCriterion("end_address_id <=", value, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idIn(List<Long> values) {
            addCriterion("end_address_id in", values, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idNotIn(List<Long> values) {
            addCriterion("end_address_id not in", values, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idBetween(Long value1, Long value2) {
            addCriterion("end_address_id between", value1, value2, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_idNotBetween(Long value1, Long value2) {
            addCriterion("end_address_id not between", value1, value2, "end_address_id");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameIsNull() {
            addCriterion("end_address_name is null");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameIsNotNull() {
            addCriterion("end_address_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameEqualTo(String value) {
            addCriterion("end_address_name =", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameNotEqualTo(String value) {
            addCriterion("end_address_name <>", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameGreaterThan(String value) {
            addCriterion("end_address_name >", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameGreaterThanOrEqualTo(String value) {
            addCriterion("end_address_name >=", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameLessThan(String value) {
            addCriterion("end_address_name <", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameLessThanOrEqualTo(String value) {
            addCriterion("end_address_name <=", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameLike(String value) {
            addCriterion("end_address_name like", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameNotLike(String value) {
            addCriterion("end_address_name not like", value, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameIn(List<String> values) {
            addCriterion("end_address_name in", values, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameNotIn(List<String> values) {
            addCriterion("end_address_name not in", values, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameBetween(String value1, String value2) {
            addCriterion("end_address_name between", value1, value2, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_address_nameNotBetween(String value1, String value2) {
            addCriterion("end_address_name not between", value1, value2, "end_address_name");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idIsNull() {
            addCriterion("end_contact_id is null");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idIsNotNull() {
            addCriterion("end_contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idEqualTo(Long value) {
            addCriterion("end_contact_id =", value, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idNotEqualTo(Long value) {
            addCriterion("end_contact_id <>", value, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idGreaterThan(Long value) {
            addCriterion("end_contact_id >", value, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idGreaterThanOrEqualTo(Long value) {
            addCriterion("end_contact_id >=", value, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idLessThan(Long value) {
            addCriterion("end_contact_id <", value, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idLessThanOrEqualTo(Long value) {
            addCriterion("end_contact_id <=", value, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idIn(List<Long> values) {
            addCriterion("end_contact_id in", values, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idNotIn(List<Long> values) {
            addCriterion("end_contact_id not in", values, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idBetween(Long value1, Long value2) {
            addCriterion("end_contact_id between", value1, value2, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andEnd_contact_idNotBetween(Long value1, Long value2) {
            addCriterion("end_contact_id not between", value1, value2, "end_contact_id");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeEqualTo(Integer value) {
            addCriterion("coupon_type =", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeNotEqualTo(Integer value) {
            addCriterion("coupon_type <>", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeGreaterThan(Integer value) {
            addCriterion("coupon_type >", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type >=", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeLessThan(Integer value) {
            addCriterion("coupon_type <", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type <=", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeIn(List<Integer> values) {
            addCriterion("coupon_type in", values, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeNotIn(List<Integer> values) {
            addCriterion("coupon_type not in", values, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type between", value1, value2, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCoupon_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type not between", value1, value2, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeIsNull() {
            addCriterion("cover_type is null");
            return (Criteria) this;
        }

        public Criteria andCover_typeIsNotNull() {
            addCriterion("cover_type is not null");
            return (Criteria) this;
        }

        public Criteria andCover_typeEqualTo(Integer value) {
            addCriterion("cover_type =", value, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeNotEqualTo(Integer value) {
            addCriterion("cover_type <>", value, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeGreaterThan(Integer value) {
            addCriterion("cover_type >", value, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_type >=", value, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeLessThan(Integer value) {
            addCriterion("cover_type <", value, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeLessThanOrEqualTo(Integer value) {
            addCriterion("cover_type <=", value, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeIn(List<Integer> values) {
            addCriterion("cover_type in", values, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeNotIn(List<Integer> values) {
            addCriterion("cover_type not in", values, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeBetween(Integer value1, Integer value2) {
            addCriterion("cover_type between", value1, value2, "cover_type");
            return (Criteria) this;
        }

        public Criteria andCover_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_type not between", value1, value2, "cover_type");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idIsNull() {
            addCriterion("special_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idIsNotNull() {
            addCriterion("special_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idEqualTo(Long value) {
            addCriterion("special_coupon_id =", value, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idNotEqualTo(Long value) {
            addCriterion("special_coupon_id <>", value, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idGreaterThan(Long value) {
            addCriterion("special_coupon_id >", value, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idGreaterThanOrEqualTo(Long value) {
            addCriterion("special_coupon_id >=", value, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idLessThan(Long value) {
            addCriterion("special_coupon_id <", value, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idLessThanOrEqualTo(Long value) {
            addCriterion("special_coupon_id <=", value, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idIn(List<Long> values) {
            addCriterion("special_coupon_id in", values, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idNotIn(List<Long> values) {
            addCriterion("special_coupon_id not in", values, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idBetween(Long value1, Long value2) {
            addCriterion("special_coupon_id between", value1, value2, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_coupon_idNotBetween(Long value1, Long value2) {
            addCriterion("special_coupon_id not between", value1, value2, "special_coupon_id");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeIsNull() {
            addCriterion("special_code is null");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeIsNotNull() {
            addCriterion("special_code is not null");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeEqualTo(String value) {
            addCriterion("special_code =", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeNotEqualTo(String value) {
            addCriterion("special_code <>", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeGreaterThan(String value) {
            addCriterion("special_code >", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeGreaterThanOrEqualTo(String value) {
            addCriterion("special_code >=", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeLessThan(String value) {
            addCriterion("special_code <", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeLessThanOrEqualTo(String value) {
            addCriterion("special_code <=", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeLike(String value) {
            addCriterion("special_code like", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeNotLike(String value) {
            addCriterion("special_code not like", value, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeIn(List<String> values) {
            addCriterion("special_code in", values, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeNotIn(List<String> values) {
            addCriterion("special_code not in", values, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeBetween(String value1, String value2) {
            addCriterion("special_code between", value1, value2, "special_code");
            return (Criteria) this;
        }

        public Criteria andSpecial_codeNotBetween(String value1, String value2) {
            addCriterion("special_code not between", value1, value2, "special_code");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameIsNull() {
            addCriterion("j_place_name is null");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameIsNotNull() {
            addCriterion("j_place_name is not null");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameEqualTo(String value) {
            addCriterion("j_place_name =", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameNotEqualTo(String value) {
            addCriterion("j_place_name <>", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameGreaterThan(String value) {
            addCriterion("j_place_name >", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameGreaterThanOrEqualTo(String value) {
            addCriterion("j_place_name >=", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameLessThan(String value) {
            addCriterion("j_place_name <", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameLessThanOrEqualTo(String value) {
            addCriterion("j_place_name <=", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameLike(String value) {
            addCriterion("j_place_name like", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameNotLike(String value) {
            addCriterion("j_place_name not like", value, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameIn(List<String> values) {
            addCriterion("j_place_name in", values, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameNotIn(List<String> values) {
            addCriterion("j_place_name not in", values, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameBetween(String value1, String value2) {
            addCriterion("j_place_name between", value1, value2, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andJ_place_nameNotBetween(String value1, String value2) {
            addCriterion("j_place_name not between", value1, value2, "j_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameIsNull() {
            addCriterion("d_place_name is null");
            return (Criteria) this;
        }

        public Criteria andD_place_nameIsNotNull() {
            addCriterion("d_place_name is not null");
            return (Criteria) this;
        }

        public Criteria andD_place_nameEqualTo(String value) {
            addCriterion("d_place_name =", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameNotEqualTo(String value) {
            addCriterion("d_place_name <>", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameGreaterThan(String value) {
            addCriterion("d_place_name >", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameGreaterThanOrEqualTo(String value) {
            addCriterion("d_place_name >=", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameLessThan(String value) {
            addCriterion("d_place_name <", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameLessThanOrEqualTo(String value) {
            addCriterion("d_place_name <=", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameLike(String value) {
            addCriterion("d_place_name like", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameNotLike(String value) {
            addCriterion("d_place_name not like", value, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameIn(List<String> values) {
            addCriterion("d_place_name in", values, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameNotIn(List<String> values) {
            addCriterion("d_place_name not in", values, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameBetween(String value1, String value2) {
            addCriterion("d_place_name between", value1, value2, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andD_place_nameNotBetween(String value1, String value2) {
            addCriterion("d_place_name not between", value1, value2, "d_place_name");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelIsNull() {
            addCriterion("is_paid_cancel is null");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelIsNotNull() {
            addCriterion("is_paid_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelEqualTo(Boolean value) {
            addCriterion("is_paid_cancel =", value, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelNotEqualTo(Boolean value) {
            addCriterion("is_paid_cancel <>", value, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelGreaterThan(Boolean value) {
            addCriterion("is_paid_cancel >", value, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_paid_cancel >=", value, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelLessThan(Boolean value) {
            addCriterion("is_paid_cancel <", value, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_paid_cancel <=", value, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelIn(List<Boolean> values) {
            addCriterion("is_paid_cancel in", values, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelNotIn(List<Boolean> values) {
            addCriterion("is_paid_cancel not in", values, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_paid_cancel between", value1, value2, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andIs_paid_cancelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_paid_cancel not between", value1, value2, "is_paid_cancel");
            return (Criteria) this;
        }

        public Criteria andInsured_valueIsNull() {
            addCriterion("insured_value is null");
            return (Criteria) this;
        }

        public Criteria andInsured_valueIsNotNull() {
            addCriterion("insured_value is not null");
            return (Criteria) this;
        }

        public Criteria andInsured_valueEqualTo(Double value) {
            addCriterion("insured_value =", value, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueNotEqualTo(Double value) {
            addCriterion("insured_value <>", value, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueGreaterThan(Double value) {
            addCriterion("insured_value >", value, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueGreaterThanOrEqualTo(Double value) {
            addCriterion("insured_value >=", value, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueLessThan(Double value) {
            addCriterion("insured_value <", value, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueLessThanOrEqualTo(Double value) {
            addCriterion("insured_value <=", value, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueIn(List<Double> values) {
            addCriterion("insured_value in", values, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueNotIn(List<Double> values) {
            addCriterion("insured_value not in", values, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueBetween(Double value1, Double value2) {
            addCriterion("insured_value between", value1, value2, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_valueNotBetween(Double value1, Double value2) {
            addCriterion("insured_value not between", value1, value2, "insured_value");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesIsNull() {
            addCriterion("insured_rates is null");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesIsNotNull() {
            addCriterion("insured_rates is not null");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesEqualTo(Double value) {
            addCriterion("insured_rates =", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesNotEqualTo(Double value) {
            addCriterion("insured_rates <>", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesGreaterThan(Double value) {
            addCriterion("insured_rates >", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesGreaterThanOrEqualTo(Double value) {
            addCriterion("insured_rates >=", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesLessThan(Double value) {
            addCriterion("insured_rates <", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesLessThanOrEqualTo(Double value) {
            addCriterion("insured_rates <=", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesIn(List<Double> values) {
            addCriterion("insured_rates in", values, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesNotIn(List<Double> values) {
            addCriterion("insured_rates not in", values, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesBetween(Double value1, Double value2) {
            addCriterion("insured_rates between", value1, value2, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesNotBetween(Double value1, Double value2) {
            addCriterion("insured_rates not between", value1, value2, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_feeIsNull() {
            addCriterion("insured_fee is null");
            return (Criteria) this;
        }

        public Criteria andInsured_feeIsNotNull() {
            addCriterion("insured_fee is not null");
            return (Criteria) this;
        }

        public Criteria andInsured_feeEqualTo(Double value) {
            addCriterion("insured_fee =", value, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeNotEqualTo(Double value) {
            addCriterion("insured_fee <>", value, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeGreaterThan(Double value) {
            addCriterion("insured_fee >", value, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeGreaterThanOrEqualTo(Double value) {
            addCriterion("insured_fee >=", value, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeLessThan(Double value) {
            addCriterion("insured_fee <", value, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeLessThanOrEqualTo(Double value) {
            addCriterion("insured_fee <=", value, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeIn(List<Double> values) {
            addCriterion("insured_fee in", values, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeNotIn(List<Double> values) {
            addCriterion("insured_fee not in", values, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeBetween(Double value1, Double value2) {
            addCriterion("insured_fee between", value1, value2, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andInsured_feeNotBetween(Double value1, Double value2) {
            addCriterion("insured_fee not between", value1, value2, "insured_fee");
            return (Criteria) this;
        }

        public Criteria andIs_helpedIsNull() {
            addCriterion("is_helped is null");
            return (Criteria) this;
        }

        public Criteria andIs_helpedIsNotNull() {
            addCriterion("is_helped is not null");
            return (Criteria) this;
        }

        public Criteria andIs_helpedEqualTo(Boolean value) {
            addCriterion("is_helped =", value, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedNotEqualTo(Boolean value) {
            addCriterion("is_helped <>", value, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedGreaterThan(Boolean value) {
            addCriterion("is_helped >", value, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_helped >=", value, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedLessThan(Boolean value) {
            addCriterion("is_helped <", value, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_helped <=", value, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedIn(List<Boolean> values) {
            addCriterion("is_helped in", values, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedNotIn(List<Boolean> values) {
            addCriterion("is_helped not in", values, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_helped between", value1, value2, "is_helped");
            return (Criteria) this;
        }

        public Criteria andIs_helpedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_helped not between", value1, value2, "is_helped");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusIsNull() {
            addCriterion("coupon_status is null");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusIsNotNull() {
            addCriterion("coupon_status is not null");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusEqualTo(Integer value) {
            addCriterion("coupon_status =", value, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusNotEqualTo(Integer value) {
            addCriterion("coupon_status <>", value, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusGreaterThan(Integer value) {
            addCriterion("coupon_status >", value, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_status >=", value, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusLessThan(Integer value) {
            addCriterion("coupon_status <", value, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_status <=", value, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusIn(List<Integer> values) {
            addCriterion("coupon_status in", values, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusNotIn(List<Integer> values) {
            addCriterion("coupon_status not in", values, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusBetween(Integer value1, Integer value2) {
            addCriterion("coupon_status between", value1, value2, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andCoupon_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_status not between", value1, value2, "coupon_status");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nameEqualTo(String value) {
            addCriterion("user_name =", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThan(String value) {
            addCriterion("user_name >", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThan(String value) {
            addCriterion("user_name <", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLike(String value) {
            addCriterion("user_name like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotLike(String value) {
            addCriterion("user_name not like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIn(List<String> values) {
            addCriterion("user_name in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "user_name");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}