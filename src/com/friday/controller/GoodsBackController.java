package com.friday.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.service.StockInService;
import com.friday.service.impl.StockInServiceImpl;

public class GoodsBackController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			StockInService stockInService = new StockInServiceImpl();
			HttpSession session = request.getSession();
			
			String uId = (String) session.getAttribute("account");
			String oid = request.getParameter("orderid");
			String timeString = request.getParameter("intime");
			String bz = request.getParameter("remark");
			Date date = timeString.isEmpty() ? new Date(System.currentTimeMillis()) : Date.valueOf(timeString);
			
			stockInService.goodsBack(oid, date, bz, uId);
			
			model.put("success", "成功");
			return new ModelAndView("success", model);
		} catch (Exception e) {
			
			model.put("error", "失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
