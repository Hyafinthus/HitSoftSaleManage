package com.hit.soft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.StaffOrderMapper;

@Service
public class StaffOrderServiceImpl {

	@Autowired
	private StaffOrderMapper staffOrderMapper;
	
	
}
