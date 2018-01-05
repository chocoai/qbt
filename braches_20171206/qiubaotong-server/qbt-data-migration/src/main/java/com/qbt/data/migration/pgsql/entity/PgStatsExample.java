package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatsExample() {
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

        public Criteria andSchemanameIsNull() {
            addCriterion("schemaname is null");
            return (Criteria) this;
        }

        public Criteria andSchemanameIsNotNull() {
            addCriterion("schemaname is not null");
            return (Criteria) this;
        }

        public Criteria andSchemanameEqualTo(String value) {
            addCriterion("schemaname =", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotEqualTo(String value) {
            addCriterion("schemaname <>", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThan(String value) {
            addCriterion("schemaname >", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThanOrEqualTo(String value) {
            addCriterion("schemaname >=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThan(String value) {
            addCriterion("schemaname <", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThanOrEqualTo(String value) {
            addCriterion("schemaname <=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLike(String value) {
            addCriterion("schemaname like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotLike(String value) {
            addCriterion("schemaname not like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameIn(List<String> values) {
            addCriterion("schemaname in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotIn(List<String> values) {
            addCriterion("schemaname not in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameBetween(String value1, String value2) {
            addCriterion("schemaname between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotBetween(String value1, String value2) {
            addCriterion("schemaname not between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andAttnameIsNull() {
            addCriterion("attname is null");
            return (Criteria) this;
        }

        public Criteria andAttnameIsNotNull() {
            addCriterion("attname is not null");
            return (Criteria) this;
        }

        public Criteria andAttnameEqualTo(String value) {
            addCriterion("attname =", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotEqualTo(String value) {
            addCriterion("attname <>", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameGreaterThan(String value) {
            addCriterion("attname >", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameGreaterThanOrEqualTo(String value) {
            addCriterion("attname >=", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLessThan(String value) {
            addCriterion("attname <", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLessThanOrEqualTo(String value) {
            addCriterion("attname <=", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLike(String value) {
            addCriterion("attname like", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotLike(String value) {
            addCriterion("attname not like", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameIn(List<String> values) {
            addCriterion("attname in", values, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotIn(List<String> values) {
            addCriterion("attname not in", values, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameBetween(String value1, String value2) {
            addCriterion("attname between", value1, value2, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotBetween(String value1, String value2) {
            addCriterion("attname not between", value1, value2, "attname");
            return (Criteria) this;
        }

        public Criteria andInheritedIsNull() {
            addCriterion("inherited is null");
            return (Criteria) this;
        }

        public Criteria andInheritedIsNotNull() {
            addCriterion("inherited is not null");
            return (Criteria) this;
        }

        public Criteria andInheritedEqualTo(Boolean value) {
            addCriterion("inherited =", value, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedNotEqualTo(Boolean value) {
            addCriterion("inherited <>", value, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedGreaterThan(Boolean value) {
            addCriterion("inherited >", value, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("inherited >=", value, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedLessThan(Boolean value) {
            addCriterion("inherited <", value, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedLessThanOrEqualTo(Boolean value) {
            addCriterion("inherited <=", value, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedIn(List<Boolean> values) {
            addCriterion("inherited in", values, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedNotIn(List<Boolean> values) {
            addCriterion("inherited not in", values, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedBetween(Boolean value1, Boolean value2) {
            addCriterion("inherited between", value1, value2, "inherited");
            return (Criteria) this;
        }

        public Criteria andInheritedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("inherited not between", value1, value2, "inherited");
            return (Criteria) this;
        }

        public Criteria andNull_fracIsNull() {
            addCriterion("null_frac is null");
            return (Criteria) this;
        }

        public Criteria andNull_fracIsNotNull() {
            addCriterion("null_frac is not null");
            return (Criteria) this;
        }

        public Criteria andNull_fracEqualTo(Float value) {
            addCriterion("null_frac =", value, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracNotEqualTo(Float value) {
            addCriterion("null_frac <>", value, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracGreaterThan(Float value) {
            addCriterion("null_frac >", value, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracGreaterThanOrEqualTo(Float value) {
            addCriterion("null_frac >=", value, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracLessThan(Float value) {
            addCriterion("null_frac <", value, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracLessThanOrEqualTo(Float value) {
            addCriterion("null_frac <=", value, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracIn(List<Float> values) {
            addCriterion("null_frac in", values, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracNotIn(List<Float> values) {
            addCriterion("null_frac not in", values, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracBetween(Float value1, Float value2) {
            addCriterion("null_frac between", value1, value2, "null_frac");
            return (Criteria) this;
        }

        public Criteria andNull_fracNotBetween(Float value1, Float value2) {
            addCriterion("null_frac not between", value1, value2, "null_frac");
            return (Criteria) this;
        }

        public Criteria andAvg_widthIsNull() {
            addCriterion("avg_width is null");
            return (Criteria) this;
        }

        public Criteria andAvg_widthIsNotNull() {
            addCriterion("avg_width is not null");
            return (Criteria) this;
        }

        public Criteria andAvg_widthEqualTo(Integer value) {
            addCriterion("avg_width =", value, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthNotEqualTo(Integer value) {
            addCriterion("avg_width <>", value, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthGreaterThan(Integer value) {
            addCriterion("avg_width >", value, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthGreaterThanOrEqualTo(Integer value) {
            addCriterion("avg_width >=", value, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthLessThan(Integer value) {
            addCriterion("avg_width <", value, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthLessThanOrEqualTo(Integer value) {
            addCriterion("avg_width <=", value, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthIn(List<Integer> values) {
            addCriterion("avg_width in", values, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthNotIn(List<Integer> values) {
            addCriterion("avg_width not in", values, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthBetween(Integer value1, Integer value2) {
            addCriterion("avg_width between", value1, value2, "avg_width");
            return (Criteria) this;
        }

        public Criteria andAvg_widthNotBetween(Integer value1, Integer value2) {
            addCriterion("avg_width not between", value1, value2, "avg_width");
            return (Criteria) this;
        }

        public Criteria andN_distinctIsNull() {
            addCriterion("n_distinct is null");
            return (Criteria) this;
        }

        public Criteria andN_distinctIsNotNull() {
            addCriterion("n_distinct is not null");
            return (Criteria) this;
        }

        public Criteria andN_distinctEqualTo(Float value) {
            addCriterion("n_distinct =", value, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctNotEqualTo(Float value) {
            addCriterion("n_distinct <>", value, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctGreaterThan(Float value) {
            addCriterion("n_distinct >", value, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctGreaterThanOrEqualTo(Float value) {
            addCriterion("n_distinct >=", value, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctLessThan(Float value) {
            addCriterion("n_distinct <", value, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctLessThanOrEqualTo(Float value) {
            addCriterion("n_distinct <=", value, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctIn(List<Float> values) {
            addCriterion("n_distinct in", values, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctNotIn(List<Float> values) {
            addCriterion("n_distinct not in", values, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctBetween(Float value1, Float value2) {
            addCriterion("n_distinct between", value1, value2, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andN_distinctNotBetween(Float value1, Float value2) {
            addCriterion("n_distinct not between", value1, value2, "n_distinct");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsIsNull() {
            addCriterion("most_common_vals is null");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsIsNotNull() {
            addCriterion("most_common_vals is not null");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsEqualTo(Object value) {
            addCriterion("most_common_vals =", value, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsNotEqualTo(Object value) {
            addCriterion("most_common_vals <>", value, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsGreaterThan(Object value) {
            addCriterion("most_common_vals >", value, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsGreaterThanOrEqualTo(Object value) {
            addCriterion("most_common_vals >=", value, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsLessThan(Object value) {
            addCriterion("most_common_vals <", value, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsLessThanOrEqualTo(Object value) {
            addCriterion("most_common_vals <=", value, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsIn(List<Object> values) {
            addCriterion("most_common_vals in", values, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsNotIn(List<Object> values) {
            addCriterion("most_common_vals not in", values, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsBetween(Object value1, Object value2) {
            addCriterion("most_common_vals between", value1, value2, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_valsNotBetween(Object value1, Object value2) {
            addCriterion("most_common_vals not between", value1, value2, "most_common_vals");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsIsNull() {
            addCriterion("most_common_freqs is null");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsIsNotNull() {
            addCriterion("most_common_freqs is not null");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsEqualTo(Object value) {
            addCriterion("most_common_freqs =", value, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsNotEqualTo(Object value) {
            addCriterion("most_common_freqs <>", value, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsGreaterThan(Object value) {
            addCriterion("most_common_freqs >", value, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsGreaterThanOrEqualTo(Object value) {
            addCriterion("most_common_freqs >=", value, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsLessThan(Object value) {
            addCriterion("most_common_freqs <", value, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsLessThanOrEqualTo(Object value) {
            addCriterion("most_common_freqs <=", value, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsIn(List<Object> values) {
            addCriterion("most_common_freqs in", values, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsNotIn(List<Object> values) {
            addCriterion("most_common_freqs not in", values, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsBetween(Object value1, Object value2) {
            addCriterion("most_common_freqs between", value1, value2, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_freqsNotBetween(Object value1, Object value2) {
            addCriterion("most_common_freqs not between", value1, value2, "most_common_freqs");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsIsNull() {
            addCriterion("histogram_bounds is null");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsIsNotNull() {
            addCriterion("histogram_bounds is not null");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsEqualTo(Object value) {
            addCriterion("histogram_bounds =", value, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsNotEqualTo(Object value) {
            addCriterion("histogram_bounds <>", value, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsGreaterThan(Object value) {
            addCriterion("histogram_bounds >", value, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsGreaterThanOrEqualTo(Object value) {
            addCriterion("histogram_bounds >=", value, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsLessThan(Object value) {
            addCriterion("histogram_bounds <", value, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsLessThanOrEqualTo(Object value) {
            addCriterion("histogram_bounds <=", value, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsIn(List<Object> values) {
            addCriterion("histogram_bounds in", values, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsNotIn(List<Object> values) {
            addCriterion("histogram_bounds not in", values, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsBetween(Object value1, Object value2) {
            addCriterion("histogram_bounds between", value1, value2, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andHistogram_boundsNotBetween(Object value1, Object value2) {
            addCriterion("histogram_bounds not between", value1, value2, "histogram_bounds");
            return (Criteria) this;
        }

        public Criteria andCorrelationIsNull() {
            addCriterion("correlation is null");
            return (Criteria) this;
        }

        public Criteria andCorrelationIsNotNull() {
            addCriterion("correlation is not null");
            return (Criteria) this;
        }

        public Criteria andCorrelationEqualTo(Float value) {
            addCriterion("correlation =", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotEqualTo(Float value) {
            addCriterion("correlation <>", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationGreaterThan(Float value) {
            addCriterion("correlation >", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationGreaterThanOrEqualTo(Float value) {
            addCriterion("correlation >=", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationLessThan(Float value) {
            addCriterion("correlation <", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationLessThanOrEqualTo(Float value) {
            addCriterion("correlation <=", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationIn(List<Float> values) {
            addCriterion("correlation in", values, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotIn(List<Float> values) {
            addCriterion("correlation not in", values, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationBetween(Float value1, Float value2) {
            addCriterion("correlation between", value1, value2, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotBetween(Float value1, Float value2) {
            addCriterion("correlation not between", value1, value2, "correlation");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsIsNull() {
            addCriterion("most_common_elems is null");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsIsNotNull() {
            addCriterion("most_common_elems is not null");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsEqualTo(Object value) {
            addCriterion("most_common_elems =", value, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsNotEqualTo(Object value) {
            addCriterion("most_common_elems <>", value, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsGreaterThan(Object value) {
            addCriterion("most_common_elems >", value, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsGreaterThanOrEqualTo(Object value) {
            addCriterion("most_common_elems >=", value, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsLessThan(Object value) {
            addCriterion("most_common_elems <", value, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsLessThanOrEqualTo(Object value) {
            addCriterion("most_common_elems <=", value, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsIn(List<Object> values) {
            addCriterion("most_common_elems in", values, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsNotIn(List<Object> values) {
            addCriterion("most_common_elems not in", values, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsBetween(Object value1, Object value2) {
            addCriterion("most_common_elems between", value1, value2, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elemsNotBetween(Object value1, Object value2) {
            addCriterion("most_common_elems not between", value1, value2, "most_common_elems");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsIsNull() {
            addCriterion("most_common_elem_freqs is null");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsIsNotNull() {
            addCriterion("most_common_elem_freqs is not null");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsEqualTo(Object value) {
            addCriterion("most_common_elem_freqs =", value, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsNotEqualTo(Object value) {
            addCriterion("most_common_elem_freqs <>", value, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsGreaterThan(Object value) {
            addCriterion("most_common_elem_freqs >", value, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsGreaterThanOrEqualTo(Object value) {
            addCriterion("most_common_elem_freqs >=", value, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsLessThan(Object value) {
            addCriterion("most_common_elem_freqs <", value, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsLessThanOrEqualTo(Object value) {
            addCriterion("most_common_elem_freqs <=", value, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsIn(List<Object> values) {
            addCriterion("most_common_elem_freqs in", values, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsNotIn(List<Object> values) {
            addCriterion("most_common_elem_freqs not in", values, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsBetween(Object value1, Object value2) {
            addCriterion("most_common_elem_freqs between", value1, value2, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andMost_common_elem_freqsNotBetween(Object value1, Object value2) {
            addCriterion("most_common_elem_freqs not between", value1, value2, "most_common_elem_freqs");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramIsNull() {
            addCriterion("elem_count_histogram is null");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramIsNotNull() {
            addCriterion("elem_count_histogram is not null");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramEqualTo(Object value) {
            addCriterion("elem_count_histogram =", value, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramNotEqualTo(Object value) {
            addCriterion("elem_count_histogram <>", value, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramGreaterThan(Object value) {
            addCriterion("elem_count_histogram >", value, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramGreaterThanOrEqualTo(Object value) {
            addCriterion("elem_count_histogram >=", value, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramLessThan(Object value) {
            addCriterion("elem_count_histogram <", value, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramLessThanOrEqualTo(Object value) {
            addCriterion("elem_count_histogram <=", value, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramIn(List<Object> values) {
            addCriterion("elem_count_histogram in", values, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramNotIn(List<Object> values) {
            addCriterion("elem_count_histogram not in", values, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramBetween(Object value1, Object value2) {
            addCriterion("elem_count_histogram between", value1, value2, "elem_count_histogram");
            return (Criteria) this;
        }

        public Criteria andElem_count_histogramNotBetween(Object value1, Object value2) {
            addCriterion("elem_count_histogram not between", value1, value2, "elem_count_histogram");
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