package com.fang.order.parms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.parms
 * @author:fxm
 * @createTime:2021/6/23 17:04
 * @version:1.0
 */
@Data
public class OrderInfoParm {
    private Long userId;
    private String name;
}
