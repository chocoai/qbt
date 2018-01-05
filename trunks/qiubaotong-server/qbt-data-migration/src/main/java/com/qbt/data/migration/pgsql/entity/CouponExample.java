package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
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

        public Criteria andActivity_idIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivity_idIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivity_idEqualTo(Long value) {
            addCriterion("activity_id =", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idLessThan(Long value) {
            addCriterion("activity_id <", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idIn(List<Long> values) {
            addCriterion("activity_id in", values, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivity_idNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activity_id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andAmount_denominationIsNull() {
            addCriterion("amount_denomination is null");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationIsNotNull() {
            addCriterion("amount_denomination is not null");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationEqualTo(Double value) {
            addCriterion("amount_denomination =", value, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationNotEqualTo(Double value) {
            addCriterion("amount_denomination <>", value, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationGreaterThan(Double value) {
            addCriterion("amount_denomination >", value, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationGreaterThanOrEqualTo(Double value) {
            addCriterion("amount_denomination >=", value, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationLessThan(Double value) {
            addCriterion("amount_denomination <", value, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationLessThanOrEqualTo(Double value) {
            addCriterion("amount_denomination <=", value, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationIn(List<Double> values) {
            addCriterion("amount_denomination in", values, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationNotIn(List<Double> values) {
            addCriterion("amount_denomination not in", values, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationBetween(Double value1, Double value2) {
            addCriterion("amount_denomination between", value1, value2, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andAmount_denominationNotBetween(Double value1, Double value2) {
            addCriterion("amount_denomination not between", value1, value2, "amount_denomination");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valid not between", value1, value2, "valid");
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

        public Criteria andLockedIsNull() {
            addCriterion("locked is null");
            return (Criteria) this;
        }

        public Criteria andLockedIsNotNull() {
            addCriterion("locked is not null");
            return (Criteria) this;
        }

        public Criteria andLockedEqualTo(Boolean value) {
            addCriterion("locked =", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotEqualTo(Boolean value) {
            addCriterion("locked <>", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThan(Boolean value) {
            addCriterion("locked >", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("locked >=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThan(Boolean value) {
            addCriterion("locked <", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThanOrEqualTo(Boolean value) {
            addCriterion("locked <=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedIn(List<Boolean> values) {
            addCriterion("locked in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotIn(List<Boolean> values) {
            addCriterion("locked not in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedBetween(Boolean value1, Boolean value2) {
            addCriterion("locked between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("locked not between", value1, value2, "locked");
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

        public Criteria andWhich_order_lockIsNull() {
            addCriterion("which_order_lock is null");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockIsNotNull() {
            addCriterion("which_order_lock is not null");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockEqualTo(Long value) {
            addCriterion("which_order_lock =", value, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockNotEqualTo(Long value) {
            addCriterion("which_order_lock <>", value, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockGreaterThan(Long value) {
            addCriterion("which_order_lock >", value, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockGreaterThanOrEqualTo(Long value) {
            addCriterion("which_order_lock >=", value, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockLessThan(Long value) {
            addCriterion("which_order_lock <", value, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockLessThanOrEqualTo(Long value) {
            addCriterion("which_order_lock <=", value, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockIn(List<Long> values) {
            addCriterion("which_order_lock in", values, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockNotIn(List<Long> values) {
            addCriterion("which_order_lock not in", values, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockBetween(Long value1, Long value2) {
            addCriterion("which_order_lock between", value1, value2, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andWhich_order_lockNotBetween(Long value1, Long value2) {
            addCriterion("which_order_lock not between", value1, value2, "which_order_lock");
            return (Criteria) this;
        }

        public Criteria andLock_timeIsNull() {
            addCriterion("lock_time is null");
            return (Criteria) this;
        }

        public Criteria andLock_timeIsNotNull() {
            addCriterion("lock_time is not null");
            return (Criteria) this;
        }

        public Criteria andLock_timeEqualTo(Date value) {
            addCriterion("lock_time =", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeNotEqualTo(Date value) {
            addCriterion("lock_time <>", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeGreaterThan(Date value) {
            addCriterion("lock_time >", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("lock_time >=", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeLessThan(Date value) {
            addCriterion("lock_time <", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeLessThanOrEqualTo(Date value) {
            addCriterion("lock_time <=", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeIn(List<Date> values) {
            addCriterion("lock_time in", values, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeNotIn(List<Date> values) {
            addCriterion("lock_time not in", values, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeBetween(Date value1, Date value2) {
            addCriterion("lock_time between", value1, value2, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeNotBetween(Date value1, Date value2) {
            addCriterion("lock_time not between", value1, value2, "lock_time");
            return (Criteria) this;
        }

        public Criteria andIs_claimIsNull() {
            addCriterion("is_claim is null");
            return (Criteria) this;
        }

        public Criteria andIs_claimIsNotNull() {
            addCriterion("is_claim is not null");
            return (Criteria) this;
        }

        public Criteria andIs_claimEqualTo(Boolean value) {
            addCriterion("is_claim =", value, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimNotEqualTo(Boolean value) {
            addCriterion("is_claim <>", value, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimGreaterThan(Boolean value) {
            addCriterion("is_claim >", value, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_claim >=", value, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimLessThan(Boolean value) {
            addCriterion("is_claim <", value, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimLessThanOrEqualTo(Boolean value) {
            addCriterion("is_claim <=", value, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimIn(List<Boolean> values) {
            addCriterion("is_claim in", values, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimNotIn(List<Boolean> values) {
            addCriterion("is_claim not in", values, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimBetween(Boolean value1, Boolean value2) {
            addCriterion("is_claim between", value1, value2, "is_claim");
            return (Criteria) this;
        }

        public Criteria andIs_claimNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_claim not between", value1, value2, "is_claim");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idIsNull() {
            addCriterion("claim_user_id is null");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idIsNotNull() {
            addCriterion("claim_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idEqualTo(Long value) {
            addCriterion("claim_user_id =", value, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idNotEqualTo(Long value) {
            addCriterion("claim_user_id <>", value, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idGreaterThan(Long value) {
            addCriterion("claim_user_id >", value, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idGreaterThanOrEqualTo(Long value) {
            addCriterion("claim_user_id >=", value, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idLessThan(Long value) {
            addCriterion("claim_user_id <", value, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idLessThanOrEqualTo(Long value) {
            addCriterion("claim_user_id <=", value, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idIn(List<Long> values) {
            addCriterion("claim_user_id in", values, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idNotIn(List<Long> values) {
            addCriterion("claim_user_id not in", values, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idBetween(Long value1, Long value2) {
            addCriterion("claim_user_id between", value1, value2, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_idNotBetween(Long value1, Long value2) {
            addCriterion("claim_user_id not between", value1, value2, "claim_user_id");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameIsNull() {
            addCriterion("claim_user_name is null");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameIsNotNull() {
            addCriterion("claim_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameEqualTo(String value) {
            addCriterion("claim_user_name =", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameNotEqualTo(String value) {
            addCriterion("claim_user_name <>", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameGreaterThan(String value) {
            addCriterion("claim_user_name >", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameGreaterThanOrEqualTo(String value) {
            addCriterion("claim_user_name >=", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameLessThan(String value) {
            addCriterion("claim_user_name <", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameLessThanOrEqualTo(String value) {
            addCriterion("claim_user_name <=", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameLike(String value) {
            addCriterion("claim_user_name like", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameNotLike(String value) {
            addCriterion("claim_user_name not like", value, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameIn(List<String> values) {
            addCriterion("claim_user_name in", values, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameNotIn(List<String> values) {
            addCriterion("claim_user_name not in", values, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameBetween(String value1, String value2) {
            addCriterion("claim_user_name between", value1, value2, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andClaim_user_nameNotBetween(String value1, String value2) {
            addCriterion("claim_user_name not between", value1, value2, "claim_user_name");
            return (Criteria) this;
        }

        public Criteria andIs_distributeIsNull() {
            addCriterion("is_distribute is null");
            return (Criteria) this;
        }

        public Criteria andIs_distributeIsNotNull() {
            addCriterion("is_distribute is not null");
            return (Criteria) this;
        }

        public Criteria andIs_distributeEqualTo(Boolean value) {
            addCriterion("is_distribute =", value, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeNotEqualTo(Boolean value) {
            addCriterion("is_distribute <>", value, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeGreaterThan(Boolean value) {
            addCriterion("is_distribute >", value, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_distribute >=", value, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeLessThan(Boolean value) {
            addCriterion("is_distribute <", value, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_distribute <=", value, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeIn(List<Boolean> values) {
            addCriterion("is_distribute in", values, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeNotIn(List<Boolean> values) {
            addCriterion("is_distribute not in", values, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_distribute between", value1, value2, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andIs_distributeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_distribute not between", value1, value2, "is_distribute");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idIsNull() {
            addCriterion("distribute_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idIsNotNull() {
            addCriterion("distribute_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idEqualTo(Long value) {
            addCriterion("distribute_user_id =", value, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idNotEqualTo(Long value) {
            addCriterion("distribute_user_id <>", value, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idGreaterThan(Long value) {
            addCriterion("distribute_user_id >", value, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idGreaterThanOrEqualTo(Long value) {
            addCriterion("distribute_user_id >=", value, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idLessThan(Long value) {
            addCriterion("distribute_user_id <", value, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idLessThanOrEqualTo(Long value) {
            addCriterion("distribute_user_id <=", value, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idIn(List<Long> values) {
            addCriterion("distribute_user_id in", values, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idNotIn(List<Long> values) {
            addCriterion("distribute_user_id not in", values, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idBetween(Long value1, Long value2) {
            addCriterion("distribute_user_id between", value1, value2, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_idNotBetween(Long value1, Long value2) {
            addCriterion("distribute_user_id not between", value1, value2, "distribute_user_id");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameIsNull() {
            addCriterion("distribute_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameIsNotNull() {
            addCriterion("distribute_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameEqualTo(String value) {
            addCriterion("distribute_user_name =", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameNotEqualTo(String value) {
            addCriterion("distribute_user_name <>", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameGreaterThan(String value) {
            addCriterion("distribute_user_name >", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameGreaterThanOrEqualTo(String value) {
            addCriterion("distribute_user_name >=", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameLessThan(String value) {
            addCriterion("distribute_user_name <", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameLessThanOrEqualTo(String value) {
            addCriterion("distribute_user_name <=", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameLike(String value) {
            addCriterion("distribute_user_name like", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameNotLike(String value) {
            addCriterion("distribute_user_name not like", value, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameIn(List<String> values) {
            addCriterion("distribute_user_name in", values, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameNotIn(List<String> values) {
            addCriterion("distribute_user_name not in", values, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameBetween(String value1, String value2) {
            addCriterion("distribute_user_name between", value1, value2, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andDistribute_user_nameNotBetween(String value1, String value2) {
            addCriterion("distribute_user_name not between", value1, value2, "distribute_user_name");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeIsNull() {
            addCriterion("xian_jin_type is null");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeIsNotNull() {
            addCriterion("xian_jin_type is not null");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeEqualTo(Integer value) {
            addCriterion("xian_jin_type =", value, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeNotEqualTo(Integer value) {
            addCriterion("xian_jin_type <>", value, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeGreaterThan(Integer value) {
            addCriterion("xian_jin_type >", value, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("xian_jin_type >=", value, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeLessThan(Integer value) {
            addCriterion("xian_jin_type <", value, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeLessThanOrEqualTo(Integer value) {
            addCriterion("xian_jin_type <=", value, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeIn(List<Integer> values) {
            addCriterion("xian_jin_type in", values, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeNotIn(List<Integer> values) {
            addCriterion("xian_jin_type not in", values, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeBetween(Integer value1, Integer value2) {
            addCriterion("xian_jin_type between", value1, value2, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andXian_jin_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("xian_jin_type not between", value1, value2, "xian_jin_type");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idIsNull() {
            addCriterion("li_bao_id is null");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idIsNotNull() {
            addCriterion("li_bao_id is not null");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idEqualTo(Long value) {
            addCriterion("li_bao_id =", value, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idNotEqualTo(Long value) {
            addCriterion("li_bao_id <>", value, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idGreaterThan(Long value) {
            addCriterion("li_bao_id >", value, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idGreaterThanOrEqualTo(Long value) {
            addCriterion("li_bao_id >=", value, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idLessThan(Long value) {
            addCriterion("li_bao_id <", value, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idLessThanOrEqualTo(Long value) {
            addCriterion("li_bao_id <=", value, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idIn(List<Long> values) {
            addCriterion("li_bao_id in", values, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idNotIn(List<Long> values) {
            addCriterion("li_bao_id not in", values, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idBetween(Long value1, Long value2) {
            addCriterion("li_bao_id between", value1, value2, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_idNotBetween(Long value1, Long value2) {
            addCriterion("li_bao_id not between", value1, value2, "li_bao_id");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexIsNull() {
            addCriterion("li_bao_index is null");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexIsNotNull() {
            addCriterion("li_bao_index is not null");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexEqualTo(Integer value) {
            addCriterion("li_bao_index =", value, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexNotEqualTo(Integer value) {
            addCriterion("li_bao_index <>", value, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexGreaterThan(Integer value) {
            addCriterion("li_bao_index >", value, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexGreaterThanOrEqualTo(Integer value) {
            addCriterion("li_bao_index >=", value, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexLessThan(Integer value) {
            addCriterion("li_bao_index <", value, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexLessThanOrEqualTo(Integer value) {
            addCriterion("li_bao_index <=", value, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexIn(List<Integer> values) {
            addCriterion("li_bao_index in", values, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexNotIn(List<Integer> values) {
            addCriterion("li_bao_index not in", values, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexBetween(Integer value1, Integer value2) {
            addCriterion("li_bao_index between", value1, value2, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_indexNotBetween(Integer value1, Integer value2) {
            addCriterion("li_bao_index not between", value1, value2, "li_bao_index");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthIsNull() {
            addCriterion("li_bao_worth is null");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthIsNotNull() {
            addCriterion("li_bao_worth is not null");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthEqualTo(Double value) {
            addCriterion("li_bao_worth =", value, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthNotEqualTo(Double value) {
            addCriterion("li_bao_worth <>", value, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthGreaterThan(Double value) {
            addCriterion("li_bao_worth >", value, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthGreaterThanOrEqualTo(Double value) {
            addCriterion("li_bao_worth >=", value, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthLessThan(Double value) {
            addCriterion("li_bao_worth <", value, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthLessThanOrEqualTo(Double value) {
            addCriterion("li_bao_worth <=", value, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthIn(List<Double> values) {
            addCriterion("li_bao_worth in", values, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthNotIn(List<Double> values) {
            addCriterion("li_bao_worth not in", values, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthBetween(Double value1, Double value2) {
            addCriterion("li_bao_worth between", value1, value2, "li_bao_worth");
            return (Criteria) this;
        }

        public Criteria andLi_bao_worthNotBetween(Double value1, Double value2) {
            addCriterion("li_bao_worth not between", value1, value2, "li_bao_worth");
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