package com.friday.model;

import java.util.Date;

public class Employee {
    private String eId;

    private String eName;

    private String eSex;

    private String ePhone;

    private String eAddress;

    private Date eDate;

    private Float ePrice;

    private String eBz;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId == null ? null : eId.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex == null ? null : eSex.trim();
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone == null ? null : ePhone.trim();
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress == null ? null : eAddress.trim();
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public Float getePrice() {
        return ePrice;
    }

    public void setePrice(Float ePrice) {
        this.ePrice = ePrice;
    }

    public String geteBz() {
        return eBz;
    }

    public void seteBz(String eBz) {
        this.eBz = eBz == null ? null : eBz.trim();
    }
}