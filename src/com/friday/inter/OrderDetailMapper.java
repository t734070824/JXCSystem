package com.friday.inter;

import java.util.List;

import com.friday.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    List<OrderDetail> selectByOrderId(String orderId);
}