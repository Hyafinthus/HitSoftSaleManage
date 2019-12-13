package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.ManagerProfileMapper;
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

}
