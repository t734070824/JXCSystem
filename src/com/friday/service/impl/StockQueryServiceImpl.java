package com.friday.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.friday.inter.ProductMapper;
import com.friday.inter.ShopMapper;
import com.friday.inter.StockMapper;
import com.friday.model.Product;
import com.friday.model.Shop;
import com.friday.model.Stock;
import com.friday.service.StockQueryService;
import com.friday.utils.SessionUtils;
import java.util.List;


public  class StockQueryServiceImpl implements StockQueryService {
	
	public Map<Integer, Object> stockQuery(String sName) throws Exception {
		SqlSession sqlSession = null;
		List<Stock> list = null;
		Map<Integer, Object> map = null;
		
		try {
			sqlSession =  SessionUtils.getSession();
			
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			Shop shop = shopMapper.selectBySName(sName);
			List<Stock> stocks = stockMapper.selectByshopId(shop.getsId());
			for(Stock stock:stocks)
			{
				Product product = productMapper.selectByPrimaryKey(stock.getpId());
				//List<Product> products = null;
				//products.add(product);
				map.put(stock.getsNum(), product);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			SessionUtils.closeSession(sqlSession);
		}
		
		return map;
	}

	@Override
	public List<Shop> shopQuery() throws Exception {
		SqlSession sqlSession = null;
		List<Shop> list = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			
			list = shopMapper.selectAllShops();
		} catch (Exception e) {
			throw e;
		}finally{
			SessionUtils.closeSession(sqlSession);
		}
		return list;
	}

}
