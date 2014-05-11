package com.friday.inter;

import com.friday.model.GoodsBackDetail;

public interface GoodsBackDetailMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GoodsBackDetail record);

    int insertSelective(GoodsBackDetail record);

    GoodsBackDetail selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GoodsBackDetail record);

    int updateByPrimaryKey(GoodsBackDetail record);
}