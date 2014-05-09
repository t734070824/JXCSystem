package com.friday.service.impl;

import com.friday.inter.IAdmin;
import com.friday.model.Admin;
import com.friday.service.IAdminService;
import com.friday.utils.ApplicationContextUtils;

public class AdminService implements IAdminService {

	IAdmin adminDao = (IAdmin)ApplicationContextUtils.getBean("IAdmin");
	
	public int addAdmin(Admin admin) throws Exception{
		return adminDao.insert(admin);
	}

}
