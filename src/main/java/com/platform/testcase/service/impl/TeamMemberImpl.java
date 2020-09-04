package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import com.platform.testcase.dao.TeamMapper;
import com.platform.testcase.dao.TeamMemberMapper;
import com.platform.testcase.pojo.TeamMember;
import com.platform.testcase.service.ITeamMember;
import com.platform.testcase.vo.TeamMemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamMemberImpl implements ITeamMember {

    @Autowired
    TeamMemberMapper teamMemberMapper;

    @Autowired
    TeamMapper teamMapper;
    public R add(TeamMember member){
        //如果团队存在，则插入团队成员
        if (teamMapper.selectByPrimaryKey(member.getTeamId()) !=null){
            int result = teamMemberMapper.insertSelective(member);
            if (result >0){
                return R.ok("团队成员新增成功");
            }
            return R.error("团队成员新增失败");
        }
        return R.error("请重新选择团队后再新增团队成员");
    }

    public R update(TeamMember member){
        int result = teamMemberMapper.updateByPrimaryKey(member);
        if (result > 0){
            return R.ok("团队成员修改成功");
        }
        return R.error("团队成员修改失败");
    }

    public R delete(List<TeamMember> members){
        int result = teamMemberMapper.delete(members);
        if (result > 0){
            StringBuilder builder = new StringBuilder();
            return R.ok(builder.append("已成功删除成员 ").append(result).append("个").toString());
        }
        return R.error("删除成员失败");
    }

    public int count(HashMap<String,Object> map){

        return teamMemberMapper.count(map);
    }

    public List<TeamMemberVo> list(Map<String,Object> map){
        return teamMemberMapper.list(map);
    }


}


