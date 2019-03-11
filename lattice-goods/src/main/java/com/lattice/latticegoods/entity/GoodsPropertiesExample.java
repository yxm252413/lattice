package com.lattice.latticegoods.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsPropertiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsPropertiesExample() {
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

        public Criteria andProidIsNull() {
            addCriterion("proID is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proID is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Integer value) {
            addCriterion("proID =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Integer value) {
            addCriterion("proID <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Integer value) {
            addCriterion("proID >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proID >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Integer value) {
            addCriterion("proID <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Integer value) {
            addCriterion("proID <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Integer> values) {
            addCriterion("proID in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Integer> values) {
            addCriterion("proID not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Integer value1, Integer value2) {
            addCriterion("proID between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Integer value1, Integer value2) {
            addCriterion("proID not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andPronameidIsNull() {
            addCriterion("proNameID is null");
            return (Criteria) this;
        }

        public Criteria andPronameidIsNotNull() {
            addCriterion("proNameID is not null");
            return (Criteria) this;
        }

        public Criteria andPronameidEqualTo(Integer value) {
            addCriterion("proNameID =", value, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidNotEqualTo(Integer value) {
            addCriterion("proNameID <>", value, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidGreaterThan(Integer value) {
            addCriterion("proNameID >", value, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proNameID >=", value, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidLessThan(Integer value) {
            addCriterion("proNameID <", value, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidLessThanOrEqualTo(Integer value) {
            addCriterion("proNameID <=", value, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidIn(List<Integer> values) {
            addCriterion("proNameID in", values, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidNotIn(List<Integer> values) {
            addCriterion("proNameID not in", values, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidBetween(Integer value1, Integer value2) {
            addCriterion("proNameID between", value1, value2, "pronameid");
            return (Criteria) this;
        }

        public Criteria andPronameidNotBetween(Integer value1, Integer value2) {
            addCriterion("proNameID not between", value1, value2, "pronameid");
            return (Criteria) this;
        }

        public Criteria andProvalueidIsNull() {
            addCriterion("proValueID is null");
            return (Criteria) this;
        }

        public Criteria andProvalueidIsNotNull() {
            addCriterion("proValueID is not null");
            return (Criteria) this;
        }

        public Criteria andProvalueidEqualTo(Integer value) {
            addCriterion("proValueID =", value, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidNotEqualTo(Integer value) {
            addCriterion("proValueID <>", value, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidGreaterThan(Integer value) {
            addCriterion("proValueID >", value, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proValueID >=", value, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidLessThan(Integer value) {
            addCriterion("proValueID <", value, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidLessThanOrEqualTo(Integer value) {
            addCriterion("proValueID <=", value, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidIn(List<Integer> values) {
            addCriterion("proValueID in", values, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidNotIn(List<Integer> values) {
            addCriterion("proValueID not in", values, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidBetween(Integer value1, Integer value2) {
            addCriterion("proValueID between", value1, value2, "provalueid");
            return (Criteria) this;
        }

        public Criteria andProvalueidNotBetween(Integer value1, Integer value2) {
            addCriterion("proValueID not between", value1, value2, "provalueid");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNull() {
            addCriterion("skuID is null");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNotNull() {
            addCriterion("skuID is not null");
            return (Criteria) this;
        }

        public Criteria andSkuidEqualTo(Integer value) {
            addCriterion("skuID =", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotEqualTo(Integer value) {
            addCriterion("skuID <>", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThan(Integer value) {
            addCriterion("skuID >", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("skuID >=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThan(Integer value) {
            addCriterion("skuID <", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThanOrEqualTo(Integer value) {
            addCriterion("skuID <=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidIn(List<Integer> values) {
            addCriterion("skuID in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotIn(List<Integer> values) {
            addCriterion("skuID not in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidBetween(Integer value1, Integer value2) {
            addCriterion("skuID between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotBetween(Integer value1, Integer value2) {
            addCriterion("skuID not between", value1, value2, "skuid");
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