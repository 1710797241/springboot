package com.nanking.models.dao;

import com.nanking.models.dto.GoodsDto;
import com.nanking.models.domain.Goods;
import com.nanking.vo.GoodsVo;

import java.util.List;

public interface GoodsDao {

    //查询商品所有信息
    public List<Goods> selectByCode(String  code);
    //查询商品名称和编号
    public List<GoodsVo> selectNameAndCode();
    //最大编号
    public  String selectMaxCode();
    //批量插入
    public Integer insertMany(GoodsDto goodsDto);
    //批量删除
    public Integer deleteById(Integer id);
}
