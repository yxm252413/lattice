package com.lattice.latticezuul.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 10:25
 **/
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

  @Override
  public List<SwaggerResource> get() {
    List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
    String[] models = {"user", "order", "goods", "category", "mail", "others", "payment", "redis",
        "search"};
    for (String model : models) {
      resources.add(swaggerResource(model, "/" + model + "/v2/api-docs", "1.0"));
    }
    return resources;
  }

  private SwaggerResource swaggerResource(String name, String location, String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion(version);
    return swaggerResource;
  }
}
