package com.platform.testcase.dao;

import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.vo.CaseDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(@Param("record") CaseDetail record);

    int insertSelective(@Param("record") CaseDetail record);

    CaseDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(@Param("record") CaseDetail record);

    int updateByPrimaryKey(@Param("record") CaseDetail record);

    List<Long> exist(@Param("record") CaseDetail caseDetail);

    int batchDelete(@Param("idList") List<Long> idList);

    List<AssociateResult> checkAssociated(@Param("idList") List<Long> idList );

    CaseDetailVo getCaseDetail(@Param("id") Long id);
}