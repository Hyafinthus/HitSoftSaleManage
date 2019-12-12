package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface ManagerOrderService {
	
	public int countQueryOrders();
	
	public List<Order> queryOrders(String page, String limit);
	
	public List<Product> showProducts(String order_id);
	
	public OrderProduct showOrder(String order_id);
	
	public void approveOrder(String order_id);
	
	public void rejectOrder(String order_id);
	
}
