package com.hit.soft.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.ManagerDepotMapper;
import com.hit.soft.domain.ProductDepot;

@Service
public class ManagerDepotServiceImpl implements ManagerDepotService {

	@Autowired
	private ManagerDepotMapper managerDepotMapper;
	
	@Override
	public Integer countQueryProducts(String query) {
		return managerDepotMapper.countQueryProducts(query);
	}

	@Override
	public List<ProductDepot> queryProducts(String query, Integer page, Integer limit) {
		return managerDepotMapper.queryProducts(query, page, limit);
	}
	
	@Override
	public void inDepot(String depot_name, Integer product_id, Integer number, Double in_price) {
		Integer prodCount = managerDepotMapper.countProductDepot(product_id);
		Double prodOldPurch = managerDepotMapper.queryProductPurchase(product_id);
		Double prodNewPurch = (prodCount * prodOldPurch + in_price * number) / (prodCount + number);
		managerDepotMapper.updateProductPurchase(product_id, prodNewPurch);
		managerDepotMapper.turnoverDepot(depot_name, product_id, number);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        managerDepotMapper.addDepotHistory(product_id, number, in_price, depot_name, df.format(new Date()));
	}

	@Override
	public void turnoverDepot(String depot_name, Integer product_id, Integer number) {
		managerDepotMapper.turnoverDepot(depot_name, product_id, number);;
	}

	@Override
	public void transferDepot(String old_depot, String new_depot, Integer product_id, Integer number) {
		managerDepotMapper.transferOldDepot(old_depot, product_id, number);
		managerDepotMapper.transferNewDepot(new_depot, product_id, number);
	}

	@Override
	public Integer countQueryDepot(String depot_name) {
		return managerDepotMapper.countQueryDepot(depot_name);
	}

	@Override
	public List<ProductDepot> queryDepot(String depot_name, Integer page, Integer limit) {
		return managerDepotMapper.queryDepot(depot_name, page, limit);
	}

	@Override
	public void confirmDepot(String depot_name, Integer product_id, Integer number) {
		managerDepotMapper.confirmDepot(depot_name, product_id, number);
	}

}
