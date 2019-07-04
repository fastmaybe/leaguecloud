### Spring Cloud学习简介
    在springboot,对于springcloud下的技术使用一般起步步骤
        1，添加依赖
        2，启动类支持  @Enable***
#### Eureka 服务注册与发现    
    可参见代码  注释详细
#### Ribbon 负载均衡
      ribbon负载均衡在客户端  即算法逻辑判断在客户端
    可自定负载均衡算法 
      注意：
       自定义  ribbon负载均衡算法
       * 1  在启动类添加 @RibbonClient(name = "LEAGUECLOUD-DEPT（微服务名）",configuration = MySelfRule.class)
       * 2  注意MySelfRule  不能再ComponentScan 可以扫描的包下  在springboot中 即是 需要在启动类上级路径下
#### Feign
    是一个声明式Webservice客户端，，使得编写web服务客户端变得非常容易    
    ==只需要创建一个接口，然后再上面添加注解即可==
     面向接口编程，比如webservice接口
     
     Feign如果整合了Ribbon  自带负载均衡  算法为轮询  
#### Hystrix 断路器     
##### 服务熔断 （在服务端）
    一般是某个服务故障或者异常引起，类似于现实世界中的'保险丝'，当某个异常条件被触发，直接熔断整个服务，而不是一直等到此服务超时
##### 服务降级  （在客户端）
    降级一般从整体负荷考虑。就是当某个服务熔断降级，或者人工宕机，总之服务将不再可用，不再被调用，
    此时客户端可用自己准备的本地的fallback回调，返回一个缺省值。
    服务虽然水平下降  但服务依旧'可用'   
    
#### HystrixDashboard  仪表盘
    主要 监视微服务的'健康'状况
    
#### zuul路由网关
    Zuul包含了对请求的==路由和过滤==的主要功能：  
    路由功能   
    主要负责将外部请求转发到具体的微服务上，是实现外部访问入口的基础   
    过滤功能  
    负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础   
    Zuul与Eureka进行整合，将==Zuul自身注册为Eureka==服务治理下的应用，同事从Eureka中获得其他微服务的信息，也即以后的微服务访问都是通过Zuul跳转后获得。  
    ==三大功能----==代理、路由、过滤   
    
#### SpringCloud Config 分布式配置中心    
     集中式的、动态的配置管理，分布式系统的配置
     
##### 注意
    在spring-cloud-config时候
    进行远程 dev test切换时候
    spring:
      profiles:
        active: 
        - dev   (注意此处前面横岗空格)
    ---
    server: 
      port: 8201
    spring:
      profiles: dev #开发环境
      application:
        name: springcloud-study-config-client
    
    eureka:
      client:
        service-url:
          defaultZone: eureka7001.com:7001/eureka
    ---
    server: 
      port: 8202
    spring:
      profiles: test #开发环境
      application:
        name: springcloud-study-config-client
    
    eureka:
      client:
        service-url:
          defaultZone: eureka7001.com:7001/eureka
    #请保存为UTF-8格式