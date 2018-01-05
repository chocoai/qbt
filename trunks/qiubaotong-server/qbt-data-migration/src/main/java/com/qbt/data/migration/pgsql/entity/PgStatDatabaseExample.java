package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgStatDatabaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatDatabaseExample() {
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

        public Criteria andNumbackendsIsNull() {
            addCriterion("numbackends is null");
            return (Criteria) this;
        }

        public Criteria andNumbackendsIsNotNull() {
            addCriterion("numbackends is not null");
            return (Criteria) this;
        }

        public Criteria andNumbackendsEqualTo(Integer value) {
            addCriterion("numbackends =", value, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsNotEqualTo(Integer value) {
            addCriterion("numbackends <>", value, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsGreaterThan(Integer value) {
            addCriterion("numbackends >", value, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsGreaterThanOrEqualTo(Integer value) {
            addCriterion("numbackends >=", value, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsLessThan(Integer value) {
            addCriterion("numbackends <", value, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsLessThanOrEqualTo(Integer value) {
            addCriterion("numbackends <=", value, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsIn(List<Integer> values) {
            addCriterion("numbackends in", values, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsNotIn(List<Integer> values) {
            addCriterion("numbackends not in", values, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsBetween(Integer value1, Integer value2) {
            addCriterion("numbackends between", value1, value2, "numbackends");
            return (Criteria) this;
        }

        public Criteria andNumbackendsNotBetween(Integer value1, Integer value2) {
            addCriterion("numbackends not between", value1, value2, "numbackends");
            return (Criteria) this;
        }

        public Criteria andXact_commitIsNull() {
            addCriterion("xact_commit is null");
            return (Criteria) this;
        }

        public Criteria andXact_commitIsNotNull() {
            addCriterion("xact_commit is not null");
            return (Criteria) this;
        }

        public Criteria andXact_commitEqualTo(Long value) {
            addCriterion("xact_commit =", value, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitNotEqualTo(Long value) {
            addCriterion("xact_commit <>", value, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitGreaterThan(Long value) {
            addCriterion("xact_commit >", value, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitGreaterThanOrEqualTo(Long value) {
            addCriterion("xact_commit >=", value, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitLessThan(Long value) {
            addCriterion("xact_commit <", value, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitLessThanOrEqualTo(Long value) {
            addCriterion("xact_commit <=", value, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitIn(List<Long> values) {
            addCriterion("xact_commit in", values, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitNotIn(List<Long> values) {
            addCriterion("xact_commit not in", values, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitBetween(Long value1, Long value2) {
            addCriterion("xact_commit between", value1, value2, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_commitNotBetween(Long value1, Long value2) {
            addCriterion("xact_commit not between", value1, value2, "xact_commit");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackIsNull() {
            addCriterion("xact_rollback is null");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackIsNotNull() {
            addCriterion("xact_rollback is not null");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackEqualTo(Long value) {
            addCriterion("xact_rollback =", value, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackNotEqualTo(Long value) {
            addCriterion("xact_rollback <>", value, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackGreaterThan(Long value) {
            addCriterion("xact_rollback >", value, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackGreaterThanOrEqualTo(Long value) {
            addCriterion("xact_rollback >=", value, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackLessThan(Long value) {
            addCriterion("xact_rollback <", value, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackLessThanOrEqualTo(Long value) {
            addCriterion("xact_rollback <=", value, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackIn(List<Long> values) {
            addCriterion("xact_rollback in", values, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackNotIn(List<Long> values) {
            addCriterion("xact_rollback not in", values, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackBetween(Long value1, Long value2) {
            addCriterion("xact_rollback between", value1, value2, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andXact_rollbackNotBetween(Long value1, Long value2) {
            addCriterion("xact_rollback not between", value1, value2, "xact_rollback");
            return (Criteria) this;
        }

        public Criteria andBlks_readIsNull() {
            addCriterion("blks_read is null");
            return (Criteria) this;
        }

        public Criteria andBlks_readIsNotNull() {
            addCriterion("blks_read is not null");
            return (Criteria) this;
        }

        public Criteria andBlks_readEqualTo(Long value) {
            addCriterion("blks_read =", value, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readNotEqualTo(Long value) {
            addCriterion("blks_read <>", value, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readGreaterThan(Long value) {
            addCriterion("blks_read >", value, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readGreaterThanOrEqualTo(Long value) {
            addCriterion("blks_read >=", value, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readLessThan(Long value) {
            addCriterion("blks_read <", value, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readLessThanOrEqualTo(Long value) {
            addCriterion("blks_read <=", value, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readIn(List<Long> values) {
            addCriterion("blks_read in", values, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readNotIn(List<Long> values) {
            addCriterion("blks_read not in", values, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readBetween(Long value1, Long value2) {
            addCriterion("blks_read between", value1, value2, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_readNotBetween(Long value1, Long value2) {
            addCriterion("blks_read not between", value1, value2, "blks_read");
            return (Criteria) this;
        }

        public Criteria andBlks_hitIsNull() {
            addCriterion("blks_hit is null");
            return (Criteria) this;
        }

        public Criteria andBlks_hitIsNotNull() {
            addCriterion("blks_hit is not null");
            return (Criteria) this;
        }

        public Criteria andBlks_hitEqualTo(Long value) {
            addCriterion("blks_hit =", value, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitNotEqualTo(Long value) {
            addCriterion("blks_hit <>", value, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitGreaterThan(Long value) {
            addCriterion("blks_hit >", value, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitGreaterThanOrEqualTo(Long value) {
            addCriterion("blks_hit >=", value, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitLessThan(Long value) {
            addCriterion("blks_hit <", value, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitLessThanOrEqualTo(Long value) {
            addCriterion("blks_hit <=", value, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitIn(List<Long> values) {
            addCriterion("blks_hit in", values, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitNotIn(List<Long> values) {
            addCriterion("blks_hit not in", values, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitBetween(Long value1, Long value2) {
            addCriterion("blks_hit between", value1, value2, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andBlks_hitNotBetween(Long value1, Long value2) {
            addCriterion("blks_hit not between", value1, value2, "blks_hit");
            return (Criteria) this;
        }

        public Criteria andTup_returnedIsNull() {
            addCriterion("tup_returned is null");
            return (Criteria) this;
        }

        public Criteria andTup_returnedIsNotNull() {
            addCriterion("tup_returned is not null");
            return (Criteria) this;
        }

        public Criteria andTup_returnedEqualTo(Long value) {
            addCriterion("tup_returned =", value, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedNotEqualTo(Long value) {
            addCriterion("tup_returned <>", value, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedGreaterThan(Long value) {
            addCriterion("tup_returned >", value, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedGreaterThanOrEqualTo(Long value) {
            addCriterion("tup_returned >=", value, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedLessThan(Long value) {
            addCriterion("tup_returned <", value, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedLessThanOrEqualTo(Long value) {
            addCriterion("tup_returned <=", value, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedIn(List<Long> values) {
            addCriterion("tup_returned in", values, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedNotIn(List<Long> values) {
            addCriterion("tup_returned not in", values, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedBetween(Long value1, Long value2) {
            addCriterion("tup_returned between", value1, value2, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_returnedNotBetween(Long value1, Long value2) {
            addCriterion("tup_returned not between", value1, value2, "tup_returned");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedIsNull() {
            addCriterion("tup_fetched is null");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedIsNotNull() {
            addCriterion("tup_fetched is not null");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedEqualTo(Long value) {
            addCriterion("tup_fetched =", value, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedNotEqualTo(Long value) {
            addCriterion("tup_fetched <>", value, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedGreaterThan(Long value) {
            addCriterion("tup_fetched >", value, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedGreaterThanOrEqualTo(Long value) {
            addCriterion("tup_fetched >=", value, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedLessThan(Long value) {
            addCriterion("tup_fetched <", value, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedLessThanOrEqualTo(Long value) {
            addCriterion("tup_fetched <=", value, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedIn(List<Long> values) {
            addCriterion("tup_fetched in", values, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedNotIn(List<Long> values) {
            addCriterion("tup_fetched not in", values, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedBetween(Long value1, Long value2) {
            addCriterion("tup_fetched between", value1, value2, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_fetchedNotBetween(Long value1, Long value2) {
            addCriterion("tup_fetched not between", value1, value2, "tup_fetched");
            return (Criteria) this;
        }

        public Criteria andTup_insertedIsNull() {
            addCriterion("tup_inserted is null");
            return (Criteria) this;
        }

        public Criteria andTup_insertedIsNotNull() {
            addCriterion("tup_inserted is not null");
            return (Criteria) this;
        }

        public Criteria andTup_insertedEqualTo(Long value) {
            addCriterion("tup_inserted =", value, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedNotEqualTo(Long value) {
            addCriterion("tup_inserted <>", value, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedGreaterThan(Long value) {
            addCriterion("tup_inserted >", value, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedGreaterThanOrEqualTo(Long value) {
            addCriterion("tup_inserted >=", value, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedLessThan(Long value) {
            addCriterion("tup_inserted <", value, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedLessThanOrEqualTo(Long value) {
            addCriterion("tup_inserted <=", value, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedIn(List<Long> values) {
            addCriterion("tup_inserted in", values, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedNotIn(List<Long> values) {
            addCriterion("tup_inserted not in", values, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedBetween(Long value1, Long value2) {
            addCriterion("tup_inserted between", value1, value2, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_insertedNotBetween(Long value1, Long value2) {
            addCriterion("tup_inserted not between", value1, value2, "tup_inserted");
            return (Criteria) this;
        }

        public Criteria andTup_updatedIsNull() {
            addCriterion("tup_updated is null");
            return (Criteria) this;
        }

        public Criteria andTup_updatedIsNotNull() {
            addCriterion("tup_updated is not null");
            return (Criteria) this;
        }

        public Criteria andTup_updatedEqualTo(Long value) {
            addCriterion("tup_updated =", value, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedNotEqualTo(Long value) {
            addCriterion("tup_updated <>", value, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedGreaterThan(Long value) {
            addCriterion("tup_updated >", value, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedGreaterThanOrEqualTo(Long value) {
            addCriterion("tup_updated >=", value, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedLessThan(Long value) {
            addCriterion("tup_updated <", value, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedLessThanOrEqualTo(Long value) {
            addCriterion("tup_updated <=", value, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedIn(List<Long> values) {
            addCriterion("tup_updated in", values, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedNotIn(List<Long> values) {
            addCriterion("tup_updated not in", values, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedBetween(Long value1, Long value2) {
            addCriterion("tup_updated between", value1, value2, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_updatedNotBetween(Long value1, Long value2) {
            addCriterion("tup_updated not between", value1, value2, "tup_updated");
            return (Criteria) this;
        }

        public Criteria andTup_deletedIsNull() {
            addCriterion("tup_deleted is null");
            return (Criteria) this;
        }

        public Criteria andTup_deletedIsNotNull() {
            addCriterion("tup_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andTup_deletedEqualTo(Long value) {
            addCriterion("tup_deleted =", value, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedNotEqualTo(Long value) {
            addCriterion("tup_deleted <>", value, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedGreaterThan(Long value) {
            addCriterion("tup_deleted >", value, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedGreaterThanOrEqualTo(Long value) {
            addCriterion("tup_deleted >=", value, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedLessThan(Long value) {
            addCriterion("tup_deleted <", value, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedLessThanOrEqualTo(Long value) {
            addCriterion("tup_deleted <=", value, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedIn(List<Long> values) {
            addCriterion("tup_deleted in", values, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedNotIn(List<Long> values) {
            addCriterion("tup_deleted not in", values, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedBetween(Long value1, Long value2) {
            addCriterion("tup_deleted between", value1, value2, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andTup_deletedNotBetween(Long value1, Long value2) {
            addCriterion("tup_deleted not between", value1, value2, "tup_deleted");
            return (Criteria) this;
        }

        public Criteria andConflictsIsNull() {
            addCriterion("conflicts is null");
            return (Criteria) this;
        }

        public Criteria andConflictsIsNotNull() {
            addCriterion("conflicts is not null");
            return (Criteria) this;
        }

        public Criteria andConflictsEqualTo(Long value) {
            addCriterion("conflicts =", value, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsNotEqualTo(Long value) {
            addCriterion("conflicts <>", value, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsGreaterThan(Long value) {
            addCriterion("conflicts >", value, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsGreaterThanOrEqualTo(Long value) {
            addCriterion("conflicts >=", value, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsLessThan(Long value) {
            addCriterion("conflicts <", value, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsLessThanOrEqualTo(Long value) {
            addCriterion("conflicts <=", value, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsIn(List<Long> values) {
            addCriterion("conflicts in", values, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsNotIn(List<Long> values) {
            addCriterion("conflicts not in", values, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsBetween(Long value1, Long value2) {
            addCriterion("conflicts between", value1, value2, "conflicts");
            return (Criteria) this;
        }

        public Criteria andConflictsNotBetween(Long value1, Long value2) {
            addCriterion("conflicts not between", value1, value2, "conflicts");
            return (Criteria) this;
        }

        public Criteria andTemp_filesIsNull() {
            addCriterion("temp_files is null");
            return (Criteria) this;
        }

        public Criteria andTemp_filesIsNotNull() {
            addCriterion("temp_files is not null");
            return (Criteria) this;
        }

        public Criteria andTemp_filesEqualTo(Long value) {
            addCriterion("temp_files =", value, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesNotEqualTo(Long value) {
            addCriterion("temp_files <>", value, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesGreaterThan(Long value) {
            addCriterion("temp_files >", value, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesGreaterThanOrEqualTo(Long value) {
            addCriterion("temp_files >=", value, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesLessThan(Long value) {
            addCriterion("temp_files <", value, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesLessThanOrEqualTo(Long value) {
            addCriterion("temp_files <=", value, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesIn(List<Long> values) {
            addCriterion("temp_files in", values, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesNotIn(List<Long> values) {
            addCriterion("temp_files not in", values, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesBetween(Long value1, Long value2) {
            addCriterion("temp_files between", value1, value2, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_filesNotBetween(Long value1, Long value2) {
            addCriterion("temp_files not between", value1, value2, "temp_files");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesIsNull() {
            addCriterion("temp_bytes is null");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesIsNotNull() {
            addCriterion("temp_bytes is not null");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesEqualTo(Long value) {
            addCriterion("temp_bytes =", value, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesNotEqualTo(Long value) {
            addCriterion("temp_bytes <>", value, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesGreaterThan(Long value) {
            addCriterion("temp_bytes >", value, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesGreaterThanOrEqualTo(Long value) {
            addCriterion("temp_bytes >=", value, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesLessThan(Long value) {
            addCriterion("temp_bytes <", value, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesLessThanOrEqualTo(Long value) {
            addCriterion("temp_bytes <=", value, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesIn(List<Long> values) {
            addCriterion("temp_bytes in", values, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesNotIn(List<Long> values) {
            addCriterion("temp_bytes not in", values, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesBetween(Long value1, Long value2) {
            addCriterion("temp_bytes between", value1, value2, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andTemp_bytesNotBetween(Long value1, Long value2) {
            addCriterion("temp_bytes not between", value1, value2, "temp_bytes");
            return (Criteria) this;
        }

        public Criteria andDeadlocksIsNull() {
            addCriterion("deadlocks is null");
            return (Criteria) this;
        }

        public Criteria andDeadlocksIsNotNull() {
            addCriterion("deadlocks is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlocksEqualTo(Long value) {
            addCriterion("deadlocks =", value, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksNotEqualTo(Long value) {
            addCriterion("deadlocks <>", value, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksGreaterThan(Long value) {
            addCriterion("deadlocks >", value, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksGreaterThanOrEqualTo(Long value) {
            addCriterion("deadlocks >=", value, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksLessThan(Long value) {
            addCriterion("deadlocks <", value, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksLessThanOrEqualTo(Long value) {
            addCriterion("deadlocks <=", value, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksIn(List<Long> values) {
            addCriterion("deadlocks in", values, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksNotIn(List<Long> values) {
            addCriterion("deadlocks not in", values, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksBetween(Long value1, Long value2) {
            addCriterion("deadlocks between", value1, value2, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andDeadlocksNotBetween(Long value1, Long value2) {
            addCriterion("deadlocks not between", value1, value2, "deadlocks");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeIsNull() {
            addCriterion("blk_read_time is null");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeIsNotNull() {
            addCriterion("blk_read_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeEqualTo(Double value) {
            addCriterion("blk_read_time =", value, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeNotEqualTo(Double value) {
            addCriterion("blk_read_time <>", value, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeGreaterThan(Double value) {
            addCriterion("blk_read_time >", value, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeGreaterThanOrEqualTo(Double value) {
            addCriterion("blk_read_time >=", value, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeLessThan(Double value) {
            addCriterion("blk_read_time <", value, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeLessThanOrEqualTo(Double value) {
            addCriterion("blk_read_time <=", value, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeIn(List<Double> values) {
            addCriterion("blk_read_time in", values, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeNotIn(List<Double> values) {
            addCriterion("blk_read_time not in", values, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeBetween(Double value1, Double value2) {
            addCriterion("blk_read_time between", value1, value2, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_read_timeNotBetween(Double value1, Double value2) {
            addCriterion("blk_read_time not between", value1, value2, "blk_read_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeIsNull() {
            addCriterion("blk_write_time is null");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeIsNotNull() {
            addCriterion("blk_write_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeEqualTo(Double value) {
            addCriterion("blk_write_time =", value, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeNotEqualTo(Double value) {
            addCriterion("blk_write_time <>", value, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeGreaterThan(Double value) {
            addCriterion("blk_write_time >", value, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeGreaterThanOrEqualTo(Double value) {
            addCriterion("blk_write_time >=", value, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeLessThan(Double value) {
            addCriterion("blk_write_time <", value, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeLessThanOrEqualTo(Double value) {
            addCriterion("blk_write_time <=", value, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeIn(List<Double> values) {
            addCriterion("blk_write_time in", values, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeNotIn(List<Double> values) {
            addCriterion("blk_write_time not in", values, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeBetween(Double value1, Double value2) {
            addCriterion("blk_write_time between", value1, value2, "blk_write_time");
            return (Criteria) this;
        }

        public Criteria andBlk_write_timeNotBetween(Double value1, Double value2) {
            addCriterion("blk_write_time not between", value1, value2, "blk_write_time");
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