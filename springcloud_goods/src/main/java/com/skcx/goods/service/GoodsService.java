package com.skcx.goods.service;


import com.skcx.entity.Goods;

import java.util.List;

public interface GoodsService {

    Goods getGoodsById(Integer id);

    List<Goods> findAll();
}
