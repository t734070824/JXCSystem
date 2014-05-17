package com.friday.service;

import java.sql.Date;

public interface StockInService {
	int stockIn(String orderId, String inId, Date date, String bz, String uId) throws Exception;
}
