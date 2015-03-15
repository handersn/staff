package com.staff.dao;

import java.util.List;

import com.staff.domain.Staff;

public interface StaffDao {
  List<?> selectAllStaffs();
  
  Staff selectOne(int eno);
  
  void insert(Staff staff);
  
  void update(Staff staff);
  
  void delete(int eno);
  
  int totalSize();
}
