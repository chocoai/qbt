package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperateLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateLogExample() {
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

        public Criteria andOperator_typeIsNull() {
            addCriterion("operator_type is null");
            return (Criteria) this;
        }

        public Criteria andOperator_typeIsNotNull() {
            addCriterion("operator_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperator_typeEqualTo(Integer value) {
            addCriterion("operator_type =", value, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeNotEqualTo(Integer value) {
            addCriterion("operator_type <>", value, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeGreaterThan(Integer value) {
            addCriterion("operator_type >", value, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_type >=", value, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeLessThan(Integer value) {
            addCriterion("operator_type <", value, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeLessThanOrEqualTo(Integer value) {
            addCriterion("operator_type <=", value, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeIn(List<Integer> values) {
            addCriterion("operator_type in", values, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeNotIn(List<Integer> values) {
            addCriterion("operator_type not in", values, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeBetween(Integer value1, Integer value2) {
            addCriterion("operator_type between", value1, value2, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_type not between", value1, value2, "operator_type");
            return (Criteria) this;
        }

        public Criteria andOperator_idIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperator_idIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperator_idEqualTo(Long value) {
            addCriterion("operator_id =", value, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idNotEqualTo(Long value) {
            addCriterion("operator_id <>", value, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idGreaterThan(Long value) {
            addCriterion("operator_id >", value, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_id >=", value, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idLessThan(Long value) {
            addCriterion("operator_id <", value, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idLessThanOrEqualTo(Long value) {
            addCriterion("operator_id <=", value, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idIn(List<Long> values) {
            addCriterion("operator_id in", values, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idNotIn(List<Long> values) {
            addCriterion("operator_id not in", values, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idBetween(Long value1, Long value2) {
            addCriterion("operator_id between", value1, value2, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_idNotBetween(Long value1, Long value2) {
            addCriterion("operator_id not between", value1, value2, "operator_id");
            return (Criteria) this;
        }

        public Criteria andOperator_nameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperator_nameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperator_nameEqualTo(String value) {
            addCriterion("operator_name =", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameLessThan(String value) {
            addCriterion("operator_name <", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameLike(String value) {
            addCriterion("operator_name like", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameNotLike(String value) {
            addCriterion("operator_name not like", value, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameIn(List<String> values) {
            addCriterion("operator_name in", values, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperator_nameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operator_name");
            return (Criteria) this;
        }

        public Criteria andOperated_atIsNull() {
            addCriterion("operated_at is null");
            return (Criteria) this;
        }

        public Criteria andOperated_atIsNotNull() {
            addCriterion("operated_at is not null");
            return (Criteria) this;
        }

        public Criteria andOperated_atEqualTo(Date value) {
            addCriterion("operated_at =", value, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atNotEqualTo(Date value) {
            addCriterion("operated_at <>", value, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atGreaterThan(Date value) {
            addCriterion("operated_at >", value, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("operated_at >=", value, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atLessThan(Date value) {
            addCriterion("operated_at <", value, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atLessThanOrEqualTo(Date value) {
            addCriterion("operated_at <=", value, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atIn(List<Date> values) {
            addCriterion("operated_at in", values, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atNotIn(List<Date> values) {
            addCriterion("operated_at not in", values, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atBetween(Date value1, Date value2) {
            addCriterion("operated_at between", value1, value2, "operated_at");
            return (Criteria) this;
        }

        public Criteria andOperated_atNotBetween(Date value1, Date value2) {
            addCriterion("operated_at not between", value1, value2, "operated_at");
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

        public Criteria andOperate_typeIsNull() {
            addCriterion("operate_type is null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIsNotNull() {
            addCriterion("operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeEqualTo(Short value) {
            addCriterion("operate_type =", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotEqualTo(Short value) {
            addCriterion("operate_type <>", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThan(Short value) {
            addCriterion("operate_type >", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThanOrEqualTo(Short value) {
            addCriterion("operate_type >=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThan(Short value) {
            addCriterion("operate_type <", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThanOrEqualTo(Short value) {
            addCriterion("operate_type <=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIn(List<Short> values) {
            addCriterion("operate_type in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotIn(List<Short> values) {
            addCriterion("operate_type not in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeBetween(Short value1, Short value2) {
            addCriterion("operate_type between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotBetween(Short value1, Short value2) {
            addCriterion("operate_type not between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Long value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Long value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Long value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Long> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
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

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
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