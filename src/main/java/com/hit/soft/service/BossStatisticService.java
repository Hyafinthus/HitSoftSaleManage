package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Product;

public interface BossStatisticService {

	public List<Product> queryInDepot(String start_time, String end_time);
	
	public List<Product> queryMarketOrder(String start_time, String end_time);	
	
}
