package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;

@Mapper
public interface StaffRetailMapper {

	int countClients();

	List<Client> searchClients(int offset, int limit);

	int countClientsById(int parseInt);

	int countClientsByName(String condition);

	List<Client> searchClientsById(int parseInt, int offset, int limit);

	List<Client> searchClientsByName(String condition, int offset, int limit);

	int countProducts();

	List<Product> searchProducts(int offset, int limit);

	int countProductsById(int parseInt);

	int countProductsByName(String condition);

	List<Product> searchProductsById(int parseInt, int offset, int limit);

	List<Product> searchProductsByName(String condition, int offset, int limit);

	void addProduct(Product product);

	void addOrder(Order order);

	int getLastId();

}
