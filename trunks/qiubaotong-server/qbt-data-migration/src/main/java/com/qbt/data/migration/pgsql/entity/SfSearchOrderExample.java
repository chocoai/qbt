package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfSearchOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfSearchOrderExample() {
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

        public Criteria andSearchIsNull() {
            addCriterion("search is null");
            return (Criteria) this;
        }

        public Criteria andSearchIsNotNull() {
            addCriterion("search is not null");
            return (Criteria) this;
        }

        public Criteria andSearchEqualTo(String value) {
            addCriterion("search =", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchNotEqualTo(String value) {
            addCriterion("search <>", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchGreaterThan(String value) {
            addCriterion("search >", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchGreaterThanOrEqualTo(String value) {
            addCriterion("search >=", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchLessThan(String value) {
            addCriterion("search <", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchLessThanOrEqualTo(String value) {
            addCriterion("search <=", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchLike(String value) {
            addCriterion("search like", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchNotLike(String value) {
            addCriterion("search not like", value, "search");
            return (Criteria) this;
        }

        public Criteria andSearchIn(List<String> values) {
            addCriterion("search in", values, "search");
            return (Criteria) this;
        }

        public Criteria andSearchNotIn(List<String> values) {
            addCriterion("search not in", values, "search");
            return (Criteria) this;
        }

        public Criteria andSearchBetween(String value1, String value2) {
            addCriterion("search between", value1, value2, "search");
            return (Criteria) this;
        }

        public Criteria andSearchNotBetween(String value1, String value2) {
            addCriterion("search not between", value1, value2, "search");
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

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Double value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Double value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Double value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Double value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Double value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Double value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Double> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Double> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Double value1, Double value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Double value1, Double value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andAccuracyIsNull() {
            addCriterion("accuracy is null");
            return (Criteria) this;
        }

        public Criteria andAccuracyIsNotNull() {
            addCriterion("accuracy is not null");
            return (Criteria) this;
        }

        public Criteria andAccuracyEqualTo(Double value) {
            addCriterion("accuracy =", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotEqualTo(Double value) {
            addCriterion("accuracy <>", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyGreaterThan(Double value) {
            addCriterion("accuracy >", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyGreaterThanOrEqualTo(Double value) {
            addCriterion("accuracy >=", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyLessThan(Double value) {
            addCriterion("accuracy <", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyLessThanOrEqualTo(Double value) {
            addCriterion("accuracy <=", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyIn(List<Double> values) {
            addCriterion("accuracy in", values, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotIn(List<Double> values) {
            addCriterion("accuracy not in", values, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyBetween(Double value1, Double value2) {
            addCriterion("accuracy between", value1, value2, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotBetween(Double value1, Double value2) {
            addCriterion("accuracy not between", value1, value2, "accuracy");
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