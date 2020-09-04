package com.platform.testcase.dao;

import com.platform.testcase.pojo.TeamMember;
import com.platform.testcase.vo.TeamMemberVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TeamMemberMapper {
    int deleteByPrimaryKey(Long teamId);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    TeamMember selectByPrimaryKey(Long teamId);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);

    int delete(List<TeamMember> members);

    int count(Map<String,Object> map);

    List<TeamMemberVo> list(Map<String,Object> map);
}