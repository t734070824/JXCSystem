package com.friday.model;

public class InStockDetail {
    private Integer iId;

    private String instockId;//入库表中的入库id

    private Integer pId;//产品id

    private Integer iNum;//产品数量

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getInstockId() {
        return instockId;
    }

    public void setInstockId(String instockId) {
        this.instockId = instockId == null ? null : instockId.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getiNum() {
        return iNum;
    }

    public void setiNum(Integer iNum) {
        this.iNum = iNum;
    }
}