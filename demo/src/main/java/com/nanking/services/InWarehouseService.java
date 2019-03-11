package com.nanking.services;

import com.github.pagehelper.PageHelper;
import com.nanking.common.GenerateCodeUtil;
import com.nanking.models.domain.InDocument;
import com.nanking.models.domain.InWarehouse;
import com.nanking.models.domain.PageInfo;
import com.nanking.models.dto.InWareDto;
import com.nanking.models.dao.InDocumentDao;
import com.nanking.models.dao.InWarehouseDao;
import com.nanking.vo.InWarehouseDetailVo;
import com.nanking.vo.InWarehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InWarehouseService {
    @Autowired
    private InWarehouseDao inWarehouseDao;
    @Autowired
    private InDocumentDao inDocumentDao;
    //根据某个入库单编号查入库明细
    public  Map<String,Object> selectInWarehouseByInCode(String code){
        List<InWarehouseDetailVo> inWarehouseDetailVoList = inWarehouseDao.selectInWarehouseByInCode(code);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",inWarehouseDetailVoList.size());
        map.put("data",inWarehouseDetailVoList);
        return  map;
    }

//    //分页查询，查入库单
//    public Page<InWarehouseVo> selectForPage(InWarehouseDto inWarehouseDto){
//        Page<InWarehouseVo> page = inWarehouseDto.getPage();
//        if(page.getCurrentPage()==null){
//            page.setCurrentPage(1);
//        }
//        if(page.getCurrentCount()==null){
//            page.setCurrentPage(5);
//        }
//        Integer totalCount = inWarehouseDao.selectTotalCount();
//        Integer currentPage = page.getCurrentPage();
//        Integer currentCount = page.getCurrentCount();
//        Integer index = (currentPage-1)*currentCount;
//        Integer totalPage = totalCount%currentCount == 0 ? (totalCount/currentCount):(totalCount/currentCount+1);
//        page.setIndex(index);
//        page.setTotalPage(totalPage);
//        inWarehouseDto.setPage(page);
//        List<InWarehouseVo> inWarehouseVoList = inWarehouseDao.selectForPage(inWarehouseDto);
//        page.setPageList(inWarehouseVoList);
//        return page;
//    }

    public   Map<String,Object> selectForPage(InWareDto inWareDto){

                Integer pageNum = inWareDto.getPageNum();
                Integer pageSize = inWareDto.getPageSize();
                if(pageNum==null){
                    pageNum=1;
                }
                if(pageSize==null){
                    pageSize=8;
                }
                PageHelper.startPage(pageNum,pageSize);

                List<InWarehouseVo> inWarehouseVoList = inWarehouseDao.selectForPage(inWareDto);
                PageInfo<InWarehouseVo> pageInfo = new PageInfo<InWarehouseVo>(inWarehouseVoList);
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("total",inWarehouseVoList.size());
                map.put("data",inWarehouseVoList);
                  return map;
    }

    //入库（可批量入库）
    @Transactional
    public  Map<String,Object> insertMany(InWareDto inWareDto){
        //当天时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //格式化当天时间
        String formatCurrentDate = simpleDateFormat.format(date);
        //查找已有最大编号
        String inMaxCode = inDocumentDao.selectMaxInCode(formatCurrentDate);
        //生成下一个编号
        String nextCode = GenerateCodeUtil.generateCode(inMaxCode);
        //拼接成入库编号
        nextCode ="I"+nextCode;
        //单据头部封装数据
        InDocument inDocument = inWareDto.getInDocument();
        inDocument.setInCode(nextCode);
        inDocument.setCreateTime(date);
        //更新inWareDto中inDocument
        inWareDto.setInDocument(inDocument);
        //新增一张入库单的头部信息
        Integer count = inDocumentDao.insertInDocument(inWareDto);
        //封装新增商品信息的编号
        List<InWarehouse> inWarehouseList = inWareDto.getInWarehouseList();
        for( int i = 0;i<inWarehouseList.size();i++){
            inWarehouseList.get(i).setInCode(nextCode);
        }
        //更新inWareDto中inWarehouseList
        inWareDto.setInWarehouseList(inWarehouseList);
        Integer insertCount = inWarehouseDao.insertMany(inWareDto);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",insertCount);
        return map;
    }

}
