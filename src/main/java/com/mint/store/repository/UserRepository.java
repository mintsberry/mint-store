package com.mint.store.repository;

import com.mint.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
public interface UserRepository extends JpaRepository<User, Long> {
  /**
   * 通过openid 查询用户
   * @param openid
   * @return
   */
  User findByOpenid(String openid);

  User findFirstById(Long uid);
}
