package com.friday.inter;

import com.friday.model.Sell;

public interface SellMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Sell record);

    int insertSelective(Sell record);

    Sell selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Sell record);

    int updateByPrimaryKey(Sell record);
}