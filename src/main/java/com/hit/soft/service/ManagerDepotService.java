package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.ProductDepot;

public interface ManagerDepotService {
	
	public Integer countQueryProducts(String query);
	
	public List<ProductDepot> queryProducts(String query, Integer page, Integer limit);
	
	public void turnoverDepot(String depot_name, Integer product_id, Integer number);

	public void transferDepot(String old_depot, String new_depot, Integer product_id, Integer number);

	public Integer countQueryDepot(String depot_name);
	
	public List<ProductDepot> queryDepot(String depot_name, Integer page, Integer limit);

	public void confirmDepot(String depot_name, Integer product_id, Integer number);
	
}
