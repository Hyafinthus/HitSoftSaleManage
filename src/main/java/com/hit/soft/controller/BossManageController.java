package com.hit.soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.Staff;
import com.hit.soft.service.BossManageService;

@Controller
@RequestMapping("/boss/manage")
public class BossManageController {

	@Autowired
	private BossManageService bossManageService;
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public List<Staff> queryCourses(){
		System.out.println(bossManageService.queryStaff());
		return bossManageService.queryStaff();
	}
	
}
