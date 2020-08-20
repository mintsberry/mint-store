package com.mint.store.config;

import com.mint.store.MintStoreApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
class ApiCodesConfigurationTest extends MintStoreApplicationTests {
  @Autowired
  private ApiCodesConfiguration apiCodesConfiguration;

  @Test
  void apiCodes() {
    System.out.println(apiCodesConfiguration.getCodes());
  }
}