package com.platform.testcase.dao;

import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.CaseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CaseDetail record);

    int insertSelective(CaseDetail record);

    CaseDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CaseDetail record);

    int updateByPrimaryKey(CaseDetail record);

    List<Long> exist(CaseDetail caseDetail);

    int batchDelete(List<Long> idList);

    List<AssociateResult> checkAssociated(@Param("idList") List<Long> idList );
}