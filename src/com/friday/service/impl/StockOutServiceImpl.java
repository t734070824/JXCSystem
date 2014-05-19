package com.friday.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.OrderDetailMapper;
import com.friday.inter.OrderMapper;
import com.friday.inter.OutStockDetailMapper;
import com.friday.inter.OutStockMapper;
import com.friday.inter.ProductMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.inter.SellDetailMapper;
import com.friday.inter.SellMapper;
import com.friday.inter.ShopMapper;
import com.friday.inter.StockMapper;
import com.friday.inter.UserMapper;
import com.friday.model.Order;
import com.friday.model.OrderDetail;
import com.friday.model.OutStock;
import com.friday.model.OutStockDetail;
import com.friday.model.Product;
import com.friday.model.ProductType;
import com.friday.model.Sell;
import com.friday.model.SellDetail;
import com.friday.model.Shop;
import com.friday.model.Stock;
import com.friday.model.User;
import com.friday.service.StockOutService;
import com.friday.utils.SessionUtils;

public class StockOutServiceImpl implements StockOutService {

	@Override
	public List<Object> getProductByShop(int shopId) throws Exception {
		List<Object> list = new ArrayList<Object>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			
			List<Stock> stocks = stockMapper.selectByshopId(shopId);
			
			for (Stock stock : stocks) {
				Map<String, Object> map = new HashMap<String, Object>();
				Product product = productMapper.selectByPrimaryKey(stock.getpId());
				
				map.put("name", product.getpName());
				map.put("num", stock.getsNum());
				map.put("pid", stock.getpId());
				map.put("price", product.getpPrice());
				
				list.add(map);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		
		return list;
	}

	@Override
	public List<Shop> getAllShops() throws Exception {
		List<Shop> list = new ArrayList<Shop>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			
			list = shopMapper.selectAllShops();
			
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		
		return list;
	}

	@Override
	public int stockOut(Map<Integer, Integer> outStocks, Date date, String bz, String uId, int shopId) throws Exception {
		int ret = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			OutStockMapper outStockMapper = sqlSession.getMapper(OutStockMapper.class);
			OutStockDetailMapper outStockDetailMapper = sqlSession.getMapper(OutStockDetailMapper.class);
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			
			OutStock outStock = new OutStock();
			outStock.setoBz(bz);
			outStock.setoDate(date);
			outStock.setsId(shopId);
			outStock.setuId(uId);
			
			outStockMapper.insert(outStock);
			
			Iterator<Integer> iterator = outStocks.keySet().iterator();
			List<Stock> stocks = stockMapper.selectAll();
			
			
			while (iterator.hasNext()) {
				OutStockDetail outStockDetail = new OutStockDetail();
				outStockDetail.setOutstockId(outStock.getoId());
				outStockDetail.setpId(iterator.next());
				outStockDetail.setoNum(outStocks.get(outStockDetail.getpId()));
				outStockDetailMapper.insert(outStockDetail);
				
				boolean shopFlag = false, warehouseFlag = false;
				for (Stock stock : stocks) {
					if (stock.getShopId() == shopId && stock.getpId() == outStockDetail.getpId()) {
						stock.setsNum(stock.getsNum() + outStockDetail.getoNum());
						stockMapper.updateByPrimaryKey(stock);
						shopFlag = true;
						if(shopFlag && warehouseFlag) break;
					}
					else if(stock.getShopId() == 1 && stock.getpId() == outStockDetail.getpId()){
						if (stock.getsNum() >= outStockDetail.getoNum()) {
							stock.setsNum(stock.getsNum() - outStockDetail.getoNum());
							stockMapper.updateByPrimaryKey(stock);
							warehouseFlag = true;
							if(shopFlag && warehouseFlag) break;
						}
						else {
							throw new Exception();
						}
					}
				}
				if (!warehouseFlag) {
					throw new Exception();
				}
				if (!shopFlag) {
					Stock stock = new Stock();
					stock.setShopId(shopId);
					stock.setpId(outStockDetail.getpId());
					stock.setsMaxnum(Integer.MAX_VALUE);
					stock.setsMinnum(0);
					stock.setsNum(outStockDetail.getoNum());
					stockMapper.insert(stock);
				}
			}
			
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
	public int sell(Map<Integer, Integer> sells, Date date, String bz, String uId, int shopId) throws Exception {
		int ret = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			SellMapper sellMapper = sqlSession.getMapper(SellMapper.class);
			SellDetailMapper sellDetailMapper = sqlSession.getMapper(SellDetailMapper.class);
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			
			Sell sell = new Sell();
			sell.setsBz(bz);
			sell.setsDate(date);
			sell.setShopId(shopId);
			sell.setuId(uId);

			
			sellMapper.insert(sell);
			
			Iterator<Integer> iterator = sells.keySet().iterator();
			List<Stock> stocks = stockMapper.selectAll();
			
			while (iterator.hasNext()) {
				SellDetail sellDetail = new SellDetail();
				sellDetail.setSellId(sell.getsId());
				sellDetail.setpId(iterator.next());
				sellDetail.setsNum(sells.get(sellDetail.getpId()));
				sellDetailMapper.insert(sellDetail);
				
				for (Stock stock : stocks) {
					if(stock.getShopId() == shopId && stock.getpId() == sellDetail.getpId()){
						if (stock.getsNum() >= sellDetail.getsNum()) {
							stock.setsNum(stock.getsNum() - sellDetail.getsNum());
							stockMapper.updateByPrimaryKey(stock);
						}
						else {
							throw new Exception();
						}
					}
				}
			}
			
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
	public List<Object> queryStockOut(Date start, Date end, int shopId,
			int orderId) throws Exception {
		List<Object> list = new ArrayList<Object>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			OutStockMapper outStockMapper = sqlSession.getMapper(OutStockMapper.class);
			OutStockDetailMapper outStockDetailMapper = sqlSession.getMapper(OutStockDetailMapper.class);
			UserMapper userMapper	= sqlSession.getMapper(UserMapper.class);
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			
			if (orderId != -1) {
				OutStock outStock = outStockMapper.selectByPrimaryKey(orderId);
				
				if (outStock != null) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("oId", outStock.getoId());
					map.put("date", outStock.getoDate());
					User user = userMapper.selectByPrimaryKey(outStock.getuId());
					map.put("user", user.getuName());
					List<OutStockDetail> outStockDetails = outStockDetailMapper.selectByOutStocksId(outStock.getoId());
					int price = 0;
					for (OutStockDetail outStockDetail : outStockDetails) {
						Product product = productMapper.selectByPrimaryKey(outStockDetail.getpId());
						price += outStockDetail.getoNum() * product.getpPrice();
					}
					map.put("price", price);
					Shop shop = shopMapper.selectByPrimaryKey(outStock.getsId());
					map.put("shop", shop.getsName());
					list.add(map);
				}
				
				return list;
			}
			else {
				List<OutStock> outStocks = null;
				if (shopId == 0) {
					outStocks = outStockMapper.selectAll();
				}
				else {
					outStocks = outStockMapper.selectByShopId(shopId);
				}
				
				for (OutStock outStock : outStocks) {
					if ((end == null ? true : outStock.getoDate().before(end)) && (start == null ? true : outStock.getoDate().after(start))) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("oId", outStock.getoId());
						map.put("date", outStock.getoDate());
						User user = userMapper.selectByPrimaryKey(outStock.getuId());
						map.put("user", user.getuName());
						List<OutStockDetail> outStockDetails = outStockDetailMapper.selectByOutStocksId(outStock.getoId());
						int price = 0;
						for (OutStockDetail outStockDetail : outStockDetails) {
							Product product = productMapper.selectByPrimaryKey(outStockDetail.getpId());
							price += outStockDetail.getoNum() * product.getpPrice();
						}
						map.put("price", price);
						Shop shop = shopMapper.selectByPrimaryKey(outStock.getsId());
						map.put("shop", shop.getsName());
						list.add(map);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		
		return list;
	}

	@Override
	public List<Object> querySell(Date start, Date end, int shopId, int orderId)
			throws Exception {
		
		List<Object> list = new ArrayList<Object>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			SellMapper sellMapper = sqlSession.getMapper(SellMapper.class);
			SellDetailMapper sellDetailMapper = sqlSession.getMapper(SellDetailMapper.class);
			UserMapper userMapper	= sqlSession.getMapper(UserMapper.class);
			ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
			
			if (orderId != -1) {
				Sell sell = sellMapper.selectByPrimaryKey(orderId);
				
				if (sell != null) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("oId", sell.getsId());
					map.put("date", sell.getsDate());
					User user = userMapper.selectByPrimaryKey(sell.getuId());
					map.put("user", user.getuName());
					List<SellDetail> sellDetails = sellDetailMapper.selectBySellId(sell.getsId());
					int price = 0;
					for (SellDetail sellDetail : sellDetails) {
						Product product = productMapper.selectByPrimaryKey(sellDetail.getpId());
						price += sellDetail.getsNum() * product.getpPrice();
					}
					map.put("price", price);
					Shop shop = shopMapper.selectByPrimaryKey(sell.getShopId());
					map.put("shop", shop.getsName());
					list.add(map);
				}
				
				return list;
			}
			else {
				List<Sell> sells = null;
				if (shopId == 0) {
					sells = sellMapper.selectAll();
				}
				else {
					sells = sellMapper.selectByShopId(shopId);
				}
				
				for (Sell sell : sells) {
					if ((end == null ? true : sell.getsDate().before(end)) && (start == null ? true : sell.getsDate().after(start))) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("oId", sell.getsId());
						map.put("date", sell.getsDate());
						User user = userMapper.selectByPrimaryKey(sell.getuId());
						map.put("user", user.getuName());
						List<SellDetail> sellDetails = sellDetailMapper.selectBySellId(sell.getShopId());
						int price = 0;
						for (SellDetail sellDetail : sellDetails) {
							Product product = productMapper.selectByPrimaryKey(sellDetail.getpId());
							price += sellDetail.getsNum() * product.getpPrice();
						}
						map.put("price", price);
						Shop shop = shopMapper.selectByPrimaryKey(sell.getShopId());
						map.put("shop", shop.getsName());
						list.add(map);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		
		return list;
	}

}
