package com.platform.testcase.pojo;

import java.util.Date;

public class ListDetail {
    private Long id;

    private Long listId;

    private Long caseId;

    private Integer result;

    private String resultDesc;

    private Long testerId;

    private String linkBug;

    private Date createTime;

    private Date modifiedTime;

    private Long creatorId;

    private Long modifierId;

    public ListDetail(Long id, Long listId, Long caseId, Integer result, String resultDesc, Long testerId, String linkBug, Date createTime, Date modifiedTime, Long creatorId, Long modifierId) {
        this.id = id;
        this.listId = listId;
        this.caseId = caseId;
        this.result = result;
        this.resultDesc = resultDesc;
        this.testerId = testerId;
        this.linkBug = linkBug;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
    }

    public ListDetail() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc == null ? null : resultDesc.trim();
    }

    public Long getTesterId() {
        return testerId;
    }

    public void setTesterId(Long testerId) {
        this.testerId = testerId;
    }

    public String getLinkBug() {
        return linkBug;
    }

    public void setLinkBug(String linkBug) {
        this.linkBug = linkBug == null ? null : linkBug.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }
}