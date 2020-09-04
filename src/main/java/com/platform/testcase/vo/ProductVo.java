package com.platform.testcase.vo;

public class ProductVo {
    private Long id;

    private String productName;

    private String productman;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductman() {
        return productman;
    }

    public void setProductman(String productman) {
        this.productman = productman;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
