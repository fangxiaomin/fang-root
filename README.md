# fang-root
个人练手测试项目
#本项目旨在熟练 springcloud 全家桶。根据springcloud 的相关组件逐一新建相关模块进行代码开发测试。
1、为何要学习Spring cloud 
- 随着业务逐渐发展，产品思想会变得越来越复杂，单体结构的应用也会越来越复杂，微服务架构逐渐取代了单体架构，且这种趋势将会越来越流行。Spring Cloud是目前最常用的微服务开发框架，已经在企业级开发中大量的应用。

2、什么是Spring Cloud
- Spring Cloud是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、智能路由、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。通过Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

3、设计目标与优缺点
 
- 3.1 目标：旨在协调各个微服务，简化分布式系统开发。
- 3.2 优缺点： 
  
   - 3.2.1  微服务的框架那么多比如：dubbo、Kubernetes，为什么就要使用Spring Cloud的呢？
   
   - 3.2.2  优点：
  
      - 产出于Spring大家族，Spring在企业级开发框架中无人能敌，来头很大，可以保证后续的更新、完善
      
      - 轻轻松松几行代码，注解或者配置就完成了熔断、负载均衡、注册中心的各种平台功能
      
      - Spring Cloud 社区活跃度很高，教程很丰富，遇到问题很容易找到解决方案
      
      - 服务拆分粒度更细，耦合度比较低，有利于资源重复利用，有利于提高开发效率
      
      - 可以更精准的制定优化服务方案，提高系统的可维护性
      
      - 减轻团队的成本，可以并行开发，不用关注其他人怎么开发，先关注自己的开发
      
      - 微服务可以是跨平台的，可以用任何一种语言开发
     
     - 适于互联网时代，产品迭代周期更短
    
   - 3.2.3 缺点：

     - 微服务过多，治理成本高，不利于维护系统
  
     - 分布式系统开发的成本高（容错，分布式事务等）对团队挑战大

4 、整体架构

![img.png](img.png)


5、主要项目
  
Spring Cloud的子项目，大致可分成两类，一类是对现有成熟框架"Spring Boot化"的封装和抽象，也是数量最多的项目；第二类是开发了一部分分布式系统的基础设施的实现，如Spring Cloud Stream扮演的就是kafka, ActiveMQ这样的角色。

### Spring Cloud Config
  集中配置管理工具，分布式系统中统一的外部配置管理，默认使用Git来存储配置，可以支持客户端配置的刷新及加密、解密操作。
### Spring Cloud Netflix
  Netflix OSS 开源组件集成，包括Eureka、Hystrix、Ribbon、Feign、Zuul等核心组件。

   - Eureka：服务治理组件，包括服务端的注册中心和客户端的服务发现机制；
   - Ribbon：负载均衡的服务调用组件，具有多种负载均衡调用策略；
   - Hystrix：服务容错组件，实现了断路器模式，为依赖服务的出错和延迟提供了容错能力；
   - Feign：基于Ribbon和Hystrix的声明式服务调用组件；
   - Zuul：API网关组件，对请求提供路由及过滤功能。

### Spring Cloud Bus
用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。
### Spring Cloud Consul
基于Hashicorp Consul的服务治理组件。
### Spring Cloud Security
安全工具包，对Zuul代理中的负载均衡OAuth2客户端及登录认证进行支持。
### Spring Cloud Sleuth
Spring Cloud应用程序的分布式请求链路跟踪，支持使用Zipkin、HTrace和基于日志（例如ELK）的跟踪。
### Spring Cloud Stream
轻量级事件驱动微服务框架，可以使用简单的声明式模型来发送及接收消息，主要实现为Apache Kafka及RabbitMQ。
### Spring Cloud Task
用于快速构建短暂、有限数据处理任务的微服务框架，用于向应用中添加功能性和非功能性的特性。
### Spring Cloud Zookeeper
基于Apache Zookeeper的服务治理组件。
### Spring Cloud Gateway
API网关组件，对请求提供路由及过滤功能。
### Spring Cloud OpenFeign
基于Ribbon和Hystrix的声明式服务调用组件，可以动态创建基于Spring MVC注解的接口实现用于服务调用，在Spring Cloud 2.0中已经取代Feign成为了一等公民。
### Spring Cloud的版本关系
#### Spring Cloud和SpringBoot版本对应关系
![img_1.png](img_1.png)
  
