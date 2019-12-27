package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.ManagerProfileMapper;
import com.hit.soft.domain.Client;
import com.hit.soft.domain.Product;

@Service
public class ManagerProfileServiceImpl implements ManagerProfileService {

	@Autowired
	private ManagerProfileMapper managerProfileMapper;
	
	@Override
	public Integer countQueryProducts(String query) {
		return managerProfileMapper.countQueryProducts(query);
	}
	
	@Override
	public List<Product> queryProducts(String query, Integer page, Integer limit) {
		return managerProfileMapper.queryProducts(query, page, limit);
	}

	@Override
	public Integer countQueryClients(String query) {
		return managerProfileMapper.countQueryClients(query);
	}

	@Override
	public List<Client> queryClients(String query, Integer page, Integer limit) {
		return managerProfileMapper.queryClients(query, page, limit);
	}

	@Override
	public void addProduct(Product product) {
		managerProfileMapper.addProduct(product);
		managerProfileMapper.addDepot();
	}

	@Override
	public void addClient(Client client) {
		managerProfileMapper.addClient(client);
	}

	@Override
	public void updateProduct(Product product) {
		managerProfileMapper.updateProduct(product);
	}

	@Override
	public void updateClient(Client client) {
		managerProfileMapper.updateClient(client);
	}

	@Override
	public Double queryRate() {
		return managerProfileMapper.queryRate();
	}

	@Override
	public void updateRate(Double rate) {
		managerProfileMapper.updateRate(rate);
	}

	@Override
	public List<Client> queryPoint() {
		return managerProfileMapper.queryPoint();
	}

	@Override
	public void addPoint(Integer points, Double wallet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePoint(Integer points_id) {
		// TODO Auto-generated method stub
		
	}

}
