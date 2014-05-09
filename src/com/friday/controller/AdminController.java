package com.friday.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.friday.model.Admin;
import com.friday.service.IAdminService;
import com.friday.service.impl.AdminService;
import org.springframework.web.servlet.mvc.Controller;

public class AdminController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		IAdminService adminService = new AdminService();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		Admin admin = new Admin();
		admin.setAccount(account);
		admin.setPassword(password);
		admin.setName(name);
		admin.setRemark("");
		
		int ret = 0;
		do {
			if (account.equals("") || password.equals("") || name.equals("")) {
				break;
			}
			
			try {
				ret = adminService.addAdmin(admin);
			} catch (Exception e) {
				break;
			}
		} while (false);
		
		Map<String, Object> model = new HashMap<String, Object>();
		if (ret > 0) {
			model.put("result", "success");
			return new ModelAndView("success", model);
		}
		else {
			model.put("result", "fail");
			return new ModelAndView("success", model);
		}
	}
}
