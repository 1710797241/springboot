package com.nanking.models.dto;

import com.nanking.models.domain.Warehouse;

import javax.validation.Valid;
import java.util.List;

public class WarehouseDto {
    @Valid
    private List<Warehouse>  warehouseList;

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }
}
