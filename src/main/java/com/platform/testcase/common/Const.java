package com.platform.testcase.common;

import org.activiti.bpmn.model.Interface;

public class Const {
    public enum serviceType{
        FUNCTION1(6502,"功能"),
        TEAM(6506,"团队"),
        PRODUCT(6504,"产品"),
        List(6503,"用例集"),
        TEAMMEMBER(6505,"团队成员"),
        CASEDETAIL(6501,"测试用例");
        int code;
        String value;

        serviceType(int code, String name) {
            this.code = code;
            this.value = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return value;
        }

        public void setName(String name) {
            this.value = name;
        }
    }

}
