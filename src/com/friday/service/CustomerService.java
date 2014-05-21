package com.friday.service;

import java.util.List;

import com.friday.model.Customer;

public interface CustomerService {
	List<Customer> queryCustomer() throws Exception;
	Customer queryCustomerById(int id) throws Exception;
	int modifyCustomer(Customer customer) throws Exception;
	int deleteCustomer(int id) throws Exception;
	int addCustomer(Customer customer) throws Exception;
}
