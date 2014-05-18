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

public class SellLoadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			StockOutService stockOutService = new StockOutServiceImpl();
			
			Map<Integer, Object> map = new HashMap<Integer, Object>();
			List<Shop> shops = stockOutService.getAllShops();
			for (Shop shop : shops) {
				if (shop.getsId() == 1) {
					shops.remove(shop);
					break;
				}
			}
			
			for (Shop shop : shops) {
				List<Object> products = stockOutService.getProductByShop(shop.getsId());
				map.put(shop.getsId(), products);
			}
			
			model.put("shops", shops);
			model.put("shopproducts", map);
			return new ModelAndView("product_sale", model);
		} catch (Exception e) {
			model.put("error", "销售数据获取失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
