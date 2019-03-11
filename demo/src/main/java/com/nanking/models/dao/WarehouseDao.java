package com.nanking.models.dao;

import com.nanking.models.dto.WarehouseDto;
import com.nanking.models.domain.Warehouse;
import com.nanking.vo.WarehouseVo;

import java.util.List;

public interface WarehouseDao {
    //查所有
    public List<Warehouse> selectAll();
    //查名称和编号
    public List<WarehouseVo>selectNameAndCode();
    //查最大编号
    public  String selectMaxCode();
   //批量删除
    public Integer deleteById(Integer id);
    //批量插入
    public Integer insertMany(WarehouseDto warehouseDto);



}
