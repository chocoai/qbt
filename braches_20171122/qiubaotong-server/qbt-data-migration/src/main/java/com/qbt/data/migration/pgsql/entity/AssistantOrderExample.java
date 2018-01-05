package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssistantOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssistantOrderExample() {
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

        public Criteria andGroup_idIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroup_idIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroup_idEqualTo(Long value) {
            addCriterion("group_id =", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotEqualTo(Long value) {
            addCriterion("group_id <>", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idGreaterThan(Long value) {
            addCriterion("group_id >", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idGreaterThanOrEqualTo(Long value) {
            addCriterion("group_id >=", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idLessThan(Long value) {
            addCriterion("group_id <", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idLessThanOrEqualTo(Long value) {
            addCriterion("group_id <=", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idIn(List<Long> values) {
            addCriterion("group_id in", values, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotIn(List<Long> values) {
            addCriterion("group_id not in", values, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idBetween(Long value1, Long value2) {
            addCriterion("group_id between", value1, value2, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotBetween(Long value1, Long value2) {
            addCriterion("group_id not between", value1, value2, "group_id");
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

        public Criteria andWaybillIsNull() {
            addCriterion("waybill is null");
            return (Criteria) this;
        }

        public Criteria andWaybillIsNotNull() {
            addCriterion("waybill is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillEqualTo(String value) {
            addCriterion("waybill =", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotEqualTo(String value) {
            addCriterion("waybill <>", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillGreaterThan(String value) {
            addCriterion("waybill >", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillGreaterThanOrEqualTo(String value) {
            addCriterion("waybill >=", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillLessThan(String value) {
            addCriterion("waybill <", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillLessThanOrEqualTo(String value) {
            addCriterion("waybill <=", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillLike(String value) {
            addCriterion("waybill like", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotLike(String value) {
            addCriterion("waybill not like", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillIn(List<String> values) {
            addCriterion("waybill in", values, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotIn(List<String> values) {
            addCriterion("waybill not in", values, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillBetween(String value1, String value2) {
            addCriterion("waybill between", value1, value2, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotBetween(String value1, String value2) {
            addCriterion("waybill not between", value1, value2, "waybill");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idIsNull() {
            addCriterion("assistant_bag_id is null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idIsNotNull() {
            addCriterion("assistant_bag_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idEqualTo(Long value) {
            addCriterion("assistant_bag_id =", value, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idNotEqualTo(Long value) {
            addCriterion("assistant_bag_id <>", value, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idGreaterThan(Long value) {
            addCriterion("assistant_bag_id >", value, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idGreaterThanOrEqualTo(Long value) {
            addCriterion("assistant_bag_id >=", value, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idLessThan(Long value) {
            addCriterion("assistant_bag_id <", value, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idLessThanOrEqualTo(Long value) {
            addCriterion("assistant_bag_id <=", value, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idIn(List<Long> values) {
            addCriterion("assistant_bag_id in", values, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idNotIn(List<Long> values) {
            addCriterion("assistant_bag_id not in", values, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idBetween(Long value1, Long value2) {
            addCriterion("assistant_bag_id between", value1, value2, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_idNotBetween(Long value1, Long value2) {
            addCriterion("assistant_bag_id not between", value1, value2, "assistant_bag_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameIsNull() {
            addCriterion("assistant_bag_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameIsNotNull() {
            addCriterion("assistant_bag_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameEqualTo(String value) {
            addCriterion("assistant_bag_owner_name =", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameNotEqualTo(String value) {
            addCriterion("assistant_bag_owner_name <>", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameGreaterThan(String value) {
            addCriterion("assistant_bag_owner_name >", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameGreaterThanOrEqualTo(String value) {
            addCriterion("assistant_bag_owner_name >=", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameLessThan(String value) {
            addCriterion("assistant_bag_owner_name <", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameLessThanOrEqualTo(String value) {
            addCriterion("assistant_bag_owner_name <=", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameLike(String value) {
            addCriterion("assistant_bag_owner_name like", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameNotLike(String value) {
            addCriterion("assistant_bag_owner_name not like", value, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameIn(List<String> values) {
            addCriterion("assistant_bag_owner_name in", values, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameNotIn(List<String> values) {
            addCriterion("assistant_bag_owner_name not in", values, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameBetween(String value1, String value2) {
            addCriterion("assistant_bag_owner_name between", value1, value2, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_nameNotBetween(String value1, String value2) {
            addCriterion("assistant_bag_owner_name not between", value1, value2, "assistant_bag_owner_name");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileIsNull() {
            addCriterion("assistant_bag_owner_mobile is null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileIsNotNull() {
            addCriterion("assistant_bag_owner_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileEqualTo(String value) {
            addCriterion("assistant_bag_owner_mobile =", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileNotEqualTo(String value) {
            addCriterion("assistant_bag_owner_mobile <>", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileGreaterThan(String value) {
            addCriterion("assistant_bag_owner_mobile >", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileGreaterThanOrEqualTo(String value) {
            addCriterion("assistant_bag_owner_mobile >=", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileLessThan(String value) {
            addCriterion("assistant_bag_owner_mobile <", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileLessThanOrEqualTo(String value) {
            addCriterion("assistant_bag_owner_mobile <=", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileLike(String value) {
            addCriterion("assistant_bag_owner_mobile like", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileNotLike(String value) {
            addCriterion("assistant_bag_owner_mobile not like", value, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileIn(List<String> values) {
            addCriterion("assistant_bag_owner_mobile in", values, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileNotIn(List<String> values) {
            addCriterion("assistant_bag_owner_mobile not in", values, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileBetween(String value1, String value2) {
            addCriterion("assistant_bag_owner_mobile between", value1, value2, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_owner_mobileNotBetween(String value1, String value2) {
            addCriterion("assistant_bag_owner_mobile not between", value1, value2, "assistant_bag_owner_mobile");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverIsNull() {
            addCriterion("assistant_bag_bag_cover is null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverIsNotNull() {
            addCriterion("assistant_bag_bag_cover is not null");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverEqualTo(Integer value) {
            addCriterion("assistant_bag_bag_cover =", value, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverNotEqualTo(Integer value) {
            addCriterion("assistant_bag_bag_cover <>", value, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverGreaterThan(Integer value) {
            addCriterion("assistant_bag_bag_cover >", value, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverGreaterThanOrEqualTo(Integer value) {
            addCriterion("assistant_bag_bag_cover >=", value, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverLessThan(Integer value) {
            addCriterion("assistant_bag_bag_cover <", value, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverLessThanOrEqualTo(Integer value) {
            addCriterion("assistant_bag_bag_cover <=", value, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverIn(List<Integer> values) {
            addCriterion("assistant_bag_bag_cover in", values, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverNotIn(List<Integer> values) {
            addCriterion("assistant_bag_bag_cover not in", values, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverBetween(Integer value1, Integer value2) {
            addCriterion("assistant_bag_bag_cover between", value1, value2, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andAssistant_bag_bag_coverNotBetween(Integer value1, Integer value2) {
            addCriterion("assistant_bag_bag_cover not between", value1, value2, "assistant_bag_bag_cover");
            return (Criteria) this;
        }

        public Criteria andSender_idIsNull() {
            addCriterion("sender_id is null");
            return (Criteria) this;
        }

        public Criteria andSender_idIsNotNull() {
            addCriterion("sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andSender_idEqualTo(Long value) {
            addCriterion("sender_id =", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idNotEqualTo(Long value) {
            addCriterion("sender_id <>", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idGreaterThan(Long value) {
            addCriterion("sender_id >", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idGreaterThanOrEqualTo(Long value) {
            addCriterion("sender_id >=", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idLessThan(Long value) {
            addCriterion("sender_id <", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idLessThanOrEqualTo(Long value) {
            addCriterion("sender_id <=", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idIn(List<Long> values) {
            addCriterion("sender_id in", values, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idNotIn(List<Long> values) {
            addCriterion("sender_id not in", values, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idBetween(Long value1, Long value2) {
            addCriterion("sender_id between", value1, value2, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idNotBetween(Long value1, Long value2) {
            addCriterion("sender_id not between", value1, value2, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_nameIsNull() {
            addCriterion("sender_name is null");
            return (Criteria) this;
        }

        public Criteria andSender_nameIsNotNull() {
            addCriterion("sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andSender_nameEqualTo(String value) {
            addCriterion("sender_name =", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotEqualTo(String value) {
            addCriterion("sender_name <>", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameGreaterThan(String value) {
            addCriterion("sender_name >", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_name >=", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameLessThan(String value) {
            addCriterion("sender_name <", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameLessThanOrEqualTo(String value) {
            addCriterion("sender_name <=", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameLike(String value) {
            addCriterion("sender_name like", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotLike(String value) {
            addCriterion("sender_name not like", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameIn(List<String> values) {
            addCriterion("sender_name in", values, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotIn(List<String> values) {
            addCriterion("sender_name not in", values, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameBetween(String value1, String value2) {
            addCriterion("sender_name between", value1, value2, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotBetween(String value1, String value2) {
            addCriterion("sender_name not between", value1, value2, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_mobileIsNull() {
            addCriterion("sender_mobile is null");
            return (Criteria) this;
        }

        public Criteria andSender_mobileIsNotNull() {
            addCriterion("sender_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andSender_mobileEqualTo(String value) {
            addCriterion("sender_mobile =", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileNotEqualTo(String value) {
            addCriterion("sender_mobile <>", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileGreaterThan(String value) {
            addCriterion("sender_mobile >", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileGreaterThanOrEqualTo(String value) {
            addCriterion("sender_mobile >=", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileLessThan(String value) {
            addCriterion("sender_mobile <", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileLessThanOrEqualTo(String value) {
            addCriterion("sender_mobile <=", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileLike(String value) {
            addCriterion("sender_mobile like", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileNotLike(String value) {
            addCriterion("sender_mobile not like", value, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileIn(List<String> values) {
            addCriterion("sender_mobile in", values, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileNotIn(List<String> values) {
            addCriterion("sender_mobile not in", values, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileBetween(String value1, String value2) {
            addCriterion("sender_mobile between", value1, value2, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andSender_mobileNotBetween(String value1, String value2) {
            addCriterion("sender_mobile not between", value1, value2, "sender_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_idIsNull() {
            addCriterion("receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiver_idIsNotNull() {
            addCriterion("receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiver_idEqualTo(Long value) {
            addCriterion("receiver_id =", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idNotEqualTo(Long value) {
            addCriterion("receiver_id <>", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idGreaterThan(Long value) {
            addCriterion("receiver_id >", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id >=", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idLessThan(Long value) {
            addCriterion("receiver_id <", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id <=", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idIn(List<Long> values) {
            addCriterion("receiver_id in", values, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idNotIn(List<Long> values) {
            addCriterion("receiver_id not in", values, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idBetween(Long value1, Long value2) {
            addCriterion("receiver_id between", value1, value2, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id not between", value1, value2, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameLike(String value) {
            addCriterion("receiver_name like", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_nameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiver_name");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiver_mobile");
            return (Criteria) this;
        }

        public Criteria andReceiver_mobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiver_mobile");
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