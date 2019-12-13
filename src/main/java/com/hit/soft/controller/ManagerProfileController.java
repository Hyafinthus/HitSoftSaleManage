package com.hit.soft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
