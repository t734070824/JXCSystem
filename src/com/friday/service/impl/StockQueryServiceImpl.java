package com.friday.service.impl;

import java.util.ArrayList;
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
	
	public List<Object> stockQuery(int shopId) throws Exception {
		SqlSession sqlSession = null;
<<<<<<< HEAD
		List<Stock> list = null;
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		
=======
		List<Object> list = new ArrayList<Object>();
>>>>>>> 592d5b2549c3ac839b09c3c62aaad115cbe73a2f
		try {
			sqlSession =  SessionUtils.getSession();
			
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
<<<<<<< HEAD
			Shop shop = shopMapper.selectBySName(sName);
			List<Stock> stocks = stockMapper.selectByshopId(shop.getsId());

=======
			List<Stock> stocks = stockMapper.selectByshopId(shopId);
>>>>>>> 592d5b2549c3ac839b09c3c62aaad115cbe73a2f
			for(Stock stock:stocks)
			{
				//System.out.print("//"+stock.getsNum());
				Product product = productMapper.selectByPrimaryKey(stock.getpId());
<<<<<<< HEAD
				//System.out.println("///"+product.getpName());
				map.put(stock.getsNum(), product);
=======
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("num", stock.getsNum());
				map.put("name", product.getpName());
				map.put("guige", product.getpStyle());
				map.put("price", product.getpPrice());
				list.add(map);
>>>>>>> 592d5b2549c3ac839b09c3c62aaad115cbe73a2f
			}
		} catch (Exception e) {
			throw e;
		}finally{
			SessionUtils.closeSession(sqlSession);
		}
		
		return list;
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

	@Override
	public String QueryShopName(int shopId) throws Exception {
		SqlSession sqlSession = null;
		Shop shop = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			
			shop = shopMapper.selectByPrimaryKey(shopId);
		} catch (Exception e) {
			throw e;
		}finally{
			SessionUtils.closeSession(sqlSession);
		}
		return shop.getsName();
	}

}
