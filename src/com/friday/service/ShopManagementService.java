package com.friday.service;

import java.util.List;

import com.friday.model.Shop;

public interface ShopManagementService {
	public List<Shop> shopShow() throws Exception;
	public int shopAdd(Shop shop) throws Exception;
	int shopDelete(Integer sId) throws Exception; 
			
}
