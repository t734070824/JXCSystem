package com.friday.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
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

public class RemindBirthdayController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Employee> elist = null;
		SimpleDateFormat simformat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simformat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		try {
			StaffService staffService = new StaffServiceImpl();

			Date date = new Date();
			String str1_birthday = simformat1.format(date);
			String str2_birthday = str1_birthday + " 00:00:00";
			
			
			Date birthday = simformat2.parse(str2_birthday);
			
			elist = staffService.remindBirthday(birthday);

			model.put("birthdays", elist);
			model.put("nowday", str1_birthday);
			return new ModelAndView("staff_birthday_remind", model);
		} catch (Exception e) {
			model.put("success", "失败");
			e.printStackTrace();
			return new ModelAndView("success", model);
		}
	}

}
