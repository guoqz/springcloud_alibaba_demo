package com.skcx.order.feign;

import com.skcx.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 熔断处理，返回兜底数据
 */
@Slf4j
@Component
public class OrderGoodsFeignServiceFallback implements OrderGoodsFeignService {

    @Override
    public Goods getGoodsById(Integer id) {
        log.info("getGoodsById()调用失败");
        return null;
    }

}
