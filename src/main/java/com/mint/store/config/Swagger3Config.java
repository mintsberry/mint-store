package com.mint.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

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
            .build()
            .securitySchemes(securitySchemes())
            .securityContexts(securityContexts());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Store接口")
            .description("RESTful接口")
            .contact(new Contact("Mint", "https://github.com/mintsberry", "Mintberfly@gmail.com"))
            .version("版本号:1.0")
            .build();
  }

  private List<SecurityScheme> securitySchemes() {
    //设置请求头信息
    List<SecurityScheme> result = new ArrayList<>();
    SecurityScheme scheme = new ApiKey("Authorization", "Authorization", "header");
    result.add(scheme);
    return result;
  }

  private List<SecurityContext> securityContexts() {
    //设置需要登录认证的路径
    List<SecurityContext> result = new ArrayList<>();
    result.add(getContextByPath("/*.*"));
    return result;
  }

  private SecurityContext getContextByPath(String pathRegex){
    return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex(pathRegex))
            .build();
  }

  private List<SecurityReference> defaultAuth() {
    List<SecurityReference> result = new ArrayList<>();
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    result.add(new SecurityReference("Authorization", authorizationScopes));
    return result;
  }
}