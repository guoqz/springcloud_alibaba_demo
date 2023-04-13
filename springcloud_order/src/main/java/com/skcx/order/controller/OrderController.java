package com.skcx.order.controller;

import com.skcx.entity.Goods;
import com.skcx.order.feign.OrderGoodsFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单管理微服务")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderGoodsFeignService orderGoodsFeignService;

    /**
     * 购买商品
     *
     * @param goodsId  商品id
     * @param userId   用户id（购买者）
     * @param quantity 购买数量
     * @return
     */
    @ApiOperation("订单管理-购买商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品id", required = true),// required 是否必要的
            @ApiImplicitParam(name = "UserId", value = "用户id", required = false),
            @ApiImplicitParam(name = "quantity", value = "购买数量", required = false)
    })
    @PostMapping(value = "/purchaseGoods")
    public String purchaseGoods(Integer goodsId, Integer userId, Integer quantity) {
        // 查询商品     String 类型
        Goods goods = orderGoodsFeignService.getGoodsById(goodsId);
        // 创建订单

        // 减库存

        return "<下单成功>:" + goods;
    }

}
