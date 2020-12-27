package com.platform.testcase.dao;

import com.platform.testcase.pojo.DocNumber;
import org.apache.ibatis.annotations.Param;

public interface DocNumberMapper {
    DocNumber selectByType(@Param("type") int type);
    int updateNumber(@Param("number") Long number,@Param("type") int type);
    int isExist(@Param("number") Long number,@Param("type") int type);

}
