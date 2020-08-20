package com.mint.store.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.cglib.core.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
@Configuration
public class Swagger3Config {
  @Bean("apiV1")
  public Docket createRestApiV1() {
    return new Docket(DocumentationType.OAS_30)
            .groupName("v1")
            .apiInfo(apiInfo())
            .select()
            //指定包名的方式
            .apis(RequestHandlerSelectors.basePackage("com.mint.store.api.v1"))
//            .apis(RequestHandlerSelectors.any())
            //筛选 API 的 URL 来进行过滤
            .paths(PathSelectors.any())
            .build();
  }

  @Bean("apiV2")
  public Docket createRestApiV2() {
    return new Docket(DocumentationType.OAS_30)
            .groupName("v2")
            .apiInfo(apiInfo())
            .select()
            //指定包名的方式
            .apis(RequestHandlerSelectors.basePackage("com.mint.store.api.v2"))
//            .apis(RequestHandlerSelectors.any())
            //筛选 API 的 URL 来进行过滤
            .paths(PathSelectors.any())
            .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Store接口")
            .description("RESTful接口")
            .contact(new Contact("Mint", "https://github.com/mintsberry", "Mintberfly@gmail.com"))
            .version("版本号:1.0")
            .build();
  }
}