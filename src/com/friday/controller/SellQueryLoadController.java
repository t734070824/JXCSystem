package com.friday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.Shop;
import com.friday.service.StockOutService;
import com.friday.service.impl.StockOutServiceImpl;

public class SellQueryLoadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			StockOutService stockOutService = new StockOutServiceImpl();
			List<Shop> shops = stockOutService.getAllShops();
			Shop noShop = new Shop();
			noShop.setsId(0);
			noShop.setsName("全部网点");
			shops.add(0, noShop);
			for (Shop shop : shops) {
				if (shop.getsId() == 1) {
					shops.remove(shop);
					break;
				}
			}
			
			model.put("shops", shops);
		} catch (Exception e) {
			model.put("error","fail");
			e.printStackTrace();
			return new ModelAndView("error",model);
		
		}
		
		return new ModelAndView("product_sell_query",model);
	}

}
