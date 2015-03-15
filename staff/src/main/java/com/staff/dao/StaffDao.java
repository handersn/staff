package com.staff.dao;

import java.util.List;

import com.staff.domain.Staff;

public interface StaffDao {
  List<?> selectAllStaffs();

  Staff selectStaffByEno(int eno);
  List<?> selectStaffsByName(String name);
  List<?> selectStaffsByPosition(String position);
  List<?> selectStaffsByEmail(String email);
  List<?> selectStaffsByPhone(int phone);
  
  void insert(Staff staff);
  
  void update(Staff staff);
  
  void delete(int eno);
}
