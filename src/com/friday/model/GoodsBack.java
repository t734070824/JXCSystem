package com.friday.model;

import java.util.Date;

public class GoodsBack {
    private Integer gId;

    private Date gDate;

    private String uId;

    private Float gPrice;

    private Float gBackprice;

    private String gBz;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Date getgDate() {
        return gDate;
    }

    public void setgDate(Date gDate) {
        this.gDate = gDate;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Float getgPrice() {
        return gPrice;
    }

    public void setgPrice(Float gPrice) {
        this.gPrice = gPrice;
    }

    public Float getgBackprice() {
        return gBackprice;
    }

    public void setgBackprice(Float gBackprice) {
        this.gBackprice = gBackprice;
    }

    public String getgBz() {
        return gBz;
    }

    public void setgBz(String gBz) {
        this.gBz = gBz == null ? null : gBz.trim();
    }
}