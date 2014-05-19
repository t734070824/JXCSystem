package com.friday.inter;

import java.util.List;

import com.friday.model.OutStock;
import com.friday.model.OutStockDetail;

public interface OutStockDetailMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(OutStockDetail record);

    int insertSelective(OutStockDetail record);

    OutStockDetail selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OutStockDetail record);

    int updateByPrimaryKey(OutStockDetail record);
    
    List<OutStockDetail> selectByOutStocksId(int oid);
}