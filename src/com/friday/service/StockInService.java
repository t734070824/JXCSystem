package com.friday.service;

import java.sql.Date;
import java.util.List;

public interface StockInService {
	int stockIn(String orderId, String inId, Date date, String bz, String uId) throws Exception;
	int goodsBack(String orderId, Date date, String bz, String uId) throws Exception;
	List<Object> queryStockIn(Date start, Date end, String orderId) throws Exception;
	List<Object> queryReturn(Date start, Date end, int orderId) throws Exception;
}
