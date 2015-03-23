package com.friday.inter;

import java.util.List;

import com.friday.model.ProductType;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
    
    /**
     * 可订购商品类型
     * @return
     */
    List<ProductType> selectAllTypes();
    
    ProductType selectByTypeName(String tname);
   
}