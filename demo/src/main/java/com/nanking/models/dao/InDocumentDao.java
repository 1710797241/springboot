package com.nanking.models.dao;


import com.nanking.models.domain.InDocument;
import com.nanking.models.dto.InWareDto;

public interface InDocumentDao {
    //查询已知最大入库单号
    public String selectMaxInCode(String inCodeHead);

    //新增入库单（可批量新增）
    public Integer insertInDocument (InWareDto inWareDto);

}
