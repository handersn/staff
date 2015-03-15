package com.staff.dao;

import java.util.Map;

import com.staff.domain.Member;

public interface MemberDao {
  Member existUser(Map<String,String> params);
}
