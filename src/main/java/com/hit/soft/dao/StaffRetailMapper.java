package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;

@Mapper
public interface StaffRetailMapper {

	
	int countProducts();

	List<Product> searchProducts(@Param("offset") Integer offset, @Param("limit")Integer limit);

	int countProductsById(int parseInt);

	int countProductsByName(String condition);

	List<Product> searchProductsById(@Param("productId") int productId, @Param("offset") Integer offset, @Param("limit")Integer limit);

	List<Product> searchProductsByName(@Param("productName") String productName, @Param("offset") Integer offset, @Param("limit")Integer limit);

	void addProduct(Product product);

	void addOrder(Order order);

	int getLastId();

	void updateDepot(Product product);

	Product completeProduct(Product tmpProduct);

	

}
