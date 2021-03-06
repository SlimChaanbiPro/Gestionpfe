package com.slim.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Firas gorrab API").description("Firas gorrab API reference for front developers")
                .termsOfServiceUrl("http://www.dpc.com.tn").contact("https://www.facebook.com/firas.gorrab")
                .license("Firas gorrab API License").licenseUrl("https://www.facebook.com/firas.gorrab").version("1.0").build();
    }

}
