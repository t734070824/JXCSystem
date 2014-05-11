package com.friday.inter;

import com.friday.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String eId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String eId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}