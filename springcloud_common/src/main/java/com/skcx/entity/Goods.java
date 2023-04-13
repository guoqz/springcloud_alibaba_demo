package com.skcx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("商品实体类")
@Data
@ToString
@TableName("s_goods")
public class Goods implements Serializable {

    // 主键
    @ApiModelProperty("商品id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    // 商品名
    @ApiModelProperty("商品名称")
    private String goodsName;

    // 价格
    @ApiModelProperty("商品价格")
    private BigDecimal price;

    // 库存
    @ApiModelProperty("商品库存")
    private Integer stock;

}
