package com.platform.testcase.dao;

import com.platform.testcase.pojo.DocNumber;
import org.apache.ibatis.annotations.Param;

public interface DocNumberMapper {
    DocNumber selectByCode(@Param("docCode") int docCode);
    int updateNumber(@Param("docNumber") Long number,@Param("docCode") int type);
    int isExist(@Param("docNumber") Long number,@Param("docCode") int type);

}
