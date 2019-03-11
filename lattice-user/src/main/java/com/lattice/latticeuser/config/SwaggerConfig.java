package com.lattice.latticeuser.config;

import org.springframework.context.annotation.Configuration;

import com.lattice.latticecommon.config.BaseSwaggerConfig;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-14 20:34
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {


    @Override
    public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
            .title("user模块")
				.description("购物系统用户模块接口文档说明")
				.termsOfServiceUrl("http://localhost:8222")
            .version("1.0")
            .build();
	}
}

