package com.xxl.robot;

import com.xxl.robot.service.RobotPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 《人工智能中心》
 *
 * @author xuxuelei
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages={"com.xxl.*"})
public class RobotApplication {
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(RobotApplication.class);
 		builder.headless(false)
 				.run(args);
	}



}


