package com.platform.testcase.service.impl;

import com.google.common.base.Splitter;
import com.platform.testcase.handler.AssociateResultHandler;
import com.platform.testcase.dao.ProductMapper;
import com.platform.testcase.pojo.AssociateResult;
import com.platform.testcase.pojo.Product;
import com.platform.testcase.service.IProductService;
import com.platform.testcase.utils.BaseTypeUtils;
import com.platform.testcase.utils.IdGenerator;
import com.platform.testcase.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootdo.common.utils.*;

import java.util.ArrayList;
import java.util.Iterator;
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


    public R batchDelete(String productIds){
        List<String> IdListStr = Splitter.on(",").splitToList(productIds);
        List<Long> productIdList= BaseTypeUtils.strToLong(IdListStr);
        int totalNum = productIdList.size();
        String errMsg = checkAssociation(productIdList);
        int successNum = productIdList.size();
        int failNum = totalNum - successNum;
        StringBuilder msg = new StringBuilder();
        msg.append("操作成功\n").append("成功删除产品").append(successNum)
                .append("个\n").append(failNum).append("个产品删除失败,")
                .append(errMsg);
        if (successNum != 0){
            productMapper.batchDelete(productIdList);
        }
        return R.ok(errMsg.toString());
    }

    public List<ProductVo> list(Map<String,Object> query){
        List<ProductVo> products = productMapper.list(query);
        return products;
    }

    public int count(Map<String,Object> map) {
        return productMapper.count(map);
    }

    public R forbidden(List<Long> lists,int type){
        productMapper.forbidden(lists,type);
        return R.ok("团队状态更新成功");
    }

    private String checkAssociation(List<Long> idList){
        List<AssociateResult> resultList= productMapper.checkAssociated(idList);
        if (resultList == null || resultList.size() == 0){
            return "";
        }
        StringBuilder errMsg=new StringBuilder();
        errMsg.append("失败原因如下:\n");
        for(AssociateResult result : resultList) {
            Long id = result.getId();
            idList.remove(id);
            switch (result.getType()){
                case "6501":
                    errMsg.append(result.getName()).append("已关联测试用例，删除失败;\n");
                    break;
                case "6502":
                    errMsg.append(result.getName()).append("已关联子功能，删除失败;\n");
                    break;
                case "6503":
                    errMsg.append(result.getName()).append("已关联测试用例集，删除失败;\n");
                    break;
                default:
                    errMsg.append(result.getName()).append("已关联其他业务，删除失败;\n");
            }
        }

        return errMsg.toString();
    }
}
