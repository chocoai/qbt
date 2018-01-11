package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgStatActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatActivityExample() {
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

        public Criteria andUsesysidIsNull() {
            addCriterion("usesysid is null");
            return (Criteria) this;
        }

        public Criteria andUsesysidIsNotNull() {
            addCriterion("usesysid is not null");
            return (Criteria) this;
        }

        public Criteria andUsesysidEqualTo(Long value) {
            addCriterion("usesysid =", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidNotEqualTo(Long value) {
            addCriterion("usesysid <>", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidGreaterThan(Long value) {
            addCriterion("usesysid >", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidGreaterThanOrEqualTo(Long value) {
            addCriterion("usesysid >=", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidLessThan(Long value) {
            addCriterion("usesysid <", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidLessThanOrEqualTo(Long value) {
            addCriterion("usesysid <=", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidIn(List<Long> values) {
            addCriterion("usesysid in", values, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidNotIn(List<Long> values) {
            addCriterion("usesysid not in", values, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidBetween(Long value1, Long value2) {
            addCriterion("usesysid between", value1, value2, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidNotBetween(Long value1, Long value2) {
            addCriterion("usesysid not between", value1, value2, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsenameIsNull() {
            addCriterion("usename is null");
            return (Criteria) this;
        }

        public Criteria andUsenameIsNotNull() {
            addCriterion("usename is not null");
            return (Criteria) this;
        }

        public Criteria andUsenameEqualTo(String value) {
            addCriterion("usename =", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotEqualTo(String value) {
            addCriterion("usename <>", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameGreaterThan(String value) {
            addCriterion("usename >", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameGreaterThanOrEqualTo(String value) {
            addCriterion("usename >=", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameLessThan(String value) {
            addCriterion("usename <", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameLessThanOrEqualTo(String value) {
            addCriterion("usename <=", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameLike(String value) {
            addCriterion("usename like", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotLike(String value) {
            addCriterion("usename not like", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameIn(List<String> values) {
            addCriterion("usename in", values, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotIn(List<String> values) {
            addCriterion("usename not in", values, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameBetween(String value1, String value2) {
            addCriterion("usename between", value1, value2, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotBetween(String value1, String value2) {
            addCriterion("usename not between", value1, value2, "usename");
            return (Criteria) this;
        }

        public Criteria andApplication_nameIsNull() {
            addCriterion("application_name is null");
            return (Criteria) this;
        }

        public Criteria andApplication_nameIsNotNull() {
            addCriterion("application_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplication_nameEqualTo(String value) {
            addCriterion("application_name =", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameNotEqualTo(String value) {
            addCriterion("application_name <>", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameGreaterThan(String value) {
            addCriterion("application_name >", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameGreaterThanOrEqualTo(String value) {
            addCriterion("application_name >=", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameLessThan(String value) {
            addCriterion("application_name <", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameLessThanOrEqualTo(String value) {
            addCriterion("application_name <=", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameLike(String value) {
            addCriterion("application_name like", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameNotLike(String value) {
            addCriterion("application_name not like", value, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameIn(List<String> values) {
            addCriterion("application_name in", values, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameNotIn(List<String> values) {
            addCriterion("application_name not in", values, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameBetween(String value1, String value2) {
            addCriterion("application_name between", value1, value2, "application_name");
            return (Criteria) this;
        }

        public Criteria andApplication_nameNotBetween(String value1, String value2) {
            addCriterion("application_name not between", value1, value2, "application_name");
            return (Criteria) this;
        }

        public Criteria andClient_addrIsNull() {
            addCriterion("client_addr is null");
            return (Criteria) this;
        }

        public Criteria andClient_addrIsNotNull() {
            addCriterion("client_addr is not null");
            return (Criteria) this;
        }

        public Criteria andClient_addrEqualTo(Object value) {
            addCriterion("client_addr =", value, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrNotEqualTo(Object value) {
            addCriterion("client_addr <>", value, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrGreaterThan(Object value) {
            addCriterion("client_addr >", value, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrGreaterThanOrEqualTo(Object value) {
            addCriterion("client_addr >=", value, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrLessThan(Object value) {
            addCriterion("client_addr <", value, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrLessThanOrEqualTo(Object value) {
            addCriterion("client_addr <=", value, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrIn(List<Object> values) {
            addCriterion("client_addr in", values, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrNotIn(List<Object> values) {
            addCriterion("client_addr not in", values, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrBetween(Object value1, Object value2) {
            addCriterion("client_addr between", value1, value2, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_addrNotBetween(Object value1, Object value2) {
            addCriterion("client_addr not between", value1, value2, "client_addr");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameIsNull() {
            addCriterion("client_hostname is null");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameIsNotNull() {
            addCriterion("client_hostname is not null");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameEqualTo(String value) {
            addCriterion("client_hostname =", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameNotEqualTo(String value) {
            addCriterion("client_hostname <>", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameGreaterThan(String value) {
            addCriterion("client_hostname >", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameGreaterThanOrEqualTo(String value) {
            addCriterion("client_hostname >=", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameLessThan(String value) {
            addCriterion("client_hostname <", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameLessThanOrEqualTo(String value) {
            addCriterion("client_hostname <=", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameLike(String value) {
            addCriterion("client_hostname like", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameNotLike(String value) {
            addCriterion("client_hostname not like", value, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameIn(List<String> values) {
            addCriterion("client_hostname in", values, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameNotIn(List<String> values) {
            addCriterion("client_hostname not in", values, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameBetween(String value1, String value2) {
            addCriterion("client_hostname between", value1, value2, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_hostnameNotBetween(String value1, String value2) {
            addCriterion("client_hostname not between", value1, value2, "client_hostname");
            return (Criteria) this;
        }

        public Criteria andClient_portIsNull() {
            addCriterion("client_port is null");
            return (Criteria) this;
        }

        public Criteria andClient_portIsNotNull() {
            addCriterion("client_port is not null");
            return (Criteria) this;
        }

        public Criteria andClient_portEqualTo(Integer value) {
            addCriterion("client_port =", value, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portNotEqualTo(Integer value) {
            addCriterion("client_port <>", value, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portGreaterThan(Integer value) {
            addCriterion("client_port >", value, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_port >=", value, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portLessThan(Integer value) {
            addCriterion("client_port <", value, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portLessThanOrEqualTo(Integer value) {
            addCriterion("client_port <=", value, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portIn(List<Integer> values) {
            addCriterion("client_port in", values, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portNotIn(List<Integer> values) {
            addCriterion("client_port not in", values, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portBetween(Integer value1, Integer value2) {
            addCriterion("client_port between", value1, value2, "client_port");
            return (Criteria) this;
        }

        public Criteria andClient_portNotBetween(Integer value1, Integer value2) {
            addCriterion("client_port not between", value1, value2, "client_port");
            return (Criteria) this;
        }

        public Criteria andBackend_startIsNull() {
            addCriterion("backend_start is null");
            return (Criteria) this;
        }

        public Criteria andBackend_startIsNotNull() {
            addCriterion("backend_start is not null");
            return (Criteria) this;
        }

        public Criteria andBackend_startEqualTo(Date value) {
            addCriterion("backend_start =", value, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startNotEqualTo(Date value) {
            addCriterion("backend_start <>", value, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startGreaterThan(Date value) {
            addCriterion("backend_start >", value, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startGreaterThanOrEqualTo(Date value) {
            addCriterion("backend_start >=", value, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startLessThan(Date value) {
            addCriterion("backend_start <", value, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startLessThanOrEqualTo(Date value) {
            addCriterion("backend_start <=", value, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startIn(List<Date> values) {
            addCriterion("backend_start in", values, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startNotIn(List<Date> values) {
            addCriterion("backend_start not in", values, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startBetween(Date value1, Date value2) {
            addCriterion("backend_start between", value1, value2, "backend_start");
            return (Criteria) this;
        }

        public Criteria andBackend_startNotBetween(Date value1, Date value2) {
            addCriterion("backend_start not between", value1, value2, "backend_start");
            return (Criteria) this;
        }

        public Criteria andXact_startIsNull() {
            addCriterion("xact_start is null");
            return (Criteria) this;
        }

        public Criteria andXact_startIsNotNull() {
            addCriterion("xact_start is not null");
            return (Criteria) this;
        }

        public Criteria andXact_startEqualTo(Date value) {
            addCriterion("xact_start =", value, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startNotEqualTo(Date value) {
            addCriterion("xact_start <>", value, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startGreaterThan(Date value) {
            addCriterion("xact_start >", value, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startGreaterThanOrEqualTo(Date value) {
            addCriterion("xact_start >=", value, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startLessThan(Date value) {
            addCriterion("xact_start <", value, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startLessThanOrEqualTo(Date value) {
            addCriterion("xact_start <=", value, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startIn(List<Date> values) {
            addCriterion("xact_start in", values, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startNotIn(List<Date> values) {
            addCriterion("xact_start not in", values, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startBetween(Date value1, Date value2) {
            addCriterion("xact_start between", value1, value2, "xact_start");
            return (Criteria) this;
        }

        public Criteria andXact_startNotBetween(Date value1, Date value2) {
            addCriterion("xact_start not between", value1, value2, "xact_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startIsNull() {
            addCriterion("query_start is null");
            return (Criteria) this;
        }

        public Criteria andQuery_startIsNotNull() {
            addCriterion("query_start is not null");
            return (Criteria) this;
        }

        public Criteria andQuery_startEqualTo(Date value) {
            addCriterion("query_start =", value, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startNotEqualTo(Date value) {
            addCriterion("query_start <>", value, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startGreaterThan(Date value) {
            addCriterion("query_start >", value, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startGreaterThanOrEqualTo(Date value) {
            addCriterion("query_start >=", value, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startLessThan(Date value) {
            addCriterion("query_start <", value, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startLessThanOrEqualTo(Date value) {
            addCriterion("query_start <=", value, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startIn(List<Date> values) {
            addCriterion("query_start in", values, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startNotIn(List<Date> values) {
            addCriterion("query_start not in", values, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startBetween(Date value1, Date value2) {
            addCriterion("query_start between", value1, value2, "query_start");
            return (Criteria) this;
        }

        public Criteria andQuery_startNotBetween(Date value1, Date value2) {
            addCriterion("query_start not between", value1, value2, "query_start");
            return (Criteria) this;
        }

        public Criteria andState_changeIsNull() {
            addCriterion("state_change is null");
            return (Criteria) this;
        }

        public Criteria andState_changeIsNotNull() {
            addCriterion("state_change is not null");
            return (Criteria) this;
        }

        public Criteria andState_changeEqualTo(Date value) {
            addCriterion("state_change =", value, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeNotEqualTo(Date value) {
            addCriterion("state_change <>", value, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeGreaterThan(Date value) {
            addCriterion("state_change >", value, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeGreaterThanOrEqualTo(Date value) {
            addCriterion("state_change >=", value, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeLessThan(Date value) {
            addCriterion("state_change <", value, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeLessThanOrEqualTo(Date value) {
            addCriterion("state_change <=", value, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeIn(List<Date> values) {
            addCriterion("state_change in", values, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeNotIn(List<Date> values) {
            addCriterion("state_change not in", values, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeBetween(Date value1, Date value2) {
            addCriterion("state_change between", value1, value2, "state_change");
            return (Criteria) this;
        }

        public Criteria andState_changeNotBetween(Date value1, Date value2) {
            addCriterion("state_change not between", value1, value2, "state_change");
            return (Criteria) this;
        }

        public Criteria andWaitingIsNull() {
            addCriterion("waiting is null");
            return (Criteria) this;
        }

        public Criteria andWaitingIsNotNull() {
            addCriterion("waiting is not null");
            return (Criteria) this;
        }

        public Criteria andWaitingEqualTo(Boolean value) {
            addCriterion("waiting =", value, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingNotEqualTo(Boolean value) {
            addCriterion("waiting <>", value, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingGreaterThan(Boolean value) {
            addCriterion("waiting >", value, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("waiting >=", value, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingLessThan(Boolean value) {
            addCriterion("waiting <", value, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingLessThanOrEqualTo(Boolean value) {
            addCriterion("waiting <=", value, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingIn(List<Boolean> values) {
            addCriterion("waiting in", values, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingNotIn(List<Boolean> values) {
            addCriterion("waiting not in", values, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingBetween(Boolean value1, Boolean value2) {
            addCriterion("waiting between", value1, value2, "waiting");
            return (Criteria) this;
        }

        public Criteria andWaitingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("waiting not between", value1, value2, "waiting");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andQueryIsNull() {
            addCriterion("query is null");
            return (Criteria) this;
        }

        public Criteria andQueryIsNotNull() {
            addCriterion("query is not null");
            return (Criteria) this;
        }

        public Criteria andQueryEqualTo(String value) {
            addCriterion("query =", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryNotEqualTo(String value) {
            addCriterion("query <>", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryGreaterThan(String value) {
            addCriterion("query >", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryGreaterThanOrEqualTo(String value) {
            addCriterion("query >=", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryLessThan(String value) {
            addCriterion("query <", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryLessThanOrEqualTo(String value) {
            addCriterion("query <=", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryLike(String value) {
            addCriterion("query like", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryNotLike(String value) {
            addCriterion("query not like", value, "query");
            return (Criteria) this;
        }

        public Criteria andQueryIn(List<String> values) {
            addCriterion("query in", values, "query");
            return (Criteria) this;
        }

        public Criteria andQueryNotIn(List<String> values) {
            addCriterion("query not in", values, "query");
            return (Criteria) this;
        }

        public Criteria andQueryBetween(String value1, String value2) {
            addCriterion("query between", value1, value2, "query");
            return (Criteria) this;
        }

        public Criteria andQueryNotBetween(String value1, String value2) {
            addCriterion("query not between", value1, value2, "query");
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