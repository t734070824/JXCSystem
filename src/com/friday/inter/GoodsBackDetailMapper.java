package com.friday.inter;

import java.util.List;

import com.friday.model.GoodsBackDetail;

public interface GoodsBackDetailMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(GoodsBackDetail record);

    int insertSelective(GoodsBackDetail record);

    GoodsBackDetail selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GoodsBackDetail record);

    int updateByPrimaryKey(GoodsBackDetail record);
    
    List<GoodsBackDetail> selectByBackId(int bId);
}