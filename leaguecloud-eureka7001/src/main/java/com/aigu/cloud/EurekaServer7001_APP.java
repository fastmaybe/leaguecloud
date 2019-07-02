package com.aigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //标识作为服务端启动 接收其他为服务注册进来
public class EurekaServer7001_APP {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_APP.class,args);
    }
}
