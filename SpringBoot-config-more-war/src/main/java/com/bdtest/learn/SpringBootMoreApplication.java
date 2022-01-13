package com.bdtest.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan
//@SpringBootConfiguration
//public class SpringBootMoreApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootMoreApplication.class, args);
//	}
//
//}

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
@SpringBootConfiguration
public class SpringBootMoreApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootMoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMoreApplication.class, args);
	}

}