#### Spring Cloud和各子项目版本对应关系
![img_2.png](img_2.png)
  注意：Hoxton版本是基于SpringBoot 2.2.x版本构建的，不适用于1.5.x版本。随着2019年8月SpringBoot 1.5.x版本停止维护，Edgware版本也将停止维护。

6、Spring Boot的关系

- Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务，Spring Cloud是一个基于Spring Boot实现的云应用开发工具。Spring -> Spring Boot > Spring Cloud 这样的关系。
- Spring Boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring Boot，属于依赖的关系
- Spring Boot专注于快速、方便集成的单个个体微服务，Spring Cloud是关注全局的服务治理框架
- Spring Boot使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，Spring Cloud很大的一部分是基于Spring Boot来实现，可以不基于Spring Boot吗？不可以


# 根据以上思路，搭建了本项目。本项目是一个微服务架构的项目。然后根据组件一步一步来进行的。

## 1.创建root跟项目。该模块是父模块。管理所有的子服务
## 2.搭建Eureka注册中心  (fang-eureka)
 - 引入jar包
```<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
   </dependency>
```
 - 在启动类加上@EnableEurekaServer注解来启用Euerka注册中心功能
 - 在配置文件添加相关的配置表明这是注册中心（配置见代码，模块： fang-eureka ）
 - 可以引入spring-boot-starter-security 依赖，这样就需要密码登录后台，默认情况下添加SpringSecurity依赖的应用每个请求都需要添加CSRF token才能访问，Eureka客户端注册时并不会添加，所以需要配置/eureka/**路径不需要CSRF token。
## 2.搭建业务模块，也是Eureka 的客户端 ( fang-user  fang-order fang-common-starter ) 
 这里我首先创建了 fang-modules 模块  来统一管理所有的业务模块。然后再该模块下面搭建业务模块，
 我这里暂时只有 fnag-order(订单) 和 fang-user（用户） 2个模块。同时创建了common-starter 模块,该模块主要是一些公共的jar包和一些工具类等
 - 在common 引入jar
```
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   <dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
   </dependency>
 ```
- 在启动类上添加@EnableDiscoveryClient注解表明是一个Eureka客户端
- 配置文件添加Eureka客户端的配置
 #### Eureka注册中心集群,可以修改端口，启动2个，然后再客户端的配置文件配置多个地址即可。打开注册中心页面，就可以看到相关的服务已经注册了。
## 3.Ribbon服务消费者   ( fang-ribbon-service  )
负载均衡 。。。微服务架构中，很多服务都会部署多个。其他服务去调用该服务的时候，如何保证负载均衡是个不得不去考虑的问题。负载均衡可以增加系统的可用性和扩展性.
Ribbon就很好的实现了负载均衡。
- 需要添加的依赖
```
   <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

```
- 因为还未使用feign,此处我们就先使用 RestTemplate 来调用服务。模块是 fang-ribbon-service 在启动类需要开启RestTemplate负载均衡功能。
- 启动2个user模块，然后调用。可以看到交替请求。
- ribbon 的常用配置主要有：重试次数、超时时间、负载均衡算法等等。
## 4.Hystrix断路器  （ fang-hystrix ）
Hystrix具备服务降级、服务熔断、线程隔离、请求缓存、请求合并及服务监控等强大功能。
- 需要的依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```
- 启动类上添加@EnableCircuitBreaker来开启Hystrix的断路器功能
- 业务代码可以实现 降级，忽略某些异常、分组、线程池、请求缓存、请求合并等功能，具体见 HystrixServiceImpl
- 配置文件可以配置上一条需要的相关参数
## 5.Hystrix Dashboard与Turbine断路器监控 （ fang-hystrix-dashboard ）
 上面已经集成了Hystrix,但是需要实时监控HystrixCommand方法的执行情况，Hystrix提供了Hystrix Dashboard。Hystrix Dashboard可以有效地反映出每个Hystrix实例的运行情况，帮助我们快速发现系统中的问题，从而采取对应措施。

 展示hystrix实例监控信息的仪表盘
- 需要的依赖。
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
- 启动类上添加@EnableHystrixDashboard来启用监控功能：
- 被监控的hystrix-service服务需要开启Actuator的hystrix.stream端点，见fang-hystrix得配置文件
- 访问Hystrix Dashboard：http://localhost:7076/hystrix
- 监控页面图，http://localhost:7075/actuator/hystrix.stream  title为：hystrix-client
![img_3.png](img_3.png)
  
### 微服务一般是集群，则需要 Turbine来聚合hystrix-service服务的监控信息 （ fang-urbine-service ）

聚合收集hystrix实例监控信息的服务
- 添加依赖spring-cloud-starter-netflix-turbine
- 配置Turbine相关配置，见fang-urbine-service配置文件
- 启动类上添加@EnableTurbine来启用Turbine相关功能
- 集群地址：http://localhost:7077/tuebine.stream title为：hystrix-client。可以看到监控实例是多个
## 6.OpenFeign服务消费者 
&nbsp;&nbsp;&nbsp;
Spring Cloud OpenFeign 是声明式的服务调用工具，它整合了Ribbon和Hystrix，拥有负载均衡和服务容错功能.需要加上依赖：spring-cloud-starter-openfeign
在启动类上添加@EnableFeignClients注解来启用Feign的客户端功能。
-  通过@FeignClient注解实现了一个Feign客户端，其中的value为user-service表示这是对user-service服务的接口调用客户端。
-  添加服务降级实现类UserFallbackService
- 配置文件添加 ribbon相关的配置
-  在配置文件开启Hystrix功能:
```
   feign.hystrix.enabled: true
```
## 7.-Zuul服务网关 （fang-gateway）
API网关为微服务架构中的服务提供了统一的访问入口，客户端通过API网关访问相关服务。API网关的定义类似于设计模式中的门面模式，它相当于整个微服务架构中的门面，所有客户端的访问都通过它来进行路由及过滤。
- 它实现了请求路由、负载均衡、校验过滤、服务容错、服务聚合等功能。
- 添加依赖：spring-cloud-starter-netflix-zuul
- 启动类上添加@EnableZuulProxy注解来启用Zuul的API网关功能
- 在配置文件配置路由规则，可以设置统一访问前缀、关闭默认规则等等规则都可以配置
- 自定义的过滤器类型，添加OwnZuulFilter类继承ZuulFilter，访问：http://localhost:9200/api/orderService/order/getWay
- 通过SpringBoot Actuator来查看Zuul中的路由信息，通过访问http://localhost:9200/actuator/routes查看简单路由信息：
## 8.Config分布式配置中心  （fang-config-server   fang-config-client）
 springcloud config 分为服务端和客户端 2个部分，服务端分为分布式配置中心
是一个独立的应用。主要是从配置仓库获取配置信息并提供给客户端使用。也就是说，服务端必须开启。
一般存储在git仓库。
- 添加相关的依赖
- 启动类上添加@EnableConfigServer注解来启用配置中心功能
- 服务端配置文件添加配置：仓库地址，用户名，密码等
- 客户端配置文件可以配置：分支，环境，文件夹等信息
- 刷新配置：添加Actuator的依赖，然后在bootstrap.yml中开启refresh端点，在controller 里面添加@RefreshScope注解用于刷新配置
- 每次更改需要调用刷新接口进行刷新，无法动态
## 9.Bus消息总线
Spring Cloud Bus 配合 Spring Cloud Config 使用可以实现配置的动态刷新。目前 Spring Cloud Bus 支持两种消息代理：RabbitMQ 和 Kafka
Spring Cloud Bus 通过轻量消息代理连接各个分布的节点
- 需要RabbitMQ
- config服务端添加依赖  spring-cloud-starter-bus-amqp
- config服务端配置文件添加rabbitmq配置
- 暴露了刷新配置的Actuator端点
- 客户端添加相关依赖 spring-cloud-starter-bus-amqp
- 客户端添加rabbitmq配置
- 启动相关服务，然后登录rabbitMQ后台，会发现springCloudBus的交换机及三个以 springCloudBus.anonymous开头的队列
- 当配置文件修改了：调用暴露的端点刷新所有配置：http://localhost:7079/actuator/bus-refresh
- 配合WebHooks使用，WebHooks相当于是一个钩子函数，我们可以配置当向Git仓库push代码时触发这个钩子函数。当我们向配置仓库push代码时就会自动刷新服务配置了
## 10.Sleuth服务链路跟踪 （ order 和  user 来演示）
Spring Cloud Sleuth 是分布式系统中跟踪服务间调用的工具，它可以直观地展示出一次请求的调用过程。Zipkin是Twitter的一个开源项目，可以用来获取和分析Spring Cloud Sleuth 中产生的请求链路跟踪日志，它提供了Web界面来帮助我们直观地查看请求链路跟踪信息。
- 添加相关依赖spring-cloud-starter-zipkin
- 配置文件配置收集日志的zipkin-server访问地址，同时可设置收集率
- 下载zipkin的jar包。然后启动：java -jar zipkin-server-2.12.9-exec.jar，Zipkin页面访问地址：http://localhost:9411
- 启动相关的服务，然后多次请求，就可以看到完整的请求链路，每个服务的耗时等。
- 可以使用elk进行保存 追踪日志
- 安装Elasticsearch，安装可视化工具Kibana
- 修改启动参数将信息存储到Elasticsearch
```
  # STORAGE_TYPE：表示存储类型 ES_HOSTS：表示ES的访问地址
  java -jar zipkin-server-2.12.9-exec.jar --STORAGE_TYPE=elasticsearch --ES_HOSTS=localhost:9200
```
## 11.Consul服务注册发现与配置中心
Spring Cloud Consul 为 SpringBoot 应用提供了 Consul的支持，Consul既可以作为注册中心使用，也可以作为配置中心使用。
Spring Cloud Consul 具有如下特性：
- 支持服务治理：Consul作为注册中心时，微服务中的应用可以向Consul注册自己，并且可以从Consul获取其他应用信息；
- 支持客户端负责均衡：包括Ribbon和Spring Cloud LoadBalancer；
- 支持Zuul：当Zuul作为网关时，可以从Consul中注册和发现应用；
- 支持分布式配置管理：Consul作为配置中心时，使用键值对来存储配置信息；
- 支持控制总线：可以在整个微服务系统中通过 Control Bus 分发事件消息。
#### 使用Consul作为注册中心，
- 安装并运行Consul，首先我们从官网下载Consul，地址：https://www.consul.io/downloads.html
- 使用开发模式启动：(consul agent -dev) 通过以下地址可以访问Consul的首页：http://localhost:8500
- 将注册中心换成consul,依赖也改成Consul的，并添加SpringBoot Actuator的依赖
- 修改配置文件的注册中心，换成consul的
#### 使用Consul作为配置中心，
- 添加相关依赖：spring-cloud-starter-consul-config
- 配置文件：启动配置中心功能，格式、目录、分隔符、配置key的名字等
- 就可以获取配置文件的内容了
- Consul使用其**_自带的Control Bus_** 实现了一种事件传递机制，从而实现了**_动态刷新功能_**。使用Spring Cloud Config的时候，我们需要调用接口，通过Spring Cloud Bus才能刷新配置
## 12.Gateway服务网关
## 13.Admin服务监控中心


## Spring Cloud入门-Oauth2授权之JWT集成  （fang-oauth）
- 1.首先配置RedisTokenStoreConfig ，添加在Redis中存储令牌的配置：
    - 这个配置是Redis用来存储token，服务重启后，无需重新获取token
- 2.配置SecurityConfig
    - 添加SpringSecurity配置，允许授权相关路径的访问及表单登录
    - 获取token的时候参数grant_type 
    - 密码加密器等
- 3.配置ResourceServerConfig
  - 资源服务器配置
  -  配置需要保护的资源路径
- 4.配置AuthorizationServerConfig
  - 授权服务器配置
  - 配置认证管理器以及业务实现
    - 配置令牌存储策略
    - 配置业务处理service
    - 认证管理器
  - 配置认证规则，
    - 需要注意allowFormAuthenticationForClients 这个，允许通过get param方式进行验证。 如果不开放的话，就只能走Basic Auth验证。否则401
    - 不配置上面的，client_id 、client_secret传了也无法访问，http://localhost:7088/oauth/token
  - 配置客户端
      - 配置配置client_id 、client_secret、过期时间等
      - 配置作用域等
  - token解析网站：https://jwt.io/
    https://blog.csdn.net/weixin_38937840/article/details/90321037?utm_medium=distribute.pc_feed_404.none-task-blog-2~default~BlogCommendFromBaidu~default-6.nonecase&depth_1-utm_source=distribute.pc_feed_404.none-task-blog-2~default~BlogCommendFromBaidu~default-6.nonecas
        https://blog.csdn.net/qq_34490951/article/details/79930270?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-8.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-8.control
![img_4.png](img_4.png)