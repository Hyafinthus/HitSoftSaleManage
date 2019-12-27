package com.hit.soft.controller;

import java.text.ParseException;
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

import com.hit.soft.domain.JsonOrder;
import com.hit.soft.domain.JsonProduct;
import com.hit.soft.domain.Order;
import com.hit.soft.domain.Product;
import com.hit.soft.service.BossStatisticService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/boss/statistic")
public class BossStatisticController {

	@Autowired
	private BossStatisticService bossStatisticService;
	
	// 货品 进货量: 进货表 | 销售量: 销售单表
	@RequestMapping(value="/market/{start_time}/{end_time}", method=RequestMethod.GET)
	@ResponseBody
	public String marketStatistic(@PathVariable String start_time, @PathVariable String end_time, HttpServletRequest request) {
		start_time += " 00:00:00";
		end_time += " 23:59:59";
		
		List<Product> purchaseProducts = bossStatisticService.queryInDepot(start_time, end_time);
		List<Product> tradeProducts = bossStatisticService.queryTradeProduct(start_time, end_time);
		Map<Integer, Product> allProducts = new HashMap<>();
		for(Product product : purchaseProducts) { 
			allProducts.put(product.getProduct_id(), product);
		}
		for(Product product : tradeProducts) {
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
		int start = (pageInt - 1) * limitInt;
		int end = start + limitInt;
		if(end > count) {
			end = count;
		}
		JsonProduct jsonProduct = new JsonProduct(count, data.subList(start, end));
		
		return JSONObject.fromObject(jsonProduct).toString();
	}
	
	// 客户 下单数 | 销售额 | 盈利额: 销售单表
	@RequestMapping(value="/profit/{start_time}/{end_time}", method=RequestMethod.GET)
	@ResponseBody
	public String profitStatistic(@PathVariable String start_time, @PathVariable String end_time, HttpServletRequest request) {
		start_time += " 00:00:00";
		end_time += " 23:59:59";
		
		List<Order> data = bossStatisticService.queryTradeOrder(start_time, end_time);
		int count = data.size();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		int start = (pageInt - 1) * limitInt;
		int end = start + limitInt;
		if(end > count) {
			end = count;
		}
		JsonOrder jsonOrder = new JsonOrder(count, data.subList(start, end));
		
		return JSONObject.fromObject(jsonOrder).toString();
	}
	
	// 总进货额: 进货表
	// 总销售额 总盈利额: 销售单表
	@RequestMapping(value="/price/{start_time}/{end_time}", method=RequestMethod.GET)
	@ResponseBody
	public String priceStatistic(@PathVariable String start_time, @PathVariable String end_time) {
		start_time += " 00:00:00";
		end_time += " 23:59:59";
		
		Double pricePurchase = 0.0, priceTrade = 0.0, priceProfit = 0.0;
		List<Product> purchaseProducts = bossStatisticService.queryInDepot(start_time, end_time);
		for(Product product : purchaseProducts) {
			pricePurchase += product.getPurchase_price() * product.getCount();
		}
		
		List<Order> tradeOrder = bossStatisticService.queryTradeOrder(start_time, end_time);
		for(Order order : tradeOrder) {
			priceTrade += order.getOrder_sale_price();
			priceProfit += order.getOrder_profit();
		}
		
		return "{\"purchase\":" + String.valueOf(pricePurchase) +
				", \"trade\":" + String.valueOf(priceTrade) + 
				", \"profit\":" + String.valueOf(priceProfit) + "}";
	}
	
	@RequestMapping(value="/chart/{start_time}/{end_time}/{type}", method=RequestMethod.GET)
	@ResponseBody
	public String chartStatistic(@PathVariable String start_time, @PathVariable String end_time, @PathVariable String type) throws ParseException {	
		List<String> date = new ArrayList<>();
		List<Double> pricePurchase = new ArrayList<>(), priceTrade = new ArrayList<>(), priceProfit = new ArrayList<>();
		
		List<Product> purchaseDay = bossStatisticService.pricePurchaseDay(start_time + " 00:00:00", end_time + " 23:59:59", start_time, end_time);
		for(Product product : purchaseDay) {
			date.add(product.getProduct_name());
			pricePurchase.add(product.getPurchase_price());
		}
		
		List<Order> purchaseTradeProfit = bossStatisticService.priceTradeProfitDay(start_time + " 00:00:00", end_time + " 23:59:59", start_time, end_time);
		for(Order order : purchaseTradeProfit) {
			priceTrade.add(order.getOrder_sale_price());
			priceProfit.add(order.getOrder_profit());
		}
		
		return "{\"dates\": " + date.toString() + ", " + 
				"\"purchase\": " + pricePurchase.toString() + ", " +
				"\"sale\": " + priceTrade.toString() + ", " +
				"\"profit\": " + priceProfit.toString() + "}";
	}
	
}
