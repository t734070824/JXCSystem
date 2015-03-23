package com.friday.inter;

import java.util.List;

import com.friday.model.Stock;

public interface StockMapper {

	int deleteByPrimaryKey(Integer sId);

	/**
	 * 如数据库中没有相同产品，设置默认值
	 * @param record
	 * @return
	 */
    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Stock record);

    /**
     * 如数据库中有相同产品，则在原来基础上添加数量
     * @param record
     * @return
     */
    int updateByPrimaryKey(Stock record);
    
    /**
     * 库存列表
     * @return
     */
    List<Stock> selectAll();

	List<Stock> selectByshopId(Integer sId);

	List<Stock> selectAllStocks();
}