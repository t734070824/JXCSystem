package com.friday.service;

import java.util.Date;
import java.util.List;

import com.friday.model.Employee;

public interface StaffService {
	/**
	 * 添加一个新的员工
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	public int addStaff(Employee employee) throws Exception;
	
	/**
	 * 业务逻辑里是提示当天的。在controller新建一个当前时间的date对象传递过来。
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<Employee> remindBirthday(Date date) throws Exception;
	
	//获得员工列表
	public List<Employee> getAllStaffs() throws Exception;
	
	//
	public int deleteStaff(String id) throws Exception;
	
	

}
