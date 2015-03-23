package com.friday.model;

import java.util.Date;


/**
 * 订单入库
 * @author HelloMoTo
 *
 */
public class InStock {
    private String iId;//id

    private String uId;

    private String oId;//订单id

    private Date iDate;//入库时间

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId == null ? null : iId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

	public Date getiDate() {
		return iDate;
	}

	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}



}