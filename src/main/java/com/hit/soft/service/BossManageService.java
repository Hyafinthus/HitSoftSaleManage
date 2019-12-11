package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Staff;

public interface BossManageService {
	
	public List<Staff> queryStaff();

	public void addStaff(Staff staff);

	public void deleteStaff(String staffId);

	public void updateStaff(Staff staff);
	
}
