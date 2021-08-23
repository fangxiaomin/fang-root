package com.fang.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.entity
 * @author:fxm
 * @createTime:2021/8/23 16:35
 * @version:1.0
 */
@Data
@TableName("t_order")
public class Order  {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private Long userId;
    @TableField("product_id")
    private Long productId;
    @TableField("count")
    private Integer count;
    @TableField("money")
    private BigDecimal money;
    @TableField("status")
    private Integer status;
}
