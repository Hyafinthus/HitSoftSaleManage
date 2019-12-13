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
	}

}
