package com.hit.soft.dao;

import java.util.List;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface StaffOrderMapper {

	void createOrder(Order order);
	
	void createOrderProduct(OrderProduct orderProduct);

	List<Client> searchClient();

	List<Product> searchProduct();

	List<Order> searchUnpaidOrder();

	List<Order> searchPaidOrder();

	OrderProduct searchOrderProduct(int orderId);
	
	Order searchOrder(int orderId);

	void updateOrder(Order order);

}
