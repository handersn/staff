package com.staff.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.dao.MemberDao;
import com.staff.domain.Member;

@Service
public class MemberService {
  @Autowired MemberDao memberDao;
  
  public Member validate(String userId, String password) {
    HashMap<String,String> params = new HashMap<>();
    params.put("userId", userId);
    params.put("password", password);
    return memberDao.existUser(params);
  }

}














