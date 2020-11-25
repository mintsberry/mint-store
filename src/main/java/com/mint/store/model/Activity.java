package com.mint.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author LingXi
 */

@Getter
@Setter
@Entity
@Table(name = "activity")
public class Activity extends BaseEntity{
  @Id
  private long id;
  private String title;
  private String description;
  private Date startTime;
  private Date endTime;
  private String remark;
  private long online;
  private String entranceImg;
  private String internalTopImg;
  private String name;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name="activity_id")
  private List<Coupon> couponList;
}
