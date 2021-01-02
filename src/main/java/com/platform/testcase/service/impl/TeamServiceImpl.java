package com.platform.testcase.service.impl;

import com.platform.testcase.common.Const;
import com.platform.testcase.dao.TeamMapper;
import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.Team;
import com.platform.testcase.service.IDocNumberService;
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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements ITeamService {
    @Autowired
    TeamMapper teamMapper;

    @Autowired
    IDocNumberService iDocNumberService;

    public R save(Team team){
        int result = 0;
        //团队ID为空，则新增团队
        if (null == team.getId() || team.getId() == 0 ){
            team.setTeamNumber(iDocNumberService.updateNumber(team.getTeamNumber()
                    ,Const.serviceType.TEAM.getCode()));
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
    public R batchDelete(String ids){
        List<String> idListStr = Splitter.on(",").splitToList(ids);
        List<Long> idList = BaseTypeUtils.strToLong(idListStr);
        int totalNum = idList.size();
        String errMsg = checkAssociation(idList);
        int successNum = idList.size();
        int failNum = totalNum - successNum;
        StringBuilder msg = new StringBuilder();
        msg.append("操作成功\n").append("成功删除团队").append(successNum)
                .append("个\n").append(failNum).append("个团队删除失败,")
                .append(errMsg);
        R r = R.ok();
        if (successNum >0 ){
            teamMapper.batchDelete(idList);
        }else{
            r.put("code",400);
        }
        r.put("msg",msg.toString());
        return r;
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
    public Team decode(Team team,String code) throws UnsupportedEncodingException{
        team.setTeamName(URLDecoder.decode(team.getTeamName(),code));
        return team;
    }
    private String checkAssociation(List<Long> idList){
        List<AssociateResult> resultList= teamMapper.checkAssociated(idList);
        if (resultList == null || resultList.size() == 0){
            return "";
        }
        StringBuilder errMsg=new StringBuilder();
        errMsg.append("失败原因如下:\n");
        for(AssociateResult result : resultList) {
            Long id = result.getId();
            idList.remove(id);
            switch (result.getType()){
                case "6503":
                    errMsg.append(result.getName()).append("已关联测试用例集，删除失败;\n");
                    break;
                case "6505":
                    errMsg.append(result.getName()).append("已有团队成员，删除失败;\n");
                    break;
                    default:
                    errMsg.append(result.getName()).append("已关联其他业务，删除失败;\n");
            }
        }

        return errMsg.toString();
    }




}
