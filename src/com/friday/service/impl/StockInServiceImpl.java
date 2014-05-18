package com.friday.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.GoodsBackDetailMapper;
import com.friday.inter.GoodsBackMapper;
import com.friday.inter.InStockDetailMapper;
import com.friday.inter.InStockMapper;
import com.friday.inter.OrderDetailMapper;
import com.friday.inter.OrderMapper;
import com.friday.inter.ProductMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.inter.StockMapper;
import com.friday.inter.UserMapper;
import com.friday.model.GoodsBack;
import com.friday.model.GoodsBackDetail;
import com.friday.model.InStock;
import com.friday.model.InStockDetail;
import com.friday.model.Order;
import com.friday.model.OrderDetail;
import com.friday.model.Product;
import com.friday.model.ProductType;
import com.friday.model.Stock;
import com.friday.service.StockInService;
import com.friday.utils.SessionUtils;

public class StockInServiceImpl implements StockInService {

	@Override
	public int stockIn(String orderId, String inId, Date date, String bz, String uId) throws Exception{
		int ret = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			OrderDetailMapper orderDetailMapper = sqlSession.getMapper(OrderDetailMapper.class);
			InStockMapper inStockMapper = sqlSession.getMapper(InStockMapper.class);
			InStockDetailMapper inStockDetailMapper = sqlSession.getMapper(InStockDetailMapper.class);
			StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
			
			if (orderMapper.selectByPrimaryKey(orderId).getoStyle() != 0) {
				throw new Exception();
			}
			
			InStock inStock = new InStock();
			
			inStock.setuId(uId);
			inStock.setoId(orderId);
			inStock.setiId(inId);
			inStock.setiDate(date);
			
			inStockMapper.insert(inStock);
			
			
			
			Order order = new Order();
			order.setoBz(null);
			order.setoDate(null);
			order.setoId(orderId);
			order.setoStyle(1);
			order.setuId(null);
			
			orderMapper.updateByPrimaryKeySelective(order);
			
			List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(orderId);
			List<Stock> stocks = stockMapper.selectAll();
			
			for (OrderDetail orderDetail : orderDetails) {
				InStockDetail inStockDetail = new InStockDetail();
				inStockDetail.setInstockId(inId);
				inStockDetail.setiNum(orderDetail.getoNum());
				inStockDetail.setpId(orderDetail.getpId());
				inStockDetailMapper.insert(inStockDetail);
				
				boolean flag = false;
				for (Stock stock : stocks) {
					if (stock.getShopId() == 1 && stock.getpId() == orderDetail.getpId()) {
						stock.setsNum(stock.getsNum() + orderDetail.getoNum());
						stockMapper.updateByPrimaryKey(stock);
						flag = true;
						break;
					}
				}
				if (!flag) {
					Stock stock = new Stock();
					stock.setShopId(1);
					stock.setpId(orderDetail.getpId());
					stock.setsMaxnum(Integer.MAX_VALUE);
					stock.setsMinnum(0);
					stock.setsNum(orderDetail.getoNum());
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
	public int goodsBack(String orderId, Date date, String bz,
			String uId) throws Exception {
		int ret = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			OrderDetailMapper orderDetailMapper = sqlSession.getMapper(OrderDetailMapper.class);
			GoodsBackMapper goodsBackMapper = sqlSession.getMapper(GoodsBackMapper.class);
			GoodsBackDetailMapper goodsBackDetailMapper = sqlSession.getMapper(GoodsBackDetailMapper.class);
			
			if (orderMapper.selectByPrimaryKey(orderId).getoStyle() != 0) {
				throw new Exception();
			}
			
			GoodsBack goodsBack = new GoodsBack();
			
			goodsBack.setuId(uId);
			goodsBack.setgDate(date);
			goodsBack.setgBz(bz);
			
			goodsBackMapper.insert(goodsBack);
			
			Order order = new Order();
			order.setoBz(null);
			order.setoDate(null);
			order.setoId(orderId);
			order.setoStyle(-1);
			order.setuId(null);
			
			orderMapper.updateByPrimaryKeySelective(order);
			
			List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(orderId);
			
			for (OrderDetail orderDetail : orderDetails) {
				GoodsBackDetail goodsBackDetail = new GoodsBackDetail();
				goodsBackDetail.setGoodsbackId(goodsBack.getgId());
				goodsBackDetail.setgNum(orderDetail.getoNum());
				goodsBackDetail.setpId(orderDetail.getpId());
				goodsBackDetailMapper.insert(goodsBackDetail);
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

}
