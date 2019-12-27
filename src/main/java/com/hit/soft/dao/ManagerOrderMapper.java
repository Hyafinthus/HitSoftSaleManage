package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Mapper
public interface ManagerOrderMapper {
	
	public Integer countQueryOrders(@Param("state1") String state1, @Param("state2") String state2);
	
	public List<Order> queryOrders(@Param("page") Integer page, @Param("limit") Integer limit,
			@Param("state1") String state1, @Param("state2") String state2);
	
	public List<Product> showProducts(String order_id);
	
	public OrderProduct showOrder(String order_id);
	
	public void approveOrder(String order_id);
	
	public void rejectOrder(String order_id);
	
}
