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
	
	public void addClient(Client client);
	
	public void updateProduct(Product product);
	
	public void updateClient(Client client);
	
	public Double queryRate();
	
	public void updateRate(Double rate);
	
	public List<Client> queryPoint();
	
	public void addPoint(Integer points, Double wallet);
	
	public void deletePoint(Integer points_id);
	
}
