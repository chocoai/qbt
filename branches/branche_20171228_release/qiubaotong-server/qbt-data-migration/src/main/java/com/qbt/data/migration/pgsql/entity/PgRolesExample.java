package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgRolesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgRolesExample() {
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

        public Criteria andRolnameIsNull() {
            addCriterion("rolname is null");
            return (Criteria) this;
        }

        public Criteria andRolnameIsNotNull() {
            addCriterion("rolname is not null");
            return (Criteria) this;
        }

        public Criteria andRolnameEqualTo(String value) {
            addCriterion("rolname =", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameNotEqualTo(String value) {
            addCriterion("rolname <>", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameGreaterThan(String value) {
            addCriterion("rolname >", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameGreaterThanOrEqualTo(String value) {
            addCriterion("rolname >=", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameLessThan(String value) {
            addCriterion("rolname <", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameLessThanOrEqualTo(String value) {
            addCriterion("rolname <=", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameLike(String value) {
            addCriterion("rolname like", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameNotLike(String value) {
            addCriterion("rolname not like", value, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameIn(List<String> values) {
            addCriterion("rolname in", values, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameNotIn(List<String> values) {
            addCriterion("rolname not in", values, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameBetween(String value1, String value2) {
            addCriterion("rolname between", value1, value2, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolnameNotBetween(String value1, String value2) {
            addCriterion("rolname not between", value1, value2, "rolname");
            return (Criteria) this;
        }

        public Criteria andRolsuperIsNull() {
            addCriterion("rolsuper is null");
            return (Criteria) this;
        }

        public Criteria andRolsuperIsNotNull() {
            addCriterion("rolsuper is not null");
            return (Criteria) this;
        }

        public Criteria andRolsuperEqualTo(Boolean value) {
            addCriterion("rolsuper =", value, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperNotEqualTo(Boolean value) {
            addCriterion("rolsuper <>", value, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperGreaterThan(Boolean value) {
            addCriterion("rolsuper >", value, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolsuper >=", value, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperLessThan(Boolean value) {
            addCriterion("rolsuper <", value, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperLessThanOrEqualTo(Boolean value) {
            addCriterion("rolsuper <=", value, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperIn(List<Boolean> values) {
            addCriterion("rolsuper in", values, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperNotIn(List<Boolean> values) {
            addCriterion("rolsuper not in", values, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperBetween(Boolean value1, Boolean value2) {
            addCriterion("rolsuper between", value1, value2, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolsuperNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolsuper not between", value1, value2, "rolsuper");
            return (Criteria) this;
        }

        public Criteria andRolinheritIsNull() {
            addCriterion("rolinherit is null");
            return (Criteria) this;
        }

        public Criteria andRolinheritIsNotNull() {
            addCriterion("rolinherit is not null");
            return (Criteria) this;
        }

        public Criteria andRolinheritEqualTo(Boolean value) {
            addCriterion("rolinherit =", value, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritNotEqualTo(Boolean value) {
            addCriterion("rolinherit <>", value, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritGreaterThan(Boolean value) {
            addCriterion("rolinherit >", value, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolinherit >=", value, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritLessThan(Boolean value) {
            addCriterion("rolinherit <", value, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritLessThanOrEqualTo(Boolean value) {
            addCriterion("rolinherit <=", value, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritIn(List<Boolean> values) {
            addCriterion("rolinherit in", values, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritNotIn(List<Boolean> values) {
            addCriterion("rolinherit not in", values, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritBetween(Boolean value1, Boolean value2) {
            addCriterion("rolinherit between", value1, value2, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolinheritNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolinherit not between", value1, value2, "rolinherit");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleIsNull() {
            addCriterion("rolcreaterole is null");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleIsNotNull() {
            addCriterion("rolcreaterole is not null");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleEqualTo(Boolean value) {
            addCriterion("rolcreaterole =", value, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleNotEqualTo(Boolean value) {
            addCriterion("rolcreaterole <>", value, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleGreaterThan(Boolean value) {
            addCriterion("rolcreaterole >", value, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolcreaterole >=", value, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleLessThan(Boolean value) {
            addCriterion("rolcreaterole <", value, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleLessThanOrEqualTo(Boolean value) {
            addCriterion("rolcreaterole <=", value, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleIn(List<Boolean> values) {
            addCriterion("rolcreaterole in", values, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleNotIn(List<Boolean> values) {
            addCriterion("rolcreaterole not in", values, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcreaterole between", value1, value2, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreateroleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcreaterole not between", value1, value2, "rolcreaterole");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbIsNull() {
            addCriterion("rolcreatedb is null");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbIsNotNull() {
            addCriterion("rolcreatedb is not null");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbEqualTo(Boolean value) {
            addCriterion("rolcreatedb =", value, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbNotEqualTo(Boolean value) {
            addCriterion("rolcreatedb <>", value, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbGreaterThan(Boolean value) {
            addCriterion("rolcreatedb >", value, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolcreatedb >=", value, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbLessThan(Boolean value) {
            addCriterion("rolcreatedb <", value, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbLessThanOrEqualTo(Boolean value) {
            addCriterion("rolcreatedb <=", value, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbIn(List<Boolean> values) {
            addCriterion("rolcreatedb in", values, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbNotIn(List<Boolean> values) {
            addCriterion("rolcreatedb not in", values, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcreatedb between", value1, value2, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcreatedbNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcreatedb not between", value1, value2, "rolcreatedb");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateIsNull() {
            addCriterion("rolcatupdate is null");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateIsNotNull() {
            addCriterion("rolcatupdate is not null");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateEqualTo(Boolean value) {
            addCriterion("rolcatupdate =", value, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateNotEqualTo(Boolean value) {
            addCriterion("rolcatupdate <>", value, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateGreaterThan(Boolean value) {
            addCriterion("rolcatupdate >", value, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolcatupdate >=", value, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateLessThan(Boolean value) {
            addCriterion("rolcatupdate <", value, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateLessThanOrEqualTo(Boolean value) {
            addCriterion("rolcatupdate <=", value, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateIn(List<Boolean> values) {
            addCriterion("rolcatupdate in", values, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateNotIn(List<Boolean> values) {
            addCriterion("rolcatupdate not in", values, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcatupdate between", value1, value2, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcatupdateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcatupdate not between", value1, value2, "rolcatupdate");
            return (Criteria) this;
        }

        public Criteria andRolcanloginIsNull() {
            addCriterion("rolcanlogin is null");
            return (Criteria) this;
        }

        public Criteria andRolcanloginIsNotNull() {
            addCriterion("rolcanlogin is not null");
            return (Criteria) this;
        }

        public Criteria andRolcanloginEqualTo(Boolean value) {
            addCriterion("rolcanlogin =", value, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginNotEqualTo(Boolean value) {
            addCriterion("rolcanlogin <>", value, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginGreaterThan(Boolean value) {
            addCriterion("rolcanlogin >", value, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolcanlogin >=", value, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginLessThan(Boolean value) {
            addCriterion("rolcanlogin <", value, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginLessThanOrEqualTo(Boolean value) {
            addCriterion("rolcanlogin <=", value, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginIn(List<Boolean> values) {
            addCriterion("rolcanlogin in", values, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginNotIn(List<Boolean> values) {
            addCriterion("rolcanlogin not in", values, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcanlogin between", value1, value2, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolcanloginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolcanlogin not between", value1, value2, "rolcanlogin");
            return (Criteria) this;
        }

        public Criteria andRolreplicationIsNull() {
            addCriterion("rolreplication is null");
            return (Criteria) this;
        }

        public Criteria andRolreplicationIsNotNull() {
            addCriterion("rolreplication is not null");
            return (Criteria) this;
        }

        public Criteria andRolreplicationEqualTo(Boolean value) {
            addCriterion("rolreplication =", value, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationNotEqualTo(Boolean value) {
            addCriterion("rolreplication <>", value, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationGreaterThan(Boolean value) {
            addCriterion("rolreplication >", value, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rolreplication >=", value, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationLessThan(Boolean value) {
            addCriterion("rolreplication <", value, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationLessThanOrEqualTo(Boolean value) {
            addCriterion("rolreplication <=", value, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationIn(List<Boolean> values) {
            addCriterion("rolreplication in", values, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationNotIn(List<Boolean> values) {
            addCriterion("rolreplication not in", values, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationBetween(Boolean value1, Boolean value2) {
            addCriterion("rolreplication between", value1, value2, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolreplicationNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rolreplication not between", value1, value2, "rolreplication");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitIsNull() {
            addCriterion("rolconnlimit is null");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitIsNotNull() {
            addCriterion("rolconnlimit is not null");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitEqualTo(Integer value) {
            addCriterion("rolconnlimit =", value, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitNotEqualTo(Integer value) {
            addCriterion("rolconnlimit <>", value, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitGreaterThan(Integer value) {
            addCriterion("rolconnlimit >", value, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("rolconnlimit >=", value, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitLessThan(Integer value) {
            addCriterion("rolconnlimit <", value, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitLessThanOrEqualTo(Integer value) {
            addCriterion("rolconnlimit <=", value, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitIn(List<Integer> values) {
            addCriterion("rolconnlimit in", values, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitNotIn(List<Integer> values) {
            addCriterion("rolconnlimit not in", values, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitBetween(Integer value1, Integer value2) {
            addCriterion("rolconnlimit between", value1, value2, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolconnlimitNotBetween(Integer value1, Integer value2) {
            addCriterion("rolconnlimit not between", value1, value2, "rolconnlimit");
            return (Criteria) this;
        }

        public Criteria andRolpasswordIsNull() {
            addCriterion("rolpassword is null");
            return (Criteria) this;
        }

        public Criteria andRolpasswordIsNotNull() {
            addCriterion("rolpassword is not null");
            return (Criteria) this;
        }

        public Criteria andRolpasswordEqualTo(String value) {
            addCriterion("rolpassword =", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordNotEqualTo(String value) {
            addCriterion("rolpassword <>", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordGreaterThan(String value) {
            addCriterion("rolpassword >", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("rolpassword >=", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordLessThan(String value) {
            addCriterion("rolpassword <", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordLessThanOrEqualTo(String value) {
            addCriterion("rolpassword <=", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordLike(String value) {
            addCriterion("rolpassword like", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordNotLike(String value) {
            addCriterion("rolpassword not like", value, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordIn(List<String> values) {
            addCriterion("rolpassword in", values, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordNotIn(List<String> values) {
            addCriterion("rolpassword not in", values, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordBetween(String value1, String value2) {
            addCriterion("rolpassword between", value1, value2, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolpasswordNotBetween(String value1, String value2) {
            addCriterion("rolpassword not between", value1, value2, "rolpassword");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilIsNull() {
            addCriterion("rolvaliduntil is null");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilIsNotNull() {
            addCriterion("rolvaliduntil is not null");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilEqualTo(Date value) {
            addCriterion("rolvaliduntil =", value, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilNotEqualTo(Date value) {
            addCriterion("rolvaliduntil <>", value, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilGreaterThan(Date value) {
            addCriterion("rolvaliduntil >", value, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilGreaterThanOrEqualTo(Date value) {
            addCriterion("rolvaliduntil >=", value, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilLessThan(Date value) {
            addCriterion("rolvaliduntil <", value, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilLessThanOrEqualTo(Date value) {
            addCriterion("rolvaliduntil <=", value, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilIn(List<Date> values) {
            addCriterion("rolvaliduntil in", values, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilNotIn(List<Date> values) {
            addCriterion("rolvaliduntil not in", values, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilBetween(Date value1, Date value2) {
            addCriterion("rolvaliduntil between", value1, value2, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolvaliduntilNotBetween(Date value1, Date value2) {
            addCriterion("rolvaliduntil not between", value1, value2, "rolvaliduntil");
            return (Criteria) this;
        }

        public Criteria andRolconfigIsNull() {
            addCriterion("rolconfig is null");
            return (Criteria) this;
        }

        public Criteria andRolconfigIsNotNull() {
            addCriterion("rolconfig is not null");
            return (Criteria) this;
        }

        public Criteria andRolconfigEqualTo(Object value) {
            addCriterion("rolconfig =", value, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigNotEqualTo(Object value) {
            addCriterion("rolconfig <>", value, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigGreaterThan(Object value) {
            addCriterion("rolconfig >", value, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigGreaterThanOrEqualTo(Object value) {
            addCriterion("rolconfig >=", value, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigLessThan(Object value) {
            addCriterion("rolconfig <", value, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigLessThanOrEqualTo(Object value) {
            addCriterion("rolconfig <=", value, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigIn(List<Object> values) {
            addCriterion("rolconfig in", values, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigNotIn(List<Object> values) {
            addCriterion("rolconfig not in", values, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigBetween(Object value1, Object value2) {
            addCriterion("rolconfig between", value1, value2, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andRolconfigNotBetween(Object value1, Object value2) {
            addCriterion("rolconfig not between", value1, value2, "rolconfig");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
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