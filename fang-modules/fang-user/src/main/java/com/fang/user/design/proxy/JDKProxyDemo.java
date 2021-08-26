package com.fang.user.design.proxy;

import sun.security.jca.GetInstance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**https://blog.csdn.net/doujinlong1/article/details/80680149?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-4.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-4.control
 * @description:   JDK Proxy 动态代理
 * 需要有顶层接口才能使用，但是在只有顶层接口的时候也可以使用，常见是mybatis的mapper文件是代理。
 * 使用反射完成。使用了动态生成字节码技术。
 */
public class JDKProxyDemo {

    //需要代理的接口
    static interface Sister{
        void sing();
    }
    // 需要动态代理的实际对象
   static class Tom implements Sister{
       @Override
       public void sing() {
           System.out.println("I am Tom. ");
       }
   }
    // 需要动态代理的实际对象
    static class Jim implements Sister{
        @Override
        public void sing() {
            System.out.println("I am Jim. ");
        }
    }
    /**
     * JDK proxy 动态代理步骤
     * 创建一个实现接口 InvocationHandler 的类，它必须实现 invoke 方法；
     * 创建被代理的类以及接口；
     * 通过 Proxy 的静态方法 newProxyInstance(ClassLoaderloader, Class[] interfaces, InvocationHandler h)创建一个代理；
     * 通过代理调用要执行的方法。
     **/
   static class ProxyCheng implements InvocationHandler{
        //要代理的真实对象
        private Object target;
        //构造方法，给要代理的真实对象赋初值
        public ProxyCheng(Object target) {
            this.target = target;
        }
        public Object getInstance(){
            Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this );
            return o;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("introduce yourself...");
            // 执行调用方法（此方法执行前后，可以进行相关业务处理）
            Object result = method.invoke(target,args);
            System.out.println("score...");
            return result;
        }
    }
    public static void main(String[] args) {
        //创建被代理类的对象
        Sister T1 = new Tom();
        //创建代理类的对象
        ProxyCheng proxyCheng= new ProxyCheng(T1);
        //获取动态代理类实例
        Sister proxySister = (Sister) proxyCheng.getInstance();
        System.out.println("JDK Dynamic object name: " + proxySister.getClass().getName());
        proxySister.sing();

        /**
         * JDK Dynamic object name: com.coding.wbp.$Proxy0
         * introduce yourself...
         * I am wanqian.
         * score...
         *结果分析：
         * 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的 handler 对象的 invoke 方法来进行调用；
         * 即当执行 proxySister.sing();会自动调用 ProxyCheng 的 invoke 方法。
         **/

    }


}
