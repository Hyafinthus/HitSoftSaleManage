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
import com.hit.soft.domain.JsonProduct;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;
import com.hit.soft.service.StaffRetailService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/staff/retail")
public class StaffRetailController {

	@Autowired
	private StaffRetailService staffRetailService;
	
	//查询零售用户
		@RequestMapping(value="/search/whosale_clients",method=RequestMethod.GET)
		@ResponseBody
		public String searchClients(HttpServletRequest request){
			int count = staffRetailService.countClients();
			int pageInt = Integer.parseInt(request.getParameter("page"));
			int limitInt = Integer.parseInt(request.getParameter("limit"));
			List<Client> data = staffRetailService.searchClients((pageInt - 1) * limitInt, limitInt);
			JsonClient jsonClient = new JsonClient(count, data);
			return JSONObject.fromObject(jsonClient).toString();
		}
		
		@RequestMapping(value="/search/whosale_clients/{condition}",method=RequestMethod.GET)
		@ResponseBody
		public String searchClientsByCondition(@PathVariable String condition, HttpServletRequest request){
			System.out.println(condition);
			int count = staffRetailService.countClientsByCondition(condition);
			System.err.println(count);
			int pageInt = Integer.parseInt(request.getParameter("page"));
			int limitInt = Integer.parseInt(request.getParameter("limit"));
			List<Client> data = staffRetailService.searchClientsByCondition(condition, (pageInt - 1) * limitInt, limitInt);
			JsonClient jsonClient = new JsonClient(count, data);
			return JSONObject.fromObject(jsonClient).toString();
		}
		
		//查询产品
		@RequestMapping(value="/search/products",method=RequestMethod.GET)
		@ResponseBody
		public String searchProducts(HttpServletRequest request){
			int count = staffRetailService.countProducts();
			int pageInt = Integer.parseInt(request.getParameter("page"));
			int limitInt = Integer.parseInt(request.getParameter("limit"));
			List<Product> data = staffRetailService.searchProducts((pageInt - 1) * limitInt, limitInt);
			JsonProduct jsonProduct = new JsonProduct(count, data);
			return JSONObject.fromObject(jsonProduct).toString();
		}
		
		@RequestMapping(value="/search/products/{condition}",method=RequestMethod.GET)
		@ResponseBody
		public String searchProductsByCondition(@PathVariable String condition, HttpServletRequest request){
			int count = staffRetailService.countProductsByCondition(condition);
			int pageInt = Integer.parseInt(request.getParameter("page"));
			int limitInt = Integer.parseInt(request.getParameter("limit"));
			List<Product> data = staffRetailService.searchProductsByCondition(condition, (pageInt - 1) * limitInt, limitInt);
			JsonProduct jsonProduct = new JsonProduct(count, data);
			return JSONObject.fromObject(jsonProduct).toString();
		}
		
		//付款
		@RequestMapping(value="/pay",method=RequestMethod.POST)
		@ResponseBody
		public String payOrder(@RequestBody OrderProduct orderProduct){
			staffRetailService.payOrder(orderProduct);
			return "success";
		}
}
