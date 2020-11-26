package com.mint.store.dto;

import lombok.Data;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
@Data
public class OrderAddressDTO {
  private String userName;
  private String province;
  private String city;
  private String county;
  private String mobile;
  private String nationalCode;
  private String postalCode;
  private String detail;
}
