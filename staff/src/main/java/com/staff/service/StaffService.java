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
  
  public void insert(Staff staff) {
	staffDao.insert(staff);
  }
  
  public void delete(int eno) {
    staffDao.delete(eno);
 }
  
  public void update(Staff staff) {
	staffDao.update(staff);
  }
  
  public List<?> selectAllStaffs() {
	return staffDao.selectAllStaffs();
  }
  
  public List<?> findStaffs(int eno, String email, int phone, String name, String position) {
  	Map<String, Object> params = new HashMap<>();
  	
    params.put("eno", eno);
    params.put("email", email);
    params.put("phone", phone);
    params.put("name", name);
    params.put("position", position);
    
    return staffDao.findStaffs(params);
  }
}














