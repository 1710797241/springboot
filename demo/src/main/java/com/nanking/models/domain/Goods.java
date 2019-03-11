package com.nanking.models.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Goods {
    //数据库自增
    private Integer id;
    //商品编号，手动生成
    private String goodsCode;
    //商品名称
    @NotEmpty(message ="请输入正确的商品名称")
    private  String goodsName;
    //商品规格类型
    @NotEmpty(message = "请输入正确的商品规格类型")
    private String goodsSize;
    //商品价格
    @NotNull(message ="请输入正确的商品价格")
    @Min(value = 0,message = "请输入正确的商品价格")
    private BigDecimal goodsPrice;

    private String deleteStatus="no";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
