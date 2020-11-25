package com.mint.store.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "coupon")
@Where(clause = "delete_time is null")
public class Coupon extends BaseEntity {
  @Id
  private Long id;
  private String title;
  private Date startTime;
  private Date endTime;
  private String description;
  private BigDecimal fullMoney;
  private BigDecimal minus;
  private BigDecimal rate;
  private Integer type;
  @Column(name = "activity_id")
  private long activityId;
  private String remark;
  private boolean wholeStore;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "couponList")
  private List<Category> categoryList;
}
