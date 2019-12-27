package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;

public interface BossStatisticService {

	public List<Product> queryInDepot(String start_time, String end_time);
	
	public List<Product> queryTradeProduct(String start_time, String end_time);
	
	public List<Order> queryTradeOrder(String start_time, String end_time);
	
	public List<Product> pricePurchaseDay(String start_time, String end_time, String start_date, String end_date);
	
	public List<Order> priceTradeProfitDay(String start_time, String end_time, String start_date, String end_date);
	
}
