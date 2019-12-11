package com.hit.soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	@ResponseBody
	public List<Staff> queryAllStaffs(){
		List<Staff> staffs = bossManageService.queryStaff();
		//System.out.println(staffs);
		return staffs;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String addStaffs(@RequestBody Staff staff){
		bossManageService.addStaff(staff);
		System.out.println(staff);
		return "success";
	}
	
	@RequestMapping(value="/delete/{staffId}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteStaffs(@PathVariable String staffId){
		bossManageService.deleteStaff(staffId);
		return "success";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateStaffs(@RequestBody Staff staff){
		/*Staff staff1=new Staff();
		staff1.setStaff_id(4);
		staff1.setStaff_name("pipixia");
		staff1.setRole("manager");
		staff1.setPass("t123456");*/
		bossManageService.updateStaff(staff);
		return "success";
	}
	
}
