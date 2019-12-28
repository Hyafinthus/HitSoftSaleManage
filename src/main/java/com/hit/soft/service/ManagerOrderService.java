package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface ManagerOrderService {
	
	public Integer countQueryOrders(String type);
	
	public List<Order> queryOrders(Integer page, Integer limit, String type);
	
	public List<Product> showProducts(Integer order_id);
	
	public OrderProduct showOrder(Integer order_id);
	
	public void approveOrder(Integer order_id);
	
	public void rejectOrder(Integer order_id);
	
	public void deliverOrder(Integer order_id);
	
	public void deliverProductDepot(Integer product_id, Integer count);
	
	public Integer checkProductDepot(Integer product_id);
	
}
