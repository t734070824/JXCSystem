package com.friday.service;

import com.friday.model.User;

public interface UserService {
	public int addUser(User user) throws Exception;
	public User getUser(String account) throws Exception;
	public  int updateByPrimaryKeySelective(User record)throws Exception;
}
