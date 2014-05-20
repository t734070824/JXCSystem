package com.friday.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.ProductMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.model.Product;
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

	@Override
	public List<ProductType> getAllType() throws Exception {
		List<ProductType> ptlist = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			ProductTypeMapper producttypeMapper = sqlSession
					.getMapper(ProductTypeMapper.class);

			ptlist = producttypeMapper.selectAllTypes();
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ptlist;
	}

	@Override
	public int removeType(int id) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			ProductTypeMapper producttypeMapper = sqlSession.getMapper(ProductTypeMapper.class);
			
			
			producttypeMapper.deleteByPrimaryKey(id);
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
	public List<Object> getProduct() throws Exception {
		List<Object> olist = new ArrayList<Object>();
		List<Product> plist = null;
		SqlSession sqlSession = null;
		Iterator<Product> ite = null;
		try {
			sqlSession = SessionUtils.getSession();
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			ProductTypeMapper producttypeMapper = sqlSession
					.getMapper(ProductTypeMapper.class);
			
			plist = productMapper.selectAll();
		    ite = plist.iterator();
		    while(ite.hasNext())
		    {
		    	Product p = ite.next();
		    	Map<String,Object> map = new HashMap<String, Object>();
		    	map.put("pId", p.getpId());
		    	map.put("pName", p.getpName());
		    	map.put("pPrice", p.getpPrice());
		    	map.put("pStyle", p.getpStyle());
		    	map.put("pZt", p.getpZt());
		    	
		    	ProductType pt = producttypeMapper.selectByPrimaryKey(p.gettId());
		    	map.put("typename", pt.gettType());
		    	
		    	olist.add(map);
		    }
			
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}		
		return olist;
	}

	@Override
	public int removeProduct(int pid) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			productMapper.deleteByPrimaryKey(pid);
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
	public int addProduct(Product product) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			productMapper.insertSelective(product);
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
	public Product getProductByid(int id) throws Exception {
		SqlSession sqlSession = null;
		Product product = null;
		try {
			sqlSession = SessionUtils.getSession();
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			product = productMapper.selectByPrimaryKey(id);	
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}		
		return product;
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			productMapper.updateByPrimaryKey(product);
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
}
