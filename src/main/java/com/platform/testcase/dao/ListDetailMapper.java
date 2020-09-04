package com.platform.testcase.dao;

import com.platform.testcase.pojo.ListDetail;

public interface ListDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ListDetail record);

    int insertSelective(ListDetail record);

    ListDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ListDetail record);

    int updateByPrimaryKey(ListDetail record);
}