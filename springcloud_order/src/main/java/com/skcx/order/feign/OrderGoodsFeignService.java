package com.skcx.order.feign;

import com.skcx.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(
        value = "springcloud-goods",
        fallback = OrderGoodsFeignServiceFallback.class)  //fallback  熔断处理
public interface OrderGoodsFeignService {

    @ResponseBody
    @GetMapping(value = "/goods/getGoodsById")
    Goods getGoodsById(@RequestParam("id") Integer id);

}
