package com.lattice.eurekatwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
public class EurekaTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTwoApplication.class, args);
	}
}