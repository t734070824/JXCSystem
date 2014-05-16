package com.friday.inter;

import java.util.List;

import com.friday.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String oId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String oId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> selectAll();
    
    List<Order> selectByStyle(int oStyle);
}