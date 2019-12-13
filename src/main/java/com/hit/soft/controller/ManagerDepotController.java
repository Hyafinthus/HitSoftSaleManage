package com.hit.soft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.JsonProductDepot;
import com.hit.soft.domain.ProductDepot;
import com.hit.soft.service.ManagerDepotService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manager/depot")
public class ManagerDepotController {

	@Autowired
	private ManagerDepotService managerDepotService;
	
	@RequestMapping(value="/search/{query}", method=RequestMethod.GET)
	@ResponseBody
	public String queryProducts(@PathVariable String query, HttpServletRequest request) {
		int count = managerDepotService.countQueryProducts(query);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<ProductDepot> data = managerDepotService.queryProducts(query.replaceAll(" ", ""), (pageInt - 1) * limitInt, limitInt);
		JsonProductDepot jsonProductDepot = new JsonProductDepot(count, data);
		
		return JSONObject.fromObject(jsonProductDepot).toString();
	}
	
	@RequestMapping(value="/turnover/{depot_name}/{product_id}/{number}", method=RequestMethod.GET)
	@ResponseBody
	public String turnoverDepot(@PathVariable String depot_name, @PathVariable String product_id, @PathVariable String number) throws NumberFormatException, UnsupportedEncodingException {
		managerDepotService.turnoverDepot(depot_name, Integer.parseInt(product_id), Integer.parseInt(number));		
		System.out.print(depot_name);
		return "success";
	}
	
	@RequestMapping(value="/transfer/{depot_name}/{product_id}/{number}", method=RequestMethod.GET)
	@ResponseBody
	public String transferDepot(@PathVariable String depot_name, @PathVariable String product_id, @PathVariable String number) {
		String oldDepot = depot_name;
		String newDepot = "";
		if(oldDepot.equals("仓库")) {
			newDepot = "门店";
		} else {
			newDepot = "仓库";
		}
		managerDepotService.transferDepot(oldDepot, newDepot, Integer.parseInt(product_id), Integer.parseInt(number));
		return "success";
	}
	
	@RequestMapping(value="/inventory/{depot_name}", method=RequestMethod.GET)
	@ResponseBody
	public String queryDepot(@PathVariable String depot_name, HttpServletRequest request) {
		int count = managerDepotService.countQueryDepot(depot_name);
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<ProductDepot> data = managerDepotService.queryDepot(depot_name, (pageInt - 1) * limitInt, limitInt);
		JsonProductDepot jsonProductDepot = new JsonProductDepot(count, data);
		
		return JSONObject.fromObject(jsonProductDepot).toString();
	}
	
	@RequestMapping(value="/inventory/confirm/{depot_name}/{product_id}/{number}", method=RequestMethod.GET)
	@ResponseBody
	public String confirmDepot(@PathVariable String depot_name, @PathVariable String product_id, @PathVariable String number) {
		managerDepotService.confirmDepot(depot_name, Integer.parseInt(product_id), Integer.parseInt(number));
		return "success";
	}
	
}
