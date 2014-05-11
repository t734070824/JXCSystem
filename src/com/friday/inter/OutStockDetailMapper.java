package com.friday.inter;

import com.friday.model.OutStockDetail;

public interface OutStockDetailMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(OutStockDetail record);

    int insertSelective(OutStockDetail record);

    OutStockDetail selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OutStockDetail record);

    int updateByPrimaryKey(OutStockDetail record);
}