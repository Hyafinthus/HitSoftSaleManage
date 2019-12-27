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
import com.hit.soft.domain.JsonProduct;
import com.hit.soft.domain.OrderProduct;
import com.hit.soft.domain.Product;
import com.hit.soft.service.ClientAppService;
import com.hit.soft.service.StaffRetailService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/client")
public class ClientAppController {

	@Autowired
	private ClientAppService clientAppService;
	@Autowired
	private StaffRetailService staffRetailService;
	
		//存款
		@RequestMapping(value="/save/money",method=RequestMethod.POST)
		@ResponseBody
		public String saveMoney(@RequestBody Client client){
			clientAppService.saveMoney(client);
			return "success";
		}
		
		//查询个人信息
		@RequestMapping(value="/search/client/{client_id}",method=RequestMethod.GET)
		@ResponseBody
		public Client searchClient(@PathVariable int client_id){
			Client client = clientAppService.searchClient(client_id);
			return client;
		}
		
		//下单
		@RequestMapping(value="/pay",method=RequestMethod.POST)
		@ResponseBody
		public String payOrder(@RequestBody OrderProduct orderProduct){
			clientAppService.payOrder(orderProduct);
			return "success";
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
		
		//积分兑换现金
		//@RequestMapping(value="/points_for_cash",method=RequestMethod.POST)
		//@ResponseBody
		//public String pointsForCash(@RequestBody OrderProduct orderProduct){
		//	clientAppService.pointsForCash(orderProduct);
		//	return "success";
		//}
}
