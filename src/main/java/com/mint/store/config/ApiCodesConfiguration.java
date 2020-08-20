package com.mint.store.config;

import com.mint.store.factory.YamlAndPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
@Configuration
@PropertySource(value = "classpath:/config/api-codes.yml", factory = YamlAndPropertySourceFactory.class)
@ConfigurationProperties(prefix = "api")
public class ApiCodesConfiguration {
  private Map<Integer, String> codes = new HashMap<>();

  public ApiCodesConfiguration() {
  }
  public Map<Integer, String> getCodes() {
    return codes;
  }

  public void setCodes(Map<Integer, String> codes) {
    this.codes = codes;
  }

  public String getMessage(int code) {
    return this.codes.get(code);
  }
}
