package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgConstraintExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgConstraintExample() {
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

        public Criteria andConnameIsNull() {
            addCriterion("conname is null");
            return (Criteria) this;
        }

        public Criteria andConnameIsNotNull() {
            addCriterion("conname is not null");
            return (Criteria) this;
        }

        public Criteria andConnameEqualTo(String value) {
            addCriterion("conname =", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotEqualTo(String value) {
            addCriterion("conname <>", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThan(String value) {
            addCriterion("conname >", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThanOrEqualTo(String value) {
            addCriterion("conname >=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThan(String value) {
            addCriterion("conname <", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThanOrEqualTo(String value) {
            addCriterion("conname <=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLike(String value) {
            addCriterion("conname like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotLike(String value) {
            addCriterion("conname not like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameIn(List<String> values) {
            addCriterion("conname in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotIn(List<String> values) {
            addCriterion("conname not in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameBetween(String value1, String value2) {
            addCriterion("conname between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotBetween(String value1, String value2) {
            addCriterion("conname not between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConnamespaceIsNull() {
            addCriterion("connamespace is null");
            return (Criteria) this;
        }

        public Criteria andConnamespaceIsNotNull() {
            addCriterion("connamespace is not null");
            return (Criteria) this;
        }

        public Criteria andConnamespaceEqualTo(Long value) {
            addCriterion("connamespace =", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceNotEqualTo(Long value) {
            addCriterion("connamespace <>", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceGreaterThan(Long value) {
            addCriterion("connamespace >", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("connamespace >=", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceLessThan(Long value) {
            addCriterion("connamespace <", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("connamespace <=", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceIn(List<Long> values) {
            addCriterion("connamespace in", values, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceNotIn(List<Long> values) {
            addCriterion("connamespace not in", values, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceBetween(Long value1, Long value2) {
            addCriterion("connamespace between", value1, value2, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("connamespace not between", value1, value2, "connamespace");
            return (Criteria) this;
        }

        public Criteria andContypeIsNull() {
            addCriterion("contype is null");
            return (Criteria) this;
        }

        public Criteria andContypeIsNotNull() {
            addCriterion("contype is not null");
            return (Criteria) this;
        }

        public Criteria andContypeEqualTo(String value) {
            addCriterion("contype =", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeNotEqualTo(String value) {
            addCriterion("contype <>", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeGreaterThan(String value) {
            addCriterion("contype >", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeGreaterThanOrEqualTo(String value) {
            addCriterion("contype >=", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeLessThan(String value) {
            addCriterion("contype <", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeLessThanOrEqualTo(String value) {
            addCriterion("contype <=", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeLike(String value) {
            addCriterion("contype like", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeNotLike(String value) {
            addCriterion("contype not like", value, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeIn(List<String> values) {
            addCriterion("contype in", values, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeNotIn(List<String> values) {
            addCriterion("contype not in", values, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeBetween(String value1, String value2) {
            addCriterion("contype between", value1, value2, "contype");
            return (Criteria) this;
        }

        public Criteria andContypeNotBetween(String value1, String value2) {
            addCriterion("contype not between", value1, value2, "contype");
            return (Criteria) this;
        }

        public Criteria andCondeferrableIsNull() {
            addCriterion("condeferrable is null");
            return (Criteria) this;
        }

        public Criteria andCondeferrableIsNotNull() {
            addCriterion("condeferrable is not null");
            return (Criteria) this;
        }

        public Criteria andCondeferrableEqualTo(Boolean value) {
            addCriterion("condeferrable =", value, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableNotEqualTo(Boolean value) {
            addCriterion("condeferrable <>", value, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableGreaterThan(Boolean value) {
            addCriterion("condeferrable >", value, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("condeferrable >=", value, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableLessThan(Boolean value) {
            addCriterion("condeferrable <", value, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableLessThanOrEqualTo(Boolean value) {
            addCriterion("condeferrable <=", value, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableIn(List<Boolean> values) {
            addCriterion("condeferrable in", values, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableNotIn(List<Boolean> values) {
            addCriterion("condeferrable not in", values, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableBetween(Boolean value1, Boolean value2) {
            addCriterion("condeferrable between", value1, value2, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferrableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("condeferrable not between", value1, value2, "condeferrable");
            return (Criteria) this;
        }

        public Criteria andCondeferredIsNull() {
            addCriterion("condeferred is null");
            return (Criteria) this;
        }

        public Criteria andCondeferredIsNotNull() {
            addCriterion("condeferred is not null");
            return (Criteria) this;
        }

        public Criteria andCondeferredEqualTo(Boolean value) {
            addCriterion("condeferred =", value, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredNotEqualTo(Boolean value) {
            addCriterion("condeferred <>", value, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredGreaterThan(Boolean value) {
            addCriterion("condeferred >", value, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("condeferred >=", value, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredLessThan(Boolean value) {
            addCriterion("condeferred <", value, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredLessThanOrEqualTo(Boolean value) {
            addCriterion("condeferred <=", value, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredIn(List<Boolean> values) {
            addCriterion("condeferred in", values, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredNotIn(List<Boolean> values) {
            addCriterion("condeferred not in", values, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredBetween(Boolean value1, Boolean value2) {
            addCriterion("condeferred between", value1, value2, "condeferred");
            return (Criteria) this;
        }

        public Criteria andCondeferredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("condeferred not between", value1, value2, "condeferred");
            return (Criteria) this;
        }

        public Criteria andConvalidatedIsNull() {
            addCriterion("convalidated is null");
            return (Criteria) this;
        }

        public Criteria andConvalidatedIsNotNull() {
            addCriterion("convalidated is not null");
            return (Criteria) this;
        }

        public Criteria andConvalidatedEqualTo(Boolean value) {
            addCriterion("convalidated =", value, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedNotEqualTo(Boolean value) {
            addCriterion("convalidated <>", value, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedGreaterThan(Boolean value) {
            addCriterion("convalidated >", value, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("convalidated >=", value, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedLessThan(Boolean value) {
            addCriterion("convalidated <", value, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedLessThanOrEqualTo(Boolean value) {
            addCriterion("convalidated <=", value, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedIn(List<Boolean> values) {
            addCriterion("convalidated in", values, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedNotIn(List<Boolean> values) {
            addCriterion("convalidated not in", values, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedBetween(Boolean value1, Boolean value2) {
            addCriterion("convalidated between", value1, value2, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConvalidatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("convalidated not between", value1, value2, "convalidated");
            return (Criteria) this;
        }

        public Criteria andConrelidIsNull() {
            addCriterion("conrelid is null");
            return (Criteria) this;
        }

        public Criteria andConrelidIsNotNull() {
            addCriterion("conrelid is not null");
            return (Criteria) this;
        }

        public Criteria andConrelidEqualTo(Long value) {
            addCriterion("conrelid =", value, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidNotEqualTo(Long value) {
            addCriterion("conrelid <>", value, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidGreaterThan(Long value) {
            addCriterion("conrelid >", value, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("conrelid >=", value, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidLessThan(Long value) {
            addCriterion("conrelid <", value, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidLessThanOrEqualTo(Long value) {
            addCriterion("conrelid <=", value, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidIn(List<Long> values) {
            addCriterion("conrelid in", values, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidNotIn(List<Long> values) {
            addCriterion("conrelid not in", values, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidBetween(Long value1, Long value2) {
            addCriterion("conrelid between", value1, value2, "conrelid");
            return (Criteria) this;
        }

        public Criteria andConrelidNotBetween(Long value1, Long value2) {
            addCriterion("conrelid not between", value1, value2, "conrelid");
            return (Criteria) this;
        }

        public Criteria andContypidIsNull() {
            addCriterion("contypid is null");
            return (Criteria) this;
        }

        public Criteria andContypidIsNotNull() {
            addCriterion("contypid is not null");
            return (Criteria) this;
        }

        public Criteria andContypidEqualTo(Long value) {
            addCriterion("contypid =", value, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidNotEqualTo(Long value) {
            addCriterion("contypid <>", value, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidGreaterThan(Long value) {
            addCriterion("contypid >", value, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidGreaterThanOrEqualTo(Long value) {
            addCriterion("contypid >=", value, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidLessThan(Long value) {
            addCriterion("contypid <", value, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidLessThanOrEqualTo(Long value) {
            addCriterion("contypid <=", value, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidIn(List<Long> values) {
            addCriterion("contypid in", values, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidNotIn(List<Long> values) {
            addCriterion("contypid not in", values, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidBetween(Long value1, Long value2) {
            addCriterion("contypid between", value1, value2, "contypid");
            return (Criteria) this;
        }

        public Criteria andContypidNotBetween(Long value1, Long value2) {
            addCriterion("contypid not between", value1, value2, "contypid");
            return (Criteria) this;
        }

        public Criteria andConindidIsNull() {
            addCriterion("conindid is null");
            return (Criteria) this;
        }

        public Criteria andConindidIsNotNull() {
            addCriterion("conindid is not null");
            return (Criteria) this;
        }

        public Criteria andConindidEqualTo(Long value) {
            addCriterion("conindid =", value, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidNotEqualTo(Long value) {
            addCriterion("conindid <>", value, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidGreaterThan(Long value) {
            addCriterion("conindid >", value, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidGreaterThanOrEqualTo(Long value) {
            addCriterion("conindid >=", value, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidLessThan(Long value) {
            addCriterion("conindid <", value, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidLessThanOrEqualTo(Long value) {
            addCriterion("conindid <=", value, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidIn(List<Long> values) {
            addCriterion("conindid in", values, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidNotIn(List<Long> values) {
            addCriterion("conindid not in", values, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidBetween(Long value1, Long value2) {
            addCriterion("conindid between", value1, value2, "conindid");
            return (Criteria) this;
        }

        public Criteria andConindidNotBetween(Long value1, Long value2) {
            addCriterion("conindid not between", value1, value2, "conindid");
            return (Criteria) this;
        }

        public Criteria andConfrelidIsNull() {
            addCriterion("confrelid is null");
            return (Criteria) this;
        }

        public Criteria andConfrelidIsNotNull() {
            addCriterion("confrelid is not null");
            return (Criteria) this;
        }

        public Criteria andConfrelidEqualTo(Long value) {
            addCriterion("confrelid =", value, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidNotEqualTo(Long value) {
            addCriterion("confrelid <>", value, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidGreaterThan(Long value) {
            addCriterion("confrelid >", value, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("confrelid >=", value, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidLessThan(Long value) {
            addCriterion("confrelid <", value, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidLessThanOrEqualTo(Long value) {
            addCriterion("confrelid <=", value, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidIn(List<Long> values) {
            addCriterion("confrelid in", values, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidNotIn(List<Long> values) {
            addCriterion("confrelid not in", values, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidBetween(Long value1, Long value2) {
            addCriterion("confrelid between", value1, value2, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfrelidNotBetween(Long value1, Long value2) {
            addCriterion("confrelid not between", value1, value2, "confrelid");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeIsNull() {
            addCriterion("confupdtype is null");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeIsNotNull() {
            addCriterion("confupdtype is not null");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeEqualTo(String value) {
            addCriterion("confupdtype =", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeNotEqualTo(String value) {
            addCriterion("confupdtype <>", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeGreaterThan(String value) {
            addCriterion("confupdtype >", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeGreaterThanOrEqualTo(String value) {
            addCriterion("confupdtype >=", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeLessThan(String value) {
            addCriterion("confupdtype <", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeLessThanOrEqualTo(String value) {
            addCriterion("confupdtype <=", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeLike(String value) {
            addCriterion("confupdtype like", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeNotLike(String value) {
            addCriterion("confupdtype not like", value, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeIn(List<String> values) {
            addCriterion("confupdtype in", values, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeNotIn(List<String> values) {
            addCriterion("confupdtype not in", values, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeBetween(String value1, String value2) {
            addCriterion("confupdtype between", value1, value2, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfupdtypeNotBetween(String value1, String value2) {
            addCriterion("confupdtype not between", value1, value2, "confupdtype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeIsNull() {
            addCriterion("confdeltype is null");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeIsNotNull() {
            addCriterion("confdeltype is not null");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeEqualTo(String value) {
            addCriterion("confdeltype =", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeNotEqualTo(String value) {
            addCriterion("confdeltype <>", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeGreaterThan(String value) {
            addCriterion("confdeltype >", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeGreaterThanOrEqualTo(String value) {
            addCriterion("confdeltype >=", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeLessThan(String value) {
            addCriterion("confdeltype <", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeLessThanOrEqualTo(String value) {
            addCriterion("confdeltype <=", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeLike(String value) {
            addCriterion("confdeltype like", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeNotLike(String value) {
            addCriterion("confdeltype not like", value, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeIn(List<String> values) {
            addCriterion("confdeltype in", values, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeNotIn(List<String> values) {
            addCriterion("confdeltype not in", values, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeBetween(String value1, String value2) {
            addCriterion("confdeltype between", value1, value2, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfdeltypeNotBetween(String value1, String value2) {
            addCriterion("confdeltype not between", value1, value2, "confdeltype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeIsNull() {
            addCriterion("confmatchtype is null");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeIsNotNull() {
            addCriterion("confmatchtype is not null");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeEqualTo(String value) {
            addCriterion("confmatchtype =", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeNotEqualTo(String value) {
            addCriterion("confmatchtype <>", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeGreaterThan(String value) {
            addCriterion("confmatchtype >", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeGreaterThanOrEqualTo(String value) {
            addCriterion("confmatchtype >=", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeLessThan(String value) {
            addCriterion("confmatchtype <", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeLessThanOrEqualTo(String value) {
            addCriterion("confmatchtype <=", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeLike(String value) {
            addCriterion("confmatchtype like", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeNotLike(String value) {
            addCriterion("confmatchtype not like", value, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeIn(List<String> values) {
            addCriterion("confmatchtype in", values, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeNotIn(List<String> values) {
            addCriterion("confmatchtype not in", values, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeBetween(String value1, String value2) {
            addCriterion("confmatchtype between", value1, value2, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConfmatchtypeNotBetween(String value1, String value2) {
            addCriterion("confmatchtype not between", value1, value2, "confmatchtype");
            return (Criteria) this;
        }

        public Criteria andConislocalIsNull() {
            addCriterion("conislocal is null");
            return (Criteria) this;
        }

        public Criteria andConislocalIsNotNull() {
            addCriterion("conislocal is not null");
            return (Criteria) this;
        }

        public Criteria andConislocalEqualTo(Boolean value) {
            addCriterion("conislocal =", value, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalNotEqualTo(Boolean value) {
            addCriterion("conislocal <>", value, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalGreaterThan(Boolean value) {
            addCriterion("conislocal >", value, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("conislocal >=", value, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalLessThan(Boolean value) {
            addCriterion("conislocal <", value, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalLessThanOrEqualTo(Boolean value) {
            addCriterion("conislocal <=", value, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalIn(List<Boolean> values) {
            addCriterion("conislocal in", values, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalNotIn(List<Boolean> values) {
            addCriterion("conislocal not in", values, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalBetween(Boolean value1, Boolean value2) {
            addCriterion("conislocal between", value1, value2, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConislocalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("conislocal not between", value1, value2, "conislocal");
            return (Criteria) this;
        }

        public Criteria andConinhcountIsNull() {
            addCriterion("coninhcount is null");
            return (Criteria) this;
        }

        public Criteria andConinhcountIsNotNull() {
            addCriterion("coninhcount is not null");
            return (Criteria) this;
        }

        public Criteria andConinhcountEqualTo(Integer value) {
            addCriterion("coninhcount =", value, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountNotEqualTo(Integer value) {
            addCriterion("coninhcount <>", value, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountGreaterThan(Integer value) {
            addCriterion("coninhcount >", value, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coninhcount >=", value, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountLessThan(Integer value) {
            addCriterion("coninhcount <", value, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountLessThanOrEqualTo(Integer value) {
            addCriterion("coninhcount <=", value, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountIn(List<Integer> values) {
            addCriterion("coninhcount in", values, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountNotIn(List<Integer> values) {
            addCriterion("coninhcount not in", values, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountBetween(Integer value1, Integer value2) {
            addCriterion("coninhcount between", value1, value2, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConinhcountNotBetween(Integer value1, Integer value2) {
            addCriterion("coninhcount not between", value1, value2, "coninhcount");
            return (Criteria) this;
        }

        public Criteria andConnoinheritIsNull() {
            addCriterion("connoinherit is null");
            return (Criteria) this;
        }

        public Criteria andConnoinheritIsNotNull() {
            addCriterion("connoinherit is not null");
            return (Criteria) this;
        }

        public Criteria andConnoinheritEqualTo(Boolean value) {
            addCriterion("connoinherit =", value, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritNotEqualTo(Boolean value) {
            addCriterion("connoinherit <>", value, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritGreaterThan(Boolean value) {
            addCriterion("connoinherit >", value, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritGreaterThanOrEqualTo(Boolean value) {
            addCriterion("connoinherit >=", value, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritLessThan(Boolean value) {
            addCriterion("connoinherit <", value, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritLessThanOrEqualTo(Boolean value) {
            addCriterion("connoinherit <=", value, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritIn(List<Boolean> values) {
            addCriterion("connoinherit in", values, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritNotIn(List<Boolean> values) {
            addCriterion("connoinherit not in", values, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritBetween(Boolean value1, Boolean value2) {
            addCriterion("connoinherit between", value1, value2, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConnoinheritNotBetween(Boolean value1, Boolean value2) {
            addCriterion("connoinherit not between", value1, value2, "connoinherit");
            return (Criteria) this;
        }

        public Criteria andConkeyIsNull() {
            addCriterion("conkey is null");
            return (Criteria) this;
        }

        public Criteria andConkeyIsNotNull() {
            addCriterion("conkey is not null");
            return (Criteria) this;
        }

        public Criteria andConkeyEqualTo(Object value) {
            addCriterion("conkey =", value, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyNotEqualTo(Object value) {
            addCriterion("conkey <>", value, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyGreaterThan(Object value) {
            addCriterion("conkey >", value, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyGreaterThanOrEqualTo(Object value) {
            addCriterion("conkey >=", value, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyLessThan(Object value) {
            addCriterion("conkey <", value, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyLessThanOrEqualTo(Object value) {
            addCriterion("conkey <=", value, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyIn(List<Object> values) {
            addCriterion("conkey in", values, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyNotIn(List<Object> values) {
            addCriterion("conkey not in", values, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyBetween(Object value1, Object value2) {
            addCriterion("conkey between", value1, value2, "conkey");
            return (Criteria) this;
        }

        public Criteria andConkeyNotBetween(Object value1, Object value2) {
            addCriterion("conkey not between", value1, value2, "conkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyIsNull() {
            addCriterion("confkey is null");
            return (Criteria) this;
        }

        public Criteria andConfkeyIsNotNull() {
            addCriterion("confkey is not null");
            return (Criteria) this;
        }

        public Criteria andConfkeyEqualTo(Object value) {
            addCriterion("confkey =", value, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyNotEqualTo(Object value) {
            addCriterion("confkey <>", value, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyGreaterThan(Object value) {
            addCriterion("confkey >", value, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyGreaterThanOrEqualTo(Object value) {
            addCriterion("confkey >=", value, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyLessThan(Object value) {
            addCriterion("confkey <", value, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyLessThanOrEqualTo(Object value) {
            addCriterion("confkey <=", value, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyIn(List<Object> values) {
            addCriterion("confkey in", values, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyNotIn(List<Object> values) {
            addCriterion("confkey not in", values, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyBetween(Object value1, Object value2) {
            addCriterion("confkey between", value1, value2, "confkey");
            return (Criteria) this;
        }

        public Criteria andConfkeyNotBetween(Object value1, Object value2) {
            addCriterion("confkey not between", value1, value2, "confkey");
            return (Criteria) this;
        }

        public Criteria andConpfeqopIsNull() {
            addCriterion("conpfeqop is null");
            return (Criteria) this;
        }

        public Criteria andConpfeqopIsNotNull() {
            addCriterion("conpfeqop is not null");
            return (Criteria) this;
        }

        public Criteria andConpfeqopEqualTo(Object value) {
            addCriterion("conpfeqop =", value, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopNotEqualTo(Object value) {
            addCriterion("conpfeqop <>", value, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopGreaterThan(Object value) {
            addCriterion("conpfeqop >", value, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopGreaterThanOrEqualTo(Object value) {
            addCriterion("conpfeqop >=", value, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopLessThan(Object value) {
            addCriterion("conpfeqop <", value, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopLessThanOrEqualTo(Object value) {
            addCriterion("conpfeqop <=", value, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopIn(List<Object> values) {
            addCriterion("conpfeqop in", values, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopNotIn(List<Object> values) {
            addCriterion("conpfeqop not in", values, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopBetween(Object value1, Object value2) {
            addCriterion("conpfeqop between", value1, value2, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConpfeqopNotBetween(Object value1, Object value2) {
            addCriterion("conpfeqop not between", value1, value2, "conpfeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopIsNull() {
            addCriterion("conppeqop is null");
            return (Criteria) this;
        }

        public Criteria andConppeqopIsNotNull() {
            addCriterion("conppeqop is not null");
            return (Criteria) this;
        }

        public Criteria andConppeqopEqualTo(Object value) {
            addCriterion("conppeqop =", value, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopNotEqualTo(Object value) {
            addCriterion("conppeqop <>", value, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopGreaterThan(Object value) {
            addCriterion("conppeqop >", value, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopGreaterThanOrEqualTo(Object value) {
            addCriterion("conppeqop >=", value, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopLessThan(Object value) {
            addCriterion("conppeqop <", value, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopLessThanOrEqualTo(Object value) {
            addCriterion("conppeqop <=", value, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopIn(List<Object> values) {
            addCriterion("conppeqop in", values, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopNotIn(List<Object> values) {
            addCriterion("conppeqop not in", values, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopBetween(Object value1, Object value2) {
            addCriterion("conppeqop between", value1, value2, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConppeqopNotBetween(Object value1, Object value2) {
            addCriterion("conppeqop not between", value1, value2, "conppeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopIsNull() {
            addCriterion("conffeqop is null");
            return (Criteria) this;
        }

        public Criteria andConffeqopIsNotNull() {
            addCriterion("conffeqop is not null");
            return (Criteria) this;
        }

        public Criteria andConffeqopEqualTo(Object value) {
            addCriterion("conffeqop =", value, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopNotEqualTo(Object value) {
            addCriterion("conffeqop <>", value, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopGreaterThan(Object value) {
            addCriterion("conffeqop >", value, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopGreaterThanOrEqualTo(Object value) {
            addCriterion("conffeqop >=", value, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopLessThan(Object value) {
            addCriterion("conffeqop <", value, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopLessThanOrEqualTo(Object value) {
            addCriterion("conffeqop <=", value, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopIn(List<Object> values) {
            addCriterion("conffeqop in", values, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopNotIn(List<Object> values) {
            addCriterion("conffeqop not in", values, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopBetween(Object value1, Object value2) {
            addCriterion("conffeqop between", value1, value2, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConffeqopNotBetween(Object value1, Object value2) {
            addCriterion("conffeqop not between", value1, value2, "conffeqop");
            return (Criteria) this;
        }

        public Criteria andConexclopIsNull() {
            addCriterion("conexclop is null");
            return (Criteria) this;
        }

        public Criteria andConexclopIsNotNull() {
            addCriterion("conexclop is not null");
            return (Criteria) this;
        }

        public Criteria andConexclopEqualTo(Object value) {
            addCriterion("conexclop =", value, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopNotEqualTo(Object value) {
            addCriterion("conexclop <>", value, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopGreaterThan(Object value) {
            addCriterion("conexclop >", value, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopGreaterThanOrEqualTo(Object value) {
            addCriterion("conexclop >=", value, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopLessThan(Object value) {
            addCriterion("conexclop <", value, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopLessThanOrEqualTo(Object value) {
            addCriterion("conexclop <=", value, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopIn(List<Object> values) {
            addCriterion("conexclop in", values, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopNotIn(List<Object> values) {
            addCriterion("conexclop not in", values, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopBetween(Object value1, Object value2) {
            addCriterion("conexclop between", value1, value2, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConexclopNotBetween(Object value1, Object value2) {
            addCriterion("conexclop not between", value1, value2, "conexclop");
            return (Criteria) this;
        }

        public Criteria andConbinIsNull() {
            addCriterion("conbin is null");
            return (Criteria) this;
        }

        public Criteria andConbinIsNotNull() {
            addCriterion("conbin is not null");
            return (Criteria) this;
        }

        public Criteria andConbinEqualTo(Object value) {
            addCriterion("conbin =", value, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinNotEqualTo(Object value) {
            addCriterion("conbin <>", value, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinGreaterThan(Object value) {
            addCriterion("conbin >", value, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinGreaterThanOrEqualTo(Object value) {
            addCriterion("conbin >=", value, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinLessThan(Object value) {
            addCriterion("conbin <", value, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinLessThanOrEqualTo(Object value) {
            addCriterion("conbin <=", value, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinIn(List<Object> values) {
            addCriterion("conbin in", values, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinNotIn(List<Object> values) {
            addCriterion("conbin not in", values, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinBetween(Object value1, Object value2) {
            addCriterion("conbin between", value1, value2, "conbin");
            return (Criteria) this;
        }

        public Criteria andConbinNotBetween(Object value1, Object value2) {
            addCriterion("conbin not between", value1, value2, "conbin");
            return (Criteria) this;
        }

        public Criteria andConsrcIsNull() {
            addCriterion("consrc is null");
            return (Criteria) this;
        }

        public Criteria andConsrcIsNotNull() {
            addCriterion("consrc is not null");
            return (Criteria) this;
        }

        public Criteria andConsrcEqualTo(String value) {
            addCriterion("consrc =", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcNotEqualTo(String value) {
            addCriterion("consrc <>", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcGreaterThan(String value) {
            addCriterion("consrc >", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcGreaterThanOrEqualTo(String value) {
            addCriterion("consrc >=", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcLessThan(String value) {
            addCriterion("consrc <", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcLessThanOrEqualTo(String value) {
            addCriterion("consrc <=", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcLike(String value) {
            addCriterion("consrc like", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcNotLike(String value) {
            addCriterion("consrc not like", value, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcIn(List<String> values) {
            addCriterion("consrc in", values, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcNotIn(List<String> values) {
            addCriterion("consrc not in", values, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcBetween(String value1, String value2) {
            addCriterion("consrc between", value1, value2, "consrc");
            return (Criteria) this;
        }

        public Criteria andConsrcNotBetween(String value1, String value2) {
            addCriterion("consrc not between", value1, value2, "consrc");
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