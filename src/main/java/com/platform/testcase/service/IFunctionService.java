package com.platform.testcase.service;

import com.bootdo.common.utils.R;
import com.platform.testcase.pojo.Function;

import java.util.List;
import java.util.Map;

public interface IFunctionService {
    public R save(Function function);
    public void forbidden(Map<String,Object> map);
    public List<Function> list(Map<String,Object> map);
}
