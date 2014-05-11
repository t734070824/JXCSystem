package com.friday.model;

import java.util.Date;

public class OutStock {
    private Integer oId;

    private Integer sId;

    private Date oDate;

    private String uId;

    private String oBz;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getoBz() {
        return oBz;
    }

    public void setoBz(String oBz) {
        this.oBz = oBz == null ? null : oBz.trim();
    }
}