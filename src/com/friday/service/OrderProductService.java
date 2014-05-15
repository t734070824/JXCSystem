package com.friday.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.friday.model.ProductType;

public interface OrderProductService {
	public Map<String, Object> getTypeAndProduct() throws Exception;
	
	public int orderProduct(Map<Integer, Integer> order, Date date, String bz , String uId, String oId) throws Exception;
}