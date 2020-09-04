package com.platform.testcase.controller;

import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import com.google.common.base.Splitter;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.service.IFunctionService;
import com.platform.testcase.service.iCaseDetailService;
import com.platform.testcase.utils.BaseTypeUtils;
import com.platform.testcase.utils.IdGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/testplatform/caseDetail")
public class CaseDetailController {

    @Autowired
    iCaseDetailService iCaseDetailService;

    @RequestMapping("/save")
    @ResponseBody
    public R sava(CaseDetail caseDetail){
        R verify = iCaseDetailService.verify(caseDetail);
        if ((int)verify.get("code") != 0){
            return verify;
        }
        if (caseDetail.getId() == -1){
            caseDetail.setCreatorId(ShiroUtils.getUserId());
            caseDetail.setId(IdGenerator.getId());
        }
        caseDetail.setModifierId(ShiroUtils.getUserId());
        return iCaseDetailService.save(caseDetail);
    }

    public R delete(String ids){
        if (StringUtils.isBlank(ids)){
            return R.error("请选择需要删除的测试用例");
        }
        List<Long> idList = BaseTypeUtils.strToLong(Splitter.on(",").splitToList(ids));
    return  null;
    }



}
