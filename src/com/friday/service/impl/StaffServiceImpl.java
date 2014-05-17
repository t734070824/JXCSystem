package com.friday.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.EmployeeMapper;
import com.friday.model.Employee;
import com.friday.service.StaffService;
import com.friday.utils.SessionUtils;

public class StaffServiceImpl implements StaffService {

	@Override
	public int addStaff(Employee employee) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			
			employeeMapper.insertSelective(employee);
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
	public List<Employee> remindBirthday(Date date) throws Exception {
		
		return null;
	}

}
