package com.friday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.Employee;
import com.friday.service.StaffService;
import com.friday.service.impl.StaffServiceImpl;

public class QueryAllStaffsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Employee> elist = null;

		try {
			StaffService staffService = new StaffServiceImpl();

			//String id = request.getParameter("id");

			elist = staffService.getAllStaffs();
			
			
			
			model.put("results", elist);
			return new ModelAndView("staff_management", model);
		} catch (Exception e) {

			model.put("result", "fail");
			model.put("success", "失败");
			e.printStackTrace();
			return new ModelAndView("success", model);
		}
	}

}
