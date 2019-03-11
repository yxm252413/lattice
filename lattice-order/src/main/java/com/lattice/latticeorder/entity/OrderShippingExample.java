package com.lattice.latticeorder.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderShippingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderShippingExample() {
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

        public Criteria andOrdershippingidIsNull() {
            addCriterion("orderShippingID is null");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidIsNotNull() {
            addCriterion("orderShippingID is not null");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidEqualTo(Integer value) {
            addCriterion("orderShippingID =", value, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidNotEqualTo(Integer value) {
            addCriterion("orderShippingID <>", value, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidGreaterThan(Integer value) {
            addCriterion("orderShippingID >", value, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderShippingID >=", value, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidLessThan(Integer value) {
            addCriterion("orderShippingID <", value, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidLessThanOrEqualTo(Integer value) {
            addCriterion("orderShippingID <=", value, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidIn(List<Integer> values) {
            addCriterion("orderShippingID in", values, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidNotIn(List<Integer> values) {
            addCriterion("orderShippingID not in", values, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidBetween(Integer value1, Integer value2) {
            addCriterion("orderShippingID between", value1, value2, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andOrdershippingidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderShippingID not between", value1, value2, "ordershippingid");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNull() {
            addCriterion("receiverName is null");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNotNull() {
            addCriterion("receiverName is not null");
            return (Criteria) this;
        }

        public Criteria andReceivernameEqualTo(String value) {
            addCriterion("receiverName =", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotEqualTo(String value) {
            addCriterion("receiverName <>", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThan(String value) {
            addCriterion("receiverName >", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThanOrEqualTo(String value) {
            addCriterion("receiverName >=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThan(String value) {
            addCriterion("receiverName <", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThanOrEqualTo(String value) {
            addCriterion("receiverName <=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLike(String value) {
            addCriterion("receiverName like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotLike(String value) {
            addCriterion("receiverName not like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameIn(List<String> values) {
            addCriterion("receiverName in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotIn(List<String> values) {
            addCriterion("receiverName not in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameBetween(String value1, String value2) {
            addCriterion("receiverName between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotBetween(String value1, String value2) {
            addCriterion("receiverName not between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNull() {
            addCriterion("receiverPhone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNotNull() {
            addCriterion("receiverPhone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneEqualTo(String value) {
            addCriterion("receiverPhone =", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotEqualTo(String value) {
            addCriterion("receiverPhone <>", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThan(String value) {
            addCriterion("receiverPhone >", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiverPhone >=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThan(String value) {
            addCriterion("receiverPhone <", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThanOrEqualTo(String value) {
            addCriterion("receiverPhone <=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLike(String value) {
            addCriterion("receiverPhone like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotLike(String value) {
            addCriterion("receiverPhone not like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIn(List<String> values) {
            addCriterion("receiverPhone in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotIn(List<String> values) {
            addCriterion("receiverPhone not in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneBetween(String value1, String value2) {
            addCriterion("receiverPhone between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotBetween(String value1, String value2) {
            addCriterion("receiverPhone not between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverstateIsNull() {
            addCriterion("receiverState is null");
            return (Criteria) this;
        }

        public Criteria andReceiverstateIsNotNull() {
            addCriterion("receiverState is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverstateEqualTo(String value) {
            addCriterion("receiverState =", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateNotEqualTo(String value) {
            addCriterion("receiverState <>", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateGreaterThan(String value) {
            addCriterion("receiverState >", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateGreaterThanOrEqualTo(String value) {
            addCriterion("receiverState >=", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateLessThan(String value) {
            addCriterion("receiverState <", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateLessThanOrEqualTo(String value) {
            addCriterion("receiverState <=", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateLike(String value) {
            addCriterion("receiverState like", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateNotLike(String value) {
            addCriterion("receiverState not like", value, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateIn(List<String> values) {
            addCriterion("receiverState in", values, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateNotIn(List<String> values) {
            addCriterion("receiverState not in", values, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateBetween(String value1, String value2) {
            addCriterion("receiverState between", value1, value2, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceiverstateNotBetween(String value1, String value2) {
            addCriterion("receiverState not between", value1, value2, "receiverstate");
            return (Criteria) this;
        }

        public Criteria andReceivercityIsNull() {
            addCriterion("receiverCity is null");
            return (Criteria) this;
        }

        public Criteria andReceivercityIsNotNull() {
            addCriterion("receiverCity is not null");
            return (Criteria) this;
        }

        public Criteria andReceivercityEqualTo(String value) {
            addCriterion("receiverCity =", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotEqualTo(String value) {
            addCriterion("receiverCity <>", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityGreaterThan(String value) {
            addCriterion("receiverCity >", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityGreaterThanOrEqualTo(String value) {
            addCriterion("receiverCity >=", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityLessThan(String value) {
            addCriterion("receiverCity <", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityLessThanOrEqualTo(String value) {
            addCriterion("receiverCity <=", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityLike(String value) {
            addCriterion("receiverCity like", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotLike(String value) {
            addCriterion("receiverCity not like", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityIn(List<String> values) {
            addCriterion("receiverCity in", values, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotIn(List<String> values) {
            addCriterion("receiverCity not in", values, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityBetween(String value1, String value2) {
            addCriterion("receiverCity between", value1, value2, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotBetween(String value1, String value2) {
            addCriterion("receiverCity not between", value1, value2, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictIsNull() {
            addCriterion("receiverDistrict is null");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictIsNotNull() {
            addCriterion("receiverDistrict is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictEqualTo(String value) {
            addCriterion("receiverDistrict =", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotEqualTo(String value) {
            addCriterion("receiverDistrict <>", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictGreaterThan(String value) {
            addCriterion("receiverDistrict >", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictGreaterThanOrEqualTo(String value) {
            addCriterion("receiverDistrict >=", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictLessThan(String value) {
            addCriterion("receiverDistrict <", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictLessThanOrEqualTo(String value) {
            addCriterion("receiverDistrict <=", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictLike(String value) {
            addCriterion("receiverDistrict like", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotLike(String value) {
            addCriterion("receiverDistrict not like", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictIn(List<String> values) {
            addCriterion("receiverDistrict in", values, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotIn(List<String> values) {
            addCriterion("receiverDistrict not in", values, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictBetween(String value1, String value2) {
            addCriterion("receiverDistrict between", value1, value2, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotBetween(String value1, String value2) {
            addCriterion("receiverDistrict not between", value1, value2, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNull() {
            addCriterion("receiverAddress is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNotNull() {
            addCriterion("receiverAddress is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressEqualTo(String value) {
            addCriterion("receiverAddress =", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotEqualTo(String value) {
            addCriterion("receiverAddress <>", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThan(String value) {
            addCriterion("receiverAddress >", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiverAddress >=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThan(String value) {
            addCriterion("receiverAddress <", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThanOrEqualTo(String value) {
            addCriterion("receiverAddress <=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLike(String value) {
            addCriterion("receiverAddress like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotLike(String value) {
            addCriterion("receiverAddress not like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIn(List<String> values) {
            addCriterion("receiverAddress in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotIn(List<String> values) {
            addCriterion("receiverAddress not in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressBetween(String value1, String value2) {
            addCriterion("receiverAddress between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotBetween(String value1, String value2) {
            addCriterion("receiverAddress not between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiverzipIsNull() {
            addCriterion("receiverZip is null");
            return (Criteria) this;
        }

        public Criteria andReceiverzipIsNotNull() {
            addCriterion("receiverZip is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverzipEqualTo(String value) {
            addCriterion("receiverZip =", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipNotEqualTo(String value) {
            addCriterion("receiverZip <>", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipGreaterThan(String value) {
            addCriterion("receiverZip >", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipGreaterThanOrEqualTo(String value) {
            addCriterion("receiverZip >=", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipLessThan(String value) {
            addCriterion("receiverZip <", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipLessThanOrEqualTo(String value) {
            addCriterion("receiverZip <=", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipLike(String value) {
            addCriterion("receiverZip like", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipNotLike(String value) {
            addCriterion("receiverZip not like", value, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipIn(List<String> values) {
            addCriterion("receiverZip in", values, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipNotIn(List<String> values) {
            addCriterion("receiverZip not in", values, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipBetween(String value1, String value2) {
            addCriterion("receiverZip between", value1, value2, "receiverzip");
            return (Criteria) this;
        }

        public Criteria andReceiverzipNotBetween(String value1, String value2) {
            addCriterion("receiverZip not between", value1, value2, "receiverzip");
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