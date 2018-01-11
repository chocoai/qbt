package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssistantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssistantExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
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

        public Criteria andId_noIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andId_noIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andId_noEqualTo(String value) {
            addCriterion("id_no =", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotEqualTo(String value) {
            addCriterion("id_no <>", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noGreaterThan(String value) {
            addCriterion("id_no >", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noLessThan(String value) {
            addCriterion("id_no <", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noLike(String value) {
            addCriterion("id_no like", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotLike(String value) {
            addCriterion("id_no not like", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noIn(List<String> values) {
            addCriterion("id_no in", values, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotIn(List<String> values) {
            addCriterion("id_no not in", values, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_no_imgIsNull() {
            addCriterion("id_no_img is null");
            return (Criteria) this;
        }

        public Criteria andId_no_imgIsNotNull() {
            addCriterion("id_no_img is not null");
            return (Criteria) this;
        }

        public Criteria andId_no_imgEqualTo(String value) {
            addCriterion("id_no_img =", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgNotEqualTo(String value) {
            addCriterion("id_no_img <>", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgGreaterThan(String value) {
            addCriterion("id_no_img >", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgGreaterThanOrEqualTo(String value) {
            addCriterion("id_no_img >=", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgLessThan(String value) {
            addCriterion("id_no_img <", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgLessThanOrEqualTo(String value) {
            addCriterion("id_no_img <=", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgLike(String value) {
            addCriterion("id_no_img like", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgNotLike(String value) {
            addCriterion("id_no_img not like", value, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgIn(List<String> values) {
            addCriterion("id_no_img in", values, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgNotIn(List<String> values) {
            addCriterion("id_no_img not in", values, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgBetween(String value1, String value2) {
            addCriterion("id_no_img between", value1, value2, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andId_no_imgNotBetween(String value1, String value2) {
            addCriterion("id_no_img not between", value1, value2, "id_no_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgIsNull() {
            addCriterion("name_card_img is null");
            return (Criteria) this;
        }

        public Criteria andName_card_imgIsNotNull() {
            addCriterion("name_card_img is not null");
            return (Criteria) this;
        }

        public Criteria andName_card_imgEqualTo(String value) {
            addCriterion("name_card_img =", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgNotEqualTo(String value) {
            addCriterion("name_card_img <>", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgGreaterThan(String value) {
            addCriterion("name_card_img >", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgGreaterThanOrEqualTo(String value) {
            addCriterion("name_card_img >=", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgLessThan(String value) {
            addCriterion("name_card_img <", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgLessThanOrEqualTo(String value) {
            addCriterion("name_card_img <=", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgLike(String value) {
            addCriterion("name_card_img like", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgNotLike(String value) {
            addCriterion("name_card_img not like", value, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgIn(List<String> values) {
            addCriterion("name_card_img in", values, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgNotIn(List<String> values) {
            addCriterion("name_card_img not in", values, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgBetween(String value1, String value2) {
            addCriterion("name_card_img between", value1, value2, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andName_card_imgNotBetween(String value1, String value2) {
            addCriterion("name_card_img not between", value1, value2, "name_card_img");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andEducation_levelIsNull() {
            addCriterion("education_level is null");
            return (Criteria) this;
        }

        public Criteria andEducation_levelIsNotNull() {
            addCriterion("education_level is not null");
            return (Criteria) this;
        }

        public Criteria andEducation_levelEqualTo(Short value) {
            addCriterion("education_level =", value, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelNotEqualTo(Short value) {
            addCriterion("education_level <>", value, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelGreaterThan(Short value) {
            addCriterion("education_level >", value, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelGreaterThanOrEqualTo(Short value) {
            addCriterion("education_level >=", value, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelLessThan(Short value) {
            addCriterion("education_level <", value, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelLessThanOrEqualTo(Short value) {
            addCriterion("education_level <=", value, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelIn(List<Short> values) {
            addCriterion("education_level in", values, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelNotIn(List<Short> values) {
            addCriterion("education_level not in", values, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelBetween(Short value1, Short value2) {
            addCriterion("education_level between", value1, value2, "education_level");
            return (Criteria) this;
        }

        public Criteria andEducation_levelNotBetween(Short value1, Short value2) {
            addCriterion("education_level not between", value1, value2, "education_level");
            return (Criteria) this;
        }

        public Criteria andResumeIsNull() {
            addCriterion("resume is null");
            return (Criteria) this;
        }

        public Criteria andResumeIsNotNull() {
            addCriterion("resume is not null");
            return (Criteria) this;
        }

        public Criteria andResumeEqualTo(String value) {
            addCriterion("resume =", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotEqualTo(String value) {
            addCriterion("resume <>", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThan(String value) {
            addCriterion("resume >", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThanOrEqualTo(String value) {
            addCriterion("resume >=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThan(String value) {
            addCriterion("resume <", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThanOrEqualTo(String value) {
            addCriterion("resume <=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLike(String value) {
            addCriterion("resume like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotLike(String value) {
            addCriterion("resume not like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeIn(List<String> values) {
            addCriterion("resume in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotIn(List<String> values) {
            addCriterion("resume not in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeBetween(String value1, String value2) {
            addCriterion("resume between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotBetween(String value1, String value2) {
            addCriterion("resume not between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
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

        public Criteria andReject_descIsNull() {
            addCriterion("reject_desc is null");
            return (Criteria) this;
        }

        public Criteria andReject_descIsNotNull() {
            addCriterion("reject_desc is not null");
            return (Criteria) this;
        }

        public Criteria andReject_descEqualTo(String value) {
            addCriterion("reject_desc =", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descNotEqualTo(String value) {
            addCriterion("reject_desc <>", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descGreaterThan(String value) {
            addCriterion("reject_desc >", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descGreaterThanOrEqualTo(String value) {
            addCriterion("reject_desc >=", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descLessThan(String value) {
            addCriterion("reject_desc <", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descLessThanOrEqualTo(String value) {
            addCriterion("reject_desc <=", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descLike(String value) {
            addCriterion("reject_desc like", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descNotLike(String value) {
            addCriterion("reject_desc not like", value, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descIn(List<String> values) {
            addCriterion("reject_desc in", values, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descNotIn(List<String> values) {
            addCriterion("reject_desc not in", values, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descBetween(String value1, String value2) {
            addCriterion("reject_desc between", value1, value2, "reject_desc");
            return (Criteria) this;
        }

        public Criteria andReject_descNotBetween(String value1, String value2) {
            addCriterion("reject_desc not between", value1, value2, "reject_desc");
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

        public Criteria andPhoto1IsNull() {
            addCriterion("photo1 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto1IsNotNull() {
            addCriterion("photo1 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto1EqualTo(String value) {
            addCriterion("photo1 =", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotEqualTo(String value) {
            addCriterion("photo1 <>", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1GreaterThan(String value) {
            addCriterion("photo1 >", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1GreaterThanOrEqualTo(String value) {
            addCriterion("photo1 >=", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1LessThan(String value) {
            addCriterion("photo1 <", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1LessThanOrEqualTo(String value) {
            addCriterion("photo1 <=", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1Like(String value) {
            addCriterion("photo1 like", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotLike(String value) {
            addCriterion("photo1 not like", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1In(List<String> values) {
            addCriterion("photo1 in", values, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotIn(List<String> values) {
            addCriterion("photo1 not in", values, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1Between(String value1, String value2) {
            addCriterion("photo1 between", value1, value2, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotBetween(String value1, String value2) {
            addCriterion("photo1 not between", value1, value2, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto2IsNull() {
            addCriterion("photo2 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto2IsNotNull() {
            addCriterion("photo2 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto2EqualTo(String value) {
            addCriterion("photo2 =", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotEqualTo(String value) {
            addCriterion("photo2 <>", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2GreaterThan(String value) {
            addCriterion("photo2 >", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2GreaterThanOrEqualTo(String value) {
            addCriterion("photo2 >=", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2LessThan(String value) {
            addCriterion("photo2 <", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2LessThanOrEqualTo(String value) {
            addCriterion("photo2 <=", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2Like(String value) {
            addCriterion("photo2 like", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotLike(String value) {
            addCriterion("photo2 not like", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2In(List<String> values) {
            addCriterion("photo2 in", values, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotIn(List<String> values) {
            addCriterion("photo2 not in", values, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2Between(String value1, String value2) {
            addCriterion("photo2 between", value1, value2, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotBetween(String value1, String value2) {
            addCriterion("photo2 not between", value1, value2, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idIsNull() {
            addCriterion("photo1_media_id is null");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idIsNotNull() {
            addCriterion("photo1_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idEqualTo(String value) {
            addCriterion("photo1_media_id =", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idNotEqualTo(String value) {
            addCriterion("photo1_media_id <>", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idGreaterThan(String value) {
            addCriterion("photo1_media_id >", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idGreaterThanOrEqualTo(String value) {
            addCriterion("photo1_media_id >=", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idLessThan(String value) {
            addCriterion("photo1_media_id <", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idLessThanOrEqualTo(String value) {
            addCriterion("photo1_media_id <=", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idLike(String value) {
            addCriterion("photo1_media_id like", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idNotLike(String value) {
            addCriterion("photo1_media_id not like", value, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idIn(List<String> values) {
            addCriterion("photo1_media_id in", values, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idNotIn(List<String> values) {
            addCriterion("photo1_media_id not in", values, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idBetween(String value1, String value2) {
            addCriterion("photo1_media_id between", value1, value2, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_media_idNotBetween(String value1, String value2) {
            addCriterion("photo1_media_id not between", value1, value2, "photo1_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idIsNull() {
            addCriterion("photo2_media_id is null");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idIsNotNull() {
            addCriterion("photo2_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idEqualTo(String value) {
            addCriterion("photo2_media_id =", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idNotEqualTo(String value) {
            addCriterion("photo2_media_id <>", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idGreaterThan(String value) {
            addCriterion("photo2_media_id >", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idGreaterThanOrEqualTo(String value) {
            addCriterion("photo2_media_id >=", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idLessThan(String value) {
            addCriterion("photo2_media_id <", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idLessThanOrEqualTo(String value) {
            addCriterion("photo2_media_id <=", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idLike(String value) {
            addCriterion("photo2_media_id like", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idNotLike(String value) {
            addCriterion("photo2_media_id not like", value, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idIn(List<String> values) {
            addCriterion("photo2_media_id in", values, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idNotIn(List<String> values) {
            addCriterion("photo2_media_id not in", values, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idBetween(String value1, String value2) {
            addCriterion("photo2_media_id between", value1, value2, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto2_media_idNotBetween(String value1, String value2) {
            addCriterion("photo2_media_id not between", value1, value2, "photo2_media_id");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileIsNull() {
            addCriterion("photo1_file is null");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileIsNotNull() {
            addCriterion("photo1_file is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileEqualTo(String value) {
            addCriterion("photo1_file =", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileNotEqualTo(String value) {
            addCriterion("photo1_file <>", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileGreaterThan(String value) {
            addCriterion("photo1_file >", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileGreaterThanOrEqualTo(String value) {
            addCriterion("photo1_file >=", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileLessThan(String value) {
            addCriterion("photo1_file <", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileLessThanOrEqualTo(String value) {
            addCriterion("photo1_file <=", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileLike(String value) {
            addCriterion("photo1_file like", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileNotLike(String value) {
            addCriterion("photo1_file not like", value, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileIn(List<String> values) {
            addCriterion("photo1_file in", values, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileNotIn(List<String> values) {
            addCriterion("photo1_file not in", values, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileBetween(String value1, String value2) {
            addCriterion("photo1_file between", value1, value2, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto1_fileNotBetween(String value1, String value2) {
            addCriterion("photo1_file not between", value1, value2, "photo1_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileIsNull() {
            addCriterion("photo2_file is null");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileIsNotNull() {
            addCriterion("photo2_file is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileEqualTo(String value) {
            addCriterion("photo2_file =", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileNotEqualTo(String value) {
            addCriterion("photo2_file <>", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileGreaterThan(String value) {
            addCriterion("photo2_file >", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileGreaterThanOrEqualTo(String value) {
            addCriterion("photo2_file >=", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileLessThan(String value) {
            addCriterion("photo2_file <", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileLessThanOrEqualTo(String value) {
            addCriterion("photo2_file <=", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileLike(String value) {
            addCriterion("photo2_file like", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileNotLike(String value) {
            addCriterion("photo2_file not like", value, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileIn(List<String> values) {
            addCriterion("photo2_file in", values, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileNotIn(List<String> values) {
            addCriterion("photo2_file not in", values, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileBetween(String value1, String value2) {
            addCriterion("photo2_file between", value1, value2, "photo2_file");
            return (Criteria) this;
        }

        public Criteria andPhoto2_fileNotBetween(String value1, String value2) {
            addCriterion("photo2_file not between", value1, value2, "photo2_file");
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