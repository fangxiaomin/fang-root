package com.fang.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.oval.constraint.NotNull;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.entity
 * @author:fxm
 * @createTime:2021/8/12 17:42
 * @version:1.0
 */
@Data
public class AddUserParm {

    @NotNull(errorCode = "40001",message = "不能为null")
    @ApiModelProperty(required = true, name = "name", value = "名字")
    private  String name;
    @NotNull(errorCode = "40001",message = "不能为null")
    private String age;
}
