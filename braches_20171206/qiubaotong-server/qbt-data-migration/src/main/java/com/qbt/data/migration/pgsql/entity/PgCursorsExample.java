package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgCursorsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgCursorsExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStatementIsNull() {
            addCriterion("statement is null");
            return (Criteria) this;
        }

        public Criteria andStatementIsNotNull() {
            addCriterion("statement is not null");
            return (Criteria) this;
        }

        public Criteria andStatementEqualTo(String value) {
            addCriterion("statement =", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotEqualTo(String value) {
            addCriterion("statement <>", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementGreaterThan(String value) {
            addCriterion("statement >", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementGreaterThanOrEqualTo(String value) {
            addCriterion("statement >=", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLessThan(String value) {
            addCriterion("statement <", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLessThanOrEqualTo(String value) {
            addCriterion("statement <=", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLike(String value) {
            addCriterion("statement like", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotLike(String value) {
            addCriterion("statement not like", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementIn(List<String> values) {
            addCriterion("statement in", values, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotIn(List<String> values) {
            addCriterion("statement not in", values, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementBetween(String value1, String value2) {
            addCriterion("statement between", value1, value2, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotBetween(String value1, String value2) {
            addCriterion("statement not between", value1, value2, "statement");
            return (Criteria) this;
        }

        public Criteria andIs_holdableIsNull() {
            addCriterion("is_holdable is null");
            return (Criteria) this;
        }

        public Criteria andIs_holdableIsNotNull() {
            addCriterion("is_holdable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_holdableEqualTo(Boolean value) {
            addCriterion("is_holdable =", value, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableNotEqualTo(Boolean value) {
            addCriterion("is_holdable <>", value, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableGreaterThan(Boolean value) {
            addCriterion("is_holdable >", value, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_holdable >=", value, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableLessThan(Boolean value) {
            addCriterion("is_holdable <", value, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableLessThanOrEqualTo(Boolean value) {
            addCriterion("is_holdable <=", value, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableIn(List<Boolean> values) {
            addCriterion("is_holdable in", values, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableNotIn(List<Boolean> values) {
            addCriterion("is_holdable not in", values, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableBetween(Boolean value1, Boolean value2) {
            addCriterion("is_holdable between", value1, value2, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_holdableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_holdable not between", value1, value2, "is_holdable");
            return (Criteria) this;
        }

        public Criteria andIs_binaryIsNull() {
            addCriterion("is_binary is null");
            return (Criteria) this;
        }

        public Criteria andIs_binaryIsNotNull() {
            addCriterion("is_binary is not null");
            return (Criteria) this;
        }

        public Criteria andIs_binaryEqualTo(Boolean value) {
            addCriterion("is_binary =", value, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryNotEqualTo(Boolean value) {
            addCriterion("is_binary <>", value, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryGreaterThan(Boolean value) {
            addCriterion("is_binary >", value, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_binary >=", value, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryLessThan(Boolean value) {
            addCriterion("is_binary <", value, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryLessThanOrEqualTo(Boolean value) {
            addCriterion("is_binary <=", value, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryIn(List<Boolean> values) {
            addCriterion("is_binary in", values, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryNotIn(List<Boolean> values) {
            addCriterion("is_binary not in", values, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryBetween(Boolean value1, Boolean value2) {
            addCriterion("is_binary between", value1, value2, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_binaryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_binary not between", value1, value2, "is_binary");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableIsNull() {
            addCriterion("is_scrollable is null");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableIsNotNull() {
            addCriterion("is_scrollable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableEqualTo(Boolean value) {
            addCriterion("is_scrollable =", value, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableNotEqualTo(Boolean value) {
            addCriterion("is_scrollable <>", value, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableGreaterThan(Boolean value) {
            addCriterion("is_scrollable >", value, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_scrollable >=", value, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableLessThan(Boolean value) {
            addCriterion("is_scrollable <", value, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableLessThanOrEqualTo(Boolean value) {
            addCriterion("is_scrollable <=", value, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableIn(List<Boolean> values) {
            addCriterion("is_scrollable in", values, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableNotIn(List<Boolean> values) {
            addCriterion("is_scrollable not in", values, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableBetween(Boolean value1, Boolean value2) {
            addCriterion("is_scrollable between", value1, value2, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andIs_scrollableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_scrollable not between", value1, value2, "is_scrollable");
            return (Criteria) this;
        }

        public Criteria andCreation_timeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreation_timeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreation_timeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeLessThan(Date value) {
            addCriterion("creation_time <", value, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creation_time");
            return (Criteria) this;
        }

        public Criteria andCreation_timeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creation_time");
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