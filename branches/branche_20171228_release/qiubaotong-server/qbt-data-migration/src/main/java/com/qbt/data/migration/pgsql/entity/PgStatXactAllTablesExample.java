package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatXactAllTablesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatXactAllTablesExample() {
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

        public Criteria andSeq_scanIsNull() {
            addCriterion("seq_scan is null");
            return (Criteria) this;
        }

        public Criteria andSeq_scanIsNotNull() {
            addCriterion("seq_scan is not null");
            return (Criteria) this;
        }

        public Criteria andSeq_scanEqualTo(Long value) {
            addCriterion("seq_scan =", value, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanNotEqualTo(Long value) {
            addCriterion("seq_scan <>", value, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanGreaterThan(Long value) {
            addCriterion("seq_scan >", value, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanGreaterThanOrEqualTo(Long value) {
            addCriterion("seq_scan >=", value, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanLessThan(Long value) {
            addCriterion("seq_scan <", value, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanLessThanOrEqualTo(Long value) {
            addCriterion("seq_scan <=", value, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanIn(List<Long> values) {
            addCriterion("seq_scan in", values, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanNotIn(List<Long> values) {
            addCriterion("seq_scan not in", values, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanBetween(Long value1, Long value2) {
            addCriterion("seq_scan between", value1, value2, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_scanNotBetween(Long value1, Long value2) {
            addCriterion("seq_scan not between", value1, value2, "seq_scan");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readIsNull() {
            addCriterion("seq_tup_read is null");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readIsNotNull() {
            addCriterion("seq_tup_read is not null");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readEqualTo(Long value) {
            addCriterion("seq_tup_read =", value, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readNotEqualTo(Long value) {
            addCriterion("seq_tup_read <>", value, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readGreaterThan(Long value) {
            addCriterion("seq_tup_read >", value, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readGreaterThanOrEqualTo(Long value) {
            addCriterion("seq_tup_read >=", value, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readLessThan(Long value) {
            addCriterion("seq_tup_read <", value, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readLessThanOrEqualTo(Long value) {
            addCriterion("seq_tup_read <=", value, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readIn(List<Long> values) {
            addCriterion("seq_tup_read in", values, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readNotIn(List<Long> values) {
            addCriterion("seq_tup_read not in", values, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readBetween(Long value1, Long value2) {
            addCriterion("seq_tup_read between", value1, value2, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andSeq_tup_readNotBetween(Long value1, Long value2) {
            addCriterion("seq_tup_read not between", value1, value2, "seq_tup_read");
            return (Criteria) this;
        }

        public Criteria andIdx_scanIsNull() {
            addCriterion("idx_scan is null");
            return (Criteria) this;
        }

        public Criteria andIdx_scanIsNotNull() {
            addCriterion("idx_scan is not null");
            return (Criteria) this;
        }

        public Criteria andIdx_scanEqualTo(Long value) {
            addCriterion("idx_scan =", value, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanNotEqualTo(Long value) {
            addCriterion("idx_scan <>", value, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanGreaterThan(Long value) {
            addCriterion("idx_scan >", value, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanGreaterThanOrEqualTo(Long value) {
            addCriterion("idx_scan >=", value, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanLessThan(Long value) {
            addCriterion("idx_scan <", value, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanLessThanOrEqualTo(Long value) {
            addCriterion("idx_scan <=", value, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanIn(List<Long> values) {
            addCriterion("idx_scan in", values, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanNotIn(List<Long> values) {
            addCriterion("idx_scan not in", values, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanBetween(Long value1, Long value2) {
            addCriterion("idx_scan between", value1, value2, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_scanNotBetween(Long value1, Long value2) {
            addCriterion("idx_scan not between", value1, value2, "idx_scan");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchIsNull() {
            addCriterion("idx_tup_fetch is null");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchIsNotNull() {
            addCriterion("idx_tup_fetch is not null");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchEqualTo(Long value) {
            addCriterion("idx_tup_fetch =", value, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchNotEqualTo(Long value) {
            addCriterion("idx_tup_fetch <>", value, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchGreaterThan(Long value) {
            addCriterion("idx_tup_fetch >", value, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchGreaterThanOrEqualTo(Long value) {
            addCriterion("idx_tup_fetch >=", value, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchLessThan(Long value) {
            addCriterion("idx_tup_fetch <", value, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchLessThanOrEqualTo(Long value) {
            addCriterion("idx_tup_fetch <=", value, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchIn(List<Long> values) {
            addCriterion("idx_tup_fetch in", values, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchNotIn(List<Long> values) {
            addCriterion("idx_tup_fetch not in", values, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchBetween(Long value1, Long value2) {
            addCriterion("idx_tup_fetch between", value1, value2, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andIdx_tup_fetchNotBetween(Long value1, Long value2) {
            addCriterion("idx_tup_fetch not between", value1, value2, "idx_tup_fetch");
            return (Criteria) this;
        }

        public Criteria andN_tup_insIsNull() {
            addCriterion("n_tup_ins is null");
            return (Criteria) this;
        }

        public Criteria andN_tup_insIsNotNull() {
            addCriterion("n_tup_ins is not null");
            return (Criteria) this;
        }

        public Criteria andN_tup_insEqualTo(Long value) {
            addCriterion("n_tup_ins =", value, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insNotEqualTo(Long value) {
            addCriterion("n_tup_ins <>", value, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insGreaterThan(Long value) {
            addCriterion("n_tup_ins >", value, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insGreaterThanOrEqualTo(Long value) {
            addCriterion("n_tup_ins >=", value, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insLessThan(Long value) {
            addCriterion("n_tup_ins <", value, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insLessThanOrEqualTo(Long value) {
            addCriterion("n_tup_ins <=", value, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insIn(List<Long> values) {
            addCriterion("n_tup_ins in", values, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insNotIn(List<Long> values) {
            addCriterion("n_tup_ins not in", values, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insBetween(Long value1, Long value2) {
            addCriterion("n_tup_ins between", value1, value2, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_insNotBetween(Long value1, Long value2) {
            addCriterion("n_tup_ins not between", value1, value2, "n_tup_ins");
            return (Criteria) this;
        }

        public Criteria andN_tup_updIsNull() {
            addCriterion("n_tup_upd is null");
            return (Criteria) this;
        }

        public Criteria andN_tup_updIsNotNull() {
            addCriterion("n_tup_upd is not null");
            return (Criteria) this;
        }

        public Criteria andN_tup_updEqualTo(Long value) {
            addCriterion("n_tup_upd =", value, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updNotEqualTo(Long value) {
            addCriterion("n_tup_upd <>", value, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updGreaterThan(Long value) {
            addCriterion("n_tup_upd >", value, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updGreaterThanOrEqualTo(Long value) {
            addCriterion("n_tup_upd >=", value, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updLessThan(Long value) {
            addCriterion("n_tup_upd <", value, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updLessThanOrEqualTo(Long value) {
            addCriterion("n_tup_upd <=", value, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updIn(List<Long> values) {
            addCriterion("n_tup_upd in", values, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updNotIn(List<Long> values) {
            addCriterion("n_tup_upd not in", values, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updBetween(Long value1, Long value2) {
            addCriterion("n_tup_upd between", value1, value2, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_updNotBetween(Long value1, Long value2) {
            addCriterion("n_tup_upd not between", value1, value2, "n_tup_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_delIsNull() {
            addCriterion("n_tup_del is null");
            return (Criteria) this;
        }

        public Criteria andN_tup_delIsNotNull() {
            addCriterion("n_tup_del is not null");
            return (Criteria) this;
        }

        public Criteria andN_tup_delEqualTo(Long value) {
            addCriterion("n_tup_del =", value, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delNotEqualTo(Long value) {
            addCriterion("n_tup_del <>", value, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delGreaterThan(Long value) {
            addCriterion("n_tup_del >", value, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delGreaterThanOrEqualTo(Long value) {
            addCriterion("n_tup_del >=", value, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delLessThan(Long value) {
            addCriterion("n_tup_del <", value, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delLessThanOrEqualTo(Long value) {
            addCriterion("n_tup_del <=", value, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delIn(List<Long> values) {
            addCriterion("n_tup_del in", values, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delNotIn(List<Long> values) {
            addCriterion("n_tup_del not in", values, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delBetween(Long value1, Long value2) {
            addCriterion("n_tup_del between", value1, value2, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_delNotBetween(Long value1, Long value2) {
            addCriterion("n_tup_del not between", value1, value2, "n_tup_del");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updIsNull() {
            addCriterion("n_tup_hot_upd is null");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updIsNotNull() {
            addCriterion("n_tup_hot_upd is not null");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updEqualTo(Long value) {
            addCriterion("n_tup_hot_upd =", value, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updNotEqualTo(Long value) {
            addCriterion("n_tup_hot_upd <>", value, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updGreaterThan(Long value) {
            addCriterion("n_tup_hot_upd >", value, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updGreaterThanOrEqualTo(Long value) {
            addCriterion("n_tup_hot_upd >=", value, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updLessThan(Long value) {
            addCriterion("n_tup_hot_upd <", value, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updLessThanOrEqualTo(Long value) {
            addCriterion("n_tup_hot_upd <=", value, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updIn(List<Long> values) {
            addCriterion("n_tup_hot_upd in", values, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updNotIn(List<Long> values) {
            addCriterion("n_tup_hot_upd not in", values, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updBetween(Long value1, Long value2) {
            addCriterion("n_tup_hot_upd between", value1, value2, "n_tup_hot_upd");
            return (Criteria) this;
        }

        public Criteria andN_tup_hot_updNotBetween(Long value1, Long value2) {
            addCriterion("n_tup_hot_upd not between", value1, value2, "n_tup_hot_upd");
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