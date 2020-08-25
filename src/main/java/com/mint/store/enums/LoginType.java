package com.mint.store.enums;

import lombok.Getter;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Getter
public enum LoginType {
  //微信登录
  WX,
  //网页登录
  WEB,
  //邮箱登录
  EMAIL,
  ;

  LoginType() {
  }
}
