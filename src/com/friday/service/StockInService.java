package com.friday.service;

import java.sql.Date;
import java.util.List;

public interface StockInService {
	
	/**
	 * 产品入库
	 * @param orderId
	 * @param inId
	 * @param date
	 * @param bz
	 * @param uId
	 * @return
	 * @throws Exception
	 */
	int stockIn(String orderId, String inId, Date date, String bz, String uId) throws Exception;

	/**
	 * 商品退回
	 * @param orderId 产品id
	 * @param date 日期
	 * @param bz 备注
	 * @param uId 操作用户id
	 * @return
	 * @throws Exception
	 */
	int goodsBack(String orderId, Date date, String bz, String uId) throws Exception;
	
	/**
	 * 查询入库列表
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param orderId 入库编号
	 * @return
	 * @throws Exception
	 */
	List<Object> queryStockIn(Date start, Date end, String orderId) throws Exception;
	List<Object> queryReturn(Date start, Date end, int orderId) throws Exception;
}
