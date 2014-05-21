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

public class ModifyCustomerLoadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();

		try {

			CustomerService customerService = new CustomerServiceImpl();

			String cidString = request.getParameter("cid");
			int cid = Integer.parseInt(cidString);
			
			Customer customer = customerService.queryCustomerById(cid);

			model.put("customer", customer);

			return new ModelAndView("modify_customer", model);
		} catch (Exception e) {
			model.put("error", "操作失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
