package com.platform.testcase.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import com.platform.testcase.vo.CaseDetailVo;
import com.platform.testcase.vo.ProductVo;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Splitter;
import com.platform.testcase.pojo.CaseDetail;
import com.platform.testcase.service.iCaseDetailService;
import com.platform.testcase.utils.BaseTypeUtils;
import com.platform.testcase.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public R caseDetail(Map<String,Object> map){
        Object id = map.get("id");
        if(id == null || StringUtils.isBlank(id.toString())){
            return R.error("请重新选择需要查看的用例");
        }
        List<CaseDetailVo> voList = iCaseDetailService.caseDetailList(map);
        if (voList.size() == 0){
            return R.error("用例已被删除或不存在");
        }
        //一次只能查看一个用例的明细，所以只需要把第一个用例的对象返回即可
        return R.ok().put("data",voList.get(0));
    }
    /**
     * 用例结果保存在结果集，不需要保存在用例
    @RequestMapping("/saveResult.do")
    @ResponseBody
    public R saveResult(String ids,int result){
        if (StringUtils.isBlank(ids)){
            return R.error("所选用例不能为空，请重新选择用例");
        }
        List<String> lists = Splitter.on(",").splitToList(ids);
        List<Long> idList = BaseTypeUtils.strToLong(lists);
        return iCaseDetailService.saveResult(idList,result);
    }
    **/

    @RequestMapping("/forbidden.do")
    @ResponseBody
    public R forbidden(String ids,int status){
        if (StringUtils.isBlank(ids) ){
            return R.error("所选用例不能为空，请选择需要禁用/启用的用例");
        }
        List<String> strList = Splitter.on(",").splitToList(ids);
        List<Long> idList = BaseTypeUtils.strToLong(strList);
        return iCaseDetailService.forbidden(idList,status);
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public R list(Map<String, Object> map){
        if (map.size() == 0){
            return R.error("前端传参错误");
        }
        Object limit = map.get("limit");
        if (null == limit || 0 == Integer.parseInt(limit.toString())) {
            return R.error("每页条数不能为空");
        }
        Query query = new Query(map);
        int total = iCaseDetailService.count(query);
        List<CaseDetailVo> voList =  iCaseDetailService.caseDetailList(query);
        PageUtils pageUtils = new PageUtils(voList,
                total);
        R r = new R().put("data",pageUtils);
        return r;
    }


}
