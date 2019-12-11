package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Mapper
public interface ManagerOrderMapper {
	
	public List<Order> queryOrders();
	
	public List<Product> showProducts(String order_id);
	
	public OrderProduct showOrder(String order_id);
	
	public void approveOrder(String order_id);
	
	public void rejectOrder(String order_id);
	
}
