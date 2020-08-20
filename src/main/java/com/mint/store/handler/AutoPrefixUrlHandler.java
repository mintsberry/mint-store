package com.mint.store.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
public class AutoPrefixUrlHandler extends RequestMappingHandlerMapping {
  @Value("${api.basePackage}")
  private String basePack;
  @Override
  protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
    RequestMappingInfo mappingForMethod = super.getMappingForMethod(method, handlerType);
    if (mappingForMethod != null) {
      String prefix = this.getPrefix(handlerType);
      return RequestMappingInfo.paths(prefix).build().combine(mappingForMethod);
    }
    return null;
  }

  private String getPrefix(Class<?> handleType) {
    String packName = handleType.getPackage().getName();
    if (packName.startsWith(basePack)) {
      return packName.replaceAll(basePack, "").replace(".", "/");
    }
    return "";
  }
}
