package com.aigu.cloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //配置负载均衡 算法  默认是轮询
    @Bean
    public IRule myRule(){
//        return new RandomRule();//随机

        return new RetryRule(); //如果服务都是好的，就是轮询 当服务宕机  几次请求不到的时候 就会跳过宕机的服务
    }

}
