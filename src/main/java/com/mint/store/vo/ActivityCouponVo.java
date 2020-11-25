package com.mint.store.vo;

import com.mint.store.model.Activity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MintsBerry
 * @date 2020/11/24
 */
@Data
public class ActivityCouponVo extends ActivityPureVo{
  private List<CouponPureVo> coupons;

  public ActivityCouponVo(Activity activity) {
    super(activity);
    this.coupons = activity.getCouponList()
            .stream().map(CouponPureVo::new)
             .collect(Collectors.toList());
  }
}
