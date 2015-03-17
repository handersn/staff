package com.staffmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffmanager.dao.StaffDao;
import com.staffmanager.domain.Staff;

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
  
	  public void add(Staff staff) {
	  	staffDao.insert(staff);
	  	
	  }
}














