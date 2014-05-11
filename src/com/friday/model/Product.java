package com.friday.model;

public class Product {
    private Integer pId;

    private String pName;

    private Integer tId;

    private String pStyle;

    private Float pPrice;

    private String pZt;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getpStyle() {
        return pStyle;
    }

    public void setpStyle(String pStyle) {
        this.pStyle = pStyle == null ? null : pStyle.trim();
    }

    public Float getpPrice() {
        return pPrice;
    }

    public void setpPrice(Float pPrice) {
        this.pPrice = pPrice;
    }

    public String getpZt() {
        return pZt;
    }

    public void setpZt(String pZt) {
        this.pZt = pZt == null ? null : pZt.trim();
    }
}