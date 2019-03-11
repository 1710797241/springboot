package com.nanking.vo;

import java.io.Serializable;
import java.util.Date;

public class InWarehouseVo implements Serializable {

    //单号
    private String inCode;
    //入库类型
    private String inType;

    //仓库地址
    private String warehouseAddress;

    //创建时间
    private Date createTime;
    //操作人
    private String inPerson;

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

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
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
