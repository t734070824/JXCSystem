package com.friday.inter;

import java.util.List;

import com.friday.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Product record);

    int insertSelective(Product record);

    /**
     * 根据商品id获取商品详情
     * @param pId
     * @return
     */
    Product selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    /**
     * 根据商品类型获取商品列表
     * @param tId
     * @return
     */
    List<Product> selectByType(Integer tId);
    
    List<Product> selectAll();
}