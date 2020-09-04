package com.platform.testcase.pojo;

import java.util.Date;

public class List {
    private Long id;

    private Long productId;

    private String listName;

    private Integer status;

    private Long chargeId;

    private Long teamId;

    private Date beginDate;

    private Date endDate;

    private Long unittestListId;

    private Long apitestListId;

    private Long uitestListId;

    private Date createTime;

    private Date modifiedTime;

    private Long creatorId;

    private Long modifierId;

    public List(Long id, Long productId, String listName, Integer status, Long chargeId, Long teamId, Date beginDate, Date endDate, Long unittestListId, Long apitestListId, Long uitestListId, Date createTime, Date modifiedTime, Long creatorId, Long modifierId) {
        this.id = id;
        this.productId = productId;
        this.listName = listName;
        this.status = status;
        this.chargeId = chargeId;
        this.teamId = teamId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.unittestListId = unittestListId;
        this.apitestListId = apitestListId;
        this.uitestListId = uitestListId;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
    }

    public List() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName == null ? null : listName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getUnittestListId() {
        return unittestListId;
    }

    public void setUnittestListId(Long unittestListId) {
        this.unittestListId = unittestListId;
    }

    public Long getApitestListId() {
        return apitestListId;
    }

    public void setApitestListId(Long apitestListId) {
        this.apitestListId = apitestListId;
    }

    public Long getUitestListId() {
        return uitestListId;
    }

    public void setUitestListId(Long uitestListId) {
        this.uitestListId = uitestListId;
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