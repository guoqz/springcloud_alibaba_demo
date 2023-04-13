//package com.skcx.goods.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//@Configuration
//@EnableSwagger2WebMvc
//public class Knife4jConfig {
//
//    @Value("${knife4j.enable}")
//    private Boolean enable;
//
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .enable(enable)
//                .apiInfo(apiInfo())
//                //分组名称
//                .groupName("2.X版本")
//                .select()
//                //这里指定Controller扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("com.skcx.goods.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("商品管理系统api")
//                .description("商品管理系统api")
//                // 服务的访问地址
//                .termsOfServiceUrl("")
//                .version("1.0.0")
//                .build();
//    }
//}
