package com.friday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.Customer;
import com.friday.service.CustomerService;
import com.friday.service.impl.CustomerServiceImpl;

public class AddCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();

		try {

			CustomerService customerService = new CustomerServiceImpl();

			Customer customer = new Customer();
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String bz = request.getParameter("remark");
			
			customer.setcName(name);
			customer.setcPhone(phone);
			customer.setcAddress(address);
			customer.setcNote(bz);
			
			customerService.addCustomer(customer);
			
			List<Customer> list = customerService.queryCustomer();

			model.put("result", list);

			return new ModelAndView("customer_management", model);
		} catch (Exception e) {
			model.put("error", "操作失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
