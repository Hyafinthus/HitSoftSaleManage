package com.hit.soft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.JsonOrder;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;
import com.hit.soft.service.ManagerOrderService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manager/order")
public class ManagerOrderController {

	@Autowired
	private ManagerOrderService managerOrderService;
	
	@RequestMapping(value="/{type}", method=RequestMethod.GET)
	@ResponseBody
	public String queryOrders(@PathVariable String type, HttpServletRequest request) {
		int count = managerOrderService.countQueryOrders(type);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Order> data = managerOrderService.queryOrders((pageInt - 1) * limitInt, limitInt, type);
		JsonOrder jsonOrder = new JsonOrder(count, data);
		
		return JSONObject.fromObject(jsonOrder).toString();
	}
	
	@RequestMapping(value="/review/detail/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public OrderProduct reviewOrder(@PathVariable String order_id) {
		OrderProduct orderProduct = managerOrderService.showOrder(Integer.parseInt(order_id));
		orderProduct.setProducts(managerOrderService.showProducts(Integer.parseInt(order_id)));
		return orderProduct;
	}
	
	@RequestMapping(value="/review/approve/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public String approveOrder(@PathVariable String order_id) {
		managerOrderService.approveOrder(Integer.parseInt(order_id));
		return "success";
	}
	
	@RequestMapping(value="/review/reject/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public String rejectOrder(@PathVariable String order_id) {
		managerOrderService.rejectOrder(Integer.parseInt(order_id));
		return "success";
	}
	
	@RequestMapping(value="/deliver/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public String deliverOrder(@PathVariable String order_id) {
		List<Product> products = managerOrderService.showProducts(Integer.parseInt(order_id));
		for(Product product : products) {
			if(product.getCount() > managerOrderService.checkProductDepot(product.getProduct_id())) {
				return "fail";
			}
		}
		for(Product product : products) {
			managerOrderService.deliverProductDepot(product.getProduct_id(), product.getCount());
		}
		managerOrderService.deliverOrder(Integer.parseInt(order_id));
		return "success";
	}
	
}
