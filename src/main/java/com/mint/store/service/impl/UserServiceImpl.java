package com.mint.store.service.impl;

import com.mint.store.model.User;
import com.mint.store.repository.UserRepository;
import com.mint.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;
  @Override
  public User getUserById(Long uid) {
    User user = userRepository.findFirstById(uid);
    return user;
  }
}
