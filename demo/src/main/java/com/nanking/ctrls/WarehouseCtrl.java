package com.nanking.ctrls;

import com.nanking.common.Result;
import com.nanking.models.dto.WarehouseDto;
import com.nanking.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/warehouse")
public class WarehouseCtrl extends BaseCtrl {
    @Autowired
    private WarehouseService warehouseService;
//    查询仓库的所有信息
    @GetMapping("/selectAll")
    public Result selectAll(){
        return this.send(warehouseService.selectAll());

    }
//    查仓库名和编码
    @GetMapping("/selectNameAndCode")
    public Result selectNameAndCode(){

        return this.send(warehouseService.selectNameAndCode());
    }


    @PostMapping("/insertMany")
    public Result insertMany( @Valid WarehouseDto WarehouseDto){
        return this.send(warehouseService.insertMany(WarehouseDto));

    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        return this.send(warehouseService.deleteById(id));
    }

}
