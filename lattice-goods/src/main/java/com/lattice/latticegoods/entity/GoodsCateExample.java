package com.lattice.latticegoods.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsCateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsCateExample() {
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

        public Criteria andCateidIsNull() {
            addCriterion("cateID is null");
            return (Criteria) this;
        }

        public Criteria andCateidIsNotNull() {
            addCriterion("cateID is not null");
            return (Criteria) this;
        }

        public Criteria andCateidEqualTo(Integer value) {
            addCriterion("cateID =", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotEqualTo(Integer value) {
            addCriterion("cateID <>", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThan(Integer value) {
            addCriterion("cateID >", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cateID >=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThan(Integer value) {
            addCriterion("cateID <", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThanOrEqualTo(Integer value) {
            addCriterion("cateID <=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidIn(List<Integer> values) {
            addCriterion("cateID in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotIn(List<Integer> values) {
            addCriterion("cateID not in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidBetween(Integer value1, Integer value2) {
            addCriterion("cateID between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotBetween(Integer value1, Integer value2) {
            addCriterion("cateID not between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andOrdIsNull() {
            addCriterion("ord is null");
            return (Criteria) this;
        }

        public Criteria andOrdIsNotNull() {
            addCriterion("ord is not null");
            return (Criteria) this;
        }

        public Criteria andOrdEqualTo(Integer value) {
            addCriterion("ord =", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotEqualTo(Integer value) {
            addCriterion("ord <>", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdGreaterThan(Integer value) {
            addCriterion("ord >", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ord >=", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdLessThan(Integer value) {
            addCriterion("ord <", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdLessThanOrEqualTo(Integer value) {
            addCriterion("ord <=", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdIn(List<Integer> values) {
            addCriterion("ord in", values, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotIn(List<Integer> values) {
            addCriterion("ord not in", values, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdBetween(Integer value1, Integer value2) {
            addCriterion("ord between", value1, value2, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotBetween(Integer value1, Integer value2) {
            addCriterion("ord not between", value1, value2, "ord");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andFatherIsNull() {
            addCriterion("father is null");
            return (Criteria) this;
        }

        public Criteria andFatherIsNotNull() {
            addCriterion("father is not null");
            return (Criteria) this;
        }

        public Criteria andFatherEqualTo(Integer value) {
            addCriterion("father =", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotEqualTo(Integer value) {
            addCriterion("father <>", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherGreaterThan(Integer value) {
            addCriterion("father >", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherGreaterThanOrEqualTo(Integer value) {
            addCriterion("father >=", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherLessThan(Integer value) {
            addCriterion("father <", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherLessThanOrEqualTo(Integer value) {
            addCriterion("father <=", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherIn(List<Integer> values) {
            addCriterion("father in", values, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotIn(List<Integer> values) {
            addCriterion("father not in", values, "father");
            return (Criteria) this;
        }

        public Criteria andFatherBetween(Integer value1, Integer value2) {
            addCriterion("father between", value1, value2, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotBetween(Integer value1, Integer value2) {
            addCriterion("father not between", value1, value2, "father");
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