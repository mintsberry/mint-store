package com.mint.store.service;

import com.mint.store.model.User;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public interface UserService {
  User getUserById(Long uid);
}
