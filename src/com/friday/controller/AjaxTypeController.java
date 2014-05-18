package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.ProductType;
import com.friday.service.ProductMService;
import com.friday.service.impl.ProductMServiceImpl;

public class AjaxTypeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		ProductType pt = null;
		try {
			ProductMService productMService = new ProductMServiceImpl();
			
			String name = request.getParameter("typename");
			System.out.println(name);
			
			 pt = productMService.getType(name);
			
			if (pt != null ) {
				 response.getWriter().print("已经存在");
				return null;
			}
			else {
				 response.getWriter().print("是新的");
				 return null;
			}
		} catch (Exception e) {
			model.put("error", "fail");
			return null;
		}
	}

}
