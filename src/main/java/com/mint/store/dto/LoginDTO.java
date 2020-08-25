package com.mint.store.dto;

import com.mint.store.enums.LoginType;
import com.mint.store.validators.TokenPassword;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Data
public class LoginDTO {
  @NotBlank(message = "{account.message}")
  private String account;
  @TokenPassword(message = "{token.message}")
  private String password;

  private LoginType type;
}
