package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgStatReplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatReplicationExample() {
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

        public Criteria andSent_locationIsNull() {
            addCriterion("sent_location is null");
            return (Criteria) this;
        }

        public Criteria andSent_locationIsNotNull() {
            addCriterion("sent_location is not null");
            return (Criteria) this;
        }

        public Criteria andSent_locationEqualTo(String value) {
            addCriterion("sent_location =", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationNotEqualTo(String value) {
            addCriterion("sent_location <>", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationGreaterThan(String value) {
            addCriterion("sent_location >", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationGreaterThanOrEqualTo(String value) {
            addCriterion("sent_location >=", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationLessThan(String value) {
            addCriterion("sent_location <", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationLessThanOrEqualTo(String value) {
            addCriterion("sent_location <=", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationLike(String value) {
            addCriterion("sent_location like", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationNotLike(String value) {
            addCriterion("sent_location not like", value, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationIn(List<String> values) {
            addCriterion("sent_location in", values, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationNotIn(List<String> values) {
            addCriterion("sent_location not in", values, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationBetween(String value1, String value2) {
            addCriterion("sent_location between", value1, value2, "sent_location");
            return (Criteria) this;
        }

        public Criteria andSent_locationNotBetween(String value1, String value2) {
            addCriterion("sent_location not between", value1, value2, "sent_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationIsNull() {
            addCriterion("write_location is null");
            return (Criteria) this;
        }

        public Criteria andWrite_locationIsNotNull() {
            addCriterion("write_location is not null");
            return (Criteria) this;
        }

        public Criteria andWrite_locationEqualTo(String value) {
            addCriterion("write_location =", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationNotEqualTo(String value) {
            addCriterion("write_location <>", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationGreaterThan(String value) {
            addCriterion("write_location >", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationGreaterThanOrEqualTo(String value) {
            addCriterion("write_location >=", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationLessThan(String value) {
            addCriterion("write_location <", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationLessThanOrEqualTo(String value) {
            addCriterion("write_location <=", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationLike(String value) {
            addCriterion("write_location like", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationNotLike(String value) {
            addCriterion("write_location not like", value, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationIn(List<String> values) {
            addCriterion("write_location in", values, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationNotIn(List<String> values) {
            addCriterion("write_location not in", values, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationBetween(String value1, String value2) {
            addCriterion("write_location between", value1, value2, "write_location");
            return (Criteria) this;
        }

        public Criteria andWrite_locationNotBetween(String value1, String value2) {
            addCriterion("write_location not between", value1, value2, "write_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationIsNull() {
            addCriterion("flush_location is null");
            return (Criteria) this;
        }

        public Criteria andFlush_locationIsNotNull() {
            addCriterion("flush_location is not null");
            return (Criteria) this;
        }

        public Criteria andFlush_locationEqualTo(String value) {
            addCriterion("flush_location =", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationNotEqualTo(String value) {
            addCriterion("flush_location <>", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationGreaterThan(String value) {
            addCriterion("flush_location >", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationGreaterThanOrEqualTo(String value) {
            addCriterion("flush_location >=", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationLessThan(String value) {
            addCriterion("flush_location <", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationLessThanOrEqualTo(String value) {
            addCriterion("flush_location <=", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationLike(String value) {
            addCriterion("flush_location like", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationNotLike(String value) {
            addCriterion("flush_location not like", value, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationIn(List<String> values) {
            addCriterion("flush_location in", values, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationNotIn(List<String> values) {
            addCriterion("flush_location not in", values, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationBetween(String value1, String value2) {
            addCriterion("flush_location between", value1, value2, "flush_location");
            return (Criteria) this;
        }

        public Criteria andFlush_locationNotBetween(String value1, String value2) {
            addCriterion("flush_location not between", value1, value2, "flush_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationIsNull() {
            addCriterion("replay_location is null");
            return (Criteria) this;
        }

        public Criteria andReplay_locationIsNotNull() {
            addCriterion("replay_location is not null");
            return (Criteria) this;
        }

        public Criteria andReplay_locationEqualTo(String value) {
            addCriterion("replay_location =", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationNotEqualTo(String value) {
            addCriterion("replay_location <>", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationGreaterThan(String value) {
            addCriterion("replay_location >", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationGreaterThanOrEqualTo(String value) {
            addCriterion("replay_location >=", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationLessThan(String value) {
            addCriterion("replay_location <", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationLessThanOrEqualTo(String value) {
            addCriterion("replay_location <=", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationLike(String value) {
            addCriterion("replay_location like", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationNotLike(String value) {
            addCriterion("replay_location not like", value, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationIn(List<String> values) {
            addCriterion("replay_location in", values, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationNotIn(List<String> values) {
            addCriterion("replay_location not in", values, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationBetween(String value1, String value2) {
            addCriterion("replay_location between", value1, value2, "replay_location");
            return (Criteria) this;
        }

        public Criteria andReplay_locationNotBetween(String value1, String value2) {
            addCriterion("replay_location not between", value1, value2, "replay_location");
            return (Criteria) this;
        }

        public Criteria andSync_priorityIsNull() {
            addCriterion("sync_priority is null");
            return (Criteria) this;
        }

        public Criteria andSync_priorityIsNotNull() {
            addCriterion("sync_priority is not null");
            return (Criteria) this;
        }

        public Criteria andSync_priorityEqualTo(Integer value) {
            addCriterion("sync_priority =", value, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityNotEqualTo(Integer value) {
            addCriterion("sync_priority <>", value, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityGreaterThan(Integer value) {
            addCriterion("sync_priority >", value, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sync_priority >=", value, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityLessThan(Integer value) {
            addCriterion("sync_priority <", value, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityLessThanOrEqualTo(Integer value) {
            addCriterion("sync_priority <=", value, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityIn(List<Integer> values) {
            addCriterion("sync_priority in", values, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityNotIn(List<Integer> values) {
            addCriterion("sync_priority not in", values, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityBetween(Integer value1, Integer value2) {
            addCriterion("sync_priority between", value1, value2, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_priorityNotBetween(Integer value1, Integer value2) {
            addCriterion("sync_priority not between", value1, value2, "sync_priority");
            return (Criteria) this;
        }

        public Criteria andSync_stateIsNull() {
            addCriterion("sync_state is null");
            return (Criteria) this;
        }

        public Criteria andSync_stateIsNotNull() {
            addCriterion("sync_state is not null");
            return (Criteria) this;
        }

        public Criteria andSync_stateEqualTo(String value) {
            addCriterion("sync_state =", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateNotEqualTo(String value) {
            addCriterion("sync_state <>", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateGreaterThan(String value) {
            addCriterion("sync_state >", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateGreaterThanOrEqualTo(String value) {
            addCriterion("sync_state >=", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateLessThan(String value) {
            addCriterion("sync_state <", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateLessThanOrEqualTo(String value) {
            addCriterion("sync_state <=", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateLike(String value) {
            addCriterion("sync_state like", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateNotLike(String value) {
            addCriterion("sync_state not like", value, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateIn(List<String> values) {
            addCriterion("sync_state in", values, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateNotIn(List<String> values) {
            addCriterion("sync_state not in", values, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateBetween(String value1, String value2) {
            addCriterion("sync_state between", value1, value2, "sync_state");
            return (Criteria) this;
        }

        public Criteria andSync_stateNotBetween(String value1, String value2) {
            addCriterion("sync_state not between", value1, value2, "sync_state");
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