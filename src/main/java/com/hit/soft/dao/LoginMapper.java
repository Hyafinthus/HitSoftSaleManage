package com.hit.soft.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hit.soft.domain.Staff;

@Mapper
public interface LoginMapper {

	public String login(Staff staff);
	
}
