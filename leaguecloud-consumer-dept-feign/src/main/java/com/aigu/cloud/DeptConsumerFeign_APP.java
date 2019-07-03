package com.aigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "LEAGUECLOUD-DEPT",configuration = MySelfRule.class)
@EnableFeignClients(basePackages = {"com.aigu.cloud"})
//@ComponentScan(basePackages= {"com.aigu.cloud"})
public class DeptConsumerFeign_APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_APP.class,args);
    }
}
