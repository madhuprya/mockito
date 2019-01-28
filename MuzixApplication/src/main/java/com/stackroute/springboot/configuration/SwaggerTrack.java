package com.stackroute.springboot.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerTrack {


    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.springboot"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo=new ApiInfo(
            "Spring boot server example",
                "Spring boot Swager Example for youtube",
                "1.0",
                "Terms of services",
                 new Contact("Track","http://www.youtube.com/stackroute","abc@gmail.com"),
                "Apache License Version 2.0",
                "http://www.apache.org.license.html"
        );
        return apiInfo;

    }
}
