package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.Shop;
import com.friday.service.ShopManagementService;
import com.friday.service.impl.ShopManagementServiceImpl;

public class ShopAddController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			ShopManagementService shopManagementService = new ShopManagementServiceImpl();
			Shop shop = new Shop();
			shop.setsAddress("");
			shop.setsBz(request.getParameter("shopBz").toString());
			shop.setsName(request.getParameter("shopName").toString());
			shopManagementService.shopAdd(shop);
			
			model.put("result","success");
			model.put("success", "成功");
			model.put("shop", shopManagementService.shopShow());
		} catch (Exception e) {
			model.put("result", "fail");
			model.put("success", "失败");
			e.printStackTrace();
			return new ModelAndView("success",model);

		}
		return new ModelAndView("shop_management",model);
	}

}
