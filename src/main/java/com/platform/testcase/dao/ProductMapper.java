package com.platform.testcase.dao;

import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.Product;
import com.platform.testcase.vo.ProductVo;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    int isExist (String ProductName);

    int save(Product product);

    int batchDelete(List<Long> productIdList);

    int count(Map<String,Object> map);

    List<ProductVo> list(Map<String,Object> query);

    int disable(List<Long> lists);

    int enable(List<Long> lists);
    List<AssociateResult> checkAssociated(List<Long> idList);


}