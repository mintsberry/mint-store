package com.mint.store.vo;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@Data
public class SpuSimplifyVO {
  private Long id;
  private String title;
  private String subtitle;
  private Integer categoryId;
  private Integer rootCategoryId;
  private Integer online;
  private String price;
  private Integer sketchSpecId;
  private Integer defaultSkuId;
  private String img;
  private String discountPrice;
  private String description;
  private String tags;

}
