package com.staff.dao;

import java.util.List;

import com.staff.domain.Maker;

public interface MakerDao {
  List<Maker> selectNameList();
}
