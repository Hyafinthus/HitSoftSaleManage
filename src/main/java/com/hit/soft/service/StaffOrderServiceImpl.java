package com.hit.soft.service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Date;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.ManagerDepotMapper;
import com.hit.soft.dao.StaffOrderMapper;
import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Service
public class StaffOrderServiceImpl implements StaffOrderService{

	@Autowired
	private StaffOrderMapper staffOrderMapper;
	@Autowired
	private ManagerDepotMapper managerDepotMapper;

	//保存草稿
	@Override
	public void saveOrder(OrderProduct orderProduct) {
		orderProduct = completeOrderProduct(orderProduct);
		Order order = orderProductToOrder(orderProduct, true);
		List<Product> products = orderProduct.getProducts();
		staffOrderMapper.deleteDraft();
		staffOrderMapper.addOrder(order);
		int id = staffOrderMapper.getLastId();
		for(int i=0; i<products.size(); i++){
			Product product = products.get(i);
			product.setOrder_id(id);
			staffOrderMapper.addProduct(product);
		}
		
	}
	
	//上传给经理审核
	@Override
	public void submitOrder(OrderProduct orderProduct) {
		orderProduct = completeOrderProduct(orderProduct);
		Order order = orderProductToOrder(orderProduct, false);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setCreate_time(df.format(new Date()));// new Date()为获取当前系统时间
		List<Product> products = orderProduct.getProducts();
		
		if(orderProduct.getOrder_id() >= 1){
			staffOrderMapper.deleteOrder(orderProduct.getOrder_id());
		}else{
			staffOrderMapper.deleteDraft();
		}
		
		
		staffOrderMapper.addOrder(order);
		int id = staffOrderMapper.getLastId();
		for(int i=0; i<products.size(); i++){
			Product product = products.get(i);
			product.setOrder_id(id);
			staffOrderMapper.addProduct(product);
		}
		
	}
	
	@Override
	public int countClients() {
		return staffOrderMapper.countClients();
	}
	
	@Override
	public List<Client> searchClients(Integer offset, Integer limit) {
		List<Client> clients = staffOrderMapper.searchClients(offset, limit);
		return clients;
	}
	
	@Override
	public int countClientsByCondition(String condition) {
		if(isInteger(condition)){
			return staffOrderMapper.countClientsById(Integer.parseInt(condition));
		}else{
			return staffOrderMapper.countClientsByName(condition);
		}
	}

	@Override
	public List<Client> searchClientsByCondition(String condition, Integer offset, Integer limit) {
		List<Client> clients = new ArrayList<Client>();
		if(isInteger(condition)){
			clients = staffOrderMapper.searchClientsById(Integer.parseInt(condition), offset, limit);
		}else{
			clients = staffOrderMapper.searchClientsByName(condition, offset, limit);
		}
		return clients;
	}
	
	@Override
	public int countProducts() {
		return staffOrderMapper.countProducts();
	}

	@Override
	public List<Product> searchProducts(Integer offset, Integer limit) {
		List<Product> products = staffOrderMapper.searchProducts(offset, limit);
		return products;
	}

	@Override
	public int countProductsByCondition(String condition) {
		if(isInteger(condition)){
			return staffOrderMapper.countProductsById(Integer.parseInt(condition));
		}else{
			return staffOrderMapper.countProductsByName(condition);
		}
	}

	@Override
	public List<Product> searchProductsByCondition(String condition, Integer offset, Integer limit) {
		List<Product> products = new ArrayList<Product>();
		if(isInteger(condition)){
			products = staffOrderMapper.searchProductsById(Integer.parseInt(condition), offset, limit);
		}else{
			products = staffOrderMapper.searchProductsByName(condition, offset, limit);
		}
		return products;
	}

	@Override
	public int countUnpaidOrder() {
		return staffOrderMapper.countUnpaidOrder();
	}

	@Override
	public List<Order> searchUnpaidOrder(Integer offset, Integer limit) {
		List<Order> orders = staffOrderMapper.searchUnpaidOrder(offset, limit);
		return orders;
	}

	@Override
	public int countPaidOrder() {
		return staffOrderMapper.countPaidOrder();
	}

	@Override
	public List<Order> searchPaidOrder(Integer offset, Integer limit) {
		List<Order> orders = staffOrderMapper.searchPaidOrder(offset, limit);
		return orders;
	}
	
	@Override
	public int countRejectedOrder() {
		return staffOrderMapper.countRejectedOrder();
	}

	@Override
	public List<Order> searchRejectedOrder(Integer offset, Integer limit) {
		List<Order> orders = staffOrderMapper.searchRejectedOrder(offset, limit);
		return orders;
	}

