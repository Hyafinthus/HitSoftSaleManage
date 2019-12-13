package com.hit.soft.controller;

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
		List<ProductDepot> data = managerDepotService.queryProducts(query, (pageInt - 1) * limitInt, limitInt);
		JsonProductDepot jsonProductDepot = new JsonProductDepot(count, data);
		
		return JSONObject.fromObject(jsonProductDepot).toString();
	}
	
}
