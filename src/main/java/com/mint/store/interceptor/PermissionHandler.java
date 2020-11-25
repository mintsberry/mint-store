package com.mint.store.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.mint.store.annotations.ScopeLevel;
import com.mint.store.exception.ForbiddenException;
import com.mint.store.exception.UnAuthenticatedException;
import com.mint.store.model.User;
import com.mint.store.service.UserService;
import com.mint.store.util.JwtUtil;
import com.mint.store.util.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
@Component
public class PermissionHandler extends HandlerInterceptorAdapter {
  @Autowired
  private UserService userService;
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    Integer scopeLevel = this.getScopeLevel(handler);
    if (scopeLevel == 0) {
      return true;
    }
    String authorization = request.getHeader("Authorization");
    if (StringUtils.isEmpty(authorization)) {
      throw new UnAuthenticatedException(10004);
    }
//    String token = authorization.split(" ")[1];
    Optional<Map<String, Claim>> claims = JwtUtil.getClaims(authorization);
    Map<String, Claim> claimMap = claims.orElseThrow(() -> new UnAuthenticatedException(10004));
    Integer scope = claimMap.get("scope").asInt();
    Boolean flag = this.isPermission(scope, scopeLevel);
    if (!flag) {
      throw new ForbiddenException(10005);
    } else {
      this.setToThreadLocal(claimMap);
    }
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    LocalUser.clear();
    super.afterCompletion(request, response, handler, ex);
  }

  private Boolean isPermission(Integer scope, Integer scopeLevel) {
    return scope >= scopeLevel;
  }

  private Integer getScopeLevel(Object handler) {
    if (handler instanceof HandlerMethod) {
      HandlerMethod methodHandle = (HandlerMethod) handler;
      ScopeLevel scopeLevel = methodHandle.getMethodAnnotation(ScopeLevel.class);
      if (scopeLevel == null) {
        return 0;
      }
      return scopeLevel.value();
    }
    return 0;
  }

  private void setToThreadLocal(Map<String, Claim> map) {
    Long uid = map.get("uid").asLong();
    String scope = map.get("scope").asString();
    User user = userService.getUserById(uid);
    LocalUser.set(user, scope);
  }
}
