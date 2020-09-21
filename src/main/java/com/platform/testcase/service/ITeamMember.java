package com.platform.testcase.service;

import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.platform.testcase.pojo.TeamMember;
import com.platform.testcase.vo.TeamMemberVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITeamMember {
    public R add(TeamMember member);
    public R update(TeamMember member);
    public R batchDelete(List<Long> testerIds,Long teamId);
    public int count(HashMap<String,Object> map);
    public List<TeamMemberVo> list(Map<String,Object> map);
}
