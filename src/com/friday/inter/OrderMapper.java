package com.friday.inter;

import java.util.List;

import com.friday.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String oId);

    /**
     * 添加订单
     * @param record
     * @return
     */
    int insert(Order record);

    int insertSelective(Order record);

    /**
     * 根据订单id获取订单信息
     * @param oId 订单id
     * @return
     */
    Order selectByPrimaryKey(String oId);

    /**
     * 更新订单状态
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    /**
     * 获取所有列表（2 所有类型）
     * @return
     */
    List<Order> selectAll();
    
    /**
     * 根据订单状态获取订单列表
     * @param oStyle 订单状态
     * @return
     */
    List<Order> selectByStyle(int oStyle);
}