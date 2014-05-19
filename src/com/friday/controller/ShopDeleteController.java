package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.service.ShopManagementService;
import com.friday.service.impl.ShopManagementServiceImpl;

public class ShopDeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			ShopManagementService shopManagementService = new ShopManagementServiceImpl();
			shopManagementService.shopDelete(Integer.parseInt(request.getParameter("sId")));
			//System.out.println("........"+Integer.parseInt(request.getParameter("sId")));
			
			model.put("shop", shopManagementService.shopShow());
			model.put("result", " 成功");
			//System.out.println("...."+model.values());
		} catch (Exception e) {
			model.put("result", "失败");
			e.printStackTrace();
			return new ModelAndView("success",model);
		}
		return new ModelAndView("shop_management",model);
	}

}
