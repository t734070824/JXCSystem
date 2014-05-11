package com.friday.model;

import java.util.Date;

public class Order {
    private String oId;

    private String uId;

    private Date oDate;

    private String oBz;

    private Integer oStyle;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public String getoBz() {
        return oBz;
    }

    public void setoBz(String oBz) {
        this.oBz = oBz == null ? null : oBz.trim();
    }

    public Integer getoStyle() {
        return oStyle;
    }

    public void setoStyle(Integer oStyle) {
        this.oStyle = oStyle;
    }
}