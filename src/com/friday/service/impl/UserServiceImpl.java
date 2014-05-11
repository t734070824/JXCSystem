package com.friday.service.impl;

import com.friday.inter.UserMapper;
import com.friday.model.User;
import com.friday.service.UserService;
import com.friday.utils.ApplicationContextUtils;

public class UserServiceImpl implements UserService {

	UserMapper userMapper = (UserMapper) ApplicationContextUtils.getBean("UserMapper");
	
	@Override
	public int addUser(User user)  throws Exception{
		
		userMapper.insert(user);
		
		return 0;
	}

}
