package com.nanking.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanking.models.domain.InDocument;
import com.nanking.models.domain.InWarehouse;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

public class InWareDto {

    //入库单号
    private String inCode;

    //入库类型
    private String inType;

    //商品编号
    private String goodsCode;
    //商品名称
    private String goodsName;
    //起始时间
    private String startDate;

    //终止时间
    private  String endDate;

    private Integer pageNum;

    private Integer pageSize;


    @Valid
    private InDocument inDocument;
    @Valid
    private List<InWarehouse> inWarehouseList ;



    public String getInCode() {
        return inCode;
    }

    public void setInCode(String inCode) {
        this.inCode = inCode;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public InDocument getInDocument() {
        return inDocument;
    }

    public void setInDocument(InDocument inDocument) {
        this.inDocument = inDocument;
    }

    public List<InWarehouse> getInWarehouseList() {
        return inWarehouseList;
    }

    public void setInWarehouseList(List<InWarehouse> inWarehouseList) {
        this.inWarehouseList = inWarehouseList;
    }


}
