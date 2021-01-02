package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.platform.testcase.common.Const;
import com.platform.testcase.dao.CaseDetailMapper;
import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.service.IDocNumberService;
import com.platform.testcase.service.iCaseDetailService;
import com.platform.testcase.vo.CaseDetailVo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Service
public class CaseDetailServiceImpl implements iCaseDetailService {

    @Autowired
    CaseDetailMapper caseDetailMapper;

    @Autowired
    IDocNumberService iDocNumberService;

    @Override
    public R save(CaseDetail caseDetail){
        int result = 0;
        if (caseDetail.getId() == -1){
            String no = caseDetail.getCaseNumber();
            no = iDocNumberService.updateNumber(no, Const.serviceType.CASEDETAIL.getCode());
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
        StringBuilder msg = new StringBuilder();
        msg.append("操作成功\n").append("成功删除产品").append(successNum)
                .append("个\n").append(failNum).append("个产品删除失败,")
                .append(errMsg);
        R r = R.ok();
        if (successNum >0 ){
            caseDetailMapper.batchDelete(idList);
        }else{
            r.put("code",400);
        }
        r.put("msg",msg.toString());
        return r;
    }

    @Override
    public CaseDetailVo caseDetail(Long id){
        //当前用例执行结果另外调用结果查询接口去查
        //相关人员只返回ID，前端去缓存的人员名单中查
        CaseDetailVo vo =  caseDetailMapper.getCaseDetail(id);
        return vo;
    }

    @Override
    public List<CaseDetailVo> caseList(Map<String,Object> map){
        //当前用例执行结果另外调用结果查询接口去查
        //相关人员只返回ID，前端去缓存的人员名单中查
        List<CaseDetailVo> voList =  caseDetailMapper.getCaseList(map);
        return voList;
    }

    /**
     * 测试用例不需要保存结果，结果保存在测试用例集
     * @param idList
     * @param
     * @return

    @Override
    public R saveResult(List<Long> idList,int result){
        int num = caseDetailMapper.saveResult(idList,result);
        if (num > 0){
            return R.ok("用例结果更新成功");
        }
        return R.error("用例不存在或结果被已更新");
    }*/

    @Override
    public R forbidden(List<Long> idList,int status){
        int result =  caseDetailMapper.forbidden(idList,status);
        //根据status返回不同的提示
        if (status == 0){
            if (result > 0){return R.ok("测试用例禁用成功");}
            return R.error("已禁用的测试用例不能再禁用");
        }
        if (status == 1){
            if (result > 0){return R.ok("测试用例启用成功");}
            return R.error("已启用的测试用例不能再启用");
        }
        return R.ok("操作成功");
    }

    public int count(Map<String,Object> map){
        return caseDetailMapper.count(map);
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

    public CaseDetail decode(CaseDetail caseDetail,String code) throws UnsupportedEncodingException{
        caseDetail.setExcStep(URLDecoder.decode(caseDetail.getExcStep(),code));
        caseDetail.setExpResults(URLDecoder.decode(caseDetail.getExpResults(),code));
        caseDetail.setImgPath(URLDecoder.decode(caseDetail.getImgPath(),code));
        caseDetail.setPrecondition(URLDecoder.decode(caseDetail.getPrecondition(),code));
        caseDetail.setRelateDemand(URLDecoder.decode(caseDetail.getRelateDemand(),code));
        caseDetail.setRemarks(URLDecoder.decode(caseDetail.getRemarks(),code));
        caseDetail.setTitle(URLDecoder.decode(caseDetail.getTitle(),code));
        return caseDetail;
    }


}
