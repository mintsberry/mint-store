package com.mint.store.service;

import com.mint.store.model.Coupon;

import java.util.List;

/**
 * (Coupon)表服务接口
 *
 * @author LingXi
 * @since 2020-11-25 09:40:36
 */
public interface CouponService {

  List<Coupon> getByCategory(Long cid);

  List<Coupon> getWholeStoreCoupon();

  void collectOneCoupon(Long uid, Long cid);

  List<Coupon> getMyAvailableCoupons(Long uid);

  List<Coupon> getUsedCoupons(Long uid);

  List<Coupon> getExpiredCoupons(Long uid);
}