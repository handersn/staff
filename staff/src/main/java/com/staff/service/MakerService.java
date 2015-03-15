package com.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.dao.MakerDao;
import com.staff.domain.Maker;

@Service
public class MakerService {
  @Autowired MakerDao makerDao;
  
  public List<Maker> getList() {
    return makerDao.selectNameList(); 
  }
}







