package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

public interface StaffRetailService {

	int countProducts();

	List<Product> searchProducts(int offset, int limit);

	int countProductsByCondition(String condition);

	List<Product> searchProductsByCondition(String condition, int offset, int limit);

	void payOrder(OrderProduct orderProduct);

}
