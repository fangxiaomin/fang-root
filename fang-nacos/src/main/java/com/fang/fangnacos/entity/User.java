package com.fang.fangnacos.entity;

import lombok.Data;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.fangsentinelservice.entity
 * @author:fxm
 * @createTime:2021/8/17 16:02
 * @version:1.0
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
