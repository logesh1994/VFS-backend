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

}
