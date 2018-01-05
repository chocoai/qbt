package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgRewriteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgRewriteExample() {
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

        public Criteria andRulenameIsNull() {
            addCriterion("rulename is null");
            return (Criteria) this;
        }

        public Criteria andRulenameIsNotNull() {
            addCriterion("rulename is not null");
            return (Criteria) this;
        }

        public Criteria andRulenameEqualTo(String value) {
            addCriterion("rulename =", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotEqualTo(String value) {
            addCriterion("rulename <>", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameGreaterThan(String value) {
            addCriterion("rulename >", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameGreaterThanOrEqualTo(String value) {
            addCriterion("rulename >=", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLessThan(String value) {
            addCriterion("rulename <", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLessThanOrEqualTo(String value) {
            addCriterion("rulename <=", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLike(String value) {
            addCriterion("rulename like", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotLike(String value) {
            addCriterion("rulename not like", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameIn(List<String> values) {
            addCriterion("rulename in", values, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotIn(List<String> values) {
            addCriterion("rulename not in", values, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameBetween(String value1, String value2) {
            addCriterion("rulename between", value1, value2, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotBetween(String value1, String value2) {
            addCriterion("rulename not between", value1, value2, "rulename");
            return (Criteria) this;
        }

        public Criteria andEv_classIsNull() {
            addCriterion("ev_class is null");
            return (Criteria) this;
        }

        public Criteria andEv_classIsNotNull() {
            addCriterion("ev_class is not null");
            return (Criteria) this;
        }

        public Criteria andEv_classEqualTo(Long value) {
            addCriterion("ev_class =", value, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classNotEqualTo(Long value) {
            addCriterion("ev_class <>", value, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classGreaterThan(Long value) {
            addCriterion("ev_class >", value, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classGreaterThanOrEqualTo(Long value) {
            addCriterion("ev_class >=", value, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classLessThan(Long value) {
            addCriterion("ev_class <", value, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classLessThanOrEqualTo(Long value) {
            addCriterion("ev_class <=", value, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classIn(List<Long> values) {
            addCriterion("ev_class in", values, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classNotIn(List<Long> values) {
            addCriterion("ev_class not in", values, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classBetween(Long value1, Long value2) {
            addCriterion("ev_class between", value1, value2, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_classNotBetween(Long value1, Long value2) {
            addCriterion("ev_class not between", value1, value2, "ev_class");
            return (Criteria) this;
        }

        public Criteria andEv_attrIsNull() {
            addCriterion("ev_attr is null");
            return (Criteria) this;
        }

        public Criteria andEv_attrIsNotNull() {
            addCriterion("ev_attr is not null");
            return (Criteria) this;
        }

        public Criteria andEv_attrEqualTo(Short value) {
            addCriterion("ev_attr =", value, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrNotEqualTo(Short value) {
            addCriterion("ev_attr <>", value, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrGreaterThan(Short value) {
            addCriterion("ev_attr >", value, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrGreaterThanOrEqualTo(Short value) {
            addCriterion("ev_attr >=", value, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrLessThan(Short value) {
            addCriterion("ev_attr <", value, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrLessThanOrEqualTo(Short value) {
            addCriterion("ev_attr <=", value, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrIn(List<Short> values) {
            addCriterion("ev_attr in", values, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrNotIn(List<Short> values) {
            addCriterion("ev_attr not in", values, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrBetween(Short value1, Short value2) {
            addCriterion("ev_attr between", value1, value2, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_attrNotBetween(Short value1, Short value2) {
            addCriterion("ev_attr not between", value1, value2, "ev_attr");
            return (Criteria) this;
        }

        public Criteria andEv_typeIsNull() {
            addCriterion("ev_type is null");
            return (Criteria) this;
        }

        public Criteria andEv_typeIsNotNull() {
            addCriterion("ev_type is not null");
            return (Criteria) this;
        }

        public Criteria andEv_typeEqualTo(String value) {
            addCriterion("ev_type =", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeNotEqualTo(String value) {
            addCriterion("ev_type <>", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeGreaterThan(String value) {
            addCriterion("ev_type >", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeGreaterThanOrEqualTo(String value) {
            addCriterion("ev_type >=", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeLessThan(String value) {
            addCriterion("ev_type <", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeLessThanOrEqualTo(String value) {
            addCriterion("ev_type <=", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeLike(String value) {
            addCriterion("ev_type like", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeNotLike(String value) {
            addCriterion("ev_type not like", value, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeIn(List<String> values) {
            addCriterion("ev_type in", values, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeNotIn(List<String> values) {
            addCriterion("ev_type not in", values, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeBetween(String value1, String value2) {
            addCriterion("ev_type between", value1, value2, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_typeNotBetween(String value1, String value2) {
            addCriterion("ev_type not between", value1, value2, "ev_type");
            return (Criteria) this;
        }

        public Criteria andEv_enabledIsNull() {
            addCriterion("ev_enabled is null");
            return (Criteria) this;
        }

        public Criteria andEv_enabledIsNotNull() {
            addCriterion("ev_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEv_enabledEqualTo(String value) {
            addCriterion("ev_enabled =", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledNotEqualTo(String value) {
            addCriterion("ev_enabled <>", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledGreaterThan(String value) {
            addCriterion("ev_enabled >", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledGreaterThanOrEqualTo(String value) {
            addCriterion("ev_enabled >=", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledLessThan(String value) {
            addCriterion("ev_enabled <", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledLessThanOrEqualTo(String value) {
            addCriterion("ev_enabled <=", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledLike(String value) {
            addCriterion("ev_enabled like", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledNotLike(String value) {
            addCriterion("ev_enabled not like", value, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledIn(List<String> values) {
            addCriterion("ev_enabled in", values, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledNotIn(List<String> values) {
            addCriterion("ev_enabled not in", values, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledBetween(String value1, String value2) {
            addCriterion("ev_enabled between", value1, value2, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andEv_enabledNotBetween(String value1, String value2) {
            addCriterion("ev_enabled not between", value1, value2, "ev_enabled");
            return (Criteria) this;
        }

        public Criteria andIs_insteadIsNull() {
            addCriterion("is_instead is null");
            return (Criteria) this;
        }

        public Criteria andIs_insteadIsNotNull() {
            addCriterion("is_instead is not null");
            return (Criteria) this;
        }

        public Criteria andIs_insteadEqualTo(Boolean value) {
            addCriterion("is_instead =", value, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadNotEqualTo(Boolean value) {
            addCriterion("is_instead <>", value, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadGreaterThan(Boolean value) {
            addCriterion("is_instead >", value, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_instead >=", value, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadLessThan(Boolean value) {
            addCriterion("is_instead <", value, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadLessThanOrEqualTo(Boolean value) {
            addCriterion("is_instead <=", value, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadIn(List<Boolean> values) {
            addCriterion("is_instead in", values, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadNotIn(List<Boolean> values) {
            addCriterion("is_instead not in", values, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadBetween(Boolean value1, Boolean value2) {
            addCriterion("is_instead between", value1, value2, "is_instead");
            return (Criteria) this;
        }

        public Criteria andIs_insteadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_instead not between", value1, value2, "is_instead");
            return (Criteria) this;
        }

        public Criteria andEv_qualIsNull() {
            addCriterion("ev_qual is null");
            return (Criteria) this;
        }

        public Criteria andEv_qualIsNotNull() {
            addCriterion("ev_qual is not null");
            return (Criteria) this;
        }

        public Criteria andEv_qualEqualTo(Object value) {
            addCriterion("ev_qual =", value, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualNotEqualTo(Object value) {
            addCriterion("ev_qual <>", value, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualGreaterThan(Object value) {
            addCriterion("ev_qual >", value, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualGreaterThanOrEqualTo(Object value) {
            addCriterion("ev_qual >=", value, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualLessThan(Object value) {
            addCriterion("ev_qual <", value, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualLessThanOrEqualTo(Object value) {
            addCriterion("ev_qual <=", value, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualIn(List<Object> values) {
            addCriterion("ev_qual in", values, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualNotIn(List<Object> values) {
            addCriterion("ev_qual not in", values, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualBetween(Object value1, Object value2) {
            addCriterion("ev_qual between", value1, value2, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_qualNotBetween(Object value1, Object value2) {
            addCriterion("ev_qual not between", value1, value2, "ev_qual");
            return (Criteria) this;
        }

        public Criteria andEv_actionIsNull() {
            addCriterion("ev_action is null");
            return (Criteria) this;
        }

        public Criteria andEv_actionIsNotNull() {
            addCriterion("ev_action is not null");
            return (Criteria) this;
        }

        public Criteria andEv_actionEqualTo(Object value) {
            addCriterion("ev_action =", value, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionNotEqualTo(Object value) {
            addCriterion("ev_action <>", value, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionGreaterThan(Object value) {
            addCriterion("ev_action >", value, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionGreaterThanOrEqualTo(Object value) {
            addCriterion("ev_action >=", value, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionLessThan(Object value) {
            addCriterion("ev_action <", value, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionLessThanOrEqualTo(Object value) {
            addCriterion("ev_action <=", value, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionIn(List<Object> values) {
            addCriterion("ev_action in", values, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionNotIn(List<Object> values) {
            addCriterion("ev_action not in", values, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionBetween(Object value1, Object value2) {
            addCriterion("ev_action between", value1, value2, "ev_action");
            return (Criteria) this;
        }

        public Criteria andEv_actionNotBetween(Object value1, Object value2) {
            addCriterion("ev_action not between", value1, value2, "ev_action");
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