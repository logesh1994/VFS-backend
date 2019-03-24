package com.cognizant.outreach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cognizant.outreach.vfs")
public class OutreachVfsBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutreachVfsBatchApplication.class, args);
	}

//	@Bean
//    public Docket newsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("apis")
//                .apiInfo(apiInfo())
//                .select()
//                .paths(regex("/vfs/api.*"))
//                .build();
//    }
//	
//	private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("VFS REST API Documents")
//                .description("Documents with Swagger 2")
//                .termsOfServiceUrl("http://cognizant.com")
//                .contact(new Contact("VFS", "http://cognizant.com", "512641@cognizant.com"))
//                .license("")
//                .licenseUrl("")
//                .version("1.0")
//                .build();
//    }
}
