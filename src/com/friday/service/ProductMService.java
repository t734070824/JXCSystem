package com.friday.service;

import java.util.List;

import com.friday.model.Product;
import com.friday.model.ProductType;

public interface ProductMService {
	public int addType(ProductType productType) throws Exception;
	
	public ProductType getType(String name) throws Exception;
	
	public List<ProductType> getAllType() throws Exception;
	
	public int removeType(int id) throws Exception;
	
	public List<Object> getProduct() throws Exception;
	
	public int removeProduct(int pid) throws Exception;
	
	public int addProduct(Product product) throws Exception;
	
	public int updateProduct(Product product) throws Exception;
	
	public Product getProductByid(int id) throws Exception;

}
