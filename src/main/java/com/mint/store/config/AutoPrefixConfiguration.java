package com.mint.store.config;

import com.mint.store.handler.AutoPrefixUrlHandler;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
@Configuration
public class AutoPrefixConfiguration implements WebMvcRegistrations {
  @Override
  public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
    return new AutoPrefixUrlHandler();
  }
}
