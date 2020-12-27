package com.platform.testcase.service;

import com.bootdo.common.utils.R;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.vo.CaseDetailVo;

import java.util.List;
import java.util.Map;

public interface iCaseDetailService {

    public R verify(CaseDetail caseDetail);
    public R save(CaseDetail caseDetail);
    public R batchDelete(List<Long> idList);
    public CaseDetailVo caseDetail(Long id);
    public List<CaseDetailVo> caseList(Map<String,Object> map);
    //public R saveResult(List<Long> idList,int result);
    public R forbidden(List<Long> idList,int status);
    public int count(Map<String,Object> map);
}
