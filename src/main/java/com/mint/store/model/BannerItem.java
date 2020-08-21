package com.mint.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
@Entity
public class BannerItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String img;
  private String keyword;
  private Short type;
  private String name;
  private Long bannerId;
}
