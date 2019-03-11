package com.nanking.models.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class InDocument {
    //单据编号,手动设置

    private String inCode;
    private String inName="入库";
    //入库类型
    @NotEmpty(message = "请输入正确的入库类型")
    private String inType;
    @NotEmpty(message = "请输入正确的仓库名称")
    private String warehouseCode;
    //创建时间，自动生成
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime ;
    //入库负责人
    @NotEmpty(message = "请输入正确的负责人姓名")
    private String inPerson;

    public String getInCode() {
        return inCode;
    }

    public void setInCode(String inCode) {
        this.inCode = inCode;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInPerson() {
        return inPerson;
    }

    public void setInPerson(String inPerson) {
        this.inPerson = inPerson;
    }
}
