package com.nanking.models.domain;

import javax.validation.constraints.NotEmpty;

public class Warehouse {

    //仓库编号
    //手动生成
    private String warehouseCode;
    //仓库名称
    @NotEmpty(message = "请输入正确的仓库名称")
    private String warehouseName;
    //仓库地址
    @NotEmpty(message = "请输入正确的仓库地址")
    private String warehouseAddress;
    //仓库负责人
    @NotEmpty(message = "请输入正确的仓库负责人")
    private String warehouseManager;
    private String  deleteStatus ="no";

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseManager() {
        return warehouseManager;
    }

    public void setWarehouseManager(String warehouseManager) {
        this.warehouseManager = warehouseManager;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
