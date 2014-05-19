package com.friday.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.friday.model.Shop;
import com.friday.model.Stock;

public interface StockQueryService {
	public List<Object> stockQuery(int shopId) throws Exception;
	public List<Shop> shopQuery() throws Exception;
	public String QueryShopName(int shopId) throws Exception;
}
