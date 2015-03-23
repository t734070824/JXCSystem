package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.service.StockQueryService;
import com.friday.service.impl.StockQueryServiceImpl;

public class StockQueryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			StockQueryService stockQueryService = new StockQueryServiceImpl();

			int shopId = Integer.parseInt(request.getParameter("sName"));
			model.put("stock", stockQueryService.stockQuery(shopId));
			model.put("shop", stockQueryService.shopQuery());
			model.put("shopname", stockQueryService.QueryShopName(shopId));

		} catch (Exception e) {
			model.put("error","查询库存失败");
			e.printStackTrace();
			return new ModelAndView("error",model);
		}
		
		return new ModelAndView("stock_query",model);
	}

}
