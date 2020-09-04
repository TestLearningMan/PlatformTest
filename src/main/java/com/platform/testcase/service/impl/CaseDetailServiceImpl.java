package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.platform.testcase.dao.CaseDetailMapper;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.service.iCaseDetailService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseDetailServiceImpl implements iCaseDetailService {

    @Autowired
    CaseDetailMapper caseDetailMapper;

    @Override
    public R save(CaseDetail caseDetail){
        int result = 0;
        if (caseDetail.getId() == -1){
            result =caseDetailMapper.insertSelective(caseDetail);
        }else {
            result = caseDetailMapper.updateByPrimaryKeySelective(caseDetail);
        }
        return result == 0 ? R.error("用例保存失败") : R.ok("用例保存成功");
    }

    @Override
    public R verify(CaseDetail caseDetail) {
        if (caseDetail == null ){
            return R.error("请重新填写用例保存");
        }
        if (null == caseDetail.getFrontdevId() ||
                StringUtils.isBlank(caseDetail.getFrontdevId().toString())){
            return R.error("功能模块不能为空");
        }
        if (StringUtils.isBlank(caseDetail.getTitle())){
            return R.error("用例标题不能为空");
        }
        if (StringUtils.isBlank(caseDetail.getExcStep())){
            return R.error("执行步骤不能为空");
        }
        if (StringUtils.isBlank(caseDetail.getExpResults())){
            return R.error("期望结果不能为空");
        }
        List<Long> exist = caseDetailMapper.exist(caseDetail);
        if (caseDetail.getId() == -1 && exist.size() != 0){
            return R.error("请勿保存重复测试用例");
        }
        if (caseDetail.getId()!= -1 && (exist.size() !=0 &&
                exist.get(0) != caseDetail.getId())){
            return R.error("请勿保存重复测试用例");
        }
        return R.ok();
    }

    @Override
    public R delete(List<Long> idList){
        int result = caseDetailMapper.delete(idList);

        return  result == 0 ? R.ok("用例不存在或已被删除"):R.ok("用例删除成功");
    }


}
