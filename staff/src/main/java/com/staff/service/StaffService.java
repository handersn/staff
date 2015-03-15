package com.staff.service;

import java.util.HashMap;
import java.util.List;

import com.staff.dao.StaffDao;
import com.staff.domain.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StaffService {
	
  @Autowired 
  StaffDao staffDao;
  
  public void delete(int eno) {
    staffDao.delete(eno);
 }
  
  public void insertPhoto(int mno, MultipartFile userPhotofile) {
    staffDao.photoadd1(mno,userPhotofile);
    
  }
}














