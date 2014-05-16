package com.friday.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

import com.friday.service.OrderProductService;
import com.friday.service.impl.OrderProductServiceImpl;

public class QueryOrderController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			Date start = starttime.isEmpty() ? null : Date.valueOf(starttime);
			Date end = endtime.isEmpty() ? null : Date.valueOf(endtime);
			String orderId = request.getParameter("orderid");
			String state = request.getParameter("orderstate");
			int style = Integer.parseInt(state);
			
			OrderProductService orderProductService = new OrderProductServiceImpl();
			
			List<Object> list = orderProductService.queryOrder(start, end, style, orderId);
			
			model.put("result", list);
			
			return new ModelAndView("order_record_query", model);
		} catch (Exception e) {
			model.put("error", "操作失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
