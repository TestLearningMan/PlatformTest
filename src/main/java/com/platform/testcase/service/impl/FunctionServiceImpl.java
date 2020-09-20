package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.platform.testcase.dao.FunctionMapper;
import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.Function;
import com.platform.testcase.service.IFunctionService;
import com.platform.testcase.utils.IdGenerator;
import org.apache.commons.lang3.StringUtils;
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
    public R delete(Long id){
        String errMsg = checkAssociation(id);
        if (StringUtils.isBlank(errMsg)){
            functionMapper.deleteByPrimaryKey(id);
            return R.ok("功能删除成功");
        }
        return R.error(errMsg);
    }


    private String checkAssociation(Long id){
        List<AssociateResult> resultList= functionMapper.checkAssociated(id);
        StringBuilder errMsg=new StringBuilder();
        for(AssociateResult result : resultList) {
            switch (result.getType()){
                case "6501":
                    if (result.getId() > 0){
                        errMsg.append("该功能已关联测试用例，不允许删除\n");
                    }
                    break;
                case "6504":
                    if (result.getId() > 1){
                        errMsg.append("该功能有子功能，不允许删除\n");
                    }
                    break;
                default:
                    errMsg.append(result.getName()).append("已关联其他业务，删除失败;\n");
            }
        }
        return errMsg.toString();
    }





}
