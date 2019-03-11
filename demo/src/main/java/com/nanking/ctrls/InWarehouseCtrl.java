package com.nanking.ctrls;

import com.nanking.common.Result;
import com.nanking.models.dto.InWareDto;
import com.nanking.services.InWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/inWarehouse")
public class InWarehouseCtrl extends BaseCtrl{
    @Autowired
    private InWarehouseService inWarehouseService;
    //分页显示入库单
    @GetMapping("/selectForPage")
    public Result selectForPage(InWareDto inWareDto){
        return this.send(inWarehouseService.selectForPage(inWareDto));
    }
    //查询某个入库单的详细信息
    @GetMapping("/selectByInCode")
    public Result selectInWarehouseByInCode(@RequestParam("code") String code){
        return  this.send(inWarehouseService.selectInWarehouseByInCode(code));
    }

    //批量入库
    @PostMapping("/insertMany")
    public Result insertMany(@Valid InWareDto inWareDto){
        return  this.send(inWarehouseService.insertMany(inWareDto));
    }

}
