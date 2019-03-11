package com.lattice.latticeorder.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderShipping implements Serializable {
    private Integer ordershippingid;

    private String receivername;

    private String receiverphone;

    private String receiverstate;

    private String receivercity;

    private String receiverdistrict;

    private String receiveraddress;

    private String receiverzip;

    private Date created;

    private Date updated;

    private Integer orderid;

    public Integer getOrdershippingid() {
        return ordershippingid;
    }

    public void setOrdershippingid(Integer ordershippingid) {
        this.ordershippingid = ordershippingid;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone == null ? null : receiverphone.trim();
    }

    public String getReceiverstate() {
        return receiverstate;
    }

    public void setReceiverstate(String receiverstate) {
        this.receiverstate = receiverstate == null ? null : receiverstate.trim();
    }

    public String getReceivercity() {
        return receivercity;
    }

    public void setReceivercity(String receivercity) {
        this.receivercity = receivercity == null ? null : receivercity.trim();
    }

    public String getReceiverdistrict() {
        return receiverdistrict;
    }

    public void setReceiverdistrict(String receiverdistrict) {
        this.receiverdistrict = receiverdistrict == null ? null : receiverdistrict.trim();
    }

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress == null ? null : receiveraddress.trim();
    }

    public String getReceiverzip() {
        return receiverzip;
    }

    public void setReceiverzip(String receiverzip) {
        this.receiverzip = receiverzip == null ? null : receiverzip.trim();
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

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}