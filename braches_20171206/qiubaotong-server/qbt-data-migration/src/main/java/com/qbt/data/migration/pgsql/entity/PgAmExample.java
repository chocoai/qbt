package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAmExample() {
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

        public Criteria andAmnameIsNull() {
            addCriterion("amname is null");
            return (Criteria) this;
        }

        public Criteria andAmnameIsNotNull() {
            addCriterion("amname is not null");
            return (Criteria) this;
        }

        public Criteria andAmnameEqualTo(String value) {
            addCriterion("amname =", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameNotEqualTo(String value) {
            addCriterion("amname <>", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameGreaterThan(String value) {
            addCriterion("amname >", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameGreaterThanOrEqualTo(String value) {
            addCriterion("amname >=", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameLessThan(String value) {
            addCriterion("amname <", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameLessThanOrEqualTo(String value) {
            addCriterion("amname <=", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameLike(String value) {
            addCriterion("amname like", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameNotLike(String value) {
            addCriterion("amname not like", value, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameIn(List<String> values) {
            addCriterion("amname in", values, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameNotIn(List<String> values) {
            addCriterion("amname not in", values, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameBetween(String value1, String value2) {
            addCriterion("amname between", value1, value2, "amname");
            return (Criteria) this;
        }

        public Criteria andAmnameNotBetween(String value1, String value2) {
            addCriterion("amname not between", value1, value2, "amname");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesIsNull() {
            addCriterion("amstrategies is null");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesIsNotNull() {
            addCriterion("amstrategies is not null");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesEqualTo(Short value) {
            addCriterion("amstrategies =", value, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesNotEqualTo(Short value) {
            addCriterion("amstrategies <>", value, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesGreaterThan(Short value) {
            addCriterion("amstrategies >", value, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesGreaterThanOrEqualTo(Short value) {
            addCriterion("amstrategies >=", value, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesLessThan(Short value) {
            addCriterion("amstrategies <", value, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesLessThanOrEqualTo(Short value) {
            addCriterion("amstrategies <=", value, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesIn(List<Short> values) {
            addCriterion("amstrategies in", values, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesNotIn(List<Short> values) {
            addCriterion("amstrategies not in", values, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesBetween(Short value1, Short value2) {
            addCriterion("amstrategies between", value1, value2, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmstrategiesNotBetween(Short value1, Short value2) {
            addCriterion("amstrategies not between", value1, value2, "amstrategies");
            return (Criteria) this;
        }

        public Criteria andAmsupportIsNull() {
            addCriterion("amsupport is null");
            return (Criteria) this;
        }

        public Criteria andAmsupportIsNotNull() {
            addCriterion("amsupport is not null");
            return (Criteria) this;
        }

        public Criteria andAmsupportEqualTo(Short value) {
            addCriterion("amsupport =", value, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportNotEqualTo(Short value) {
            addCriterion("amsupport <>", value, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportGreaterThan(Short value) {
            addCriterion("amsupport >", value, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportGreaterThanOrEqualTo(Short value) {
            addCriterion("amsupport >=", value, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportLessThan(Short value) {
            addCriterion("amsupport <", value, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportLessThanOrEqualTo(Short value) {
            addCriterion("amsupport <=", value, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportIn(List<Short> values) {
            addCriterion("amsupport in", values, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportNotIn(List<Short> values) {
            addCriterion("amsupport not in", values, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportBetween(Short value1, Short value2) {
            addCriterion("amsupport between", value1, value2, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmsupportNotBetween(Short value1, Short value2) {
            addCriterion("amsupport not between", value1, value2, "amsupport");
            return (Criteria) this;
        }

        public Criteria andAmcanorderIsNull() {
            addCriterion("amcanorder is null");
            return (Criteria) this;
        }

        public Criteria andAmcanorderIsNotNull() {
            addCriterion("amcanorder is not null");
            return (Criteria) this;
        }

        public Criteria andAmcanorderEqualTo(Boolean value) {
            addCriterion("amcanorder =", value, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderNotEqualTo(Boolean value) {
            addCriterion("amcanorder <>", value, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderGreaterThan(Boolean value) {
            addCriterion("amcanorder >", value, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amcanorder >=", value, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderLessThan(Boolean value) {
            addCriterion("amcanorder <", value, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderLessThanOrEqualTo(Boolean value) {
            addCriterion("amcanorder <=", value, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderIn(List<Boolean> values) {
            addCriterion("amcanorder in", values, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderNotIn(List<Boolean> values) {
            addCriterion("amcanorder not in", values, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanorder between", value1, value2, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanorder not between", value1, value2, "amcanorder");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopIsNull() {
            addCriterion("amcanorderbyop is null");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopIsNotNull() {
            addCriterion("amcanorderbyop is not null");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopEqualTo(Boolean value) {
            addCriterion("amcanorderbyop =", value, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopNotEqualTo(Boolean value) {
            addCriterion("amcanorderbyop <>", value, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopGreaterThan(Boolean value) {
            addCriterion("amcanorderbyop >", value, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amcanorderbyop >=", value, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopLessThan(Boolean value) {
            addCriterion("amcanorderbyop <", value, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopLessThanOrEqualTo(Boolean value) {
            addCriterion("amcanorderbyop <=", value, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopIn(List<Boolean> values) {
            addCriterion("amcanorderbyop in", values, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopNotIn(List<Boolean> values) {
            addCriterion("amcanorderbyop not in", values, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanorderbyop between", value1, value2, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanorderbyopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanorderbyop not between", value1, value2, "amcanorderbyop");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardIsNull() {
            addCriterion("amcanbackward is null");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardIsNotNull() {
            addCriterion("amcanbackward is not null");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardEqualTo(Boolean value) {
            addCriterion("amcanbackward =", value, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardNotEqualTo(Boolean value) {
            addCriterion("amcanbackward <>", value, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardGreaterThan(Boolean value) {
            addCriterion("amcanbackward >", value, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amcanbackward >=", value, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardLessThan(Boolean value) {
            addCriterion("amcanbackward <", value, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardLessThanOrEqualTo(Boolean value) {
            addCriterion("amcanbackward <=", value, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardIn(List<Boolean> values) {
            addCriterion("amcanbackward in", values, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardNotIn(List<Boolean> values) {
            addCriterion("amcanbackward not in", values, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanbackward between", value1, value2, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanbackwardNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanbackward not between", value1, value2, "amcanbackward");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueIsNull() {
            addCriterion("amcanunique is null");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueIsNotNull() {
            addCriterion("amcanunique is not null");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueEqualTo(Boolean value) {
            addCriterion("amcanunique =", value, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueNotEqualTo(Boolean value) {
            addCriterion("amcanunique <>", value, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueGreaterThan(Boolean value) {
            addCriterion("amcanunique >", value, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amcanunique >=", value, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueLessThan(Boolean value) {
            addCriterion("amcanunique <", value, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueLessThanOrEqualTo(Boolean value) {
            addCriterion("amcanunique <=", value, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueIn(List<Boolean> values) {
            addCriterion("amcanunique in", values, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueNotIn(List<Boolean> values) {
            addCriterion("amcanunique not in", values, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanunique between", value1, value2, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanuniqueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanunique not between", value1, value2, "amcanunique");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolIsNull() {
            addCriterion("amcanmulticol is null");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolIsNotNull() {
            addCriterion("amcanmulticol is not null");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolEqualTo(Boolean value) {
            addCriterion("amcanmulticol =", value, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolNotEqualTo(Boolean value) {
            addCriterion("amcanmulticol <>", value, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolGreaterThan(Boolean value) {
            addCriterion("amcanmulticol >", value, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amcanmulticol >=", value, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolLessThan(Boolean value) {
            addCriterion("amcanmulticol <", value, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolLessThanOrEqualTo(Boolean value) {
            addCriterion("amcanmulticol <=", value, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolIn(List<Boolean> values) {
            addCriterion("amcanmulticol in", values, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolNotIn(List<Boolean> values) {
            addCriterion("amcanmulticol not in", values, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanmulticol between", value1, value2, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmcanmulticolNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amcanmulticol not between", value1, value2, "amcanmulticol");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyIsNull() {
            addCriterion("amoptionalkey is null");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyIsNotNull() {
            addCriterion("amoptionalkey is not null");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyEqualTo(Boolean value) {
            addCriterion("amoptionalkey =", value, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyNotEqualTo(Boolean value) {
            addCriterion("amoptionalkey <>", value, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyGreaterThan(Boolean value) {
            addCriterion("amoptionalkey >", value, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amoptionalkey >=", value, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyLessThan(Boolean value) {
            addCriterion("amoptionalkey <", value, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyLessThanOrEqualTo(Boolean value) {
            addCriterion("amoptionalkey <=", value, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyIn(List<Boolean> values) {
            addCriterion("amoptionalkey in", values, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyNotIn(List<Boolean> values) {
            addCriterion("amoptionalkey not in", values, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyBetween(Boolean value1, Boolean value2) {
            addCriterion("amoptionalkey between", value1, value2, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmoptionalkeyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amoptionalkey not between", value1, value2, "amoptionalkey");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayIsNull() {
            addCriterion("amsearcharray is null");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayIsNotNull() {
            addCriterion("amsearcharray is not null");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayEqualTo(Boolean value) {
            addCriterion("amsearcharray =", value, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayNotEqualTo(Boolean value) {
            addCriterion("amsearcharray <>", value, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayGreaterThan(Boolean value) {
            addCriterion("amsearcharray >", value, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amsearcharray >=", value, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayLessThan(Boolean value) {
            addCriterion("amsearcharray <", value, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayLessThanOrEqualTo(Boolean value) {
            addCriterion("amsearcharray <=", value, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayIn(List<Boolean> values) {
            addCriterion("amsearcharray in", values, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayNotIn(List<Boolean> values) {
            addCriterion("amsearcharray not in", values, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayBetween(Boolean value1, Boolean value2) {
            addCriterion("amsearcharray between", value1, value2, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearcharrayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amsearcharray not between", value1, value2, "amsearcharray");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsIsNull() {
            addCriterion("amsearchnulls is null");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsIsNotNull() {
            addCriterion("amsearchnulls is not null");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsEqualTo(Boolean value) {
            addCriterion("amsearchnulls =", value, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsNotEqualTo(Boolean value) {
            addCriterion("amsearchnulls <>", value, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsGreaterThan(Boolean value) {
            addCriterion("amsearchnulls >", value, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amsearchnulls >=", value, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsLessThan(Boolean value) {
            addCriterion("amsearchnulls <", value, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsLessThanOrEqualTo(Boolean value) {
            addCriterion("amsearchnulls <=", value, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsIn(List<Boolean> values) {
            addCriterion("amsearchnulls in", values, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsNotIn(List<Boolean> values) {
            addCriterion("amsearchnulls not in", values, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsBetween(Boolean value1, Boolean value2) {
            addCriterion("amsearchnulls between", value1, value2, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmsearchnullsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amsearchnulls not between", value1, value2, "amsearchnulls");
            return (Criteria) this;
        }

        public Criteria andAmstorageIsNull() {
            addCriterion("amstorage is null");
            return (Criteria) this;
        }

        public Criteria andAmstorageIsNotNull() {
            addCriterion("amstorage is not null");
            return (Criteria) this;
        }

        public Criteria andAmstorageEqualTo(Boolean value) {
            addCriterion("amstorage =", value, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageNotEqualTo(Boolean value) {
            addCriterion("amstorage <>", value, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageGreaterThan(Boolean value) {
            addCriterion("amstorage >", value, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amstorage >=", value, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageLessThan(Boolean value) {
            addCriterion("amstorage <", value, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageLessThanOrEqualTo(Boolean value) {
            addCriterion("amstorage <=", value, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageIn(List<Boolean> values) {
            addCriterion("amstorage in", values, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageNotIn(List<Boolean> values) {
            addCriterion("amstorage not in", values, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageBetween(Boolean value1, Boolean value2) {
            addCriterion("amstorage between", value1, value2, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmstorageNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amstorage not between", value1, value2, "amstorage");
            return (Criteria) this;
        }

        public Criteria andAmclusterableIsNull() {
            addCriterion("amclusterable is null");
            return (Criteria) this;
        }

        public Criteria andAmclusterableIsNotNull() {
            addCriterion("amclusterable is not null");
            return (Criteria) this;
        }

        public Criteria andAmclusterableEqualTo(Boolean value) {
            addCriterion("amclusterable =", value, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableNotEqualTo(Boolean value) {
            addCriterion("amclusterable <>", value, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableGreaterThan(Boolean value) {
            addCriterion("amclusterable >", value, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("amclusterable >=", value, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableLessThan(Boolean value) {
            addCriterion("amclusterable <", value, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableLessThanOrEqualTo(Boolean value) {
            addCriterion("amclusterable <=", value, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableIn(List<Boolean> values) {
            addCriterion("amclusterable in", values, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableNotIn(List<Boolean> values) {
            addCriterion("amclusterable not in", values, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableBetween(Boolean value1, Boolean value2) {
            addCriterion("amclusterable between", value1, value2, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmclusterableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("amclusterable not between", value1, value2, "amclusterable");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksIsNull() {
            addCriterion("ampredlocks is null");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksIsNotNull() {
            addCriterion("ampredlocks is not null");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksEqualTo(Boolean value) {
            addCriterion("ampredlocks =", value, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksNotEqualTo(Boolean value) {
            addCriterion("ampredlocks <>", value, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksGreaterThan(Boolean value) {
            addCriterion("ampredlocks >", value, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ampredlocks >=", value, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksLessThan(Boolean value) {
            addCriterion("ampredlocks <", value, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksLessThanOrEqualTo(Boolean value) {
            addCriterion("ampredlocks <=", value, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksIn(List<Boolean> values) {
            addCriterion("ampredlocks in", values, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksNotIn(List<Boolean> values) {
            addCriterion("ampredlocks not in", values, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksBetween(Boolean value1, Boolean value2) {
            addCriterion("ampredlocks between", value1, value2, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmpredlocksNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ampredlocks not between", value1, value2, "ampredlocks");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeIsNull() {
            addCriterion("amkeytype is null");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeIsNotNull() {
            addCriterion("amkeytype is not null");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeEqualTo(Long value) {
            addCriterion("amkeytype =", value, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeNotEqualTo(Long value) {
            addCriterion("amkeytype <>", value, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeGreaterThan(Long value) {
            addCriterion("amkeytype >", value, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeGreaterThanOrEqualTo(Long value) {
            addCriterion("amkeytype >=", value, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeLessThan(Long value) {
            addCriterion("amkeytype <", value, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeLessThanOrEqualTo(Long value) {
            addCriterion("amkeytype <=", value, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeIn(List<Long> values) {
            addCriterion("amkeytype in", values, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeNotIn(List<Long> values) {
            addCriterion("amkeytype not in", values, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeBetween(Long value1, Long value2) {
            addCriterion("amkeytype between", value1, value2, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAmkeytypeNotBetween(Long value1, Long value2) {
            addCriterion("amkeytype not between", value1, value2, "amkeytype");
            return (Criteria) this;
        }

        public Criteria andAminsertIsNull() {
            addCriterion("aminsert is null");
            return (Criteria) this;
        }

        public Criteria andAminsertIsNotNull() {
            addCriterion("aminsert is not null");
            return (Criteria) this;
        }

        public Criteria andAminsertEqualTo(Object value) {
            addCriterion("aminsert =", value, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertNotEqualTo(Object value) {
            addCriterion("aminsert <>", value, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertGreaterThan(Object value) {
            addCriterion("aminsert >", value, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertGreaterThanOrEqualTo(Object value) {
            addCriterion("aminsert >=", value, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertLessThan(Object value) {
            addCriterion("aminsert <", value, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertLessThanOrEqualTo(Object value) {
            addCriterion("aminsert <=", value, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertIn(List<Object> values) {
            addCriterion("aminsert in", values, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertNotIn(List<Object> values) {
            addCriterion("aminsert not in", values, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertBetween(Object value1, Object value2) {
            addCriterion("aminsert between", value1, value2, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAminsertNotBetween(Object value1, Object value2) {
            addCriterion("aminsert not between", value1, value2, "aminsert");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanIsNull() {
            addCriterion("ambeginscan is null");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanIsNotNull() {
            addCriterion("ambeginscan is not null");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanEqualTo(Object value) {
            addCriterion("ambeginscan =", value, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanNotEqualTo(Object value) {
            addCriterion("ambeginscan <>", value, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanGreaterThan(Object value) {
            addCriterion("ambeginscan >", value, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanGreaterThanOrEqualTo(Object value) {
            addCriterion("ambeginscan >=", value, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanLessThan(Object value) {
            addCriterion("ambeginscan <", value, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanLessThanOrEqualTo(Object value) {
            addCriterion("ambeginscan <=", value, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanIn(List<Object> values) {
            addCriterion("ambeginscan in", values, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanNotIn(List<Object> values) {
            addCriterion("ambeginscan not in", values, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanBetween(Object value1, Object value2) {
            addCriterion("ambeginscan between", value1, value2, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmbeginscanNotBetween(Object value1, Object value2) {
            addCriterion("ambeginscan not between", value1, value2, "ambeginscan");
            return (Criteria) this;
        }

        public Criteria andAmgettupleIsNull() {
            addCriterion("amgettuple is null");
            return (Criteria) this;
        }

        public Criteria andAmgettupleIsNotNull() {
            addCriterion("amgettuple is not null");
            return (Criteria) this;
        }

        public Criteria andAmgettupleEqualTo(Object value) {
            addCriterion("amgettuple =", value, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleNotEqualTo(Object value) {
            addCriterion("amgettuple <>", value, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleGreaterThan(Object value) {
            addCriterion("amgettuple >", value, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleGreaterThanOrEqualTo(Object value) {
            addCriterion("amgettuple >=", value, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleLessThan(Object value) {
            addCriterion("amgettuple <", value, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleLessThanOrEqualTo(Object value) {
            addCriterion("amgettuple <=", value, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleIn(List<Object> values) {
            addCriterion("amgettuple in", values, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleNotIn(List<Object> values) {
            addCriterion("amgettuple not in", values, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleBetween(Object value1, Object value2) {
            addCriterion("amgettuple between", value1, value2, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgettupleNotBetween(Object value1, Object value2) {
            addCriterion("amgettuple not between", value1, value2, "amgettuple");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapIsNull() {
            addCriterion("amgetbitmap is null");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapIsNotNull() {
            addCriterion("amgetbitmap is not null");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapEqualTo(Object value) {
            addCriterion("amgetbitmap =", value, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapNotEqualTo(Object value) {
            addCriterion("amgetbitmap <>", value, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapGreaterThan(Object value) {
            addCriterion("amgetbitmap >", value, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapGreaterThanOrEqualTo(Object value) {
            addCriterion("amgetbitmap >=", value, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapLessThan(Object value) {
            addCriterion("amgetbitmap <", value, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapLessThanOrEqualTo(Object value) {
            addCriterion("amgetbitmap <=", value, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapIn(List<Object> values) {
            addCriterion("amgetbitmap in", values, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapNotIn(List<Object> values) {
            addCriterion("amgetbitmap not in", values, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapBetween(Object value1, Object value2) {
            addCriterion("amgetbitmap between", value1, value2, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmgetbitmapNotBetween(Object value1, Object value2) {
            addCriterion("amgetbitmap not between", value1, value2, "amgetbitmap");
            return (Criteria) this;
        }

        public Criteria andAmrescanIsNull() {
            addCriterion("amrescan is null");
            return (Criteria) this;
        }

        public Criteria andAmrescanIsNotNull() {
            addCriterion("amrescan is not null");
            return (Criteria) this;
        }

        public Criteria andAmrescanEqualTo(Object value) {
            addCriterion("amrescan =", value, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanNotEqualTo(Object value) {
            addCriterion("amrescan <>", value, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanGreaterThan(Object value) {
            addCriterion("amrescan >", value, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanGreaterThanOrEqualTo(Object value) {
            addCriterion("amrescan >=", value, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanLessThan(Object value) {
            addCriterion("amrescan <", value, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanLessThanOrEqualTo(Object value) {
            addCriterion("amrescan <=", value, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanIn(List<Object> values) {
            addCriterion("amrescan in", values, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanNotIn(List<Object> values) {
            addCriterion("amrescan not in", values, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanBetween(Object value1, Object value2) {
            addCriterion("amrescan between", value1, value2, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmrescanNotBetween(Object value1, Object value2) {
            addCriterion("amrescan not between", value1, value2, "amrescan");
            return (Criteria) this;
        }

        public Criteria andAmendscanIsNull() {
            addCriterion("amendscan is null");
            return (Criteria) this;
        }

        public Criteria andAmendscanIsNotNull() {
            addCriterion("amendscan is not null");
            return (Criteria) this;
        }

        public Criteria andAmendscanEqualTo(Object value) {
            addCriterion("amendscan =", value, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanNotEqualTo(Object value) {
            addCriterion("amendscan <>", value, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanGreaterThan(Object value) {
            addCriterion("amendscan >", value, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanGreaterThanOrEqualTo(Object value) {
            addCriterion("amendscan >=", value, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanLessThan(Object value) {
            addCriterion("amendscan <", value, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanLessThanOrEqualTo(Object value) {
            addCriterion("amendscan <=", value, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanIn(List<Object> values) {
            addCriterion("amendscan in", values, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanNotIn(List<Object> values) {
            addCriterion("amendscan not in", values, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanBetween(Object value1, Object value2) {
            addCriterion("amendscan between", value1, value2, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmendscanNotBetween(Object value1, Object value2) {
            addCriterion("amendscan not between", value1, value2, "amendscan");
            return (Criteria) this;
        }

        public Criteria andAmmarkposIsNull() {
            addCriterion("ammarkpos is null");
            return (Criteria) this;
        }

        public Criteria andAmmarkposIsNotNull() {
            addCriterion("ammarkpos is not null");
            return (Criteria) this;
        }

        public Criteria andAmmarkposEqualTo(Object value) {
            addCriterion("ammarkpos =", value, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposNotEqualTo(Object value) {
            addCriterion("ammarkpos <>", value, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposGreaterThan(Object value) {
            addCriterion("ammarkpos >", value, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposGreaterThanOrEqualTo(Object value) {
            addCriterion("ammarkpos >=", value, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposLessThan(Object value) {
            addCriterion("ammarkpos <", value, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposLessThanOrEqualTo(Object value) {
            addCriterion("ammarkpos <=", value, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposIn(List<Object> values) {
            addCriterion("ammarkpos in", values, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposNotIn(List<Object> values) {
            addCriterion("ammarkpos not in", values, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposBetween(Object value1, Object value2) {
            addCriterion("ammarkpos between", value1, value2, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmmarkposNotBetween(Object value1, Object value2) {
            addCriterion("ammarkpos not between", value1, value2, "ammarkpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposIsNull() {
            addCriterion("amrestrpos is null");
            return (Criteria) this;
        }

        public Criteria andAmrestrposIsNotNull() {
            addCriterion("amrestrpos is not null");
            return (Criteria) this;
        }

        public Criteria andAmrestrposEqualTo(Object value) {
            addCriterion("amrestrpos =", value, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposNotEqualTo(Object value) {
            addCriterion("amrestrpos <>", value, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposGreaterThan(Object value) {
            addCriterion("amrestrpos >", value, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposGreaterThanOrEqualTo(Object value) {
            addCriterion("amrestrpos >=", value, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposLessThan(Object value) {
            addCriterion("amrestrpos <", value, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposLessThanOrEqualTo(Object value) {
            addCriterion("amrestrpos <=", value, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposIn(List<Object> values) {
            addCriterion("amrestrpos in", values, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposNotIn(List<Object> values) {
            addCriterion("amrestrpos not in", values, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposBetween(Object value1, Object value2) {
            addCriterion("amrestrpos between", value1, value2, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmrestrposNotBetween(Object value1, Object value2) {
            addCriterion("amrestrpos not between", value1, value2, "amrestrpos");
            return (Criteria) this;
        }

        public Criteria andAmbuildIsNull() {
            addCriterion("ambuild is null");
            return (Criteria) this;
        }

        public Criteria andAmbuildIsNotNull() {
            addCriterion("ambuild is not null");
            return (Criteria) this;
        }

        public Criteria andAmbuildEqualTo(Object value) {
            addCriterion("ambuild =", value, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildNotEqualTo(Object value) {
            addCriterion("ambuild <>", value, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildGreaterThan(Object value) {
            addCriterion("ambuild >", value, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildGreaterThanOrEqualTo(Object value) {
            addCriterion("ambuild >=", value, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildLessThan(Object value) {
            addCriterion("ambuild <", value, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildLessThanOrEqualTo(Object value) {
            addCriterion("ambuild <=", value, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildIn(List<Object> values) {
            addCriterion("ambuild in", values, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildNotIn(List<Object> values) {
            addCriterion("ambuild not in", values, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildBetween(Object value1, Object value2) {
            addCriterion("ambuild between", value1, value2, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildNotBetween(Object value1, Object value2) {
            addCriterion("ambuild not between", value1, value2, "ambuild");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyIsNull() {
            addCriterion("ambuildempty is null");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyIsNotNull() {
            addCriterion("ambuildempty is not null");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyEqualTo(Object value) {
            addCriterion("ambuildempty =", value, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyNotEqualTo(Object value) {
            addCriterion("ambuildempty <>", value, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyGreaterThan(Object value) {
            addCriterion("ambuildempty >", value, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyGreaterThanOrEqualTo(Object value) {
            addCriterion("ambuildempty >=", value, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyLessThan(Object value) {
            addCriterion("ambuildempty <", value, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyLessThanOrEqualTo(Object value) {
            addCriterion("ambuildempty <=", value, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyIn(List<Object> values) {
            addCriterion("ambuildempty in", values, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyNotIn(List<Object> values) {
            addCriterion("ambuildempty not in", values, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyBetween(Object value1, Object value2) {
            addCriterion("ambuildempty between", value1, value2, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbuildemptyNotBetween(Object value1, Object value2) {
            addCriterion("ambuildempty not between", value1, value2, "ambuildempty");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteIsNull() {
            addCriterion("ambulkdelete is null");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteIsNotNull() {
            addCriterion("ambulkdelete is not null");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteEqualTo(Object value) {
            addCriterion("ambulkdelete =", value, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteNotEqualTo(Object value) {
            addCriterion("ambulkdelete <>", value, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteGreaterThan(Object value) {
            addCriterion("ambulkdelete >", value, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteGreaterThanOrEqualTo(Object value) {
            addCriterion("ambulkdelete >=", value, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteLessThan(Object value) {
            addCriterion("ambulkdelete <", value, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteLessThanOrEqualTo(Object value) {
            addCriterion("ambulkdelete <=", value, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteIn(List<Object> values) {
            addCriterion("ambulkdelete in", values, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteNotIn(List<Object> values) {
            addCriterion("ambulkdelete not in", values, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteBetween(Object value1, Object value2) {
            addCriterion("ambulkdelete between", value1, value2, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmbulkdeleteNotBetween(Object value1, Object value2) {
            addCriterion("ambulkdelete not between", value1, value2, "ambulkdelete");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupIsNull() {
            addCriterion("amvacuumcleanup is null");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupIsNotNull() {
            addCriterion("amvacuumcleanup is not null");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupEqualTo(Object value) {
            addCriterion("amvacuumcleanup =", value, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupNotEqualTo(Object value) {
            addCriterion("amvacuumcleanup <>", value, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupGreaterThan(Object value) {
            addCriterion("amvacuumcleanup >", value, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupGreaterThanOrEqualTo(Object value) {
            addCriterion("amvacuumcleanup >=", value, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupLessThan(Object value) {
            addCriterion("amvacuumcleanup <", value, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupLessThanOrEqualTo(Object value) {
            addCriterion("amvacuumcleanup <=", value, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupIn(List<Object> values) {
            addCriterion("amvacuumcleanup in", values, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupNotIn(List<Object> values) {
            addCriterion("amvacuumcleanup not in", values, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupBetween(Object value1, Object value2) {
            addCriterion("amvacuumcleanup between", value1, value2, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmvacuumcleanupNotBetween(Object value1, Object value2) {
            addCriterion("amvacuumcleanup not between", value1, value2, "amvacuumcleanup");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnIsNull() {
            addCriterion("amcanreturn is null");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnIsNotNull() {
            addCriterion("amcanreturn is not null");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnEqualTo(Object value) {
            addCriterion("amcanreturn =", value, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnNotEqualTo(Object value) {
            addCriterion("amcanreturn <>", value, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnGreaterThan(Object value) {
            addCriterion("amcanreturn >", value, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnGreaterThanOrEqualTo(Object value) {
            addCriterion("amcanreturn >=", value, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnLessThan(Object value) {
            addCriterion("amcanreturn <", value, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnLessThanOrEqualTo(Object value) {
            addCriterion("amcanreturn <=", value, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnIn(List<Object> values) {
            addCriterion("amcanreturn in", values, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnNotIn(List<Object> values) {
            addCriterion("amcanreturn not in", values, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnBetween(Object value1, Object value2) {
            addCriterion("amcanreturn between", value1, value2, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcanreturnNotBetween(Object value1, Object value2) {
            addCriterion("amcanreturn not between", value1, value2, "amcanreturn");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateIsNull() {
            addCriterion("amcostestimate is null");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateIsNotNull() {
            addCriterion("amcostestimate is not null");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateEqualTo(Object value) {
            addCriterion("amcostestimate =", value, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateNotEqualTo(Object value) {
            addCriterion("amcostestimate <>", value, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateGreaterThan(Object value) {
            addCriterion("amcostestimate >", value, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateGreaterThanOrEqualTo(Object value) {
            addCriterion("amcostestimate >=", value, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateLessThan(Object value) {
            addCriterion("amcostestimate <", value, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateLessThanOrEqualTo(Object value) {
            addCriterion("amcostestimate <=", value, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateIn(List<Object> values) {
            addCriterion("amcostestimate in", values, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateNotIn(List<Object> values) {
            addCriterion("amcostestimate not in", values, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateBetween(Object value1, Object value2) {
            addCriterion("amcostestimate between", value1, value2, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmcostestimateNotBetween(Object value1, Object value2) {
            addCriterion("amcostestimate not between", value1, value2, "amcostestimate");
            return (Criteria) this;
        }

        public Criteria andAmoptionsIsNull() {
            addCriterion("amoptions is null");
            return (Criteria) this;
        }

        public Criteria andAmoptionsIsNotNull() {
            addCriterion("amoptions is not null");
            return (Criteria) this;
        }

        public Criteria andAmoptionsEqualTo(Object value) {
            addCriterion("amoptions =", value, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsNotEqualTo(Object value) {
            addCriterion("amoptions <>", value, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsGreaterThan(Object value) {
            addCriterion("amoptions >", value, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("amoptions >=", value, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsLessThan(Object value) {
            addCriterion("amoptions <", value, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsLessThanOrEqualTo(Object value) {
            addCriterion("amoptions <=", value, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsIn(List<Object> values) {
            addCriterion("amoptions in", values, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsNotIn(List<Object> values) {
            addCriterion("amoptions not in", values, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsBetween(Object value1, Object value2) {
            addCriterion("amoptions between", value1, value2, "amoptions");
            return (Criteria) this;
        }

        public Criteria andAmoptionsNotBetween(Object value1, Object value2) {
            addCriterion("amoptions not between", value1, value2, "amoptions");
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