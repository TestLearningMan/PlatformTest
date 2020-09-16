package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.platform.testcase.dao.FunctionMapper;
import com.platform.testcase.pojo.Function;
import com.platform.testcase.service.IFunctionService;
import com.platform.testcase.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class FunctionServiceImpl implements IFunctionService {

    @Autowired
    FunctionMapper functionMapper;

    public R save(Function function){
        if (functionMapper.isExist(function.getFunctionName()) !=0){
            return R.error("功能名称重复");
        }
        int result =0;
        if (function.getId() == -1){
            //无id时，则为新增
            function.setId(IdGenerator.getId());
            result = functionMapper.insertSelective(function);
        }else {
            result = functionMapper.updateByPrimaryKeySelective(function);
        }
        if (result > 0){
            return R.ok("功能保存成功");
        }
        return R.error("功能保存失败");
    }

    public void forbidden(Map<String,Object> map){
        functionMapper.forbidden(map);
    }
    public List<Function> list(Map<String,Object> map){
        List<Function> lists= functionMapper.list(map);
        return lists;
    }





}
