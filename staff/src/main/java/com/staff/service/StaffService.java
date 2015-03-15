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
  
  public Staff selectStaffByEno(int eno) {
	  return staffDao.selectStaffByEno(eno);
  }
  
  public List<?> selectStaffsByName(String name) {
	  return staffDao.selectStaffsByName(name);
  }
  
  public List<?> selectStaffsByPosition(String position) {
	  return staffDao.selectStaffsByPosition(position);
  }
  
  public List<?> selectStaffsByEmail(String email) {
	  return staffDao.selectStaffsByEmail(email);
  }
  
  public List<?> selectStaffsByPhone(int phone) {
	  return staffDao.selectStaffsByPhone(phone);
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
}














