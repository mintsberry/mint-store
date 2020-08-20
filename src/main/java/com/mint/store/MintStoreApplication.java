package com.mint.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author LingXi
 */

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MintStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(MintStoreApplication.class, args);
  }

}
