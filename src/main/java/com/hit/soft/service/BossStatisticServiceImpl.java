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
	public List<Product> pricePurchaseDay(String start_time, String end_time, String start_date, String end_date) {
		return bossStatisticMapper.pricePurchaseDay(start_time, end_time, start_date, end_date);
	}

	@Override
	public List<Order> priceTradeProfitDay(String start_time, String end_time, String start_date, String end_date) {
		return bossStatisticMapper.priceTradeProfitDay(start_time, end_time, start_date, end_date);
	}

}
