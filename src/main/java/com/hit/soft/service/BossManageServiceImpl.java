package com.hit.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.soft.dao.BossManageMapper;
import com.hit.soft.domain.Staff;

@Service
public class BossManageServiceImpl implements BossManageService {

	@Autowired
	private BossManageMapper bossManageMapper;

	@Override
	public List<Staff> queryStaff() {
		return bossManageMapper.queryStaff();
	}
	
}
