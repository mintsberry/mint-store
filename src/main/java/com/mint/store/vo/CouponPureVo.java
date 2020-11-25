package com.mint.store.vo;

import com.mint.store.model.Coupon;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author MintsBerry
 * @date 2020/11/24
 */
@Data
public class CouponPureVo {
  private Long id;
  private String title;
  private Date startTime;
  private Date endTime;
  private String description;
  private BigDecimal fullMoney;
  private BigDecimal minus;
  private BigDecimal rate;
  private Integer type;
  private long activityId;
  private String remark;
  private long wholeStore;

  public CouponPureVo(Coupon coupon) {
    BeanUtils.copyProperties(coupon, this);
  }
}
