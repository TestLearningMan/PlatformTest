package com.platform.testcase.vo;

public class TeamMemberVo {
    Long teamId;
    Long testerId;
    String testerName;
    int isLeader;
    String teamName;
    int teamStatus;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(int teamStatus) {
        this.teamStatus = teamStatus;
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

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public int getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(int isLeader) {
        this.isLeader = isLeader;
    }
}
