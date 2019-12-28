package com.hit.soft.service;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.Staff;

public interface LoginService {

	public String login(Staff staff);
	
	public Client loginClient(Integer client_id, String pass);
	
}
