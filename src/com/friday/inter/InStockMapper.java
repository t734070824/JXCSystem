package com.friday.inter;

import java.util.List;

import com.friday.model.InStock;

public interface InStockMapper {
    int deleteByPrimaryKey(String iId);

    /**
     * 添加入库信息
     * @param record
     * @return
     */
    int insert(InStock record);

    int insertSelective(InStock record);

    InStock selectByPrimaryKey(String iId);

    int updateByPrimaryKeySelective(InStock record);

    int updateByPrimaryKey(InStock record);
    
    List<InStock> selectAll();
}