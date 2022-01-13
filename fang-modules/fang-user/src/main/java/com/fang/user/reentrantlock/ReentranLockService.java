package com.fang.user.reentrantlock;

import com.fang.user.entity.Order;
import com.fang.user.entity.Product;
import com.fang.user.mapper.IOrderMapper;
import com.fang.user.mapper.IProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:fxm
 * @createTime:2021/10/12 11:36
 */
@Service
public class ReentranLockService {
    //设置一把可重入的公平锁
    private Lock lock = new ReentrantLock(true);

    @Resource
    private IProductMapper productMapper;
    @Resource
    private IOrderMapper orderMapper;

   /* @Transactional(rollbackFor = Exception.class)
    public Result func( Long seckillId , long userId){
        lock.lock();
        //  执行数据库操作===查询商品库存
        //如果库存数量满足要求，执行数据库操作-减少库存--卖出货物
        lock.unlock();

        return null;
    }*/

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void sellProduct() {
        try {
            lock.lock();
            sellProductBiz();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " : 释放锁");
            lock.unlock();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sellProductBiz() {
        System.out.println(Thread.currentThread().getName() + " 抢到锁啦，:进入方法");
//        int a =1/0;
        Product product = productMapper.selectById(1);
        Integer cnt = product.getProductCnt();
        System.out.println(Thread.currentThread().getName() + "当前库存 = " + cnt);
        if (cnt > 0) {
            Product productUpdate = new Product();
            productUpdate.setId(product.getId());
            productUpdate.setProductCnt(cnt - 1);
            productMapper.updateById(productUpdate);
            Order order = new Order();
            order.setProductId(product.getId().longValue());
            order.setCount(1);
            order.setUserId(2L);
            orderMapper.insert(order);
            System.out.println(Thread.currentThread().getName() + "扣减库存完毕，创建订单完毕");
        } else {
            System.out.println(Thread.currentThread().getName() + " : 没库存了");
        }
    }
}
