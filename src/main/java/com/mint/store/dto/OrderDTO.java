package com.mint.store.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
@Data
public class OrderDTO {
  @DecimalMin(value = "0.00", message = "不在合理范围")
  @DecimalMax(value = "9999999.99", message = "不在合理范围")
  private BigDecimal totalPrice;

  private BigDecimal finalTotalPrice;

  private Long couponId;

  private List<SkuInfoDTO> skuInfoDTOList;

  private OrderAddressDTO address;
}
