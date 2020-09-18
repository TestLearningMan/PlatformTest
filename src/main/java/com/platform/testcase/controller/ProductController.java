package com.platform.testcase.controller;

import com.google.common.base.Splitter;
import com.platform.testcase.pojo.Product;
import com.platform.testcase.service.IProductService;
import com.platform.testcase.utils.BaseTypeUtils;
import com.platform.testcase.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bootdo.common.utils.*;
import java.util.List;
import java.util.Map;


@RequestMapping("/testplatform/product")
@Controller
public class ProductController {

    @Autowired
    IProductService iProductService;

    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    @ResponseBody
    public R AddProduct(Product product){
        if (null ==product || StringUtils.isBlank(product.getProductName())){
            return R.error(-1,"产品名称不能为空");
        }
        return iProductService.save(product);
    }

    @RequestMapping(value = "/batchDelete.do")
    @ResponseBody
    public R batchDelete(String ids){
        if (StringUtils.isBlank(ids)){
            return R.error(-1,"请先选择需要删除的产品");
        }
        return iProductService.batchDelete(ids);
    }

    @RequestMapping(value = "/list.do")
    @ResponseBody
    public R list(@RequestParam Map<String,Object> map){
        Object limit = map.get("limit");
        if (null == limit || StringUtils.isBlank(limit.toString())
                || 0 == Integer.parseInt(limit.toString())) {
            return R.error("每页条数不能为空");
        }
        Query query = new Query(map);
        int total = iProductService.count(map);
        List<ProductVo> productVoLinkedHashMap =  iProductService.list(query);
        PageUtils pageUtils = new PageUtils(productVoLinkedHashMap,
                total);
        R r = new R();
        r.put("data",pageUtils);
        return r;
    }

    @RequestMapping("/forbidden.do")
    @ResponseBody
    public R forbidden(String ids,int type){
        List<String> idList = Splitter.on(",").splitToList(ids);
        List<Long> lists = BaseTypeUtils.strToLong(idList);
        return iProductService.forbidden(lists,type);
    }

}
