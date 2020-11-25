package com.mint.store.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
@Getter
public enum CouponStatus {
  //可以使用，未过期"
  AVAILABLE(1, "可以使用，未过期"),
  //已使用
  USED(2, "已使用"),
  //未使用，已过期
  EXPIRED(3, "未使用，已过期");

  private Integer value;
  private String desc;

  CouponStatus(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public static CouponStatus toType(int value) {
    return Stream.of(CouponStatus.values())
            .filter(c->c.value == value)
            .findAny()
            .orElse(null);
  }
}
