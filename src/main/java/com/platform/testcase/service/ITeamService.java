package com.platform.testcase.service;

import com.bootdo.common.utils.R;
import com.platform.testcase.pojo.Team;
import com.platform.testcase.vo.TeamVo;

import java.util.List;
import java.util.Map;

public interface ITeamService {
    public R save(Team team);
    public R batchDelete(String ids);
    public int count(Map<String,Object> map);
    public List<TeamVo> list(Map<String,Object> map);
    public R forbidden(List<Long> lists,int type);

}
