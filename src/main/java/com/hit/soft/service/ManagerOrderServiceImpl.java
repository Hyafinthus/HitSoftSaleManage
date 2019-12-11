package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.ManagerOrderMapper;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Service
public class ManagerOrderServiceImpl implements ManagerOrderService {

	@Autowired
	private ManagerOrderMapper managerOrderMapper;

	@Override
	public List<Order> queryOrders() {
		return managerOrderMapper.queryOrders();
	}

	@Override
	public List<Product> showProducts(String order_id) {
		return managerOrderMapper.showProducts(order_id);
	}

	@Override
	public OrderProduct showOrder(String order_id) {
		return managerOrderMapper.showOrder(order_id);
	}

	@Override
	public void approveOrder(String order_id) {
		managerOrderMapper.approveOrder(order_id);
	}

	@Override
	public void rejectOrder(String order_id) {
		managerOrderMapper.rejectOrder(order_id);
	}
	
}
