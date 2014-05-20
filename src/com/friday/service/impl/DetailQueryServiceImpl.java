package com.friday.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.GoodsBackDetailMapper;
import com.friday.inter.InStockDetailMapper;
import com.friday.inter.OrderDetailMapper;
import com.friday.inter.OutStockDetailMapper;
import com.friday.inter.ProductMapper;
import com.friday.inter.SellDetailMapper;
import com.friday.inter.StockMapper;
import com.friday.model.GoodsBackDetail;
import com.friday.model.InStockDetail;
import com.friday.model.OrderDetail;
import com.friday.model.OutStockDetail;
import com.friday.model.Product;
import com.friday.model.SellDetail;
import com.friday.model.Stock;
import com.friday.service.DetailQueryService;
import com.friday.utils.SessionUtils;

public class DetailQueryServiceImpl implements DetailQueryService {

	@Override
	public List<Object> queryDetail(String dId, String table) throws Exception {
		List<Object> list = new ArrayList<Object>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = SessionUtils.getSession();
			
			ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
			OrderDetailMapper orderDetailMapper = sqlSession.getMapper(OrderDetailMapper.class);
			InStockDetailMapper inStockDetailMapper = sqlSession.getMapper(InStockDetailMapper.class);
			GoodsBackDetailMapper goodsBackDetailMapper = sqlSession.getMapper(GoodsBackDetailMapper.class);
			OutStockDetailMapper outStockDetailMapper = sqlSession.getMapper(OutStockDetailMapper.class);
			SellDetailMapper sellDetailMapper = sqlSession.getMapper(SellDetailMapper.class);
			
			if (table.equals("order")) {
				List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(dId);
				
				for (OrderDetail orderDetail : orderDetails) {
					Map<String, Object> map = new HashMap<String, Object>();
					Product product = productMapper.selectByPrimaryKey(orderDetail.getpId());
					
					map.put("name", product.getpName());
					map.put("num", orderDetail.getoNum());
					map.put("price", product.getpPrice() * orderDetail.getoNum());
					
					list.add(map);
				}
			}
			else if (table.equals("in")) {
				List<InStockDetail> inStockDetails = inStockDetailMapper.selectByInStockId(dId);
				
				for (InStockDetail inStockDetail : inStockDetails) {
					Map<String, Object> map = new HashMap<String, Object>();
					Product product = productMapper.selectByPrimaryKey(inStockDetail.getpId());
					
					map.put("name", product.getpName());
					map.put("num", inStockDetail.getiNum());
					map.put("price", product.getpPrice() * inStockDetail.getiNum());
					
					list.add(map);
				}
			}
			else if (table.equals("back")) {
				int id = Integer.parseInt(dId);
				List<GoodsBackDetail> goodsBackDetails = goodsBackDetailMapper.selectByBackId(id);
				
				for (GoodsBackDetail goodsBackDetail : goodsBackDetails) {
					Map<String, Object> map = new HashMap<String, Object>();
					Product product = productMapper.selectByPrimaryKey(goodsBackDetail.getpId());
					
					map.put("name", product.getpName());
					map.put("num", goodsBackDetail.getgNum());
					map.put("price", product.getpPrice() * goodsBackDetail.getgNum());
					
					list.add(map);
				}
			}
			else if (table.equals("sell")) {
				int id = Integer.parseInt(dId);
				List<SellDetail> sellDetails = sellDetailMapper.selectBySellId(id);
				
				for (SellDetail sellDetail : sellDetails) {
					Map<String, Object> map = new HashMap<String, Object>();
					Product product = productMapper.selectByPrimaryKey(sellDetail.getpId());
					
					map.put("name", product.getpName());
					map.put("num", sellDetail.getsNum());
					map.put("price", product.getpPrice() * sellDetail.getsNum());
					
					list.add(map);
				}
			}
			else if (table.equals("out")) {
				int id = Integer.parseInt(dId);
				List<OutStockDetail> outStockDetails = outStockDetailMapper.selectByOutStocksId(id);
				
				for (OutStockDetail outStockDetail : outStockDetails) {
					Map<String, Object> map = new HashMap<String, Object>();
					Product product = productMapper.selectByPrimaryKey(outStockDetail.getpId());
					
					map.put("name", product.getpName());
					map.put("num", outStockDetail.getoNum());
					map.put("price", product.getpPrice() * outStockDetail.getoNum());
					
					list.add(map);
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
