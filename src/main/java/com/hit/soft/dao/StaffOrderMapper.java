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
	//获取草稿
	OrderProduct getDraft();

	//删除所有有关草稿的数据
	void deleteDraft();

	//添加货物订单信息到order_prod
	void addProduct(Product product);

	void addOrder(Order order);
	
	int countClients();

	List<Client> searchClients(@Param("offset") Integer offset, @Param("limit")Integer limit);
	
	int countClientsById(int clientId);

	int countClientsByName(String clientName);
	
	//根据ID精准查询得到客户信息
	Client searchClientById(int clientId);
	
	//根据ID模糊查询得到客户信息
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
	
	int countRejectedOrder();

	List<Order> searchRejectedOrder(@Param("offset") Integer offset, @Param("limit")Integer limit);

	OrderProduct searchOrderProduct(int orderId);
	
	Order searchOrder(int orderId);

	void updateOrder(Order order);

	//用以在加入自增ID的表中时获取最后一条数据的ID
	int getLastId();

	//根据product的ID填充product的所有信息
	Product completeProduct(Product product);

	void saveMoney(Client client);

	void deleteOrder(int orderId);

	void changePoints(@Param("points") Integer points, @Param("clientId")Integer clientId);

	double getRatio();

	


	
}
