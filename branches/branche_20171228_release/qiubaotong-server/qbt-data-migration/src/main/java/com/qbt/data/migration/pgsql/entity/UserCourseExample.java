package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCourseExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Short value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Short value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Short value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Short value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Short value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Short value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Short> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Short> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Short value1, Short value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Short value1, Short value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andVerify_codeIsNull() {
            addCriterion("verify_code is null");
            return (Criteria) this;
        }

        public Criteria andVerify_codeIsNotNull() {
            addCriterion("verify_code is not null");
            return (Criteria) this;
        }

        public Criteria andVerify_codeEqualTo(String value) {
            addCriterion("verify_code =", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeNotEqualTo(String value) {
            addCriterion("verify_code <>", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeGreaterThan(String value) {
            addCriterion("verify_code >", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeGreaterThanOrEqualTo(String value) {
            addCriterion("verify_code >=", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeLessThan(String value) {
            addCriterion("verify_code <", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeLessThanOrEqualTo(String value) {
            addCriterion("verify_code <=", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeLike(String value) {
            addCriterion("verify_code like", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeNotLike(String value) {
            addCriterion("verify_code not like", value, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeIn(List<String> values) {
            addCriterion("verify_code in", values, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeNotIn(List<String> values) {
            addCriterion("verify_code not in", values, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeBetween(String value1, String value2) {
            addCriterion("verify_code between", value1, value2, "verify_code");
            return (Criteria) this;
        }

        public Criteria andVerify_codeNotBetween(String value1, String value2) {
            addCriterion("verify_code not between", value1, value2, "verify_code");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_atEqualTo(Date value) {
            addCriterion("created_at =", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThan(Date value) {
            addCriterion("created_at >", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThan(Date value) {
            addCriterion("created_at <", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atIn(List<Date> values) {
            addCriterion("created_at in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andAccept_pushIsNull() {
            addCriterion("accept_push is null");
            return (Criteria) this;
        }

        public Criteria andAccept_pushIsNotNull() {
            addCriterion("accept_push is not null");
            return (Criteria) this;
        }

        public Criteria andAccept_pushEqualTo(Boolean value) {
            addCriterion("accept_push =", value, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushNotEqualTo(Boolean value) {
            addCriterion("accept_push <>", value, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushGreaterThan(Boolean value) {
            addCriterion("accept_push >", value, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushGreaterThanOrEqualTo(Boolean value) {
            addCriterion("accept_push >=", value, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushLessThan(Boolean value) {
            addCriterion("accept_push <", value, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushLessThanOrEqualTo(Boolean value) {
            addCriterion("accept_push <=", value, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushIn(List<Boolean> values) {
            addCriterion("accept_push in", values, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushNotIn(List<Boolean> values) {
            addCriterion("accept_push not in", values, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushBetween(Boolean value1, Boolean value2) {
            addCriterion("accept_push between", value1, value2, "accept_push");
            return (Criteria) this;
        }

        public Criteria andAccept_pushNotBetween(Boolean value1, Boolean value2) {
            addCriterion("accept_push not between", value1, value2, "accept_push");
            return (Criteria) this;
        }

        public Criteria andIs_validatedIsNull() {
            addCriterion("is_validated is null");
            return (Criteria) this;
        }

        public Criteria andIs_validatedIsNotNull() {
            addCriterion("is_validated is not null");
            return (Criteria) this;
        }

        public Criteria andIs_validatedEqualTo(Boolean value) {
            addCriterion("is_validated =", value, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedNotEqualTo(Boolean value) {
            addCriterion("is_validated <>", value, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedGreaterThan(Boolean value) {
            addCriterion("is_validated >", value, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_validated >=", value, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedLessThan(Boolean value) {
            addCriterion("is_validated <", value, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_validated <=", value, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedIn(List<Boolean> values) {
            addCriterion("is_validated in", values, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedNotIn(List<Boolean> values) {
            addCriterion("is_validated not in", values, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_validated between", value1, value2, "is_validated");
            return (Criteria) this;
        }

        public Criteria andIs_validatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_validated not between", value1, value2, "is_validated");
            return (Criteria) this;
        }

        public Criteria andCourse_idIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourse_idIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourse_idEqualTo(Long value) {
            addCriterion("course_id =", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idGreaterThan(Long value) {
            addCriterion("course_id >", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idLessThan(Long value) {
            addCriterion("course_id <", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idIn(List<Long> values) {
            addCriterion("course_id in", values, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "course_id");
            return (Criteria) this;
        }

        public Criteria andCourse_idNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "course_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idIsNull() {
            addCriterion("bank_branch_id is null");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idIsNotNull() {
            addCriterion("bank_branch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idEqualTo(Long value) {
            addCriterion("bank_branch_id =", value, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idNotEqualTo(Long value) {
            addCriterion("bank_branch_id <>", value, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idGreaterThan(Long value) {
            addCriterion("bank_branch_id >", value, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idGreaterThanOrEqualTo(Long value) {
            addCriterion("bank_branch_id >=", value, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idLessThan(Long value) {
            addCriterion("bank_branch_id <", value, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idLessThanOrEqualTo(Long value) {
            addCriterion("bank_branch_id <=", value, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idIn(List<Long> values) {
            addCriterion("bank_branch_id in", values, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idNotIn(List<Long> values) {
            addCriterion("bank_branch_id not in", values, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idBetween(Long value1, Long value2) {
            addCriterion("bank_branch_id between", value1, value2, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andBank_branch_idNotBetween(Long value1, Long value2) {
            addCriterion("bank_branch_id not between", value1, value2, "bank_branch_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idIsNull() {
            addCriterion("sf_site_id is null");
            return (Criteria) this;
        }

        public Criteria andSf_site_idIsNotNull() {
            addCriterion("sf_site_id is not null");
            return (Criteria) this;
        }

        public Criteria andSf_site_idEqualTo(Long value) {
            addCriterion("sf_site_id =", value, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idNotEqualTo(Long value) {
            addCriterion("sf_site_id <>", value, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idGreaterThan(Long value) {
            addCriterion("sf_site_id >", value, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idGreaterThanOrEqualTo(Long value) {
            addCriterion("sf_site_id >=", value, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idLessThan(Long value) {
            addCriterion("sf_site_id <", value, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idLessThanOrEqualTo(Long value) {
            addCriterion("sf_site_id <=", value, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idIn(List<Long> values) {
            addCriterion("sf_site_id in", values, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idNotIn(List<Long> values) {
            addCriterion("sf_site_id not in", values, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idBetween(Long value1, Long value2) {
            addCriterion("sf_site_id between", value1, value2, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andSf_site_idNotBetween(Long value1, Long value2) {
            addCriterion("sf_site_id not between", value1, value2, "sf_site_id");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceIsNull() {
            addCriterion("is_customer_service is null");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceIsNotNull() {
            addCriterion("is_customer_service is not null");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceEqualTo(Boolean value) {
            addCriterion("is_customer_service =", value, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceNotEqualTo(Boolean value) {
            addCriterion("is_customer_service <>", value, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceGreaterThan(Boolean value) {
            addCriterion("is_customer_service >", value, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_customer_service >=", value, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceLessThan(Boolean value) {
            addCriterion("is_customer_service <", value, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceLessThanOrEqualTo(Boolean value) {
            addCriterion("is_customer_service <=", value, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceIn(List<Boolean> values) {
            addCriterion("is_customer_service in", values, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceNotIn(List<Boolean> values) {
            addCriterion("is_customer_service not in", values, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceBetween(Boolean value1, Boolean value2) {
            addCriterion("is_customer_service between", value1, value2, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andIs_customer_serviceNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_customer_service not between", value1, value2, "is_customer_service");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeIsNull() {
            addCriterion("enjoy_assistant_fee is null");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeIsNotNull() {
            addCriterion("enjoy_assistant_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeEqualTo(Boolean value) {
            addCriterion("enjoy_assistant_fee =", value, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeNotEqualTo(Boolean value) {
            addCriterion("enjoy_assistant_fee <>", value, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeGreaterThan(Boolean value) {
            addCriterion("enjoy_assistant_fee >", value, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enjoy_assistant_fee >=", value, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeLessThan(Boolean value) {
            addCriterion("enjoy_assistant_fee <", value, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeLessThanOrEqualTo(Boolean value) {
            addCriterion("enjoy_assistant_fee <=", value, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeIn(List<Boolean> values) {
            addCriterion("enjoy_assistant_fee in", values, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeNotIn(List<Boolean> values) {
            addCriterion("enjoy_assistant_fee not in", values, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeBetween(Boolean value1, Boolean value2) {
            addCriterion("enjoy_assistant_fee between", value1, value2, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andEnjoy_assistant_feeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enjoy_assistant_fee not between", value1, value2, "enjoy_assistant_fee");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlIsNull() {
            addCriterion("head_img_url is null");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlIsNotNull() {
            addCriterion("head_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlEqualTo(String value) {
            addCriterion("head_img_url =", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlNotEqualTo(String value) {
            addCriterion("head_img_url <>", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlGreaterThan(String value) {
            addCriterion("head_img_url >", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlGreaterThanOrEqualTo(String value) {
            addCriterion("head_img_url >=", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlLessThan(String value) {
            addCriterion("head_img_url <", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlLessThanOrEqualTo(String value) {
            addCriterion("head_img_url <=", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlLike(String value) {
            addCriterion("head_img_url like", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlNotLike(String value) {
            addCriterion("head_img_url not like", value, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlIn(List<String> values) {
            addCriterion("head_img_url in", values, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlNotIn(List<String> values) {
            addCriterion("head_img_url not in", values, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlBetween(String value1, String value2) {
            addCriterion("head_img_url between", value1, value2, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andHead_img_urlNotBetween(String value1, String value2) {
            addCriterion("head_img_url not between", value1, value2, "head_img_url");
            return (Criteria) this;
        }

        public Criteria andFirst_letterIsNull() {
            addCriterion("first_letter is null");
            return (Criteria) this;
        }

        public Criteria andFirst_letterIsNotNull() {
            addCriterion("first_letter is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_letterEqualTo(String value) {
            addCriterion("first_letter =", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterNotEqualTo(String value) {
            addCriterion("first_letter <>", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterGreaterThan(String value) {
            addCriterion("first_letter >", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterGreaterThanOrEqualTo(String value) {
            addCriterion("first_letter >=", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterLessThan(String value) {
            addCriterion("first_letter <", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterLessThanOrEqualTo(String value) {
            addCriterion("first_letter <=", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterLike(String value) {
            addCriterion("first_letter like", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterNotLike(String value) {
            addCriterion("first_letter not like", value, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterIn(List<String> values) {
            addCriterion("first_letter in", values, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterNotIn(List<String> values) {
            addCriterion("first_letter not in", values, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterBetween(String value1, String value2) {
            addCriterion("first_letter between", value1, value2, "first_letter");
            return (Criteria) this;
        }

        public Criteria andFirst_letterNotBetween(String value1, String value2) {
            addCriterion("first_letter not between", value1, value2, "first_letter");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idIsNull() {
            addCriterion("sf_airport_id is null");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idIsNotNull() {
            addCriterion("sf_airport_id is not null");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idEqualTo(Long value) {
            addCriterion("sf_airport_id =", value, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idNotEqualTo(Long value) {
            addCriterion("sf_airport_id <>", value, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idGreaterThan(Long value) {
            addCriterion("sf_airport_id >", value, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idGreaterThanOrEqualTo(Long value) {
            addCriterion("sf_airport_id >=", value, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idLessThan(Long value) {
            addCriterion("sf_airport_id <", value, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idLessThanOrEqualTo(Long value) {
            addCriterion("sf_airport_id <=", value, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idIn(List<Long> values) {
            addCriterion("sf_airport_id in", values, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idNotIn(List<Long> values) {
            addCriterion("sf_airport_id not in", values, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idBetween(Long value1, Long value2) {
            addCriterion("sf_airport_id between", value1, value2, "sf_airport_id");
            return (Criteria) this;
        }

        public Criteria andSf_airport_idNotBetween(Long value1, Long value2) {
            addCriterion("sf_airport_id not between", value1, value2, "sf_airport_id");
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