package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.BossStatisticMapper;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;

@Service
public class BossStatisticServiceImpl implements BossStatisticService {

	@Autowired
	private BossStatisticMapper bossStatisticMapper;

	@Override
	public List<Product> queryInDepot(String start_time, String end_time) {
		return bossStatisticMapper.queryInDepot(start_time, end_time);
	}

	@Override
	public List<Product> queryTradeProduct(String start_time, String end_time) {
		return bossStatisticMapper.queryTradeProduct(start_time, end_time);
	}

	@Override
	public List<Order> queryTradeOrder(String start_time, String end_time) {
		return bossStatisticMapper.queryTradeOrder(start_time, end_time);
	}

	@Override
	public List<Product> pricePurchase(String start_time, String end_time, String start_date, String end_date, String type) {
		if(type.equals("day")) {
			return bossStatisticMapper.pricePurchaseDay(start_time, end_time, start_date, end_date);
		} else if (type.equals("week")) {
			return bossStatisticMapper.pricePurchaseWeek(start_time, end_time, start_date, end_date);
		} else if (type.equals("month")) {
			return bossStatisticMapper.pricePurchaseMonth(start_time, end_time, start_date, end_date);
		} else if (type.equals("year")) {
			return bossStatisticMapper.pricePurchaseYear(start_time, end_time, start_date, end_date);			
		} else {
			return null;
		}
	}

	@Override
	public List<Order> priceTradeProfit(String start_time, String end_time, String start_date, String end_date, String type) {
		if(type.equals("day")) {
			return bossStatisticMapper.priceTradeProfitDay(start_time, end_time, start_date, end_date);
		} else if (type.equals("week")) {
			return bossStatisticMapper.priceTradeProfitWeek(start_time, end_time, start_date, end_date);
		} else if (type.equals("month")) {
			return bossStatisticMapper.priceTradeProfitMonth(start_time, end_time, start_date, end_date);
		} else if (type.equals("year")) {
			return bossStatisticMapper.priceTradeProfitYear(start_time, end_time, start_date, end_date);			
		} else {
			return null;
		}
	}

}
