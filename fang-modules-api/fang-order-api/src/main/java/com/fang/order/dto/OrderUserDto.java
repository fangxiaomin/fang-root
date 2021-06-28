package com.fang.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.dto
 * @author:fxm
 * @createTime:2021/6/23 16:57
 * @version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUserDto {
    private Integer id;
    private String sn ;
    private BigDecimal orderPrice;
}
