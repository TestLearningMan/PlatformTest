package com.platform.testcase.common;

import org.activiti.bpmn.model.Interface;

public class Const {
    public enum serviceType{
        FUNCTION1(6502,"FUNCTION"),
        TEAM(6506,"TEAM"),
        PRODUCT(6504,"PRODUCT"),
        List(6503,"List"),
        TEAMMEMBER(6505,"TEAMMEMBER"),
        CASEDETAIL(6501,"CASEDETAIL");
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
