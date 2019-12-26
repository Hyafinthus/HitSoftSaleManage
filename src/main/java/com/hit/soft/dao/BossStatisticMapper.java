package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;

@Mapper
public interface BossStatisticMapper {

	public List<Product> queryInDepot(@Param("start_time") String start_time, @Param("end_time") String end_time);
	
	public List<Product> queryMarketProduct(@Param("start_time") String start_time, @Param("end_time") String end_time);
	
	public List<Order> queryMarketOrder(@Param("start_time") String start_time, @Param("end_time") String end_time);
	
}
