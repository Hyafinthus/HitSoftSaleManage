package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface StaffOrderService {

	void createOrder(OrderProduct orderProduct);
	
	void submitOrder(OrderProduct orderProduct);

	List<Client> searchClient();

	List<Product> searchProduct();

	List<Order> searchUnpaidOrder();

	List<Order> searchPaidOrder();

	OrderProduct searchOrderProduct(int orderId);
	
	Order searchOrder(int orderId);

	void payOrder(int orderId);

	void returnOrder(int orderId);

	Order orderProductToOrder(OrderProduct orderProduct, boolean isdraft);

	


}
