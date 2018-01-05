package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgOperatorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgOperatorExample() {
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

        public Criteria andOprnameIsNull() {
            addCriterion("oprname is null");
            return (Criteria) this;
        }

        public Criteria andOprnameIsNotNull() {
            addCriterion("oprname is not null");
            return (Criteria) this;
        }

        public Criteria andOprnameEqualTo(String value) {
            addCriterion("oprname =", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameNotEqualTo(String value) {
            addCriterion("oprname <>", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameGreaterThan(String value) {
            addCriterion("oprname >", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameGreaterThanOrEqualTo(String value) {
            addCriterion("oprname >=", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameLessThan(String value) {
            addCriterion("oprname <", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameLessThanOrEqualTo(String value) {
            addCriterion("oprname <=", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameLike(String value) {
            addCriterion("oprname like", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameNotLike(String value) {
            addCriterion("oprname not like", value, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameIn(List<String> values) {
            addCriterion("oprname in", values, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameNotIn(List<String> values) {
            addCriterion("oprname not in", values, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameBetween(String value1, String value2) {
            addCriterion("oprname between", value1, value2, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnameNotBetween(String value1, String value2) {
            addCriterion("oprname not between", value1, value2, "oprname");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceIsNull() {
            addCriterion("oprnamespace is null");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceIsNotNull() {
            addCriterion("oprnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceEqualTo(Long value) {
            addCriterion("oprnamespace =", value, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceNotEqualTo(Long value) {
            addCriterion("oprnamespace <>", value, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceGreaterThan(Long value) {
            addCriterion("oprnamespace >", value, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("oprnamespace >=", value, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceLessThan(Long value) {
            addCriterion("oprnamespace <", value, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("oprnamespace <=", value, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceIn(List<Long> values) {
            addCriterion("oprnamespace in", values, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceNotIn(List<Long> values) {
            addCriterion("oprnamespace not in", values, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceBetween(Long value1, Long value2) {
            addCriterion("oprnamespace between", value1, value2, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("oprnamespace not between", value1, value2, "oprnamespace");
            return (Criteria) this;
        }

        public Criteria andOprownerIsNull() {
            addCriterion("oprowner is null");
            return (Criteria) this;
        }

        public Criteria andOprownerIsNotNull() {
            addCriterion("oprowner is not null");
            return (Criteria) this;
        }

        public Criteria andOprownerEqualTo(Long value) {
            addCriterion("oprowner =", value, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerNotEqualTo(Long value) {
            addCriterion("oprowner <>", value, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerGreaterThan(Long value) {
            addCriterion("oprowner >", value, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerGreaterThanOrEqualTo(Long value) {
            addCriterion("oprowner >=", value, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerLessThan(Long value) {
            addCriterion("oprowner <", value, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerLessThanOrEqualTo(Long value) {
            addCriterion("oprowner <=", value, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerIn(List<Long> values) {
            addCriterion("oprowner in", values, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerNotIn(List<Long> values) {
            addCriterion("oprowner not in", values, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerBetween(Long value1, Long value2) {
            addCriterion("oprowner between", value1, value2, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprownerNotBetween(Long value1, Long value2) {
            addCriterion("oprowner not between", value1, value2, "oprowner");
            return (Criteria) this;
        }

        public Criteria andOprkindIsNull() {
            addCriterion("oprkind is null");
            return (Criteria) this;
        }

        public Criteria andOprkindIsNotNull() {
            addCriterion("oprkind is not null");
            return (Criteria) this;
        }

        public Criteria andOprkindEqualTo(String value) {
            addCriterion("oprkind =", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindNotEqualTo(String value) {
            addCriterion("oprkind <>", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindGreaterThan(String value) {
            addCriterion("oprkind >", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindGreaterThanOrEqualTo(String value) {
            addCriterion("oprkind >=", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindLessThan(String value) {
            addCriterion("oprkind <", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindLessThanOrEqualTo(String value) {
            addCriterion("oprkind <=", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindLike(String value) {
            addCriterion("oprkind like", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindNotLike(String value) {
            addCriterion("oprkind not like", value, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindIn(List<String> values) {
            addCriterion("oprkind in", values, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindNotIn(List<String> values) {
            addCriterion("oprkind not in", values, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindBetween(String value1, String value2) {
            addCriterion("oprkind between", value1, value2, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprkindNotBetween(String value1, String value2) {
            addCriterion("oprkind not between", value1, value2, "oprkind");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeIsNull() {
            addCriterion("oprcanmerge is null");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeIsNotNull() {
            addCriterion("oprcanmerge is not null");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeEqualTo(Boolean value) {
            addCriterion("oprcanmerge =", value, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeNotEqualTo(Boolean value) {
            addCriterion("oprcanmerge <>", value, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeGreaterThan(Boolean value) {
            addCriterion("oprcanmerge >", value, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("oprcanmerge >=", value, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeLessThan(Boolean value) {
            addCriterion("oprcanmerge <", value, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeLessThanOrEqualTo(Boolean value) {
            addCriterion("oprcanmerge <=", value, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeIn(List<Boolean> values) {
            addCriterion("oprcanmerge in", values, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeNotIn(List<Boolean> values) {
            addCriterion("oprcanmerge not in", values, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeBetween(Boolean value1, Boolean value2) {
            addCriterion("oprcanmerge between", value1, value2, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanmergeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("oprcanmerge not between", value1, value2, "oprcanmerge");
            return (Criteria) this;
        }

        public Criteria andOprcanhashIsNull() {
            addCriterion("oprcanhash is null");
            return (Criteria) this;
        }

        public Criteria andOprcanhashIsNotNull() {
            addCriterion("oprcanhash is not null");
            return (Criteria) this;
        }

        public Criteria andOprcanhashEqualTo(Boolean value) {
            addCriterion("oprcanhash =", value, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashNotEqualTo(Boolean value) {
            addCriterion("oprcanhash <>", value, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashGreaterThan(Boolean value) {
            addCriterion("oprcanhash >", value, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashGreaterThanOrEqualTo(Boolean value) {
            addCriterion("oprcanhash >=", value, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashLessThan(Boolean value) {
            addCriterion("oprcanhash <", value, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashLessThanOrEqualTo(Boolean value) {
            addCriterion("oprcanhash <=", value, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashIn(List<Boolean> values) {
            addCriterion("oprcanhash in", values, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashNotIn(List<Boolean> values) {
            addCriterion("oprcanhash not in", values, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashBetween(Boolean value1, Boolean value2) {
            addCriterion("oprcanhash between", value1, value2, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprcanhashNotBetween(Boolean value1, Boolean value2) {
            addCriterion("oprcanhash not between", value1, value2, "oprcanhash");
            return (Criteria) this;
        }

        public Criteria andOprleftIsNull() {
            addCriterion("oprleft is null");
            return (Criteria) this;
        }

        public Criteria andOprleftIsNotNull() {
            addCriterion("oprleft is not null");
            return (Criteria) this;
        }

        public Criteria andOprleftEqualTo(Long value) {
            addCriterion("oprleft =", value, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftNotEqualTo(Long value) {
            addCriterion("oprleft <>", value, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftGreaterThan(Long value) {
            addCriterion("oprleft >", value, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftGreaterThanOrEqualTo(Long value) {
            addCriterion("oprleft >=", value, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftLessThan(Long value) {
            addCriterion("oprleft <", value, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftLessThanOrEqualTo(Long value) {
            addCriterion("oprleft <=", value, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftIn(List<Long> values) {
            addCriterion("oprleft in", values, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftNotIn(List<Long> values) {
            addCriterion("oprleft not in", values, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftBetween(Long value1, Long value2) {
            addCriterion("oprleft between", value1, value2, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprleftNotBetween(Long value1, Long value2) {
            addCriterion("oprleft not between", value1, value2, "oprleft");
            return (Criteria) this;
        }

        public Criteria andOprrightIsNull() {
            addCriterion("oprright is null");
            return (Criteria) this;
        }

        public Criteria andOprrightIsNotNull() {
            addCriterion("oprright is not null");
            return (Criteria) this;
        }

        public Criteria andOprrightEqualTo(Long value) {
            addCriterion("oprright =", value, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightNotEqualTo(Long value) {
            addCriterion("oprright <>", value, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightGreaterThan(Long value) {
            addCriterion("oprright >", value, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightGreaterThanOrEqualTo(Long value) {
            addCriterion("oprright >=", value, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightLessThan(Long value) {
            addCriterion("oprright <", value, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightLessThanOrEqualTo(Long value) {
            addCriterion("oprright <=", value, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightIn(List<Long> values) {
            addCriterion("oprright in", values, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightNotIn(List<Long> values) {
            addCriterion("oprright not in", values, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightBetween(Long value1, Long value2) {
            addCriterion("oprright between", value1, value2, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprrightNotBetween(Long value1, Long value2) {
            addCriterion("oprright not between", value1, value2, "oprright");
            return (Criteria) this;
        }

        public Criteria andOprresultIsNull() {
            addCriterion("oprresult is null");
            return (Criteria) this;
        }

        public Criteria andOprresultIsNotNull() {
            addCriterion("oprresult is not null");
            return (Criteria) this;
        }

        public Criteria andOprresultEqualTo(Long value) {
            addCriterion("oprresult =", value, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultNotEqualTo(Long value) {
            addCriterion("oprresult <>", value, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultGreaterThan(Long value) {
            addCriterion("oprresult >", value, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultGreaterThanOrEqualTo(Long value) {
            addCriterion("oprresult >=", value, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultLessThan(Long value) {
            addCriterion("oprresult <", value, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultLessThanOrEqualTo(Long value) {
            addCriterion("oprresult <=", value, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultIn(List<Long> values) {
            addCriterion("oprresult in", values, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultNotIn(List<Long> values) {
            addCriterion("oprresult not in", values, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultBetween(Long value1, Long value2) {
            addCriterion("oprresult between", value1, value2, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprresultNotBetween(Long value1, Long value2) {
            addCriterion("oprresult not between", value1, value2, "oprresult");
            return (Criteria) this;
        }

        public Criteria andOprcomIsNull() {
            addCriterion("oprcom is null");
            return (Criteria) this;
        }

        public Criteria andOprcomIsNotNull() {
            addCriterion("oprcom is not null");
            return (Criteria) this;
        }

        public Criteria andOprcomEqualTo(Long value) {
            addCriterion("oprcom =", value, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomNotEqualTo(Long value) {
            addCriterion("oprcom <>", value, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomGreaterThan(Long value) {
            addCriterion("oprcom >", value, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomGreaterThanOrEqualTo(Long value) {
            addCriterion("oprcom >=", value, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomLessThan(Long value) {
            addCriterion("oprcom <", value, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomLessThanOrEqualTo(Long value) {
            addCriterion("oprcom <=", value, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomIn(List<Long> values) {
            addCriterion("oprcom in", values, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomNotIn(List<Long> values) {
            addCriterion("oprcom not in", values, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomBetween(Long value1, Long value2) {
            addCriterion("oprcom between", value1, value2, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprcomNotBetween(Long value1, Long value2) {
            addCriterion("oprcom not between", value1, value2, "oprcom");
            return (Criteria) this;
        }

        public Criteria andOprnegateIsNull() {
            addCriterion("oprnegate is null");
            return (Criteria) this;
        }

        public Criteria andOprnegateIsNotNull() {
            addCriterion("oprnegate is not null");
            return (Criteria) this;
        }

        public Criteria andOprnegateEqualTo(Long value) {
            addCriterion("oprnegate =", value, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateNotEqualTo(Long value) {
            addCriterion("oprnegate <>", value, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateGreaterThan(Long value) {
            addCriterion("oprnegate >", value, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateGreaterThanOrEqualTo(Long value) {
            addCriterion("oprnegate >=", value, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateLessThan(Long value) {
            addCriterion("oprnegate <", value, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateLessThanOrEqualTo(Long value) {
            addCriterion("oprnegate <=", value, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateIn(List<Long> values) {
            addCriterion("oprnegate in", values, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateNotIn(List<Long> values) {
            addCriterion("oprnegate not in", values, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateBetween(Long value1, Long value2) {
            addCriterion("oprnegate between", value1, value2, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprnegateNotBetween(Long value1, Long value2) {
            addCriterion("oprnegate not between", value1, value2, "oprnegate");
            return (Criteria) this;
        }

        public Criteria andOprcodeIsNull() {
            addCriterion("oprcode is null");
            return (Criteria) this;
        }

        public Criteria andOprcodeIsNotNull() {
            addCriterion("oprcode is not null");
            return (Criteria) this;
        }

        public Criteria andOprcodeEqualTo(Object value) {
            addCriterion("oprcode =", value, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeNotEqualTo(Object value) {
            addCriterion("oprcode <>", value, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeGreaterThan(Object value) {
            addCriterion("oprcode >", value, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeGreaterThanOrEqualTo(Object value) {
            addCriterion("oprcode >=", value, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeLessThan(Object value) {
            addCriterion("oprcode <", value, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeLessThanOrEqualTo(Object value) {
            addCriterion("oprcode <=", value, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeIn(List<Object> values) {
            addCriterion("oprcode in", values, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeNotIn(List<Object> values) {
            addCriterion("oprcode not in", values, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeBetween(Object value1, Object value2) {
            addCriterion("oprcode between", value1, value2, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprcodeNotBetween(Object value1, Object value2) {
            addCriterion("oprcode not between", value1, value2, "oprcode");
            return (Criteria) this;
        }

        public Criteria andOprrestIsNull() {
            addCriterion("oprrest is null");
            return (Criteria) this;
        }

        public Criteria andOprrestIsNotNull() {
            addCriterion("oprrest is not null");
            return (Criteria) this;
        }

        public Criteria andOprrestEqualTo(Object value) {
            addCriterion("oprrest =", value, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestNotEqualTo(Object value) {
            addCriterion("oprrest <>", value, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestGreaterThan(Object value) {
            addCriterion("oprrest >", value, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestGreaterThanOrEqualTo(Object value) {
            addCriterion("oprrest >=", value, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestLessThan(Object value) {
            addCriterion("oprrest <", value, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestLessThanOrEqualTo(Object value) {
            addCriterion("oprrest <=", value, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestIn(List<Object> values) {
            addCriterion("oprrest in", values, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestNotIn(List<Object> values) {
            addCriterion("oprrest not in", values, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestBetween(Object value1, Object value2) {
            addCriterion("oprrest between", value1, value2, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprrestNotBetween(Object value1, Object value2) {
            addCriterion("oprrest not between", value1, value2, "oprrest");
            return (Criteria) this;
        }

        public Criteria andOprjoinIsNull() {
            addCriterion("oprjoin is null");
            return (Criteria) this;
        }

        public Criteria andOprjoinIsNotNull() {
            addCriterion("oprjoin is not null");
            return (Criteria) this;
        }

        public Criteria andOprjoinEqualTo(Object value) {
            addCriterion("oprjoin =", value, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinNotEqualTo(Object value) {
            addCriterion("oprjoin <>", value, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinGreaterThan(Object value) {
            addCriterion("oprjoin >", value, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinGreaterThanOrEqualTo(Object value) {
            addCriterion("oprjoin >=", value, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinLessThan(Object value) {
            addCriterion("oprjoin <", value, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinLessThanOrEqualTo(Object value) {
            addCriterion("oprjoin <=", value, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinIn(List<Object> values) {
            addCriterion("oprjoin in", values, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinNotIn(List<Object> values) {
            addCriterion("oprjoin not in", values, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinBetween(Object value1, Object value2) {
            addCriterion("oprjoin between", value1, value2, "oprjoin");
            return (Criteria) this;
        }

        public Criteria andOprjoinNotBetween(Object value1, Object value2) {
            addCriterion("oprjoin not between", value1, value2, "oprjoin");
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