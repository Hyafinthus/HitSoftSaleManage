package com.hit.soft.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Staff;

@Mapper
public interface LoginMapper {

	public String login(Staff staff);
	
	public Client loginClient(@Param("client_id") Integer client_id, @Param("pass") String pass);
	
}
