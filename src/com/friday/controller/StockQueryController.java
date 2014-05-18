package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
		// TODO Auto-generated method stub
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			StockQueryService stockQueryService = new StockQueryServiceImpl();
			String string = request.getParameter("sName").toString();
			model.put("stock", stockQueryService.stockQuery(string));
			model.put("shop", stockQueryService.shopQuery());
			model.put("sName", string);
		} catch (Exception e) {
			model.put("result","fail");
			e.printStackTrace();
			return new ModelAndView("stock_query",model);
		
		}
		
		return new ModelAndView("stock_query",model);
	}

}
