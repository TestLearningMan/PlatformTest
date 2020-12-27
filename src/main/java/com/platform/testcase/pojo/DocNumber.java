package com.platform.testcase.pojo;

import java.util.Date;

public class DocNumber {
    Long id;
    Integer type;
    Long number;
    String prefix;
    Date modified_time;

    public DocNumber(Long id, Integer type, Long number, String prefix, Date modified_time) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.prefix = prefix;
        this.modified_time = modified_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }
}
