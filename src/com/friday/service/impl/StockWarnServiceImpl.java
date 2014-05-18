package com.friday.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;

import com.friday.inter.ProductMapper;
import com.friday.inter.ShopMapper;
import com.friday.inter.StockMapper;
import com.friday.model.Product;
import com.friday.model.Shop;
import com.friday.model.Stock;
import com.friday.service.StockWarnService;
import com.friday.utils.SessionUtils;

public class StockWarnServiceImpl implements StockWarnService {

	@Override
	public Map<String, Object> stockWarn() throws Exception {
		SqlSession sqlSession = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			sqlSession = SessionUtils.getSession();
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			List<Stock> stocks = null;
			List<Product> products = null;
			List<Shop> shops =null;
			shops = shopMapper.selectAllShops();
			for (Shop shop : shops) {
				Map<String, Object> stockMap = null;
				stocks = stockMapper.selectByshopIdAndStockNum(shop.getsId());
				for (Stock stock : stocks) {
					stockMap.put(productMapper.selectByPrimaryKey(stock.getpId()).getpName(), stock);
				}
				map.put(shop.getsName(), stockMap);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			SessionUtils.closeSession(sqlSession);
		}
		
		return map;
	}

}
