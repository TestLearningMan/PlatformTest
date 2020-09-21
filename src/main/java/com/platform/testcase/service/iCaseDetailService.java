package com.platform.testcase.service;

import com.bootdo.common.utils.R;
import com.platform.testcase.pojo.CaseDetail;

import java.util.List;

public interface iCaseDetailService {

    public R verify(CaseDetail caseDetail);
    public R save(CaseDetail caseDetail);
    public R batchDelete(List<Long> idList);
}
