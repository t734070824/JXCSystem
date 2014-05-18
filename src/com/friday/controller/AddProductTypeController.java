package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.ProductType;
import com.friday.service.ProductMService;
import com.friday.service.impl.ProductMServiceImpl;

public class AddProductTypeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			ProductMService productMService = new ProductMServiceImpl();
			
			String typename = request.getParameter("typename");
			
			ProductType pt = new ProductType();
			pt.settType(typename);

			
			productMService.addType(pt);
			
			model.put("result", "success");
			model.put("success", "成功");
			return new ModelAndView("success", model);
		} catch (Exception e) {
			
			model.put("result", "fail");
			model.put("success", "失败");
			e.printStackTrace();
			return new ModelAndView("success", model);
		}
	}

}
