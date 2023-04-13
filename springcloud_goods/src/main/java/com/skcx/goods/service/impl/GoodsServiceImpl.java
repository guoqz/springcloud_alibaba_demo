package com.skcx.goods.service.impl;

import com.skcx.entity.Goods;
import com.skcx.goods.mapper.GoodsMapper;
import com.skcx.goods.service.GoodsService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 测试 Redis、Redission分布式锁
     *
     * @param id
     * @return
     */
    @Override
    public Goods getGoodsById(Integer id) {
        Goods goods = null;

        // 获取锁对象
        RLock lock = redissonClient.getLock("anyLock");

        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));

        // 缓存中的key  （前缀可以设置成常量）
        String key = "goods" + ":" + date + ":" + id;   // goods:2023:02:25:1

        try {
            //尝试加锁，最多等待100秒，上锁以后30秒自动解锁
            boolean result = lock.tryLock(100, 30, TimeUnit.SECONDS);
            if (result) {
                // 先查缓存中是否存在该数据
                Goods goodsCache = (Goods) redisTemplate.opsForValue().get(key);
                // 缓存中存在该数据，就返回数据
                if (null != goodsCache) {
                    System.out.println("缓存命中");
                    return goodsCache;
                }

                // 如果缓存中不存在
                // 查数据库
                goods = goodsMapper.selectById(id);

                // 数据库中也不存在，缓存中存一个 空字符串
                if (null == goods) {
                    // 存入redis
                    redisTemplate.opsForValue().set(key, goods, 30, TimeUnit.SECONDS);
                    System.out.println("数据库不存在该数据");
                    return null;
                }

                redisTemplate.opsForValue().set(key, goods, 30, TimeUnit.MINUTES);
                System.out.println("缓存未命中，查询数据库获取数据，该数据存入缓存");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return goods;
    }


    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectList(null);
    }
}
