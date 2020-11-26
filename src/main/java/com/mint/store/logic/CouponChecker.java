package com.mint.store.logic;

import com.mint.store.enums.CouponType;
import com.mint.store.exception.ForbiddenException;
import com.mint.store.exception.http.ParameterException;
import com.mint.store.model.Coupon;
import com.mint.store.model.UserCoupon;
import com.mint.store.util.CommonUtil;
import com.mint.store.util.money.MoneyDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public class CouponChecker {

  private Coupon coupon;

  private UserCoupon userCoupon;
  private MoneyDiscount moneyDiscount;

  public CouponChecker(Coupon coupon, UserCoupon userCoupon) {
    this.coupon = coupon;
    this.userCoupon = userCoupon;
  }

  public void isOK() {
    Date now = new Date();
    Boolean isInTime = CommonUtil.isInTimeLine(now, this.coupon.getStartTime(), this.coupon.getEndTime());
    if (!isInTime) {
      throw new ForbiddenException(40007);
    }
  }

  public void finalTotalPriceIsOk(BigDecimal orderFinalTotalPrice,
                                  BigDecimal serverTotalPrice) {
    BigDecimal serverFinalTotalPrice;
    switch (CouponType.getType(coupon.getType())) {
      case FULL_MINUS:
        serverFinalTotalPrice = this.moneyDiscount.discount(serverTotalPrice, orderFinalTotalPrice);
        break;
      case FULL_OFF:
      case NO_THRESHOLD_MINUS:
        serverFinalTotalPrice = serverTotalPrice.subtract(this.coupon.getMinus());
        if(serverFinalTotalPrice.compareTo(new BigDecimal("0")) <= 0) {
          throw new ForbiddenException(50008);
        }
        break;
      default:
        throw new ParameterException(40009);
    }
    int compare = serverFinalTotalPrice.compareTo(orderFinalTotalPrice);
    if (compare != 0) {
      throw new ForbiddenException(50008);
    }
  }

  public void canBeUsed() {}
}
