package com.platform.testcase.dao;

import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.Product;
import com.platform.testcase.vo.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int insert(@Param("record") Product record);

    int insertSelective(@Param("record") Product record);

    int isExist (String ProductName);

    int save(@Param("product") Product product);

    int batchDelete(@Param("productIdList") List<Long> productIdList);

    int count(@Param("map") Map<String,Object> map);

    List<ProductVo> list(@Param("query") Map<String,Object> query);

    int forbidden(@Param("lists") List<Long> lists,@Param("type") int type);

    List<AssociateResult> checkAssociated(@Param("idList") List<Long> idList);


}