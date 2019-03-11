package com.nanking.services;

import com.nanking.models.dto.InWareDto;
import com.nanking.models.dao.InDocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InDocumentService {
    @Autowired
    private InDocumentDao inDocumentDao;
    //查询已知最大入库单号
    public String selectMaxInCode(String inCodeHead){

        return inDocumentDao.selectMaxInCode(inCodeHead);
    }

    //新增入库单（可批量新增）
    @Transactional
    public Integer insertInDocument (InWareDto inWareDto){
        return inDocumentDao.insertInDocument(inWareDto);
    }

}
