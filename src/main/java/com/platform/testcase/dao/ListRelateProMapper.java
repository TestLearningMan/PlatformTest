package com.platform.testcase.dao;

import com.platform.testcase.pojo.ListRelatePro;

import java.util.List;

public interface ListRelateProMapper {
    List<ListRelatePro> list(Long listId);

    int insert(Long listId, List<Long> productIds);

    int delete(Long listId);
}