package com.nanking.models.dto;

import com.nanking.models.domain.Goods;

import javax.validation.Valid;
import java.util.List;

public class GoodsDto {

    @Valid
    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
