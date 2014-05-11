package com.friday.inter;

import com.friday.model.GoodsBack;

public interface GoodsBackMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GoodsBack record);

    int insertSelective(GoodsBack record);

    GoodsBack selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GoodsBack record);

    int updateByPrimaryKey(GoodsBack record);
}