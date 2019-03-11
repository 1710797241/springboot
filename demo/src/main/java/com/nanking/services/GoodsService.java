package com.nanking.services;

import com.nanking.common.GenerateCodeUtil;
import com.nanking.models.dto.GoodsDto;
import com.nanking.models.dao.GoodsDao;
import com.nanking.models.domain.Goods;
import com.nanking.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    //查询商品所有信息
    public Map<String,Object>  selectByCode(String code){
        List<Goods> goodsList = goodsDao.selectByCode(code);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",goodsList.size());
        map.put("data",goodsList);
        return map;
    }
    //查询商品名称和编号
    public Map<String,Object> selectNameAndCode(){
        List<GoodsVo> goodsVoList = goodsDao.selectNameAndCode();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",goodsVoList.size());
        map.put("data",goodsVoList);
        return map;
    }
    //批量插入
    public Map<String,Object> insertMany(GoodsDto goodsDto){
        String  head = "G";
        String zeros ="0000000000";
        String maxCode = goodsDao.selectMaxCode();
        String nextCode = GenerateCodeUtil.generateCode(maxCode);
        List<Goods> goodsList = goodsDto.getGoodsList();
        Long nextCodel = Long.parseLong(nextCode);
        for (int i= 0;i<goodsList.size();i++){
            String fillStr = zeros+nextCodel;
            nextCode=fillStr.substring(nextCode.length()+1);
            goodsList.get(i).setGoodsCode(head+nextCode);
            nextCodel++;
            nextCode = String.valueOf(nextCodel);
        }
        goodsDto.setGoodsList(goodsList);
        Integer count = goodsDao.insertMany(goodsDto);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        return map;
    }

    //批量删除
    public Map<String,Object> deleteById(Integer id){
        Integer count = goodsDao.deleteById(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        return map;
    }
}
