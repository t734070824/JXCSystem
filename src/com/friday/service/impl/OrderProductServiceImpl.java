package com.friday.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.friday.inter.OrderDetailMapper;
import com.friday.inter.OrderMapper;
import com.friday.inter.ProductMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.model.Order;
import com.friday.model.OrderDetail;
import com.friday.model.Product;
import com.friday.model.ProductType;
import com.friday.service.OrderProductService;
import com.friday.utils.SessionUtils;

public class OrderProductServiceImpl implements OrderProductService {

	@Override
	public Map<String, Object> getTypeAndProduct() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			ProductTypeMapper productTypeMapper = sqlSession.getMapper(ProductTypeMapper.class);
			
			List<ProductType> productTypes = productTypeMapper.selectAllTypes();
			
			for (ProductType productType : productTypes) {
				List<Product> products = productMapper.selectByType(productType.gettId());
				
				map.put(productType.gettType(), products);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		
		return map;
	}

	@Override
	public int orderProduct(Map<Integer, Integer> orders, Date date, String bz, String uId, String oId) throws Exception{
		int ret = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			OrderDetailMapper orderDetailMapper = sqlSession.getMapper(OrderDetailMapper.class);
			
			Order order = new Order();
			order.setoDate(date);
			order.setoBz(bz);
			order.setoStyle(0);
			order.setuId(uId);
			order.setoId(oId);
			
			orderMapper.insert(order);
			
			Iterator<Integer> iterator = orders.keySet().iterator();
			
			while (iterator.hasNext()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setpId(iterator.next());
				orderDetail.setoNum(orders.get(orderDetail.getpId()));
				orderDetail.setOrderId(order.getoId());
				orderDetailMapper.insert(orderDetail);
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
