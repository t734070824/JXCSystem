package com.friday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.Shop;
import com.friday.model.User;
import com.friday.service.StockOutService;
import com.friday.service.UserService;
import com.friday.service.impl.StockOutServiceImpl;
import com.friday.service.impl.UserServiceImpl;

public class StockOutGetProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			StockOutService stockOutService = new StockOutServiceImpl();
			
			List<Object> products = stockOutService.getProductByShop(1);
			List<Shop> shops = stockOutService.getAllShops();
			for (Shop shop : shops) {
				if (shop.getsId() == 1) {
					shops.remove(shop);
					break;
				}
			}
			
			model.put("shops", shops);
			model.put("products", products);
			return new ModelAndView("product_out_storage", model);
		} catch (Exception e) {
			model.put("error", "读取库存失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
