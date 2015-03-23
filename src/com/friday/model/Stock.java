package com.friday.model;

public class Stock {
    private Integer sId;//库存编号

    private Integer shopId;//网点编号

    private Integer pId;//产品编号

    private Integer sNum;//库存数量

    private Integer sMaxnum;

    private Integer sMinnum;

    private Float sPrice;//库存金额

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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }

    public Integer getsMaxnum() {
        return sMaxnum;
    }

    public void setsMaxnum(Integer sMaxnum) {
        this.sMaxnum = sMaxnum;
    }

    public Integer getsMinnum() {
        return sMinnum;
    }

    public void setsMinnum(Integer sMinnum) {
        this.sMinnum = sMinnum;
    }

    public Float getsPrice() {
        return sPrice;
    }

    public void setsPrice(Float sPrice) {
        this.sPrice = sPrice;
    }
}