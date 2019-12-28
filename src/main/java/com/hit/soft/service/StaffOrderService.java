package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface StaffOrderService {

	void saveOrder(OrderProduct orderProduct);
	
	void submitOrder(OrderProduct orderProduct);

	int countClients();
	
	List<Client> searchClients(Integer offset, Integer limit);
	
	int countClientsByCondition(String condition);
	
	List<Client> searchClientsByCondition(String condition, Integer offset, Integer limit);
	
	int countProducts();

	List<Product> searchProducts(Integer offset, Integer limit);
	
	int countProductsByCondition(String condition);
	
	List<Product> searchProductsByCondition(String condition, Integer offset, Integer limit);
	
	int countUnpaidOrder();

	List<Order> searchUnpaidOrder(Integer offset, Integer limit);
	
	int countPaidOrder();

	List<Order> searchPaidOrder(Integer offset, Integer limit);

	OrderProduct searchOrderProduct(int orderId);

	void payOrderByCash(int orderId);
	
	boolean payOrderByWallet(int orderId);

	void returnOrder(int orderId);

	OrderProduct getDraft();

	void saveMoney(Client client);

	int countRejectedOrder();

	List<Order> searchRejectedOrder(Integer offset, Integer limit);


	


}
