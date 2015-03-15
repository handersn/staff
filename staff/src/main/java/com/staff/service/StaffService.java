package com.staff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.staff.dao.StaffDao;
import com.staff.domain.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
	
  @Autowired 
  StaffDao staffDao;
  
  public List<?> selectAllStaffs() {
	  return staffDao.selectAllStaffs();
  }
  
  public void insert(Staff staff) {
	staffDao.insert(staff);
  }
  
  public void delete(int eno) {
    staffDao.delete(eno);
 }
  
  public void update(Staff staff) {
	staffDao.update(staff);
  }
  
  public List<?> findStaffsByEno() {
  	Map<String, Object> params = new HashMap<>();
  }
}














