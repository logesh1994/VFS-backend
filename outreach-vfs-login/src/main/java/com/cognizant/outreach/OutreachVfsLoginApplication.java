package com.cognizant.outreach;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.cognizant.outreach.vfs")
public class OutreachVfsLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutreachVfsLoginApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("apis")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/vfs/api.*"))
                .build();
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("VFS Login REST API Documentation")
                .description("Documents with Swagger 2")
                .termsOfServiceUrl("http://172.18.2.50:10205/outreach/signin")
                .contact(new Contact("VFS", "http://172.18.2.50:10205/outreach/signin", "512641@cognizant.com"))
                .license("")
                .licenseUrl("")
                .version("1.0")
                .build();
    }

}
