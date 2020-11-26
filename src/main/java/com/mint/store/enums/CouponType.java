package com.mint.store.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author MintsBerry
 * @date 2020/11/26
 */
@Getter
public enum  CouponType {
  //满减
  FULL_MINUS(1),
  //满减折扣
  FULL_OFF(2),
  //无门槛
  NO_THRESHOLD_MINUS(3)
  ;

  private int value;

  CouponType(int value) {
    this.value = value;
  }

  public static CouponType getType(int value) {
    return Stream.of(CouponType.values())
            .filter(couponType -> couponType.value == value)
            .findAny().orElse(null);
  }
}
