package com.platform.testcase.pojo;

import java.util.Date;

public class DocNumber {
    Long id;
    Integer docCode;
    String docType;
    Long docNumber;
    String docPrefix;
    Date modified_time;

    public DocNumber(Long id, Integer docCode, String docType, Long docNumber, String docPrefix, Date modified_time) {
        this.id = id;
        this.docCode = docCode;
        this.docType = docType;
        this.docNumber = docNumber;
        this.docPrefix = docPrefix;
        this.modified_time = modified_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDocCode() {
        return docCode;
    }

    public void setDocCode(Integer docCode) {
        this.docCode = docCode;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocPrefix() {
        return docPrefix;
    }

    public void setDocPrefix(String docPrefix) {
        this.docPrefix = docPrefix;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }
}