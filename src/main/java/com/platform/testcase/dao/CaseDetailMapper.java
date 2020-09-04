package com.platform.testcase.dao;

import com.platform.testcase.pojo.CaseDetail;

import java.util.List;

public interface CaseDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CaseDetail record);

    int insertSelective(CaseDetail record);

    CaseDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CaseDetail record);

    int updateByPrimaryKey(CaseDetail record);

    List<Long> exist(CaseDetail caseDetail);

    int delete(List<Long> idList);
}