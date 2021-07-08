package com.fang.user.service;

import com.fang.common.web.Result;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.service
 * @author:fxm
 * @createTime:2021/6/16 17:13
 * @version:1.0
 */
public interface IUserService {

    String getOrderData();

    String getUserException(Long id);
}
