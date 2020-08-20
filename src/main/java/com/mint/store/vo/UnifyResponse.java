package com.mint.store.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

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
