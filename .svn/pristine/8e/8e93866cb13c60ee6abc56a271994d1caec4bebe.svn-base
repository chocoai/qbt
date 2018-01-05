package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andShort_nameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShort_nameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShort_nameEqualTo(String value) {
            addCriterion("short_name =", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameGreaterThan(String value) {
            addCriterion("short_name >", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameLessThan(String value) {
            addCriterion("short_name <", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameLike(String value) {
            addCriterion("short_name like", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameNotLike(String value) {
            addCriterion("short_name not like", value, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameIn(List<String> values) {
            addCriterion("short_name in", values, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "short_name");
            return (Criteria) this;
        }

        public Criteria andShort_nameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "short_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameEqualTo(String value) {
            addCriterion("english_name =", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameGreaterThan(String value) {
            addCriterion("english_name >", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameLessThan(String value) {
            addCriterion("english_name <", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameLike(String value) {
            addCriterion("english_name like", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotLike(String value) {
            addCriterion("english_name not like", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameIn(List<String> values) {
            addCriterion("english_name in", values, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "english_name");
            return (Criteria) this;
        }

        public Criteria andInitialIsNull() {
            addCriterion("initial is null");
            return (Criteria) this;
        }

        public Criteria andInitialIsNotNull() {
            addCriterion("initial is not null");
            return (Criteria) this;
        }

        public Criteria andInitialEqualTo(String value) {
            addCriterion("initial =", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotEqualTo(String value) {
            addCriterion("initial <>", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialGreaterThan(String value) {
            addCriterion("initial >", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialGreaterThanOrEqualTo(String value) {
            addCriterion("initial >=", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLessThan(String value) {
            addCriterion("initial <", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLessThanOrEqualTo(String value) {
            addCriterion("initial <=", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLike(String value) {
            addCriterion("initial like", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotLike(String value) {
            addCriterion("initial not like", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialIn(List<String> values) {
            addCriterion("initial in", values, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotIn(List<String> values) {
            addCriterion("initial not in", values, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialBetween(String value1, String value2) {
            addCriterion("initial between", value1, value2, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotBetween(String value1, String value2) {
            addCriterion("initial not between", value1, value2, "initial");
            return (Criteria) this;
        }

        public Criteria andGolf_holeIsNull() {
            addCriterion("golf_hole is null");
            return (Criteria) this;
        }

        public Criteria andGolf_holeIsNotNull() {
            addCriterion("golf_hole is not null");
            return (Criteria) this;
        }

        public Criteria andGolf_holeEqualTo(Short value) {
            addCriterion("golf_hole =", value, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeNotEqualTo(Short value) {
            addCriterion("golf_hole <>", value, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeGreaterThan(Short value) {
            addCriterion("golf_hole >", value, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeGreaterThanOrEqualTo(Short value) {
            addCriterion("golf_hole >=", value, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeLessThan(Short value) {
            addCriterion("golf_hole <", value, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeLessThanOrEqualTo(Short value) {
            addCriterion("golf_hole <=", value, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeIn(List<Short> values) {
            addCriterion("golf_hole in", values, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeNotIn(List<Short> values) {
            addCriterion("golf_hole not in", values, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeBetween(Short value1, Short value2) {
            addCriterion("golf_hole between", value1, value2, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andGolf_holeNotBetween(Short value1, Short value2) {
            addCriterion("golf_hole not between", value1, value2, "golf_hole");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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

        public Criteria andUpdated_atIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atEqualTo(Date value) {
            addCriterion("updated_at =", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThan(Date value) {
            addCriterion("updated_at <", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIn(List<Date> values) {
            addCriterion("updated_at in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
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

        public Criteria andLonIsNull() {
            addCriterion("lon is null");
            return (Criteria) this;
        }

        public Criteria andLonIsNotNull() {
            addCriterion("lon is not null");
            return (Criteria) this;
        }

        public Criteria andLonEqualTo(Double value) {
            addCriterion("lon =", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotEqualTo(Double value) {
            addCriterion("lon <>", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThan(Double value) {
            addCriterion("lon >", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThanOrEqualTo(Double value) {
            addCriterion("lon >=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThan(Double value) {
            addCriterion("lon <", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThanOrEqualTo(Double value) {
            addCriterion("lon <=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonIn(List<Double> values) {
            addCriterion("lon in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotIn(List<Double> values) {
            addCriterion("lon not in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonBetween(Double value1, Double value2) {
            addCriterion("lon between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotBetween(Double value1, Double value2) {
            addCriterion("lon not between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
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

        public Criteria andIntroducingIsNull() {
            addCriterion("introducing is null");
            return (Criteria) this;
        }

        public Criteria andIntroducingIsNotNull() {
            addCriterion("introducing is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducingEqualTo(String value) {
            addCriterion("introducing =", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingNotEqualTo(String value) {
            addCriterion("introducing <>", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingGreaterThan(String value) {
            addCriterion("introducing >", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingGreaterThanOrEqualTo(String value) {
            addCriterion("introducing >=", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingLessThan(String value) {
            addCriterion("introducing <", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingLessThanOrEqualTo(String value) {
            addCriterion("introducing <=", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingLike(String value) {
            addCriterion("introducing like", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingNotLike(String value) {
            addCriterion("introducing not like", value, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingIn(List<String> values) {
            addCriterion("introducing in", values, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingNotIn(List<String> values) {
            addCriterion("introducing not in", values, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingBetween(String value1, String value2) {
            addCriterion("introducing between", value1, value2, "introducing");
            return (Criteria) this;
        }

        public Criteria andIntroducingNotBetween(String value1, String value2) {
            addCriterion("introducing not between", value1, value2, "introducing");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefIsNull() {
            addCriterion("introducing_href is null");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefIsNotNull() {
            addCriterion("introducing_href is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefEqualTo(String value) {
            addCriterion("introducing_href =", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefNotEqualTo(String value) {
            addCriterion("introducing_href <>", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefGreaterThan(String value) {
            addCriterion("introducing_href >", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefGreaterThanOrEqualTo(String value) {
            addCriterion("introducing_href >=", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefLessThan(String value) {
            addCriterion("introducing_href <", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefLessThanOrEqualTo(String value) {
            addCriterion("introducing_href <=", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefLike(String value) {
            addCriterion("introducing_href like", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefNotLike(String value) {
            addCriterion("introducing_href not like", value, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefIn(List<String> values) {
            addCriterion("introducing_href in", values, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefNotIn(List<String> values) {
            addCriterion("introducing_href not in", values, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefBetween(String value1, String value2) {
            addCriterion("introducing_href between", value1, value2, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andIntroducing_hrefNotBetween(String value1, String value2) {
            addCriterion("introducing_href not between", value1, value2, "introducing_href");
            return (Criteria) this;
        }

        public Criteria andHas_assistantIsNull() {
            addCriterion("has_assistant is null");
            return (Criteria) this;
        }

        public Criteria andHas_assistantIsNotNull() {
            addCriterion("has_assistant is not null");
            return (Criteria) this;
        }

        public Criteria andHas_assistantEqualTo(Boolean value) {
            addCriterion("has_assistant =", value, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantNotEqualTo(Boolean value) {
            addCriterion("has_assistant <>", value, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantGreaterThan(Boolean value) {
            addCriterion("has_assistant >", value, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_assistant >=", value, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantLessThan(Boolean value) {
            addCriterion("has_assistant <", value, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantLessThanOrEqualTo(Boolean value) {
            addCriterion("has_assistant <=", value, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantIn(List<Boolean> values) {
            addCriterion("has_assistant in", values, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantNotIn(List<Boolean> values) {
            addCriterion("has_assistant not in", values, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantBetween(Boolean value1, Boolean value2) {
            addCriterion("has_assistant between", value1, value2, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andHas_assistantNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_assistant not between", value1, value2, "has_assistant");
            return (Criteria) this;
        }

        public Criteria andSign_placeIsNull() {
            addCriterion("sign_place is null");
            return (Criteria) this;
        }

        public Criteria andSign_placeIsNotNull() {
            addCriterion("sign_place is not null");
            return (Criteria) this;
        }

        public Criteria andSign_placeEqualTo(String value) {
            addCriterion("sign_place =", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeNotEqualTo(String value) {
            addCriterion("sign_place <>", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeGreaterThan(String value) {
            addCriterion("sign_place >", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_place >=", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeLessThan(String value) {
            addCriterion("sign_place <", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeLessThanOrEqualTo(String value) {
            addCriterion("sign_place <=", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeLike(String value) {
            addCriterion("sign_place like", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeNotLike(String value) {
            addCriterion("sign_place not like", value, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeIn(List<String> values) {
            addCriterion("sign_place in", values, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeNotIn(List<String> values) {
            addCriterion("sign_place not in", values, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeBetween(String value1, String value2) {
            addCriterion("sign_place between", value1, value2, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSign_placeNotBetween(String value1, String value2) {
            addCriterion("sign_place not between", value1, value2, "sign_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeIsNull() {
            addCriterion("send_place is null");
            return (Criteria) this;
        }

        public Criteria andSend_placeIsNotNull() {
            addCriterion("send_place is not null");
            return (Criteria) this;
        }

        public Criteria andSend_placeEqualTo(String value) {
            addCriterion("send_place =", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeNotEqualTo(String value) {
            addCriterion("send_place <>", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeGreaterThan(String value) {
            addCriterion("send_place >", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeGreaterThanOrEqualTo(String value) {
            addCriterion("send_place >=", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeLessThan(String value) {
            addCriterion("send_place <", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeLessThanOrEqualTo(String value) {
            addCriterion("send_place <=", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeLike(String value) {
            addCriterion("send_place like", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeNotLike(String value) {
            addCriterion("send_place not like", value, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeIn(List<String> values) {
            addCriterion("send_place in", values, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeNotIn(List<String> values) {
            addCriterion("send_place not in", values, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeBetween(String value1, String value2) {
            addCriterion("send_place between", value1, value2, "send_place");
            return (Criteria) this;
        }

        public Criteria andSend_placeNotBetween(String value1, String value2) {
            addCriterion("send_place not between", value1, value2, "send_place");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeIsNull() {
            addCriterion("start_work_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeIsNotNull() {
            addCriterion("start_work_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeEqualTo(String value) {
            addCriterion("start_work_time =", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeNotEqualTo(String value) {
            addCriterion("start_work_time <>", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeGreaterThan(String value) {
            addCriterion("start_work_time >", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeGreaterThanOrEqualTo(String value) {
            addCriterion("start_work_time >=", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeLessThan(String value) {
            addCriterion("start_work_time <", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeLessThanOrEqualTo(String value) {
            addCriterion("start_work_time <=", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeLike(String value) {
            addCriterion("start_work_time like", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeNotLike(String value) {
            addCriterion("start_work_time not like", value, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeIn(List<String> values) {
            addCriterion("start_work_time in", values, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeNotIn(List<String> values) {
            addCriterion("start_work_time not in", values, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeBetween(String value1, String value2) {
            addCriterion("start_work_time between", value1, value2, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andStart_work_timeNotBetween(String value1, String value2) {
            addCriterion("start_work_time not between", value1, value2, "start_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeIsNull() {
            addCriterion("end_work_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeIsNotNull() {
            addCriterion("end_work_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeEqualTo(String value) {
            addCriterion("end_work_time =", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeNotEqualTo(String value) {
            addCriterion("end_work_time <>", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeGreaterThan(String value) {
            addCriterion("end_work_time >", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeGreaterThanOrEqualTo(String value) {
            addCriterion("end_work_time >=", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeLessThan(String value) {
            addCriterion("end_work_time <", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeLessThanOrEqualTo(String value) {
            addCriterion("end_work_time <=", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeLike(String value) {
            addCriterion("end_work_time like", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeNotLike(String value) {
            addCriterion("end_work_time not like", value, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeIn(List<String> values) {
            addCriterion("end_work_time in", values, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeNotIn(List<String> values) {
            addCriterion("end_work_time not in", values, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeBetween(String value1, String value2) {
            addCriterion("end_work_time between", value1, value2, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andEnd_work_timeNotBetween(String value1, String value2) {
            addCriterion("end_work_time not between", value1, value2, "end_work_time");
            return (Criteria) this;
        }

        public Criteria andProduct_introIsNull() {
            addCriterion("product_intro is null");
            return (Criteria) this;
        }

        public Criteria andProduct_introIsNotNull() {
            addCriterion("product_intro is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_introEqualTo(String value) {
            addCriterion("product_intro =", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introNotEqualTo(String value) {
            addCriterion("product_intro <>", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introGreaterThan(String value) {
            addCriterion("product_intro >", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introGreaterThanOrEqualTo(String value) {
            addCriterion("product_intro >=", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introLessThan(String value) {
            addCriterion("product_intro <", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introLessThanOrEqualTo(String value) {
            addCriterion("product_intro <=", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introLike(String value) {
            addCriterion("product_intro like", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introNotLike(String value) {
            addCriterion("product_intro not like", value, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introIn(List<String> values) {
            addCriterion("product_intro in", values, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introNotIn(List<String> values) {
            addCriterion("product_intro not in", values, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introBetween(String value1, String value2) {
            addCriterion("product_intro between", value1, value2, "product_intro");
            return (Criteria) this;
        }

        public Criteria andProduct_introNotBetween(String value1, String value2) {
            addCriterion("product_intro not between", value1, value2, "product_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introIsNull() {
            addCriterion("feature_intro is null");
            return (Criteria) this;
        }

        public Criteria andFeature_introIsNotNull() {
            addCriterion("feature_intro is not null");
            return (Criteria) this;
        }

        public Criteria andFeature_introEqualTo(String value) {
            addCriterion("feature_intro =", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introNotEqualTo(String value) {
            addCriterion("feature_intro <>", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introGreaterThan(String value) {
            addCriterion("feature_intro >", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introGreaterThanOrEqualTo(String value) {
            addCriterion("feature_intro >=", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introLessThan(String value) {
            addCriterion("feature_intro <", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introLessThanOrEqualTo(String value) {
            addCriterion("feature_intro <=", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introLike(String value) {
            addCriterion("feature_intro like", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introNotLike(String value) {
            addCriterion("feature_intro not like", value, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introIn(List<String> values) {
            addCriterion("feature_intro in", values, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introNotIn(List<String> values) {
            addCriterion("feature_intro not in", values, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introBetween(String value1, String value2) {
            addCriterion("feature_intro between", value1, value2, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFeature_introNotBetween(String value1, String value2) {
            addCriterion("feature_intro not between", value1, value2, "feature_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introIsNull() {
            addCriterion("food_intro is null");
            return (Criteria) this;
        }

        public Criteria andFood_introIsNotNull() {
            addCriterion("food_intro is not null");
            return (Criteria) this;
        }

        public Criteria andFood_introEqualTo(String value) {
            addCriterion("food_intro =", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introNotEqualTo(String value) {
            addCriterion("food_intro <>", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introGreaterThan(String value) {
            addCriterion("food_intro >", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introGreaterThanOrEqualTo(String value) {
            addCriterion("food_intro >=", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introLessThan(String value) {
            addCriterion("food_intro <", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introLessThanOrEqualTo(String value) {
            addCriterion("food_intro <=", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introLike(String value) {
            addCriterion("food_intro like", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introNotLike(String value) {
            addCriterion("food_intro not like", value, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introIn(List<String> values) {
            addCriterion("food_intro in", values, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introNotIn(List<String> values) {
            addCriterion("food_intro not in", values, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introBetween(String value1, String value2) {
            addCriterion("food_intro between", value1, value2, "food_intro");
            return (Criteria) this;
        }

        public Criteria andFood_introNotBetween(String value1, String value2) {
            addCriterion("food_intro not between", value1, value2, "food_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introIsNull() {
            addCriterion("other_intro is null");
            return (Criteria) this;
        }

        public Criteria andOther_introIsNotNull() {
            addCriterion("other_intro is not null");
            return (Criteria) this;
        }

        public Criteria andOther_introEqualTo(String value) {
            addCriterion("other_intro =", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introNotEqualTo(String value) {
            addCriterion("other_intro <>", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introGreaterThan(String value) {
            addCriterion("other_intro >", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introGreaterThanOrEqualTo(String value) {
            addCriterion("other_intro >=", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introLessThan(String value) {
            addCriterion("other_intro <", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introLessThanOrEqualTo(String value) {
            addCriterion("other_intro <=", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introLike(String value) {
            addCriterion("other_intro like", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introNotLike(String value) {
            addCriterion("other_intro not like", value, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introIn(List<String> values) {
            addCriterion("other_intro in", values, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introNotIn(List<String> values) {
            addCriterion("other_intro not in", values, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introBetween(String value1, String value2) {
            addCriterion("other_intro between", value1, value2, "other_intro");
            return (Criteria) this;
        }

        public Criteria andOther_introNotBetween(String value1, String value2) {
            addCriterion("other_intro not between", value1, value2, "other_intro");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeIsNull() {
            addCriterion("bag_deposit_charge is null");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeIsNotNull() {
            addCriterion("bag_deposit_charge is not null");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeEqualTo(Float value) {
            addCriterion("bag_deposit_charge =", value, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeNotEqualTo(Float value) {
            addCriterion("bag_deposit_charge <>", value, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeGreaterThan(Float value) {
            addCriterion("bag_deposit_charge >", value, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeGreaterThanOrEqualTo(Float value) {
            addCriterion("bag_deposit_charge >=", value, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeLessThan(Float value) {
            addCriterion("bag_deposit_charge <", value, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeLessThanOrEqualTo(Float value) {
            addCriterion("bag_deposit_charge <=", value, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeIn(List<Float> values) {
            addCriterion("bag_deposit_charge in", values, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeNotIn(List<Float> values) {
            addCriterion("bag_deposit_charge not in", values, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeBetween(Float value1, Float value2) {
            addCriterion("bag_deposit_charge between", value1, value2, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andBag_deposit_chargeNotBetween(Float value1, Float value2) {
            addCriterion("bag_deposit_charge not between", value1, value2, "bag_deposit_charge");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalIsNull() {
            addCriterion("tee_time_interval is null");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalIsNotNull() {
            addCriterion("tee_time_interval is not null");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalEqualTo(Short value) {
            addCriterion("tee_time_interval =", value, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalNotEqualTo(Short value) {
            addCriterion("tee_time_interval <>", value, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalGreaterThan(Short value) {
            addCriterion("tee_time_interval >", value, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalGreaterThanOrEqualTo(Short value) {
            addCriterion("tee_time_interval >=", value, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalLessThan(Short value) {
            addCriterion("tee_time_interval <", value, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalLessThanOrEqualTo(Short value) {
            addCriterion("tee_time_interval <=", value, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalIn(List<Short> values) {
            addCriterion("tee_time_interval in", values, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalNotIn(List<Short> values) {
            addCriterion("tee_time_interval not in", values, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalBetween(Short value1, Short value2) {
            addCriterion("tee_time_interval between", value1, value2, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_intervalNotBetween(Short value1, Short value2) {
            addCriterion("tee_time_interval not between", value1, value2, "tee_time_interval");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestIsNull() {
            addCriterion("tee_time_earliest is null");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestIsNotNull() {
            addCriterion("tee_time_earliest is not null");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestEqualTo(String value) {
            addCriterion("tee_time_earliest =", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestNotEqualTo(String value) {
            addCriterion("tee_time_earliest <>", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestGreaterThan(String value) {
            addCriterion("tee_time_earliest >", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestGreaterThanOrEqualTo(String value) {
            addCriterion("tee_time_earliest >=", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestLessThan(String value) {
            addCriterion("tee_time_earliest <", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestLessThanOrEqualTo(String value) {
            addCriterion("tee_time_earliest <=", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestLike(String value) {
            addCriterion("tee_time_earliest like", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestNotLike(String value) {
            addCriterion("tee_time_earliest not like", value, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestIn(List<String> values) {
            addCriterion("tee_time_earliest in", values, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestNotIn(List<String> values) {
            addCriterion("tee_time_earliest not in", values, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestBetween(String value1, String value2) {
            addCriterion("tee_time_earliest between", value1, value2, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_earliestNotBetween(String value1, String value2) {
            addCriterion("tee_time_earliest not between", value1, value2, "tee_time_earliest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestIsNull() {
            addCriterion("tee_time_latest is null");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestIsNotNull() {
            addCriterion("tee_time_latest is not null");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestEqualTo(String value) {
            addCriterion("tee_time_latest =", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestNotEqualTo(String value) {
            addCriterion("tee_time_latest <>", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestGreaterThan(String value) {
            addCriterion("tee_time_latest >", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestGreaterThanOrEqualTo(String value) {
            addCriterion("tee_time_latest >=", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestLessThan(String value) {
            addCriterion("tee_time_latest <", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestLessThanOrEqualTo(String value) {
            addCriterion("tee_time_latest <=", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestLike(String value) {
            addCriterion("tee_time_latest like", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestNotLike(String value) {
            addCriterion("tee_time_latest not like", value, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestIn(List<String> values) {
            addCriterion("tee_time_latest in", values, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestNotIn(List<String> values) {
            addCriterion("tee_time_latest not in", values, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestBetween(String value1, String value2) {
            addCriterion("tee_time_latest between", value1, value2, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTee_time_latestNotBetween(String value1, String value2) {
            addCriterion("tee_time_latest not between", value1, value2, "tee_time_latest");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeIsNull() {
            addCriterion("transition_closed_time is null");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeIsNotNull() {
            addCriterion("transition_closed_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeEqualTo(Short value) {
            addCriterion("transition_closed_time =", value, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeNotEqualTo(Short value) {
            addCriterion("transition_closed_time <>", value, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeGreaterThan(Short value) {
            addCriterion("transition_closed_time >", value, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeGreaterThanOrEqualTo(Short value) {
            addCriterion("transition_closed_time >=", value, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeLessThan(Short value) {
            addCriterion("transition_closed_time <", value, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeLessThanOrEqualTo(Short value) {
            addCriterion("transition_closed_time <=", value, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeIn(List<Short> values) {
            addCriterion("transition_closed_time in", values, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeNotIn(List<Short> values) {
            addCriterion("transition_closed_time not in", values, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeBetween(Short value1, Short value2) {
            addCriterion("transition_closed_time between", value1, value2, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_timeNotBetween(Short value1, Short value2) {
            addCriterion("transition_closed_time not between", value1, value2, "transition_closed_time");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNull() {
            addCriterion("weather is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNotNull() {
            addCriterion("weather is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherEqualTo(String value) {
            addCriterion("weather =", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotEqualTo(String value) {
            addCriterion("weather <>", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThan(String value) {
            addCriterion("weather >", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThanOrEqualTo(String value) {
            addCriterion("weather >=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThan(String value) {
            addCriterion("weather <", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThanOrEqualTo(String value) {
            addCriterion("weather <=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLike(String value) {
            addCriterion("weather like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotLike(String value) {
            addCriterion("weather not like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherIn(List<String> values) {
            addCriterion("weather in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotIn(List<String> values) {
            addCriterion("weather not in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherBetween(String value1, String value2) {
            addCriterion("weather between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotBetween(String value1, String value2) {
            addCriterion("weather not between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeIsNull() {
            addCriterion("transition_closed_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeIsNotNull() {
            addCriterion("transition_closed_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeEqualTo(String value) {
            addCriterion("transition_closed_begin_time =", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeNotEqualTo(String value) {
            addCriterion("transition_closed_begin_time <>", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeGreaterThan(String value) {
            addCriterion("transition_closed_begin_time >", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeGreaterThanOrEqualTo(String value) {
            addCriterion("transition_closed_begin_time >=", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeLessThan(String value) {
            addCriterion("transition_closed_begin_time <", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeLessThanOrEqualTo(String value) {
            addCriterion("transition_closed_begin_time <=", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeLike(String value) {
            addCriterion("transition_closed_begin_time like", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeNotLike(String value) {
            addCriterion("transition_closed_begin_time not like", value, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeIn(List<String> values) {
            addCriterion("transition_closed_begin_time in", values, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeNotIn(List<String> values) {
            addCriterion("transition_closed_begin_time not in", values, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeBetween(String value1, String value2) {
            addCriterion("transition_closed_begin_time between", value1, value2, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_begin_timeNotBetween(String value1, String value2) {
            addCriterion("transition_closed_begin_time not between", value1, value2, "transition_closed_begin_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeIsNull() {
            addCriterion("transition_closed_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeIsNotNull() {
            addCriterion("transition_closed_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeEqualTo(String value) {
            addCriterion("transition_closed_end_time =", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeNotEqualTo(String value) {
            addCriterion("transition_closed_end_time <>", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeGreaterThan(String value) {
            addCriterion("transition_closed_end_time >", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeGreaterThanOrEqualTo(String value) {
            addCriterion("transition_closed_end_time >=", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeLessThan(String value) {
            addCriterion("transition_closed_end_time <", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeLessThanOrEqualTo(String value) {
            addCriterion("transition_closed_end_time <=", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeLike(String value) {
            addCriterion("transition_closed_end_time like", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeNotLike(String value) {
            addCriterion("transition_closed_end_time not like", value, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeIn(List<String> values) {
            addCriterion("transition_closed_end_time in", values, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeNotIn(List<String> values) {
            addCriterion("transition_closed_end_time not in", values, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeBetween(String value1, String value2) {
            addCriterion("transition_closed_end_time between", value1, value2, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andTransition_closed_end_timeNotBetween(String value1, String value2) {
            addCriterion("transition_closed_end_time not between", value1, value2, "transition_closed_end_time");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefIsNull() {
            addCriterion("introduction_href is null");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefIsNotNull() {
            addCriterion("introduction_href is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefEqualTo(String value) {
            addCriterion("introduction_href =", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefNotEqualTo(String value) {
            addCriterion("introduction_href <>", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefGreaterThan(String value) {
            addCriterion("introduction_href >", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefGreaterThanOrEqualTo(String value) {
            addCriterion("introduction_href >=", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefLessThan(String value) {
            addCriterion("introduction_href <", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefLessThanOrEqualTo(String value) {
            addCriterion("introduction_href <=", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefLike(String value) {
            addCriterion("introduction_href like", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefNotLike(String value) {
            addCriterion("introduction_href not like", value, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefIn(List<String> values) {
            addCriterion("introduction_href in", values, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefNotIn(List<String> values) {
            addCriterion("introduction_href not in", values, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefBetween(String value1, String value2) {
            addCriterion("introduction_href between", value1, value2, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andIntroduction_hrefNotBetween(String value1, String value2) {
            addCriterion("introduction_href not between", value1, value2, "introduction_href");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeleted_atEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atLessThan(Date value) {
            addCriterion("deleted_at <", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deleted_at");
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