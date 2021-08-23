package com.fang.user.entity;

import lombok.Data;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.entity
 * @author:fxm
 * @createTime:2021/8/23 16:35
 * @version:1.0
 */
@Data
public class User {
    private Long id;
    private String mail;
    private String nickname;
    private String password;
    private String description;
    private String updateTime;
    private String createTime;
}
