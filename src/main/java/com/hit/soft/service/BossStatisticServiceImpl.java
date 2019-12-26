package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.BossStatisticMapper;
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
	public List<Product> queryMarketOrder(String start_time, String end_time) {
		return bossStatisticMapper.queryMarketOrder(start_time, end_time);
	}

}
