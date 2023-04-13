package com.skcx.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 生成接口文档配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.enable}")
    private Boolean enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 开关，可以写到配置文件中
                .enable(enable)
                // 下方定义的方法
                .apiInfo(apiInfo())
                .select()
                // 指明包下的类、方法 放到api文档中
                .apis(RequestHandlerSelectors.basePackage("com.skcx.order.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("订单管理系统api")
                .description("订单管理系统api")
                // 服务的访问地址
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }

}
