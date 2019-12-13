package com.hit.soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;
import com.hit.soft.service.StaffOrderService;

@Controller
@RequestMapping("/staff/order")
public class StaffOrderController {

	@Autowired
	private StaffOrderService staffOrderService;
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	@ResponseBody
	public Order createOrder(){
		Order draft = staffOrderService.getDraft();
		if(draft != null){
			return draft;
		}else{
			return null;
		}
	}
	
	//保存为草稿
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveOrder(@RequestBody OrderProduct orderProduct){
		staffOrderService.saveOrder(orderProduct);
		return "success";
	}
	
	//上传给经理审核
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	@ResponseBody
	public String submitOrder(@RequestBody OrderProduct orderProduct){
		staffOrderService.submitOrder(orderProduct);
		return "success";
	}
	
	//查询批发用户
	@RequestMapping(value="/search/whosale_client",method=RequestMethod.GET)
	@ResponseBody
	public List<Client> searchClient(){
		List<Client> clients = staffOrderService.searchClient();
		return clients;
	}
	
	//查询产品
	@RequestMapping(value="/search/product",method=RequestMethod.GET)
	@ResponseBody
	public List<Product> searchProduct(){
		List<Product> products = staffOrderService.searchProduct();
		return products;
	}
	
	//查询所有已审核通过未付款的订单
	@RequestMapping(value="/search/unpaidOrder",method=RequestMethod.GET)
	@ResponseBody
	public List<Order> searchUnpaidOrder(){
		List<Order> orders = staffOrderService.searchUnpaidOrder();
		return orders;
	}
	
	//查询已付款的订单用来退款
	@RequestMapping(value="/search/paidOrder",method=RequestMethod.GET)
	@ResponseBody
	public List<Order> searchPaidOrder(){
		List<Order> orders = staffOrderService.searchPaidOrder();
		return orders;
	}
	
	//查询订单详情
	@RequestMapping(value="/search/OrderProduct/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public OrderProduct searchOrderProduct(@PathVariable int order_id){
		OrderProduct orderProduct = staffOrderService.searchOrderProduct(order_id);
		return orderProduct;
	}
	
	//付款
	@RequestMapping(value="/pay/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public String payOrder(@PathVariable int order_id){
		staffOrderService.payOrder(order_id);
		return "success";
	}
	
	//退款
	@RequestMapping(value="/return/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public String returnOrder(@PathVariable int order_id){
		staffOrderService.returnOrder(order_id);
		return "success";
	}
	
}
