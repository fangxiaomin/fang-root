package com.fang.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class FangRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangRibbonServiceApplication.class, args);
    }

    /**
     * @Description:  RestTemplate是用来发送请求的，@LoadBalanced表明这个RestTemplate开启负载均衡功能，默认使用轮训算法
     **/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    那么如何来修改ribbon使用的负载均衡算法呢？
//    直接在启动类中注入一个bean ，IRule ，然后创建你想使用的轮训策略的实例就可以了，这里使用的是RandomRule，随机策略


    //1.轮询（Round Robin）：一个替一个访问,使用synchronized，这将会导致该段轮询代码的并发吞吐量发生明显的下降。
//    (com.netflix.loadbalancer.RoundRobinRule)
    //2.随机算法：通过一定范围的随机数来分发请求给相应的tomcat.当请求量很大时，其实就很接近轮询了(com.netflix.loadbalancer.RandomRule)
    //3.源地址哈希：通过请求来源的IP计算相应的hashCode和服务器数量进行取模，最终来分发给相应的Tomcat,只要IP不发生变动请求分发的Tomcat也就固定了
    //    源地址哈希法的优点在于：保证了相同客户端IP地址将会被哈希到同一台后端服务器。根据此特性可以在服务消费者与服务提供者之间建立有状态的session会话，一旦有服务器上线、下线那么服务器数量改变，所有的都会映射失败。
    //4.加权轮询：在轮询的基础上增加权重，权重假如说是1：2，那么发送1号机子上1次，发送2号机子上就是2次
    //5.加权随机法(Weight Random)：跟加权轮询类似一样的做法 ,那么tomcat随机分发的时候分发的几率就增大
    //6.最小连接数法：根据后端服务器当前的连接情况，动态的选取当前积压连接数最少的一台服务器来处理当前请求。(com.netflix.loadbalancer.BestAvailableRule)

    //与配置文件  NFLoadBalancerRuleClassName  属性作用一致。。。。
    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }

}
