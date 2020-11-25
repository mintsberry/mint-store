package com.mint.store.util;

import com.mint.store.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public class LocalUser {
  private static ThreadLocal<Map<String, Object>> local = new ThreadLocal<>();
  public static User getUser() {
    Map<String, Object> map = local.get();
    User user = (User) map.get("user");
    return user;
  }

  public static Integer getScope() {
    Map<String, Object> map = local.get();
    Integer scope = (Integer) map.get("scope");
    return scope;
  }

  public static void set(User user, String scope) {
    Map<String, Object> map = new HashMap<>(2);
    map.put("user", user);
    map.put("scope", scope);
    LocalUser.local.set(map);
  }

  public static void clear() {
    LocalUser.local.remove();
  }
}
