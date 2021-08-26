package com.fang.user.design.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.proxy
 * @author:fxm
 * @createTime:2021/8/25 17:10
 * @version:1.0
 */
public class CGLibDemo {

    static class Sister{
        public void sing() {
            System.out.println("I am Jinsha, a little sister.");
        }
    }


    /**
     * 创建被代理的类及方法；
     * 创建一个实现接口 MethodInterceptor 的代理类，重写 intercept 方法；
     * 创建获取被代理类的方法 getInstance(Object target);
     * 获取代理类，通过代理调用方法。
     **/
    static class CGLibProxy implements MethodInterceptor{

        private Object target;

        public Object getInstance(Object target){
            this.target = target;
            Enhancer enhancer = new Enhancer();
            // 设置父类为实例类
            enhancer.setSuperclass(this.target.getClass());
            // 回调方法
            enhancer.setCallback(this);
            // 创建代理对象
            return enhancer.create();
        }

        private void aopMethod() {
            System.out.println("i am aopMethod");
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("introduce yourself...");
            Object result = methodProxy.invokeSuper(o,objects);
            System.out.println("score...");
            return result;
        }
    }


    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        //获取动态代理类实例
        Sister proxySister  =  (Sister) cgLibProxy.getInstance(new Sister());
        System.out.println("CGLib Dynamic object name: " + proxySister.getClass().getName());
        proxySister.sing();

        /**
         * 结果分析:
         * CGLib 的调用流程就是通过调用拦截器的 intercept 方法来实现对被代理类的调用。
         * 而拦截逻辑可以写在 intercept 方法的 invokeSuper(o, objects);的前后实现拦截。
         **/
    }
}

/**
 * AOP 的实现原理
 * Spring 中 AOP 的有两种实现方式：JDK proxy 和 CGLib 动态代理
 * 当 Bean 实现接口时，Spring 就会用 JDK 的动态代理。
 * 当 Bean 没有实现接口时，Spring 使用 CGlib 实现。
 * 可以强制使用 CGlib 代理（在 spring 配置中加入<aop:aspectj-autoproxy proxy-target-class=“true”/>）
 **/
