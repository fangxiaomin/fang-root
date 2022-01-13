package com.fang.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.user.entity.Product;
import org.apache.ibatis.annotations.Param;

/**
 * @author:fxm
 * @createTime:2021/10/12 14:55
 */
public interface IProductMapper extends BaseMapper<Product> {

//    Product selectByPrimaryKey(@Param("id") Integer id);
}
