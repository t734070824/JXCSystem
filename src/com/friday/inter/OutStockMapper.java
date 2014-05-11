package com.friday.inter;

import com.friday.model.OutStock;

public interface OutStockMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(OutStock record);

    int insertSelective(OutStock record);

    OutStock selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OutStock record);

    int updateByPrimaryKey(OutStock record);
}