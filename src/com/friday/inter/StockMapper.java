package com.friday.inter;

import com.friday.model.Stock;

public interface StockMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}