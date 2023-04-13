package com.skcx.goods.initial;

import com.skcx.entity.Goods;
import com.skcx.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GoodsService goodsService;


    @Override
    public void run(String... args) throws Exception {
        List<Goods> list = goodsService.findAll();

        // 缓存到 redis 中
        redisTemplate.opsForValue().set("goodsList", list, 30, TimeUnit.SECONDS);

//        for (Goods goods : (List<Goods>) Objects.requireNonNull(redisTemplate.opsForValue().get("goodsList"))) {
//            System.out.println(goods);
//        }
//        Goods(id=1, goodsName=苹果, price=5.00, stock=50)
//        Goods(id=2, goodsName=香蕉, price=7.00, stock=100)

    }
}
