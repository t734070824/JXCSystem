package com.friday.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.friday.model.Shop;
import com.friday.model.Stock;

public interface StockQueryService {
	public Map<Integer, Object> stockQuery(String sName) throws Exception;
	public List<Shop> shopQuery()throws Exception;

}
