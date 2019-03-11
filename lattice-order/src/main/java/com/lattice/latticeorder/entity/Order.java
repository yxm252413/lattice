package com.lattice.latticeorder.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    private Integer orderid;

    private String payment;

    private String paymentType;

    private String postFree;

    private Integer status;

    private Date created;

    private Date updated;

    private Date paymenttime;

    private Date consigntime;

    private Date endtime;

    private Date closetime;

    private String shippingname;

    private String shippingcode;

    private Integer userid;

    private String buyermessage;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getPostFree() {
        return postFree;
    }

    public void setPostFree(String postFree) {
        this.postFree = postFree == null ? null : postFree.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getPaymenttime() {
        return paymenttime;
    }

    public void setPaymenttime(Date paymenttime) {
        this.paymenttime = paymenttime;
    }

    public Date getConsigntime() {
        return consigntime;
    }

    public void setConsigntime(Date consigntime) {
        this.consigntime = consigntime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public String getShippingname() {
        return shippingname;
    }

    public void setShippingname(String shippingname) {
        this.shippingname = shippingname == null ? null : shippingname.trim();
    }

    public String getShippingcode() {
        return shippingcode;
    }

    public void setShippingcode(String shippingcode) {
        this.shippingcode = shippingcode == null ? null : shippingcode.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBuyermessage() {
        return buyermessage;
    }

    public void setBuyermessage(String buyermessage) {
        this.buyermessage = buyermessage == null ? null : buyermessage.trim();
    }
}