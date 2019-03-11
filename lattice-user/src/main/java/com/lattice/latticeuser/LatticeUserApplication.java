package com.lattice.latticeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Description:    启动LatticeUser
 * @Author:         张家豪
 * @CreateDate:     2018/11/18 9:06
 * @UpdateUser:     张家豪
 * @UpdateDate:     2018/11/18 9:06
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 * 
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableSwagger2
@MapperScan(value = "com.lattice.latticeuser.dao")
public class LatticeUserApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(LatticeUserApplication.class, args);
	}
}
