package com.platform.testcase.dao;

import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.pojo.Function;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(@Param("record") Function record);

    int insertSelective(@Param("record") Function record);

    Function selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(@Param("record") Function record);

    int updateByPrimaryKey(@Param("record") Function record);

    int isExist(String functionName);

    int forbidden(@Param("map") Map<String,Object> map);

    List<Function> list(@Param("map") Map<String, Object> map);

    int exist(@Param("caseDetail") CaseDetail caseDetail);

    List<AssociateResult> checkAssociated(@Param("id") Long id);

}