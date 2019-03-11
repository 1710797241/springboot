package com.nanking.ctrls;

import com.nanking.common.Result;
import com.nanking.models.dto.GoodsDto;
import com.nanking.models.domain.Goods;
import com.nanking.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsCtrl extends BaseCtrl {
    @Autowired
    private GoodsService goodsService;
    //查询商品所有信息
    @GetMapping("/selectByCode")
    public Result selectByCode(@RequestParam("code")String code ){
        return this.send(goodsService.selectByCode(code));

    }
    //查询商品名称和编号
    @GetMapping("/selectNameAndCode")
    public Result selectNameAndCode(){
        return this.send(goodsService.selectNameAndCode());
    }

    //批量插入
   @PostMapping("/insertMany")
    public Result insertMany(@Valid GoodsDto goodsDto){
        return this.send(goodsService.insertMany(goodsDto));
   }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        return this.send(goodsService.deleteById(id));
    }
}
