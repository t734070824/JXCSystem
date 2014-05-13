package com.friday.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.UserMapper;
import com.friday.model.User;
import com.friday.service.UserService;
import com.friday.utils.SessionUtils;

public class UserServiceImpl implements UserService {
	
	@Override
	public int addUser(User user)  throws Exception{
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			userMapper.insert(user);
			sqlSession.commit();
			ret = 1;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ret;
	}
}
