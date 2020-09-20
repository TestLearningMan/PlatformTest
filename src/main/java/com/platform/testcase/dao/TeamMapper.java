package com.platform.testcase.dao;

import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.Team;
import com.platform.testcase.vo.TeamVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(@Param("record") Team record);

    int insertSelective(@Param("record") Team record);

    Team selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(@Param("record") Team record);

    int updateByPrimaryKey(@Param("record") Team record);

    int isExist(String teamName);

    int batchDelete(@Param("idList") List idList);

    int count(@Param("map") Map<String,Object> map);

    List<TeamVo> list(Map<String,Object> map);

    int disable(@Param("lists") List<Long> lists);

    int enable(@Param("lists") List<Long> lists);

    List<AssociateResult> checkAssociated(@Param("idList") List<Long> idList);

}