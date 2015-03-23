package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.User;
import com.friday.service.UserService;
import com.friday.service.impl.UserServiceImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		try {
			UserService userService = new UserServiceImpl();
			
			String uid = request.getParameter("account");
			String upwd = request.getParameter("password");
			if(null == uid || uid.equals("") || null == upwd || upwd.equals("")) {
				uid = (String) session.getAttribute("account");
				upwd = (String) session.getAttribute("password");
			}
			User user = userService.getUser(uid);
			
			if (user != null && user.getuPwd().equalsIgnoreCase(upwd)) {
				session.setAttribute("account", user.getuId());
				session.setAttribute("name", user.getuName());
				session.setAttribute("password", upwd);
				return new ModelAndView("index");
			}
			else {
				model.put("error", "fail");
				return new ModelAndView("login", model);
			}
		} catch (Exception e) {
			model.put("error", "fail");
			e.printStackTrace();
			return new ModelAndView("login", model);
		}
	}

}
