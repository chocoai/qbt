package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgPltemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgPltemplateExample() {
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

        public Criteria andTmplnameIsNull() {
            addCriterion("tmplname is null");
            return (Criteria) this;
        }

        public Criteria andTmplnameIsNotNull() {
            addCriterion("tmplname is not null");
            return (Criteria) this;
        }

        public Criteria andTmplnameEqualTo(String value) {
            addCriterion("tmplname =", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameNotEqualTo(String value) {
            addCriterion("tmplname <>", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameGreaterThan(String value) {
            addCriterion("tmplname >", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameGreaterThanOrEqualTo(String value) {
            addCriterion("tmplname >=", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameLessThan(String value) {
            addCriterion("tmplname <", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameLessThanOrEqualTo(String value) {
            addCriterion("tmplname <=", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameLike(String value) {
            addCriterion("tmplname like", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameNotLike(String value) {
            addCriterion("tmplname not like", value, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameIn(List<String> values) {
            addCriterion("tmplname in", values, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameNotIn(List<String> values) {
            addCriterion("tmplname not in", values, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameBetween(String value1, String value2) {
            addCriterion("tmplname between", value1, value2, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmplnameNotBetween(String value1, String value2) {
            addCriterion("tmplname not between", value1, value2, "tmplname");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedIsNull() {
            addCriterion("tmpltrusted is null");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedIsNotNull() {
            addCriterion("tmpltrusted is not null");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedEqualTo(Boolean value) {
            addCriterion("tmpltrusted =", value, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedNotEqualTo(Boolean value) {
            addCriterion("tmpltrusted <>", value, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedGreaterThan(Boolean value) {
            addCriterion("tmpltrusted >", value, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tmpltrusted >=", value, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedLessThan(Boolean value) {
            addCriterion("tmpltrusted <", value, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedLessThanOrEqualTo(Boolean value) {
            addCriterion("tmpltrusted <=", value, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedIn(List<Boolean> values) {
            addCriterion("tmpltrusted in", values, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedNotIn(List<Boolean> values) {
            addCriterion("tmpltrusted not in", values, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedBetween(Boolean value1, Boolean value2) {
            addCriterion("tmpltrusted between", value1, value2, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpltrustedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tmpltrusted not between", value1, value2, "tmpltrusted");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateIsNull() {
            addCriterion("tmpldbacreate is null");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateIsNotNull() {
            addCriterion("tmpldbacreate is not null");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateEqualTo(Boolean value) {
            addCriterion("tmpldbacreate =", value, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateNotEqualTo(Boolean value) {
            addCriterion("tmpldbacreate <>", value, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateGreaterThan(Boolean value) {
            addCriterion("tmpldbacreate >", value, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tmpldbacreate >=", value, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateLessThan(Boolean value) {
            addCriterion("tmpldbacreate <", value, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateLessThanOrEqualTo(Boolean value) {
            addCriterion("tmpldbacreate <=", value, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateIn(List<Boolean> values) {
            addCriterion("tmpldbacreate in", values, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateNotIn(List<Boolean> values) {
            addCriterion("tmpldbacreate not in", values, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateBetween(Boolean value1, Boolean value2) {
            addCriterion("tmpldbacreate between", value1, value2, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmpldbacreateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tmpldbacreate not between", value1, value2, "tmpldbacreate");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerIsNull() {
            addCriterion("tmplhandler is null");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerIsNotNull() {
            addCriterion("tmplhandler is not null");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerEqualTo(String value) {
            addCriterion("tmplhandler =", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerNotEqualTo(String value) {
            addCriterion("tmplhandler <>", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerGreaterThan(String value) {
            addCriterion("tmplhandler >", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerGreaterThanOrEqualTo(String value) {
            addCriterion("tmplhandler >=", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerLessThan(String value) {
            addCriterion("tmplhandler <", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerLessThanOrEqualTo(String value) {
            addCriterion("tmplhandler <=", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerLike(String value) {
            addCriterion("tmplhandler like", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerNotLike(String value) {
            addCriterion("tmplhandler not like", value, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerIn(List<String> values) {
            addCriterion("tmplhandler in", values, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerNotIn(List<String> values) {
            addCriterion("tmplhandler not in", values, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerBetween(String value1, String value2) {
            addCriterion("tmplhandler between", value1, value2, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplhandlerNotBetween(String value1, String value2) {
            addCriterion("tmplhandler not between", value1, value2, "tmplhandler");
            return (Criteria) this;
        }

        public Criteria andTmplinlineIsNull() {
            addCriterion("tmplinline is null");
            return (Criteria) this;
        }

        public Criteria andTmplinlineIsNotNull() {
            addCriterion("tmplinline is not null");
            return (Criteria) this;
        }

        public Criteria andTmplinlineEqualTo(String value) {
            addCriterion("tmplinline =", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineNotEqualTo(String value) {
            addCriterion("tmplinline <>", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineGreaterThan(String value) {
            addCriterion("tmplinline >", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineGreaterThanOrEqualTo(String value) {
            addCriterion("tmplinline >=", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineLessThan(String value) {
            addCriterion("tmplinline <", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineLessThanOrEqualTo(String value) {
            addCriterion("tmplinline <=", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineLike(String value) {
            addCriterion("tmplinline like", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineNotLike(String value) {
            addCriterion("tmplinline not like", value, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineIn(List<String> values) {
            addCriterion("tmplinline in", values, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineNotIn(List<String> values) {
            addCriterion("tmplinline not in", values, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineBetween(String value1, String value2) {
            addCriterion("tmplinline between", value1, value2, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplinlineNotBetween(String value1, String value2) {
            addCriterion("tmplinline not between", value1, value2, "tmplinline");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorIsNull() {
            addCriterion("tmplvalidator is null");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorIsNotNull() {
            addCriterion("tmplvalidator is not null");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorEqualTo(String value) {
            addCriterion("tmplvalidator =", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorNotEqualTo(String value) {
            addCriterion("tmplvalidator <>", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorGreaterThan(String value) {
            addCriterion("tmplvalidator >", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorGreaterThanOrEqualTo(String value) {
            addCriterion("tmplvalidator >=", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorLessThan(String value) {
            addCriterion("tmplvalidator <", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorLessThanOrEqualTo(String value) {
            addCriterion("tmplvalidator <=", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorLike(String value) {
            addCriterion("tmplvalidator like", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorNotLike(String value) {
            addCriterion("tmplvalidator not like", value, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorIn(List<String> values) {
            addCriterion("tmplvalidator in", values, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorNotIn(List<String> values) {
            addCriterion("tmplvalidator not in", values, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorBetween(String value1, String value2) {
            addCriterion("tmplvalidator between", value1, value2, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmplvalidatorNotBetween(String value1, String value2) {
            addCriterion("tmplvalidator not between", value1, value2, "tmplvalidator");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryIsNull() {
            addCriterion("tmpllibrary is null");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryIsNotNull() {
            addCriterion("tmpllibrary is not null");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryEqualTo(String value) {
            addCriterion("tmpllibrary =", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryNotEqualTo(String value) {
            addCriterion("tmpllibrary <>", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryGreaterThan(String value) {
            addCriterion("tmpllibrary >", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryGreaterThanOrEqualTo(String value) {
            addCriterion("tmpllibrary >=", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryLessThan(String value) {
            addCriterion("tmpllibrary <", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryLessThanOrEqualTo(String value) {
            addCriterion("tmpllibrary <=", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryLike(String value) {
            addCriterion("tmpllibrary like", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryNotLike(String value) {
            addCriterion("tmpllibrary not like", value, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryIn(List<String> values) {
            addCriterion("tmpllibrary in", values, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryNotIn(List<String> values) {
            addCriterion("tmpllibrary not in", values, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryBetween(String value1, String value2) {
            addCriterion("tmpllibrary between", value1, value2, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmpllibraryNotBetween(String value1, String value2) {
            addCriterion("tmpllibrary not between", value1, value2, "tmpllibrary");
            return (Criteria) this;
        }

        public Criteria andTmplaclIsNull() {
            addCriterion("tmplacl is null");
            return (Criteria) this;
        }

        public Criteria andTmplaclIsNotNull() {
            addCriterion("tmplacl is not null");
            return (Criteria) this;
        }

        public Criteria andTmplaclEqualTo(Object value) {
            addCriterion("tmplacl =", value, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclNotEqualTo(Object value) {
            addCriterion("tmplacl <>", value, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclGreaterThan(Object value) {
            addCriterion("tmplacl >", value, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclGreaterThanOrEqualTo(Object value) {
            addCriterion("tmplacl >=", value, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclLessThan(Object value) {
            addCriterion("tmplacl <", value, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclLessThanOrEqualTo(Object value) {
            addCriterion("tmplacl <=", value, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclIn(List<Object> values) {
            addCriterion("tmplacl in", values, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclNotIn(List<Object> values) {
            addCriterion("tmplacl not in", values, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclBetween(Object value1, Object value2) {
            addCriterion("tmplacl between", value1, value2, "tmplacl");
            return (Criteria) this;
        }

        public Criteria andTmplaclNotBetween(Object value1, Object value2) {
            addCriterion("tmplacl not between", value1, value2, "tmplacl");
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