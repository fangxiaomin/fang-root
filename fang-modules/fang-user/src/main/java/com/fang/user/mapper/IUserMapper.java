package com.fang.user.mapper;

import com.fang.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.mapper
 * @author:fxm
 * @createTime:2021/8/23 16:38
 * @version:1.0
 */
@Mapper
public interface IUserMapper {

    User getUserById(@Param("id") Integer id);
}
