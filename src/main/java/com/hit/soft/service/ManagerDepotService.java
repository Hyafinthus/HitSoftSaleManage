package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.ProductDepot;

public interface ManagerDepotService {
	
	public Integer countQueryProducts(String query);
	
	public List<ProductDepot> queryProducts(String query, Integer page, Integer limit);
	
	public void turnoverDepot(String depot_name, String product_id, String number);

	public void transferDepot(String old_depot, String new_depot, String product_id, String number);

}
