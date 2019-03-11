package com.lattice.latticeorder.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(String value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(String value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(String value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(String value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(String value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLike(String value) {
            addCriterion("payment like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotLike(String value) {
            addCriterion("payment not like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<String> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<String> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(String value1, String value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(String value1, String value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("payment_type like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("payment_type not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPostFreeIsNull() {
            addCriterion("post_free is null");
            return (Criteria) this;
        }

        public Criteria andPostFreeIsNotNull() {
            addCriterion("post_free is not null");
            return (Criteria) this;
        }

        public Criteria andPostFreeEqualTo(String value) {
            addCriterion("post_free =", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeNotEqualTo(String value) {
            addCriterion("post_free <>", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeGreaterThan(String value) {
            addCriterion("post_free >", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeGreaterThanOrEqualTo(String value) {
            addCriterion("post_free >=", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeLessThan(String value) {
            addCriterion("post_free <", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeLessThanOrEqualTo(String value) {
            addCriterion("post_free <=", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeLike(String value) {
            addCriterion("post_free like", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeNotLike(String value) {
            addCriterion("post_free not like", value, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeIn(List<String> values) {
            addCriterion("post_free in", values, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeNotIn(List<String> values) {
            addCriterion("post_free not in", values, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeBetween(String value1, String value2) {
            addCriterion("post_free between", value1, value2, "postFree");
            return (Criteria) this;
        }

        public Criteria andPostFreeNotBetween(String value1, String value2) {
            addCriterion("post_free not between", value1, value2, "postFree");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
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

        public Criteria andPaymenttimeIsNull() {
            addCriterion("paymentTime is null");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeIsNotNull() {
            addCriterion("paymentTime is not null");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeEqualTo(Date value) {
            addCriterion("paymentTime =", value, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeNotEqualTo(Date value) {
            addCriterion("paymentTime <>", value, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeGreaterThan(Date value) {
            addCriterion("paymentTime >", value, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paymentTime >=", value, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeLessThan(Date value) {
            addCriterion("paymentTime <", value, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeLessThanOrEqualTo(Date value) {
            addCriterion("paymentTime <=", value, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeIn(List<Date> values) {
            addCriterion("paymentTime in", values, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeNotIn(List<Date> values) {
            addCriterion("paymentTime not in", values, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeBetween(Date value1, Date value2) {
            addCriterion("paymentTime between", value1, value2, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andPaymenttimeNotBetween(Date value1, Date value2) {
            addCriterion("paymentTime not between", value1, value2, "paymenttime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeIsNull() {
            addCriterion("consignTime is null");
            return (Criteria) this;
        }

        public Criteria andConsigntimeIsNotNull() {
            addCriterion("consignTime is not null");
            return (Criteria) this;
        }

        public Criteria andConsigntimeEqualTo(Date value) {
            addCriterion("consignTime =", value, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeNotEqualTo(Date value) {
            addCriterion("consignTime <>", value, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeGreaterThan(Date value) {
            addCriterion("consignTime >", value, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("consignTime >=", value, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeLessThan(Date value) {
            addCriterion("consignTime <", value, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeLessThanOrEqualTo(Date value) {
            addCriterion("consignTime <=", value, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeIn(List<Date> values) {
            addCriterion("consignTime in", values, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeNotIn(List<Date> values) {
            addCriterion("consignTime not in", values, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeBetween(Date value1, Date value2) {
            addCriterion("consignTime between", value1, value2, "consigntime");
            return (Criteria) this;
        }

        public Criteria andConsigntimeNotBetween(Date value1, Date value2) {
            addCriterion("consignTime not between", value1, value2, "consigntime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andClosetimeIsNull() {
            addCriterion("closeTime is null");
            return (Criteria) this;
        }

        public Criteria andClosetimeIsNotNull() {
            addCriterion("closeTime is not null");
            return (Criteria) this;
        }

        public Criteria andClosetimeEqualTo(Date value) {
            addCriterion("closeTime =", value, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeNotEqualTo(Date value) {
            addCriterion("closeTime <>", value, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeGreaterThan(Date value) {
            addCriterion("closeTime >", value, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("closeTime >=", value, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeLessThan(Date value) {
            addCriterion("closeTime <", value, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeLessThanOrEqualTo(Date value) {
            addCriterion("closeTime <=", value, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeIn(List<Date> values) {
            addCriterion("closeTime in", values, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeNotIn(List<Date> values) {
            addCriterion("closeTime not in", values, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeBetween(Date value1, Date value2) {
            addCriterion("closeTime between", value1, value2, "closetime");
            return (Criteria) this;
        }

        public Criteria andClosetimeNotBetween(Date value1, Date value2) {
            addCriterion("closeTime not between", value1, value2, "closetime");
            return (Criteria) this;
        }

        public Criteria andShippingnameIsNull() {
            addCriterion("shippingName is null");
            return (Criteria) this;
        }

        public Criteria andShippingnameIsNotNull() {
            addCriterion("shippingName is not null");
            return (Criteria) this;
        }

        public Criteria andShippingnameEqualTo(String value) {
            addCriterion("shippingName =", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameNotEqualTo(String value) {
            addCriterion("shippingName <>", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameGreaterThan(String value) {
            addCriterion("shippingName >", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameGreaterThanOrEqualTo(String value) {
            addCriterion("shippingName >=", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameLessThan(String value) {
            addCriterion("shippingName <", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameLessThanOrEqualTo(String value) {
            addCriterion("shippingName <=", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameLike(String value) {
            addCriterion("shippingName like", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameNotLike(String value) {
            addCriterion("shippingName not like", value, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameIn(List<String> values) {
            addCriterion("shippingName in", values, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameNotIn(List<String> values) {
            addCriterion("shippingName not in", values, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameBetween(String value1, String value2) {
            addCriterion("shippingName between", value1, value2, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingnameNotBetween(String value1, String value2) {
            addCriterion("shippingName not between", value1, value2, "shippingname");
            return (Criteria) this;
        }

        public Criteria andShippingcodeIsNull() {
            addCriterion("shippingCode is null");
            return (Criteria) this;
        }

        public Criteria andShippingcodeIsNotNull() {
            addCriterion("shippingCode is not null");
            return (Criteria) this;
        }

        public Criteria andShippingcodeEqualTo(String value) {
            addCriterion("shippingCode =", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeNotEqualTo(String value) {
            addCriterion("shippingCode <>", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeGreaterThan(String value) {
            addCriterion("shippingCode >", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeGreaterThanOrEqualTo(String value) {
            addCriterion("shippingCode >=", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeLessThan(String value) {
            addCriterion("shippingCode <", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeLessThanOrEqualTo(String value) {
            addCriterion("shippingCode <=", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeLike(String value) {
            addCriterion("shippingCode like", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeNotLike(String value) {
            addCriterion("shippingCode not like", value, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeIn(List<String> values) {
            addCriterion("shippingCode in", values, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeNotIn(List<String> values) {
            addCriterion("shippingCode not in", values, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeBetween(String value1, String value2) {
            addCriterion("shippingCode between", value1, value2, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andShippingcodeNotBetween(String value1, String value2) {
            addCriterion("shippingCode not between", value1, value2, "shippingcode");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBuyermessageIsNull() {
            addCriterion("buyerMessage is null");
            return (Criteria) this;
        }

        public Criteria andBuyermessageIsNotNull() {
            addCriterion("buyerMessage is not null");
            return (Criteria) this;
        }

        public Criteria andBuyermessageEqualTo(String value) {
            addCriterion("buyerMessage =", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageNotEqualTo(String value) {
            addCriterion("buyerMessage <>", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageGreaterThan(String value) {
            addCriterion("buyerMessage >", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageGreaterThanOrEqualTo(String value) {
            addCriterion("buyerMessage >=", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageLessThan(String value) {
            addCriterion("buyerMessage <", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageLessThanOrEqualTo(String value) {
            addCriterion("buyerMessage <=", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageLike(String value) {
            addCriterion("buyerMessage like", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageNotLike(String value) {
            addCriterion("buyerMessage not like", value, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageIn(List<String> values) {
            addCriterion("buyerMessage in", values, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageNotIn(List<String> values) {
            addCriterion("buyerMessage not in", values, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageBetween(String value1, String value2) {
            addCriterion("buyerMessage between", value1, value2, "buyermessage");
            return (Criteria) this;
        }

        public Criteria andBuyermessageNotBetween(String value1, String value2) {
            addCriterion("buyerMessage not between", value1, value2, "buyermessage");
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