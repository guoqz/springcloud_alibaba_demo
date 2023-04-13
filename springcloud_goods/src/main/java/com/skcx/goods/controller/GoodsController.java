package com.skcx.goods.controller;

import com.skcx.entity.Goods;
import com.skcx.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "{商品管理微服务}")
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("商品管理-根据id查询商品")
    @ApiImplicitParams({
            //                          参数              注释              是否必填            数据类型
            @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "String"),
    })
    @ResponseBody
    @GetMapping(value = "/getGoodsById")
    public Goods getGoodsById(@RequestParam("id") Integer id) {
        return goodsService.getGoodsById(id);
    }


    @ApiOperation("商品管理-查询所有商品")
    @ResponseBody
    @GetMapping(value = "/selectAll")
    public List<Goods> selectAll() {
        return goodsService.findAll();
    }

}
