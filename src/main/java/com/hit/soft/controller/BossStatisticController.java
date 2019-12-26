package com.hit.soft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.JsonProduct;
import com.hit.soft.domain.Product;
import com.hit.soft.service.BossStatisticService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/boss/statistic")
public class BossStatisticController {

	@Autowired
	private BossStatisticService bossStatisticService;
	
	@RequestMapping(value="/market/{start_time}/{end_time}", method=RequestMethod.GET)
	@ResponseBody
	public String marketStatistic(@PathVariable String start_time, @PathVariable String end_time, HttpServletRequest request) {
		start_time += " 00:00:00";
		end_time += " 00:00:00";
		
		List<Product> purchaseProducts = bossStatisticService.queryInDepot(start_time, end_time);
		List<Product> marketProducts = bossStatisticService.queryMarketOrder(start_time, end_time);
		Map<Integer, Product> allProducts = new HashMap<>();
		for(Product product : purchaseProducts) {
			allProducts.put(product.getProduct_id(), product);
		}
		for(Product product : marketProducts) {
			if(allProducts.keySet().contains(product.getProduct_id())) {
				allProducts.get(product.getProduct_id()).setOrder_id(product.getOrder_id());
			} else {
				allProducts.put(product.getProduct_id(), product);
			}
		}
		
		List<Product> data = new ArrayList<>(allProducts.values());
		int count = data.size();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		JsonProduct jsonProduct = new JsonProduct(count, data.subList(pageInt, limitInt));
		
		return JSONObject.fromObject(jsonProduct).toString();
	}
	
}
