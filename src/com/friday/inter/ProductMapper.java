package com.friday.inter;

import java.util.List;

import com.friday.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> selectByType(Integer tId);
    
    List<Product> selectAll();
}