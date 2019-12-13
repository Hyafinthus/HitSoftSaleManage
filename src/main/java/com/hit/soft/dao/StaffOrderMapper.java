package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Mapper
public interface StaffOrderMapper {
	
	OrderProduct getDraft();

	void deleteDraft();

	void addProduct(Product product);

	void addOrder(Order order);
	
	int countClients();

	List<Client> searchClients(@Param("offset") Integer offset, @Param("limit")Integer limit);
	
	int countClientsById(int clientId);

	int countClientsByName(String clientName);
	
	List<Client> searchClientsById(@Param("clientId") int clientId, @Param("offset") Integer offset, @Param("limit")Integer limit);
	
	List<Client> searchClientsByName(@Param("clientName") String clientName, @Param("offset") Integer offset, @Param("limit")Integer limit);
	
	int countProducts();

	List<Product> searchProducts(@Param("offset") Integer offset, @Param("limit")Integer limit);
	
	int countProductsById(int productId);

	int countProductsByName(String productName);
	
	List<Product> searchProductsById(@Param("productId") int productId, @Param("offset") Integer offset, @Param("limit")Integer limit);
	
	List<Product> searchProductsByName(@Param("productName") String productName, @Param("offset") Integer offset, @Param("limit")Integer limit);
	
	int countUnpaidOrder();

	List<Order> searchUnpaidOrder(@Param("offset") Integer offset, @Param("limit")Integer limit);
	
	int countPaidOrder();

	List<Order> searchPaidOrder(@Param("offset") Integer offset, @Param("limit")Integer limit);

	OrderProduct searchOrderProduct(int orderId);
	
	Order searchOrder(int orderId);

	void updateOrder(Order order);


	
}
