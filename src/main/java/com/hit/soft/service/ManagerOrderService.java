package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface ManagerOrderService {
	
	public Integer countQueryOrders(String type);
	
	public List<Order> queryOrders(Integer page, Integer limit, String type);
	
	public List<Product> showProducts(String order_id);
	
	public OrderProduct showOrder(String order_id);
	
	public void approveOrder(String order_id);
	
	public void rejectOrder(String order_id);
	
}
