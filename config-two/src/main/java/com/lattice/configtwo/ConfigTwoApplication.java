package com.lattice.configtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableConfigServer
@RefreshScope
@EnableEurekaClient
public class ConfigTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigTwoApplication.class, args);
	}
}
