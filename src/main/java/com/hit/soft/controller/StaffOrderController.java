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
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public String createOrder(@RequestBody OrderProduct orderProduct){
		staffOrderService.createOrder(orderProduct);
		//System.out.println(staffs);
		return "success";
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	@ResponseBody
	public String submitOrder(@RequestBody OrderProduct orderProduct){
		staffOrderService.submitOrder(orderProduct);
		//System.out.println(staffs);
		return "success";
	}
	
	@RequestMapping(value="/search/whosale_client",method=RequestMethod.GET)
	@ResponseBody
	public List<Client> searchClient(){
		List<Client> clients = staffOrderService.searchClient();
		//System.out.println(staffs);
		return clients;
	}
	
	@RequestMapping(value="/search/product",method=RequestMethod.GET)
	@ResponseBody
	public List<Product> searchProduct(){
		List<Product> products = staffOrderService.searchProduct();
		//System.out.println(staffs);
		return products;
	}
	
	//查询所有已审核通过未付款的订单
	@RequestMapping(value="/search/unpaidOrder",method=RequestMethod.GET)
	@ResponseBody
	public List<Order> searchUnpaidOrder(){
		List<Order> orders = staffOrderService.searchUnpaidOrder();
		//System.out.println(staffs);
		return orders;
	}
	
	//查询已付款的订单用来退款
	@RequestMapping(value="/search/paidOrder",method=RequestMethod.GET)
	@ResponseBody
	public List<Order> searchPaidOrder(){
		List<Order> orders = staffOrderService.searchPaidOrder();
		//System.out.println(staffs);
		return orders;
	}
	
	//查询订单详情
	@RequestMapping(value="/search/OrderProduct/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public OrderProduct searchOrderProduct(@PathVariable int order_id){
		OrderProduct orderProduct = staffOrderService.searchOrderProduct(order_id);
		//System.out.println(staffs);
		return orderProduct;
	}
	
	@RequestMapping(value="/pay/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public String payOrder(@PathVariable int order_id){
		staffOrderService.payOrder(order_id);
		//System.out.println(staffs);
		return "success";
	}
	
	@RequestMapping(value="/return/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public String returnOrder(@PathVariable int order_id){
		staffOrderService.returnOrder(order_id);
		//System.out.println(staffs);
		return "success";
	}
	
}
