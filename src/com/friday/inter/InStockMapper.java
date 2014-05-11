package com.friday.inter;

import com.friday.model.InStock;

public interface InStockMapper {
    int deleteByPrimaryKey(String iId);

    int insert(InStock record);

    int insertSelective(InStock record);

    InStock selectByPrimaryKey(String iId);

    int updateByPrimaryKeySelective(InStock record);

    int updateByPrimaryKey(InStock record);
}