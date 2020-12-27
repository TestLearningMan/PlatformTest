package com.platform.testcase.service.impl;

import com.bootdo.common.utils.R;
import com.platform.testcase.dao.DocNumberMapper;
import com.platform.testcase.pojo.DocNumber;
import com.platform.testcase.service.IDocNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DocNumberServiceImpl implements IDocNumberService {
    @Autowired
    DocNumberMapper docNumberMapper;

    public String getNumberForAdd(int type){
        DocNumber docNumber =  docNumberMapper.selectByType(type);
        String number = new StringBuilder().append(docNumber.getPrefix())
                .append(docNumber.getNumber()).toString();
        return number;
    }
    public String updateNumber(String No,int type){
        String DocNumber="";
        Long number =0L;
        String pattern = "\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(No);
        DocNumber no = docNumberMapper.selectByType(type);
        Long currentNumber = no.getNumber();
        if (!matcher.find() || currentNumber.equals(number) || currentNumber > number){
            //单据编号不支持自定义，格式不正确时，直接返回最新的单据编号
            // 单据编号与最新的编号一致时，说明编号未被使用，直接返回
            //单据编号比最新的编号还大时，说明编号未被使用，直接返回
            docNumberMapper.updateNumber(no.getNumber()+1,type);
            DocNumber = new StringBuilder(no.getPrefix()).append(no.getNumber()).toString();
        }else {
            //单据编号比最新编号要小时，需要校验单据编号是否已被使用
            number =Long.valueOf(matcher.group(0)) ;
            while (docNumberMapper.isExist(number,type) != 0){
                number+=1;
            }
            DocNumber = new StringBuilder(no.getPrefix()).append(number).toString();
        }
        return DocNumber;
    }

}
