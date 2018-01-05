package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgUserExample() {
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

        public Criteria andUsenameIsNull() {
            addCriterion("usename is null");
            return (Criteria) this;
        }

        public Criteria andUsenameIsNotNull() {
            addCriterion("usename is not null");
            return (Criteria) this;
        }

        public Criteria andUsenameEqualTo(String value) {
            addCriterion("usename =", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotEqualTo(String value) {
            addCriterion("usename <>", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameGreaterThan(String value) {
            addCriterion("usename >", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameGreaterThanOrEqualTo(String value) {
            addCriterion("usename >=", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameLessThan(String value) {
            addCriterion("usename <", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameLessThanOrEqualTo(String value) {
            addCriterion("usename <=", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameLike(String value) {
            addCriterion("usename like", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotLike(String value) {
            addCriterion("usename not like", value, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameIn(List<String> values) {
            addCriterion("usename in", values, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotIn(List<String> values) {
            addCriterion("usename not in", values, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameBetween(String value1, String value2) {
            addCriterion("usename between", value1, value2, "usename");
            return (Criteria) this;
        }

        public Criteria andUsenameNotBetween(String value1, String value2) {
            addCriterion("usename not between", value1, value2, "usename");
            return (Criteria) this;
        }

        public Criteria andUsesysidIsNull() {
            addCriterion("usesysid is null");
            return (Criteria) this;
        }

        public Criteria andUsesysidIsNotNull() {
            addCriterion("usesysid is not null");
            return (Criteria) this;
        }

        public Criteria andUsesysidEqualTo(Long value) {
            addCriterion("usesysid =", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidNotEqualTo(Long value) {
            addCriterion("usesysid <>", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidGreaterThan(Long value) {
            addCriterion("usesysid >", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidGreaterThanOrEqualTo(Long value) {
            addCriterion("usesysid >=", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidLessThan(Long value) {
            addCriterion("usesysid <", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidLessThanOrEqualTo(Long value) {
            addCriterion("usesysid <=", value, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidIn(List<Long> values) {
            addCriterion("usesysid in", values, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidNotIn(List<Long> values) {
            addCriterion("usesysid not in", values, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidBetween(Long value1, Long value2) {
            addCriterion("usesysid between", value1, value2, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsesysidNotBetween(Long value1, Long value2) {
            addCriterion("usesysid not between", value1, value2, "usesysid");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbIsNull() {
            addCriterion("usecreatedb is null");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbIsNotNull() {
            addCriterion("usecreatedb is not null");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbEqualTo(Boolean value) {
            addCriterion("usecreatedb =", value, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbNotEqualTo(Boolean value) {
            addCriterion("usecreatedb <>", value, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbGreaterThan(Boolean value) {
            addCriterion("usecreatedb >", value, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbGreaterThanOrEqualTo(Boolean value) {
            addCriterion("usecreatedb >=", value, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbLessThan(Boolean value) {
            addCriterion("usecreatedb <", value, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbLessThanOrEqualTo(Boolean value) {
            addCriterion("usecreatedb <=", value, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbIn(List<Boolean> values) {
            addCriterion("usecreatedb in", values, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbNotIn(List<Boolean> values) {
            addCriterion("usecreatedb not in", values, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbBetween(Boolean value1, Boolean value2) {
            addCriterion("usecreatedb between", value1, value2, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsecreatedbNotBetween(Boolean value1, Boolean value2) {
            addCriterion("usecreatedb not between", value1, value2, "usecreatedb");
            return (Criteria) this;
        }

        public Criteria andUsesuperIsNull() {
            addCriterion("usesuper is null");
            return (Criteria) this;
        }

        public Criteria andUsesuperIsNotNull() {
            addCriterion("usesuper is not null");
            return (Criteria) this;
        }

        public Criteria andUsesuperEqualTo(Boolean value) {
            addCriterion("usesuper =", value, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperNotEqualTo(Boolean value) {
            addCriterion("usesuper <>", value, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperGreaterThan(Boolean value) {
            addCriterion("usesuper >", value, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperGreaterThanOrEqualTo(Boolean value) {
            addCriterion("usesuper >=", value, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperLessThan(Boolean value) {
            addCriterion("usesuper <", value, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperLessThanOrEqualTo(Boolean value) {
            addCriterion("usesuper <=", value, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperIn(List<Boolean> values) {
            addCriterion("usesuper in", values, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperNotIn(List<Boolean> values) {
            addCriterion("usesuper not in", values, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperBetween(Boolean value1, Boolean value2) {
            addCriterion("usesuper between", value1, value2, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsesuperNotBetween(Boolean value1, Boolean value2) {
            addCriterion("usesuper not between", value1, value2, "usesuper");
            return (Criteria) this;
        }

        public Criteria andUsecatupdIsNull() {
            addCriterion("usecatupd is null");
            return (Criteria) this;
        }

        public Criteria andUsecatupdIsNotNull() {
            addCriterion("usecatupd is not null");
            return (Criteria) this;
        }

        public Criteria andUsecatupdEqualTo(Boolean value) {
            addCriterion("usecatupd =", value, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdNotEqualTo(Boolean value) {
            addCriterion("usecatupd <>", value, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdGreaterThan(Boolean value) {
            addCriterion("usecatupd >", value, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("usecatupd >=", value, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdLessThan(Boolean value) {
            addCriterion("usecatupd <", value, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdLessThanOrEqualTo(Boolean value) {
            addCriterion("usecatupd <=", value, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdIn(List<Boolean> values) {
            addCriterion("usecatupd in", values, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdNotIn(List<Boolean> values) {
            addCriterion("usecatupd not in", values, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdBetween(Boolean value1, Boolean value2) {
            addCriterion("usecatupd between", value1, value2, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsecatupdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("usecatupd not between", value1, value2, "usecatupd");
            return (Criteria) this;
        }

        public Criteria andUsereplIsNull() {
            addCriterion("userepl is null");
            return (Criteria) this;
        }

        public Criteria andUsereplIsNotNull() {
            addCriterion("userepl is not null");
            return (Criteria) this;
        }

        public Criteria andUsereplEqualTo(Boolean value) {
            addCriterion("userepl =", value, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplNotEqualTo(Boolean value) {
            addCriterion("userepl <>", value, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplGreaterThan(Boolean value) {
            addCriterion("userepl >", value, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplGreaterThanOrEqualTo(Boolean value) {
            addCriterion("userepl >=", value, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplLessThan(Boolean value) {
            addCriterion("userepl <", value, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplLessThanOrEqualTo(Boolean value) {
            addCriterion("userepl <=", value, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplIn(List<Boolean> values) {
            addCriterion("userepl in", values, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplNotIn(List<Boolean> values) {
            addCriterion("userepl not in", values, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplBetween(Boolean value1, Boolean value2) {
            addCriterion("userepl between", value1, value2, "userepl");
            return (Criteria) this;
        }

        public Criteria andUsereplNotBetween(Boolean value1, Boolean value2) {
            addCriterion("userepl not between", value1, value2, "userepl");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("passwd is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("passwd is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("passwd =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("passwd <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("passwd >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("passwd >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("passwd <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("passwd <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("passwd like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("passwd not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("passwd in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("passwd not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("passwd between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("passwd not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andValuntilIsNull() {
            addCriterion("valuntil is null");
            return (Criteria) this;
        }

        public Criteria andValuntilIsNotNull() {
            addCriterion("valuntil is not null");
            return (Criteria) this;
        }

        public Criteria andValuntilEqualTo(Object value) {
            addCriterion("valuntil =", value, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilNotEqualTo(Object value) {
            addCriterion("valuntil <>", value, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilGreaterThan(Object value) {
            addCriterion("valuntil >", value, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilGreaterThanOrEqualTo(Object value) {
            addCriterion("valuntil >=", value, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilLessThan(Object value) {
            addCriterion("valuntil <", value, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilLessThanOrEqualTo(Object value) {
            addCriterion("valuntil <=", value, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilIn(List<Object> values) {
            addCriterion("valuntil in", values, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilNotIn(List<Object> values) {
            addCriterion("valuntil not in", values, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilBetween(Object value1, Object value2) {
            addCriterion("valuntil between", value1, value2, "valuntil");
            return (Criteria) this;
        }

        public Criteria andValuntilNotBetween(Object value1, Object value2) {
            addCriterion("valuntil not between", value1, value2, "valuntil");
            return (Criteria) this;
        }

        public Criteria andUseconfigIsNull() {
            addCriterion("useconfig is null");
            return (Criteria) this;
        }

        public Criteria andUseconfigIsNotNull() {
            addCriterion("useconfig is not null");
            return (Criteria) this;
        }

        public Criteria andUseconfigEqualTo(Object value) {
            addCriterion("useconfig =", value, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigNotEqualTo(Object value) {
            addCriterion("useconfig <>", value, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigGreaterThan(Object value) {
            addCriterion("useconfig >", value, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigGreaterThanOrEqualTo(Object value) {
            addCriterion("useconfig >=", value, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigLessThan(Object value) {
            addCriterion("useconfig <", value, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigLessThanOrEqualTo(Object value) {
            addCriterion("useconfig <=", value, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigIn(List<Object> values) {
            addCriterion("useconfig in", values, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigNotIn(List<Object> values) {
            addCriterion("useconfig not in", values, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigBetween(Object value1, Object value2) {
            addCriterion("useconfig between", value1, value2, "useconfig");
            return (Criteria) this;
        }

        public Criteria andUseconfigNotBetween(Object value1, Object value2) {
            addCriterion("useconfig not between", value1, value2, "useconfig");
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