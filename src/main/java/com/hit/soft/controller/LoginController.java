package com.hit.soft.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Staff;
import com.hit.soft.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody Staff staff, HttpServletRequest request) {
		String role = loginService.login(staff);
		if(role != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", staff.getStaff_name());
			session.setAttribute("role", role);
		}
		System.err.println("登陆: " + staff.getStaff_name());
		return role;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		System.err.println("登出");
		response.sendRedirect("/sale/login.html");
	}
	
	@RequestMapping(value="/login/client/{id}/{pass}", method=RequestMethod.GET)
	@ResponseBody
	public Client login(@PathVariable String id, @PathVariable String pass, HttpServletRequest request) {
		Client client = loginService.loginClient(Integer.parseInt(id), pass);
		System.err.println("登陆: " + client.getClient_name());
		return client;
	}
	
}
