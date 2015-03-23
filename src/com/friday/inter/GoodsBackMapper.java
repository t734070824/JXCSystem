package com.friday.inter;

import java.util.List;

import com.friday.model.GoodsBack;

public interface GoodsBackMapper {
    int deleteByPrimaryKey(Integer gId);

    /**
     * 添加回退商品信息
     * @param record
     * @return
     */
    int insert(GoodsBack record);

    int insertSelective(GoodsBack record);

    GoodsBack selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(GoodsBack record);

    int updateByPrimaryKey(GoodsBack record);
    
    List<GoodsBack> selectAll();
}