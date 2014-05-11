package com.friday.model;

import java.util.Date;

public class Log {
    private Integer lId;

    private String lMsg;

    private Date lDate;

    private String uId;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public String getlMsg() {
        return lMsg;
    }

    public void setlMsg(String lMsg) {
        this.lMsg = lMsg == null ? null : lMsg.trim();
    }

    public Date getlDate() {
        return lDate;
    }

    public void setlDate(Date lDate) {
        this.lDate = lDate;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }
}