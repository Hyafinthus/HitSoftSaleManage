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
	public Integer countQueryOrders(String type) {
		if(type.equals("review")) {
			return managerOrderMapper.countQueryOrders("published", "");
		} else if (type.equals("deliver")) {
			return managerOrderMapper.countQueryOrders("approved", "paid_undelivered");
		} else if (type.equals("history")) {
			return managerOrderMapper.countQueryOrders("unpaid_delivered", "paid_delivered");
		}
		return 0;
	}
	
	@Override
	public List<Order> queryOrders(Integer page, Integer limit, String type) {
		if(type.equals("review")) {
			return managerOrderMapper.queryOrders(page, limit, "published", "");
		} else if (type.equals("deliver")) {
			return managerOrderMapper.queryOrders(page, limit, "approved", "paid_undelivered");
		} else if (type.equals("history")) {
			return managerOrderMapper.queryOrders(page, limit, "unpaid_delivered", "paid_delivered");
		}
		return null;
	}

	@Override
	public List<Product> showProducts(Integer order_id) {
		return managerOrderMapper.showProducts(order_id);
	}

	@Override
	public OrderProduct showOrder(Integer order_id) {
		return managerOrderMapper.showOrder(order_id);
	}

	@Override
	public void approveOrder(Integer order_id) {
		managerOrderMapper.approveOrder(order_id);
	}

	@Override
	public void rejectOrder(Integer order_id) {
		managerOrderMapper.rejectOrder(order_id);
	}

	@Override
	public void deliverOrder(Integer order_id) {
		managerOrderMapper.deliverOrder(order_id);
	}

	@Override
	public void deliverProductDepot(Integer product_id, Integer count) {
		managerOrderMapper.deliverProductDepot(product_id, count);
	}

	@Override
	public Integer checkProductDepot(Integer product_id) {
		return managerOrderMapper.checkProductDepot(product_id);
	}
	
}
