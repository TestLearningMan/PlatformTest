package com.platform.testcase.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseTypeUtils {

    public static List<Long> strToLong (List<String> list){
         return list
                 .stream().map(x -> {
             return Long.valueOf(x);
         }
             ).collect(Collectors.toList());
        //List<Long> longList = new ArrayList<Long>();
        //for (int i=0;i<list.size();i++){
        //    longList.add(Long.valueOf(list.get(i)));
        //}
        //return longList;
    }
}
