package com.platform.testcase.dao;

import com.platform.testcase.pojo.List;

public interface ListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(List record);

    int insertSelective(List record);

    List selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(List record);

    int updateByPrimaryKey(List record);


}