package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.platform.testcase.dao.CaseDetailMapper;
import com.platform.testcase.pojo.AssociateResult;
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
    public R batchDelete(List<Long> idList){
        int totalNum = idList.size();
        String errMsg = checkAssociation(idList);
        int successNum = idList.size();
        int failNum = totalNum - successNum;
        if (successNum > 0){
            caseDetailMapper.batchDelete(idList);
        }
        StringBuilder msg = new StringBuilder();
        msg.append("操作成功\n").append("成功删除产品").append(successNum)
                .append("个\n").append(failNum).append("个产品删除失败,")
                .append(errMsg);
        if (successNum > 0){
            caseDetailMapper.batchDelete(idList);
        }
        return R.ok(msg.toString());
    }

    private String checkAssociation(List<Long> idList){
        List<AssociateResult> resultList= caseDetailMapper.checkAssociated(idList);
        if (resultList == null || resultList.size() == 0){
            return "";
        }
        StringBuilder errMsg=new StringBuilder();
        errMsg.append("失败原因如下:\n");
        for(AssociateResult result : resultList) {
            Long id = result.getId();
            idList.remove(id);
            switch (result.getType()){
                case "6501":
                    errMsg.append(result.getName()).append("已关联测试结果，删除失败;\n");
                    break;
                default:
                    errMsg.append(result.getName()).append("已关联其他业务，删除失败;\n");
            }
        }

        return errMsg.toString();
    }

}
