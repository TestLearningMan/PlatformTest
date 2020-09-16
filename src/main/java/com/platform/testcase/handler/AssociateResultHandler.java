package com.platform.testcase.handler;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.Map;


public class AssociateResultHandler implements ResultHandler {
    private Map<Long,String> result = null;
    @Override
    public void handleResult(ResultContext resultContext) {
        Map<String,Object> map = (Map)resultContext.getResultObject();
        result.put(Long.valueOf(map.get("id").toString()),
                map.get("type").toString());
    }

    public Map<Long,String> getResult(){
        return result;
    }

    public static AssociateResultHandler getHandler(){
        return new AssociateResultHandler();
    }
}
