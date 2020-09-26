package com.platform.testcase.vo;

import com.platform.testcase.utils.TimeUtils;

import java.util.Date;
import java.sql.Timestamp;

public class CaseDetailVo {
    private Long id;

    private Long product_id;

    private String product_name;

    private Long functionId;

    private String functionName;

    private Integer level;

    private String imgPath;

    private String precondition;

    private String title;

    private String excStep;

    public CaseDetailVo(Long id, Long product_id, String product_name, Long functionId, String functionName, Integer level, String imgPath, String precondition, String title, String excStep, String expResults, String remarks, Integer status, String apitestCaseid, String unittestCaseid, String uitestCaseid, Long backdevId, String relateDemand, Long frontdevId, Long productmanId,Timestamp modifiedTime, Long modifierId) {
        this.id = id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.functionId = functionId;
        this.functionName = functionName;
        this.level = level;
        this.imgPath = imgPath;
        this.precondition = precondition;
        this.title = title;
        this.excStep = excStep;
        this.expResults = expResults;
        this.remarks = remarks;
        this.status = status;
        this.apitestCaseid = apitestCaseid;
        this.unittestCaseid = unittestCaseid;
        this.uitestCaseid = uitestCaseid;
        this.backdevId = backdevId;
        this.relateDemand = relateDemand;
        this.frontdevId = frontdevId;
        this.productmanId = productmanId;
        this.modifierId = modifierId;
        this.modifiedTime = TimeUtils.TimeStrampToString(modifiedTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcStep() {
        return excStep;
    }

    public void setExcStep(String excStep) {
        this.excStep = excStep;
    }

    public String getExpResults() {
        return expResults;
    }

    public void setExpResults(String expResults) {
        this.expResults = expResults;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApitestCaseid() {
        return apitestCaseid;
    }

    public void setApitestCaseid(String apitestCaseid) {
        this.apitestCaseid = apitestCaseid;
    }

    public String getUnittestCaseid() {
        return unittestCaseid;
    }

    public void setUnittestCaseid(String unittestCaseid) {
        this.unittestCaseid = unittestCaseid;
    }

    public String getUitestCaseid() {
        return uitestCaseid;
    }

    public void setUitestCaseid(String uitestCaseid) {
        this.uitestCaseid = uitestCaseid;
    }

    public Long getBackdevId() {
        return backdevId;
    }

    public void setBackdevId(Long backdevId) {
        this.backdevId = backdevId;
    }

    public String getRelateDemand() {
        return relateDemand;
    }

    public void setRelateDemand(String relateDemand) {
        this.relateDemand = relateDemand;
    }

    public Long getFrontdevId() {
        return frontdevId;
    }

    public void setFrontdevId(Long frontdevId) {
        this.frontdevId = frontdevId;
    }

    public Long getProductmanId() {
        return productmanId;
    }

    public void setProductmanId(Long productmanId) {
        this.productmanId = productmanId;
    }


    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getCreatorId() {
        return modifierId;
    }

    public void setCreatorId(Long creatorId) {
        this.modifierId = creatorId;
    }

    private String expResults;

    private String remarks;

    private Integer status;

    private String apitestCaseid;

    private String unittestCaseid;

    private String uitestCaseid;

    private Long backdevId;

    private String relateDemand;

    private Long frontdevId;

    private Long productmanId;

    private String modifiedTime;

    private Long modifierId;

}
