package com.platform.testcase.controller;

import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import com.google.common.base.Splitter;
import com.platform.testcase.pojo.Function;
import com.platform.testcase.service.impl.FunctionServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/testplatform/function")
public class FunctionController {
    @Autowired
    FunctionServiceImpl functionService;

    /**
     *
     * @param function
     * @return add result
     */
    @RequestMapping("/save.do")
    @ResponseBody
    public R save(Function function){
        if (StringUtils.isBlank(function.getFunctionName()) ){
            return R.error("功能名称不能为空");
        }
        function.setModifierId(ShiroUtils.getUserId());
        function.setCreatorId(ShiroUtils.getUserId());
        return functionService.save(function);
    }

    @RequestMapping("/forbidden.do")
    @ResponseBody
    public R forbidden(Map<String,Object> map){
        if (null == map.get("ids") || StringUtils.isBlank(map.get("ids").toString())){
            return R.error("请选择需要禁用/启用的功能");
        }
        return R.ok();
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public R list(Map<String,Object> map){
        List<Function> lists = functionService.list(map);
        R r = new R();
        r.put("data",lists);
        return r;
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public R  delete(Long id){
        if (id == null){
            return R.error("请选择需要删除的功能");
        }
        return functionService.delete(id);
    }



}