package com.nanking.services;

import com.nanking.common.GenerateCodeUtil;
import com.nanking.models.dto.WarehouseDto;
import com.nanking.models.dao.WarehouseDao;
import com.nanking.models.domain.Warehouse;
import com.nanking.vo.WarehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;

    //查询所有
    public Map<String, Object> selectAll() {
        List<Warehouse> warehouseList = warehouseDao.selectAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", warehouseList.size());
        map.put("data", warehouseList);
        return map;
    }

    //查仓库名和编码
    public Map<String, Object> selectNameAndCode() {
        List<WarehouseVo> warehouseVoList = warehouseDao.selectNameAndCode();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", warehouseVoList.size());
        map.put("data", warehouseVoList);
        return map;
    }
    //批量插入
    @Transactional
    public Map<String, Object> insertMany(WarehouseDto warehouseDto) {
        String head = "W";
        String zeros="000000";
        String maxCode = warehouseDao.selectMaxCode();
        String nextCode = GenerateCodeUtil.generateCode(maxCode);
        List<Warehouse> warehouseList = warehouseDto.getWarehouseList();
        Long nextCodel = Long.parseLong(nextCode);
        //批量生成编号
        for (int i = 0;i<warehouseList.size();i++){
            String fills = zeros+nextCodel;
            nextCode=fills.substring(nextCode.length()+1);
            warehouseList.get(i).setWarehouseCode(head+nextCode);
            nextCodel+=1;
            nextCode = String.valueOf(nextCodel);
        }
        //更新warehouseDto中warehouseList
        warehouseDto.setWarehouseList(warehouseList);
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = warehouseDao.insertMany(warehouseDto);
        map.put("total", count);
        return map;
    }
    //批量删除
    @Transactional
    public  Map<String, Object> deleteById(Integer id){
        Integer count = warehouseDao.deleteById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        return map;
    }


}
