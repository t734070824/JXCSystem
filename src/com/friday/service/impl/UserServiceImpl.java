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
	
	@Override
	public User getUser(String account) throws Exception {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = SessionUtils.getSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			user = userMapper.selectByPrimaryKey(account);
		
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return user;
	}

	@Override
	public int updateByPrimaryKey(String uid, String password, String newpassword) throws Exception{
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			User user = userMapper.selectByPrimaryKey(uid);
			
			if(user != null && user.getuPwd().equals(password))
			{
				user.setuPwd(newpassword);
				userMapper.updateByPrimaryKey(user);
				sqlSession.commit();
				ret = 1;
			}
			else
			{
				ret = 0;				
			}
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ret;
	}
}
