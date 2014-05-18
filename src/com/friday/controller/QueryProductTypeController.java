package com.friday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.ProductType;
import com.friday.service.ProductMService;
import com.friday.service.impl.ProductMServiceImpl;

public class QueryProductTypeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();

		try {

			ProductMService productMService = new ProductMServiceImpl();

			List<ProductType> list = productMService.getAllType();

			model.put("result", list);

			return new ModelAndView("class_management", model);
		} catch (Exception e) {
			model.put("error", "操作失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}
}
