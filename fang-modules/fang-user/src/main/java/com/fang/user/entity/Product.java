package com.fang.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author:fxm
 * @createTime:2021/10/12 14:56
 */
@Data
@TableName("t_product")
public class Product {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("product_count")
    private Integer productCnt;

    @TableField("product_name")
    private String productName;

}
