package com.mint.store.vo;

import com.mint.store.model.Coupon;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

  public static List<CouponPureVo> getList(List<Coupon> list) {
    return list.stream().map(CouponPureVo::new).collect(Collectors.toList());
  }
}
