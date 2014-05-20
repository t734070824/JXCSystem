package com.friday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.service.ProductMService;
import com.friday.service.impl.ProductMServiceImpl;

public class DeleteProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			ProductMService productMService = new ProductMServiceImpl();

			String pid = request.getParameter("pid");
			
			System.out.println(pid);
			
			productMService.removeProduct(Integer.parseInt(pid));
			
			List<Object> list = productMService.getProduct();

			model.put("result", list);

			return new ModelAndView("product_management", model);
		} catch (Exception e) {
			model.put("success", "失败");
			e.printStackTrace();
			return new ModelAndView("success", model);
		}
	}

}
