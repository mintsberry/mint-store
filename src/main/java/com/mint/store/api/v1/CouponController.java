package com.mint.store.api.v1;


import com.mint.store.annotations.ScopeLevel;
import com.mint.store.enums.CouponStatus;
import com.mint.store.model.Coupon;
import com.mint.store.service.CouponService;
import com.mint.store.util.LocalUser;
import com.mint.store.vo.CouponCategoryVo;
import com.mint.store.vo.CouponPureVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Coupon)表控制层
 *
 * @author LingXi
 * @since 2020-11-25 09:40:41
 */
@RestController
@RequestMapping("/coupon")
public class CouponController{
  /**
   * 服务对象
   */
  @Resource
  private CouponService couponService;

  @GetMapping("/by/category/{cid}")
  public List<CouponPureVo> getCouponListBYCategory(@PathVariable Long cid) {
    List<Coupon> coupons = couponService.getByCategory(cid);
    if (coupons.isEmpty()) {
      return Collections.emptyList();
    }
    return coupons.stream().map(CouponPureVo::new).collect(Collectors.toList());
  }

  @GetMapping("/whole_store")
  public List<CouponPureVo> getWholeStoreCouponList() {
    List<Coupon> coupons =this.couponService.getWholeStoreCoupon();
    if (coupons.isEmpty()) {
      return Collections.emptyList();
    }
    return coupons.stream().map(CouponPureVo::new).collect(Collectors.toList());
  }

  @ScopeLevel()
  @PostMapping("/collect/{id}")
  public void collectCoupon(@PathVariable Long id) {
    Long uid = LocalUser.getUser().getId();
    this.couponService.collectOneCoupon(uid, id);
  }

  @ScopeLevel
  @GetMapping("/myself/by/status/{status}")
  public List<CouponPureVo> getMyCouponByStatus(@PathVariable Integer status) {
    Long uid = LocalUser.getUser().getId();
    List<Coupon> couponList = new ArrayList<>();
    switch (CouponStatus.toType(status)) {
      case AVAILABLE:
        couponList = this.couponService.getMyAvailableCoupons(uid);
        break;
      case USED:
        couponList = this.couponService.getUsedCoupons(uid);
        break;
      case EXPIRED:
        couponList = this.couponService.getExpiredCoupons(uid);
        break;
      default:
    }
    return CouponPureVo.getList(couponList);
  }

  @ScopeLevel
  @GetMapping("/myself/available/with_category")
  public List<CouponCategoryVo> getUserCouponWithCategory() {
    Long uid = LocalUser.getUser().getId();
    List<Coupon> coupons = this.couponService.getMyAvailableCoupons(uid);
    if (coupons.isEmpty()) {
      return Collections.emptyList();
    }
    return coupons.stream().map(CouponCategoryVo::new).collect(Collectors.toList());
  }
}