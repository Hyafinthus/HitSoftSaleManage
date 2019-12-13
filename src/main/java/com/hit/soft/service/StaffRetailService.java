package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface StaffRetailService {

	int countClients();

	List<Client> searchClients(int offset, int limit);

	int countClientsByCondition(String condition);

	List<Client> searchClientsByCondition(String condition, int offset, int limit);

	int countProducts();

	List<Product> searchProducts(int offset, int limit);

	int countProductsByCondition(String condition);

	List<Product> searchProductsByCondition(String condition, int offset, int limit);

	void payOrder(OrderProduct orderProduct);

}
