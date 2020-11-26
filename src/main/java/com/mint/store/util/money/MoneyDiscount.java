package com.mint.store.util.money;

import java.math.BigDecimal;

/**
 * @author MintsBerry
 * @date 2020/11/26
 */
public interface MoneyDiscount {
  BigDecimal discount(BigDecimal original, BigDecimal discount);
}
