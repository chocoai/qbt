package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatioSysTablesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatioSysTablesExample() {
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

        public Criteria andRelidIsNull() {
            addCriterion("relid is null");
            return (Criteria) this;
        }

        public Criteria andRelidIsNotNull() {
            addCriterion("relid is not null");
            return (Criteria) this;
        }

        public Criteria andRelidEqualTo(Long value) {
            addCriterion("relid =", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidNotEqualTo(Long value) {
            addCriterion("relid <>", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidGreaterThan(Long value) {
            addCriterion("relid >", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidGreaterThanOrEqualTo(Long value) {
            addCriterion("relid >=", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidLessThan(Long value) {
            addCriterion("relid <", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidLessThanOrEqualTo(Long value) {
            addCriterion("relid <=", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidIn(List<Long> values) {
            addCriterion("relid in", values, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidNotIn(List<Long> values) {
            addCriterion("relid not in", values, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidBetween(Long value1, Long value2) {
            addCriterion("relid between", value1, value2, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidNotBetween(Long value1, Long value2) {
            addCriterion("relid not between", value1, value2, "relid");
            return (Criteria) this;
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

        public Criteria andRelnameIsNull() {
            addCriterion("relname is null");
            return (Criteria) this;
        }

        public Criteria andRelnameIsNotNull() {
            addCriterion("relname is not null");
            return (Criteria) this;
        }

        public Criteria andRelnameEqualTo(String value) {
            addCriterion("relname =", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotEqualTo(String value) {
            addCriterion("relname <>", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThan(String value) {
            addCriterion("relname >", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThanOrEqualTo(String value) {
            addCriterion("relname >=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThan(String value) {
            addCriterion("relname <", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThanOrEqualTo(String value) {
            addCriterion("relname <=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLike(String value) {
            addCriterion("relname like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotLike(String value) {
            addCriterion("relname not like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameIn(List<String> values) {
            addCriterion("relname in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotIn(List<String> values) {
            addCriterion("relname not in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameBetween(String value1, String value2) {
            addCriterion("relname between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotBetween(String value1, String value2) {
            addCriterion("relname not between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readIsNull() {
            addCriterion("heap_blks_read is null");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readIsNotNull() {
            addCriterion("heap_blks_read is not null");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readEqualTo(Long value) {
            addCriterion("heap_blks_read =", value, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readNotEqualTo(Long value) {
            addCriterion("heap_blks_read <>", value, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readGreaterThan(Long value) {
            addCriterion("heap_blks_read >", value, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readGreaterThanOrEqualTo(Long value) {
            addCriterion("heap_blks_read >=", value, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readLessThan(Long value) {
            addCriterion("heap_blks_read <", value, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readLessThanOrEqualTo(Long value) {
            addCriterion("heap_blks_read <=", value, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readIn(List<Long> values) {
            addCriterion("heap_blks_read in", values, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readNotIn(List<Long> values) {
            addCriterion("heap_blks_read not in", values, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readBetween(Long value1, Long value2) {
            addCriterion("heap_blks_read between", value1, value2, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_readNotBetween(Long value1, Long value2) {
            addCriterion("heap_blks_read not between", value1, value2, "heap_blks_read");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitIsNull() {
            addCriterion("heap_blks_hit is null");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitIsNotNull() {
            addCriterion("heap_blks_hit is not null");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitEqualTo(Long value) {
            addCriterion("heap_blks_hit =", value, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitNotEqualTo(Long value) {
            addCriterion("heap_blks_hit <>", value, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitGreaterThan(Long value) {
            addCriterion("heap_blks_hit >", value, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitGreaterThanOrEqualTo(Long value) {
            addCriterion("heap_blks_hit >=", value, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitLessThan(Long value) {
            addCriterion("heap_blks_hit <", value, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitLessThanOrEqualTo(Long value) {
            addCriterion("heap_blks_hit <=", value, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitIn(List<Long> values) {
            addCriterion("heap_blks_hit in", values, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitNotIn(List<Long> values) {
            addCriterion("heap_blks_hit not in", values, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitBetween(Long value1, Long value2) {
            addCriterion("heap_blks_hit between", value1, value2, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andHeap_blks_hitNotBetween(Long value1, Long value2) {
            addCriterion("heap_blks_hit not between", value1, value2, "heap_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readIsNull() {
            addCriterion("idx_blks_read is null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readIsNotNull() {
            addCriterion("idx_blks_read is not null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readEqualTo(Long value) {
            addCriterion("idx_blks_read =", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readNotEqualTo(Long value) {
            addCriterion("idx_blks_read <>", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readGreaterThan(Long value) {
            addCriterion("idx_blks_read >", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readGreaterThanOrEqualTo(Long value) {
            addCriterion("idx_blks_read >=", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readLessThan(Long value) {
            addCriterion("idx_blks_read <", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readLessThanOrEqualTo(Long value) {
            addCriterion("idx_blks_read <=", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readIn(List<Long> values) {
            addCriterion("idx_blks_read in", values, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readNotIn(List<Long> values) {
            addCriterion("idx_blks_read not in", values, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readBetween(Long value1, Long value2) {
            addCriterion("idx_blks_read between", value1, value2, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readNotBetween(Long value1, Long value2) {
            addCriterion("idx_blks_read not between", value1, value2, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitIsNull() {
            addCriterion("idx_blks_hit is null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitIsNotNull() {
            addCriterion("idx_blks_hit is not null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitEqualTo(Long value) {
            addCriterion("idx_blks_hit =", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitNotEqualTo(Long value) {
            addCriterion("idx_blks_hit <>", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitGreaterThan(Long value) {
            addCriterion("idx_blks_hit >", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitGreaterThanOrEqualTo(Long value) {
            addCriterion("idx_blks_hit >=", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitLessThan(Long value) {
            addCriterion("idx_blks_hit <", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitLessThanOrEqualTo(Long value) {
            addCriterion("idx_blks_hit <=", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitIn(List<Long> values) {
            addCriterion("idx_blks_hit in", values, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitNotIn(List<Long> values) {
            addCriterion("idx_blks_hit not in", values, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitBetween(Long value1, Long value2) {
            addCriterion("idx_blks_hit between", value1, value2, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitNotBetween(Long value1, Long value2) {
            addCriterion("idx_blks_hit not between", value1, value2, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readIsNull() {
            addCriterion("toast_blks_read is null");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readIsNotNull() {
            addCriterion("toast_blks_read is not null");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readEqualTo(Long value) {
            addCriterion("toast_blks_read =", value, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readNotEqualTo(Long value) {
            addCriterion("toast_blks_read <>", value, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readGreaterThan(Long value) {
            addCriterion("toast_blks_read >", value, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readGreaterThanOrEqualTo(Long value) {
            addCriterion("toast_blks_read >=", value, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readLessThan(Long value) {
            addCriterion("toast_blks_read <", value, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readLessThanOrEqualTo(Long value) {
            addCriterion("toast_blks_read <=", value, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readIn(List<Long> values) {
            addCriterion("toast_blks_read in", values, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readNotIn(List<Long> values) {
            addCriterion("toast_blks_read not in", values, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readBetween(Long value1, Long value2) {
            addCriterion("toast_blks_read between", value1, value2, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_readNotBetween(Long value1, Long value2) {
            addCriterion("toast_blks_read not between", value1, value2, "toast_blks_read");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitIsNull() {
            addCriterion("toast_blks_hit is null");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitIsNotNull() {
            addCriterion("toast_blks_hit is not null");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitEqualTo(Long value) {
            addCriterion("toast_blks_hit =", value, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitNotEqualTo(Long value) {
            addCriterion("toast_blks_hit <>", value, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitGreaterThan(Long value) {
            addCriterion("toast_blks_hit >", value, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitGreaterThanOrEqualTo(Long value) {
            addCriterion("toast_blks_hit >=", value, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitLessThan(Long value) {
            addCriterion("toast_blks_hit <", value, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitLessThanOrEqualTo(Long value) {
            addCriterion("toast_blks_hit <=", value, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitIn(List<Long> values) {
            addCriterion("toast_blks_hit in", values, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitNotIn(List<Long> values) {
            addCriterion("toast_blks_hit not in", values, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitBetween(Long value1, Long value2) {
            addCriterion("toast_blks_hit between", value1, value2, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andToast_blks_hitNotBetween(Long value1, Long value2) {
            addCriterion("toast_blks_hit not between", value1, value2, "toast_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readIsNull() {
            addCriterion("tidx_blks_read is null");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readIsNotNull() {
            addCriterion("tidx_blks_read is not null");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readEqualTo(Long value) {
            addCriterion("tidx_blks_read =", value, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readNotEqualTo(Long value) {
            addCriterion("tidx_blks_read <>", value, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readGreaterThan(Long value) {
            addCriterion("tidx_blks_read >", value, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readGreaterThanOrEqualTo(Long value) {
            addCriterion("tidx_blks_read >=", value, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readLessThan(Long value) {
            addCriterion("tidx_blks_read <", value, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readLessThanOrEqualTo(Long value) {
            addCriterion("tidx_blks_read <=", value, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readIn(List<Long> values) {
            addCriterion("tidx_blks_read in", values, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readNotIn(List<Long> values) {
            addCriterion("tidx_blks_read not in", values, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readBetween(Long value1, Long value2) {
            addCriterion("tidx_blks_read between", value1, value2, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_readNotBetween(Long value1, Long value2) {
            addCriterion("tidx_blks_read not between", value1, value2, "tidx_blks_read");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitIsNull() {
            addCriterion("tidx_blks_hit is null");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitIsNotNull() {
            addCriterion("tidx_blks_hit is not null");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitEqualTo(Long value) {
            addCriterion("tidx_blks_hit =", value, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitNotEqualTo(Long value) {
            addCriterion("tidx_blks_hit <>", value, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitGreaterThan(Long value) {
            addCriterion("tidx_blks_hit >", value, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitGreaterThanOrEqualTo(Long value) {
            addCriterion("tidx_blks_hit >=", value, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitLessThan(Long value) {
            addCriterion("tidx_blks_hit <", value, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitLessThanOrEqualTo(Long value) {
            addCriterion("tidx_blks_hit <=", value, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitIn(List<Long> values) {
            addCriterion("tidx_blks_hit in", values, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitNotIn(List<Long> values) {
            addCriterion("tidx_blks_hit not in", values, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitBetween(Long value1, Long value2) {
            addCriterion("tidx_blks_hit between", value1, value2, "tidx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andTidx_blks_hitNotBetween(Long value1, Long value2) {
            addCriterion("tidx_blks_hit not between", value1, value2, "tidx_blks_hit");
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