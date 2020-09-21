package com.platform.testcase.dao;

import com.platform.testcase.pojo.ListDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ListDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ListDetail record);

    int insertSelective(ListDetail record);

    ListDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ListDetail record);

    int updateByPrimaryKey(ListDetail record);

    int clearTesterOfListDetail(@Param("testerId") List<Long> testerId,
                                @Param("teamId")Long teamId);

}