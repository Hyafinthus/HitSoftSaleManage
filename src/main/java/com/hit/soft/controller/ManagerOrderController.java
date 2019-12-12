package com.hit.soft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hit.soft.domain.JsonOrder;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.service.ManagerOrderService;

@Controller
@RequestMapping("/manager")
public class ManagerOrderController {

	@Autowired
	private ManagerOrderService managerOrderService;
	
	@RequestMapping(value="/order",method=RequestMethod.GET)
	@ResponseBody
	public String queryOrders(HttpServletRequest req) {
		int count = managerOrderService.countQueryOrders();
		int pageInt = 0;
		System.out.print("limit:"+req.getParameter("limit")+"\n");
		System.out.print("page:"+req.getParameter("page")+"\n");
		pageInt = Integer.parseInt(req.getParameter("page"));
		int limitInt = 0;
		limitInt = Integer.parseInt(req.getParameter("limit"));
		List<Order> data = managerOrderService.queryOrders((pageInt - 1) * limitInt, limitInt);
		JsonOrder jsonOrder = new JsonOrder(count, data);
		
		return JSONObject.fromObject(jsonOrder).toString();
	}
	
	@RequestMapping(value="/order/review/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public OrderProduct reviewOrder(@PathVariable String order_id) {
		OrderProduct orderProduct = managerOrderService.showOrder(order_id);
		orderProduct.setProducts(managerOrderService.showProducts(order_id));
		return orderProduct;
	}
	
	@RequestMapping(value="/order/approve/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public String approveOrder(@PathVariable String order_id) {
		managerOrderService.approveOrder(order_id);
		return "success";
	}
	
	@RequestMapping(value="/order/reject/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public String rejectOrder(@PathVariable String order_id) {
		managerOrderService.rejectOrder(order_id);
		return "success";
	}
	
}
