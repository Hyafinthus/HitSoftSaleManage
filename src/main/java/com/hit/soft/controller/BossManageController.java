package com.hit.soft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.JsonClient;
import com.hit.soft.domain.JsonStaff;
import com.hit.soft.domain.Staff;
import com.hit.soft.service.BossManageService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/boss/manage")
public class BossManageController {

	@Autowired
	private BossManageService bossManageService;
	
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	@ResponseBody
	public String queryAllStaffs(HttpServletRequest request){
		int count = bossManageService.countStaffs();
		int pageInt = Integer.parseInt(request.getParameter("page"));
		int limitInt = Integer.parseInt(request.getParameter("limit"));
		List<Staff> data = bossManageService.queryStaff((pageInt - 1) * limitInt, limitInt);
		JsonStaff jsonStaff = new JsonStaff(count, data);
		return JSONObject.fromObject(jsonStaff).toString();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String addStaffs(@RequestBody Staff staff){
		bossManageService.addStaff(staff);
		System.out.println(staff);
		return "success";
	}
	
	@RequestMapping(value="/delete/{staff_id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteStaffs(@PathVariable String staff_id){
		bossManageService.deleteStaff(staff_id);
		return "success";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String updateStaffs(@RequestBody Staff staff){
		bossManageService.updateStaff(staff);
		return "success";
	}
	
}
