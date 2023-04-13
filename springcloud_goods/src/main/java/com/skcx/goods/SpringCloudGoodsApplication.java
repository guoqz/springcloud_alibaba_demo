package com.skcx.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient  // 表示当前的微服务是服务注册中心服务的客户端
@SpringBootApplication
@MapperScan("com.skcx.goods.mapper")
public class SpringCloudGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGoodsApplication.class, args);
    }
}
