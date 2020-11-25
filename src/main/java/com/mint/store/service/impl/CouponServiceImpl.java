package com.mint.store.service.impl;


import com.mint.store.repository.CouponRepository;
import com.mint.store.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Coupon)表服务实现类
 *
 * @author LingXi
 * @since 2020-11-25 09:40:39
 */
@Service("couponService")
public class CouponServiceImpl implements CouponService {
  @Autowired
  private CouponRepository couponRepository;
}