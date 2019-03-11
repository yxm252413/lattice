package com.lattice.latticegoods.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GoodsProValue implements Serializable {
    private static final long serialVersionUID = 8208951127088930539L;
    private Integer provalueid;

    private Integer nameid;

    private String value;

    private Byte status;

    private Date created;

    private Date updated;

    public Integer getProvalueid() {
        return provalueid;
    }

    public void setProvalueid(Integer provalueid) {
        this.provalueid = provalueid;
    }

    public Integer getNameid() {
        return nameid;
    }

    public void setNameid(Integer nameid) {
        this.nameid = nameid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
}