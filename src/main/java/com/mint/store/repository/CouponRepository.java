package com.mint.store.repository;

import com.mint.store.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