	@Override
	public OrderProduct searchOrderProduct(int orderId) {
		OrderProduct orderProduct = staffOrderMapper.searchOrderProduct(orderId);
		return orderProduct;
	}

	@Override
	public void payOrder(int orderId) {
		Order order = searchOrder(orderId);
		if(order.getState().equals("approved")){
			order.setState("paid_undelivered");
		}else{
			order.setState("paid_delivered");
		}
		
		int addPoints = (int)(order.getOrder_sale_price()*1.0);
		staffOrderMapper.changePoints(addPoints,order.getClient_id());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setPay_time(df.format(new Date()));// new Date()为获取当前系统时间
		staffOrderMapper.updateOrder(order);
	}

	//退货时不仅修改状态，还要更改仓库物品的成本价
	@Override
	public void returnOrder(int orderId) {
		Order order = searchOrder(orderId);
		order.setState("returned");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setReturn_time(df.format(new Date()));// new Date()为获取当前系统时间
		staffOrderMapper.updateOrder(order);
		
		OrderProduct orderProduct = searchOrderProduct(orderId);
		List<Product> products = orderProduct.getProducts();
		for (int i=0; i<products.size(); i++){
			Product product = products.get(i);
			System.err.println(product);
			Integer prodCount = managerDepotMapper.countProductDepot(product.getProduct_id());
			Double prodOldPurch = managerDepotMapper.queryProductPurchase(product.getProduct_id());
			Double prodNewPurch = (prodCount * prodOldPurch + product.getPurchase_price() * product.getCount()) / (prodCount + product.getCount());
			managerDepotMapper.updateProductPurchase(product.getProduct_id(), prodNewPurch);
			managerDepotMapper.turnoverDepot("门店",product.getProduct_id(), product.getCount());
		}
	}

	public OrderProduct getDraft(){
		return staffOrderMapper.getDraft();
	}
	
	@Override
	public void saveMoney(Client client) {
		staffOrderMapper.saveMoney(client);
	}
	
	private Order searchOrder(int orderId){
		Order order = staffOrderMapper.searchOrder(orderId);
		return order;
	}

	//已知product_id,client_id和count
	//从前端仅传来上述三个值时，需要在后端人为的将orderProduct的其他信息完善，此函数便是实现此功能
	private OrderProduct completeOrderProduct(OrderProduct orderProduct){
		double orderSalePrice = 0, orderPurchasePrice = 0, orderProfit = 0; 
		List<Product> products = orderProduct.getProducts();
		
		//获取折扣
		double discount=1;
		for(int i=0;i<products.size();i++){
			if(products.get(i).getProduct_id()==-1){
				discount = products.get(i).getCount()/100.0;
				products.remove(i);
			}
		}
		
		//完善每个货物的具体信息
		orderProduct.setClient_name(staffOrderMapper.searchClientById(orderProduct.getClient_id()).getClient_name());
		for(int i=0;i<products.size();i++){
			Product tmpProduct = products.get(i);
			int tmpCount = tmpProduct.getCount();
			int tmpBonus = tmpProduct.getBonus();
			tmpProduct = staffOrderMapper.completeProduct(tmpProduct);
			tmpProduct.setCount(tmpCount);
			tmpProduct.setBonus(tmpBonus);
			products.set(i,tmpProduct);
			
			orderPurchasePrice += tmpProduct.getPurchase_price()*tmpCount;
			if(tmpProduct.getBonus()!=1){
				orderSalePrice += tmpProduct.getWholesale_price()*tmpCount;
			}
		}
		orderSalePrice *= discount;
		
		//设置价格
		orderProfit = orderSalePrice - orderPurchasePrice;
		orderProduct.setOrder_purchase_price(orderPurchasePrice);
		orderProduct.setOrder_sale_price(orderSalePrice);
		orderProduct.setOrder_profit(orderProfit);
		orderProduct.setProducts(products);
		return orderProduct;
	}
	
	//将OrderProduct转换为Order
	private Order orderProductToOrder(OrderProduct orderProduct, boolean isdraft){
		Order order = new Order();
		order.setClient_id(orderProduct.getClient_id());
		order.setCreate_time(orderProduct.getCreate_time());
		order.setOrder_id(orderProduct.getOrder_id());
		if(isdraft){
			order.setState("draft");//草稿
		}else{
			order.setState("published");//提交审核
		}
		order.setWholesale_order(1);//1表示是批发单
		order.setOrder_purchase_price(orderProduct.getOrder_purchase_price());
		order.setOrder_sale_price(orderProduct.getOrder_sale_price());
		order.setOrder_profit(orderProduct.getOrder_profit());
		return order;
	}

	private boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
	}

	

	


}
