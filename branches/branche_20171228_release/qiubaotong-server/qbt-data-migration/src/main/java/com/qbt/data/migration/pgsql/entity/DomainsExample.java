package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class DomainsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DomainsExample() {
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

        public Criteria andDomain_catalogIsNull() {
            addCriterion("domain_catalog is null");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogIsNotNull() {
            addCriterion("domain_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogEqualTo(Object value) {
            addCriterion("domain_catalog =", value, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogNotEqualTo(Object value) {
            addCriterion("domain_catalog <>", value, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogGreaterThan(Object value) {
            addCriterion("domain_catalog >", value, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("domain_catalog >=", value, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogLessThan(Object value) {
            addCriterion("domain_catalog <", value, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogLessThanOrEqualTo(Object value) {
            addCriterion("domain_catalog <=", value, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogIn(List<Object> values) {
            addCriterion("domain_catalog in", values, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogNotIn(List<Object> values) {
            addCriterion("domain_catalog not in", values, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogBetween(Object value1, Object value2) {
            addCriterion("domain_catalog between", value1, value2, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_catalogNotBetween(Object value1, Object value2) {
            addCriterion("domain_catalog not between", value1, value2, "domain_catalog");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaIsNull() {
            addCriterion("domain_schema is null");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaIsNotNull() {
            addCriterion("domain_schema is not null");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaEqualTo(Object value) {
            addCriterion("domain_schema =", value, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaNotEqualTo(Object value) {
            addCriterion("domain_schema <>", value, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaGreaterThan(Object value) {
            addCriterion("domain_schema >", value, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("domain_schema >=", value, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaLessThan(Object value) {
            addCriterion("domain_schema <", value, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaLessThanOrEqualTo(Object value) {
            addCriterion("domain_schema <=", value, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaIn(List<Object> values) {
            addCriterion("domain_schema in", values, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaNotIn(List<Object> values) {
            addCriterion("domain_schema not in", values, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaBetween(Object value1, Object value2) {
            addCriterion("domain_schema between", value1, value2, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_schemaNotBetween(Object value1, Object value2) {
            addCriterion("domain_schema not between", value1, value2, "domain_schema");
            return (Criteria) this;
        }

        public Criteria andDomain_nameIsNull() {
            addCriterion("domain_name is null");
            return (Criteria) this;
        }

        public Criteria andDomain_nameIsNotNull() {
            addCriterion("domain_name is not null");
            return (Criteria) this;
        }

        public Criteria andDomain_nameEqualTo(Object value) {
            addCriterion("domain_name =", value, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameNotEqualTo(Object value) {
            addCriterion("domain_name <>", value, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameGreaterThan(Object value) {
            addCriterion("domain_name >", value, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("domain_name >=", value, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameLessThan(Object value) {
            addCriterion("domain_name <", value, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameLessThanOrEqualTo(Object value) {
            addCriterion("domain_name <=", value, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameIn(List<Object> values) {
            addCriterion("domain_name in", values, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameNotIn(List<Object> values) {
            addCriterion("domain_name not in", values, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameBetween(Object value1, Object value2) {
            addCriterion("domain_name between", value1, value2, "domain_name");
            return (Criteria) this;
        }

        public Criteria andDomain_nameNotBetween(Object value1, Object value2) {
            addCriterion("domain_name not between", value1, value2, "domain_name");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andData_typeEqualTo(Object value) {
            addCriterion("data_type =", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotEqualTo(Object value) {
            addCriterion("data_type <>", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThan(Object value) {
            addCriterion("data_type >", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("data_type >=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThan(Object value) {
            addCriterion("data_type <", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThanOrEqualTo(Object value) {
            addCriterion("data_type <=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeIn(List<Object> values) {
            addCriterion("data_type in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotIn(List<Object> values) {
            addCriterion("data_type not in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeBetween(Object value1, Object value2) {
            addCriterion("data_type between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotBetween(Object value1, Object value2) {
            addCriterion("data_type not between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthIsNull() {
            addCriterion("character_maximum_length is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthIsNotNull() {
            addCriterion("character_maximum_length is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthEqualTo(Object value) {
            addCriterion("character_maximum_length =", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthNotEqualTo(Object value) {
            addCriterion("character_maximum_length <>", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthGreaterThan(Object value) {
            addCriterion("character_maximum_length >", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthGreaterThanOrEqualTo(Object value) {
            addCriterion("character_maximum_length >=", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthLessThan(Object value) {
            addCriterion("character_maximum_length <", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthLessThanOrEqualTo(Object value) {
            addCriterion("character_maximum_length <=", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthIn(List<Object> values) {
            addCriterion("character_maximum_length in", values, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthNotIn(List<Object> values) {
            addCriterion("character_maximum_length not in", values, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthBetween(Object value1, Object value2) {
            addCriterion("character_maximum_length between", value1, value2, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthNotBetween(Object value1, Object value2) {
            addCriterion("character_maximum_length not between", value1, value2, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthIsNull() {
            addCriterion("character_octet_length is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthIsNotNull() {
            addCriterion("character_octet_length is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthEqualTo(Object value) {
            addCriterion("character_octet_length =", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthNotEqualTo(Object value) {
            addCriterion("character_octet_length <>", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthGreaterThan(Object value) {
            addCriterion("character_octet_length >", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthGreaterThanOrEqualTo(Object value) {
            addCriterion("character_octet_length >=", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthLessThan(Object value) {
            addCriterion("character_octet_length <", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthLessThanOrEqualTo(Object value) {
            addCriterion("character_octet_length <=", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthIn(List<Object> values) {
            addCriterion("character_octet_length in", values, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthNotIn(List<Object> values) {
            addCriterion("character_octet_length not in", values, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthBetween(Object value1, Object value2) {
            addCriterion("character_octet_length between", value1, value2, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthNotBetween(Object value1, Object value2) {
            addCriterion("character_octet_length not between", value1, value2, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogIsNull() {
            addCriterion("character_set_catalog is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogIsNotNull() {
            addCriterion("character_set_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogEqualTo(Object value) {
            addCriterion("character_set_catalog =", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogNotEqualTo(Object value) {
            addCriterion("character_set_catalog <>", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogGreaterThan(Object value) {
            addCriterion("character_set_catalog >", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("character_set_catalog >=", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogLessThan(Object value) {
            addCriterion("character_set_catalog <", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogLessThanOrEqualTo(Object value) {
            addCriterion("character_set_catalog <=", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogIn(List<Object> values) {
            addCriterion("character_set_catalog in", values, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogNotIn(List<Object> values) {
            addCriterion("character_set_catalog not in", values, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogBetween(Object value1, Object value2) {
            addCriterion("character_set_catalog between", value1, value2, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogNotBetween(Object value1, Object value2) {
            addCriterion("character_set_catalog not between", value1, value2, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaIsNull() {
            addCriterion("character_set_schema is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaIsNotNull() {
            addCriterion("character_set_schema is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaEqualTo(Object value) {
            addCriterion("character_set_schema =", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaNotEqualTo(Object value) {
            addCriterion("character_set_schema <>", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaGreaterThan(Object value) {
            addCriterion("character_set_schema >", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("character_set_schema >=", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaLessThan(Object value) {
            addCriterion("character_set_schema <", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaLessThanOrEqualTo(Object value) {
            addCriterion("character_set_schema <=", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaIn(List<Object> values) {
            addCriterion("character_set_schema in", values, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaNotIn(List<Object> values) {
            addCriterion("character_set_schema not in", values, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaBetween(Object value1, Object value2) {
            addCriterion("character_set_schema between", value1, value2, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaNotBetween(Object value1, Object value2) {
            addCriterion("character_set_schema not between", value1, value2, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameIsNull() {
            addCriterion("character_set_name is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameIsNotNull() {
            addCriterion("character_set_name is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameEqualTo(Object value) {
            addCriterion("character_set_name =", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameNotEqualTo(Object value) {
            addCriterion("character_set_name <>", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameGreaterThan(Object value) {
            addCriterion("character_set_name >", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("character_set_name >=", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameLessThan(Object value) {
            addCriterion("character_set_name <", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameLessThanOrEqualTo(Object value) {
            addCriterion("character_set_name <=", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameIn(List<Object> values) {
            addCriterion("character_set_name in", values, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameNotIn(List<Object> values) {
            addCriterion("character_set_name not in", values, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameBetween(Object value1, Object value2) {
            addCriterion("character_set_name between", value1, value2, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameNotBetween(Object value1, Object value2) {
            addCriterion("character_set_name not between", value1, value2, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogIsNull() {
            addCriterion("collation_catalog is null");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogIsNotNull() {
            addCriterion("collation_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogEqualTo(Object value) {
            addCriterion("collation_catalog =", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogNotEqualTo(Object value) {
            addCriterion("collation_catalog <>", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogGreaterThan(Object value) {
            addCriterion("collation_catalog >", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("collation_catalog >=", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogLessThan(Object value) {
            addCriterion("collation_catalog <", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogLessThanOrEqualTo(Object value) {
            addCriterion("collation_catalog <=", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogIn(List<Object> values) {
            addCriterion("collation_catalog in", values, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogNotIn(List<Object> values) {
            addCriterion("collation_catalog not in", values, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogBetween(Object value1, Object value2) {
            addCriterion("collation_catalog between", value1, value2, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogNotBetween(Object value1, Object value2) {
            addCriterion("collation_catalog not between", value1, value2, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaIsNull() {
            addCriterion("collation_schema is null");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaIsNotNull() {
            addCriterion("collation_schema is not null");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaEqualTo(Object value) {
            addCriterion("collation_schema =", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaNotEqualTo(Object value) {
            addCriterion("collation_schema <>", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaGreaterThan(Object value) {
            addCriterion("collation_schema >", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("collation_schema >=", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaLessThan(Object value) {
            addCriterion("collation_schema <", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaLessThanOrEqualTo(Object value) {
            addCriterion("collation_schema <=", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaIn(List<Object> values) {
            addCriterion("collation_schema in", values, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaNotIn(List<Object> values) {
            addCriterion("collation_schema not in", values, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaBetween(Object value1, Object value2) {
            addCriterion("collation_schema between", value1, value2, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaNotBetween(Object value1, Object value2) {
            addCriterion("collation_schema not between", value1, value2, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_nameIsNull() {
            addCriterion("collation_name is null");
            return (Criteria) this;
        }

        public Criteria andCollation_nameIsNotNull() {
            addCriterion("collation_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollation_nameEqualTo(Object value) {
            addCriterion("collation_name =", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameNotEqualTo(Object value) {
            addCriterion("collation_name <>", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameGreaterThan(Object value) {
            addCriterion("collation_name >", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("collation_name >=", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameLessThan(Object value) {
            addCriterion("collation_name <", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameLessThanOrEqualTo(Object value) {
            addCriterion("collation_name <=", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameIn(List<Object> values) {
            addCriterion("collation_name in", values, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameNotIn(List<Object> values) {
            addCriterion("collation_name not in", values, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameBetween(Object value1, Object value2) {
            addCriterion("collation_name between", value1, value2, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameNotBetween(Object value1, Object value2) {
            addCriterion("collation_name not between", value1, value2, "collation_name");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionIsNull() {
            addCriterion("numeric_precision is null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionIsNotNull() {
            addCriterion("numeric_precision is not null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionEqualTo(Object value) {
            addCriterion("numeric_precision =", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionNotEqualTo(Object value) {
            addCriterion("numeric_precision <>", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionGreaterThan(Object value) {
            addCriterion("numeric_precision >", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("numeric_precision >=", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionLessThan(Object value) {
            addCriterion("numeric_precision <", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionLessThanOrEqualTo(Object value) {
            addCriterion("numeric_precision <=", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionIn(List<Object> values) {
            addCriterion("numeric_precision in", values, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionNotIn(List<Object> values) {
            addCriterion("numeric_precision not in", values, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionBetween(Object value1, Object value2) {
            addCriterion("numeric_precision between", value1, value2, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionNotBetween(Object value1, Object value2) {
            addCriterion("numeric_precision not between", value1, value2, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixIsNull() {
            addCriterion("numeric_precision_radix is null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixIsNotNull() {
            addCriterion("numeric_precision_radix is not null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixEqualTo(Object value) {
            addCriterion("numeric_precision_radix =", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixNotEqualTo(Object value) {
            addCriterion("numeric_precision_radix <>", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixGreaterThan(Object value) {
            addCriterion("numeric_precision_radix >", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixGreaterThanOrEqualTo(Object value) {
            addCriterion("numeric_precision_radix >=", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixLessThan(Object value) {
            addCriterion("numeric_precision_radix <", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixLessThanOrEqualTo(Object value) {
            addCriterion("numeric_precision_radix <=", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixIn(List<Object> values) {
            addCriterion("numeric_precision_radix in", values, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixNotIn(List<Object> values) {
            addCriterion("numeric_precision_radix not in", values, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixBetween(Object value1, Object value2) {
            addCriterion("numeric_precision_radix between", value1, value2, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixNotBetween(Object value1, Object value2) {
            addCriterion("numeric_precision_radix not between", value1, value2, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleIsNull() {
            addCriterion("numeric_scale is null");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleIsNotNull() {
            addCriterion("numeric_scale is not null");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleEqualTo(Object value) {
            addCriterion("numeric_scale =", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleNotEqualTo(Object value) {
            addCriterion("numeric_scale <>", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleGreaterThan(Object value) {
            addCriterion("numeric_scale >", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleGreaterThanOrEqualTo(Object value) {
            addCriterion("numeric_scale >=", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleLessThan(Object value) {
            addCriterion("numeric_scale <", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleLessThanOrEqualTo(Object value) {
            addCriterion("numeric_scale <=", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleIn(List<Object> values) {
            addCriterion("numeric_scale in", values, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleNotIn(List<Object> values) {
            addCriterion("numeric_scale not in", values, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleBetween(Object value1, Object value2) {
            addCriterion("numeric_scale between", value1, value2, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleNotBetween(Object value1, Object value2) {
            addCriterion("numeric_scale not between", value1, value2, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionIsNull() {
            addCriterion("datetime_precision is null");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionIsNotNull() {
            addCriterion("datetime_precision is not null");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionEqualTo(Object value) {
            addCriterion("datetime_precision =", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionNotEqualTo(Object value) {
            addCriterion("datetime_precision <>", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionGreaterThan(Object value) {
            addCriterion("datetime_precision >", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("datetime_precision >=", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionLessThan(Object value) {
            addCriterion("datetime_precision <", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionLessThanOrEqualTo(Object value) {
            addCriterion("datetime_precision <=", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionIn(List<Object> values) {
            addCriterion("datetime_precision in", values, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionNotIn(List<Object> values) {
            addCriterion("datetime_precision not in", values, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionBetween(Object value1, Object value2) {
            addCriterion("datetime_precision between", value1, value2, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionNotBetween(Object value1, Object value2) {
            addCriterion("datetime_precision not between", value1, value2, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_typeIsNull() {
            addCriterion("interval_type is null");
            return (Criteria) this;
        }

        public Criteria andInterval_typeIsNotNull() {
            addCriterion("interval_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterval_typeEqualTo(Object value) {
            addCriterion("interval_type =", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeNotEqualTo(Object value) {
            addCriterion("interval_type <>", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeGreaterThan(Object value) {
            addCriterion("interval_type >", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("interval_type >=", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeLessThan(Object value) {
            addCriterion("interval_type <", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeLessThanOrEqualTo(Object value) {
            addCriterion("interval_type <=", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeIn(List<Object> values) {
            addCriterion("interval_type in", values, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeNotIn(List<Object> values) {
            addCriterion("interval_type not in", values, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeBetween(Object value1, Object value2) {
            addCriterion("interval_type between", value1, value2, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeNotBetween(Object value1, Object value2) {
            addCriterion("interval_type not between", value1, value2, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionIsNull() {
            addCriterion("interval_precision is null");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionIsNotNull() {
            addCriterion("interval_precision is not null");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionEqualTo(Object value) {
            addCriterion("interval_precision =", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionNotEqualTo(Object value) {
            addCriterion("interval_precision <>", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionGreaterThan(Object value) {
            addCriterion("interval_precision >", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("interval_precision >=", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionLessThan(Object value) {
            addCriterion("interval_precision <", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionLessThanOrEqualTo(Object value) {
            addCriterion("interval_precision <=", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionIn(List<Object> values) {
            addCriterion("interval_precision in", values, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionNotIn(List<Object> values) {
            addCriterion("interval_precision not in", values, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionBetween(Object value1, Object value2) {
            addCriterion("interval_precision between", value1, value2, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionNotBetween(Object value1, Object value2) {
            addCriterion("interval_precision not between", value1, value2, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultIsNull() {
            addCriterion("domain_default is null");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultIsNotNull() {
            addCriterion("domain_default is not null");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultEqualTo(Object value) {
            addCriterion("domain_default =", value, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultNotEqualTo(Object value) {
            addCriterion("domain_default <>", value, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultGreaterThan(Object value) {
            addCriterion("domain_default >", value, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultGreaterThanOrEqualTo(Object value) {
            addCriterion("domain_default >=", value, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultLessThan(Object value) {
            addCriterion("domain_default <", value, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultLessThanOrEqualTo(Object value) {
            addCriterion("domain_default <=", value, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultIn(List<Object> values) {
            addCriterion("domain_default in", values, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultNotIn(List<Object> values) {
            addCriterion("domain_default not in", values, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultBetween(Object value1, Object value2) {
            addCriterion("domain_default between", value1, value2, "domain_default");
            return (Criteria) this;
        }

        public Criteria andDomain_defaultNotBetween(Object value1, Object value2) {
            addCriterion("domain_default not between", value1, value2, "domain_default");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogIsNull() {
            addCriterion("udt_catalog is null");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogIsNotNull() {
            addCriterion("udt_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogEqualTo(Object value) {
            addCriterion("udt_catalog =", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogNotEqualTo(Object value) {
            addCriterion("udt_catalog <>", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogGreaterThan(Object value) {
            addCriterion("udt_catalog >", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("udt_catalog >=", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogLessThan(Object value) {
            addCriterion("udt_catalog <", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogLessThanOrEqualTo(Object value) {
            addCriterion("udt_catalog <=", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogIn(List<Object> values) {
            addCriterion("udt_catalog in", values, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogNotIn(List<Object> values) {
            addCriterion("udt_catalog not in", values, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogBetween(Object value1, Object value2) {
            addCriterion("udt_catalog between", value1, value2, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogNotBetween(Object value1, Object value2) {
            addCriterion("udt_catalog not between", value1, value2, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaIsNull() {
            addCriterion("udt_schema is null");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaIsNotNull() {
            addCriterion("udt_schema is not null");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaEqualTo(Object value) {
            addCriterion("udt_schema =", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaNotEqualTo(Object value) {
            addCriterion("udt_schema <>", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaGreaterThan(Object value) {
            addCriterion("udt_schema >", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("udt_schema >=", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaLessThan(Object value) {
            addCriterion("udt_schema <", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaLessThanOrEqualTo(Object value) {
            addCriterion("udt_schema <=", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaIn(List<Object> values) {
            addCriterion("udt_schema in", values, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaNotIn(List<Object> values) {
            addCriterion("udt_schema not in", values, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaBetween(Object value1, Object value2) {
            addCriterion("udt_schema between", value1, value2, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaNotBetween(Object value1, Object value2) {
            addCriterion("udt_schema not between", value1, value2, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_nameIsNull() {
            addCriterion("udt_name is null");
            return (Criteria) this;
        }

        public Criteria andUdt_nameIsNotNull() {
            addCriterion("udt_name is not null");
            return (Criteria) this;
        }

        public Criteria andUdt_nameEqualTo(Object value) {
            addCriterion("udt_name =", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameNotEqualTo(Object value) {
            addCriterion("udt_name <>", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameGreaterThan(Object value) {
            addCriterion("udt_name >", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("udt_name >=", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameLessThan(Object value) {
            addCriterion("udt_name <", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameLessThanOrEqualTo(Object value) {
            addCriterion("udt_name <=", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameIn(List<Object> values) {
            addCriterion("udt_name in", values, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameNotIn(List<Object> values) {
            addCriterion("udt_name not in", values, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameBetween(Object value1, Object value2) {
            addCriterion("udt_name between", value1, value2, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameNotBetween(Object value1, Object value2) {
            addCriterion("udt_name not between", value1, value2, "udt_name");
            return (Criteria) this;
        }

        public Criteria andScope_catalogIsNull() {
            addCriterion("scope_catalog is null");
            return (Criteria) this;
        }

        public Criteria andScope_catalogIsNotNull() {
            addCriterion("scope_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andScope_catalogEqualTo(Object value) {
            addCriterion("scope_catalog =", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogNotEqualTo(Object value) {
            addCriterion("scope_catalog <>", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogGreaterThan(Object value) {
            addCriterion("scope_catalog >", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("scope_catalog >=", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogLessThan(Object value) {
            addCriterion("scope_catalog <", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogLessThanOrEqualTo(Object value) {
            addCriterion("scope_catalog <=", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogIn(List<Object> values) {
            addCriterion("scope_catalog in", values, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogNotIn(List<Object> values) {
            addCriterion("scope_catalog not in", values, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogBetween(Object value1, Object value2) {
            addCriterion("scope_catalog between", value1, value2, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogNotBetween(Object value1, Object value2) {
            addCriterion("scope_catalog not between", value1, value2, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_schemaIsNull() {
            addCriterion("scope_schema is null");
            return (Criteria) this;
        }

        public Criteria andScope_schemaIsNotNull() {
            addCriterion("scope_schema is not null");
            return (Criteria) this;
        }

        public Criteria andScope_schemaEqualTo(Object value) {
            addCriterion("scope_schema =", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaNotEqualTo(Object value) {
            addCriterion("scope_schema <>", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaGreaterThan(Object value) {
            addCriterion("scope_schema >", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("scope_schema >=", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaLessThan(Object value) {
            addCriterion("scope_schema <", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaLessThanOrEqualTo(Object value) {
            addCriterion("scope_schema <=", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaIn(List<Object> values) {
            addCriterion("scope_schema in", values, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaNotIn(List<Object> values) {
            addCriterion("scope_schema not in", values, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaBetween(Object value1, Object value2) {
            addCriterion("scope_schema between", value1, value2, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaNotBetween(Object value1, Object value2) {
            addCriterion("scope_schema not between", value1, value2, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_nameIsNull() {
            addCriterion("scope_name is null");
            return (Criteria) this;
        }

        public Criteria andScope_nameIsNotNull() {
            addCriterion("scope_name is not null");
            return (Criteria) this;
        }

        public Criteria andScope_nameEqualTo(Object value) {
            addCriterion("scope_name =", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameNotEqualTo(Object value) {
            addCriterion("scope_name <>", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameGreaterThan(Object value) {
            addCriterion("scope_name >", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("scope_name >=", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameLessThan(Object value) {
            addCriterion("scope_name <", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameLessThanOrEqualTo(Object value) {
            addCriterion("scope_name <=", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameIn(List<Object> values) {
            addCriterion("scope_name in", values, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameNotIn(List<Object> values) {
            addCriterion("scope_name not in", values, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameBetween(Object value1, Object value2) {
            addCriterion("scope_name between", value1, value2, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameNotBetween(Object value1, Object value2) {
            addCriterion("scope_name not between", value1, value2, "scope_name");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityIsNull() {
            addCriterion("maximum_cardinality is null");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityIsNotNull() {
            addCriterion("maximum_cardinality is not null");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityEqualTo(Object value) {
            addCriterion("maximum_cardinality =", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityNotEqualTo(Object value) {
            addCriterion("maximum_cardinality <>", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityGreaterThan(Object value) {
            addCriterion("maximum_cardinality >", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityGreaterThanOrEqualTo(Object value) {
            addCriterion("maximum_cardinality >=", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityLessThan(Object value) {
            addCriterion("maximum_cardinality <", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityLessThanOrEqualTo(Object value) {
            addCriterion("maximum_cardinality <=", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityIn(List<Object> values) {
            addCriterion("maximum_cardinality in", values, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityNotIn(List<Object> values) {
            addCriterion("maximum_cardinality not in", values, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityBetween(Object value1, Object value2) {
            addCriterion("maximum_cardinality between", value1, value2, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityNotBetween(Object value1, Object value2) {
            addCriterion("maximum_cardinality not between", value1, value2, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIsNull() {
            addCriterion("dtd_identifier is null");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIsNotNull() {
            addCriterion("dtd_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierEqualTo(Object value) {
            addCriterion("dtd_identifier =", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotEqualTo(Object value) {
            addCriterion("dtd_identifier <>", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierGreaterThan(Object value) {
            addCriterion("dtd_identifier >", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("dtd_identifier >=", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierLessThan(Object value) {
            addCriterion("dtd_identifier <", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierLessThanOrEqualTo(Object value) {
            addCriterion("dtd_identifier <=", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIn(List<Object> values) {
            addCriterion("dtd_identifier in", values, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotIn(List<Object> values) {
            addCriterion("dtd_identifier not in", values, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierBetween(Object value1, Object value2) {
            addCriterion("dtd_identifier between", value1, value2, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotBetween(Object value1, Object value2) {
            addCriterion("dtd_identifier not between", value1, value2, "dtd_identifier");
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