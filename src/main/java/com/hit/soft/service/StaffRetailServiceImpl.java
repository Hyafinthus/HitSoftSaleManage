package com.hit.soft.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.StaffRetailMapper;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;

@Service
public class StaffRetailServiceImpl implements StaffRetailService {

	@Autowired
	private StaffRetailMapper staffRetailMapper;

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
		orderProduct = completeOrderProduct(orderProduct);
		Order order = orderProductToOrder(orderProduct, false);
		order.setState("paid_delivered");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setPay_time(df.format(new Date()));// new Date()为获取当前系统时间
		List<Product> products = orderProduct.getProducts();
		staffRetailMapper.addOrder(order);
		int id = staffRetailMapper.getLastId();
		for(int i=0; i<products.size(); i++){
			Product product = products.get(i);
			product.setOrder_id(id);
			staffRetailMapper.addProduct(product);
			staffRetailMapper.updateDepot(product);
		}
	}

	//已知product_id,client_id和count
	//从前端仅传来上述三个值时，需要在后端人为的将orderProduct的其他信息完善，此函数便是实现此功能
	private OrderProduct completeOrderProduct(OrderProduct orderProduct){
		double orderSalePrice = 0, orderPurchasePrice = 0, orderProfit = 0; 
		List<Product> products = orderProduct.getProducts();
			
		orderProduct.setClient_name("零售客户");
		for(int i=0;i<products.size();i++){
			Product tmpProduct = products.get(i);
			int tmpCount = tmpProduct.getCount();
			tmpProduct = staffRetailMapper.completeProduct(tmpProduct);
			tmpProduct.setCount(tmpCount);
			products.set(i,tmpProduct);
			
			orderPurchasePrice += tmpProduct.getPurchase_price()*tmpCount;
			if(tmpProduct.getBonus()!=1){
				orderSalePrice += tmpProduct.getRetail_price()*tmpCount;
			}
		}
		orderProfit = orderSalePrice - orderPurchasePrice;
		orderProduct.setOrder_purchase_price(orderPurchasePrice);
		orderProduct.setOrder_sale_price(orderSalePrice);
		orderProduct.setOrder_profit(orderProfit);
		orderProduct.setProducts(products);
		return orderProduct;
	}
	
	private Order orderProductToOrder(OrderProduct orderProduct, boolean isdraft){
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
