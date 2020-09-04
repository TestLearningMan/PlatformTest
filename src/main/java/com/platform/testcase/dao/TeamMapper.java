package com.platform.testcase.dao;

import com.platform.testcase.pojo.Team;
import com.platform.testcase.vo.TeamVo;

import java.util.List;
import java.util.Map;

public interface TeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    int isExist(String teamName);

    int delete(List idList);

    int count(Map<String,Object> map);

    List<TeamVo> list(Map<String,Object> map);

    int disable(List<Long> lists);

    int enable(List<Long> lists);


}