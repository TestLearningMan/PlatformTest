package com.platform.testcase.service.impl;

import com.platform.testcase.dao.TeamMapper;
import com.platform.testcase.pojo.Team;
import com.platform.testcase.service.ITeamService;
import com.google.common.base.Splitter;
import com.platform.testcase.dao.TeamMapper;
import com.platform.testcase.service.IProductService;
import com.platform.testcase.utils.BaseTypeUtils;
import com.platform.testcase.utils.IdGenerator;
import com.platform.testcase.vo.ProductVo;
import com.platform.testcase.vo.TeamVo;
import org.activiti.engine.impl.transformer.StringToInteger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootdo.common.utils.*;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements ITeamService {
    @Autowired
    TeamMapper teamMapper;

    public R save(Team team){
        int result = 0;
        //团队ID为空，则新增团队
        if (null == team.getId() || team.getId() == 0 ){
            team.setId(IdGenerator.getId());
            team.setCreatorId(ShiroUtils.getUserId());
            team.setModifierId(ShiroUtils.getUserId());
            result = teamMapper.insertSelective(team);
        }else{
            result = teamMapper.updateByPrimaryKeySelective(team);
        }
        //团队ID不为空，保存修改值
        if(result == 1){
            return R.ok("团队新增成功");
        }
        return R.error("团队新增失败");
    }
    public R delete(String ids){
        List<String> idList = Splitter.on(ids).splitToList(",");
        int result = teamMapper.delete(idList);
        if (result > 0){
            StringBuilder builder = new StringBuilder();
            return R.ok(builder.append("已成功删除团队 ").append(result).append("个").toString());
        }
        return R.error("团队删除失败");
    }
    public int count(Map<String,Object> map){
        return teamMapper.count(map);
    }
    public List<TeamVo> list(Map<java.lang.String,Object> map){
        return teamMapper.list(map);
    }
    public R forbidden(List<Long> lists,int type){
        int result = 0;
        //禁用/启用调用不同的方法
        switch (type){
            case 0:
                result=teamMapper.disable(lists);
                break;
            case 1:
                result=teamMapper.enable(lists);
                break;
            default:
                return R.error("前端传参错误，请重新进行禁用/启用操作");
        }
        if (result ==0){
            return R.error("所选团队状态已被全部更新,请重新选择需要禁用/启用的团队");
        }
        return  R.ok("团队状态更新成功");
    }





}
