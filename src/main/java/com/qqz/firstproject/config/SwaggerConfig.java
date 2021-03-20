package com.qqz.firstproject.config;/*
@Author qqz
@create 2020-02-10  22:06
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.qqz.firstproject.controller"})
@EnableSwagger2
@Configuration
@EnableWebMvc
public class SwaggerConfig {
    private ApiInfo apiInfo(){
        Contact contact = new Contact ( "qqz","none","1463080241@qq.com" );
        return new ApiInfoBuilder ()
                .title ( "项目API接口" )
                .description ( "API接口" )
                .contact ( contact )
                .version ( "1.1.0" ).build ();
    }
    @Bean
    public Docket customDocket(){
        return new Docket ( DocumentationType.SWAGGER_2 ).apiInfo ( apiInfo() );
    }

}
