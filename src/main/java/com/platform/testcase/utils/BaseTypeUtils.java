package com.platform.testcase.utils;

import java.util.ArrayList;
import java.util.List;

public class BaseTypeUtils {

    public static List<Long> strToLong (List<String> list){
        List<Long> longList = new ArrayList<Long>();
        for (int i=0;i<list.size();i++){
            longList.add(Long.valueOf(list.get(i)));
        }
        return longList;
    }
}
