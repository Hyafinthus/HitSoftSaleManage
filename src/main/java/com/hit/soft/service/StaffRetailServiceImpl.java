package com.hit.soft.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.StaffRetailMapper;
import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Service
public class StaffRetailServiceImpl implements StaffRetailService {

	@Autowired
	private StaffRetailMapper staffRetailMapper;

	@Override
	public int countClients() {
		return staffRetailMapper.countClients();
	}

	@Override
	public List<Client> searchClients(int offset, int limit) {
		List<Client> clients = staffRetailMapper.searchClients(offset, limit);
		return clients;
	}

	@Override
	public int countClientsByCondition(String condition) {
		if(isInteger(condition)){
			return staffRetailMapper.countClientsById(Integer.parseInt(condition));
		}else{
			return staffRetailMapper.countClientsByName(condition);
		}
	}

	@Override
	public List<Client> searchClientsByCondition(String condition, int offset, int limit) {
		List<Client> clients = new ArrayList<Client>();
		if(isInteger(condition)){
			clients = staffRetailMapper.searchClientsById(Integer.parseInt(condition), offset, limit);
		}else{
			clients = staffRetailMapper.searchClientsByName(condition, offset, limit);
		}
		return clients;
	}

	@Override
	public int countProducts() {
		return staffRetailMapper.countProducts();
	}

	@Override
	public List<Product> searchProducts(int offset, int limit) {
		List<Product> products = staffRetailMapper.searchProducts(offset, limit);
		return products;
	}

	@Override
	public int countProductsByCondition(String condition) {
		if(isInteger(condition)){
			return staffRetailMapper.countProductsById(Integer.parseInt(condition));
		}else{
			return staffRetailMapper.countProductsByName(condition);
		}
	}

	@Override
	public List<Product> searchProductsByCondition(String condition, int offset, int limit) {
		List<Product> products = new ArrayList<Product>();
		if(isInteger(condition)){
			products = staffRetailMapper.searchProductsById(Integer.parseInt(condition), offset, limit);
		}else{
			products = staffRetailMapper.searchProductsByName(condition, offset, limit);
		}
		return products;
	}

	@Override
	public void payOrder(OrderProduct orderProduct) {
		Order order = orderProductToOrder(orderProduct, false);
		order.setState("paid");
		List<Product> products = orderProduct.getProducts();
		staffRetailMapper.addOrder(order);
		int id = staffRetailMapper.getLastId();
		for(int i=0; i<products.size(); i++){
			Product product = products.get(i);
			product.setOrder_id(id);
			staffRetailMapper.addProduct(product);
		}

	}

	private Order orderProductToOrder(OrderProduct orderProduct, boolean isdraft){
		double purchase_price=0,sale_price=0;
		List<Product> products = orderProduct.getProducts();
		Order order = new Order();
		order.setClient_id(orderProduct.getClient_id());
		order.setCreate_time(orderProduct.getCreate_time());
		order.setOrder_id(orderProduct.getOrder_id());
		if(isdraft){
			order.setState("draft");//草稿
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        order.setCreate_time(df.format(new Date()));// new Date()为获取当前系统时间
			order.setState("published");//提交审核
		}
		order.setWholesale_order(0);//0表示非批发单
		for(int i=0; i<products.size(); i++){
			Product temp = products.get(i);
			purchase_price += temp.getPurchase_price()*temp.getCount();
		}
		for(int i=0; i<products.size(); i++){
			Product temp = products.get(i);
			sale_price += temp.getWholesale_price()*temp.getCount();
		}
		order.setOrder_purchase_price(purchase_price);
		order.setOrder_sale_price(sale_price);
		order.setOrder_profit(sale_price-purchase_price);
		return order;
	}

	private boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
	}
}
