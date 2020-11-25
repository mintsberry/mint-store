package com.mint.store.repository;

import com.mint.store.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MintsBerry
 * @date 2020/11/24
 */
public interface ActivityRepository  extends JpaRepository<Activity, Long> {
  Activity findByName(String name);

  Optional<Activity> findByCouponListId(Long couponId);
}
