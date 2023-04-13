package com.skcx.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.skcx.order.feign")
public class SpringCloudOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderApplication.class, args);
    }
}
