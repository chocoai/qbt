package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgLocksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgLocksExample() {
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

        public Criteria andLocktypeIsNull() {
            addCriterion("locktype is null");
            return (Criteria) this;
        }

        public Criteria andLocktypeIsNotNull() {
            addCriterion("locktype is not null");
            return (Criteria) this;
        }

        public Criteria andLocktypeEqualTo(String value) {
            addCriterion("locktype =", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeNotEqualTo(String value) {
            addCriterion("locktype <>", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeGreaterThan(String value) {
            addCriterion("locktype >", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeGreaterThanOrEqualTo(String value) {
            addCriterion("locktype >=", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeLessThan(String value) {
            addCriterion("locktype <", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeLessThanOrEqualTo(String value) {
            addCriterion("locktype <=", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeLike(String value) {
            addCriterion("locktype like", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeNotLike(String value) {
            addCriterion("locktype not like", value, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeIn(List<String> values) {
            addCriterion("locktype in", values, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeNotIn(List<String> values) {
            addCriterion("locktype not in", values, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeBetween(String value1, String value2) {
            addCriterion("locktype between", value1, value2, "locktype");
            return (Criteria) this;
        }

        public Criteria andLocktypeNotBetween(String value1, String value2) {
            addCriterion("locktype not between", value1, value2, "locktype");
            return (Criteria) this;
        }

        public Criteria andDatabaseIsNull() {
            addCriterion("database is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseIsNotNull() {
            addCriterion("database is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseEqualTo(Long value) {
            addCriterion("database =", value, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseNotEqualTo(Long value) {
            addCriterion("database <>", value, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseGreaterThan(Long value) {
            addCriterion("database >", value, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseGreaterThanOrEqualTo(Long value) {
            addCriterion("database >=", value, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseLessThan(Long value) {
            addCriterion("database <", value, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseLessThanOrEqualTo(Long value) {
            addCriterion("database <=", value, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseIn(List<Long> values) {
            addCriterion("database in", values, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseNotIn(List<Long> values) {
            addCriterion("database not in", values, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseBetween(Long value1, Long value2) {
            addCriterion("database between", value1, value2, "database");
            return (Criteria) this;
        }

        public Criteria andDatabaseNotBetween(Long value1, Long value2) {
            addCriterion("database not between", value1, value2, "database");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(Long value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(Long value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(Long value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(Long value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(Long value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(Long value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<Long> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<Long> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(Long value1, Long value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(Long value1, Long value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(Integer value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(Integer value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(Integer value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(Integer value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(Integer value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(Integer value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<Integer> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<Integer> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(Integer value1, Integer value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(Integer value1, Integer value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andTupleIsNull() {
            addCriterion("tuple is null");
            return (Criteria) this;
        }

        public Criteria andTupleIsNotNull() {
            addCriterion("tuple is not null");
            return (Criteria) this;
        }

        public Criteria andTupleEqualTo(Short value) {
            addCriterion("tuple =", value, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleNotEqualTo(Short value) {
            addCriterion("tuple <>", value, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleGreaterThan(Short value) {
            addCriterion("tuple >", value, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleGreaterThanOrEqualTo(Short value) {
            addCriterion("tuple >=", value, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleLessThan(Short value) {
            addCriterion("tuple <", value, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleLessThanOrEqualTo(Short value) {
            addCriterion("tuple <=", value, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleIn(List<Short> values) {
            addCriterion("tuple in", values, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleNotIn(List<Short> values) {
            addCriterion("tuple not in", values, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleBetween(Short value1, Short value2) {
            addCriterion("tuple between", value1, value2, "tuple");
            return (Criteria) this;
        }

        public Criteria andTupleNotBetween(Short value1, Short value2) {
            addCriterion("tuple not between", value1, value2, "tuple");
            return (Criteria) this;
        }

        public Criteria andVirtualxidIsNull() {
            addCriterion("virtualxid is null");
            return (Criteria) this;
        }

        public Criteria andVirtualxidIsNotNull() {
            addCriterion("virtualxid is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualxidEqualTo(String value) {
            addCriterion("virtualxid =", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidNotEqualTo(String value) {
            addCriterion("virtualxid <>", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidGreaterThan(String value) {
            addCriterion("virtualxid >", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidGreaterThanOrEqualTo(String value) {
            addCriterion("virtualxid >=", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidLessThan(String value) {
            addCriterion("virtualxid <", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidLessThanOrEqualTo(String value) {
            addCriterion("virtualxid <=", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidLike(String value) {
            addCriterion("virtualxid like", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidNotLike(String value) {
            addCriterion("virtualxid not like", value, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidIn(List<String> values) {
            addCriterion("virtualxid in", values, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidNotIn(List<String> values) {
            addCriterion("virtualxid not in", values, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidBetween(String value1, String value2) {
            addCriterion("virtualxid between", value1, value2, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andVirtualxidNotBetween(String value1, String value2) {
            addCriterion("virtualxid not between", value1, value2, "virtualxid");
            return (Criteria) this;
        }

        public Criteria andTransactionidIsNull() {
            addCriterion("transactionid is null");
            return (Criteria) this;
        }

        public Criteria andTransactionidIsNotNull() {
            addCriterion("transactionid is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionidEqualTo(Object value) {
            addCriterion("transactionid =", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotEqualTo(Object value) {
            addCriterion("transactionid <>", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidGreaterThan(Object value) {
            addCriterion("transactionid >", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidGreaterThanOrEqualTo(Object value) {
            addCriterion("transactionid >=", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLessThan(Object value) {
            addCriterion("transactionid <", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLessThanOrEqualTo(Object value) {
            addCriterion("transactionid <=", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidIn(List<Object> values) {
            addCriterion("transactionid in", values, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotIn(List<Object> values) {
            addCriterion("transactionid not in", values, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidBetween(Object value1, Object value2) {
            addCriterion("transactionid between", value1, value2, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotBetween(Object value1, Object value2) {
            addCriterion("transactionid not between", value1, value2, "transactionid");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classid is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classid is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Long value) {
            addCriterion("classid =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Long value) {
            addCriterion("classid <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Long value) {
            addCriterion("classid >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Long value) {
            addCriterion("classid >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Long value) {
            addCriterion("classid <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Long value) {
            addCriterion("classid <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Long> values) {
            addCriterion("classid in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Long> values) {
            addCriterion("classid not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Long value1, Long value2) {
            addCriterion("classid between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Long value1, Long value2) {
            addCriterion("classid not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andObjidIsNull() {
            addCriterion("objid is null");
            return (Criteria) this;
        }

        public Criteria andObjidIsNotNull() {
            addCriterion("objid is not null");
            return (Criteria) this;
        }

        public Criteria andObjidEqualTo(Long value) {
            addCriterion("objid =", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotEqualTo(Long value) {
            addCriterion("objid <>", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThan(Long value) {
            addCriterion("objid >", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThanOrEqualTo(Long value) {
            addCriterion("objid >=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThan(Long value) {
            addCriterion("objid <", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThanOrEqualTo(Long value) {
            addCriterion("objid <=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidIn(List<Long> values) {
            addCriterion("objid in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotIn(List<Long> values) {
            addCriterion("objid not in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidBetween(Long value1, Long value2) {
            addCriterion("objid between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotBetween(Long value1, Long value2) {
            addCriterion("objid not between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjsubidIsNull() {
            addCriterion("objsubid is null");
            return (Criteria) this;
        }

        public Criteria andObjsubidIsNotNull() {
            addCriterion("objsubid is not null");
            return (Criteria) this;
        }

        public Criteria andObjsubidEqualTo(Short value) {
            addCriterion("objsubid =", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidNotEqualTo(Short value) {
            addCriterion("objsubid <>", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidGreaterThan(Short value) {
            addCriterion("objsubid >", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidGreaterThanOrEqualTo(Short value) {
            addCriterion("objsubid >=", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidLessThan(Short value) {
            addCriterion("objsubid <", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidLessThanOrEqualTo(Short value) {
            addCriterion("objsubid <=", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidIn(List<Short> values) {
            addCriterion("objsubid in", values, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidNotIn(List<Short> values) {
            addCriterion("objsubid not in", values, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidBetween(Short value1, Short value2) {
            addCriterion("objsubid between", value1, value2, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidNotBetween(Short value1, Short value2) {
            addCriterion("objsubid not between", value1, value2, "objsubid");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionIsNull() {
            addCriterion("virtualtransaction is null");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionIsNotNull() {
            addCriterion("virtualtransaction is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionEqualTo(String value) {
            addCriterion("virtualtransaction =", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionNotEqualTo(String value) {
            addCriterion("virtualtransaction <>", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionGreaterThan(String value) {
            addCriterion("virtualtransaction >", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionGreaterThanOrEqualTo(String value) {
            addCriterion("virtualtransaction >=", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionLessThan(String value) {
            addCriterion("virtualtransaction <", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionLessThanOrEqualTo(String value) {
            addCriterion("virtualtransaction <=", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionLike(String value) {
            addCriterion("virtualtransaction like", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionNotLike(String value) {
            addCriterion("virtualtransaction not like", value, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionIn(List<String> values) {
            addCriterion("virtualtransaction in", values, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionNotIn(List<String> values) {
            addCriterion("virtualtransaction not in", values, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionBetween(String value1, String value2) {
            addCriterion("virtualtransaction between", value1, value2, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andVirtualtransactionNotBetween(String value1, String value2) {
            addCriterion("virtualtransaction not between", value1, value2, "virtualtransaction");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(String value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(String value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(String value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(String value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(String value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(String value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLike(String value) {
            addCriterion("mode like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotLike(String value) {
            addCriterion("mode not like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<String> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<String> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(String value1, String value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(String value1, String value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andGrantedIsNull() {
            addCriterion("granted is null");
            return (Criteria) this;
        }

        public Criteria andGrantedIsNotNull() {
            addCriterion("granted is not null");
            return (Criteria) this;
        }

        public Criteria andGrantedEqualTo(Boolean value) {
            addCriterion("granted =", value, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedNotEqualTo(Boolean value) {
            addCriterion("granted <>", value, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedGreaterThan(Boolean value) {
            addCriterion("granted >", value, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("granted >=", value, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedLessThan(Boolean value) {
            addCriterion("granted <", value, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedLessThanOrEqualTo(Boolean value) {
            addCriterion("granted <=", value, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedIn(List<Boolean> values) {
            addCriterion("granted in", values, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedNotIn(List<Boolean> values) {
            addCriterion("granted not in", values, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedBetween(Boolean value1, Boolean value2) {
            addCriterion("granted between", value1, value2, "granted");
            return (Criteria) this;
        }

        public Criteria andGrantedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("granted not between", value1, value2, "granted");
            return (Criteria) this;
        }

        public Criteria andFastpathIsNull() {
            addCriterion("fastpath is null");
            return (Criteria) this;
        }

        public Criteria andFastpathIsNotNull() {
            addCriterion("fastpath is not null");
            return (Criteria) this;
        }

        public Criteria andFastpathEqualTo(Boolean value) {
            addCriterion("fastpath =", value, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathNotEqualTo(Boolean value) {
            addCriterion("fastpath <>", value, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathGreaterThan(Boolean value) {
            addCriterion("fastpath >", value, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fastpath >=", value, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathLessThan(Boolean value) {
            addCriterion("fastpath <", value, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathLessThanOrEqualTo(Boolean value) {
            addCriterion("fastpath <=", value, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathIn(List<Boolean> values) {
            addCriterion("fastpath in", values, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathNotIn(List<Boolean> values) {
            addCriterion("fastpath not in", values, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathBetween(Boolean value1, Boolean value2) {
            addCriterion("fastpath between", value1, value2, "fastpath");
            return (Criteria) this;
        }

        public Criteria andFastpathNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fastpath not between", value1, value2, "fastpath");
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