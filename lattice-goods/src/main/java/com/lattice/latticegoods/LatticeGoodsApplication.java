package com.lattice.latticegoods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableSwagger2
@EnableCaching
@MapperScan(value = "com.lattice.latticegoods.dao")
public class LatticeGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatticeGoodsApplication.class, args);
	}
}
