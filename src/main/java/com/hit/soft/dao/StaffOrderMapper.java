package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Mapper
public interface StaffOrderMapper {
	
	Order getDraft();

	void deleteDraft();

	void addProduct(Product product);

	void addOrder(Order order);

	List<Client> searchClient();

	List<Product> searchProduct();

	List<Order> searchUnpaidOrder();

	List<Order> searchPaidOrder();

	OrderProduct searchOrderProduct(int orderId);
	
	Order searchOrder(int orderId);

	void updateOrder(Order order);


}
