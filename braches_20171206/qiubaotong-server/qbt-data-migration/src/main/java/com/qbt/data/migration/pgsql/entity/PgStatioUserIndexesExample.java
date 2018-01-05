package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatioUserIndexesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatioUserIndexesExample() {
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

        public Criteria andRelidIsNull() {
            addCriterion("relid is null");
            return (Criteria) this;
        }

        public Criteria andRelidIsNotNull() {
            addCriterion("relid is not null");
            return (Criteria) this;
        }

        public Criteria andRelidEqualTo(Long value) {
            addCriterion("relid =", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidNotEqualTo(Long value) {
            addCriterion("relid <>", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidGreaterThan(Long value) {
            addCriterion("relid >", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidGreaterThanOrEqualTo(Long value) {
            addCriterion("relid >=", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidLessThan(Long value) {
            addCriterion("relid <", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidLessThanOrEqualTo(Long value) {
            addCriterion("relid <=", value, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidIn(List<Long> values) {
            addCriterion("relid in", values, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidNotIn(List<Long> values) {
            addCriterion("relid not in", values, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidBetween(Long value1, Long value2) {
            addCriterion("relid between", value1, value2, "relid");
            return (Criteria) this;
        }

        public Criteria andRelidNotBetween(Long value1, Long value2) {
            addCriterion("relid not between", value1, value2, "relid");
            return (Criteria) this;
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

        public Criteria andRelnameIsNull() {
            addCriterion("relname is null");
            return (Criteria) this;
        }

        public Criteria andRelnameIsNotNull() {
            addCriterion("relname is not null");
            return (Criteria) this;
        }

        public Criteria andRelnameEqualTo(String value) {
            addCriterion("relname =", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotEqualTo(String value) {
            addCriterion("relname <>", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThan(String value) {
            addCriterion("relname >", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThanOrEqualTo(String value) {
            addCriterion("relname >=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThan(String value) {
            addCriterion("relname <", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThanOrEqualTo(String value) {
            addCriterion("relname <=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLike(String value) {
            addCriterion("relname like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotLike(String value) {
            addCriterion("relname not like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameIn(List<String> values) {
            addCriterion("relname in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotIn(List<String> values) {
            addCriterion("relname not in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameBetween(String value1, String value2) {
            addCriterion("relname between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotBetween(String value1, String value2) {
            addCriterion("relname not between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameIsNull() {
            addCriterion("indexrelname is null");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameIsNotNull() {
            addCriterion("indexrelname is not null");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameEqualTo(String value) {
            addCriterion("indexrelname =", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameNotEqualTo(String value) {
            addCriterion("indexrelname <>", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameGreaterThan(String value) {
            addCriterion("indexrelname >", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameGreaterThanOrEqualTo(String value) {
            addCriterion("indexrelname >=", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameLessThan(String value) {
            addCriterion("indexrelname <", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameLessThanOrEqualTo(String value) {
            addCriterion("indexrelname <=", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameLike(String value) {
            addCriterion("indexrelname like", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameNotLike(String value) {
            addCriterion("indexrelname not like", value, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameIn(List<String> values) {
            addCriterion("indexrelname in", values, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameNotIn(List<String> values) {
            addCriterion("indexrelname not in", values, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameBetween(String value1, String value2) {
            addCriterion("indexrelname between", value1, value2, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIndexrelnameNotBetween(String value1, String value2) {
            addCriterion("indexrelname not between", value1, value2, "indexrelname");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readIsNull() {
            addCriterion("idx_blks_read is null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readIsNotNull() {
            addCriterion("idx_blks_read is not null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readEqualTo(Long value) {
            addCriterion("idx_blks_read =", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readNotEqualTo(Long value) {
            addCriterion("idx_blks_read <>", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readGreaterThan(Long value) {
            addCriterion("idx_blks_read >", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readGreaterThanOrEqualTo(Long value) {
            addCriterion("idx_blks_read >=", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readLessThan(Long value) {
            addCriterion("idx_blks_read <", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readLessThanOrEqualTo(Long value) {
            addCriterion("idx_blks_read <=", value, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readIn(List<Long> values) {
            addCriterion("idx_blks_read in", values, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readNotIn(List<Long> values) {
            addCriterion("idx_blks_read not in", values, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readBetween(Long value1, Long value2) {
            addCriterion("idx_blks_read between", value1, value2, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_readNotBetween(Long value1, Long value2) {
            addCriterion("idx_blks_read not between", value1, value2, "idx_blks_read");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitIsNull() {
            addCriterion("idx_blks_hit is null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitIsNotNull() {
            addCriterion("idx_blks_hit is not null");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitEqualTo(Long value) {
            addCriterion("idx_blks_hit =", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitNotEqualTo(Long value) {
            addCriterion("idx_blks_hit <>", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitGreaterThan(Long value) {
            addCriterion("idx_blks_hit >", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitGreaterThanOrEqualTo(Long value) {
            addCriterion("idx_blks_hit >=", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitLessThan(Long value) {
            addCriterion("idx_blks_hit <", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitLessThanOrEqualTo(Long value) {
            addCriterion("idx_blks_hit <=", value, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitIn(List<Long> values) {
            addCriterion("idx_blks_hit in", values, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitNotIn(List<Long> values) {
            addCriterion("idx_blks_hit not in", values, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitBetween(Long value1, Long value2) {
            addCriterion("idx_blks_hit between", value1, value2, "idx_blks_hit");
            return (Criteria) this;
        }

        public Criteria andIdx_blks_hitNotBetween(Long value1, Long value2) {
            addCriterion("idx_blks_hit not between", value1, value2, "idx_blks_hit");
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