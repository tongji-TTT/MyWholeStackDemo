package com.example.backend.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableOpenApi
public class SwaggerConfiguration {
    //读取application.properties 文件设置的是否开启swagger属性，正式环境通常须要关闭
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .apiInfo(apiInfo())
                // 是否开启swagger
                .enable(swaggerEnabled)
                .select()
                // 过滤条件，扫描指定路径下的文件
                .apis(RequestHandlerSelectors.basePackage("com.example.backend.Controller"))
                //只保留/user/*风格的路径，你们能够调试一下
                //.paths(PathSelectors.ant("/user/*"))
                // 指定路径处理，PathSelectors.any()表明不过滤任何路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("全栈项目demo")
                .description("drt")
                // 开发者信息
                //.contact(new Contact("楼兰胡杨", "https://www.cnblogs.com/east7/", "wienerXXX@163.com"))
                .version("1.0.0")
                .build();
    }
}
