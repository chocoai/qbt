package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseBagNoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseBagNoExample() {
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

        public Criteria andCourse_idIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourse_idIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourse_idEqualTo(Long value) {
            addCriterion("course_id =", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idGreaterThan(Long value) {
            addCriterion("course_id >", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idLessThan(Long value) {
            addCriterion("course_id <", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idIn(List<Long> values) {
            addCriterion("course_id in", values, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "course_id");
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

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andBag_noIsNull() {
            addCriterion("bag_no is null");
            return (Criteria) this;
        }

        public Criteria andBag_noIsNotNull() {
            addCriterion("bag_no is not null");
            return (Criteria) this;
        }

        public Criteria andBag_noEqualTo(String value) {
            addCriterion("bag_no =", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noNotEqualTo(String value) {
            addCriterion("bag_no <>", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noGreaterThan(String value) {
            addCriterion("bag_no >", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noGreaterThanOrEqualTo(String value) {
            addCriterion("bag_no >=", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noLessThan(String value) {
            addCriterion("bag_no <", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noLessThanOrEqualTo(String value) {
            addCriterion("bag_no <=", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noLike(String value) {
            addCriterion("bag_no like", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noNotLike(String value) {
            addCriterion("bag_no not like", value, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noIn(List<String> values) {
            addCriterion("bag_no in", values, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noNotIn(List<String> values) {
            addCriterion("bag_no not in", values, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noBetween(String value1, String value2) {
            addCriterion("bag_no between", value1, value2, "bag_no");
            return (Criteria) this;
        }

        public Criteria andBag_noNotBetween(String value1, String value2) {
            addCriterion("bag_no not between", value1, value2, "bag_no");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_byEqualTo(Long value) {
            addCriterion("created_by =", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotEqualTo(Long value) {
            addCriterion("created_by <>", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThan(Long value) {
            addCriterion("created_by >", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThanOrEqualTo(Long value) {
            addCriterion("created_by >=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThan(Long value) {
            addCriterion("created_by <", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThanOrEqualTo(Long value) {
            addCriterion("created_by <=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byIn(List<Long> values) {
            addCriterion("created_by in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotIn(List<Long> values) {
            addCriterion("created_by not in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byBetween(Long value1, Long value2) {
            addCriterion("created_by between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotBetween(Long value1, Long value2) {
            addCriterion("created_by not between", value1, value2, "created_by");
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