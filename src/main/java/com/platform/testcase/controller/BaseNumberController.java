package com.platform.testcase.controller;

import com.bootdo.common.utils.R;
import com.platform.testcase.service.IDocNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/testplatform/baseNumber")
@Controller
public class BaseNumberController {
    @Autowired
    IDocNumberService iDocNumberService;

    @RequestMapping(value = "/getNumber.do",method = RequestMethod.GET)
    @ResponseBody
    public R getNumber(int code){
        String number = iDocNumberService.getNumberForAdd(code);
        if (number == ""){
            return R.error("业务类型不存在");
        }
        return R.ok().put("data",number);
    }

}
