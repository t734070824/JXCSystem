package com.friday.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.service.StockInService;
import com.friday.service.impl.StockInServiceImpl;

public class THQueryController implements Controller {

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
			int oid = -1;
			if (!orderId.isEmpty()) {
				oid = Integer.parseInt(orderId);
			}
			
			StockInService stockInService = new StockInServiceImpl();
			
			List<Object> list = stockInService.queryReturn(start, end, oid);
			
			int pagecurrent = 0, pagecount = (list.size()-1) / 10 + 1;
			
			String page = request.getParameter("page");
			
			if (page!=null) {
				pagecurrent = Integer.parseInt(page);
			}
			
			list = list.subList(pagecurrent * 10, (pagecurrent*10 + 10) > list.size() ? list.size() : (pagecurrent*10 + 10));
			
			model.put("result", list);
			
			model.put("starttime", starttime);
			model.put("endtime", endtime);
			model.put("orderId", orderId);
			model.put("pagecurrent", pagecurrent);
			model.put("pagecount", pagecount);
			return new ModelAndView("Returns_records_query", model);
		} catch (Exception e) {
			model.put("error", "操作失败");
			e.printStackTrace();
			return new ModelAndView("error", model);
		}
	}

}
