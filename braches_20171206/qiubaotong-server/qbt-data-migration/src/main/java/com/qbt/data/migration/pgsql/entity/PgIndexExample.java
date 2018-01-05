package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgIndexExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgIndexExample() {
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

        public Criteria andIndexrelidIsNull() {
            addCriterion("indexrelid is null");
            return (Criteria) this;
        }

        public Criteria andIndexrelidIsNotNull() {
            addCriterion("indexrelid is not null");
            return (Criteria) this;
        }

        public Criteria andIndexrelidEqualTo(Long value) {
            addCriterion("indexrelid =", value, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidNotEqualTo(Long value) {
            addCriterion("indexrelid <>", value, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidGreaterThan(Long value) {
            addCriterion("indexrelid >", value, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("indexrelid >=", value, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidLessThan(Long value) {
            addCriterion("indexrelid <", value, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidLessThanOrEqualTo(Long value) {
            addCriterion("indexrelid <=", value, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidIn(List<Long> values) {
            addCriterion("indexrelid in", values, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidNotIn(List<Long> values) {
            addCriterion("indexrelid not in", values, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidBetween(Long value1, Long value2) {
            addCriterion("indexrelid between", value1, value2, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndexrelidNotBetween(Long value1, Long value2) {
            addCriterion("indexrelid not between", value1, value2, "indexrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidIsNull() {
            addCriterion("indrelid is null");
            return (Criteria) this;
        }

        public Criteria andIndrelidIsNotNull() {
            addCriterion("indrelid is not null");
            return (Criteria) this;
        }

        public Criteria andIndrelidEqualTo(Long value) {
            addCriterion("indrelid =", value, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidNotEqualTo(Long value) {
            addCriterion("indrelid <>", value, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidGreaterThan(Long value) {
            addCriterion("indrelid >", value, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("indrelid >=", value, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidLessThan(Long value) {
            addCriterion("indrelid <", value, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidLessThanOrEqualTo(Long value) {
            addCriterion("indrelid <=", value, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidIn(List<Long> values) {
            addCriterion("indrelid in", values, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidNotIn(List<Long> values) {
            addCriterion("indrelid not in", values, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidBetween(Long value1, Long value2) {
            addCriterion("indrelid between", value1, value2, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndrelidNotBetween(Long value1, Long value2) {
            addCriterion("indrelid not between", value1, value2, "indrelid");
            return (Criteria) this;
        }

        public Criteria andIndnattsIsNull() {
            addCriterion("indnatts is null");
            return (Criteria) this;
        }

        public Criteria andIndnattsIsNotNull() {
            addCriterion("indnatts is not null");
            return (Criteria) this;
        }

        public Criteria andIndnattsEqualTo(Short value) {
            addCriterion("indnatts =", value, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsNotEqualTo(Short value) {
            addCriterion("indnatts <>", value, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsGreaterThan(Short value) {
            addCriterion("indnatts >", value, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsGreaterThanOrEqualTo(Short value) {
            addCriterion("indnatts >=", value, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsLessThan(Short value) {
            addCriterion("indnatts <", value, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsLessThanOrEqualTo(Short value) {
            addCriterion("indnatts <=", value, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsIn(List<Short> values) {
            addCriterion("indnatts in", values, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsNotIn(List<Short> values) {
            addCriterion("indnatts not in", values, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsBetween(Short value1, Short value2) {
            addCriterion("indnatts between", value1, value2, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndnattsNotBetween(Short value1, Short value2) {
            addCriterion("indnatts not between", value1, value2, "indnatts");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueIsNull() {
            addCriterion("indisunique is null");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueIsNotNull() {
            addCriterion("indisunique is not null");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueEqualTo(Boolean value) {
            addCriterion("indisunique =", value, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueNotEqualTo(Boolean value) {
            addCriterion("indisunique <>", value, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueGreaterThan(Boolean value) {
            addCriterion("indisunique >", value, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indisunique >=", value, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueLessThan(Boolean value) {
            addCriterion("indisunique <", value, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueLessThanOrEqualTo(Boolean value) {
            addCriterion("indisunique <=", value, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueIn(List<Boolean> values) {
            addCriterion("indisunique in", values, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueNotIn(List<Boolean> values) {
            addCriterion("indisunique not in", values, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueBetween(Boolean value1, Boolean value2) {
            addCriterion("indisunique between", value1, value2, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisuniqueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indisunique not between", value1, value2, "indisunique");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryIsNull() {
            addCriterion("indisprimary is null");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryIsNotNull() {
            addCriterion("indisprimary is not null");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryEqualTo(Boolean value) {
            addCriterion("indisprimary =", value, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryNotEqualTo(Boolean value) {
            addCriterion("indisprimary <>", value, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryGreaterThan(Boolean value) {
            addCriterion("indisprimary >", value, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indisprimary >=", value, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryLessThan(Boolean value) {
            addCriterion("indisprimary <", value, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryLessThanOrEqualTo(Boolean value) {
            addCriterion("indisprimary <=", value, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryIn(List<Boolean> values) {
            addCriterion("indisprimary in", values, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryNotIn(List<Boolean> values) {
            addCriterion("indisprimary not in", values, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryBetween(Boolean value1, Boolean value2) {
            addCriterion("indisprimary between", value1, value2, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisprimaryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indisprimary not between", value1, value2, "indisprimary");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionIsNull() {
            addCriterion("indisexclusion is null");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionIsNotNull() {
            addCriterion("indisexclusion is not null");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionEqualTo(Boolean value) {
            addCriterion("indisexclusion =", value, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionNotEqualTo(Boolean value) {
            addCriterion("indisexclusion <>", value, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionGreaterThan(Boolean value) {
            addCriterion("indisexclusion >", value, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indisexclusion >=", value, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionLessThan(Boolean value) {
            addCriterion("indisexclusion <", value, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionLessThanOrEqualTo(Boolean value) {
            addCriterion("indisexclusion <=", value, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionIn(List<Boolean> values) {
            addCriterion("indisexclusion in", values, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionNotIn(List<Boolean> values) {
            addCriterion("indisexclusion not in", values, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionBetween(Boolean value1, Boolean value2) {
            addCriterion("indisexclusion between", value1, value2, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndisexclusionNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indisexclusion not between", value1, value2, "indisexclusion");
            return (Criteria) this;
        }

        public Criteria andIndimmediateIsNull() {
            addCriterion("indimmediate is null");
            return (Criteria) this;
        }

        public Criteria andIndimmediateIsNotNull() {
            addCriterion("indimmediate is not null");
            return (Criteria) this;
        }

        public Criteria andIndimmediateEqualTo(Boolean value) {
            addCriterion("indimmediate =", value, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateNotEqualTo(Boolean value) {
            addCriterion("indimmediate <>", value, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateGreaterThan(Boolean value) {
            addCriterion("indimmediate >", value, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indimmediate >=", value, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateLessThan(Boolean value) {
            addCriterion("indimmediate <", value, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateLessThanOrEqualTo(Boolean value) {
            addCriterion("indimmediate <=", value, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateIn(List<Boolean> values) {
            addCriterion("indimmediate in", values, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateNotIn(List<Boolean> values) {
            addCriterion("indimmediate not in", values, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateBetween(Boolean value1, Boolean value2) {
            addCriterion("indimmediate between", value1, value2, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndimmediateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indimmediate not between", value1, value2, "indimmediate");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredIsNull() {
            addCriterion("indisclustered is null");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredIsNotNull() {
            addCriterion("indisclustered is not null");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredEqualTo(Boolean value) {
            addCriterion("indisclustered =", value, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredNotEqualTo(Boolean value) {
            addCriterion("indisclustered <>", value, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredGreaterThan(Boolean value) {
            addCriterion("indisclustered >", value, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indisclustered >=", value, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredLessThan(Boolean value) {
            addCriterion("indisclustered <", value, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredLessThanOrEqualTo(Boolean value) {
            addCriterion("indisclustered <=", value, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredIn(List<Boolean> values) {
            addCriterion("indisclustered in", values, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredNotIn(List<Boolean> values) {
            addCriterion("indisclustered not in", values, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredBetween(Boolean value1, Boolean value2) {
            addCriterion("indisclustered between", value1, value2, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisclusteredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indisclustered not between", value1, value2, "indisclustered");
            return (Criteria) this;
        }

        public Criteria andIndisvalidIsNull() {
            addCriterion("indisvalid is null");
            return (Criteria) this;
        }

        public Criteria andIndisvalidIsNotNull() {
            addCriterion("indisvalid is not null");
            return (Criteria) this;
        }

        public Criteria andIndisvalidEqualTo(Boolean value) {
            addCriterion("indisvalid =", value, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidNotEqualTo(Boolean value) {
            addCriterion("indisvalid <>", value, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidGreaterThan(Boolean value) {
            addCriterion("indisvalid >", value, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indisvalid >=", value, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidLessThan(Boolean value) {
            addCriterion("indisvalid <", value, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidLessThanOrEqualTo(Boolean value) {
            addCriterion("indisvalid <=", value, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidIn(List<Boolean> values) {
            addCriterion("indisvalid in", values, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidNotIn(List<Boolean> values) {
            addCriterion("indisvalid not in", values, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidBetween(Boolean value1, Boolean value2) {
            addCriterion("indisvalid between", value1, value2, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndisvalidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indisvalid not between", value1, value2, "indisvalid");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminIsNull() {
            addCriterion("indcheckxmin is null");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminIsNotNull() {
            addCriterion("indcheckxmin is not null");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminEqualTo(Boolean value) {
            addCriterion("indcheckxmin =", value, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminNotEqualTo(Boolean value) {
            addCriterion("indcheckxmin <>", value, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminGreaterThan(Boolean value) {
            addCriterion("indcheckxmin >", value, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indcheckxmin >=", value, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminLessThan(Boolean value) {
            addCriterion("indcheckxmin <", value, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminLessThanOrEqualTo(Boolean value) {
            addCriterion("indcheckxmin <=", value, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminIn(List<Boolean> values) {
            addCriterion("indcheckxmin in", values, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminNotIn(List<Boolean> values) {
            addCriterion("indcheckxmin not in", values, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminBetween(Boolean value1, Boolean value2) {
            addCriterion("indcheckxmin between", value1, value2, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndcheckxminNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indcheckxmin not between", value1, value2, "indcheckxmin");
            return (Criteria) this;
        }

        public Criteria andIndisreadyIsNull() {
            addCriterion("indisready is null");
            return (Criteria) this;
        }

        public Criteria andIndisreadyIsNotNull() {
            addCriterion("indisready is not null");
            return (Criteria) this;
        }

        public Criteria andIndisreadyEqualTo(Boolean value) {
            addCriterion("indisready =", value, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyNotEqualTo(Boolean value) {
            addCriterion("indisready <>", value, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyGreaterThan(Boolean value) {
            addCriterion("indisready >", value, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("indisready >=", value, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyLessThan(Boolean value) {
            addCriterion("indisready <", value, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyLessThanOrEqualTo(Boolean value) {
            addCriterion("indisready <=", value, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyIn(List<Boolean> values) {
            addCriterion("indisready in", values, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyNotIn(List<Boolean> values) {
            addCriterion("indisready not in", values, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyBetween(Boolean value1, Boolean value2) {
            addCriterion("indisready between", value1, value2, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndisreadyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("indisready not between", value1, value2, "indisready");
            return (Criteria) this;
        }

        public Criteria andIndkeyIsNull() {
            addCriterion("indkey is null");
            return (Criteria) this;
        }

        public Criteria andIndkeyIsNotNull() {
            addCriterion("indkey is not null");
            return (Criteria) this;
        }

        public Criteria andIndkeyEqualTo(Object value) {
            addCriterion("indkey =", value, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyNotEqualTo(Object value) {
            addCriterion("indkey <>", value, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyGreaterThan(Object value) {
            addCriterion("indkey >", value, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyGreaterThanOrEqualTo(Object value) {
            addCriterion("indkey >=", value, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyLessThan(Object value) {
            addCriterion("indkey <", value, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyLessThanOrEqualTo(Object value) {
            addCriterion("indkey <=", value, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyIn(List<Object> values) {
            addCriterion("indkey in", values, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyNotIn(List<Object> values) {
            addCriterion("indkey not in", values, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyBetween(Object value1, Object value2) {
            addCriterion("indkey between", value1, value2, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndkeyNotBetween(Object value1, Object value2) {
            addCriterion("indkey not between", value1, value2, "indkey");
            return (Criteria) this;
        }

        public Criteria andIndcollationIsNull() {
            addCriterion("indcollation is null");
            return (Criteria) this;
        }

        public Criteria andIndcollationIsNotNull() {
            addCriterion("indcollation is not null");
            return (Criteria) this;
        }

        public Criteria andIndcollationEqualTo(Object value) {
            addCriterion("indcollation =", value, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationNotEqualTo(Object value) {
            addCriterion("indcollation <>", value, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationGreaterThan(Object value) {
            addCriterion("indcollation >", value, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationGreaterThanOrEqualTo(Object value) {
            addCriterion("indcollation >=", value, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationLessThan(Object value) {
            addCriterion("indcollation <", value, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationLessThanOrEqualTo(Object value) {
            addCriterion("indcollation <=", value, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationIn(List<Object> values) {
            addCriterion("indcollation in", values, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationNotIn(List<Object> values) {
            addCriterion("indcollation not in", values, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationBetween(Object value1, Object value2) {
            addCriterion("indcollation between", value1, value2, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndcollationNotBetween(Object value1, Object value2) {
            addCriterion("indcollation not between", value1, value2, "indcollation");
            return (Criteria) this;
        }

        public Criteria andIndclassIsNull() {
            addCriterion("indclass is null");
            return (Criteria) this;
        }

        public Criteria andIndclassIsNotNull() {
            addCriterion("indclass is not null");
            return (Criteria) this;
        }

        public Criteria andIndclassEqualTo(Object value) {
            addCriterion("indclass =", value, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassNotEqualTo(Object value) {
            addCriterion("indclass <>", value, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassGreaterThan(Object value) {
            addCriterion("indclass >", value, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassGreaterThanOrEqualTo(Object value) {
            addCriterion("indclass >=", value, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassLessThan(Object value) {
            addCriterion("indclass <", value, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassLessThanOrEqualTo(Object value) {
            addCriterion("indclass <=", value, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassIn(List<Object> values) {
            addCriterion("indclass in", values, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassNotIn(List<Object> values) {
            addCriterion("indclass not in", values, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassBetween(Object value1, Object value2) {
            addCriterion("indclass between", value1, value2, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndclassNotBetween(Object value1, Object value2) {
            addCriterion("indclass not between", value1, value2, "indclass");
            return (Criteria) this;
        }

        public Criteria andIndoptionIsNull() {
            addCriterion("indoption is null");
            return (Criteria) this;
        }

        public Criteria andIndoptionIsNotNull() {
            addCriterion("indoption is not null");
            return (Criteria) this;
        }

        public Criteria andIndoptionEqualTo(Object value) {
            addCriterion("indoption =", value, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionNotEqualTo(Object value) {
            addCriterion("indoption <>", value, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionGreaterThan(Object value) {
            addCriterion("indoption >", value, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionGreaterThanOrEqualTo(Object value) {
            addCriterion("indoption >=", value, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionLessThan(Object value) {
            addCriterion("indoption <", value, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionLessThanOrEqualTo(Object value) {
            addCriterion("indoption <=", value, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionIn(List<Object> values) {
            addCriterion("indoption in", values, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionNotIn(List<Object> values) {
            addCriterion("indoption not in", values, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionBetween(Object value1, Object value2) {
            addCriterion("indoption between", value1, value2, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndoptionNotBetween(Object value1, Object value2) {
            addCriterion("indoption not between", value1, value2, "indoption");
            return (Criteria) this;
        }

        public Criteria andIndexprsIsNull() {
            addCriterion("indexprs is null");
            return (Criteria) this;
        }

        public Criteria andIndexprsIsNotNull() {
            addCriterion("indexprs is not null");
            return (Criteria) this;
        }

        public Criteria andIndexprsEqualTo(Object value) {
            addCriterion("indexprs =", value, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsNotEqualTo(Object value) {
            addCriterion("indexprs <>", value, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsGreaterThan(Object value) {
            addCriterion("indexprs >", value, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsGreaterThanOrEqualTo(Object value) {
            addCriterion("indexprs >=", value, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsLessThan(Object value) {
            addCriterion("indexprs <", value, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsLessThanOrEqualTo(Object value) {
            addCriterion("indexprs <=", value, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsIn(List<Object> values) {
            addCriterion("indexprs in", values, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsNotIn(List<Object> values) {
            addCriterion("indexprs not in", values, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsBetween(Object value1, Object value2) {
            addCriterion("indexprs between", value1, value2, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndexprsNotBetween(Object value1, Object value2) {
            addCriterion("indexprs not between", value1, value2, "indexprs");
            return (Criteria) this;
        }

        public Criteria andIndpredIsNull() {
            addCriterion("indpred is null");
            return (Criteria) this;
        }

        public Criteria andIndpredIsNotNull() {
            addCriterion("indpred is not null");
            return (Criteria) this;
        }

        public Criteria andIndpredEqualTo(Object value) {
            addCriterion("indpred =", value, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredNotEqualTo(Object value) {
            addCriterion("indpred <>", value, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredGreaterThan(Object value) {
            addCriterion("indpred >", value, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredGreaterThanOrEqualTo(Object value) {
            addCriterion("indpred >=", value, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredLessThan(Object value) {
            addCriterion("indpred <", value, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredLessThanOrEqualTo(Object value) {
            addCriterion("indpred <=", value, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredIn(List<Object> values) {
            addCriterion("indpred in", values, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredNotIn(List<Object> values) {
            addCriterion("indpred not in", values, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredBetween(Object value1, Object value2) {
            addCriterion("indpred between", value1, value2, "indpred");
            return (Criteria) this;
        }

        public Criteria andIndpredNotBetween(Object value1, Object value2) {
            addCriterion("indpred not between", value1, value2, "indpred");
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