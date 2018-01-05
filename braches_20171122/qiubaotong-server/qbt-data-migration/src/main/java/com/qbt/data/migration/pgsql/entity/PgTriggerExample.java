package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTriggerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTriggerExample() {
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

        public Criteria andTgrelidIsNull() {
            addCriterion("tgrelid is null");
            return (Criteria) this;
        }

        public Criteria andTgrelidIsNotNull() {
            addCriterion("tgrelid is not null");
            return (Criteria) this;
        }

        public Criteria andTgrelidEqualTo(Long value) {
            addCriterion("tgrelid =", value, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidNotEqualTo(Long value) {
            addCriterion("tgrelid <>", value, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidGreaterThan(Long value) {
            addCriterion("tgrelid >", value, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("tgrelid >=", value, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidLessThan(Long value) {
            addCriterion("tgrelid <", value, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidLessThanOrEqualTo(Long value) {
            addCriterion("tgrelid <=", value, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidIn(List<Long> values) {
            addCriterion("tgrelid in", values, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidNotIn(List<Long> values) {
            addCriterion("tgrelid not in", values, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidBetween(Long value1, Long value2) {
            addCriterion("tgrelid between", value1, value2, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgrelidNotBetween(Long value1, Long value2) {
            addCriterion("tgrelid not between", value1, value2, "tgrelid");
            return (Criteria) this;
        }

        public Criteria andTgnameIsNull() {
            addCriterion("tgname is null");
            return (Criteria) this;
        }

        public Criteria andTgnameIsNotNull() {
            addCriterion("tgname is not null");
            return (Criteria) this;
        }

        public Criteria andTgnameEqualTo(String value) {
            addCriterion("tgname =", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameNotEqualTo(String value) {
            addCriterion("tgname <>", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameGreaterThan(String value) {
            addCriterion("tgname >", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameGreaterThanOrEqualTo(String value) {
            addCriterion("tgname >=", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameLessThan(String value) {
            addCriterion("tgname <", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameLessThanOrEqualTo(String value) {
            addCriterion("tgname <=", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameLike(String value) {
            addCriterion("tgname like", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameNotLike(String value) {
            addCriterion("tgname not like", value, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameIn(List<String> values) {
            addCriterion("tgname in", values, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameNotIn(List<String> values) {
            addCriterion("tgname not in", values, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameBetween(String value1, String value2) {
            addCriterion("tgname between", value1, value2, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgnameNotBetween(String value1, String value2) {
            addCriterion("tgname not between", value1, value2, "tgname");
            return (Criteria) this;
        }

        public Criteria andTgfoidIsNull() {
            addCriterion("tgfoid is null");
            return (Criteria) this;
        }

        public Criteria andTgfoidIsNotNull() {
            addCriterion("tgfoid is not null");
            return (Criteria) this;
        }

        public Criteria andTgfoidEqualTo(Long value) {
            addCriterion("tgfoid =", value, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidNotEqualTo(Long value) {
            addCriterion("tgfoid <>", value, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidGreaterThan(Long value) {
            addCriterion("tgfoid >", value, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidGreaterThanOrEqualTo(Long value) {
            addCriterion("tgfoid >=", value, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidLessThan(Long value) {
            addCriterion("tgfoid <", value, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidLessThanOrEqualTo(Long value) {
            addCriterion("tgfoid <=", value, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidIn(List<Long> values) {
            addCriterion("tgfoid in", values, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidNotIn(List<Long> values) {
            addCriterion("tgfoid not in", values, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidBetween(Long value1, Long value2) {
            addCriterion("tgfoid between", value1, value2, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgfoidNotBetween(Long value1, Long value2) {
            addCriterion("tgfoid not between", value1, value2, "tgfoid");
            return (Criteria) this;
        }

        public Criteria andTgtypeIsNull() {
            addCriterion("tgtype is null");
            return (Criteria) this;
        }

        public Criteria andTgtypeIsNotNull() {
            addCriterion("tgtype is not null");
            return (Criteria) this;
        }

        public Criteria andTgtypeEqualTo(Short value) {
            addCriterion("tgtype =", value, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeNotEqualTo(Short value) {
            addCriterion("tgtype <>", value, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeGreaterThan(Short value) {
            addCriterion("tgtype >", value, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("tgtype >=", value, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeLessThan(Short value) {
            addCriterion("tgtype <", value, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeLessThanOrEqualTo(Short value) {
            addCriterion("tgtype <=", value, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeIn(List<Short> values) {
            addCriterion("tgtype in", values, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeNotIn(List<Short> values) {
            addCriterion("tgtype not in", values, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeBetween(Short value1, Short value2) {
            addCriterion("tgtype between", value1, value2, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgtypeNotBetween(Short value1, Short value2) {
            addCriterion("tgtype not between", value1, value2, "tgtype");
            return (Criteria) this;
        }

        public Criteria andTgenabledIsNull() {
            addCriterion("tgenabled is null");
            return (Criteria) this;
        }

        public Criteria andTgenabledIsNotNull() {
            addCriterion("tgenabled is not null");
            return (Criteria) this;
        }

        public Criteria andTgenabledEqualTo(String value) {
            addCriterion("tgenabled =", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledNotEqualTo(String value) {
            addCriterion("tgenabled <>", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledGreaterThan(String value) {
            addCriterion("tgenabled >", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledGreaterThanOrEqualTo(String value) {
            addCriterion("tgenabled >=", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledLessThan(String value) {
            addCriterion("tgenabled <", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledLessThanOrEqualTo(String value) {
            addCriterion("tgenabled <=", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledLike(String value) {
            addCriterion("tgenabled like", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledNotLike(String value) {
            addCriterion("tgenabled not like", value, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledIn(List<String> values) {
            addCriterion("tgenabled in", values, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledNotIn(List<String> values) {
            addCriterion("tgenabled not in", values, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledBetween(String value1, String value2) {
            addCriterion("tgenabled between", value1, value2, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgenabledNotBetween(String value1, String value2) {
            addCriterion("tgenabled not between", value1, value2, "tgenabled");
            return (Criteria) this;
        }

        public Criteria andTgisinternalIsNull() {
            addCriterion("tgisinternal is null");
            return (Criteria) this;
        }

        public Criteria andTgisinternalIsNotNull() {
            addCriterion("tgisinternal is not null");
            return (Criteria) this;
        }

        public Criteria andTgisinternalEqualTo(Boolean value) {
            addCriterion("tgisinternal =", value, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalNotEqualTo(Boolean value) {
            addCriterion("tgisinternal <>", value, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalGreaterThan(Boolean value) {
            addCriterion("tgisinternal >", value, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tgisinternal >=", value, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalLessThan(Boolean value) {
            addCriterion("tgisinternal <", value, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalLessThanOrEqualTo(Boolean value) {
            addCriterion("tgisinternal <=", value, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalIn(List<Boolean> values) {
            addCriterion("tgisinternal in", values, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalNotIn(List<Boolean> values) {
            addCriterion("tgisinternal not in", values, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalBetween(Boolean value1, Boolean value2) {
            addCriterion("tgisinternal between", value1, value2, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgisinternalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tgisinternal not between", value1, value2, "tgisinternal");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidIsNull() {
            addCriterion("tgconstrrelid is null");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidIsNotNull() {
            addCriterion("tgconstrrelid is not null");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidEqualTo(Long value) {
            addCriterion("tgconstrrelid =", value, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidNotEqualTo(Long value) {
            addCriterion("tgconstrrelid <>", value, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidGreaterThan(Long value) {
            addCriterion("tgconstrrelid >", value, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("tgconstrrelid >=", value, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidLessThan(Long value) {
            addCriterion("tgconstrrelid <", value, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidLessThanOrEqualTo(Long value) {
            addCriterion("tgconstrrelid <=", value, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidIn(List<Long> values) {
            addCriterion("tgconstrrelid in", values, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidNotIn(List<Long> values) {
            addCriterion("tgconstrrelid not in", values, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidBetween(Long value1, Long value2) {
            addCriterion("tgconstrrelid between", value1, value2, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrrelidNotBetween(Long value1, Long value2) {
            addCriterion("tgconstrrelid not between", value1, value2, "tgconstrrelid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidIsNull() {
            addCriterion("tgconstrindid is null");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidIsNotNull() {
            addCriterion("tgconstrindid is not null");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidEqualTo(Long value) {
            addCriterion("tgconstrindid =", value, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidNotEqualTo(Long value) {
            addCriterion("tgconstrindid <>", value, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidGreaterThan(Long value) {
            addCriterion("tgconstrindid >", value, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidGreaterThanOrEqualTo(Long value) {
            addCriterion("tgconstrindid >=", value, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidLessThan(Long value) {
            addCriterion("tgconstrindid <", value, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidLessThanOrEqualTo(Long value) {
            addCriterion("tgconstrindid <=", value, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidIn(List<Long> values) {
            addCriterion("tgconstrindid in", values, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidNotIn(List<Long> values) {
            addCriterion("tgconstrindid not in", values, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidBetween(Long value1, Long value2) {
            addCriterion("tgconstrindid between", value1, value2, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstrindidNotBetween(Long value1, Long value2) {
            addCriterion("tgconstrindid not between", value1, value2, "tgconstrindid");
            return (Criteria) this;
        }

        public Criteria andTgconstraintIsNull() {
            addCriterion("tgconstraint is null");
            return (Criteria) this;
        }

        public Criteria andTgconstraintIsNotNull() {
            addCriterion("tgconstraint is not null");
            return (Criteria) this;
        }

        public Criteria andTgconstraintEqualTo(Long value) {
            addCriterion("tgconstraint =", value, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintNotEqualTo(Long value) {
            addCriterion("tgconstraint <>", value, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintGreaterThan(Long value) {
            addCriterion("tgconstraint >", value, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintGreaterThanOrEqualTo(Long value) {
            addCriterion("tgconstraint >=", value, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintLessThan(Long value) {
            addCriterion("tgconstraint <", value, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintLessThanOrEqualTo(Long value) {
            addCriterion("tgconstraint <=", value, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintIn(List<Long> values) {
            addCriterion("tgconstraint in", values, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintNotIn(List<Long> values) {
            addCriterion("tgconstraint not in", values, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintBetween(Long value1, Long value2) {
            addCriterion("tgconstraint between", value1, value2, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgconstraintNotBetween(Long value1, Long value2) {
            addCriterion("tgconstraint not between", value1, value2, "tgconstraint");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableIsNull() {
            addCriterion("tgdeferrable is null");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableIsNotNull() {
            addCriterion("tgdeferrable is not null");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableEqualTo(Boolean value) {
            addCriterion("tgdeferrable =", value, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableNotEqualTo(Boolean value) {
            addCriterion("tgdeferrable <>", value, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableGreaterThan(Boolean value) {
            addCriterion("tgdeferrable >", value, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tgdeferrable >=", value, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableLessThan(Boolean value) {
            addCriterion("tgdeferrable <", value, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableLessThanOrEqualTo(Boolean value) {
            addCriterion("tgdeferrable <=", value, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableIn(List<Boolean> values) {
            addCriterion("tgdeferrable in", values, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableNotIn(List<Boolean> values) {
            addCriterion("tgdeferrable not in", values, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableBetween(Boolean value1, Boolean value2) {
            addCriterion("tgdeferrable between", value1, value2, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTgdeferrableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tgdeferrable not between", value1, value2, "tgdeferrable");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredIsNull() {
            addCriterion("tginitdeferred is null");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredIsNotNull() {
            addCriterion("tginitdeferred is not null");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredEqualTo(Boolean value) {
            addCriterion("tginitdeferred =", value, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredNotEqualTo(Boolean value) {
            addCriterion("tginitdeferred <>", value, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredGreaterThan(Boolean value) {
            addCriterion("tginitdeferred >", value, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tginitdeferred >=", value, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredLessThan(Boolean value) {
            addCriterion("tginitdeferred <", value, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredLessThanOrEqualTo(Boolean value) {
            addCriterion("tginitdeferred <=", value, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredIn(List<Boolean> values) {
            addCriterion("tginitdeferred in", values, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredNotIn(List<Boolean> values) {
            addCriterion("tginitdeferred not in", values, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredBetween(Boolean value1, Boolean value2) {
            addCriterion("tginitdeferred between", value1, value2, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTginitdeferredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tginitdeferred not between", value1, value2, "tginitdeferred");
            return (Criteria) this;
        }

        public Criteria andTgnargsIsNull() {
            addCriterion("tgnargs is null");
            return (Criteria) this;
        }

        public Criteria andTgnargsIsNotNull() {
            addCriterion("tgnargs is not null");
            return (Criteria) this;
        }

        public Criteria andTgnargsEqualTo(Short value) {
            addCriterion("tgnargs =", value, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsNotEqualTo(Short value) {
            addCriterion("tgnargs <>", value, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsGreaterThan(Short value) {
            addCriterion("tgnargs >", value, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsGreaterThanOrEqualTo(Short value) {
            addCriterion("tgnargs >=", value, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsLessThan(Short value) {
            addCriterion("tgnargs <", value, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsLessThanOrEqualTo(Short value) {
            addCriterion("tgnargs <=", value, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsIn(List<Short> values) {
            addCriterion("tgnargs in", values, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsNotIn(List<Short> values) {
            addCriterion("tgnargs not in", values, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsBetween(Short value1, Short value2) {
            addCriterion("tgnargs between", value1, value2, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgnargsNotBetween(Short value1, Short value2) {
            addCriterion("tgnargs not between", value1, value2, "tgnargs");
            return (Criteria) this;
        }

        public Criteria andTgattrIsNull() {
            addCriterion("tgattr is null");
            return (Criteria) this;
        }

        public Criteria andTgattrIsNotNull() {
            addCriterion("tgattr is not null");
            return (Criteria) this;
        }

        public Criteria andTgattrEqualTo(Object value) {
            addCriterion("tgattr =", value, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrNotEqualTo(Object value) {
            addCriterion("tgattr <>", value, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrGreaterThan(Object value) {
            addCriterion("tgattr >", value, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrGreaterThanOrEqualTo(Object value) {
            addCriterion("tgattr >=", value, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrLessThan(Object value) {
            addCriterion("tgattr <", value, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrLessThanOrEqualTo(Object value) {
            addCriterion("tgattr <=", value, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrIn(List<Object> values) {
            addCriterion("tgattr in", values, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrNotIn(List<Object> values) {
            addCriterion("tgattr not in", values, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrBetween(Object value1, Object value2) {
            addCriterion("tgattr between", value1, value2, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgattrNotBetween(Object value1, Object value2) {
            addCriterion("tgattr not between", value1, value2, "tgattr");
            return (Criteria) this;
        }

        public Criteria andTgqualIsNull() {
            addCriterion("tgqual is null");
            return (Criteria) this;
        }

        public Criteria andTgqualIsNotNull() {
            addCriterion("tgqual is not null");
            return (Criteria) this;
        }

        public Criteria andTgqualEqualTo(Object value) {
            addCriterion("tgqual =", value, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualNotEqualTo(Object value) {
            addCriterion("tgqual <>", value, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualGreaterThan(Object value) {
            addCriterion("tgqual >", value, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualGreaterThanOrEqualTo(Object value) {
            addCriterion("tgqual >=", value, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualLessThan(Object value) {
            addCriterion("tgqual <", value, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualLessThanOrEqualTo(Object value) {
            addCriterion("tgqual <=", value, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualIn(List<Object> values) {
            addCriterion("tgqual in", values, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualNotIn(List<Object> values) {
            addCriterion("tgqual not in", values, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualBetween(Object value1, Object value2) {
            addCriterion("tgqual between", value1, value2, "tgqual");
            return (Criteria) this;
        }

        public Criteria andTgqualNotBetween(Object value1, Object value2) {
            addCriterion("tgqual not between", value1, value2, "tgqual");
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