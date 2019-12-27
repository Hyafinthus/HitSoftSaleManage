package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;

@Mapper
public interface BossStatisticMapper {

	public List<Product> queryInDepot(@Param("start_time") String start_time, @Param("end_time") String end_time);
	
	public List<Product> queryTradeProduct(@Param("start_time") String start_time, @Param("end_time") String end_time);
	
	public List<Order> queryTradeOrder(@Param("start_time") String start_time, @Param("end_time") String end_time);
	
	public List<Product> pricePurchaseDay(@Param("start_time") String start_time, @Param("end_time") String end_time,
			@Param("start_date") String start_date, @Param("end_date") String end_date);
	
	public List<Order> priceTradeProfitDay(@Param("start_time") String start_time, @Param("end_time") String end_time,
			@Param("start_date") String start_date, @Param("end_date") String end_date);
	
}
