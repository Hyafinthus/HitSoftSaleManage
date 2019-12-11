package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hit.soft.domain.Staff;

@Mapper
public interface BossManageMapper {
	
	public List<Staff> queryStaff();

	public void addStaff(Staff staff);

	public void deleteStaff(String staffId);

	public void updateStaff(Staff staff);
	
}
