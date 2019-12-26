package com.hit.soft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.JsonClient;
import com.hit.soft.domain.JsonOrder;
import com.hit.soft.domain.JsonProduct;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;
import com.hit.soft.service.StaffOrderService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/staff/order")
public class StaffOrderController {

	@Autowired
	private StaffOrderService staffOrderService;
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	@ResponseBody
	public OrderProduct createOrder(){
		OrderProduct draft = staffOrderService.getDraft();
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
	@RequestMapping(value="/search/whosale_clients",method=RequestMethod.GET)
	@ResponseBody
	public String searchClients(HttpServletRequest request){
		int count = staffOrderService.countClients();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Client> data = staffOrderService.searchClients((pageInt - 1) * limitInt, limitInt);
		JsonClient jsonClient = new JsonClient(count, data);
		return JSONObject.fromObject(jsonClient).toString();
	}
	
	@RequestMapping(value="/search/whosale_clients/{condition}",method=RequestMethod.GET)
	@ResponseBody
	public String searchClientsByCondition(@PathVariable String condition, HttpServletRequest request){
		System.out.println(condition);
		int count = staffOrderService.countClientsByCondition(condition);
		System.err.println(count);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Client> data = staffOrderService.searchClientsByCondition(condition, (pageInt - 1) * limitInt, limitInt);
		JsonClient jsonClient = new JsonClient(count, data);
		return JSONObject.fromObject(jsonClient).toString();
	}
	
	//查询产品
	@RequestMapping(value="/search/products",method=RequestMethod.GET)
	@ResponseBody
	public String searchProducts(HttpServletRequest request){
		int count = staffOrderService.countProducts();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Product> data = staffOrderService.searchProducts((pageInt - 1) * limitInt, limitInt);
		JsonProduct jsonProduct = new JsonProduct(count, data);
		return JSONObject.fromObject(jsonProduct).toString();
	}
	
	@RequestMapping(value="/search/products/{condition}",method=RequestMethod.GET)
	@ResponseBody
	public String searchProductsByCondition(@PathVariable String condition, HttpServletRequest request){
		int count = staffOrderService.countProductsByCondition(condition);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Product> data = staffOrderService.searchProductsByCondition(condition, (pageInt - 1) * limitInt, limitInt);
		JsonProduct jsonProduct = new JsonProduct(count, data);
		return JSONObject.fromObject(jsonProduct).toString();
	}
	
	//查询所有已审核通过未付款的订单
	@RequestMapping(value="/search/unpaidOrder",method=RequestMethod.GET)
	@ResponseBody
	public String searchUnpaidOrder(HttpServletRequest request){
		int count = staffOrderService.countUnpaidOrder();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Order> data = staffOrderService.searchUnpaidOrder((pageInt - 1) * limitInt, limitInt);
		JsonOrder jsonOrder = new JsonOrder(count, data);
		return JSONObject.fromObject(jsonOrder).toString();
	}
	
	//查询已付款的订单用来退款
	@RequestMapping(value="/search/paidOrder",method=RequestMethod.GET)
	@ResponseBody
	public String searchPaidOrder(HttpServletRequest request){
		int count = staffOrderService.countPaidOrder();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Order> data = staffOrderService.searchPaidOrder((pageInt - 1) * limitInt, limitInt);
		JsonOrder jsonOrder = new JsonOrder(count, data);
		return JSONObject.fromObject(jsonOrder).toString();
	}
	
	//查询已付款的订单用来退款
		@RequestMapping(value="/search/rejectedOrder",method=RequestMethod.GET)
		@ResponseBody
		public String searchRejectedOrder(HttpServletRequest request){
			int count = staffOrderService.countRejectedOrder();
			int pageInt = Integer.parseInt(request.getParameter("page"));
			int limitInt = Integer.parseInt(request.getParameter("limit"));
			List<Order> data = staffOrderService.searchRejectedOrder((pageInt - 1) * limitInt, limitInt);
			JsonOrder jsonOrder = new JsonOrder(count, data);
			return JSONObject.fromObject(jsonOrder).toString();
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
	
	//存款
	@RequestMapping(value="/save/money",method=RequestMethod.POST)
	@ResponseBody
	public String saveMoney(@RequestBody Client client){
		staffOrderService.saveMoney(client);
		return "success";
	}
	
}
