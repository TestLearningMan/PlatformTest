package com.platform.testcase.controller;

import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Splitter;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.service.iCaseDetailService;
import com.platform.testcase.utils.BaseTypeUtils;
import com.platform.testcase.utils.IdGenerator;
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

    @RequestMapping("/delete.do")
    @ResponseBody
    public R delete(String ids){
        if (StringUtils.isBlank(ids)){
            return R.error("请选择需要删除的测试用例");
        }
        List<Long> idList = BaseTypeUtils.strToLong(Splitter.on(",").splitToList(ids));
        return  iCaseDetailService.batchDelete(idList);
    }

    @RequestMapping("/caseDetail.do")
    @ResponseBody
    public R caseDetail(String id){
        if(StringUtils.isBlank(id)){
            return R.error("请重新选择需要查看的用例");
        }
        return iCaseDetailService.caseDetail(Long.valueOf(id));


    }



}
