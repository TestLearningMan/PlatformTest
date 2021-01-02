package com.platform.testcase.service;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import com.platform.testcase.pojo.Product;
import com.platform.testcase.vo.ProductVo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

public interface IProductService {
    public R save(Product product);
    public R batchDelete(String productIds);
    public List<ProductVo> list(Map<String,Object> query);
    public int count(Map<String,Object> map);
    public R forbidden(List<Long> lists,int type);
    public Product decode(Product product,String code) throws UnsupportedEncodingException;

}
