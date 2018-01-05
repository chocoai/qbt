package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTablesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTablesExample() {
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

        public Criteria andSchemanameIsNull() {
            addCriterion("schemaname is null");
            return (Criteria) this;
        }

        public Criteria andSchemanameIsNotNull() {
            addCriterion("schemaname is not null");
            return (Criteria) this;
        }

        public Criteria andSchemanameEqualTo(String value) {
            addCriterion("schemaname =", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotEqualTo(String value) {
            addCriterion("schemaname <>", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThan(String value) {
            addCriterion("schemaname >", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThanOrEqualTo(String value) {
            addCriterion("schemaname >=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThan(String value) {
            addCriterion("schemaname <", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThanOrEqualTo(String value) {
            addCriterion("schemaname <=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLike(String value) {
            addCriterion("schemaname like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotLike(String value) {
            addCriterion("schemaname not like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameIn(List<String> values) {
            addCriterion("schemaname in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotIn(List<String> values) {
            addCriterion("schemaname not in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameBetween(String value1, String value2) {
            addCriterion("schemaname between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotBetween(String value1, String value2) {
            addCriterion("schemaname not between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTableownerIsNull() {
            addCriterion("tableowner is null");
            return (Criteria) this;
        }

        public Criteria andTableownerIsNotNull() {
            addCriterion("tableowner is not null");
            return (Criteria) this;
        }

        public Criteria andTableownerEqualTo(String value) {
            addCriterion("tableowner =", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerNotEqualTo(String value) {
            addCriterion("tableowner <>", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerGreaterThan(String value) {
            addCriterion("tableowner >", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerGreaterThanOrEqualTo(String value) {
            addCriterion("tableowner >=", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerLessThan(String value) {
            addCriterion("tableowner <", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerLessThanOrEqualTo(String value) {
            addCriterion("tableowner <=", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerLike(String value) {
            addCriterion("tableowner like", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerNotLike(String value) {
            addCriterion("tableowner not like", value, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerIn(List<String> values) {
            addCriterion("tableowner in", values, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerNotIn(List<String> values) {
            addCriterion("tableowner not in", values, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerBetween(String value1, String value2) {
            addCriterion("tableowner between", value1, value2, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTableownerNotBetween(String value1, String value2) {
            addCriterion("tableowner not between", value1, value2, "tableowner");
            return (Criteria) this;
        }

        public Criteria andTablespaceIsNull() {
            addCriterion("tablespace is null");
            return (Criteria) this;
        }

        public Criteria andTablespaceIsNotNull() {
            addCriterion("tablespace is not null");
            return (Criteria) this;
        }

        public Criteria andTablespaceEqualTo(String value) {
            addCriterion("tablespace =", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotEqualTo(String value) {
            addCriterion("tablespace <>", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceGreaterThan(String value) {
            addCriterion("tablespace >", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceGreaterThanOrEqualTo(String value) {
            addCriterion("tablespace >=", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceLessThan(String value) {
            addCriterion("tablespace <", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceLessThanOrEqualTo(String value) {
            addCriterion("tablespace <=", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceLike(String value) {
            addCriterion("tablespace like", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotLike(String value) {
            addCriterion("tablespace not like", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceIn(List<String> values) {
            addCriterion("tablespace in", values, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotIn(List<String> values) {
            addCriterion("tablespace not in", values, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceBetween(String value1, String value2) {
            addCriterion("tablespace between", value1, value2, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotBetween(String value1, String value2) {
            addCriterion("tablespace not between", value1, value2, "tablespace");
            return (Criteria) this;
        }

        public Criteria andHasindexesIsNull() {
            addCriterion("hasindexes is null");
            return (Criteria) this;
        }

        public Criteria andHasindexesIsNotNull() {
            addCriterion("hasindexes is not null");
            return (Criteria) this;
        }

        public Criteria andHasindexesEqualTo(Boolean value) {
            addCriterion("hasindexes =", value, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesNotEqualTo(Boolean value) {
            addCriterion("hasindexes <>", value, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesGreaterThan(Boolean value) {
            addCriterion("hasindexes >", value, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hasindexes >=", value, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesLessThan(Boolean value) {
            addCriterion("hasindexes <", value, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesLessThanOrEqualTo(Boolean value) {
            addCriterion("hasindexes <=", value, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesIn(List<Boolean> values) {
            addCriterion("hasindexes in", values, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesNotIn(List<Boolean> values) {
            addCriterion("hasindexes not in", values, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesBetween(Boolean value1, Boolean value2) {
            addCriterion("hasindexes between", value1, value2, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasindexesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hasindexes not between", value1, value2, "hasindexes");
            return (Criteria) this;
        }

        public Criteria andHasrulesIsNull() {
            addCriterion("hasrules is null");
            return (Criteria) this;
        }

        public Criteria andHasrulesIsNotNull() {
            addCriterion("hasrules is not null");
            return (Criteria) this;
        }

        public Criteria andHasrulesEqualTo(Boolean value) {
            addCriterion("hasrules =", value, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesNotEqualTo(Boolean value) {
            addCriterion("hasrules <>", value, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesGreaterThan(Boolean value) {
            addCriterion("hasrules >", value, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hasrules >=", value, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesLessThan(Boolean value) {
            addCriterion("hasrules <", value, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesLessThanOrEqualTo(Boolean value) {
            addCriterion("hasrules <=", value, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesIn(List<Boolean> values) {
            addCriterion("hasrules in", values, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesNotIn(List<Boolean> values) {
            addCriterion("hasrules not in", values, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesBetween(Boolean value1, Boolean value2) {
            addCriterion("hasrules between", value1, value2, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHasrulesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hasrules not between", value1, value2, "hasrules");
            return (Criteria) this;
        }

        public Criteria andHastriggersIsNull() {
            addCriterion("hastriggers is null");
            return (Criteria) this;
        }

        public Criteria andHastriggersIsNotNull() {
            addCriterion("hastriggers is not null");
            return (Criteria) this;
        }

        public Criteria andHastriggersEqualTo(Boolean value) {
            addCriterion("hastriggers =", value, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersNotEqualTo(Boolean value) {
            addCriterion("hastriggers <>", value, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersGreaterThan(Boolean value) {
            addCriterion("hastriggers >", value, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hastriggers >=", value, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersLessThan(Boolean value) {
            addCriterion("hastriggers <", value, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersLessThanOrEqualTo(Boolean value) {
            addCriterion("hastriggers <=", value, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersIn(List<Boolean> values) {
            addCriterion("hastriggers in", values, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersNotIn(List<Boolean> values) {
            addCriterion("hastriggers not in", values, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersBetween(Boolean value1, Boolean value2) {
            addCriterion("hastriggers between", value1, value2, "hastriggers");
            return (Criteria) this;
        }

        public Criteria andHastriggersNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hastriggers not between", value1, value2, "hastriggers");
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