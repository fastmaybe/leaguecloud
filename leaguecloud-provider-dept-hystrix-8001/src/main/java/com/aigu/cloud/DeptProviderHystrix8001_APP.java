package com.aigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 此为服务熔断
 *
 *
 * 服务熔断 和 服务降级比较
 *
 *
 * 第一点：
 *          服务熔断在服务端
 *          服务降级在客户端
 * 第二点：
 *          服务熔断 ： 注重于调用服务出现错误  返回fallback  解决服务扇形调用引起的服务雪崩；
 *          服务降级 ： 着重于 在某些情况下 比如服务器资源紧张 舍弃某些服务情况下（丢车保帅）
 *                      在客户端访问舍弃的服务（宕机）发现不可用时候  返回预设好的值（比如：服务升级,请稍后访问）
 */
@SpringBootApplication
@EnableEurekaClient   //申明是微服务客户端
@EnableCircuitBreaker
public class DeptProviderHystrix8001_APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001_APP.class,args);
    }
}
