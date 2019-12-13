package com.hit.soft.service;

import java.util.List;
import java.util.Date;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.StaffOrderMapper;
import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Service
public class StaffOrderServiceImpl implements StaffOrderService{

	@Autowired
	private StaffOrderMapper staffOrderMapper;

	//保存草稿
	@Override
	public void saveOrder(OrderProduct orderProduct) {
		Order order = orderProductToOrder(orderProduct, true);
		List<Product> products = orderProduct.getProducts();
		staffOrderMapper.deleteDraft();
		for(int i=0; i<products.size(); i++){
			staffOrderMapper.addProduct(products.get(i));
		}
		staffOrderMapper.addOrder(order);
	}
	
	//上传给经理审核
	@Override
	public void submitOrder(OrderProduct orderProduct) {
		Order order = orderProductToOrder(orderProduct, false);
		List<Product> products = orderProduct.getProducts();
		staffOrderMapper.deleteDraft();
		for(int i=0; i<products.size(); i++){
			staffOrderMapper.addProduct(products.get(i));
		}
		staffOrderMapper.addOrder(order);
	}

	@Override
	public List<Client> searchClient() {
		List<Client> clients = staffOrderMapper.searchClient();
		return clients;
	}

	@Override
	public List<Product> searchProduct() {
		List<Product> products = staffOrderMapper.searchProduct();
		return products;
	}

	@Override
	public List<Order> searchUnpaidOrder() {
		List<Order> orders = staffOrderMapper.searchUnpaidOrder();
		return orders;
	}

	@Override
	public List<Order> searchPaidOrder() {
		List<Order> orders = staffOrderMapper.searchPaidOrder();
		return orders;
	}

	@Override
	public OrderProduct searchOrderProduct(int orderId) {
		OrderProduct orderProduct = staffOrderMapper.searchOrderProduct(orderId);
		return orderProduct;
	}
	
	@Override
	public Order searchOrder(int orderId){
		Order order = staffOrderMapper.searchOrder(orderId);
		return order;
	}
	
	@Override
	public Order orderProductToOrder(OrderProduct orderProduct, boolean isdraft){
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
		order.setWholesale_order(1);//1表示是批发单
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
		return order;
	}

	@Override
	public void payOrder(int orderId) {
		Order order = searchOrder(orderId);
		order.setState("paid");
		order.setOrder_profit(order.getOrder_sale_price()-order.getOrder_purchase_price());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setPay_time(df.format(new Date()));// new Date()为获取当前系统时间
		staffOrderMapper.updateOrder(order);
	}

	@Override
	public void returnOrder(int orderId) {
		Order order = searchOrder(orderId);
		order.setOrder_profit(0);
		order.setState("returned");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setReturn_time(df.format(new Date()));// new Date()为获取当前系统时间
		staffOrderMapper.updateOrder(order);
	}

	public Order getDraft(){
		Order draft = staffOrderMapper.getDraft();
		return draft;
	}

	
	
}
