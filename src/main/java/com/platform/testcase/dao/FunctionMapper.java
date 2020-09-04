package com.platform.testcase.dao;

import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.pojo.Function;

import java.util.List;
import java.util.Map;

public interface FunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);

    int isExist(String functionName);

    int delete(List<Long> idList);

    int forbidden(Map<String,Object> map);

    List<Function> list(Map<String, Object> map);

    int exist(CaseDetail caseDetail);
}