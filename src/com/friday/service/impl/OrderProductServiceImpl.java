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
import com.friday.inter.ProductMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.inter.UserMapper;
import com.friday.model.Order;
import com.friday.model.OrderDetail;
import com.friday.model.Product;
import com.friday.model.ProductType;
import com.friday.model.User;
import com.friday.service.OrderProductService;
import com.friday.utils.SessionUtils;

public class OrderProductServiceImpl implements OrderProductService {

	/**
	 * 可订购商品列表
	 */
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

	@Override
	public List<Object> queryOrder(Date start, Date end, int style,
			String orderId) throws Exception {
		List<Object> list = new ArrayList<Object>();
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			OrderDetailMapper orderDetailMapper = sqlSession.getMapper(OrderDetailMapper.class);
			UserMapper userMapper	= sqlSession.getMapper(UserMapper.class);
			if (!orderId.isEmpty()) {
				Order order = orderMapper.selectByPrimaryKey(orderId);
				if (order != null) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("oId", order.getoId());
					map.put("date", order.getoDate());
					User user = userMapper.selectByPrimaryKey(order.getuId());
					map.put("user", user.getuName());
					List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(order.getoId());
					int price = 0;
					for (OrderDetail orderDetail : orderDetails) {
						Product product = productMapper.selectByPrimaryKey(orderDetail.getpId());
						price += orderDetail.getoNum() * product.getpPrice();//总价
					}
					map.put("price", price);
					map.put("style", order.getoStyle());
					list.add(map);
				}
				
				return list;
			}
			else {
				List<Order> orders = null;
				if (style == 2) {
					orders = orderMapper.selectAll();
				}
				else {
					orders = orderMapper.selectByStyle(style);
				}
				
				for (Order order : orders) {
					if ((end == null ? true : order.getoDate().before(end)) && (start == null ? true : order.getoDate().after(start))) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("oId", order.getoId());
						map.put("date", order.getoDate());
						User user = userMapper.selectByPrimaryKey(order.getuId());
						map.put("user", user.getuName());
						List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(order.getoId());
						int price = 0;
						for (OrderDetail orderDetail : orderDetails) {
							Product product = productMapper.selectByPrimaryKey(orderDetail.getpId());
							price += orderDetail.getoNum() * product.getpPrice();
						}
						map.put("price", price);
						switch (order.getoStyle()) {
						case 0:
							map.put("style", "未处理");
							break;
						case 1:
							map.put("style", "已入库");
							break;
						case -1:
							map.put("style", "已退回");
							break;
						default:
							map.put("style", "未处理");
							break;
						}
						
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
