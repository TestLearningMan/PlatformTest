package com.platform.testcase.service.impl;

import com.google.common.base.Splitter;
import com.platform.testcase.dao.ProductMapper;
import com.platform.testcase.pojo.Product;
import com.platform.testcase.service.IProductService;
import com.platform.testcase.utils.IdGenerator;
import com.platform.testcase.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootdo.common.utils.*;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductMapper productMapper;

    public R save(Product product){
        if (productMapper.isExist(product.getProductName()) >0){
            return R.error(-1,"产品名称已存在");
        }
        if (StringUtils.isBlank(product.getId().toString())){
            product.setId(IdGenerator.getId());
            product.setStatus(1);
            product.setCreatorId(ShiroUtils.getUserId());
            product.setModifierId(ShiroUtils.getUserId());
            int result = productMapper.insertSelective(product);
            if (result > 0){
                return R.ok("新增产品成功");
            }
                return R.error("新增产品失败");

        }
        else{
            product.setModifierId(ShiroUtils.getUserId());
            int result = productMapper.save(product);
            if (result > 0){
                return R.ok("保存产品成功");
            }
            return R.error("所选商品不存在，请重新选择商品修改");
            }
        }

    public R delete(Long id){
        int result=productMapper.delete(id);
        if (result > 0){
            return R.ok("删除产品成功");
        }
        return R.error("此产品已被删除，请勿重复操作");
    }

    public R batchDelete(String productIds){
        List<String> productIdList = Splitter.on(",").splitToList(productIds);
        if (productIdList.size() == 0){
            return R.error("请刷新页面，重新选择要删除的产品");
        }

        int result=productMapper.batchDelete(productIdList);
        if (result > 0){
            return R.ok("批量删除产品成功");}
        return R.error("所选产品已被删除，请勿重复操作");
    }

    public List<ProductVo> list(Map<String,Object> query){
        List<ProductVo> products = productMapper.list(query);
        return products;
    }

    public int count(Map<String,Object> map) {
        return productMapper.count(map);
    }

    public R forbidden(List<Long> lists,int type){
        int result = 0;
        //禁用/启用调用不同的方法
        switch (type){
            case 0:
                result=productMapper.disable(lists);
                break;
            case 1:
                result=productMapper.enable(lists);
                break;
            default:
                return R.error("前端传参错误，请重新进行禁用/启用操作");
        }
        if (result == 0){
            return R.error("所选团队状态已被全部更新,请重新选择需要禁用/启用的团队");
        }
        return R.ok("团队状态更新成功");

    }

}
