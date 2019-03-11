package com.nanking.models.dao;
import com.nanking.models.dto.InWareDto;
import com.nanking.vo.InWarehouseDetailVo;
import com.nanking.vo.InWarehouseVo;

import java.util.List;

public interface InWarehouseDao {

    public List<InWarehouseDetailVo> selectInWarehouseByInCode(String code);
    //查总记录数
    public Integer selectTotalCount ();
    //分页查询limit index,currenCount
    public List<InWarehouseVo> selectForPage(InWareDto inWareDto);
    //入库（可批量入库）
    public Integer insertMany( InWareDto inWareDto);



}
