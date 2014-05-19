package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.service.ShopManagementService;
import com.friday.service.impl.ShopManagementServiceImpl;

public class ShopShowController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			ShopManagementService shopManagementService = new ShopManagementServiceImpl();
			model.put("shop", shopManagementService.shopShow());
		} catch (Exception e) {
			model.put("result", "fail");
			e.printStackTrace();
			return new ModelAndView("shop_management",model);
		}
		return new ModelAndView("shop_management",model);
	}

}
