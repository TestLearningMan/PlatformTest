package com.platform.testcase.pojo;

import java.util.Date;

public class Team {
    private Long id;

    private String teamName;

    private Boolean status;

    private Date createTime;

    private Date modifiedTime;

    private Long creatorId;

    private Long modifierId;

    public Team(Long id, String teamName, Boolean status, Date createTime, Date modifiedTime, Long creatorId, Long modifierId) {
        this.id = id;
        this.teamName = teamName;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
    }

    public Team() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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