package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.ManagerDepotMapper;
import com.hit.soft.domain.ProductDepot;

@Service
public class ManagerDepotServiceImpl implements ManagerDepotService {

	@Autowired
	private ManagerDepotMapper managerDepotMapper;
	
	@Override
	public Integer countQueryProducts(String query) {
		return managerDepotMapper.countQueryProducts(query);
	}

	@Override
	public List<ProductDepot> queryProducts(String query, Integer page, Integer limit) {
		return managerDepotMapper.queryProducts(query, page, limit);
	}

}
