package com.platform.testcase.utils;

public  class IdGenerator {

    public static long getId (){
        return (long)((Math.random())*Math.pow(10, 8+Math.random()*10));
    }
}
