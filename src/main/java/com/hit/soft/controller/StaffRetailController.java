package com.hit.soft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hit.soft.service.StaffRetailService;

@Controller
@RequestMapping("/staff/retail")
public class StaffRetailController {

	@Autowired
	private StaffRetailService staffRetailService;
	
	
}
