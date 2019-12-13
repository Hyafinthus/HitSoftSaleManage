package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.ProductDepot;

public interface ManagerDepotService {
	
	public Integer countQueryProducts(String query);
	
	public List<ProductDepot> queryProducts(String query, Integer page, Integer limit);
	
}
