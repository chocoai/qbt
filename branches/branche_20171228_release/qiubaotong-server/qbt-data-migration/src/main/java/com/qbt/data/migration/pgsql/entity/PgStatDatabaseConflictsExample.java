package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatDatabaseConflictsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatDatabaseConflictsExample() {
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

        public Criteria andDatidIsNull() {
            addCriterion("datid is null");
            return (Criteria) this;
        }

        public Criteria andDatidIsNotNull() {
            addCriterion("datid is not null");
            return (Criteria) this;
        }

        public Criteria andDatidEqualTo(Long value) {
            addCriterion("datid =", value, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidNotEqualTo(Long value) {
            addCriterion("datid <>", value, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidGreaterThan(Long value) {
            addCriterion("datid >", value, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidGreaterThanOrEqualTo(Long value) {
            addCriterion("datid >=", value, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidLessThan(Long value) {
            addCriterion("datid <", value, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidLessThanOrEqualTo(Long value) {
            addCriterion("datid <=", value, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidIn(List<Long> values) {
            addCriterion("datid in", values, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidNotIn(List<Long> values) {
            addCriterion("datid not in", values, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidBetween(Long value1, Long value2) {
            addCriterion("datid between", value1, value2, "datid");
            return (Criteria) this;
        }

        public Criteria andDatidNotBetween(Long value1, Long value2) {
            addCriterion("datid not between", value1, value2, "datid");
            return (Criteria) this;
        }

        public Criteria andDatnameIsNull() {
            addCriterion("datname is null");
            return (Criteria) this;
        }

        public Criteria andDatnameIsNotNull() {
            addCriterion("datname is not null");
            return (Criteria) this;
        }

        public Criteria andDatnameEqualTo(String value) {
            addCriterion("datname =", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameNotEqualTo(String value) {
            addCriterion("datname <>", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameGreaterThan(String value) {
            addCriterion("datname >", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameGreaterThanOrEqualTo(String value) {
            addCriterion("datname >=", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameLessThan(String value) {
            addCriterion("datname <", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameLessThanOrEqualTo(String value) {
            addCriterion("datname <=", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameLike(String value) {
            addCriterion("datname like", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameNotLike(String value) {
            addCriterion("datname not like", value, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameIn(List<String> values) {
            addCriterion("datname in", values, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameNotIn(List<String> values) {
            addCriterion("datname not in", values, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameBetween(String value1, String value2) {
            addCriterion("datname between", value1, value2, "datname");
            return (Criteria) this;
        }

        public Criteria andDatnameNotBetween(String value1, String value2) {
            addCriterion("datname not between", value1, value2, "datname");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceIsNull() {
            addCriterion("confl_tablespace is null");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceIsNotNull() {
            addCriterion("confl_tablespace is not null");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceEqualTo(Long value) {
            addCriterion("confl_tablespace =", value, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceNotEqualTo(Long value) {
            addCriterion("confl_tablespace <>", value, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceGreaterThan(Long value) {
            addCriterion("confl_tablespace >", value, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("confl_tablespace >=", value, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceLessThan(Long value) {
            addCriterion("confl_tablespace <", value, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceLessThanOrEqualTo(Long value) {
            addCriterion("confl_tablespace <=", value, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceIn(List<Long> values) {
            addCriterion("confl_tablespace in", values, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceNotIn(List<Long> values) {
            addCriterion("confl_tablespace not in", values, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceBetween(Long value1, Long value2) {
            addCriterion("confl_tablespace between", value1, value2, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_tablespaceNotBetween(Long value1, Long value2) {
            addCriterion("confl_tablespace not between", value1, value2, "confl_tablespace");
            return (Criteria) this;
        }

        public Criteria andConfl_lockIsNull() {
            addCriterion("confl_lock is null");
            return (Criteria) this;
        }

        public Criteria andConfl_lockIsNotNull() {
            addCriterion("confl_lock is not null");
            return (Criteria) this;
        }

        public Criteria andConfl_lockEqualTo(Long value) {
            addCriterion("confl_lock =", value, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockNotEqualTo(Long value) {
            addCriterion("confl_lock <>", value, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockGreaterThan(Long value) {
            addCriterion("confl_lock >", value, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockGreaterThanOrEqualTo(Long value) {
            addCriterion("confl_lock >=", value, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockLessThan(Long value) {
            addCriterion("confl_lock <", value, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockLessThanOrEqualTo(Long value) {
            addCriterion("confl_lock <=", value, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockIn(List<Long> values) {
            addCriterion("confl_lock in", values, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockNotIn(List<Long> values) {
            addCriterion("confl_lock not in", values, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockBetween(Long value1, Long value2) {
            addCriterion("confl_lock between", value1, value2, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_lockNotBetween(Long value1, Long value2) {
            addCriterion("confl_lock not between", value1, value2, "confl_lock");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotIsNull() {
            addCriterion("confl_snapshot is null");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotIsNotNull() {
            addCriterion("confl_snapshot is not null");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotEqualTo(Long value) {
            addCriterion("confl_snapshot =", value, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotNotEqualTo(Long value) {
            addCriterion("confl_snapshot <>", value, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotGreaterThan(Long value) {
            addCriterion("confl_snapshot >", value, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotGreaterThanOrEqualTo(Long value) {
            addCriterion("confl_snapshot >=", value, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotLessThan(Long value) {
            addCriterion("confl_snapshot <", value, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotLessThanOrEqualTo(Long value) {
            addCriterion("confl_snapshot <=", value, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotIn(List<Long> values) {
            addCriterion("confl_snapshot in", values, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotNotIn(List<Long> values) {
            addCriterion("confl_snapshot not in", values, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotBetween(Long value1, Long value2) {
            addCriterion("confl_snapshot between", value1, value2, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_snapshotNotBetween(Long value1, Long value2) {
            addCriterion("confl_snapshot not between", value1, value2, "confl_snapshot");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinIsNull() {
            addCriterion("confl_bufferpin is null");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinIsNotNull() {
            addCriterion("confl_bufferpin is not null");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinEqualTo(Long value) {
            addCriterion("confl_bufferpin =", value, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinNotEqualTo(Long value) {
            addCriterion("confl_bufferpin <>", value, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinGreaterThan(Long value) {
            addCriterion("confl_bufferpin >", value, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinGreaterThanOrEqualTo(Long value) {
            addCriterion("confl_bufferpin >=", value, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinLessThan(Long value) {
            addCriterion("confl_bufferpin <", value, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinLessThanOrEqualTo(Long value) {
            addCriterion("confl_bufferpin <=", value, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinIn(List<Long> values) {
            addCriterion("confl_bufferpin in", values, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinNotIn(List<Long> values) {
            addCriterion("confl_bufferpin not in", values, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinBetween(Long value1, Long value2) {
            addCriterion("confl_bufferpin between", value1, value2, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_bufferpinNotBetween(Long value1, Long value2) {
            addCriterion("confl_bufferpin not between", value1, value2, "confl_bufferpin");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockIsNull() {
            addCriterion("confl_deadlock is null");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockIsNotNull() {
            addCriterion("confl_deadlock is not null");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockEqualTo(Long value) {
            addCriterion("confl_deadlock =", value, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockNotEqualTo(Long value) {
            addCriterion("confl_deadlock <>", value, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockGreaterThan(Long value) {
            addCriterion("confl_deadlock >", value, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockGreaterThanOrEqualTo(Long value) {
            addCriterion("confl_deadlock >=", value, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockLessThan(Long value) {
            addCriterion("confl_deadlock <", value, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockLessThanOrEqualTo(Long value) {
            addCriterion("confl_deadlock <=", value, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockIn(List<Long> values) {
            addCriterion("confl_deadlock in", values, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockNotIn(List<Long> values) {
            addCriterion("confl_deadlock not in", values, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockBetween(Long value1, Long value2) {
            addCriterion("confl_deadlock between", value1, value2, "confl_deadlock");
            return (Criteria) this;
        }

        public Criteria andConfl_deadlockNotBetween(Long value1, Long value2) {
            addCriterion("confl_deadlock not between", value1, value2, "confl_deadlock");
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