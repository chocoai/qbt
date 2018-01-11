package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAmopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAmopExample() {
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

        public Criteria andAmopfamilyIsNull() {
            addCriterion("amopfamily is null");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyIsNotNull() {
            addCriterion("amopfamily is not null");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyEqualTo(Long value) {
            addCriterion("amopfamily =", value, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyNotEqualTo(Long value) {
            addCriterion("amopfamily <>", value, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyGreaterThan(Long value) {
            addCriterion("amopfamily >", value, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyGreaterThanOrEqualTo(Long value) {
            addCriterion("amopfamily >=", value, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyLessThan(Long value) {
            addCriterion("amopfamily <", value, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyLessThanOrEqualTo(Long value) {
            addCriterion("amopfamily <=", value, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyIn(List<Long> values) {
            addCriterion("amopfamily in", values, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyNotIn(List<Long> values) {
            addCriterion("amopfamily not in", values, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyBetween(Long value1, Long value2) {
            addCriterion("amopfamily between", value1, value2, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmopfamilyNotBetween(Long value1, Long value2) {
            addCriterion("amopfamily not between", value1, value2, "amopfamily");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeIsNull() {
            addCriterion("amoplefttype is null");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeIsNotNull() {
            addCriterion("amoplefttype is not null");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeEqualTo(Long value) {
            addCriterion("amoplefttype =", value, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeNotEqualTo(Long value) {
            addCriterion("amoplefttype <>", value, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeGreaterThan(Long value) {
            addCriterion("amoplefttype >", value, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeGreaterThanOrEqualTo(Long value) {
            addCriterion("amoplefttype >=", value, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeLessThan(Long value) {
            addCriterion("amoplefttype <", value, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeLessThanOrEqualTo(Long value) {
            addCriterion("amoplefttype <=", value, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeIn(List<Long> values) {
            addCriterion("amoplefttype in", values, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeNotIn(List<Long> values) {
            addCriterion("amoplefttype not in", values, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeBetween(Long value1, Long value2) {
            addCriterion("amoplefttype between", value1, value2, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoplefttypeNotBetween(Long value1, Long value2) {
            addCriterion("amoplefttype not between", value1, value2, "amoplefttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeIsNull() {
            addCriterion("amoprighttype is null");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeIsNotNull() {
            addCriterion("amoprighttype is not null");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeEqualTo(Long value) {
            addCriterion("amoprighttype =", value, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeNotEqualTo(Long value) {
            addCriterion("amoprighttype <>", value, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeGreaterThan(Long value) {
            addCriterion("amoprighttype >", value, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeGreaterThanOrEqualTo(Long value) {
            addCriterion("amoprighttype >=", value, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeLessThan(Long value) {
            addCriterion("amoprighttype <", value, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeLessThanOrEqualTo(Long value) {
            addCriterion("amoprighttype <=", value, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeIn(List<Long> values) {
            addCriterion("amoprighttype in", values, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeNotIn(List<Long> values) {
            addCriterion("amoprighttype not in", values, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeBetween(Long value1, Long value2) {
            addCriterion("amoprighttype between", value1, value2, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmoprighttypeNotBetween(Long value1, Long value2) {
            addCriterion("amoprighttype not between", value1, value2, "amoprighttype");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyIsNull() {
            addCriterion("amopstrategy is null");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyIsNotNull() {
            addCriterion("amopstrategy is not null");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyEqualTo(Short value) {
            addCriterion("amopstrategy =", value, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyNotEqualTo(Short value) {
            addCriterion("amopstrategy <>", value, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyGreaterThan(Short value) {
            addCriterion("amopstrategy >", value, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyGreaterThanOrEqualTo(Short value) {
            addCriterion("amopstrategy >=", value, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyLessThan(Short value) {
            addCriterion("amopstrategy <", value, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyLessThanOrEqualTo(Short value) {
            addCriterion("amopstrategy <=", value, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyIn(List<Short> values) {
            addCriterion("amopstrategy in", values, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyNotIn(List<Short> values) {
            addCriterion("amopstrategy not in", values, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyBetween(Short value1, Short value2) {
            addCriterion("amopstrategy between", value1, value2, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmopstrategyNotBetween(Short value1, Short value2) {
            addCriterion("amopstrategy not between", value1, value2, "amopstrategy");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeIsNull() {
            addCriterion("amoppurpose is null");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeIsNotNull() {
            addCriterion("amoppurpose is not null");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeEqualTo(String value) {
            addCriterion("amoppurpose =", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeNotEqualTo(String value) {
            addCriterion("amoppurpose <>", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeGreaterThan(String value) {
            addCriterion("amoppurpose >", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeGreaterThanOrEqualTo(String value) {
            addCriterion("amoppurpose >=", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeLessThan(String value) {
            addCriterion("amoppurpose <", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeLessThanOrEqualTo(String value) {
            addCriterion("amoppurpose <=", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeLike(String value) {
            addCriterion("amoppurpose like", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeNotLike(String value) {
            addCriterion("amoppurpose not like", value, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeIn(List<String> values) {
            addCriterion("amoppurpose in", values, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeNotIn(List<String> values) {
            addCriterion("amoppurpose not in", values, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeBetween(String value1, String value2) {
            addCriterion("amoppurpose between", value1, value2, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmoppurposeNotBetween(String value1, String value2) {
            addCriterion("amoppurpose not between", value1, value2, "amoppurpose");
            return (Criteria) this;
        }

        public Criteria andAmopoprIsNull() {
            addCriterion("amopopr is null");
            return (Criteria) this;
        }

        public Criteria andAmopoprIsNotNull() {
            addCriterion("amopopr is not null");
            return (Criteria) this;
        }

        public Criteria andAmopoprEqualTo(Long value) {
            addCriterion("amopopr =", value, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprNotEqualTo(Long value) {
            addCriterion("amopopr <>", value, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprGreaterThan(Long value) {
            addCriterion("amopopr >", value, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprGreaterThanOrEqualTo(Long value) {
            addCriterion("amopopr >=", value, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprLessThan(Long value) {
            addCriterion("amopopr <", value, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprLessThanOrEqualTo(Long value) {
            addCriterion("amopopr <=", value, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprIn(List<Long> values) {
            addCriterion("amopopr in", values, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprNotIn(List<Long> values) {
            addCriterion("amopopr not in", values, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprBetween(Long value1, Long value2) {
            addCriterion("amopopr between", value1, value2, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopoprNotBetween(Long value1, Long value2) {
            addCriterion("amopopr not between", value1, value2, "amopopr");
            return (Criteria) this;
        }

        public Criteria andAmopmethodIsNull() {
            addCriterion("amopmethod is null");
            return (Criteria) this;
        }

        public Criteria andAmopmethodIsNotNull() {
            addCriterion("amopmethod is not null");
            return (Criteria) this;
        }

        public Criteria andAmopmethodEqualTo(Long value) {
            addCriterion("amopmethod =", value, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodNotEqualTo(Long value) {
            addCriterion("amopmethod <>", value, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodGreaterThan(Long value) {
            addCriterion("amopmethod >", value, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodGreaterThanOrEqualTo(Long value) {
            addCriterion("amopmethod >=", value, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodLessThan(Long value) {
            addCriterion("amopmethod <", value, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodLessThanOrEqualTo(Long value) {
            addCriterion("amopmethod <=", value, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodIn(List<Long> values) {
            addCriterion("amopmethod in", values, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodNotIn(List<Long> values) {
            addCriterion("amopmethod not in", values, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodBetween(Long value1, Long value2) {
            addCriterion("amopmethod between", value1, value2, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopmethodNotBetween(Long value1, Long value2) {
            addCriterion("amopmethod not between", value1, value2, "amopmethod");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyIsNull() {
            addCriterion("amopsortfamily is null");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyIsNotNull() {
            addCriterion("amopsortfamily is not null");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyEqualTo(Long value) {
            addCriterion("amopsortfamily =", value, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyNotEqualTo(Long value) {
            addCriterion("amopsortfamily <>", value, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyGreaterThan(Long value) {
            addCriterion("amopsortfamily >", value, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyGreaterThanOrEqualTo(Long value) {
            addCriterion("amopsortfamily >=", value, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyLessThan(Long value) {
            addCriterion("amopsortfamily <", value, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyLessThanOrEqualTo(Long value) {
            addCriterion("amopsortfamily <=", value, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyIn(List<Long> values) {
            addCriterion("amopsortfamily in", values, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyNotIn(List<Long> values) {
            addCriterion("amopsortfamily not in", values, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyBetween(Long value1, Long value2) {
            addCriterion("amopsortfamily between", value1, value2, "amopsortfamily");
            return (Criteria) this;
        }

        public Criteria andAmopsortfamilyNotBetween(Long value1, Long value2) {
            addCriterion("amopsortfamily not between", value1, value2, "amopsortfamily");
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