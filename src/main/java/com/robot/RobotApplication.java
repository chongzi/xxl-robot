package com.xxl.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 《用户中心》包含用户信息及权限
 * 
 * @author xuxuelei
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages={"com.xxl.*"})
public class AuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

		
	
}
