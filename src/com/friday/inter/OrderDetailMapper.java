package com.friday.inter;

import java.util.List;

import com.friday.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer oId);

    /**
     * 添加订单详情
     * @param record
     * @return
     */
    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    /**
     * 根据订单id获取订单详情
     * @param orderId 订单id
     * @return
     */
    List<OrderDetail> selectByOrderId(String orderId);
}