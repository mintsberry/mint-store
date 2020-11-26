package com.mint.store.util.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author MintsBerry
 * @date 2020/11/26
 */
public class HalfUpRound implements MoneyDiscount {
  @Override
  public BigDecimal discount(BigDecimal original, BigDecimal discount) {
    BigDecimal actualMoney = original.multiply(discount);
    BigDecimal finalMoney = actualMoney.setScale(2, RoundingMode.HALF_EVEN);
    return finalMoney;
  }
}
