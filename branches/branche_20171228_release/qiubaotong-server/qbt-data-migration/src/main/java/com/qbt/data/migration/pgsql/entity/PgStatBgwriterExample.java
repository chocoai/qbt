package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgStatBgwriterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatBgwriterExample() {
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

        public Criteria andCheckpoints_timedIsNull() {
            addCriterion("checkpoints_timed is null");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedIsNotNull() {
            addCriterion("checkpoints_timed is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedEqualTo(Long value) {
            addCriterion("checkpoints_timed =", value, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedNotEqualTo(Long value) {
            addCriterion("checkpoints_timed <>", value, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedGreaterThan(Long value) {
            addCriterion("checkpoints_timed >", value, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedGreaterThanOrEqualTo(Long value) {
            addCriterion("checkpoints_timed >=", value, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedLessThan(Long value) {
            addCriterion("checkpoints_timed <", value, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedLessThanOrEqualTo(Long value) {
            addCriterion("checkpoints_timed <=", value, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedIn(List<Long> values) {
            addCriterion("checkpoints_timed in", values, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedNotIn(List<Long> values) {
            addCriterion("checkpoints_timed not in", values, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedBetween(Long value1, Long value2) {
            addCriterion("checkpoints_timed between", value1, value2, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_timedNotBetween(Long value1, Long value2) {
            addCriterion("checkpoints_timed not between", value1, value2, "checkpoints_timed");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqIsNull() {
            addCriterion("checkpoints_req is null");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqIsNotNull() {
            addCriterion("checkpoints_req is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqEqualTo(Long value) {
            addCriterion("checkpoints_req =", value, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqNotEqualTo(Long value) {
            addCriterion("checkpoints_req <>", value, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqGreaterThan(Long value) {
            addCriterion("checkpoints_req >", value, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqGreaterThanOrEqualTo(Long value) {
            addCriterion("checkpoints_req >=", value, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqLessThan(Long value) {
            addCriterion("checkpoints_req <", value, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqLessThanOrEqualTo(Long value) {
            addCriterion("checkpoints_req <=", value, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqIn(List<Long> values) {
            addCriterion("checkpoints_req in", values, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqNotIn(List<Long> values) {
            addCriterion("checkpoints_req not in", values, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqBetween(Long value1, Long value2) {
            addCriterion("checkpoints_req between", value1, value2, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoints_reqNotBetween(Long value1, Long value2) {
            addCriterion("checkpoints_req not between", value1, value2, "checkpoints_req");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeIsNull() {
            addCriterion("checkpoint_write_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeIsNotNull() {
            addCriterion("checkpoint_write_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeEqualTo(Double value) {
            addCriterion("checkpoint_write_time =", value, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeNotEqualTo(Double value) {
            addCriterion("checkpoint_write_time <>", value, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeGreaterThan(Double value) {
            addCriterion("checkpoint_write_time >", value, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeGreaterThanOrEqualTo(Double value) {
            addCriterion("checkpoint_write_time >=", value, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeLessThan(Double value) {
            addCriterion("checkpoint_write_time <", value, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeLessThanOrEqualTo(Double value) {
            addCriterion("checkpoint_write_time <=", value, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeIn(List<Double> values) {
            addCriterion("checkpoint_write_time in", values, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeNotIn(List<Double> values) {
            addCriterion("checkpoint_write_time not in", values, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeBetween(Double value1, Double value2) {
            addCriterion("checkpoint_write_time between", value1, value2, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_write_timeNotBetween(Double value1, Double value2) {
            addCriterion("checkpoint_write_time not between", value1, value2, "checkpoint_write_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeIsNull() {
            addCriterion("checkpoint_sync_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeIsNotNull() {
            addCriterion("checkpoint_sync_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeEqualTo(Double value) {
            addCriterion("checkpoint_sync_time =", value, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeNotEqualTo(Double value) {
            addCriterion("checkpoint_sync_time <>", value, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeGreaterThan(Double value) {
            addCriterion("checkpoint_sync_time >", value, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeGreaterThanOrEqualTo(Double value) {
            addCriterion("checkpoint_sync_time >=", value, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeLessThan(Double value) {
            addCriterion("checkpoint_sync_time <", value, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeLessThanOrEqualTo(Double value) {
            addCriterion("checkpoint_sync_time <=", value, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeIn(List<Double> values) {
            addCriterion("checkpoint_sync_time in", values, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeNotIn(List<Double> values) {
            addCriterion("checkpoint_sync_time not in", values, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeBetween(Double value1, Double value2) {
            addCriterion("checkpoint_sync_time between", value1, value2, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andCheckpoint_sync_timeNotBetween(Double value1, Double value2) {
            addCriterion("checkpoint_sync_time not between", value1, value2, "checkpoint_sync_time");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointIsNull() {
            addCriterion("buffers_checkpoint is null");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointIsNotNull() {
            addCriterion("buffers_checkpoint is not null");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointEqualTo(Long value) {
            addCriterion("buffers_checkpoint =", value, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointNotEqualTo(Long value) {
            addCriterion("buffers_checkpoint <>", value, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointGreaterThan(Long value) {
            addCriterion("buffers_checkpoint >", value, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointGreaterThanOrEqualTo(Long value) {
            addCriterion("buffers_checkpoint >=", value, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointLessThan(Long value) {
            addCriterion("buffers_checkpoint <", value, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointLessThanOrEqualTo(Long value) {
            addCriterion("buffers_checkpoint <=", value, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointIn(List<Long> values) {
            addCriterion("buffers_checkpoint in", values, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointNotIn(List<Long> values) {
            addCriterion("buffers_checkpoint not in", values, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointBetween(Long value1, Long value2) {
            addCriterion("buffers_checkpoint between", value1, value2, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_checkpointNotBetween(Long value1, Long value2) {
            addCriterion("buffers_checkpoint not between", value1, value2, "buffers_checkpoint");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanIsNull() {
            addCriterion("buffers_clean is null");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanIsNotNull() {
            addCriterion("buffers_clean is not null");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanEqualTo(Long value) {
            addCriterion("buffers_clean =", value, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanNotEqualTo(Long value) {
            addCriterion("buffers_clean <>", value, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanGreaterThan(Long value) {
            addCriterion("buffers_clean >", value, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanGreaterThanOrEqualTo(Long value) {
            addCriterion("buffers_clean >=", value, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanLessThan(Long value) {
            addCriterion("buffers_clean <", value, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanLessThanOrEqualTo(Long value) {
            addCriterion("buffers_clean <=", value, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanIn(List<Long> values) {
            addCriterion("buffers_clean in", values, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanNotIn(List<Long> values) {
            addCriterion("buffers_clean not in", values, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanBetween(Long value1, Long value2) {
            addCriterion("buffers_clean between", value1, value2, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_cleanNotBetween(Long value1, Long value2) {
            addCriterion("buffers_clean not between", value1, value2, "buffers_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanIsNull() {
            addCriterion("maxwritten_clean is null");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanIsNotNull() {
            addCriterion("maxwritten_clean is not null");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanEqualTo(Long value) {
            addCriterion("maxwritten_clean =", value, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanNotEqualTo(Long value) {
            addCriterion("maxwritten_clean <>", value, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanGreaterThan(Long value) {
            addCriterion("maxwritten_clean >", value, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanGreaterThanOrEqualTo(Long value) {
            addCriterion("maxwritten_clean >=", value, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanLessThan(Long value) {
            addCriterion("maxwritten_clean <", value, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanLessThanOrEqualTo(Long value) {
            addCriterion("maxwritten_clean <=", value, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanIn(List<Long> values) {
            addCriterion("maxwritten_clean in", values, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanNotIn(List<Long> values) {
            addCriterion("maxwritten_clean not in", values, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanBetween(Long value1, Long value2) {
            addCriterion("maxwritten_clean between", value1, value2, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andMaxwritten_cleanNotBetween(Long value1, Long value2) {
            addCriterion("maxwritten_clean not between", value1, value2, "maxwritten_clean");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendIsNull() {
            addCriterion("buffers_backend is null");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendIsNotNull() {
            addCriterion("buffers_backend is not null");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendEqualTo(Long value) {
            addCriterion("buffers_backend =", value, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendNotEqualTo(Long value) {
            addCriterion("buffers_backend <>", value, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendGreaterThan(Long value) {
            addCriterion("buffers_backend >", value, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendGreaterThanOrEqualTo(Long value) {
            addCriterion("buffers_backend >=", value, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendLessThan(Long value) {
            addCriterion("buffers_backend <", value, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendLessThanOrEqualTo(Long value) {
            addCriterion("buffers_backend <=", value, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendIn(List<Long> values) {
            addCriterion("buffers_backend in", values, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendNotIn(List<Long> values) {
            addCriterion("buffers_backend not in", values, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendBetween(Long value1, Long value2) {
            addCriterion("buffers_backend between", value1, value2, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backendNotBetween(Long value1, Long value2) {
            addCriterion("buffers_backend not between", value1, value2, "buffers_backend");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncIsNull() {
            addCriterion("buffers_backend_fsync is null");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncIsNotNull() {
            addCriterion("buffers_backend_fsync is not null");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncEqualTo(Long value) {
            addCriterion("buffers_backend_fsync =", value, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncNotEqualTo(Long value) {
            addCriterion("buffers_backend_fsync <>", value, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncGreaterThan(Long value) {
            addCriterion("buffers_backend_fsync >", value, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncGreaterThanOrEqualTo(Long value) {
            addCriterion("buffers_backend_fsync >=", value, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncLessThan(Long value) {
            addCriterion("buffers_backend_fsync <", value, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncLessThanOrEqualTo(Long value) {
            addCriterion("buffers_backend_fsync <=", value, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncIn(List<Long> values) {
            addCriterion("buffers_backend_fsync in", values, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncNotIn(List<Long> values) {
            addCriterion("buffers_backend_fsync not in", values, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncBetween(Long value1, Long value2) {
            addCriterion("buffers_backend_fsync between", value1, value2, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_backend_fsyncNotBetween(Long value1, Long value2) {
            addCriterion("buffers_backend_fsync not between", value1, value2, "buffers_backend_fsync");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocIsNull() {
            addCriterion("buffers_alloc is null");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocIsNotNull() {
            addCriterion("buffers_alloc is not null");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocEqualTo(Long value) {
            addCriterion("buffers_alloc =", value, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocNotEqualTo(Long value) {
            addCriterion("buffers_alloc <>", value, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocGreaterThan(Long value) {
            addCriterion("buffers_alloc >", value, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocGreaterThanOrEqualTo(Long value) {
            addCriterion("buffers_alloc >=", value, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocLessThan(Long value) {
            addCriterion("buffers_alloc <", value, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocLessThanOrEqualTo(Long value) {
            addCriterion("buffers_alloc <=", value, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocIn(List<Long> values) {
            addCriterion("buffers_alloc in", values, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocNotIn(List<Long> values) {
            addCriterion("buffers_alloc not in", values, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocBetween(Long value1, Long value2) {
            addCriterion("buffers_alloc between", value1, value2, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andBuffers_allocNotBetween(Long value1, Long value2) {
            addCriterion("buffers_alloc not between", value1, value2, "buffers_alloc");
            return (Criteria) this;
        }

        public Criteria andStats_resetIsNull() {
            addCriterion("stats_reset is null");
            return (Criteria) this;
        }

        public Criteria andStats_resetIsNotNull() {
            addCriterion("stats_reset is not null");
            return (Criteria) this;
        }

        public Criteria andStats_resetEqualTo(Date value) {
            addCriterion("stats_reset =", value, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetNotEqualTo(Date value) {
            addCriterion("stats_reset <>", value, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetGreaterThan(Date value) {
            addCriterion("stats_reset >", value, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetGreaterThanOrEqualTo(Date value) {
            addCriterion("stats_reset >=", value, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetLessThan(Date value) {
            addCriterion("stats_reset <", value, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetLessThanOrEqualTo(Date value) {
            addCriterion("stats_reset <=", value, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetIn(List<Date> values) {
            addCriterion("stats_reset in", values, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetNotIn(List<Date> values) {
            addCriterion("stats_reset not in", values, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetBetween(Date value1, Date value2) {
            addCriterion("stats_reset between", value1, value2, "stats_reset");
            return (Criteria) this;
        }

        public Criteria andStats_resetNotBetween(Date value1, Date value2) {
            addCriterion("stats_reset not between", value1, value2, "stats_reset");
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