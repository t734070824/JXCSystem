package com.friday.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.Shop;
import com.friday.service.StockOutService;
import com.friday.service.impl.StockOutServiceImpl;

public class SellController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			
			StockOutService stockOutService = new StockOutServiceImpl();
			HttpSession session = request.getSession();
			
			String uId = (String) session.getAttribute("account");
			Map<Integer, Integer> stockOut = new HashMap<Integer, Integer>();
			String dateString = request.getParameter("outtime");
			Date date = dateString.isEmpty() ? new Date(System.currentTimeMillis()) : Date.valueOf(dateString);
			String bz = request.getParameter("remark");
			
			String shopIdString = request.getParameter("shopid");
			int shopId = Integer.parseInt(shopIdString);
			
			Map<String, String[]> paraMap = request.getParameterMap();
			Iterator<String> iterator = paraMap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				String value = paraMap.get(key)[0];
				Pattern pattern = Pattern.compile("[0-9]*");
				if (pattern.matcher(key).matches()) {
					if(value.isEmpty()) continue;
					stockOut.put(Integer.parseInt(key), Integer.parseInt(value));
				}
			}
			
			stockOutService.sell(stockOut, date, bz, uId, shopId);
			model.put("success", "产品销售成功");
			return new ModelAndView("success", model);
		} catch (Exception e) {
			model.put("error", "操作失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
