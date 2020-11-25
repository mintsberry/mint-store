package com.mint.store.api.v1;


import com.mint.store.service.CouponService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Coupon)表控制层
 *
 * @author LingXi
 * @since 2020-11-25 09:40:41
 */
@RestController
@RequestMapping("coupon")
public class CouponController{
  /**
   * 服务对象
   */
  @Resource
  private CouponService couponService;



}