package com.mint.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LingXi
 */
@Data
@Table(name = "`order`")
@Entity
public class Order extends BaseEntity {
  @Id
  private long id;
  private String orderNo;
  private long userId;
  private double totalPrice;
  private long totalCount;
  private String snapImg;
  private String snapTitle;
  private String snapItems;
  private String snapAddress;
  private String prepayId;
  private double finalTotalPrice;
  private long status;



}
