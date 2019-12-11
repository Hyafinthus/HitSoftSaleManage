package com.hit.soft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hit.soft.service.StaffOrderService;

@Controller
@RequestMapping("/staff/order")
public class StaffOrderController {

	@Autowired
	private StaffOrderService staffOrderService;
	
	
}
