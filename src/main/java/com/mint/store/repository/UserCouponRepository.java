package com.mint.store.repository;

import com.mint.store.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
  Optional<UserCoupon> findFirstByUserIdAndCouponId(Long uid, Long cid);
}
