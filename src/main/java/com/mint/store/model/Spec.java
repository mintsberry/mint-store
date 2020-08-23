package com.mint.store.model;

import lombok.Data;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
@Data
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Spec {
  private Long keyId;
  private String key;
  private Long valueId;
  private String value;

}
