package com.friday.service.impl;

import java.util.ArrayList;
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
	public List<Object> stockWarn() throws Exception {
		SqlSession sqlSession = null;
		List<Object> list = new ArrayList<Object>();
		
		try {
			sqlSession = SessionUtils.getSession();
			
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
<<<<<<< HEAD
			List<Stock> stocks = null;
			List<Product> products = null;
			List<Shop> shops =null;
			shops = shopMapper.selectAllShops();
			for (Shop shop : shops) {
				Map<String, Object> stockMap = new HashMap<String, Object>();
				stocks = stockMapper.selectByshopIdAndStockNum(shop.getsId());
				//System.out.println("///"+shop.getsName());
				for (Stock stock : stocks) {
					//System.out.println("////"+stock.getsNum());
					stockMap.put(productMapper.selectByPrimaryKey(stock.getpId()).getpName(), stock);
					//System.out.println("/////"+productMapper.selectByPrimaryKey(stock.getpId()).getpName());
=======
			List<Stock> stocks =stockMapper.selectAll();
			for (Stock stock : stocks) {
				Map<String, Object> stockMap = new HashMap<String, Object>();
				if (stock.getsNum() <= 10) {
					Shop shop = shopMapper.selectByPrimaryKey(stock.getShopId());
					Product product = productMapper.selectByPrimaryKey(stock.getpId());
					stockMap.put("shop", shop.getsName());
					stockMap.put("product", product.getpName());
					stockMap.put("num", stock.getsNum());
					
					list.add(stockMap);
>>>>>>> 592d5b2549c3ac839b09c3c62aaad115cbe73a2f
				}
			}
		} catch (Exception e) {
			throw e;
		}finally{
			SessionUtils.closeSession(sqlSession);
		}
		
		return list;
	}

}
