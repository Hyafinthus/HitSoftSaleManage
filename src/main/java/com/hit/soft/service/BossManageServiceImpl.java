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
	public int countStaffs() {
		return bossManageMapper.countStaffs();
	}
	
	@Override
	public List<Staff> queryStaff(int offset, int limit) {
		return bossManageMapper.queryStaff(offset, limit);
	}

	@Override
	public void addStaff(Staff staff) {
		bossManageMapper.addStaff(staff);
	}

	@Override
	public void deleteStaff(String staffId) {
		bossManageMapper.deleteStaff(staffId);
	}

	@Override
	public void updateStaff(Staff staff) {
		if(staff.getPass().equals("")){
			bossManageMapper.updatePosition(staff);
		}else{
			bossManageMapper.updateStaff(staff);
		}
		
	}
	
}
