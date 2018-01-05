package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgClassExample() {
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

        public Criteria andRelnamespaceIsNull() {
            addCriterion("relnamespace is null");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceIsNotNull() {
            addCriterion("relnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceEqualTo(Long value) {
            addCriterion("relnamespace =", value, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceNotEqualTo(Long value) {
            addCriterion("relnamespace <>", value, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceGreaterThan(Long value) {
            addCriterion("relnamespace >", value, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("relnamespace >=", value, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceLessThan(Long value) {
            addCriterion("relnamespace <", value, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("relnamespace <=", value, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceIn(List<Long> values) {
            addCriterion("relnamespace in", values, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceNotIn(List<Long> values) {
            addCriterion("relnamespace not in", values, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceBetween(Long value1, Long value2) {
            addCriterion("relnamespace between", value1, value2, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andRelnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("relnamespace not between", value1, value2, "relnamespace");
            return (Criteria) this;
        }

        public Criteria andReltypeIsNull() {
            addCriterion("reltype is null");
            return (Criteria) this;
        }

        public Criteria andReltypeIsNotNull() {
            addCriterion("reltype is not null");
            return (Criteria) this;
        }

        public Criteria andReltypeEqualTo(Long value) {
            addCriterion("reltype =", value, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeNotEqualTo(Long value) {
            addCriterion("reltype <>", value, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeGreaterThan(Long value) {
            addCriterion("reltype >", value, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeGreaterThanOrEqualTo(Long value) {
            addCriterion("reltype >=", value, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeLessThan(Long value) {
            addCriterion("reltype <", value, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeLessThanOrEqualTo(Long value) {
            addCriterion("reltype <=", value, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeIn(List<Long> values) {
            addCriterion("reltype in", values, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeNotIn(List<Long> values) {
            addCriterion("reltype not in", values, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeBetween(Long value1, Long value2) {
            addCriterion("reltype between", value1, value2, "reltype");
            return (Criteria) this;
        }

        public Criteria andReltypeNotBetween(Long value1, Long value2) {
            addCriterion("reltype not between", value1, value2, "reltype");
            return (Criteria) this;
        }

        public Criteria andReloftypeIsNull() {
            addCriterion("reloftype is null");
            return (Criteria) this;
        }

        public Criteria andReloftypeIsNotNull() {
            addCriterion("reloftype is not null");
            return (Criteria) this;
        }

        public Criteria andReloftypeEqualTo(Long value) {
            addCriterion("reloftype =", value, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeNotEqualTo(Long value) {
            addCriterion("reloftype <>", value, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeGreaterThan(Long value) {
            addCriterion("reloftype >", value, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeGreaterThanOrEqualTo(Long value) {
            addCriterion("reloftype >=", value, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeLessThan(Long value) {
            addCriterion("reloftype <", value, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeLessThanOrEqualTo(Long value) {
            addCriterion("reloftype <=", value, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeIn(List<Long> values) {
            addCriterion("reloftype in", values, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeNotIn(List<Long> values) {
            addCriterion("reloftype not in", values, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeBetween(Long value1, Long value2) {
            addCriterion("reloftype between", value1, value2, "reloftype");
            return (Criteria) this;
        }

        public Criteria andReloftypeNotBetween(Long value1, Long value2) {
            addCriterion("reloftype not between", value1, value2, "reloftype");
            return (Criteria) this;
        }

        public Criteria andRelownerIsNull() {
            addCriterion("relowner is null");
            return (Criteria) this;
        }

        public Criteria andRelownerIsNotNull() {
            addCriterion("relowner is not null");
            return (Criteria) this;
        }

        public Criteria andRelownerEqualTo(Long value) {
            addCriterion("relowner =", value, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerNotEqualTo(Long value) {
            addCriterion("relowner <>", value, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerGreaterThan(Long value) {
            addCriterion("relowner >", value, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerGreaterThanOrEqualTo(Long value) {
            addCriterion("relowner >=", value, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerLessThan(Long value) {
            addCriterion("relowner <", value, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerLessThanOrEqualTo(Long value) {
            addCriterion("relowner <=", value, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerIn(List<Long> values) {
            addCriterion("relowner in", values, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerNotIn(List<Long> values) {
            addCriterion("relowner not in", values, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerBetween(Long value1, Long value2) {
            addCriterion("relowner between", value1, value2, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelownerNotBetween(Long value1, Long value2) {
            addCriterion("relowner not between", value1, value2, "relowner");
            return (Criteria) this;
        }

        public Criteria andRelamIsNull() {
            addCriterion("relam is null");
            return (Criteria) this;
        }

        public Criteria andRelamIsNotNull() {
            addCriterion("relam is not null");
            return (Criteria) this;
        }

        public Criteria andRelamEqualTo(Long value) {
            addCriterion("relam =", value, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamNotEqualTo(Long value) {
            addCriterion("relam <>", value, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamGreaterThan(Long value) {
            addCriterion("relam >", value, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamGreaterThanOrEqualTo(Long value) {
            addCriterion("relam >=", value, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamLessThan(Long value) {
            addCriterion("relam <", value, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamLessThanOrEqualTo(Long value) {
            addCriterion("relam <=", value, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamIn(List<Long> values) {
            addCriterion("relam in", values, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamNotIn(List<Long> values) {
            addCriterion("relam not in", values, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamBetween(Long value1, Long value2) {
            addCriterion("relam between", value1, value2, "relam");
            return (Criteria) this;
        }

        public Criteria andRelamNotBetween(Long value1, Long value2) {
            addCriterion("relam not between", value1, value2, "relam");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeIsNull() {
            addCriterion("relfilenode is null");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeIsNotNull() {
            addCriterion("relfilenode is not null");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeEqualTo(Long value) {
            addCriterion("relfilenode =", value, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeNotEqualTo(Long value) {
            addCriterion("relfilenode <>", value, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeGreaterThan(Long value) {
            addCriterion("relfilenode >", value, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeGreaterThanOrEqualTo(Long value) {
            addCriterion("relfilenode >=", value, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeLessThan(Long value) {
            addCriterion("relfilenode <", value, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeLessThanOrEqualTo(Long value) {
            addCriterion("relfilenode <=", value, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeIn(List<Long> values) {
            addCriterion("relfilenode in", values, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeNotIn(List<Long> values) {
            addCriterion("relfilenode not in", values, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeBetween(Long value1, Long value2) {
            addCriterion("relfilenode between", value1, value2, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andRelfilenodeNotBetween(Long value1, Long value2) {
            addCriterion("relfilenode not between", value1, value2, "relfilenode");
            return (Criteria) this;
        }

        public Criteria andReltablespaceIsNull() {
            addCriterion("reltablespace is null");
            return (Criteria) this;
        }

        public Criteria andReltablespaceIsNotNull() {
            addCriterion("reltablespace is not null");
            return (Criteria) this;
        }

        public Criteria andReltablespaceEqualTo(Long value) {
            addCriterion("reltablespace =", value, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceNotEqualTo(Long value) {
            addCriterion("reltablespace <>", value, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceGreaterThan(Long value) {
            addCriterion("reltablespace >", value, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("reltablespace >=", value, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceLessThan(Long value) {
            addCriterion("reltablespace <", value, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceLessThanOrEqualTo(Long value) {
            addCriterion("reltablespace <=", value, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceIn(List<Long> values) {
            addCriterion("reltablespace in", values, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceNotIn(List<Long> values) {
            addCriterion("reltablespace not in", values, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceBetween(Long value1, Long value2) {
            addCriterion("reltablespace between", value1, value2, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andReltablespaceNotBetween(Long value1, Long value2) {
            addCriterion("reltablespace not between", value1, value2, "reltablespace");
            return (Criteria) this;
        }

        public Criteria andRelpagesIsNull() {
            addCriterion("relpages is null");
            return (Criteria) this;
        }

        public Criteria andRelpagesIsNotNull() {
            addCriterion("relpages is not null");
            return (Criteria) this;
        }

        public Criteria andRelpagesEqualTo(Integer value) {
            addCriterion("relpages =", value, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesNotEqualTo(Integer value) {
            addCriterion("relpages <>", value, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesGreaterThan(Integer value) {
            addCriterion("relpages >", value, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("relpages >=", value, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesLessThan(Integer value) {
            addCriterion("relpages <", value, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesLessThanOrEqualTo(Integer value) {
            addCriterion("relpages <=", value, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesIn(List<Integer> values) {
            addCriterion("relpages in", values, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesNotIn(List<Integer> values) {
            addCriterion("relpages not in", values, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesBetween(Integer value1, Integer value2) {
            addCriterion("relpages between", value1, value2, "relpages");
            return (Criteria) this;
        }

        public Criteria andRelpagesNotBetween(Integer value1, Integer value2) {
            addCriterion("relpages not between", value1, value2, "relpages");
            return (Criteria) this;
        }

        public Criteria andReltuplesIsNull() {
            addCriterion("reltuples is null");
            return (Criteria) this;
        }

        public Criteria andReltuplesIsNotNull() {
            addCriterion("reltuples is not null");
            return (Criteria) this;
        }

        public Criteria andReltuplesEqualTo(Float value) {
            addCriterion("reltuples =", value, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesNotEqualTo(Float value) {
            addCriterion("reltuples <>", value, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesGreaterThan(Float value) {
            addCriterion("reltuples >", value, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesGreaterThanOrEqualTo(Float value) {
            addCriterion("reltuples >=", value, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesLessThan(Float value) {
            addCriterion("reltuples <", value, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesLessThanOrEqualTo(Float value) {
            addCriterion("reltuples <=", value, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesIn(List<Float> values) {
            addCriterion("reltuples in", values, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesNotIn(List<Float> values) {
            addCriterion("reltuples not in", values, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesBetween(Float value1, Float value2) {
            addCriterion("reltuples between", value1, value2, "reltuples");
            return (Criteria) this;
        }

        public Criteria andReltuplesNotBetween(Float value1, Float value2) {
            addCriterion("reltuples not between", value1, value2, "reltuples");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleIsNull() {
            addCriterion("relallvisible is null");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleIsNotNull() {
            addCriterion("relallvisible is not null");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleEqualTo(Integer value) {
            addCriterion("relallvisible =", value, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleNotEqualTo(Integer value) {
            addCriterion("relallvisible <>", value, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleGreaterThan(Integer value) {
            addCriterion("relallvisible >", value, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("relallvisible >=", value, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleLessThan(Integer value) {
            addCriterion("relallvisible <", value, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleLessThanOrEqualTo(Integer value) {
            addCriterion("relallvisible <=", value, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleIn(List<Integer> values) {
            addCriterion("relallvisible in", values, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleNotIn(List<Integer> values) {
            addCriterion("relallvisible not in", values, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleBetween(Integer value1, Integer value2) {
            addCriterion("relallvisible between", value1, value2, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andRelallvisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("relallvisible not between", value1, value2, "relallvisible");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidIsNull() {
            addCriterion("reltoastrelid is null");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidIsNotNull() {
            addCriterion("reltoastrelid is not null");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidEqualTo(Long value) {
            addCriterion("reltoastrelid =", value, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidNotEqualTo(Long value) {
            addCriterion("reltoastrelid <>", value, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidGreaterThan(Long value) {
            addCriterion("reltoastrelid >", value, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("reltoastrelid >=", value, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidLessThan(Long value) {
            addCriterion("reltoastrelid <", value, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidLessThanOrEqualTo(Long value) {
            addCriterion("reltoastrelid <=", value, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidIn(List<Long> values) {
            addCriterion("reltoastrelid in", values, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidNotIn(List<Long> values) {
            addCriterion("reltoastrelid not in", values, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidBetween(Long value1, Long value2) {
            addCriterion("reltoastrelid between", value1, value2, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastrelidNotBetween(Long value1, Long value2) {
            addCriterion("reltoastrelid not between", value1, value2, "reltoastrelid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidIsNull() {
            addCriterion("reltoastidxid is null");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidIsNotNull() {
            addCriterion("reltoastidxid is not null");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidEqualTo(Long value) {
            addCriterion("reltoastidxid =", value, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidNotEqualTo(Long value) {
            addCriterion("reltoastidxid <>", value, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidGreaterThan(Long value) {
            addCriterion("reltoastidxid >", value, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidGreaterThanOrEqualTo(Long value) {
            addCriterion("reltoastidxid >=", value, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidLessThan(Long value) {
            addCriterion("reltoastidxid <", value, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidLessThanOrEqualTo(Long value) {
            addCriterion("reltoastidxid <=", value, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidIn(List<Long> values) {
            addCriterion("reltoastidxid in", values, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidNotIn(List<Long> values) {
            addCriterion("reltoastidxid not in", values, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidBetween(Long value1, Long value2) {
            addCriterion("reltoastidxid between", value1, value2, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andReltoastidxidNotBetween(Long value1, Long value2) {
            addCriterion("reltoastidxid not between", value1, value2, "reltoastidxid");
            return (Criteria) this;
        }

        public Criteria andRelhasindexIsNull() {
            addCriterion("relhasindex is null");
            return (Criteria) this;
        }

        public Criteria andRelhasindexIsNotNull() {
            addCriterion("relhasindex is not null");
            return (Criteria) this;
        }

        public Criteria andRelhasindexEqualTo(Boolean value) {
            addCriterion("relhasindex =", value, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexNotEqualTo(Boolean value) {
            addCriterion("relhasindex <>", value, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexGreaterThan(Boolean value) {
            addCriterion("relhasindex >", value, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relhasindex >=", value, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexLessThan(Boolean value) {
            addCriterion("relhasindex <", value, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexLessThanOrEqualTo(Boolean value) {
            addCriterion("relhasindex <=", value, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexIn(List<Boolean> values) {
            addCriterion("relhasindex in", values, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexNotIn(List<Boolean> values) {
            addCriterion("relhasindex not in", values, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexBetween(Boolean value1, Boolean value2) {
            addCriterion("relhasindex between", value1, value2, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelhasindexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relhasindex not between", value1, value2, "relhasindex");
            return (Criteria) this;
        }

        public Criteria andRelissharedIsNull() {
            addCriterion("relisshared is null");
            return (Criteria) this;
        }

        public Criteria andRelissharedIsNotNull() {
            addCriterion("relisshared is not null");
            return (Criteria) this;
        }

        public Criteria andRelissharedEqualTo(Boolean value) {
            addCriterion("relisshared =", value, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedNotEqualTo(Boolean value) {
            addCriterion("relisshared <>", value, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedGreaterThan(Boolean value) {
            addCriterion("relisshared >", value, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relisshared >=", value, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedLessThan(Boolean value) {
            addCriterion("relisshared <", value, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedLessThanOrEqualTo(Boolean value) {
            addCriterion("relisshared <=", value, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedIn(List<Boolean> values) {
            addCriterion("relisshared in", values, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedNotIn(List<Boolean> values) {
            addCriterion("relisshared not in", values, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedBetween(Boolean value1, Boolean value2) {
            addCriterion("relisshared between", value1, value2, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelissharedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relisshared not between", value1, value2, "relisshared");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceIsNull() {
            addCriterion("relpersistence is null");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceIsNotNull() {
            addCriterion("relpersistence is not null");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceEqualTo(String value) {
            addCriterion("relpersistence =", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceNotEqualTo(String value) {
            addCriterion("relpersistence <>", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceGreaterThan(String value) {
            addCriterion("relpersistence >", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceGreaterThanOrEqualTo(String value) {
            addCriterion("relpersistence >=", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceLessThan(String value) {
            addCriterion("relpersistence <", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceLessThanOrEqualTo(String value) {
            addCriterion("relpersistence <=", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceLike(String value) {
            addCriterion("relpersistence like", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceNotLike(String value) {
            addCriterion("relpersistence not like", value, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceIn(List<String> values) {
            addCriterion("relpersistence in", values, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceNotIn(List<String> values) {
            addCriterion("relpersistence not in", values, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceBetween(String value1, String value2) {
            addCriterion("relpersistence between", value1, value2, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelpersistenceNotBetween(String value1, String value2) {
            addCriterion("relpersistence not between", value1, value2, "relpersistence");
            return (Criteria) this;
        }

        public Criteria andRelkindIsNull() {
            addCriterion("relkind is null");
            return (Criteria) this;
        }

        public Criteria andRelkindIsNotNull() {
            addCriterion("relkind is not null");
            return (Criteria) this;
        }

        public Criteria andRelkindEqualTo(String value) {
            addCriterion("relkind =", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindNotEqualTo(String value) {
            addCriterion("relkind <>", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindGreaterThan(String value) {
            addCriterion("relkind >", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindGreaterThanOrEqualTo(String value) {
            addCriterion("relkind >=", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindLessThan(String value) {
            addCriterion("relkind <", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindLessThanOrEqualTo(String value) {
            addCriterion("relkind <=", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindLike(String value) {
            addCriterion("relkind like", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindNotLike(String value) {
            addCriterion("relkind not like", value, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindIn(List<String> values) {
            addCriterion("relkind in", values, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindNotIn(List<String> values) {
            addCriterion("relkind not in", values, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindBetween(String value1, String value2) {
            addCriterion("relkind between", value1, value2, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelkindNotBetween(String value1, String value2) {
            addCriterion("relkind not between", value1, value2, "relkind");
            return (Criteria) this;
        }

        public Criteria andRelnattsIsNull() {
            addCriterion("relnatts is null");
            return (Criteria) this;
        }

        public Criteria andRelnattsIsNotNull() {
            addCriterion("relnatts is not null");
            return (Criteria) this;
        }

        public Criteria andRelnattsEqualTo(Short value) {
            addCriterion("relnatts =", value, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsNotEqualTo(Short value) {
            addCriterion("relnatts <>", value, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsGreaterThan(Short value) {
            addCriterion("relnatts >", value, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsGreaterThanOrEqualTo(Short value) {
            addCriterion("relnatts >=", value, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsLessThan(Short value) {
            addCriterion("relnatts <", value, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsLessThanOrEqualTo(Short value) {
            addCriterion("relnatts <=", value, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsIn(List<Short> values) {
            addCriterion("relnatts in", values, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsNotIn(List<Short> values) {
            addCriterion("relnatts not in", values, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsBetween(Short value1, Short value2) {
            addCriterion("relnatts between", value1, value2, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelnattsNotBetween(Short value1, Short value2) {
            addCriterion("relnatts not between", value1, value2, "relnatts");
            return (Criteria) this;
        }

        public Criteria andRelchecksIsNull() {
            addCriterion("relchecks is null");
            return (Criteria) this;
        }

        public Criteria andRelchecksIsNotNull() {
            addCriterion("relchecks is not null");
            return (Criteria) this;
        }

        public Criteria andRelchecksEqualTo(Short value) {
            addCriterion("relchecks =", value, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksNotEqualTo(Short value) {
            addCriterion("relchecks <>", value, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksGreaterThan(Short value) {
            addCriterion("relchecks >", value, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksGreaterThanOrEqualTo(Short value) {
            addCriterion("relchecks >=", value, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksLessThan(Short value) {
            addCriterion("relchecks <", value, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksLessThanOrEqualTo(Short value) {
            addCriterion("relchecks <=", value, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksIn(List<Short> values) {
            addCriterion("relchecks in", values, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksNotIn(List<Short> values) {
            addCriterion("relchecks not in", values, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksBetween(Short value1, Short value2) {
            addCriterion("relchecks between", value1, value2, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelchecksNotBetween(Short value1, Short value2) {
            addCriterion("relchecks not between", value1, value2, "relchecks");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsIsNull() {
            addCriterion("relhasoids is null");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsIsNotNull() {
            addCriterion("relhasoids is not null");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsEqualTo(Boolean value) {
            addCriterion("relhasoids =", value, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsNotEqualTo(Boolean value) {
            addCriterion("relhasoids <>", value, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsGreaterThan(Boolean value) {
            addCriterion("relhasoids >", value, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relhasoids >=", value, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsLessThan(Boolean value) {
            addCriterion("relhasoids <", value, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsLessThanOrEqualTo(Boolean value) {
            addCriterion("relhasoids <=", value, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsIn(List<Boolean> values) {
            addCriterion("relhasoids in", values, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsNotIn(List<Boolean> values) {
            addCriterion("relhasoids not in", values, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsBetween(Boolean value1, Boolean value2) {
            addCriterion("relhasoids between", value1, value2, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhasoidsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relhasoids not between", value1, value2, "relhasoids");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyIsNull() {
            addCriterion("relhaspkey is null");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyIsNotNull() {
            addCriterion("relhaspkey is not null");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyEqualTo(Boolean value) {
            addCriterion("relhaspkey =", value, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyNotEqualTo(Boolean value) {
            addCriterion("relhaspkey <>", value, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyGreaterThan(Boolean value) {
            addCriterion("relhaspkey >", value, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relhaspkey >=", value, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyLessThan(Boolean value) {
            addCriterion("relhaspkey <", value, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyLessThanOrEqualTo(Boolean value) {
            addCriterion("relhaspkey <=", value, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyIn(List<Boolean> values) {
            addCriterion("relhaspkey in", values, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyNotIn(List<Boolean> values) {
            addCriterion("relhaspkey not in", values, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyBetween(Boolean value1, Boolean value2) {
            addCriterion("relhaspkey between", value1, value2, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhaspkeyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relhaspkey not between", value1, value2, "relhaspkey");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesIsNull() {
            addCriterion("relhasrules is null");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesIsNotNull() {
            addCriterion("relhasrules is not null");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesEqualTo(Boolean value) {
            addCriterion("relhasrules =", value, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesNotEqualTo(Boolean value) {
            addCriterion("relhasrules <>", value, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesGreaterThan(Boolean value) {
            addCriterion("relhasrules >", value, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relhasrules >=", value, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesLessThan(Boolean value) {
            addCriterion("relhasrules <", value, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesLessThanOrEqualTo(Boolean value) {
            addCriterion("relhasrules <=", value, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesIn(List<Boolean> values) {
            addCriterion("relhasrules in", values, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesNotIn(List<Boolean> values) {
            addCriterion("relhasrules not in", values, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesBetween(Boolean value1, Boolean value2) {
            addCriterion("relhasrules between", value1, value2, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhasrulesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relhasrules not between", value1, value2, "relhasrules");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersIsNull() {
            addCriterion("relhastriggers is null");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersIsNotNull() {
            addCriterion("relhastriggers is not null");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersEqualTo(Boolean value) {
            addCriterion("relhastriggers =", value, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersNotEqualTo(Boolean value) {
            addCriterion("relhastriggers <>", value, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersGreaterThan(Boolean value) {
            addCriterion("relhastriggers >", value, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relhastriggers >=", value, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersLessThan(Boolean value) {
            addCriterion("relhastriggers <", value, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersLessThanOrEqualTo(Boolean value) {
            addCriterion("relhastriggers <=", value, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersIn(List<Boolean> values) {
            addCriterion("relhastriggers in", values, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersNotIn(List<Boolean> values) {
            addCriterion("relhastriggers not in", values, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersBetween(Boolean value1, Boolean value2) {
            addCriterion("relhastriggers between", value1, value2, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhastriggersNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relhastriggers not between", value1, value2, "relhastriggers");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassIsNull() {
            addCriterion("relhassubclass is null");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassIsNotNull() {
            addCriterion("relhassubclass is not null");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassEqualTo(Boolean value) {
            addCriterion("relhassubclass =", value, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassNotEqualTo(Boolean value) {
            addCriterion("relhassubclass <>", value, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassGreaterThan(Boolean value) {
            addCriterion("relhassubclass >", value, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relhassubclass >=", value, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassLessThan(Boolean value) {
            addCriterion("relhassubclass <", value, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassLessThanOrEqualTo(Boolean value) {
            addCriterion("relhassubclass <=", value, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassIn(List<Boolean> values) {
            addCriterion("relhassubclass in", values, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassNotIn(List<Boolean> values) {
            addCriterion("relhassubclass not in", values, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassBetween(Boolean value1, Boolean value2) {
            addCriterion("relhassubclass between", value1, value2, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelhassubclassNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relhassubclass not between", value1, value2, "relhassubclass");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidIsNull() {
            addCriterion("relfrozenxid is null");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidIsNotNull() {
            addCriterion("relfrozenxid is not null");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidEqualTo(Object value) {
            addCriterion("relfrozenxid =", value, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidNotEqualTo(Object value) {
            addCriterion("relfrozenxid <>", value, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidGreaterThan(Object value) {
            addCriterion("relfrozenxid >", value, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidGreaterThanOrEqualTo(Object value) {
            addCriterion("relfrozenxid >=", value, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidLessThan(Object value) {
            addCriterion("relfrozenxid <", value, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidLessThanOrEqualTo(Object value) {
            addCriterion("relfrozenxid <=", value, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidIn(List<Object> values) {
            addCriterion("relfrozenxid in", values, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidNotIn(List<Object> values) {
            addCriterion("relfrozenxid not in", values, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidBetween(Object value1, Object value2) {
            addCriterion("relfrozenxid between", value1, value2, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelfrozenxidNotBetween(Object value1, Object value2) {
            addCriterion("relfrozenxid not between", value1, value2, "relfrozenxid");
            return (Criteria) this;
        }

        public Criteria andRelaclIsNull() {
            addCriterion("relacl is null");
            return (Criteria) this;
        }

        public Criteria andRelaclIsNotNull() {
            addCriterion("relacl is not null");
            return (Criteria) this;
        }

        public Criteria andRelaclEqualTo(Object value) {
            addCriterion("relacl =", value, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclNotEqualTo(Object value) {
            addCriterion("relacl <>", value, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclGreaterThan(Object value) {
            addCriterion("relacl >", value, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclGreaterThanOrEqualTo(Object value) {
            addCriterion("relacl >=", value, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclLessThan(Object value) {
            addCriterion("relacl <", value, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclLessThanOrEqualTo(Object value) {
            addCriterion("relacl <=", value, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclIn(List<Object> values) {
            addCriterion("relacl in", values, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclNotIn(List<Object> values) {
            addCriterion("relacl not in", values, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclBetween(Object value1, Object value2) {
            addCriterion("relacl between", value1, value2, "relacl");
            return (Criteria) this;
        }

        public Criteria andRelaclNotBetween(Object value1, Object value2) {
            addCriterion("relacl not between", value1, value2, "relacl");
            return (Criteria) this;
        }

        public Criteria andReloptionsIsNull() {
            addCriterion("reloptions is null");
            return (Criteria) this;
        }

        public Criteria andReloptionsIsNotNull() {
            addCriterion("reloptions is not null");
            return (Criteria) this;
        }

        public Criteria andReloptionsEqualTo(Object value) {
            addCriterion("reloptions =", value, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsNotEqualTo(Object value) {
            addCriterion("reloptions <>", value, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsGreaterThan(Object value) {
            addCriterion("reloptions >", value, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("reloptions >=", value, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsLessThan(Object value) {
            addCriterion("reloptions <", value, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsLessThanOrEqualTo(Object value) {
            addCriterion("reloptions <=", value, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsIn(List<Object> values) {
            addCriterion("reloptions in", values, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsNotIn(List<Object> values) {
            addCriterion("reloptions not in", values, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsBetween(Object value1, Object value2) {
            addCriterion("reloptions between", value1, value2, "reloptions");
            return (Criteria) this;
        }

        public Criteria andReloptionsNotBetween(Object value1, Object value2) {
            addCriterion("reloptions not between", value1, value2, "reloptions");
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