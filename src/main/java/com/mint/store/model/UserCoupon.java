package com.mint.store.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "user_coupon")
@Builder
@NoArgsConstructor
public class UserCoupon extends BaseEntity{
  @Id
  private long id;
  private long userId;
  private long couponId;
  private long status;
  private long orderId;
}
