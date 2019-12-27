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
import com.hit.soft.domain.Product;
import com.hit.soft.service.ManagerProfileService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manager/profile")
public class ManagerProfileController {

	@Autowired
	private ManagerProfileService managerProfileService;
	
	@RequestMapping(value="/product/search/{query}", method=RequestMethod.GET)
	@ResponseBody
	public String queryProducts(@PathVariable String query, HttpServletRequest request) {
		int count = managerProfileService.countQueryProducts(query);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Product> data = managerProfileService.queryProducts(query.replaceAll(" ", ""), (pageInt - 1) * limitInt, limitInt);
		JsonProduct jsonProduct = new JsonProduct(count, data);
		
		return JSONObject.fromObject(jsonProduct).toString();
	}
	
	@RequestMapping(value="/client/search/{query}", method=RequestMethod.GET)
	@ResponseBody
	public String queryClients(@PathVariable String query, HttpServletRequest request) {
		int count = managerProfileService.countQueryClients(query);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Client> data = managerProfileService.queryClients(query.replaceAll(" ", ""), (pageInt - 1) * limitInt, limitInt);
		JsonClient jsonClient = new JsonClient(count, data);
		
		return JSONObject.fromObject(jsonClient).toString();
	}
	
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	@ResponseBody
	public String addProduct(@RequestBody Product product) {
		managerProfileService.addProduct(product);	
		return "success";
	}
	
	@RequestMapping(value="/client/add", method=RequestMethod.POST)
	@ResponseBody
	public String addClient(@RequestBody Client client) {
		managerProfileService.addClient(client);
		return "success";
	}
	
	@RequestMapping(value="/product/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateProduct(@RequestBody Product product) {
		managerProfileService.updateProduct(product);
		return "success";
	}
	
	@RequestMapping(value="/client/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateClient(@RequestBody Client client) {
		managerProfileService.updateClient(client);
		return "success";
	}
	
	@RequestMapping(value="/rate", method=RequestMethod.GET)
	@ResponseBody
	public Double queryRate() {
		return managerProfileService.queryRate();
	}
	
	@RequestMapping(value="/rate/{rate}", method=RequestMethod.GET)
	@ResponseBody
	public String updateRate(@PathVariable String rate) {
		Double rateDouble = Double.parseDouble(rate);
		managerProfileService.updateRate(rateDouble);
		return "success";
	}
	
	@RequestMapping(value="/points", method=RequestMethod.GET)
	@ResponseBody
	public String queryPoints() {
		List<Client> data = managerProfileService.queryPoints();
		JsonClient jsonClient = new JsonClient(data.size(), data);
		
		return JSONObject.fromObject(jsonClient).toString();
	}
	
	@RequestMapping(value="/points/add/{points}/{wallet}", method=RequestMethod.GET)
	@ResponseBody
	public String addPoints(@PathVariable String points, @PathVariable String wallet) {
		Integer pointsInt = Integer.parseInt(points);
		Double walletDouble = Double.parseDouble(wallet);
		managerProfileService.addPoints(pointsInt, walletDouble);
		return "success";
	}
	
	@RequestMapping(value="/points/add/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String addPoints(@PathVariable String id) {
		Integer idInt = Integer.parseInt(id);
		managerProfileService.deletePoints(idInt);
		return "success";
	}
	
}
