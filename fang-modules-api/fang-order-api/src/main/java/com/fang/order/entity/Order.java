package com.fang.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.entity
 * @author:fxm
 * @createTime:2021/6/25 14:34
 * @version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String username;
    private String password;
}
