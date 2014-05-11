package com.friday.model;

import java.util.Date;

public class Sell {
    private Integer sId;

    private Integer shopId;

    private String uId;

    private Date sDate;

    private String sBz;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public String getsBz() {
        return sBz;
    }

    public void setsBz(String sBz) {
        this.sBz = sBz == null ? null : sBz.trim();
    }
}