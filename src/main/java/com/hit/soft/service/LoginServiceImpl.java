package com.hit.soft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.LoginMapper;
import com.hit.soft.domain.Staff;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public String login(Staff staff) {
		return loginMapper.login(staff);
	}
	
}
