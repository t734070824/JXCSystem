package com.friday.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.InStockDetailMapper;
import com.friday.inter.InStockMapper;
import com.friday.inter.OrderDetailMapper;
import com.friday.inter.OrderMapper;
import com.friday.inter.ProductMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.inter.UserMapper;
import com.friday.model.InStock;
import com.friday.model.InStockDetail;
import com.friday.model.Order;
import com.friday.model.OrderDetail;
import com.friday.model.Product;
import com.friday.model.ProductType;
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
			
			for (OrderDetail orderDetail : orderDetails) {
				InStockDetail inStockDetail = new InStockDetail();
				inStockDetail.setInstockId(inId);
				inStockDetail.setiNum(orderDetail.getoNum());
				inStockDetail.setpId(orderDetail.getpId());
				inStockDetailMapper.insert(inStockDetail);
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
