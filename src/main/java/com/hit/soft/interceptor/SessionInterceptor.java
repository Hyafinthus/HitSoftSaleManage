package com.hit.soft.interceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {

	private static List<String> boss = Arrays.asList(
			"/boss/manage", "/boss/statistic", "/logout",
			
			"/sk_index.html", "/sk_member_add.html", "/sk_member_edit.html", "/sk_member_list.html",
			
			"/boss_market.html", "/boss_profit.html", "/boss_statistics.html");
	
	private static List<String> manager = Arrays.asList(
			"/manager/order", "/manager/profile", "/manager/depot", "/logout",
			
			"/manager-index.html", "/new_file.html", "/wallet-add.html", "/wallet-list.html",
			"/client-add.html", "/client-list.html", "/product-add.html", "/product-list.html",
			
			"/depot-handle.html", "/depot-input.html", "/depot-inventory.html",
			"/depot-output.html", "/depot-statics.html", "/depot-transfer.html",
			
			"/order-approve.html", "/order-deliver.html", "/order-detailapprove.html",
			"/order-detaildeliver.html", "/order-detailhistory.html", "/order-history.html");
	
	private static List<String> staff = Arrays.asList(
			"/staff/order", "/staff/retail", "/logout",
			
			"/sf_index.html", "/sf_paid_order_list.html",
			"/sf_order_add.html", "/sf_order_list.html", "/sf_order_modify.html",
			"/sf_order_modify1.html", "/sf_order_rejected_list.html", "/sf_order_retail.html");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		System.out.println("进入PreHandle: " + request.getRequestURI());
		String path = request.getServletPath();
		if(path.contains("session")) {
			path = path.split(";")[0];
		}
		
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		if(role == null || role.equals("")) {
			System.err.println("拦截: 未登录");
			response.sendRedirect("/sale/login.html");
			return false;
		}
		
		switch(role) {
			case "boss":
				if(check(boss, path)) {
					return true;
				} else {
					System.err.println("拦截: boss越权");
					response.sendRedirect("/sale/sk_index.html");
					return false;
				}
			case "manager":
				if(check(manager, path)) {
					return true;
				} else {
					System.err.println("拦截: manager越权");
					response.sendRedirect("/sale/manager-index.html");
					return false;
				}
			case "staff":
				if(check(staff, path)) {
					return true;
				} else {
					System.err.println("拦截: staff越权");
					response.sendRedirect("/sale/sf_index.html");
					return false;
				}
			default:
				return false;
		}
	}

	private Boolean check(List<String> valid, String path) {
		for(String v : valid) {
			if(path.startsWith(v)) {
				return true;
			}
		}
		return false;
	}
}
