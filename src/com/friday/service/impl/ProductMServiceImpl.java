package com.friday.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.ProductTypeMapper;
import com.friday.model.ProductType;
import com.friday.service.ProductMService;
import com.friday.utils.SessionUtils;

public class ProductMServiceImpl implements ProductMService  {

	@Override
	public int addType(ProductType productType) throws Exception{
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			ProductTypeMapper producttypeMapper = sqlSession.getMapper(ProductTypeMapper.class);
			
			producttypeMapper.insertSelective(productType);
			sqlSession.commit();
			ret = 1;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ret;
	}

	@Override
	public ProductType getType(String name) throws Exception {
		ProductType producttype = null;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			ProductTypeMapper producttypeMapper = sqlSession.getMapper(ProductTypeMapper.class);
			
			producttype = producttypeMapper.selectByTypeName(name);
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		
		return producttype;
	}

}
