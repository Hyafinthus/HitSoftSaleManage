package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Product;

public interface ManagerProfileService {

	public Integer countQueryProducts(String query);
	
	public List<Product> queryProducts(String query, Integer page, Integer limit);
	
	public Integer countQueryClients(String query);
	
	public List<Client> queryClients(String query, Integer page, Integer limit);

	public void addProduct(Product product);
	
}
