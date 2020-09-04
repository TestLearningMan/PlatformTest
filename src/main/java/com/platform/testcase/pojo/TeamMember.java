package com.platform.testcase.pojo;

import java.util.Date;

public class TeamMember {
    private Long teamId;

    private Long testerId;

    private Boolean isleader;

    private Date createTime;

    private Date modifiedTime;

    private Long creatorId;

    private Long modifierId;

    public TeamMember(Long teamId, Long testerId, Boolean isleader, Date createTime, Date modifiedTime, Long creatorId, Long modifierId) {
        this.teamId = teamId;
        this.testerId = testerId;
        this.isleader = isleader;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
    }

    public TeamMember() {
        super();
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTesterId() {
        return testerId;
    }

    public void setTesterId(Long testerId) {
        this.testerId = testerId;
    }

    public Boolean getIsleader() {
        return isleader;
    }

    public void setIsleader(Boolean isleader) {
        this.isleader = isleader;
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