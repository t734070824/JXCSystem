package com.friday.service;

import com.friday.model.ProductType;

public interface ProductMService {
	public int addType(ProductType productType) throws Exception;
	
	public ProductType getType(String name) throws Exception;

}
