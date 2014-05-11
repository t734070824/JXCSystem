package com.friday.model;

public class Shop {
    private Integer sId;

    private String sName;

    private String sBz;

    private String sAddress;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsBz() {
        return sBz;
    }

    public void setsBz(String sBz) {
        this.sBz = sBz == null ? null : sBz.trim();
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }
}