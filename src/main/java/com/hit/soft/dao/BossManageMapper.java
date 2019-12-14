package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Staff;

@Mapper
public interface BossManageMapper {
	
	public List<Staff> queryStaff(@Param("offset") Integer offset, @Param("limit")Integer limit);

	public void addStaff(Staff staff);

	public void deleteStaff(String staffId);

	public void updateStaff(Staff staff);

	public int countStaffs();
	
}
