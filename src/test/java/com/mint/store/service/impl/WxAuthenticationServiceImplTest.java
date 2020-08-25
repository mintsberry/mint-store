package com.mint.store.service.impl;

import com.mint.store.MintStoreApplicationTests;
import com.mint.store.service.WxAuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
class WxAuthenticationServiceImplTest extends MintStoreApplicationTests {
  @Autowired
  private WxAuthenticationService wxAuthenticationService;
  @Test
  void code2Session() {
    String s = wxAuthenticationService.code2Session("033dzRkl2eLUu54Xljol2igeTT3dzRkw");
    System.out.println(s);
  }
}