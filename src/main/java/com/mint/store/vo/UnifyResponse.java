package com.mint.store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnifyResponse {
  private int code;
  private String message;
  private String url;
}
