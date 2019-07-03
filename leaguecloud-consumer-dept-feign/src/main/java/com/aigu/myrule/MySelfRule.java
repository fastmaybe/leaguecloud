package com.aigu.myrule;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义  ribbon负载均衡算法
 * 1  在启动类添加 @RibbonClient(name = "LEAGUECLOUD-DEPT",configuration = MySelfRule.class)
 * 2  注意MySelfRule  不能再ComponentScan 可以扫描的包下  在springboot中 即是 需要在启动类上级路径下
 */
@Configuration
public class MySelfRule {



    @Bean
    public IRule myRule(){
         return new RanDomRUle_YJ();//三次一随机

//        return new RetryRule(); //如果服务都是好的，就是轮询 当服务宕机  几次请求不到的时候 就会跳过宕机的服务
    }
}
