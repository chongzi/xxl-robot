package com.xxl.robot;

 import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 《用户中心》包含用户信息及权限
 * 
 * @author xuxuelei
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@ComponentScan(basePackages={"com.xxl.*"})
public class RobotApplication {
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(RobotApplication.class);
 		builder.headless(false)
 				.run(args);
	}



}


