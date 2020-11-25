package com.mint.store.service.impl;


import com.mint.store.exception.http.NotFoundException;
import com.mint.store.exception.http.ParameterException;
import com.mint.store.model.Activity;
import com.mint.store.model.Coupon;
import com.mint.store.model.UserCoupon;
import com.mint.store.repository.ActivityRepository;
import com.mint.store.repository.CouponRepository;
import com.mint.store.repository.UserCouponRepository;
import com.mint.store.service.CouponService;
import com.mint.store.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

  @Resource
  private ActivityRepository activityRepository;

  @Resource
  private UserCouponRepository userCouponRepository;

  @Override
  public List<Coupon> getByCategory(Long cid) {
    Date now = new Date();
    return couponRepository.selByCategory(cid, now);
  }

  @Override
  public List<Coupon> getWholeStoreCoupon() {
    Date now = new Date();
    return couponRepository.selByWholeStore(true, now);
  }

  @Override
  public void collectOneCoupon(Long uid, Long cid) {
    this.couponRepository.findById(cid)
            .orElseThrow(() -> new NotFoundException(40003));
    Activity activity = this.activityRepository.findByCouponListId(cid)
            .orElseThrow(() -> new NotFoundException(40010));
    Date now = new Date();
    Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
    if (!isIn) {
      throw new ParameterException(40006);
    }
    userCouponRepository.findFirstByUserIdAndCouponId(uid, cid)
            .orElseThrow(() -> new ParameterException(40006));
    UserCoupon userCoupon = UserCoupon.builder()
            .userId(uid)
            .couponId(cid)
            .build();
    this.userCouponRepository.save(userCoupon);
  }

  @Override
  public List<Coupon> getMyAvailableCoupons(Long uid) {
    Date date = new Date();
    return this.couponRepository.findMyAvailable(uid, date);
  }

  @Override
  public List<Coupon> getUsedCoupons(Long uid) {
    Date date = new Date();
    return this.couponRepository.findUsed(uid, date);
  }

  @Override
  public List<Coupon> getExpiredCoupons(Long uid) {
    Date date = new Date();
    return this.couponRepository.findExpired(uid, date);
  }
}