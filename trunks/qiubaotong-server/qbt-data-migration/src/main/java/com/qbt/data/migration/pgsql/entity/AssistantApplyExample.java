package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssistantApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssistantApplyExample() {
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

        public Criteria andAssistant_idIsNull() {
            addCriterion("assistant_id is null");
            return (Criteria) this;
        }

        public Criteria andAssistant_idIsNotNull() {
            addCriterion("assistant_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssistant_idEqualTo(Long value) {
            addCriterion("assistant_id =", value, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idNotEqualTo(Long value) {
            addCriterion("assistant_id <>", value, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idGreaterThan(Long value) {
            addCriterion("assistant_id >", value, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idGreaterThanOrEqualTo(Long value) {
            addCriterion("assistant_id >=", value, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idLessThan(Long value) {
            addCriterion("assistant_id <", value, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idLessThanOrEqualTo(Long value) {
            addCriterion("assistant_id <=", value, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idIn(List<Long> values) {
            addCriterion("assistant_id in", values, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idNotIn(List<Long> values) {
            addCriterion("assistant_id not in", values, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idBetween(Long value1, Long value2) {
            addCriterion("assistant_id between", value1, value2, "assistant_id");
            return (Criteria) this;
        }

        public Criteria andAssistant_idNotBetween(Long value1, Long value2) {
            addCriterion("assistant_id not between", value1, value2, "assistant_id");
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

        public Criteria andIdentity_codeIsNull() {
            addCriterion("identity_code is null");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeIsNotNull() {
            addCriterion("identity_code is not null");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeEqualTo(String value) {
            addCriterion("identity_code =", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeNotEqualTo(String value) {
            addCriterion("identity_code <>", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeGreaterThan(String value) {
            addCriterion("identity_code >", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeGreaterThanOrEqualTo(String value) {
            addCriterion("identity_code >=", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeLessThan(String value) {
            addCriterion("identity_code <", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeLessThanOrEqualTo(String value) {
            addCriterion("identity_code <=", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeLike(String value) {
            addCriterion("identity_code like", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeNotLike(String value) {
            addCriterion("identity_code not like", value, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeIn(List<String> values) {
            addCriterion("identity_code in", values, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeNotIn(List<String> values) {
            addCriterion("identity_code not in", values, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeBetween(String value1, String value2) {
            addCriterion("identity_code between", value1, value2, "identity_code");
            return (Criteria) this;
        }

        public Criteria andIdentity_codeNotBetween(String value1, String value2) {
            addCriterion("identity_code not between", value1, value2, "identity_code");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlIsNull() {
            addCriterion("photo1_url is null");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlIsNotNull() {
            addCriterion("photo1_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlEqualTo(String value) {
            addCriterion("photo1_url =", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlNotEqualTo(String value) {
            addCriterion("photo1_url <>", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlGreaterThan(String value) {
            addCriterion("photo1_url >", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlGreaterThanOrEqualTo(String value) {
            addCriterion("photo1_url >=", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlLessThan(String value) {
            addCriterion("photo1_url <", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlLessThanOrEqualTo(String value) {
            addCriterion("photo1_url <=", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlLike(String value) {
            addCriterion("photo1_url like", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlNotLike(String value) {
            addCriterion("photo1_url not like", value, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlIn(List<String> values) {
            addCriterion("photo1_url in", values, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlNotIn(List<String> values) {
            addCriterion("photo1_url not in", values, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlBetween(String value1, String value2) {
            addCriterion("photo1_url between", value1, value2, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto1_urlNotBetween(String value1, String value2) {
            addCriterion("photo1_url not between", value1, value2, "photo1_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlIsNull() {
            addCriterion("photo2_url is null");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlIsNotNull() {
            addCriterion("photo2_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlEqualTo(String value) {
            addCriterion("photo2_url =", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlNotEqualTo(String value) {
            addCriterion("photo2_url <>", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlGreaterThan(String value) {
            addCriterion("photo2_url >", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlGreaterThanOrEqualTo(String value) {
            addCriterion("photo2_url >=", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlLessThan(String value) {
            addCriterion("photo2_url <", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlLessThanOrEqualTo(String value) {
            addCriterion("photo2_url <=", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlLike(String value) {
            addCriterion("photo2_url like", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlNotLike(String value) {
            addCriterion("photo2_url not like", value, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlIn(List<String> values) {
            addCriterion("photo2_url in", values, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlNotIn(List<String> values) {
            addCriterion("photo2_url not in", values, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlBetween(String value1, String value2) {
            addCriterion("photo2_url between", value1, value2, "photo2_url");
            return (Criteria) this;
        }

        public Criteria andPhoto2_urlNotBetween(String value1, String value2) {
            addCriterion("photo2_url not between", value1, value2, "photo2_url");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReject_reasonIsNull() {
            addCriterion("reject_reason is null");
            return (Criteria) this;
        }

        public Criteria andReject_reasonIsNotNull() {
            addCriterion("reject_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReject_reasonEqualTo(String value) {
            addCriterion("reject_reason =", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonNotEqualTo(String value) {
            addCriterion("reject_reason <>", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonGreaterThan(String value) {
            addCriterion("reject_reason >", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonGreaterThanOrEqualTo(String value) {
            addCriterion("reject_reason >=", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonLessThan(String value) {
            addCriterion("reject_reason <", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonLessThanOrEqualTo(String value) {
            addCriterion("reject_reason <=", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonLike(String value) {
            addCriterion("reject_reason like", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonNotLike(String value) {
            addCriterion("reject_reason not like", value, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonIn(List<String> values) {
            addCriterion("reject_reason in", values, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonNotIn(List<String> values) {
            addCriterion("reject_reason not in", values, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonBetween(String value1, String value2) {
            addCriterion("reject_reason between", value1, value2, "reject_reason");
            return (Criteria) this;
        }

        public Criteria andReject_reasonNotBetween(String value1, String value2) {
            addCriterion("reject_reason not between", value1, value2, "reject_reason");
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

        public Criteria andApply_typeIsNull() {
            addCriterion("apply_type is null");
            return (Criteria) this;
        }

        public Criteria andApply_typeIsNotNull() {
            addCriterion("apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andApply_typeEqualTo(Integer value) {
            addCriterion("apply_type =", value, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeNotEqualTo(Integer value) {
            addCriterion("apply_type <>", value, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeGreaterThan(Integer value) {
            addCriterion("apply_type >", value, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_type >=", value, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeLessThan(Integer value) {
            addCriterion("apply_type <", value, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeLessThanOrEqualTo(Integer value) {
            addCriterion("apply_type <=", value, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeIn(List<Integer> values) {
            addCriterion("apply_type in", values, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeNotIn(List<Integer> values) {
            addCriterion("apply_type not in", values, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeBetween(Integer value1, Integer value2) {
            addCriterion("apply_type between", value1, value2, "apply_type");
            return (Criteria) this;
        }

        public Criteria andApply_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_type not between", value1, value2, "apply_type");
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

        public Criteria andAirport_idIsNull() {
            addCriterion("airport_id is null");
            return (Criteria) this;
        }

        public Criteria andAirport_idIsNotNull() {
            addCriterion("airport_id is not null");
            return (Criteria) this;
        }

        public Criteria andAirport_idEqualTo(Long value) {
            addCriterion("airport_id =", value, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idNotEqualTo(Long value) {
            addCriterion("airport_id <>", value, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idGreaterThan(Long value) {
            addCriterion("airport_id >", value, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idGreaterThanOrEqualTo(Long value) {
            addCriterion("airport_id >=", value, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idLessThan(Long value) {
            addCriterion("airport_id <", value, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idLessThanOrEqualTo(Long value) {
            addCriterion("airport_id <=", value, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idIn(List<Long> values) {
            addCriterion("airport_id in", values, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idNotIn(List<Long> values) {
            addCriterion("airport_id not in", values, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idBetween(Long value1, Long value2) {
            addCriterion("airport_id between", value1, value2, "airport_id");
            return (Criteria) this;
        }

        public Criteria andAirport_idNotBetween(Long value1, Long value2) {
            addCriterion("airport_id not between", value1, value2, "airport_id");
            return (Criteria) this;
        }

        public Criteria andBank_idIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBank_idIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBank_idEqualTo(Long value) {
            addCriterion("bank_id =", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotEqualTo(Long value) {
            addCriterion("bank_id <>", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idGreaterThan(Long value) {
            addCriterion("bank_id >", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idGreaterThanOrEqualTo(Long value) {
            addCriterion("bank_id >=", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLessThan(Long value) {
            addCriterion("bank_id <", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLessThanOrEqualTo(Long value) {
            addCriterion("bank_id <=", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idIn(List<Long> values) {
            addCriterion("bank_id in", values, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotIn(List<Long> values) {
            addCriterion("bank_id not in", values, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idBetween(Long value1, Long value2) {
            addCriterion("bank_id between", value1, value2, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotBetween(Long value1, Long value2) {
            addCriterion("bank_id not between", value1, value2, "bank_id");
            return (Criteria) this;
        }

        public Criteria andApply_idIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApply_idIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApply_idEqualTo(Long value) {
            addCriterion("apply_id =", value, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idNotEqualTo(Long value) {
            addCriterion("apply_id <>", value, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idGreaterThan(Long value) {
            addCriterion("apply_id >", value, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_id >=", value, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idLessThan(Long value) {
            addCriterion("apply_id <", value, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idLessThanOrEqualTo(Long value) {
            addCriterion("apply_id <=", value, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idIn(List<Long> values) {
            addCriterion("apply_id in", values, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idNotIn(List<Long> values) {
            addCriterion("apply_id not in", values, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idBetween(Long value1, Long value2) {
            addCriterion("apply_id between", value1, value2, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_idNotBetween(Long value1, Long value2) {
            addCriterion("apply_id not between", value1, value2, "apply_id");
            return (Criteria) this;
        }

        public Criteria andApply_nameIsNull() {
            addCriterion("apply_name is null");
            return (Criteria) this;
        }

        public Criteria andApply_nameIsNotNull() {
            addCriterion("apply_name is not null");
            return (Criteria) this;
        }

        public Criteria andApply_nameEqualTo(String value) {
            addCriterion("apply_name =", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameNotEqualTo(String value) {
            addCriterion("apply_name <>", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameGreaterThan(String value) {
            addCriterion("apply_name >", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_name >=", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameLessThan(String value) {
            addCriterion("apply_name <", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameLessThanOrEqualTo(String value) {
            addCriterion("apply_name <=", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameLike(String value) {
            addCriterion("apply_name like", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameNotLike(String value) {
            addCriterion("apply_name not like", value, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameIn(List<String> values) {
            addCriterion("apply_name in", values, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameNotIn(List<String> values) {
            addCriterion("apply_name not in", values, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameBetween(String value1, String value2) {
            addCriterion("apply_name between", value1, value2, "apply_name");
            return (Criteria) this;
        }

        public Criteria andApply_nameNotBetween(String value1, String value2) {
            addCriterion("apply_name not between", value1, value2, "apply_name");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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