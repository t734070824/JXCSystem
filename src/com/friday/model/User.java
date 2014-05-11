package com.friday.model;

public class User {
    private String uId;

    private String uPwd;

    private String uName;

    private String uBz;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuBz() {
        return uBz;
    }

    public void setuBz(String uBz) {
        this.uBz = uBz == null ? null : uBz.trim();
    }
}