package com.mint.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author LingXi
 */
@SpringBootApplication()
@EnableOpenApi
public class MintStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(MintStoreApplication.class, args);
  }

}
