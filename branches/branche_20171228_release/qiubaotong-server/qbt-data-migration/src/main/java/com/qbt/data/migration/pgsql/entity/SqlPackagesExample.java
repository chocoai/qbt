package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class SqlPackagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SqlPackagesExample() {
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

        public Criteria andFeature_idIsNull() {
            addCriterion("feature_id is null");
            return (Criteria) this;
        }

        public Criteria andFeature_idIsNotNull() {
            addCriterion("feature_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeature_idEqualTo(Object value) {
            addCriterion("feature_id =", value, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idNotEqualTo(Object value) {
            addCriterion("feature_id <>", value, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idGreaterThan(Object value) {
            addCriterion("feature_id >", value, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idGreaterThanOrEqualTo(Object value) {
            addCriterion("feature_id >=", value, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idLessThan(Object value) {
            addCriterion("feature_id <", value, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idLessThanOrEqualTo(Object value) {
            addCriterion("feature_id <=", value, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idIn(List<Object> values) {
            addCriterion("feature_id in", values, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idNotIn(List<Object> values) {
            addCriterion("feature_id not in", values, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idBetween(Object value1, Object value2) {
            addCriterion("feature_id between", value1, value2, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_idNotBetween(Object value1, Object value2) {
            addCriterion("feature_id not between", value1, value2, "feature_id");
            return (Criteria) this;
        }

        public Criteria andFeature_nameIsNull() {
            addCriterion("feature_name is null");
            return (Criteria) this;
        }

        public Criteria andFeature_nameIsNotNull() {
            addCriterion("feature_name is not null");
            return (Criteria) this;
        }

        public Criteria andFeature_nameEqualTo(Object value) {
            addCriterion("feature_name =", value, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameNotEqualTo(Object value) {
            addCriterion("feature_name <>", value, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameGreaterThan(Object value) {
            addCriterion("feature_name >", value, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("feature_name >=", value, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameLessThan(Object value) {
            addCriterion("feature_name <", value, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameLessThanOrEqualTo(Object value) {
            addCriterion("feature_name <=", value, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameIn(List<Object> values) {
            addCriterion("feature_name in", values, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameNotIn(List<Object> values) {
            addCriterion("feature_name not in", values, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameBetween(Object value1, Object value2) {
            addCriterion("feature_name between", value1, value2, "feature_name");
            return (Criteria) this;
        }

        public Criteria andFeature_nameNotBetween(Object value1, Object value2) {
            addCriterion("feature_name not between", value1, value2, "feature_name");
            return (Criteria) this;
        }

        public Criteria andIs_supportedIsNull() {
            addCriterion("is_supported is null");
            return (Criteria) this;
        }

        public Criteria andIs_supportedIsNotNull() {
            addCriterion("is_supported is not null");
            return (Criteria) this;
        }

        public Criteria andIs_supportedEqualTo(Object value) {
            addCriterion("is_supported =", value, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedNotEqualTo(Object value) {
            addCriterion("is_supported <>", value, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedGreaterThan(Object value) {
            addCriterion("is_supported >", value, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedGreaterThanOrEqualTo(Object value) {
            addCriterion("is_supported >=", value, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedLessThan(Object value) {
            addCriterion("is_supported <", value, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedLessThanOrEqualTo(Object value) {
            addCriterion("is_supported <=", value, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedIn(List<Object> values) {
            addCriterion("is_supported in", values, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedNotIn(List<Object> values) {
            addCriterion("is_supported not in", values, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedBetween(Object value1, Object value2) {
            addCriterion("is_supported between", value1, value2, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_supportedNotBetween(Object value1, Object value2) {
            addCriterion("is_supported not between", value1, value2, "is_supported");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byIsNull() {
            addCriterion("is_verified_by is null");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byIsNotNull() {
            addCriterion("is_verified_by is not null");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byEqualTo(Object value) {
            addCriterion("is_verified_by =", value, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byNotEqualTo(Object value) {
            addCriterion("is_verified_by <>", value, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byGreaterThan(Object value) {
            addCriterion("is_verified_by >", value, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byGreaterThanOrEqualTo(Object value) {
            addCriterion("is_verified_by >=", value, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byLessThan(Object value) {
            addCriterion("is_verified_by <", value, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byLessThanOrEqualTo(Object value) {
            addCriterion("is_verified_by <=", value, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byIn(List<Object> values) {
            addCriterion("is_verified_by in", values, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byNotIn(List<Object> values) {
            addCriterion("is_verified_by not in", values, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byBetween(Object value1, Object value2) {
            addCriterion("is_verified_by between", value1, value2, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andIs_verified_byNotBetween(Object value1, Object value2) {
            addCriterion("is_verified_by not between", value1, value2, "is_verified_by");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(Object value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(Object value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(Object value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(Object value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(Object value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(Object value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<Object> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<Object> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(Object value1, Object value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(Object value1, Object value2) {
            addCriterion("comments not between", value1, value2, "comments");
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